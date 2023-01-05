package it.poliba.is45.ecoshipping.service;

import it.poliba.is45.ecoshipping.repository.OrdineRepository;
import it.poliba.is45.ecoshipping.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinQueryService {




    //https://roytuts.com/spring-boot-data-jpa-left-right-inner-and-cross-join-examples/
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private OrdineRepository ordineRepository;
/*
    public List<ClienteOrdineDto> getUsOrdersInnerJoin() {
        List<ClienteOrdineDto> clienteOrdineDtoList = utenteRepository.fetchUtenteOrdinidataInnerJoin();
        // clienteOrdineDtoList.forEach(System.out::println);
        return clienteOrdineDtoList;
    }

 */



}
