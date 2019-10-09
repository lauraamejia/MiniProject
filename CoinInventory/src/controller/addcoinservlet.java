package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Coin;

/**
 * Servlet implementation class addcoinservlet
 */
@WebServlet("/addcoinservlet")
public class addcoinservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addcoinservlet() {
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
		
		String type = request.getParameter("type");
		String location = request.getParameter("location");
		String condition = request.getParameter("condition");
		String date = request.getParameter("date");
		
		//create new coin instance to save parameters to 
		Coin itemtostore = new Coin();
		
		itemtostore.setType(type);
		itemtostore.setContidion(condition);
		itemtostore.setStorageLocation(location);
		
		Date datetoadd;
		
		try {
		 datetoadd=new SimpleDateFormat("dd/MM/yyyy").parse(date);
			itemtostore.setDateOnCoin(datetoadd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		//create instance of coin helper
		CoinHelper instance = new CoinHelper();
		
		//add to database
		instance.addCoin(itemtostore);
		
		//redirect back to page
		getServletContext().getRequestDispatcher("/addcoin.jsp").forward(request, response);
		
	}

}

