package com.sda.travel_agency.service;

import com.sda.travel_agency.dto.TripDto;
import com.sda.travel_agency.entity.Airport;
import com.sda.travel_agency.entity.Country;
import com.sda.travel_agency.entity.Hotel;
import com.sda.travel_agency.entity.Trip;
import com.sda.travel_agency.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;
    private final AirportService airportService;
    private final HotelService hotelService;

    public void createOrUpdateTripForCountry(TripDto tripDto){
        Optional<Airport> airportFlyOut = airportService.findAirportById(tripDto.getFromAirport());
        Optional<Airport> airportFlyBack = airportService.findAirportById(tripDto.getToAirport());
        Optional<Hotel> hotel = hotelService.findHotelById(tripDto.getHotel());

        Trip newTrip = new Trip();
        airportFlyOut.ifPresent(newTrip::setFromAirport);
        airportFlyBack.ifPresent(newTrip::setToAirport);
        hotel.ifPresent(newTrip::setHotel);
        newTrip.setAdultPrice(tripDto.getAdultPrice());
        newTrip.setChildPrice(tripDto.getChildPrice());
        newTrip.setFlyBack(tripDto.getFlyBack());
        newTrip.setFlyOut(tripDto.getFlyOut());
        newTrip.setMealsType(tripDto.getMealsType());
        newTrip.setSeatsNumber(tripDto.getSeatsNumber());
        newTrip.setPromoted(tripDto.isPromoted());
        tripRepository.save(newTrip);
    }


    public Iterable<Trip>  getAllTrip(){
        return tripRepository.findAll();
    }

    public void editTrip (Trip trip){
        tripRepository.save(trip);
    }

    public void deleteById (Long tripId){
        tripRepository.deleteById(tripId);
    }

}
