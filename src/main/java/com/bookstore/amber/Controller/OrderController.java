package com.bookstore.amber.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.amber.Entiry.Orders;
import com.bookstore.amber.Service.OService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
    
    @Autowired
    OService os;

    
    @PostMapping("/addOrder")
    public Orders addOrders(@RequestBody Orders Order){

        return os.addOrders(Order);
    }

	@PostMapping("/addOrder/{customer_id}")
    public Orders addOrdersanCustomer(@RequestBody Orders Order,@PathVariable(required = false)Integer customer_id){

        return os.OrderwithCustomer(Order,customer_id);
    }
    
	  @GetMapping("/getOrders")
	    public List<Orders> getAllOrders() {
	        return os.fetchAllOrders();
	    }
	  
	  @GetMapping("/getOrders/{id}") //localhost:8080/getOrders/5
	  public Orders getOrdersById(@PathVariable int id)
	  {
		  return os.getOrdersById(id);
	  }
	  
	  @DeleteMapping("/Orders/{id}")
	  public String deleteOrders(@PathVariable int id) {
		  return os.deleteOrdersById(id);
	  }
}
