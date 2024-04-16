package com.example.demo.Repository;
import com.example.demo.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface PersonRepository extends JpaRepository<Person,Integer> {
    @Query(value="select * from Person where username=:c", nativeQuery=true)
    List<Person> findUserBySurname(@Param("c") String surname);
}
