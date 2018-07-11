package com.fjd.mbt.persistence;

import com.fjd.mbt.model.BaseUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<BaseUser, Long> {
}
