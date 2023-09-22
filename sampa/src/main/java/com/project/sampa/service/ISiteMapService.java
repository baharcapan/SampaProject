package com.project.sampa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.sampa.model.SiteMap;

public interface ISiteMapService {

	void createSiteMap(SiteMap sitemap);
	List<SiteMap> findAll();
	Optional<SiteMap> findById(long id);
	void updateSiteMap(SiteMap siteMap);
	void deleteSiteMap(SiteMap siteMap);
}
