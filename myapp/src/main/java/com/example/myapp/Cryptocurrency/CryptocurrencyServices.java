package com.example.myapp.Cryptocurrency;

public class CryptocurrencyServices {
    private final CryptocurrencyRepository cryptocurrencyRepository;

    public CryptocurrencyServices(CryptocurrencyRepository cryptocurrencyRepository) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
    }

    public Iterable<Cryptocurrency> getAllCryptocurrencies() {
        return cryptocurrencyRepository.findAll();
    }

    public Cryptocurrency getCryptocurrencyById(int id) {
        return cryptocurrencyRepository.findById(id).orElse(null);
    }

    public Cryptocurrency addCryptocurrency(Cryptocurrency cryptocurrency) {
        return cryptocurrencyRepository.save(cryptocurrency);
    }

    public Cryptocurrency updateCryptocurrency(int id, Cryptocurrency cryptocurrency) {
        Cryptocurrency cryptocurrencyToUpdate = cryptocurrencyRepository.findById(id).orElse(null);
        if (cryptocurrencyToUpdate == null) {
            return null;
        }
        cryptocurrencyToUpdate.setName(cryptocurrency.getName());
        cryptocurrencyToUpdate.setSymbol(cryptocurrency.getSymbol());
        cryptocurrencyToUpdate.setPrice(cryptocurrency.getPrice());
        return cryptocurrencyRepository.save(cryptocurrencyToUpdate);
    }

    public void deleteCryptocurrency(int id) {
        cryptocurrencyRepository.deleteById(id);
    }
}
