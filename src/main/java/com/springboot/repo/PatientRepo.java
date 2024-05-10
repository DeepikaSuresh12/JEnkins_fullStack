package com.springboot.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bean.Patient;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PatientRepo {
 
    @PersistenceContext
    private EntityManager entityManager;
 
    @Transactional
    public void save(Patient pat) {
        entityManager.persist(pat);
    }
 
    public List<Patient> findAll() {
        return entityManager.createQuery("FROM Patient", Patient.class).getResultList();
    }
}
