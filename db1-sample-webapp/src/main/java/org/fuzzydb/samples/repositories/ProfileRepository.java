package org.fuzzydb.samples.repositories;


import org.fuzzydb.samples.GiveTakeItem;

import com.wwm.db1.spring.repository.FuzzyRepository;

public interface ProfileRepository extends FuzzyRepository<GiveTakeItem,String> {

}
