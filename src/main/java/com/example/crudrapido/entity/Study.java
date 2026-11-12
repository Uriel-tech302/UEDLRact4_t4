package com.example.crudrapido.entity;
import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Data
@Entity 
@Table(name = "tbl_studies")
public class Study {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studyId;
    private String firstName;
    private String lastName;
    @Column (name = "email_address", unique = true, nullable = false)
    private String email;
}
