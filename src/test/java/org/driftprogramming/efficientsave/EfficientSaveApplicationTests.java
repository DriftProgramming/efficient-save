package org.driftprogramming.efficientsave;

import org.driftprogramming.efficientsave.repo.OrderRepo;
import org.driftprogramming.efficientsave.repo.CompanyRepo;
import org.driftprogramming.efficientsave.service.BatchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EfficientSaveApplicationTests {
    @Autowired
    BatchService batchService;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    CompanyRepo companyRepo;

    @Test
    void delete_all() {
        orderRepo.deleteAll();
        companyRepo.deleteAll();
    }


    @Test
    void test_save_orders() throws Exception {
        batchService.saveOrders();
    }

    @Test
    void test_save_companies() throws Exception {
        batchService.saveCompanies();
    }
}
