package com.xworkz.xworkz_website.repository;

import com.xworkz.xworkz_website.entity.WebsiteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Repository
public class WebsiteRepositoryImpl implements WebsiteRepository{

    public WebsiteRepositoryImpl()
    {
        System.out.println("created WebsiteRepositoryImpl");
    }

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public boolean save(WebsiteEntity websiteEntity) {

        System.out.println("save in WebsiteRepositoryImpl");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try{
            entityTransaction.begin();
            entityManager.persist(websiteEntity);
            entityTransaction.commit();

        }catch(Exception e){
            if(entityTransaction.isActive())
                entityTransaction.rollback();
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return true;
    }

    @Override
    public WebsiteEntity findByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createNamedQuery("WebsiteEntity.findByEmail", WebsiteEntity.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

}
