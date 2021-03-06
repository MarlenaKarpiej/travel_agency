package com.sda.travel_agency.service;

import com.sda.travel_agency.dto.TripDto;
import com.sda.travel_agency.entity.Airport;
import com.sda.travel_agency.entity.Hotel;
import com.sda.travel_agency.entity.Trip;
import com.sda.travel_agency.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;
    private final AirportService airportService;
    private final HotelService hotelService;

    public void createOrUpdateTripForCountry(TripDto tripDto, MultipartFile file) throws IOException {
        Optional<Airport> airportFlyOut = airportService.findAirportById(tripDto.getFromAirport());
        Optional<Airport> airportFlyBack = airportService.findAirportById(tripDto.getToAirport());
        Optional<Hotel> hotel = hotelService.findHotelById(tripDto.getHotel());

        byte[] bytes = file.getBytes();

        Trip newTrip = new Trip();
        newTrip.setData(bytes);
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


    public int getNumberOfTakenSeats(Long tripId) {
        Integer result = tripRepository.findHowManyPurchasesWereMade(tripId);
        if (result == null) {
            return 0;
        }
        return result;
    }

    public Page<Trip> getAllTrip(Pageable pageable) {
        return tripRepository.findAll(pageable);
    }

    public void editTrip(Trip trip) {
        tripRepository.save(trip);
    }

    public void deleteById(Long tripId) {
        tripRepository.deleteById(tripId);
    }

    public Optional<Trip> findTripById(Long tripId) {
        return tripRepository.findById(tripId);
    }

    public TripDto editTrip(Long id) {
        Optional<Trip> maybeTrip = tripRepository.findById(id);
        if (maybeTrip.isPresent()) {
            Trip editedTrip = maybeTrip.get();

            TripDto tripDto = new TripDto();

            tripDto.setFromAirport(editedTrip.getFromAirport().getId());
            tripDto.setToAirport(editedTrip.getToAirport().getId());
            tripDto.setHotel(editedTrip.getHotel().getId());
            tripDto.setFlyOut(editedTrip.getFlyOut());
            tripDto.setFlyBack(editedTrip.getFlyBack());
            tripDto.setMealsType(editedTrip.getMealsType());
            tripDto.setAdultPrice(editedTrip.getAdultPrice());
            tripDto.setChildPrice(editedTrip.getChildPrice());
            tripDto.setPromoted(editedTrip.isPromoted());
            tripDto.setSeatsNumber(editedTrip.getSeatsNumber());
            return tripDto;
        }
        throw new EntityNotFoundException("ni ma");
    }

    public void editTrip(Long editedIdentifier, TripDto dto, MultipartFile file) throws IOException {
        Optional<Trip> editedTrip = tripRepository.findById(editedIdentifier);
        if (editedTrip.isPresent()) {
            Trip trip = editedTrip.get();

            byte[] bytes = file.getBytes();

            Trip newTrip = new Trip();
            newTrip.setData(bytes);

            trip.setFromAirport(airportService.findAirportById(dto.getFromAirport()).get());
            trip.setToAirport(airportService.findAirportById(dto.getToAirport()).get());
            trip.setHotel(hotelService.findHotelById(dto.getHotel()).get());
            trip.setFlyOut(dto.getFlyOut());
            trip.setFlyBack(dto.getFlyBack());
            trip.setMealsType(dto.getMealsType());
            trip.setAdultPrice(dto.getAdultPrice());
            trip.setChildPrice(dto.getChildPrice());
            trip.setPromoted(dto.isPromoted());
            trip.setSeatsNumber(dto.getSeatsNumber());

            tripRepository.save(trip);
        }
    }

}
