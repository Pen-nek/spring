package model;

public class UserDataBean
{
  private String firstname;
  private String lastname;
  private String email;
  
  public String getFirstname()
  {
    return this.firstname;
  }
  
  public void setFirstname(String firstname)
  {
    this.firstname = firstname;
  }
  
  public String getLastname()
  {
    return this.lastname;
  }
  
  public void setLastname(String lastname)
  {
    this.lastname = lastname;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public void setEmail(String email)
  {
    this.email = email;
  }
  
  public UserDataBean(String firstname, String lastname, String email)
  {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
  }
  
  public String toString()
  {
    return "UserDataBean [firstname=" + this.firstname + ", lastname=" + this.lastname + ", email=" + this.email + "]";
  }
}
