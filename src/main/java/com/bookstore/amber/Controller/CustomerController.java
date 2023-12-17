package com.bookstore.amber.Controller;

import java.util.List;

import com.bookstore.amber.Service.JWTService;
import com.bookstore.amber.dto.AuthBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.amber.Entiry.Customers;
import com.bookstore.amber.Service.CService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
    
    @Autowired
    CService cs;
	@Autowired
	JWTService jwtService;
	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthBody authBody){
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authBody.getEmail(), authBody.getPassword()));
			if(authentication.isAuthenticated()){
				return jwtService.generateToken(authBody.getEmail());
			}
			else {
                throw new  UsernameNotFoundException("Invalid Credentials");
            }
	}
    @PostMapping("/addCustomers")
	public Customers addCustomers(@Valid @RequestBody Customers Customers) {
		
		return cs.addCustomers(Customers);
	}
	@PostMapping("/register")
    public Customers registration(@Valid @RequestBody Customers Customers){
        Customers existingUser = cs.getByEmail(Customers.getEmail());

        if(existingUser != null)
            return null;
		else
        	return cs.addCustomers(Customers);
    }

	  @GetMapping("/getCustomers")
	  @PreAuthorize("hasAuthority('USER')")
	    public List<Customers> getAllCustomers() {
	        return cs.fetchAllCustomers();
	    }
	  
	  @GetMapping("/getCustomers/{id}") //localhost:8080/getCustomers/5
	  public Customers getCustomersById(@PathVariable int id)
	  {
		  return cs.getCustomersById(id);
	  }
	  
	  @PutMapping("/Customers/{id}")
	    public Customers updateCustomers(@PathVariable int id, @RequestBody Customers Customers) {
	        return cs.updateCustomersById(id, Customers);
	    }
	  
	  @DeleteMapping("/Customers/{id}")
	  public String deleteCustomers(@PathVariable int id) {
		  return cs.deleteCustomersById(id);
	  }

	  @PostMapping("/log_in")
      public Customers login(@RequestBody Customers user){
		String email=user.getEmail();
		String password=user.getPassword();
         Customers c1=cs.getByEmail(email);
        if(c1!=null && c1.getPassword().equals(password)){

            return c1; 
        }
        else{
            return null;    
        }
    }
}
