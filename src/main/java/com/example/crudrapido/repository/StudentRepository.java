package com.example.crudrapido.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crudrapido.entity.Study;
@Repository 
public interface StudentRepository extends JpaRepository<Study, Long> {

    
    
}