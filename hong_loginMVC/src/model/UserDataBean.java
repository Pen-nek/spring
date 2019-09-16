/*    */ package model;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserDataBean
/*    */ {
/*    */   private String firstname;
/*    */   private String lastname;
/*    */   private String email;
/*    */   
/*    */   public UserDataBean(String firstname, String lastname, String email) {
/* 13 */     this.firstname = firstname;
/* 14 */     this.lastname = lastname;
/* 15 */     this.email = email;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public UserDataBean() {}
/*    */ 
/*    */ 
/*    */   
/* 24 */   public String getFirstname() { return this.firstname; }
/*    */ 
/*    */   
/* 27 */   public void setFirstname(String firstname) { this.firstname = firstname; }
/*    */ 
/*    */   
/* 30 */   public String getLastname() { return this.lastname; }
/*    */ 
/*    */   
/* 33 */   public void setLastname(String lastname) { this.lastname = lastname; }
/*    */ 
/*    */   
/* 36 */   public String getEmail() { return this.email; }
/*    */ 
/*    */   
/* 39 */   public void setEmail(String email) { this.email = email; }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 46 */   public String toString() { return "UserDataBean [firstname=" + this.firstname + ", lastname=" + this.lastname + ", email=" + this.email + "]"; }
/*    */ }


/* Location:              C:\Users\USER\Desktop\홍경일\loginMVC\WEB-INF\classes\!\model\UserDataBean.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */