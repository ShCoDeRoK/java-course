package ru.mipt.java2017.hw3.Models;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name="Books")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ID")
  private Long ID;

  public Long getID() {
    return ID;
  }

  public BigDecimal getISBN() {
    return ISBN;
  }

  public void setISBN(BigDecimal ISBN) {
    this.ISBN = ISBN;
  }

  public String getTitle() {
    return Title;
  }

  public void setTitle(String title) {
    this.Title = title;
  }

  public String getCover() {
    return Cover;
  }

  public void setCover(String cover) {
    this.Cover = cover;
  }

  @Column(name="ISBN", scale = 13)
  private BigDecimal ISBN;

  @Column(name="title", length = 100)
  private String Title;

  @Column(name="cover", length = 400)
  private String Cover;
}
