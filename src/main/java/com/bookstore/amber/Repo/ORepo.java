package com.bookstore.amber.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.amber.Entiry.Orders;
@Repository
public interface ORepo extends JpaRepository<Orders,Integer>{
    
}
