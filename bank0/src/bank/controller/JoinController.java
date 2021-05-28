package bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.service.Service;
import bank.vo.Account;

public class JoinController implements Controller{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if(id.isEmpty() || pwd.isEmpty()) {
			request.setAttribute("error", "Enter ID/PASSWORD");
			HttpUtil.forward(request, response, "/join.jsp");
			return;
		}
		
		Account account = new Account(id,pwd);
		
		Service s = Service.getInstance();
		s.join(account);
		
		HttpUtil.forward(request, response, "/index.jsp");
	}
}