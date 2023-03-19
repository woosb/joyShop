package com.joyshop.joy.domain.repository;

import com.joyshop.joy.domain.model.Customer;
import com.joyshop.joy.dto.CustomerDto;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;
    @Test
    @DisplayName("Customer add test")
    public void addCustomer(){
        //given
        Customer customer = new Customer();
        customer.setName("joy");
        customer.setAddress("서울특별시");
        customer.setEmail("asd1234@naver.com");
        customer.setPhoneNumber("01012341234");

        //when
        customerRepository.save(customer);

        //then
        assertNotNull(customer.getCustomerId());
        assertNotNull(customer.getCreatedAt());
        assertNotNull(customer.getUpdatedAt());
    }

    @Test
    public void updateCustomer(){

    }

    @Test
    public void deleteCustomer(){

    }

    @Test
    public void readCustomer(){

    }

    @Test
    public void convertDtoToEntity(){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId(1L);
        customerDto.setName("joy");
        customerDto.setAddress("서울");
        customerDto.setEmail("asd123@naver.com");
        customerDto.setPhoneNumber("01012341234");

        Customer customer = customerDto.convertDtoToEntity(customerDto);

        assertEquals(customer.getClass(), Customer.class);
        assertEquals(customer.getCustomerId(), customerDto.getCustomerId());
        assertEquals(customer.getName(),customerDto.getName());
        assertEquals(customer.getAddress(), customerDto.getAddress());
        assertEquals(customer.getEmail(), customerDto.getEmail());
        assertEquals(customer.getPhoneNumber(), customerDto.getPhoneNumber());
    }

    @Test
    public void convertEntityToDto(){
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setName("joy");
        customer.setAddress("서울");
        customer.setEmail("asd123@naver.com");
        customer.setPhoneNumber("01012341234");

        CustomerDto customerDto = CustomerDto.convertEntityToDTO(customer);

        assertEquals(customerDto.getClass(), CustomerDto.class);
        assertEquals(customerDto.getCustomerId(), customer.getCustomerId());
        assertEquals(customerDto.getName(),customer.getName());
        assertEquals(customerDto.getAddress(), customer.getAddress());
        assertEquals(customerDto.getEmail(), customer.getEmail());
        assertEquals(customerDto.getPhoneNumber(), customer.getPhoneNumber());
    }

}