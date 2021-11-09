package com.ciclo3.ciclo3.model.assets;

import com.ciclo3.ciclo3.model.Client;

public class TopClients {

    private Long count;
    private Client client;

    public TopClients(Long count, Client client) {
        this.count = count;
        this.client = client;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
