package com.example.attachapp.ressources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mybank")
public class BankController {

    @Autowired TransferService service;

    @PostMapping("/account/{from}/transfer")
    public void transfert(@PathVariable("from") String from, @RequestParam("to") String to ,@RequestParam("amount") Long amount){
        service.transfer(from,to,amount);
    }
}


@Service
class TransferService {

    void transfer(String from , String to , Long amount){
        System.out.println("Succesfully transfered $"+amount+" from : "+from+" to : "+to);
    }
}
