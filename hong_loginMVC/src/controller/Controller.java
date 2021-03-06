/*    */ package controller;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.ArrayList;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.annotation.WebServlet;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import model.UserDBBean;
/*    */ import model.UserDataBean;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @WebServlet({"/controller"})
/*    */ public class Controller
/*    */   extends HttpServlet
/*    */   implements ControllInterface
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */ 
/*    */   
/*    */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 36 */     System.out.println("doGet");
/*    */     try {
/* 38 */       requestPro(request, response);
/* 39 */     } catch (Exception e) {
/* 40 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/* 46 */     System.out.println("doPost");
/*    */     try {
/* 48 */       requestPro(request, response);
/* 49 */     } catch (Exception e) {
/* 50 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 넘어오는 패러미터 값을 인코딩
/* 58 */     request.setCharacterEncoding("UTF-8");
/*    */     // index.jsp에서 패러미터 넘겨받음
/* 60 */     String firstname = request.getParameter("firstname");
/* 61 */     String lastname = request.getParameter("lastname");
/* 62 */     String email = request.getParameter("email");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     // UserDBBean 객체 생성
/* 72 */     UserDBBean user = new UserDBBean();

			// 가입 패러미터를 넘기며 insertUser 메소드 돌림
/* 73 */     user.insertUser(firstname, lastname, email);

/*    */	// 전체회원 출력용 배열 생성해 listDB에 저장
/* 75 */     ArrayList<UserDataBean> listDB = user.list();
/* 76 */     request.setAttribute("user", listDB);
/*    */     
/* 78 */     RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
/* 79 */     dispatcher.forward(request, response);
/*    */     
/* 81 */     Controller controller = new Controller();
/* 82 */     controller.destroy();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void destroy() {
/* 88 */     System.out.println("destory");
/* 89 */     super.destroy();
/*    */   }
/*    */ }


/* Location:              C:\Users\USER\Desktop\홍경일\loginMVC\WEB-INF\classes\!\controller\Controller.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */