package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int tableID;

	private String dealer;

	private String price;

	@Temporal(TemporalType.DATE)
	private Date tranDate;

	//bi-directional many-to-one association to Coin
	@ManyToOne
	@JoinColumn(name="id")
	private Coin coin;

	//bi-directional many-to-one association to Transactiontype
	@ManyToOne
	@JoinColumn(name="tranTypeID")
	private Transactiontype transactiontype;

	public Transaction() {
	}

	public int getTableID() {
		return this.tableID;
	}

	public void setTableID(int tableID) {
		this.tableID = tableID;
	}

	public String getDealer() {
		return this.dealer;
	}

	public void setDealer(String dealer) {
		this.dealer = dealer;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getTranDate() {
		return this.tranDate;
	}

	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	public Coin getCoin() {
		return this.coin;
	}

	public void setCoin(Coin coin) {
		this.coin = coin;
	}

	public Transactiontype getTransactiontype() {
		return this.transactiontype;
	}

	public void setTransactiontype(Transactiontype transactiontype) {
		this.transactiontype = transactiontype;
	}

	public Transaction(String dealer, String price, Date tranDate, Coin coin, Transactiontype transactiontype) {
		super();
		this.dealer = dealer;
		this.price = price;
		this.tranDate = tranDate;
		this.coin = coin;
		this.transactiontype = transactiontype;
	}

	public Transaction(int tableID, String dealer, String price, Date tranDate, Coin coin,
			Transactiontype transactiontype) {
		super();
		this.tableID = tableID;
		this.dealer = dealer;
		this.price = price;
		this.tranDate = tranDate;
		this.coin = coin;
		this.transactiontype = transactiontype;
	}

	@Override
	public String toString() {
		return "Transaction [tableID=" + tableID + ", dealer=" + dealer + ", price=" + price + ", tranDate=" + tranDate
				+ ", coin=" + coin + ", transactiontype=" + transactiontype + "]";
	}

}