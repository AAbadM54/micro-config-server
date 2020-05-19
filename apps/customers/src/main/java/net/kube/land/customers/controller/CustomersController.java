package net.kube.land.customers.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.kube.land.customers.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/kube/customers")
public class CustomersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomersController.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${kube.land.customers.config1.id:none}")
    public String customerId1;
    @Value("${kube.land.customers.config1.name:none}")
    public String customerName1;
    @Value("${kube.land.customers.config1.school:none}")
    public String customerSchool1;
    @Value("${kube.land.customers.config1.profession:none}")
    public String customerProfession1;
    @Value("${kube.land.customers.config1.friends:none}")
    public String customerFriends1;
    @Value("${kube.land.customers.config1.enemy:none}")
    public String customerEnemy1;

    @Value("${kube.land.customers.config2.id:none}")
    public String customerId2;
    @Value("${kube.land.customers.config2.name:none}")
    public String customerName2;
    @Value("${kube.land.customers.config2.school:none}")
    public String customerSchool2;
    @Value("${kube.land.customers.config2.profession:none}")
    public String customerProfession2;
    @Value("${kube.land.customers.config2.friends:none}")
    public String customerFriends2;
    @Value("${kube.land.customers.config2.enemy:none}")
    public String customerEnemy2;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> list() throws Exception {

        List<Customer> customers = Arrays.asList(
                new Customer(customerId1, customerName1, customerSchool1, customerProfession1, customerFriends1, customerEnemy1),
                new Customer(customerId2, customerName2, customerSchool2, customerProfession2, customerFriends2, customerEnemy2)
        );

        String responseString = objectMapper.writeValueAsString(customers);

        return new ResponseEntity(responseString, HttpStatus.OK);
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> getCustomer(@PathVariable("customerId") String customerId) throws Exception {

        return new ResponseEntity(new Customer(customerId, customerName1, customerSchool1, customerProfession1, customerFriends1, customerEnemy1), HttpStatus.OK);
    }
}
