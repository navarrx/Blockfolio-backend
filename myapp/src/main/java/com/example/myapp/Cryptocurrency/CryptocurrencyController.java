package com.example.myapp.Cryptocurrency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.example.myapp.Cryptocurrency.CryptocurrencyServices;

@RestController
public class CryptocurrencyController {

    @Autowired
    private CryptocurrencyRepository cryptocurrencyRepository;

    @GetMapping("/cryptocurrencies")
    public List<Cryptocurrency> getAllCryptocurrencies() {
        return (List<Cryptocurrency>) cryptocurrencyRepository.findAll();
    }

    @GetMapping("/cryptocurrencies/{id}")
    public Cryptocurrency getCryptocurrencyById(@PathVariable int id) {
        return cryptocurrencyRepository.findById(id).orElse(null);
    }

    @PostMapping("/cryptocurrencies/create")
    public Cryptocurrency createCryptocurrency(@RequestBody Cryptocurrency cryptocurrency) {
        return cryptocurrencyRepository.save(cryptocurrency);
    }


}
