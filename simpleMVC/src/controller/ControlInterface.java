package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract interface ControlInterface
{
  public abstract void requestPro(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
    throws Throwable;
}
