package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coin;

/**
 * Servlet implementation class deletecoindataservlet
 */
@WebServlet("/deletecoindataservlet")
public class deletecoindataservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletecoindataservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		//get id to delete
		String id = request.getParameter("id");
		
		//create instance of helper
		CoinHelper instance = new CoinHelper();
		
		//find item to delete
		Coin itemtodelete = instance.searchForCoinById(Integer.parseInt(id));
		
		//delete coin in database
		instance.addCoin(itemtodelete);
		
		//redirect back to page
		getServletContext().getRequestDispatcher("/deletecoin.jsp").forward(request, response);
		
	}

}
