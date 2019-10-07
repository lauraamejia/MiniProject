package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Coin;

public class CoinHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CoinInventory");
	
	public void insertCoin(Coin c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Coin> showAllBuyers(){
		EntityManager em = emfactory.createEntityManager();
		List<Coin> allCoins = em.createQuery("SELECT i FROM Coin i").getResultList();
		return allCoins;
	}
	
	public void deleteCoin(Coin toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Coin> typedQuery = em.createQuery("select c from Coin c where c.id = :selectedid and c.contidion = :selectedContidion and c.dateoncoin = :selecteDateOnCoin and c.type = :selectedType", Coin.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setParameter("selectedContidion", toDelete.getContidion());
		typedQuery.setParameter("selectedDateOnCoin", toDelete.getDateOnCoin());
		typedQuery.setParameter("selectedType", toDelete.getType());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		Coin result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Coin searchForCoinById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Coin found = em.find(Coin.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateCoin(Coin toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Coin> searchForCoinByContidion(String contidion) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Coin> typedQuery = em.createQuery("select c from Coin c where c.contidion = :selectedContidion", Coin.class);
		typedQuery.setParameter("selectedContidion", contidion);
		
		List<Coin> foundCoin = typedQuery.getResultList();
		em.close();
		return foundCoin;
	}
	
	public List<Coin> searchForCoinByStorageLocation(String storageLocation) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Coin> typedQuery = em.createQuery("select c from Coin c where c.storageLocation = :selectedStorageLocation", Coin.class);
		typedQuery.setParameter("selectedState", storageLocation);
		
		List<Coin> foundCoin = typedQuery.getResultList();
		em.close();
		return foundCoin;
	}
	
	public List<Coin> searchForCoinrByType(String type) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Coin> typedQuery = em.createQuery("select c from Coin c where c.type = :selectedType", Coin.class);
		typedQuery.setParameter("selectedFname", type);
		
		List<Coin> foundCoin = typedQuery.getResultList();
		em.close();
		return foundCoin;
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
