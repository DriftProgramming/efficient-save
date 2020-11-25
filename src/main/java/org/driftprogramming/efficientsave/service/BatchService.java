package org.driftprogramming.efficientsave.service;

import org.driftprogramming.efficientsave.model.BizOrder;
import org.driftprogramming.efficientsave.model.Branch;
import org.driftprogramming.efficientsave.model.Company;
import org.driftprogramming.efficientsave.repo.OrderRepo;
import org.driftprogramming.efficientsave.repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

@Service
public class BatchService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    CompanyRepo companyRepo;

    @Transactional
    public void saveOrders() throws Exception {
        StopWatch stopWatch = new StopWatch("SaveAllTaskStopWatch");
        Integer companyNumber = 10000;
        List<BizOrder> orders = this.generateListOrders(companyNumber);

        stopWatch.start("task-SaveAll");

        orderRepo.insertInBatch(orders);

        stopWatch.stop();

        System.out.println("SaveAll took total: " + stopWatch.getTotalTimeSeconds() + " seconds with " + orders.size() + " entities");
        // throw new RuntimeException("xxxx");
    }


    @Transactional(rollbackFor = Exception.class)
    public void saveCompanies() throws Exception {
        StopWatch stopWatch = new StopWatch("SaveAllTaskStopWatch");
        Integer companyNumber = 1000;
        Integer branchNumber4EachCompany = 10;
        List<Company> companies = this.generateListCompanies(companyNumber, branchNumber4EachCompany);

        stopWatch.start("task-SaveAll");

        companyRepo.insertInBatch(companies);

        stopWatch.stop();

        System.out.println("SaveAll took total: " + stopWatch.getTotalTimeSeconds() + " seconds with " + companies.size() + " entities");
        //        throw new RuntimeException("xxxx");
    }


    List<Company> generateListCompanies(Integer companyNumber, Integer branchNumber4EachCompany) {
        List<Company> companies = new ArrayList<>();
        for (int i = 0; i < companyNumber; i++) {
            Company company = new Company();
            company.setName("company" + i);
            List<Branch> branches = new ArrayList<>();
            for (int j = 0; j < branchNumber4EachCompany; j++) {
                Branch branch = new Branch("branch" + j);
                branches.add(branch);
            }

            company.setBranch(branches);
            companies.add(company);
        }

        return companies;
    }


    List<BizOrder> generateListOrders(Integer companyNumber) {
        List<BizOrder> companies = new ArrayList<>();
        for (int i = 0; i < companyNumber; i++) {
            BizOrder company = new BizOrder();
            company.setName("company" + i);
            companies.add(company);
        }

        return companies;
    }
}