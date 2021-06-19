package com.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Payment;
import com.dao.IPaymentRepository;
import com.exception.EntityCreationException;
import com.exception.EntityDeletionException;
import com.exception.EntityUpdationException;


/****************************
 *          @author          G. Anvesh
 *          Description      It is a payment service implementation class that defines the methods
 *                           mentioned in its interface.
  *         Version          1.0
  *         Created Date     25-MARCH-2021
 ****************************/

@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private IPaymentRepository paymentRepository;
	
	/****************************
	 * Method:                          	addPayment
     *Description:                      	To add the payment details
     *@param payment:                       Payment's reference variable.
	 * @returns payment                  	- Adds payment data else throws Entity Creation Exception 
	 * @throws  Entity Creation Exception  	- It is raised when we cannot create payment details
     *Created By                            - G. Anvesh
     *Created Date                          - 25-MARCH-2021                           
	 
	 ****************************/
	@Override
	public Payment addPayment(Payment payment) {

		try {
			Payment payment2 = paymentRepository.save(payment);
			return payment2;
		} catch (Exception e) {
			throw new EntityCreationException("Failed to Create Payment");
		}
	}
	/****************************
	 * Method:                          	removePayment
     *Description:                      	To remove the payment details
     *@param payment:                       Payment's reference variable.
	 * @returns payment                  	- Removes payment data else throws Entity Deletion Exception 
	 * @throws  Entity Deletion Exception  	- It is raised when we cannot remove payment details
     *Created By                            - G. Anvesh
     *Created Date                          - 25-MARCH-2021                           
	 
	 ****************************/
	@Override
	public Payment removePayment(long id) {

		Optional<Payment> optionalPayment = paymentRepository.findById(id);
		Payment payment = null;
		if (optionalPayment.isPresent()) {
			payment = optionalPayment.get();
			paymentRepository.deleteById(id);
			return payment;

		} else {
			throw new EntityDeletionException("Payment with Id " + id + " cannot be found");
		}

	}
	
	
	/****************************
	 * Method:                          	updatePayment
     *Description:                      	To update the payment details
     *@param payment:                       Payment's reference variable.
	 * @returns payment                  	- Updates payment data else throws Entity Updation Exception 
	 * @throws  Entity Updation Exception   - It is raised when we cannot update payment details
     *Created By                            - G. Anvesh
     *Created Date                          - 25-MARCH-2021                           
	 ****************************/
	@Override
	public Payment updatePayment(Payment payment) {
		Optional<Payment> optionalPayment = null;
		Payment payment2 = null;
		optionalPayment = paymentRepository.findById(payment.getPaymentId());
		if (optionalPayment.isPresent()) {
			payment2 = paymentRepository.save(payment);
			return payment2;
		} else {
			throw new EntityUpdationException("Payment with Id " + payment.getPaymentId() + " cannot be updated");
		}

	}

	/****************************
	 * Method:                          getPaymentDetails
     *Description:                      To display the payment by Id (Primary key)
     *@param id:                        id of the user.
	 * @returns Payment              	- if payment with Id presents it returns payment else throws EntityNotFoundException
	 * @throws EntityNotFoundException 	-  It is raised due to invalid  paymentId 
     *Created By                   		- G. Anvesh
     *Created Date                 		- 25-MARCH-2021                           
	 
	 ****************************/
	@Override
	public Payment getPaymentDetails(long id) {
		Payment payment = null;
		Optional<Payment> optionalPayment = paymentRepository.findById(id);
		if (optionalPayment.isPresent()) {
			payment = optionalPayment.get();
			return payment;
		} else {
			throw new EntityNotFoundException("Payment with Id " + id + " cannot be found");
		}

	}
	
	/****************************
	 * Method:                          getAllPaymentDetails
     *Description:                      To display all the payments
	 * @returns List<Payment>           - It returns all the payments present in database
	 * @throws EntityNotFoundException 	-  It is raised when no valid payment details are found
     *Created By                        - G. Anvesh
     *Created Date                      - 25-MARCH-2021                           
	 
	 ****************************/
	@Override
	public List<Payment> getAllPaymentDetails() {
		List<Payment> allPayments = new ArrayList<Payment>();
		allPayments = paymentRepository.findAll();
		if (!allPayments.isEmpty()) {
			return allPayments;
		} else {
			throw new EntityNotFoundException("No Payments Found");
		}

	}

}
