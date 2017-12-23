package com.demo.tdd.repository;

import com.demo.tdd.domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CarRepositoryTest {

    @Autowired
    private CarRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void getCar_returnsCarDetails() throws Exception {
        Car savedCar = entityManager.persistAndFlush(new Car("prius", "hybrid"));
        Car car = repository.findByName("prius");

        Assertions.assertThat(car.getName()).isEqualTo(savedCar.getName());
        Assertions.assertThat(car.getType()).isEqualTo(savedCar.getType());
    }
}