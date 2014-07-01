package com.rolan.examples.springtransactions;

import com.rolan.examples.springtransactions.dao.UsersDao;
import com.rolan.examples.springtransactions.service.SyncService;
import com.rolan.examples.springtransactions.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class AppTest {

    @Autowired
    private UserService userService;
    @Autowired
    private SyncService syncService;
    @Autowired
    private UsersDao userDao;
    @Autowired
    private ClearTestDataService clearTestDataService;

    @Test
    public void testCreateUser() {
        Long userId = syncService.requiresNew();
        clearTestDataService.delete(userId);
    }
}
