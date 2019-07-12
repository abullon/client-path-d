package com.spsa.client.service;

import com.spsa.client.controller.ClientController;
import com.spsa.client.model.Client;
import com.spsa.client.model.Kpi;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientService {

    private final ClientController clientController;

    public ClientService(final ClientController clientController) {
        this.clientController = clientController;
    }

	@CrossOrigin(origins = "https://path-d-frontend.firebaseapp.com")
    @PostMapping("/creacliente")
    Client newClient(@RequestBody Client client) {
        return clientController.newClient(client);
    }

	@CrossOrigin(origins = "https://path-d-frontend.firebaseapp.com")
    @GetMapping("/listclientes")
    public List<Client> getAllClients() {
        return clientController.getAllClients();
    }

	@CrossOrigin(origins = "https://path-d-frontend.firebaseapp.com")
    @DeleteMapping("/deleteAllClients")
    public void deleteAllClients() {
        clientController.deleteAllClients();
    }

	@CrossOrigin(origins = "https://path-d-frontend.firebaseapp.com")
    @GetMapping("/kpideclientes")
    public Kpi getKpiClientes() {
        return clientController.getKpiClientes();
    }
}
