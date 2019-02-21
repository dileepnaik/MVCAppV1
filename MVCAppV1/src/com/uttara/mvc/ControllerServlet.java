package com.uttara.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		
		RequestDispatcher rd = null;
		if(uri.contains("/checkforVote"))
		{
			if(Constants.isPollAvailable()) {
				rd = request.getRequestDispatcher("audiencequest.jsp");
			}else {
				rd = request.getRequestDispatcher("votefail.jsp");
			}
	
			rd.forward(request, response);
		}
		if(uri.contains("/completevote"))
		{
			
			if(Constants.isPollAvailable()) {
				rd = request.getRequestDispatcher("voteSuccess.jsp");
				//System.out.println(request.getParameter("option"));
				String answer=request.getParameter("option");
				
				if(answer.equals("A")) {
					System.out.println("A");
					Constants.setCount_A(Constants.getCount_A()+1);
				}else if(answer.equals("B")) {
					System.out.println("B");
					Constants.setCount_B(Constants.getCount_B()+1);
				}else if(answer.equals("C")) {
					System.out.println("C");
					Constants.setCount_C(Constants.getCount_C()+1);
				}else if(answer.equals("D")){
					System.out.println("D");
					Constants.setCount_D(Constants.getCount_D()+1);
				}
			
			}else {
				rd = request.getRequestDispatcher("votefail.jsp");
			}
			
			rd.forward(request, response);
		}
		
		if(uri.contains("/resetvote")) {
			Constants.clearValue();
		}
		
		
		if(uri.contains("/setPollTrue")) {
			Constants.setPollAvailable(true);
			System.out.println("coming ghewre..rd.");
		}
		
		if(uri.contains("/setPollFalse")) {
			Constants.setPollAvailable(false);
		}
		
		
		
		if(uri.contains("/getcountA")) {
			request.setAttribute("Value",Constants.count_A);
			rd = request.getRequestDispatcher("getVoteValue.jsp");
			rd.forward(request, response);
		}
		if(uri.contains("/getcountB")) {
			request.setAttribute("Value",Constants.count_B);
			rd = request.getRequestDispatcher("getVoteValue.jsp");
			rd.forward(request, response);
		}
		if(uri.contains("/getcountC")) {
			request.setAttribute("Value",Constants.count_C);
			rd = request.getRequestDispatcher("getVoteValue.jsp");
			rd.forward(request, response);
		}
		if(uri.contains("/getcountD")) {
			request.setAttribute("Value",Constants.count_D);
			rd = request.getRequestDispatcher("getVoteValue.jsp");
			rd.forward(request, response);
		}

	}
   
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("inside doGet() of CS");
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("inside doPost() of CS");
		process(request,response);
	}

}
