package com.spsa.client.controller;

import com.spsa.client.repository.ClientRepository;
import com.spsa.client.service.WorldPopulationService;
import org.junit.After;
import org.junit.Before;
import org.springframework.web.client.RestTemplate;

public class ClientControllerTest {

    private final ClientRepository clientRepository;
    private final WorldPopulationService worldPopulationService;
    private RestTemplate firebaseConnection;

    public ClientControllerTest(final ClientRepository clientRepository,
                            final WorldPopulationService worldPopulationService,
                            final RestTemplate firebaseConnection) {
        this.clientRepository = clientRepository;
        this.worldPopulationService = worldPopulationService;
        this.firebaseConnection = firebaseConnection;
    }

    @Before
    public void before() {
        System.out.println("Before");
    }

    @After
    public void after() {
        System.out.println("After");
    }
}
