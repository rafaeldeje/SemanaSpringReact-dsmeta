package com.devsuperior.dsmeta.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity // Preperando para tornar a Classe em uma Tabela no Banco (Anotação JPA);
@Table(name = "tb_sales") //Costumizando o Nome da Tabela que será criada no Banco de Dados;
public class Sale {
    @Id // Definindo que o atribudo id, será um identificador Unico na Tabela no banco de Dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Intruindo que o valor Gerado será baseado em Identidade-
    private Long id;
    private String sellerName;
    private Integer visited;
    private Integer deals;
    private Double amount;
    private LocalDate date;
    public Sale() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Integer getVisited() {
        return visited;
    }

    public void setVisited(Integer visited) {
        this.visited = visited;
    }

    public Integer getDeals() {
        return deals;
    }

    public void setDeals(Integer deals) {
        this.deals = deals;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
