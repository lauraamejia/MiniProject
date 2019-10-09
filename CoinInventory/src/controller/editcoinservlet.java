package controller;

import java.io.IOException;
import java.util.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Coin;

/**
 * Servlet implementation class editcoinservlet
 */
@WebServlet("/editcoinservlet")
public class editcoinservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editcoinservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//create instance of helper
		CoinHelper instance = new CoinHelper();
		
		//send list of coins to page
		request.setAttribute("allItems", instance.showAllCoins());
		
		//take care of empty set condition
		if(instance.showAllCoins().isEmpty()){
		request.setAttribute("allItems", " ");
		}
		
		//direct to page
		getServletContext().getRequestDispatcher("/editcoin.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
