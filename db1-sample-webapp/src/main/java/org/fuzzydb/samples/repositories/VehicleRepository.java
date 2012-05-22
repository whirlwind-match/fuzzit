package org.fuzzydb.samples.repositories;


import org.fuzzydb.samples.Vehicle;

import com.wwm.db1.spring.repository.FuzzyRepository;

public interface VehicleRepository extends FuzzyRepository<Vehicle,String> {

}
