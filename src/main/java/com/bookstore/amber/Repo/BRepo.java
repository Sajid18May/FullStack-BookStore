package com.bookstore.amber.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.amber.Entiry.Books;
@Repository
public interface BRepo extends JpaRepository<Books,Integer>{
    
}
