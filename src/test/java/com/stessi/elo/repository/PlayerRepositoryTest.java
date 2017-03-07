package com.stessi.elo.repository;

import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author palmithor
 * @since 7.3.2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository repository;

    @Autowired
    private Flyway flyway;

    /**
     * To make sure all tests have the same data when running
     */
    @Before
    public void setUp() {
        flyway.clean();
        flyway.migrate();
    }

    @Test
    public void findAll() throws Exception {
        System.out.println("hello world");
    }

}