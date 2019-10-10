package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coin;

/**
 * Servlet implementation class selecttoeditservlet
 */
@WebServlet("/selecttoeditservlet")
public class selecttoeditservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selecttoeditservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String itemtoedit = request.getParameter("id");
		
		CoinHelper instance = new CoinHelper();
		
		Coin coinitemtoedit = instance.searchForCoinById(Integer.parseInt(itemtoedit));
		
		request.setAttribute("AllItems", coinitemtoedit);
		
		//direct to page
		getServletContext().getRequestDispatcher("/editcoinitems.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
