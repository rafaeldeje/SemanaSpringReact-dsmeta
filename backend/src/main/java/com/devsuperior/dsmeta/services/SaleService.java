package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service // Com essa anotação, ele está fazendo com que o SaleService seja Identificado como Serviço para Spring
public class SaleService {

    @Autowired //Faz uma importação automatica;
    private SaleRepository repository;

    public List<Sale> findSales() {
        return repository.findAll();
    }

    public Page<Sale> findSalesPage(Pageable pageable){
        return repository.findAll(pageable);
        // Retornando um exemplo com Pageable;
    }

    public Page<Sale> findSalesDate(String minDate, String maxDate, Pageable pageable){

        LocalDate DataAtual = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate min = minDate.equals("") ? DataAtual.minusDays(365) :LocalDate.parse(minDate); // Vai converter a data em forma de texto, para a forma do Local Date
        LocalDate max = maxDate.equals("") ? DataAtual : LocalDate.parse(maxDate); //

        return repository.findSalesDate(min, max, pageable);
    }


}
