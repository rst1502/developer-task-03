package com.econetmedia.developer.interview.service;

import com.econetmedia.developer.interview.exception.ValidationException;
import com.econetmedia.developer.interview.model.Customer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public boolean registerCustomer(Customer customer) {

        if(customer.getFirstName()==null ){
            throw new ValidationException("Firstname is null  ");
        }
        if(customer.getFirstName().isEmpty()){
            throw new ValidationException("Firstname is empty ");
        }
        if(customer.getNationalId().length()<5){
            throw new ValidationException("National ID is less than the required length ");
        }

        return false;
    }

    @Override
    public Optional<Customer> findCustomer(Long id) {
        return null;
    }

    @Override
    public List<Customer> filterByGradeOrSalary(String grade, Number salary, List<Customer> customerInputList) {

        return customerInputList.stream()
                .filter(customer -> customer.getGrade().equals(grade)|| customer.getSalary()==salary)
                .collect(Collectors.toList());

    }
}
