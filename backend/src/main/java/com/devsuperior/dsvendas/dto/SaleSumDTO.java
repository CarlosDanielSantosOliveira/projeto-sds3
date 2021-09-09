package com.devsuperior.dsvendas.dto;

import com.devsuperior.dsvendas.domain.entities.Seller;

import java.io.Serializable;

public class SaleSumDTO implements Serializable {

    private static final long seriaLVersionUID = 1L;

    private String sellerName;
    private Double sum;

    public SaleSumDTO(){

    }

    public SaleSumDTO(Seller seller, Double sum) { //Vamos usar o Seller porque na hora de agrupar os dados na consulta, eu vou ter que agrupar por seller, nao tem como eu agrupar so pelo nome, isso nao funciona no postman
        this.sellerName = seller.getName();
        this.sum = sum;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    //Agora vamos ter que implementar uma consulta agrupada para buscar essa soma no banco de dados
}
