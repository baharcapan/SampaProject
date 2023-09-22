package com.project.sampa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.sampa.model.SiteMap;

@Repository
public interface SiteMapDataRepository extends JpaRepository<SiteMap,Long> {

}
