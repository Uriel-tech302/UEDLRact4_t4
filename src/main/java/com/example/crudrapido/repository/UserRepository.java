package com.example.crudrapido.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.crudrapido.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
    // Spring Data JPA creará automáticamente la consulta SQL con solo nombrar el método así:
    Optional<UserEntity> findByEmail(String email);
    
    Boolean existsByEmail(String email);
}