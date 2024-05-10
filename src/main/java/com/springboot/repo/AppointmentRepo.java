package com.springboot.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.bean.Appointment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AppointmentRepo {
	
	@PersistenceContext
    private EntityManager entityManager;
 
    @Transactional
    public void save(Appointment appoint) {
        entityManager.persist(appoint);
    }
 
    public List<Appointment> findAll() {
        return entityManager.createQuery("FROM Appointment", Appointment.class).getResultList();
    }
    
    public List<Appointment> getId(){
    	return entityManager.createQuery("Select id FROM Appointment", Appointment.class).getResultList();
    }
}

	
	
