package com.arothy.search.persistence.h2.sample.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.arothy.search.persistence.h2.sample.entity.Sample;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class SampleRepositoryTest {

    @Autowired
    private SampleRepository sampleRepository;

    @Test
    public void whenFindByName_thenReturn() {
        // given
        Sample sample = Sample.creation().name("arothy").build();
        sampleRepository.save(sample);

        // when
        List<Sample> found = sampleRepository.findByName(sample.getName());

        // then
        assertThat(found.get(0).getName()).isEqualTo(sample.getName());
    }

}