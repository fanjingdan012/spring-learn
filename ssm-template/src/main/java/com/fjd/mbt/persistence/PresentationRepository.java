package com.fjd.mbt.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fjd.mbt.model.Presentation;

@Repository
@Transactional
public interface PresentationRepository extends CrudRepository<Presentation, Long> {
}
