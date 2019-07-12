package com.spsa.client.controller;

import com.spsa.client.model.Client;
import com.spsa.client.model.Kpi;
import com.spsa.client.repository.ClientRepository;
import com.spsa.client.service.WorldPopulationService;
import com.spsa.client.util.DateUtils;
import com.spsa.client.util.MathUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Controller
public class ClientController {

    private final ClientRepository clientRepository;
    private final WorldPopulationService worldPopulationService;
    private RestTemplate firebaseConnection;

    public ClientController(final ClientRepository clientRepository,
                            final WorldPopulationService worldPopulationService,
                            final RestTemplate firebaseConnection) {
        this.clientRepository = clientRepository;
        this.worldPopulationService = worldPopulationService;
        this.firebaseConnection = firebaseConnection;
    }

    public Client newClient(Client newClient) {
        GregorianCalendar calendarGregorian = new GregorianCalendar();
        Double totalLifeExpectancy = worldPopulationService.getTotalLifeExpectancy(newClient);
        Integer years = totalLifeExpectancy.intValue();
        double daysDecimals = totalLifeExpectancy - years.doubleValue();
        Calendar dateCalendar = DateUtils.dateToCalendar(newClient.getBirthday());
        dateCalendar.add(Calendar.YEAR, totalLifeExpectancy.intValue());
        if (calendarGregorian.isLeapYear(dateCalendar.get(Calendar.YEAR))) {
            daysDecimals = daysDecimals * 366;
        } else {
            daysDecimals = daysDecimals * 365;
        }
        dateCalendar.add(Calendar.DATE, (int) Math.round(daysDecimals));
        newClient.setProbableDeathDate(dateCalendar.getTime());
        return clientRepository.push(newClient);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public void deleteAllClients(){
        clientRepository.removeAll();
    }

    public Kpi getKpiClientes() {
        Kpi kpi = new Kpi();
        kpi.setAverageAge(clientRepository.calculateAverageAge());
        kpi.setStandardDeviation(calculateStandardDeviationAge(clientRepository.findAll(),kpi.getAverageAge()));
        return kpi;
    }

    private Double calculateStandardDeviationAge(List<Client> clients, Double media){
        return MathUtils.deviation(getArrayAges(clients),media);
    }

    private double[] getArrayAges (List<Client> clients){
        double[] arrayAges = new double[clients.size()];
        int i = 0;
        for (Client client : clients) {
            arrayAges[i] = client.getAge();
            i++;
        }
        return arrayAges;
    }

}
