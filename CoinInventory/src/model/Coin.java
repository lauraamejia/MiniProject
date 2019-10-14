package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the coin database table.
 * 
 */
@Entity
@Table(name="coin")
public class Coin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String contidion;


	@Temporal(TemporalType.DATE)
	private Date dateOnCoin;

	private String storageLocation;

	private String type;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="coin")
	private List<Transaction> transactions;

	public Coin() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContidion() {
		return this.contidion;
	}

	public void setContidion(String contidion) {
		this.contidion = contidion;
	}

	public Date getDateOnCoin() {
		return this.dateOnCoin;
	}

	public void setDateOnCoin(Date dateOnCoin) {
		this.dateOnCoin = dateOnCoin;
	}

	public String getStorageLocation() {
		return this.storageLocation;
	}

	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Coin(int id, String contidion, Date dateOnCoin, String storageLocation, String type,
			List<Transaction> transactions) {
		super();
		this.id = id;
		this.contidion = contidion;
		this.dateOnCoin = dateOnCoin;
		this.storageLocation = storageLocation;
		this.type = type;
		this.transactions = transactions;
	}

	public Coin(String contidion, Date dateOnCoin, String storageLocation, String type,
			List<Transaction> transactions) {
		super();
		this.contidion = contidion;
		this.dateOnCoin = dateOnCoin;
		this.storageLocation = storageLocation;
		this.type = type;
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Coin [id=" + id + ", contidion=" + contidion + ", dateOnCoin=" + dateOnCoin + ", storageLocation="
				+ storageLocation + ", type=" + type + ", transactions=" + transactions + "]";
	}
	

}