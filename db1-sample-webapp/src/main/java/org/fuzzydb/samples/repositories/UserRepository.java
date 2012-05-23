package org.fuzzydb.samples.repositories;

import likemynds.db.query.SortableString;

import org.fuzzydb.samples.security.WhirlwindUserDetails;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<WhirlwindUserDetails,SortableString> {

}
