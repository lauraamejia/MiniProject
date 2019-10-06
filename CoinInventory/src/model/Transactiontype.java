package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the transactiontype database table.
 * 
 */
@Entity
@NamedQuery(name="Transactiontype.findAll", query="SELECT t FROM Transactiontype t")
public class Transactiontype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String tranType;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="transactiontype")
	private List<Transaction> transactions;

	public Transactiontype() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTranType() {
		return this.tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setTransactiontype(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setTransactiontype(null);

		return transaction;
	}

	public Transactiontype(int id, String tranType, List<Transaction> transactions) {
		super();
		this.id = id;
		this.tranType = tranType;
		this.transactions = transactions;
	}

	public Transactiontype(String tranType, List<Transaction> transactions) {
		super();
		this.tranType = tranType;
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Transactiontype [id=" + id + ", tranType=" + tranType + ", transactions=" + transactions + "]";
	}
	

}