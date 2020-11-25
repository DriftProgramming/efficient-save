package org.driftprogramming.efficientsave.repo;

import org.driftprogramming.efficientsave.batch.BatchRepository;
import org.driftprogramming.efficientsave.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long>, BatchRepository<Company> {
}
