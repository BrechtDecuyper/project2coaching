package ui.controller.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.service.Service;

public abstract class RequestHandler {

	protected Service service;

	public RequestHandler() {};

	public final void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.handleRequest(request, response);
	}

	public abstract void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;


	/*********************
	 * Getters & Setters *
	 *********************/

	public void setService(Service service) {
		this.service = service;
	}

	protected Service getService() {
		return service;
	}
}
