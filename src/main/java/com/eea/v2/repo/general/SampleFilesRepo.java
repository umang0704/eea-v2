package com.eea.v2.repo.general;

import com.eea.v2.model.general.SampleFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SampleFilesRepo extends JpaRepository<SampleFiles,Integer> {
    Optional<SampleFiles> findByFileFor(String fileFor);

}