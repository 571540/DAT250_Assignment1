package no.hvl.dat250.jpa.basicexample;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	private static final String PERSISTENCE_UNIT_NAME = "banking";
    private static EntityManagerFactory factory;
    
	public static void main(String[] args) {
    	factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    	EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        
        //Person
        Person person = new Person();
        Bank bank = new Bank();
        CreditCard card = new CreditCard();
        Pincode pincode = new Pincode();
        Address address = new Address();
        
        //Person
        person.setName("Marcus");
        List<Address> addresses = new ArrayList<Address>();
        person.setAddress(addresses);
        
        //Pincode
        pincode.setPincode("1234");
        pincode.setCount(3);
        
        //CrediCard
        card.setBalance(500000);
        card.setLimit(5000);
        card.setNumber(1111223333);
        card.setPincode(pincode);
        card.setBank(bank);
        
        //Bank
        bank.setName("ToSmallToSucceed");
        List<CreditCard> creditcards = new ArrayList<CreditCard>();
        creditcards.add(card);;
        bank.setCreditcards(creditcards);
        
        //Address
        List<Person> persons = new ArrayList<Person>();
        persons.add(person);
        address.setPerson(persons);
        address.setStreet("Inndalsveien 28");
        
        em.persist(pincode);
        em.persist(bank);
        em.persist(card);
        em.persist(person);
        em.persist(address);
        em.getTransaction().commit();

        em.close();
    }
}
