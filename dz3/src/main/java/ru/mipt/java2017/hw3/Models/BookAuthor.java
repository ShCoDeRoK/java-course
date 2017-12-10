package ru.mipt.java2017.hw3.Models;

import javax.persistence.*;

@Entity
@Table(name = "Books_Authors")
public class BookAuthor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ID")
  private Long ID;

  public Long getID() {
    return ID;
  }

  public Long getBookId() {
    return BookId;
  }

  public void setBookId(Long bookId) {
    this.BookId = bookId;
  }

  public Long getAuthorId() {
    return AuthorId;
  }

  public void setAuthorId(Long authorId) {
    this.AuthorId = authorId;
  }

  public int getOrderNumber() {
    return OrderNumber;
  }

  public void setOrderNumber(int orderNumber) {
    this.OrderNumber = orderNumber;
  }

  @Column(name="books_id")
  private Long BookId;

  @Column(name="authors_id")
  private Long AuthorId;

  @Column(name="num")
  private int OrderNumber;
}
