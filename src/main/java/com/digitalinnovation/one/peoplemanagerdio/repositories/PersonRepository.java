package com.digitalinnovation.one.peoplemanagerdio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalinnovation.one.peoplemanagerdio.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
