package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Transactiontype;

public class TransactionTypeHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CoinInventory");
	
	public void addTransactionType(Transactiontype toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public Transactiontype searchForTransactionById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Transactiontype found = em.find(Transactiontype.class, idToEdit);
		em.close();
		return found;
	}

	public void updateTransactionType(Transactiontype toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteTransactionType(Transactiontype toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Transactiontype> typedQuery = em.createQuery("select t from Transactiontype t where t.id = :selectedId and t.trantype = :selectedTranType", Transactiontype.class);		
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setParameter("selectedTranType", toDelete.getTranType());

		
		typedQuery.setMaxResults(1);
		
		Transactiontype result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Transactiontype> showAllTransactionsTypes() {
		EntityManager em = emfactory.createEntityManager();
		List<Transactiontype> allItems = em.createQuery("SELECT i FROM Transactiontype i").getResultList();
		return allItems;
	}

	public void cleanUp() {
		emfactory.close();
	}
}
