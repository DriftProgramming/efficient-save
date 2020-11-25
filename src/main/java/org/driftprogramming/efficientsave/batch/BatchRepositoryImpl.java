package org.driftprogramming.efficientsave.batch;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

@Repository
public class BatchRepositoryImpl<T> implements BatchRepository<T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public <S extends T> void insertInBatch(List<S> list) {
        if (!ObjectUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                entityManager.persist(list.get(i));
                if (i % 50 == 0) {
                    entityManager.flush();
                    entityManager.clear();
                }
            }
            entityManager.flush();
            entityManager.clear();
        }
    }

    @Override
    public <S extends T> void updateInBatch(List<S> list) {
        if (!ObjectUtils.isEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                entityManager.merge(list.get(i));
                if (i % 50 == 0) {
                    entityManager.flush();
                    entityManager.clear();
                }
            }
            entityManager.flush();
            entityManager.clear();
        }
    }
}