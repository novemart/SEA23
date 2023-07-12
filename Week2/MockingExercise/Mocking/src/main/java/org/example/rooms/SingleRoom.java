package org.example.rooms;

import org.example.PricingService;

public class SingleRoom extends HotelRoom{

    private boolean hasBalcony;

    public SingleRoom(PricingService pricingService, double rate, boolean hasBalcony) {
        super(pricingService, rate);
        this.hasBalcony = hasBalcony;
    }

    public double bookRoom(int numberOfGuests, int numberOfNights){
        if (hasBalcony){
            return super.bookRoom(numberOfGuests, numberOfNights);
        }
        else{
            return 0.95 * super.bookRoom(numberOfGuests, numberOfNights);
        }
    }
}
