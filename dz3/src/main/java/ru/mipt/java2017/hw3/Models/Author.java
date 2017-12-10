package ru.mipt.java2017.hw3.Models;

import javax.persistence.*;


@Entity
@Table(name = "Authors")
public class Author {

  public Long getID() {
    return ID;
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    this.Name = name;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ID")
  private Long ID;

  @Column(name="name", length = 50)
  private String Name;
}