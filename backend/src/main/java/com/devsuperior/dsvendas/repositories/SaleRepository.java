package com.devsuperior.dsvendas.repositories;

import com.devsuperior.dsvendas.domain.entities.Sale;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.devsuperior.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))"
            + " FROM Sale As obj GROUP BY obj.seller")//No parenteses vamos colocar a nossa consulta especifica, pode ser escrita com SQL raiz, porem vamos usar a JPQL
        //Nesse caso aqui eu estou querendo uma busca agrupada, onde o resutltado vai ser uma lista de objetos do tipo SaleSUmDTO, entao
        //Nesse caso a busca agrupada exige que voce coloque o tipo pelo qual voce esta agrupando, mas exige com todoo o caminho do pacote
    List<SaleSuccessDTO> successtGroupedBySeller(); //quantia vendida, agrupada por vendedor

    //Fizemos tudo isso, para criar uma requisição, onde vamos pegar todas as vendas de um vendedor e somar o total de quanto ele vendeu em dinheiro

    @Query("SELECT new com.devsuperior.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))"
            + " FROM Sale As obj GROUP BY obj.seller")
    List<SaleSumDTO> amountGroupedBySeller(); //Taxa de sucesso de vendas

}
