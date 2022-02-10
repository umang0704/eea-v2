package com.eea.v2.repo.pe;

import com.eea.v2.model.pe.PELogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PELogoRepo extends JpaRepository<PELogo,Integer> {
}
