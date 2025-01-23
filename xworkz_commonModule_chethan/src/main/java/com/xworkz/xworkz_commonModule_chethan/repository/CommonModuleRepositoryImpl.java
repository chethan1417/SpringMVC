package com.xworkz.xworkz_commonModule_chethan.repository;

import com.xworkz.xworkz_commonModule_chethan.entity.CommonModuleEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalDateTime;

@Repository
public class CommonModuleRepositoryImpl implements CommonModuleRepository {

    private static final Logger log = LoggerFactory.getLogger(CommonModuleRepositoryImpl.class);
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public CommonModuleRepositoryImpl()
    {
        log.info("created CommonModuleRepositoryImpl");
    }
    @Override
    public boolean save(CommonModuleEntity entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
        return true;
    }

    @Override
    public Long getCountOfName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getCountOfName");
        query.setParameter("setName", name);
        Long count = (Long) query.getSingleResult();
        entityManager.close();
        return count;
    }

    @Override
    public Long getCountOfEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getCountOfEmail");
        query.setParameter("setEmail", email);
        Long count = (Long) query.getSingleResult();
        entityManager.close();
        return count;
    }

    @Override
    public Long getCountOfPhone(String phone) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getCountOfPhone");
        query.setParameter("setPh", phone);
        Long count = (Long) query.getSingleResult();
        entityManager.close();
        return count;
    }

    @Override
    public Long getCountOfAlterEmail(String alterEmail) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getCountOfAlterEmail");
        query.setParameter("setAlterEmail", alterEmail);
        Long count = (Long) query.getSingleResult();
        entityManager.close();
        return count;
    }

    @Override
    public Long getCountOfAlterPhone(String alterPhone) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("getCountOfAlterPhone");
        query.setParameter("setAlterPhone", alterPhone);
        Long count = (Long) query.getSingleResult();
        entityManager.close();
        return count;
    }

    @Override
    public CommonModuleEntity onSignin(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("getValue");
            query.setParameter("email", email);
            CommonModuleEntity entity = (CommonModuleEntity) query.getSingleResult();

            if (entity != null) {
                if (entity.getSigninCount() >= 3) {
                    LocalDateTime now = LocalDateTime.now();
                    if (entity.getLoginTime() != null && entity.getLoginTime().plusHours(24).isBefore(now)) {
                        entity.setSigninCount(0);
                        entity.setLoginTime(null);
                        onUpdate(entity);
                    } else {
                        return null;
                    }
                }
            }
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public CommonModuleEntity getData(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("getValue");
            query.setParameter("email", email);
            return (CommonModuleEntity) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean onUpdate(CommonModuleEntity commonModuleEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            log.info("Updating entity: email={}, signinCount={}, loginTime={}",
                    commonModuleEntity.getEmail(),
                    commonModuleEntity.getSigninCount(),
                    commonModuleEntity.getLoginTime());
            entityManager.merge(commonModuleEntity);
            transaction.commit();
            log.info("Entity updated successfully for email: {}", commonModuleEntity.getEmail());
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            log.error("Error while updating entity: {}", e.getMessage());
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean updateDetailsByName(CommonModuleEntity commonModuleEntity,String filePath) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Query query = entityManager.createNamedQuery("updateDetailsByName");
            query.setParameter("name",commonModuleEntity.getName());
            query.setParameter("ph", commonModuleEntity.getPh());
            query.setParameter("alterEmail", commonModuleEntity.getAlterEmail());
            query.setParameter("alterPh", commonModuleEntity.getAlterPh());
            query.setParameter("location", commonModuleEntity.getLocation());
            query.setParameter("email", commonModuleEntity.getEmail());
            query.setParameter("filePathBy",filePath);
            query.setParameter("updatedOn", LocalDateTime.now());
            query.setParameter("updatedBy",commonModuleEntity.getName());
            System.out.println("entityyyyyyyy"+commonModuleEntity);
            int updatedRows = query.executeUpdate();
            transaction.commit();
            return updatedRows > 0;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

}
