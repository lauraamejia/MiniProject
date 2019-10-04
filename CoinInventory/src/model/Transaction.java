package model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="tranID")
	private int tranID;
	
	@Column(name="price")
	private String price;
	
	@Column(name="dealer")
	private String dealer;
	
	@Column(name="transDate")
	private LocalDate transDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTranID() {
		return tranID;
	}

	public void setTranID(int tranID) {
		this.tranID = tranID;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDealer() {
		return dealer;
	}

	public void setDealer(String dealer) {
		this.dealer = dealer;
	}

	public LocalDate getTransDate() {
		return transDate;
	}

	public void setTransDate(LocalDate transDate) {
		this.transDate = transDate;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", tranID=" + tranID + ", price=" + price + ", dealer=" + dealer
				+ ", transDate=" + transDate + "]";
	}

	public Transaction(int id, int tranID, String price, String dealer, LocalDate transDate) {
		super();
		this.id = id;
		this.tranID = tranID;
		this.price = price;
		this.dealer = dealer;
		this.transDate = transDate;
	}

	public Transaction(int tranID, String price, String dealer, LocalDate transDate) {
		super();
		this.tranID = tranID;
		this.price = price;
		this.dealer = dealer;
		this.transDate = transDate;
	}
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

}
