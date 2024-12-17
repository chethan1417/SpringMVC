package com.xworkz.xworkz_website.repository;

import com.xworkz.xworkz_website.entity.WebsiteEntity;

public interface WebsiteRepository {

    boolean save(WebsiteEntity websiteEntity);
    WebsiteEntity findByEmail(String email);

}
