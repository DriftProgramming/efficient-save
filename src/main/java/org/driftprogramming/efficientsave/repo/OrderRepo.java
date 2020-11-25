package org.driftprogramming.efficientsave.repo;

import org.driftprogramming.efficientsave.batch.BatchRepository;
import org.driftprogramming.efficientsave.model.BizOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<BizOrder, Long>, BatchRepository<BizOrder> {
}
