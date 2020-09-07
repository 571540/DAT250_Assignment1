package no.hvl.dat250.jpa.basicexample;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String street;

  @ManyToMany(mappedBy = "address")
  private List<Person> person;

  public String getStreet() {
    return street;
  }

  public List<Person> getPerson() {
    return person;
  }

  public void setPerson(List<Person> person) {
    this.person = person;
  }

  public void setStreet(String street) {
    this.street = street;
  }
}