package com.eea.v2.service.general;

import com.eea.v2.model.general.SampleFiles;
import com.eea.v2.repo.general.SampleFilesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional(rollbackFor = { SQLException.class })
public class SampleFilesService {
    @Autowired
    private SampleFilesRepo repo;

    public SampleFiles save(SampleFiles files){
        return repo.save(files);
    }

    public Optional<SampleFiles> download(String name){
        return this.repo.findByFileFor(name);
    }
}