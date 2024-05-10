package com.springboot.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bean.Doctor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DoctorRepo {
 
    @PersistenceContext
    private EntityManager entityManager;
 
    @Transactional
    public void save(Doctor doc) {
        entityManager.persist(doc);
    }
 
    public List<Doctor> findAll() {
        return entityManager.createQuery("FROM Doctor", Doctor.class).getResultList();
    }
}
