package com.sda.travel_agency.repository;

import com.sda.travel_agency.entity.City;
import com.sda.travel_agency.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepisitory extends JpaRepository<Hotel, Long> {

    List<Hotel> findByHotelNameContaining(String hotelName);
    List<Hotel> findByCity(City city);
    boolean existsByHotelName(String name);
    Hotel findByHotelName(String hotelName);

}


