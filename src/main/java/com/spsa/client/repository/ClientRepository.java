package com.spsa.client.repository;

import com.github.fabiomaffioletti.firebase.repository.DefaultFirebaseRealtimeDatabaseRepository;
import com.spsa.client.model.Client;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository extends DefaultFirebaseRealtimeDatabaseRepository<Client, String> {

    public Double calculateAverageAge(){
        List<Client> list = findAll();
        double total = 0;
        double count = 0;
        double average = 0;
        for(Client client:  list) {
            double rating = client.getAge();
            total = total + rating;
            count = count + 1;
            average = total / count;
        }
        return average;
    };
}
