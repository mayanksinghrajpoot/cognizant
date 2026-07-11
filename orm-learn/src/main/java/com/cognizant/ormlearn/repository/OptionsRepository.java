package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Options;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionsRepository extends JpaRepository<Options, Integer> {
}
