package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserDBBean;
import model.UserDataBean;

@WebServlet({"/controller"})
public class Controller
  extends HttpServlet
  implements ControlInterface
{
  private static final long serialVersionUID = 1L;
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    try {
      requestPro(request, response);
    }
    catch (Throwable e) {
      e.printStackTrace();
    }
  }
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    try
    {
      requestPro(request, response);
    }
    catch (Throwable e)
    {
      e.printStackTrace();
    }
  }
  
  public void requestPro(HttpServletRequest request, HttpServletResponse response)
    throws Throwable
  {
	// 넘어오는 패러미터 값을 인코딩
    request.setCharacterEncoding("UTF-8");
    
    // index.jsp에서 패러미터 넘겨받음
    String firstname = request.getParameter("firstname");
    String lastname = request.getParameter("lastname");
    String email = request.getParameter("email");
    
//    // UserDBBean 객체 만들어서 짧은 이름 붙여 써도 됨. 꼭 만들 필요 없음
//    UserDBBean user = new UserDBBean();
    
    // DB 실행
    UserDBBean.DBConnect();

    // 가입 회원 생성하며 패러미터 넘기기
    UserDataBean user = new UserDataBean(firstname, lastname, email);
    
    // DB에 가입회원 넣기
    UserDBBean.insertUser(user);
    
    // 전체회원 출력용 배열 생성해 users에 저장
    ArrayList<UserDataBean> users = UserDBBean.searchUser();
    
    // DB 해제
    UserDBBean.DBClose();
    
    // 전체회원 배열을 users라는 이름으로 request에 저장
    request.setAttribute("users", users);
    
    // request에 저장된 정보를 result에 전송
    RequestDispatcher dp = request.getRequestDispatcher("result.jsp");
    dp.forward(request, response);
  }
}
