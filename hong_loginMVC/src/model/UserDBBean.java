/*     */ package model;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.ArrayList;
/*     */ import javax.naming.Context;
/*     */ import javax.naming.InitialContext;
/*     */ import javax.sql.DataSource;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UserDBBean
/*     */ {
/*     */   private Connection getConn() throws Exception {
/*  17 */     Context initCtx = new InitialContext();
/*     */     
/*  19 */     Context envCtx = (Context)initCtx.lookup("java:comp/env");
/*  20 */     DataSource data = (DataSource)envCtx.lookup("jdbc/oracle11g");
/*     */     
/*  22 */     return data.getConnection();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void closeDB() {
/*  29 */     Connection conn = null;
/*  30 */     PreparedStatement pstmt = null;
/*  31 */     ResultSet rs = null;
/*     */     
/*     */     try {
/*  34 */       if (rs != null) rs.close(); 
/*  35 */       if (pstmt != null) pstmt.close(); 
/*  36 */       if (conn != null) conn.close(); 
/*  37 */       System.out.println("DB 접속 해제");
/*  38 */     } catch (Exception e) {
/*  39 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertUser() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void insertUser(String firstname, String lastname, String email) {
/*  53 */     Connection conn = null;
/*  54 */     PreparedStatement pstmt = null;
/*  55 */     String sql = null;
/*     */     
/*     */     try {
/*  58 */       conn = getConn();
/*  59 */       System.out.println("db접속 성공");
/*  60 */       sql = "insert into members(firstname,lastname,email) values(?,?,?)";
/*  61 */       pstmt = conn.prepareStatement(sql);
/*  62 */       pstmt.setString(1, firstname);
/*  63 */       pstmt.setString(2, lastname);
/*  64 */       pstmt.setString(3, email);
/*  65 */       int i = pstmt.executeUpdate();
/*     */     }
/*  67 */     catch (Exception e) {
/*  68 */       e.printStackTrace();
/*     */     } finally {
/*  70 */       closeDB();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<UserDataBean> list() {
/*  80 */     String firstname = "";
/*  81 */     String lastname = "";
/*  82 */     String email = "";
/*     */     
/*  84 */     Connection conn = null;
/*  85 */     PreparedStatement pstmt = null;
/*  86 */     ResultSet rs = null;
/*     */     
/*  88 */     ArrayList<UserDataBean> list = new ArrayList<UserDataBean>();
/*  89 */     String sql = "select * from members";
/*     */     
/*     */     try {
/*  92 */       conn = getConn();
/*  93 */       System.out.println("db접속 성공");
/*  94 */       pstmt = conn.prepareStatement(sql);
/*  95 */       rs = pstmt.executeQuery();
/*     */       
/*  97 */       while (rs.next()) {
/*  98 */         UserDataBean user = new UserDataBean(firstname, lastname, email);
/*     */         
/* 100 */         user.setFirstname(rs.getString("firstname"));
/* 101 */         user.setLastname(rs.getString("lastname"));
/* 102 */         user.setEmail(rs.getString("email"));
/*     */         
/* 104 */         list.add(user);
/*     */       }
/*     */     
/* 107 */     } catch (Exception e) {
/* 108 */       e.printStackTrace();
/*     */     } finally {
/* 110 */       closeDB();
/*     */     } 
/*     */     
/* 113 */     return list;
/*     */   }
/*     */ }


/* Location:              C:\Users\USER\Desktop\홍경일\loginMVC\WEB-INF\classes\!\model\UserDBBean.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */