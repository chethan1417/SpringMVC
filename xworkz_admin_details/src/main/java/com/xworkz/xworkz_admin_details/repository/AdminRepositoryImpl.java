package com.xworkz.xworkz_admin_details.repository;

import com.xworkz.xworkz_admin_details.entity.AdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Repository
public class AdminRepositoryImpl implements AdminRepository{

    @Autowired
    EntityManagerFactory entityManagerFactory;

    public AdminRepositoryImpl()
    {
        System.out.println("created AdminRepositoryImpl");
    }
    @Override
    public boolean save(AdminEntity adminEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try{

            entityTransaction.begin();
            entityManager.persist(adminEntity);
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
}
