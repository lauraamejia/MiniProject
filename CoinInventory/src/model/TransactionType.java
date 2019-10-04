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
@Table(name="transactiontype")
public class TransactionType {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="tranType")
	private String tranType;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="transaction_tranID")
	private Transaction transaction;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "TransactionType [id=" + id + ", tranType=" + tranType + ", transaction=" + transaction + "]";
	}

	public TransactionType(int id, String tranType, Transaction transaction) {
		super();
		this.id = id;
		this.tranType = tranType;
		this.transaction = transaction;
	}

	public TransactionType(String tranType, Transaction transaction) {
		super();
		this.tranType = tranType;
		this.transaction = transaction;
	}
	public TransactionType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
