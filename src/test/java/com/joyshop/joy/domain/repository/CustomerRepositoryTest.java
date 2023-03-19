package com.joyshop.joy.domain.repository;

import com.joyshop.joy.domain.model.Customer;
import com.joyshop.joy.dto.CustomerDto;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;

    private static Customer defaultCustomer;
    private static CustomerDto defaultCustomerDto;
    @BeforeEach
    public void setUp(){
        Customer customer = new Customer();
        customer.setName("joy");
        customer.setAddress("서울특별시");
        customer.setEmail("asd1234@naver.com");
        customer.setPhoneNumber("01012341234");

        defaultCustomer = customer;

        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId(1L);
        customerDto.setName("joy");
        customerDto.setAddress("서울");
        customerDto.setEmail("asd123@naver.com");
        customerDto.setPhoneNumber("01012341234");

        defaultCustomerDto = customerDto;
    }

    @Test
    @DisplayName("Customer add test")
    public void addCustomer(){
        //given
        Customer customer = defaultCustomer;

        //when
        customerRepository.save(customer);

        //then
        assertNotNull(customer.getCustomerId());
        assertNotNull(customer.getCreatedAt());
        assertNotNull(customer.getUpdatedAt());
    }

    @Test
    @DisplayName("Customer update test")
    public void updateCustomer(){
        //given
        Customer customer = defaultCustomer;
        customerRepository.save(customer);

        //when
        customer.setName("joy_shop");
        customerRepository.save(customer);

        Customer findCustomer = customerRepository.findById(customer.getCustomerId()).orElse(null);
        //then
        assertEquals(findCustomer.getName(), "joy_shop");
        assertEquals(findCustomer.getCreatedAt(), customer.getCreatedAt());
    }

    @Test
    @DisplayName("Customer delete test")
    public void deleteCustomer(){
        //given
        Customer customer = defaultCustomer;
        customerRepository.save(customer);
        //when
        customerRepository.deleteById(customer.getCustomerId());
        //then
        Customer deletedCustomer = customerRepository.findById(customer.getCustomerId()).orElse(null);
        assertNull(deletedCustomer);

    }

    @Test
    @DisplayName("Customer read test")
    public void readCustomer(){
        //given
        Customer customer = defaultCustomer;
        customerRepository.save(customer);
        //when
        Customer findCustomer = customerRepository.findById(customer.getCustomerId()).orElse(null);
        //then
        assertEquals(findCustomer.getCustomerId(), customer.getCustomerId());
        assertEquals(findCustomer.getName(), customer.getName());
        assertEquals(findCustomer.getEmail(), customer.getEmail());
        assertEquals(findCustomer.getAddress(), customer.getAddress());
        assertEquals(findCustomer.getPhoneNumber(), customer.getPhoneNumber());
    }

    @Test
    @DisplayName("convert customer Dto to Entity")
    public void convertDtoToEntity(){
        //given
        CustomerDto customerDto = defaultCustomerDto;

        //when
        Customer customer = CustomerDto.convertDtoToEntity(customerDto);

        //then
        assertEquals(customer.getClass(), Customer.class);
        assertEquals(customer.getCustomerId(), customerDto.getCustomerId());
        assertEquals(customer.getName(),customerDto.getName());
        assertEquals(customer.getAddress(), customerDto.getAddress());
        assertEquals(customer.getEmail(), customerDto.getEmail());
        assertEquals(customer.getPhoneNumber(), customerDto.getPhoneNumber());
    }

    @Test
    @DisplayName("convert customer Entity to Dto")
    public void convertEntityToDto(){
        //given
        Customer customer = defaultCustomer;

        //when
        CustomerDto customerDto = CustomerDto.convertEntityToDTO(customer);

        //then
        assertEquals(customerDto.getClass(), CustomerDto.class);
        assertEquals(customerDto.getCustomerId(), customer.getCustomerId());
        assertEquals(customerDto.getName(),customer.getName());
        assertEquals(customerDto.getAddress(), customer.getAddress());
        assertEquals(customerDto.getEmail(), customer.getEmail());
        assertEquals(customerDto.getPhoneNumber(), customer.getPhoneNumber());
    }

}