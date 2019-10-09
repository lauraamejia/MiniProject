package controller;

import model.Transaction;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TransactionHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CoinInventory");
	
	
	public void addTransaction(Transaction toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public Transaction searchForTransactionById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Transaction found = em.find(Transaction.class, idToEdit);
		em.close();
		return found;
	}

	public void updateTransaction(Transaction toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteTransaction(Transaction toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Transaction> typedQuery = em.createQuery("select ch from Transaction ch where ch.tableid = :selectedTableID and ch.dealer = :selectedDealer and ch.price = :selectedPrice and ch.tranDate = :selectedTranDate", Transaction.class);		
		typedQuery.setParameter("selectedId", toDelete.getTableID());
		typedQuery.setParameter("selectedDealer", toDelete.getDealer());
		typedQuery.setParameter("selectedPrice", toDelete.getPrice());
		typedQuery.setParameter("selectedTranDate", toDelete.getTranDate());
		
		typedQuery.setMaxResults(1);
		
		Transaction result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Transaction> showAllTransactions() {
		EntityManager em = emfactory.createEntityManager();
		List<Transaction> allItems = em.createQuery("SELECT i FROM Transaction i").getResultList();
		return allItems;
	}

	
	public void cleanUp() {
		emfactory.close();
	}
}
