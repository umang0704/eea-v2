package com.eea.v2.repo.pe;

import com.eea.v2.model.pe.PE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PERepo extends JpaRepository<PE,Integer> {

}
