package com.fjd.mbt.repo;

import com.fjd.mbt.model.BaseUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<BaseUser, Long> {
}
