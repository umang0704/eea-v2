package com.eea.v2.repo.pe.db;

import com.eea.v2.model.pe.db.Founder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FounderRepo extends JpaRepository<Founder,Integer> {
    List<Founder> findByPeId(Integer peId);
}
