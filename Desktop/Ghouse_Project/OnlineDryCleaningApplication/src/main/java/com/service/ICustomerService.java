package com.service;

import java.util.List;

import com.bean.Customer;

public interface ICustomerService {

	Customer addCustomer(Customer customer);

	Customer removeCustomer(String custId);

	Customer updateCustomer(Customer customer);

	Customer getCustomer(String custId);

	List<Customer> getAllCustomers();
}
