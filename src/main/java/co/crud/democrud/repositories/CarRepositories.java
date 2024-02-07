package co.crud.democrud.repositories;

import co.crud.democrud.enities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarRepositories extends JpaRepository<Car, Long > {
}
