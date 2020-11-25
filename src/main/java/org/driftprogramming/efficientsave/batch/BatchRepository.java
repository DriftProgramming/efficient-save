package org.driftprogramming.efficientsave.batch;

import java.util.List;

public interface BatchRepository<T> {
    <S extends T> void insertInBatch(List<S> list, int batchSize);

    <S extends T> void saveInBatch(List<S> list, int batchSize);
}