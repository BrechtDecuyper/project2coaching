package ui.controller.handler;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ui.controller.RequestHandler;

public class SendMailHandler extends RequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String receiver = request.getParameter("receiver");
		try {
			this.getService().sendStandardMail(receiver);
		} catch (MessagingException e) {
			throw new ServletException(e.getMessage(), e);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
