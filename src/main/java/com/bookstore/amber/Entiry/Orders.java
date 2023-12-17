package com.bookstore.amber.Entiry;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private int totalcount;
    private double totalprice;
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date order_date;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customers;
}
 