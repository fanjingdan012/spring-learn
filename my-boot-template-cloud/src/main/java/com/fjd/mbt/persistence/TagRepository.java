package com.fjd.mbt.persistence;

import com.fjd.mbt.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
}
