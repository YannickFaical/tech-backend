package com.tech.techbackend.service;

import com.tech.techbackend.entities.Client;
import com.tech.techbackend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

  //pour linjection de dependance en passant par le constructeur
   private  ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void creer(@RequestBody Client client){
      Client clientDansLaBDD =  this.clientRepository.findByEmail(client.getEmail());
      if (clientDansLaBDD ==null){


        this.clientRepository.save(client);
      }
    }

    public List<Client> rechercher(){
        return this.clientRepository.findAll();
    }

    public Client lire(int id) {
        Optional<Client>  optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElse(null);
    }

    public Client lireOuCreer(Client clientAcreer){
        Client clientDansLaBDD =  this.clientRepository.findByEmail(clientAcreer.getEmail());
        if (clientDansLaBDD ==null){
         clientDansLaBDD =  this.clientRepository.save(clientAcreer);
        }
        return clientDansLaBDD;

    }

    public void modifier(int id, Client client) {
       Client clientDansLaBDD = this.lire(id);
       if(clientDansLaBDD.getId()== client.getId()){
           clientDansLaBDD.setEmail(client.getEmail());
           clientDansLaBDD.setTelephone(client.getTelephone());
           this.clientRepository.save(clientDansLaBDD);
       }
    }
}
