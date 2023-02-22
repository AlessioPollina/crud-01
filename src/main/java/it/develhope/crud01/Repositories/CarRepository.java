package it.develhope.crud01.Repositories;

import it.develhope.crud01.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarRepository extends JpaRepository<Car, Long>{
}
