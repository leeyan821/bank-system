package bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.service.Service;

public class LoginController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if(id.isEmpty() || pwd.isEmpty()) {
			request.setAttribute("error", "Enter ID/PASSWORD");
			HttpUtil.forward(request, response, "/login.jsp");
			return;
		}
		
		Service s = Service.getInstance();
		boolean result = s.login(id,pwd);
		String path = null;
		if(result)
		{
			HttpSession session = request.getSession();
			session.setAttribute("id",id);
			path = "/menu.jsp";
		}
		else
		{
			path = "/index.jsp";
		}
		HttpUtil.forward(request, response, path);
	}

}
