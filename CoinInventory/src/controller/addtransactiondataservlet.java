package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
		//doGet(request, response);
		
		//create instances of helpers
		CoinHelper instance = new CoinHelper();
		TransactionHelper transactioninstance = new TransactionHelper();
		TransactionTypeHelper traninstance = new TransactionTypeHelper(); 
		
		//get parameters
		String id = request.getParameter("id");
		String dealor = request.getParameter("dealor");
		String price = request.getParameter("price");
		String date = request.getParameter("trandate");
		String trantype = request.getParameter("tranlist");
		
		//search for selected coin
		Coin item = instance.searchForCoinById(Integer.parseInt(id));
		
		Transaction trantostore = new Transaction();
		
		//Note: The program will keep putting in the same number 0 in the primary key field, tableID, of transaction table for
		//each transaction, so I developed code to find the highest number in that tableID field and add one to it before the 
		//program saves the record.  This will prevent a database error It's an ugly solution, but it works :( 
				
		//get list of all transactions and find highest number in tableID field, which is primary key of table
		List<Transaction> list = transactioninstance.showAllTransactions();
		
		int highest = 0;
		
		for(int i = 0; i < list.size(); i++) {
			
			if(list.get(i).getTableID() >= highest) {
				highest = list.get(i).getTableID();
				
			}
			
		}
		
		//add one to highest number to get new number to put into primary key
		highest = highest +1;
					
		Date dateoncoin;
		
		try {
			 dateoncoin=new SimpleDateFormat("dd/MM/yyyy").parse(date);
			 trantostore.setTranDate(dateoncoin);
			} catch (ParseException e) {
			
				e.printStackTrace();
			}  
		
		//look up transaction type 
		Transactiontype tran = traninstance.searchForTransactionById(Integer.parseInt(trantype));
		
		//set transaction parameters
		trantostore.setTransactiontype(tran);
		trantostore.setCoin(item);
		trantostore.setDealer(dealor);
		trantostore.setPrice(price);
		trantostore.setTableID(highest);
		
		//put in database
		transactioninstance.addTransaction(trantostore);
		
		//return to add screen
		getServletContext().getRequestDispatcher("/addtransaction.jsp").forward(request, response);
	}

}
