package com.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.CustomerItem;
import com.dao.ICustomerItemRepository;
import com.exception.EmptyEntityListException;
import com.exception.EntityCreationException;
import com.exception.EntityDeletionException;
import com.exception.EntityUpdationException;



/****************************
 * @author U.Arun Teja Description It is a CustomerItem service implementation
 *         class that defines the methods mentioned in its interface. Version
 *         1.0 Created Date 23-MARCH-2021
 ****************************/
@Service
@Transactional
public class CustomerItemServiceImpl implements ICustomerItemService {
	@Autowired
	private ICustomerItemRepository customerItemRepository;

	/****************************
	 * Method: addItem Description: To add the item to the list
	 * 
	 * @param CustomerItem: CustomerItes's reference variable.
	 * @returns CustomerItem - Adds Customer item
	 * @throws EntityCreationException - It is raised when we fail to create/add the
	 *                                 item Created By - U.Arun Teja Created Date -
	 *                                 23-MARCH-2021
	 * 
	 ****************************/
	@Override
	public CustomerItem addItem(CustomerItem customerItem) {
		try {
			CustomerItem customerItem2 = customerItemRepository.save(customerItem);
			return customerItem2;
		} catch (Exception e) {
			throw new EntityCreationException("Failed to create CustomerItem.");
		}
	}

	/****************************
	 * Method: removeItem Description: To remove/delete the item from the list
	 * 
	 * @param CustomerItem: CustomerItes's reference variable.
	 * @returns CustomerItem -remove's/delete's Customer item
	 * @throws EntityDeletionException - It is raised when we fail to delete the
	 *                                 item Created By - U.Arun Teja Created Date -
	 *                                 23-MARCH-2021
	 * 
	 ****************************/
	@Override
	public CustomerItem removeItem(long id) {

		Optional<CustomerItem> optionalCustomerItem = customerItemRepository.findById(id);
		CustomerItem customerItem = null;
		if (optionalCustomerItem.isPresent()) {
			customerItem = optionalCustomerItem.get();
			customerItemRepository.deleteById(id);
			return customerItem;
		} else {
			throw new EntityDeletionException("CustomerItem with ID " + id + " Cannot be Found");
		}

	}

	/****************************
	 * Method: updateItem Description: To update the item in the list
	 * 
	 * @param CustomerItem: CustomerItes's reference variable.
	 * @returns CustomerItem -It updates Customer item
	 * @throws EntityUpdationException -It is raised when we fail to update the item
	 *                                 Created By - U.Arun Teja Created Date -
	 *                                 23-MARCH-2021
	 * 
	 ****************************/

	@Override
	public CustomerItem updateItem(CustomerItem customerItem) {
		Optional<CustomerItem> optionalCustomerItem = null;
		CustomerItem customerItem1 = null;

		optionalCustomerItem = customerItemRepository.findById(customerItem.getItemId());
		if (optionalCustomerItem.isPresent()) {
			customerItem1 = customerItemRepository.save(customerItem);
			return customerItem1;
		} else {
			throw new EntityUpdationException("CustomerItem with ID " + customerItem.getItemId() + " Cannot be Updated");

		}

	}

	/****************************
	 * Method: getItem Description: To get the customer item from the list
	 * 
	 * @param CustomerItem: CustomerItes's reference variable.
	 * @returns CustomerItem -returns the Customer item
	 * @throws EntitynotFoundException - It is raised when we fail to find the
	 *                                 CustomerItem Created By - U.Arun Teja Created
	 *                                 Date - 23-MARCH-2021
	 * 
	 ****************************/

	@Override
	public CustomerItem getItem(long id) {
		CustomerItem customerItem = null;

		Optional<CustomerItem> optionalCustomerItem = customerItemRepository.findById(id);
		if (optionalCustomerItem.isPresent()) {
			customerItem = optionalCustomerItem.get();
			return customerItem;
		} else {
			throw new EntityNotFoundException("CustomerItem with ID " + id + " Cannot be Found");
		}

	}

	/****************************
	 * Method: getItemsByCustomer Description: To get the customer item from the
	 * list by the Customer
	 * 
	 * @param CustomerItem: CustomerItes's reference variable.
	 * @returns CustomerItem -returns the Customer item
	 * @throws EmptyEntityListException - It is raised when we fail to find the
	 *                                  CustomerItems by Id Created By - U.Arun Teja
	 *                                  Created Date - 23-MARCH-2021
	 * 
	 ****************************/

	@Override
	public List<CustomerItem> getItemsByCustomer(String customerId) {
		List<CustomerItem> customerItems = new ArrayList<CustomerItem>();
		customerItems = customerItemRepository.getItemsByCustomer(customerId);
		if (!customerItems.isEmpty()) {
			return customerItems;
		} else {
			throw new EmptyEntityListException("No Items Found For Given Customer Id " + customerId);
		}

	}

	@Override
	public List<CustomerItem> getAllCustomerItems() {
		List<CustomerItem> allCustomerItems = new ArrayList<CustomerItem>();
		allCustomerItems = customerItemRepository.findAll();
		if (!allCustomerItems.isEmpty()) {
			return allCustomerItems;
		} else {
			throw new EntityNotFoundException("No Items Found");
		}
	}
}
