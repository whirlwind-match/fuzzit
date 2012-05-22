package org.fuzzydb.samples.repositories;

import org.fuzzydb.samples.Person;

import com.wwm.db1.spring.repository.FuzzyRepository;

public interface PersonRepository extends FuzzyRepository<Person,String> {

}
