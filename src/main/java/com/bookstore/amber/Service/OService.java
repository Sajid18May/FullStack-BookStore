package com.bookstore.amber.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.amber.Entiry.Customers;
import com.bookstore.amber.Entiry.Orders;
import com.bookstore.amber.Repo.CRepo;
import com.bookstore.amber.Repo.ORepo;

@Service
public class OService {
    @Autowired
    ORepo or;

	@Autowired
	CRepo cr;

    public Orders addOrders(Orders order){
        return or.save(order);
    }
	public List<Orders> fetchAllOrders() {	
		return or.findAll();
	}

	public Orders getOrdersById(int id) {
		Optional<Orders> order = or.findById(id);

		if (order.isPresent()) {
			return order.get();
		}
		return null;
	}

	
	public String deleteOrdersById(int id) {
		if(or.findById(id).isPresent()) {
			or.deleteById(id);
			return "Order deleted successfully";
		}
		return "No such order in the database";
	}

	public Orders OrderwithCustomer(Orders Order, int customer_id) {
        Optional<Customers> optionalcustomer = cr.findById(customer_id);

        if (optionalcustomer.isPresent()) {
            Customers customer = optionalcustomer.get();
            Order.setCustomers(customer);
            or.save(Order);
			return Order;
        } else {
			return null;
		}
            
    }
}
