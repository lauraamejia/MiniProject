package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coin;

/**
 * Servlet implementation class savededititemservlet
 */
@WebServlet("/savededititemservlet")
public class savededititemservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public savededititemservlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		//get instance of helper
		CoinHelper instance = new CoinHelper();
		
		//get page data
		String locid = request.getParameter("locid");
		String type = request.getParameter("type");
		String location = request.getParameter("storagelocation");
		String condition = request.getParameter("condition");
		String date = request.getParameter("dateOnCoin");
		
		//find item to update
		Coin itemtoupdate = instance.searchForCoinById(Integer.parseInt(locid));
		
		//update items in coin object
		Date dateoncoin;
		
		try {
		 dateoncoin=new SimpleDateFormat("dd/MM/yyyy").parse(date);
		 itemtoupdate.setDateOnCoin(dateoncoin);
		} catch (ParseException e) {
		
			e.printStackTrace();
		}  
		
		itemtoupdate.setType(type);
		itemtoupdate.setStorageLocation(location);
		itemtoupdate.setContidion(condition);
		
		//save object to database
		instance.updateCoin(itemtoupdate);
		
		//go back to edit page
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
		
	}

}
