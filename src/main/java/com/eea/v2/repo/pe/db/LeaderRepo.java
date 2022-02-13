package com.eea.v2.repo.pe.db;

import com.eea.v2.model.pe.db.Leader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderRepo extends JpaRepository<Leader,Integer> {
}
