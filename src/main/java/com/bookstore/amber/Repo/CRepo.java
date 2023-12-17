package com.bookstore.amber.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.amber.Entiry.Customers;

@Repository
public interface CRepo extends JpaRepository<Customers,Integer>{
    public Customers findByEmail(String email);
}
