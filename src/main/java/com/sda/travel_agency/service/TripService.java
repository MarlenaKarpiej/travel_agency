package com.sda.travel_agency.service;

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

    public void createOrUpdateTripForCountry(Trip trip, Long fromAirportId, Long toAirportId, Long hotelId){
        Optional<Airport> airportFlyOut = airportService.findAirportById(fromAirportId);
        Optional<Airport> airportFlyBack = airportService.findAirportById(toAirportId);
        Optional<Hotel> hotel = hotelService.findHotelById(hotelId);
        airportFlyOut.ifPresent(trip::setFromAirport);
        airportFlyBack.ifPresent(trip::setToAirport);
        hotel.ifPresent(trip::setHotel);
        tripRepository.save(trip);
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
