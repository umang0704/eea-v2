package com.eea.v2.repo.general;

import com.eea.v2.model.general.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<Image,Integer> {
}
