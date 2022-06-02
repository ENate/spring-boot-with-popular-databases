package com.minejava.mariadbexample;

import com.minejava.mariadbexample.model.Customer;
import com.minejava.mariadbexample.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MariaDBExampleApplicationTests {

    // call customer model repo
    @Autowired
    private CustomerRepository customerRepository;
    @Before
    public void setUp() {
        Customer customer1 = new Customer("Another", "Maker", 12);
        Customer customer2 = new Customer("Download", "Dears", 12);
        Customer customer3 = new Customer("Joker", "Farmer", 38);
        Customer customer4 = new Customer("Smart", "Mart Dane", 112);
        //save user, verify has ID value after save
        assert(customer1.getId() == 0);
        // assertNull(customer2.getId());//null before save
        this.customerRepository.save(customer1);
        this.customerRepository.save(customer2);
        this.customerRepository.save(customer3);
        this.customerRepository.save(customer4);
        assert(customer1.getId() != 0);
        // assertNotNull(customer2.getId());
    }

    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        Customer customerA = customerRepository.findByFirstName("Joker");
        assertNotNull(customerA);
        assertEquals(38, customerA.getAge());
        /*Get all products, list should only have two*/
        Iterable<Customer> customers = customerRepository.findAll();
        int count = 0;
        for(Customer p : customers){
            count++;
            if (count == 2) {
                System.out.println("We reached 2!" + p);
            }
        }
        assertEquals(count, 12);
    }

}
