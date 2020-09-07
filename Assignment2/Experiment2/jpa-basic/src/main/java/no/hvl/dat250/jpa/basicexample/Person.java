package no.hvl.dat250.jpa.basicexample;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @OneToMany
  @JoinColumn
  private List<CreditCard> creditcards;

  @ManyToMany
  @JoinTable(name = "jnd_pers_addr", 
  	joinColumns = @JoinColumn(name = "person_fk"), 
  	inverseJoinColumns = @JoinColumn(name = "address_fk"))
  private List<Address> address;

  public String getName() {
    return name;
  }

  public List<Address> getAddress() {
    return address;
  }

  public void setAddress(List<Address> address) {
    this.address = address;
  }

  public void setName(String name) {
    this.name = name;
  }
}
