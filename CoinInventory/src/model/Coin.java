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
@Table(name="coin")
public class Coin {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="storageLocation")
	private String storageLocation;
	
	@Column(name="condition")
	private String condition;
	
	@Column(name="dateOnCoin")
	private LocalDate dateOnCoin;
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="transaction_id")
	private Transaction transaction;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStorageLocation() {
		return storageLocation;
	}

	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}
	
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public LocalDate getDateOnCoin() {
		return dateOnCoin;
	}

	public void setDateOnCoin(LocalDate dateOnCoin) {
		this.dateOnCoin = dateOnCoin;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transactionID) {
		this.transaction = transactionID;
	}
	
	public void setNullTransaction() {
		this.transaction = null;
	}
	
	//constructor without id or owner
		@Override
	public String toString() {
		return "Coin [id=" + id + ", type=" + type + ", storageLocation=" + storageLocation + ", condition=" + condition
				+ ", dateOnCoin=" + dateOnCoin + ", transaction=" + transaction + "]";
	}

	public Coin(String type, String storageLocation, String condition, LocalDate dateOnCoin) {
			super();
			this.type = type;
			this.storageLocation = storageLocation;
			this.condition = condition;
			this.dateOnCoin = dateOnCoin;
		}
	
	//constructor without id
	public Coin(String type, String storageLocation, String condition, LocalDate dateOnCoin, Transaction transaction) {
		super();
		this.type = type;
		this.storageLocation = storageLocation;
		this.condition = condition;
		this.dateOnCoin = dateOnCoin;
		this.transaction = transaction;
	}


	//all fields constructor
	public Coin(int id, String type, String storageLocation, String condition, LocalDate dateOnCoin, Transaction transactionID) {
		super();
		this.id = id;
		this.type = type;
		this.storageLocation = storageLocation;
		this.condition = condition;
		this.dateOnCoin = dateOnCoin;
		this.transaction = transactionID;
	}
	//super constructor
		public Coin() {
			super();
			// TODO Auto-generated constructor stub
		}
}
