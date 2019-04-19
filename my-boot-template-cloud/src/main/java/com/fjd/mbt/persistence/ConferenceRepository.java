package com.fjd.mbt.persistence;

import com.fjd.mbt.model.Conference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ConferenceRepository extends CrudRepository<Conference, Long> {

}
