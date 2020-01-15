package com.yichun.springbootfreemarkerexample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	private static List<Customer> customers = new ArrayList<>();
	static {
		customers.add(new Customer(101, "someone", "someone@email.com", LocalDate.of(1955, 2, 24)));
	}

	public List<Customer> findAll() {

		return customers;
	}

	public void add(Customer customer) {
		customer.setCustomerId(generateRandomId());

		customers.add(customer);
	}

	private int generateRandomId() {

		return new Random().nextInt(1000);
	}

	public List<Customer> remove(int customerId) {
		customers.removeIf(c -> c.getCustomerId() == customerId);
		return findAll();
	}

	public Optional<Customer> find(int customerId) {
		
		return customers.stream().filter(c -> c.getCustomerId() == customerId).findFirst();
	}
}
