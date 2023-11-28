package com.tech.techbackend.service;

import com.tech.techbackend.entities.Client;
import com.tech.techbackend.entities.Sentiment;
import com.tech.techbackend.enums.TypeSentiment;
import com.tech.techbackend.repository.SentimentReposittory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentimentService {
    private  ClientService clientService;
    private SentimentReposittory sentimentReposittory;

    public SentimentService(ClientService clientService, SentimentReposittory sentimentReposittory) {
        this.clientService = clientService;
        this.sentimentReposittory = sentimentReposittory;
    }

    public void creer(Sentiment sentiment){
        Client client = this.clientService.lireOuCreer(sentiment.getClient());
        sentiment.setClient(client);

        //Analyse
        if (sentiment.getTexte().contains("pas")){
            sentiment.setType(TypeSentiment.NEGATIF);
        }else {
            sentiment.setType(TypeSentiment.POSITIF);
        }
        this.sentimentReposittory.save(sentiment);
    }

    public List<Sentiment> rechercher(TypeSentiment type) {
        if (type == null) {
            return this.sentimentReposittory.findAll();
        }else {
            return this.sentimentReposittory.findByType(type);
        }
    }

    public void supprimer(int id) {
        this.sentimentReposittory.deleteById(id);
    }
}
