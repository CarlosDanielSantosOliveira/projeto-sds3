package com.devsuperior.dsvendas.services;

import com.devsuperior.dsvendas.domain.entities.Sale;
import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SaleService {

     @Autowired
     private SaleRepository saleRepository;

     @Autowired
     private SellerRepository sellerRepository;

     @Transactional(readOnly = true) //Isso vai garantir que toda operação com o banco seja resolvida
     public Page<SaleDTO> findAll(Pageable pageable) { //Usamos esse objeto para trabalhar com paginação, para no frontend, trazermos uma pagina de resultados
         sellerRepository.findAll(); // Dessa forma a jpa armazena os vendedores em cash e quando eu for buscar as vendas que dependem desses vendedores, eles ja vao estar em memória
         Page<Sale> result = saleRepository.findAll(pageable);
         return result.map(x -> new SaleDTO(x)); //Convertendo a lista de Sale para SaleDTO com expressão lambda
     }
     //Usando o Pageable, ja fazemos uma busca paginada.



}
