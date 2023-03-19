package com.joyshop.joy.dto;

import com.joyshop.joy.domain.model.Customer;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CustomerDto {

    private Long customerId;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public static Customer convertDtoToEntity(CustomerDto customerDto){
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(customerDto, Customer.class);
        return customer;
    }

    public static CustomerDto convertEntityToDTO(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId(customer.getCustomerId());
        customerDto.setName(customer.getName());
        customerDto.setAddress(customer.getAddress());
        customerDto.setPhoneNumber(customer.getPhoneNumber());
        customerDto.setEmail(customer.getEmail());
        return customerDto;
    }
}
