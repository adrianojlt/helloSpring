package pt.adrz.hellospring.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pt.adrz.hellospring.utils.Utils;

public class ArenaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ace = request.getParameter("ace");
		String sop = request.getParameter("sop");

		PrintWriter out = response.getWriter();
		
		if (ace != null) {
    		out.println(Utils.getLink(ace));
    		return;
    	}

    	if (sop != null) {
    		out.println(Utils.getLink(sop));
    		return;
    	}

		String html = Utils.table();
		request.setAttribute("html", html);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/jsp/arenavision.jsp");
		dispatcher.forward(request, response);
	}
}
