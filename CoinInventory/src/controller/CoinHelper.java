package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Coin;

public class CoinHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CoinInventory");

	public void insertNewCoins(Coin s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public List<Coin> getCoins() {
		EntityManager em = emfactory.createEntityManager();
		List<Coin> allDetails = em.createQuery("SELECT d FROM Coin d").getResultList();
		return allDetails;
	}

	public Coin searchForCoinById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Coin found = em.find(Coin.class, tempId);
		em.close();
		return found;
	}

	public void deleteItem(Coin coinToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Coin> typedQuery = em.createQuery("select d from Coin d where d.id = :selectedid",Coin.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedid", coinToDelete.getId());


		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list detail object
		Coin result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public void updateCoin(Coin toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}
