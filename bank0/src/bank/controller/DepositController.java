package bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.service.Service;

public class DepositController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String m = request.getParameter("money");	
		if(m.isEmpty()) {
			request.setAttribute("error", "Enter MONEY");
			HttpUtil.forward(request, response, "/deposit.jsp");
			return;
		}
		int money = Integer.parseInt(request.getParameter("money"));

		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		Service s = Service.getInstance();
		int totalMoney = s.deposit(id,money);
		
		request.setAttribute("money", money);
		request.setAttribute("tMoney", totalMoney);
		HttpUtil.forward(request, response, "/result/depositResult.jsp");
	}

}
