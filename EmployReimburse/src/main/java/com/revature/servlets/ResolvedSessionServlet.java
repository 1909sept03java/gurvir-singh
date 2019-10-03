package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.ResolvedRequests;
import com.revature.service.ResolvedService;

public class ResolvedSessionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			ResolvedService rs = new ResolvedService();
			List<ResolvedRequests> allResolved = new ArrayList<ResolvedRequests>();
			for(ResolvedRequests rr : rs.getAllResolved()) {
				allResolved.add(rr);
			}
			
			resp.getWriter().write((new ObjectMapper()).writeValueAsString(allResolved));
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write("{\"session\":null}");
			
		}
		
	}

}