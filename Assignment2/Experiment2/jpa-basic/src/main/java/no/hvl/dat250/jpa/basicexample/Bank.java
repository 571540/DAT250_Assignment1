package no.hvl.dat250.jpa.basicexample;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Bank {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @OneToMany(mappedBy="bank")
  @JoinColumn
  private List<CreditCard> creditcards;

  public String getName() {
    return name;
  }

  public List<CreditCard> getCreditcards() {
    return creditcards;
  }

  public void setCreditcards(List<CreditCard> creditcards) {
    this.creditcards = creditcards;
  }

  public void setName(String name) {
    this.name = name;
  }
}