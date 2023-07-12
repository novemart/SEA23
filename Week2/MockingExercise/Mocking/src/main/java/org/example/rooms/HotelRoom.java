package org.example.rooms;

import org.example.PricingService;

public abstract class HotelRoom {

    private int guests;

    private boolean isAvailable;

    private PricingService pricingService;

    private double rate;

    public HotelRoom(PricingService pricingService, double rate){
        this.pricingService = pricingService;
        this.rate = rate;
    }

    public double bookRoom(int numberOfGuests, int numberOfNights){
        return this.pricingService.getPrice(rate, numberOfGuests, numberOfNights);
    };

}
