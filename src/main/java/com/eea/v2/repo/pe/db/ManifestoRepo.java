package com.eea.v2.repo.pe.db;

import com.eea.v2.model.pe.db.Manifesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManifestoRepo extends JpaRepository<Manifesto,Integer> {
}
