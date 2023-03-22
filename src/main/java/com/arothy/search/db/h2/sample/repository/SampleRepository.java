package com.arothy.search.db.h2.sample.repository;

import com.arothy.search.db.h2.sample.entity.Sample;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<Sample, Long> {

    List<Sample> findByName(String name);
}
