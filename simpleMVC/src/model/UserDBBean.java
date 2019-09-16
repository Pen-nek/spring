package model;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDBBean
{
  static final String driver = "com.mysql.cj.jdbc.Driver";
  static final String url = "jdbc:mysql://localhost:3306/simplemvc?serverTimezone=UTC";
  static final String userid = "root";
  static final String userpw = "1234";
  static Connection conn = null;
  static PreparedStatement pstmt = null;
  static ResultSet rs = null;
  
  
  
  public static void DBConnect()
  {
    System.out.println("DB 접속 : ");
    try
    {
      Class.forName("com.mysql.cj.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplemvc?serverTimezone=UTC", "root", "1234");
      if (conn != null) {
        System.out.println("드라이버 연결 성공");
      } else {
        System.out.println("드라이버 연결 실패");
      }
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("ClassNotFoundException");
      e.printStackTrace();
    }
    catch (SQLException e)
    {
      System.out.println("SQLException");
      e.printStackTrace();
    }
  }
  
  
  
  public static void DBClose()
  {
    if (conn == null) {
      try
      {
        pstmt.close();
        rs.close();
        conn.close();
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  
  
  public static void insertUser(UserDataBean user)
  {
    String sql = "insert into memb values (?, ?, ?)";
    String firstname = user.getFirstname();
    String lastname = user.getLastname();
    String email = user.getEmail();
    try
    {
      pstmt = conn.prepareStatement(sql);
      
      pstmt.setString(1, firstname);
      pstmt.setString(2, lastname);
      pstmt.setString(3, email);
      
      int num = pstmt.executeUpdate();
      if (num == 0) {
        System.out.println("데이터 추가 실패");
      } else {
        System.out.println("데이터 추가 성공");
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
  
  
  
  public static ArrayList<UserDataBean> searchUser()
  {
    ArrayList<UserDataBean> users = new ArrayList();
    
    String sql = "select * from memb";
    try
    {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      
      while (rs.next())
      {
        String firstname = rs.getString("firstname");
        String lastname = rs.getString("lastname");
        String email = rs.getString("email");
        UserDataBean user = new UserDataBean(firstname, lastname, email);
        
        	// 이렇게도 된다
//        UserDataBean user = new UserDataBean(firstname, lastname, email);
//        user.setFirstname(rs.getString("firstname"));
//        user.setLastname(rs.getString("lastname"));
//        user.setEmail(rs.getString("email"));
        
        users.add(user);
      }
      
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return users;
  }
}
