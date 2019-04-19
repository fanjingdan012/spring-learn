package com.fjd.mbt.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fjd.mbt.model.Presentation;

@Repository
public interface PresentationRepository extends CrudRepository<Presentation, Long> {
}
