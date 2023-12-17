package com.bookstore.amber.Entiry;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Books {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int book_id;
private String title;
private String author_name;
private String genre;
private double price;
private int star;

}
