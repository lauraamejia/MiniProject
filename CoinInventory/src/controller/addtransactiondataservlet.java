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
import model.Transaction;
import model.Transactiontype;

/**
 * Servlet implementation class addtransactiondataservlet
 */
@WebServlet("/addtransactiondataservlet")
public class addtransactiondataservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtransactiondataservlet() {
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
		
		CoinHelper instance = new CoinHelper();
		TransactionHelper transactioninstance = new TransactionHelper();
		Transactiontype tran = new Transactiontype();
		
		String id = request.getParameter("id");
		String dealor = request.getParameter("dealor");
		String price = request.getParameter("price");
		String date = request.getParameter("date");
		String trantype = request.getParameter("tranlist");
		
		Coin item = instance.searchForCoinById(Integer.parseInt(id));
		
		Transaction trantostore = new Transaction();
		
		Date dateoncoin;
		
		try {
			 dateoncoin=new SimpleDateFormat("dd/MM/yyyy").parse(date);
			 trantostore.setTranDate(dateoncoin);
			} catch (ParseException e) {
			
				e.printStackTrace();
			}  
		
		tran.setId(Integer.parseInt(trantype));
			
		trantostore.setCoin(item);
		trantostore.setDealer(dealor);
		trantostore.setPrice(price);
		trantostore.setTransactiontype(tran);
	
		transactioninstance.addTransaction(trantostore);
		
		getServletContext().getRequestDispatcher("/addtransaction.jsp").forward(request, response);
	}

}
