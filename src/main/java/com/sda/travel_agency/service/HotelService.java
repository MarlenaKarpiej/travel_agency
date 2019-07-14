package com.sda.travel_agency.service;

import com.sda.travel_agency.entity.City;
import com.sda.travel_agency.entity.Country;
import com.sda.travel_agency.entity.Hotel;
import com.sda.travel_agency.repository.CityRepository;
import com.sda.travel_agency.repository.CountryRepository;
import com.sda.travel_agency.repository.HotelRepisitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepisitory hotelRepisitory;
    private final CityService cityService;

    public void createOrUpdateHotelForCity(Hotel hotel, Long cityId){
        Optional<City> city = cityService.findCityById(cityId);
        city.ifPresent(hotel::setCity);
        hotelRepisitory.save(hotel);
    }

    public Iterable<Hotel> getAllHotel(){
        return hotelRepisitory.findAll();
    }


    public List<Hotel> findAllByHotelNameContaining(String hotelName){
        return hotelRepisitory.findByHotelNameContaining(hotelName);
    }

    public void deleteById (Long id){
        hotelRepisitory.deleteById(id);
    }

    public Optional<Hotel> findHotelById(Long hotelId){
        return hotelRepisitory.findById(hotelId);
    }

    public List<Hotel> findHotelByCity(City cityById) {
        return hotelRepisitory.findByCity(cityById);
    }

    public List<Hotel> findAllHotels() {
        return hotelRepisitory.findAll();
    }
}
