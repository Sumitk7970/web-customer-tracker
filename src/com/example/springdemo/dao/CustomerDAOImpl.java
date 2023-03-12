package com.example.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by firstName", Customer.class);
		
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(customer);
	}

}
