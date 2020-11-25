## How it works

Add this two files in your project:

- src/main/java/org/driftprogramming/efficientsave/batch/BatchRepository.java
- src/main/java/org/driftprogramming/efficientsave/batch/BatchRepositoryImpl.java


## How to use it
1.Assuming we have a BizOrder Entity like this:
```aidl
@Entity
public class BizOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

2.Create JPA Repository
Please make sure we extends our `BatchRepository<T>` as well.
```aidl
@Repository
public interface OrderRepo extends JpaRepository<BizOrder, Long>, BatchRepository<BizOrder> {
}
```

3.Integrate with service
Please make sure we have a `@Transactional` annotation onto the method, *it is REQUIRED*.
```aidl
@Service
public class BatchService {

    @Autowired
    OrderRepo orderRepo;

    @Transactional
    public void saveOrders() throws Exception {
        Integer companyNumber = 10000;
        List<BizOrder> orders = this.generateListOrders(companyNumber);
        orderRepo.insertInBatch(orders, 50);
        // throw new RuntimeException("exception message"); this will rollback this transaction
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
```

