package com.joyshop.joy.domain.repository;

import com.joyshop.joy.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaAuditing
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Override
    List<Customer> findAll();
    @Override
    Optional<Customer> findById(Long aLong);
    @Override
    void delete(Customer entity);
    @Override
    void deleteById(Long aLong);
    @Override
    <S extends Customer> S save(S entity);

}
