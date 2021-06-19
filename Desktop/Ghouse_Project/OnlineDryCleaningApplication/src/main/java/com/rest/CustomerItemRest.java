package com.rest;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CustomerItem;
import com.service.ICustomerItemService;

/*******************************************
 * @author           U.Arun Teja
 * Description       It is a service class that provides the
 *                   services to add a statement,remove a statement,update a statement and view statement 
 * Version           1.0 
 * Created Date      24-MARCH-2021
 *******************************************/

@RestController
@RequestMapping("/customeritem")
public class CustomerItemRest {
	@Autowired
	private ICustomerItemService iCustomerItemService;

	/*******************************
	* Method                : addItem
	*Description            : To add an Item into the Database
	* @param CustomerItem   - CustomerItem to be added to the Database
	* @param RequestBody    - It maps the HttpRequest body to a transfer or domain object,
	                          enabling automatic deserialization of the inbound HttpRequest body
	                          onto a Java object.
	* @returns customerItem - returns customerItem
	*Created By             - U.Arun Teja
	*Created Date           - 24-MARCH-2021

	********************************/
	@PostMapping("/add")
	public CustomerItem addItem(@RequestBody CustomerItem customerItem) {
		CustomerItem customerItem2 = this.iCustomerItemService.addItem(customerItem);
		return customerItem2;
	}

	/*******************************
	* Method                : removeItem
	*Description            : To remove/delete Item in the Database
	* @param CustomerItem   - CustomerItem to be deleted from the Database
	* @param RequestBody    - It maps the HttpRequest body to a transfer or domain object,
	                          enabling automatic deserialization of the inbound HttpRequest body
	                          onto a Java object.
	* @returns customerItem - returns customerItem
	*Created By             - U.Arun Teja
	*Created Date           - 24-MARCH-2021

	********************************/
	@DeleteMapping("/delete/{id}")
	public CustomerItem removeItem(@PathVariable long id) {
		CustomerItem customerItem = this.iCustomerItemService.removeItem(id);
		return customerItem;
	}

	/*******************************
	* Method                : updateItem
	*Description            : To update an Item into the Database
	* @param CustomerItem   - CustomerItem to be updated in the Database
	* @param RequestBody    - It maps the HttpRequest body to a transfer or domain object,
	                          enabling automatic deserialization of the inbound HttpRequest body
	                          onto a Java object.
	* @returns customerItem - returns customerItem
	*Created By             - U.Arun Teja
	*Created Date           - 24-MARCH-2021

	********************************/
	@PutMapping("/update")
	public CustomerItem updateItem(@RequestBody CustomerItem customerItem) {
		CustomerItem customerItem2 = this.iCustomerItemService.updateItem(customerItem);
		return customerItem2;
	}

	/*******************************
	* Method                : getItem
	*Description            : To get the Item from the Database
	* @param CustomerItem   - CustomerItem to be fetched from the Database
	* @param RequestBody    - It maps the HttpRequest body to a transfer or domain object,
	                          enabling automatic deserialization of the inbound HttpRequest body
	                          onto a Java object.
	* @returns customerItem - returns customerItem
	*Created By             - U.Arun Teja
	*Created Date           - 24-MARCH-2021

	********************************/
	@GetMapping("/get/{id}")
	public CustomerItem getItem(@PathVariable long id) {
		CustomerItem customerItem = this.iCustomerItemService.getItem(id);
		return customerItem;
	}

	/****************************
	* Method                : getItemsByCustomer
	*Description            : To fetch the Items of a Customer from the Database.
	* @returns CustomerItems- returns list of CustomerItems.
	*Created By             - U.Arun Teja
	*Created Date           - 24-MARCH-2021

	***************************************************************/
	@GetMapping("/getbycustomer/{id}")
	public List<CustomerItem> getItemsByCustomer(@PathVariable("id") String customerId) {
		List<CustomerItem> customerItems = this.iCustomerItemService.getItemsByCustomer(customerId);
		return customerItems;
	}

	@GetMapping("/all")
	public List<CustomerItem> getAllCustomerItems() {
		List<CustomerItem> customerItems = this.iCustomerItemService.getAllCustomerItems();
		return customerItems;
	}
}

