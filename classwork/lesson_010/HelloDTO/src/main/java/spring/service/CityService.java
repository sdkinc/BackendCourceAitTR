package spring.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.domain.City;
import spring.repository.CityRepository;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public City add(City city) {
        return cityRepository.save(city);
    }

    public City findByName(String name){
        City city = cityRepository.findByName(name);
        if (city == null) {
            city = new City(null, name);
            city = cityRepository.save(city);
        }
        return city;
    }
    public City findById(Integer id) {
        Optional<City> city =cityRepository.findById(id);
        return city.isPresent() ? city.get():null;
    }

    public City update(City city) {
        return cityRepository.save(city);
    }

    public City delete(Integer id) {
        City city =findById(id);
        if(city !=null){
            cityRepository.delete(city);
        }
        return city;
    }
}
