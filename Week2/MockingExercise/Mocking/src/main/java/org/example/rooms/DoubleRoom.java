package org.example.rooms;

import org.example.PricingService;

public class DoubleRoom extends HotelRoom{

    private boolean hasView;


    public DoubleRoom(PricingService pricingService, double rate, boolean hasView) {
        super(pricingService, rate);
        this.hasView = hasView;
    }

    public double bookRoom(int numberOfGuests, int numberOfNights){
        if (hasView){
            return 1.2*super.bookRoom(numberOfGuests, numberOfNights);
        }
        else if (numberOfGuests <2 ){
            return 0.8 * super.bookRoom(numberOfGuests, numberOfNights);
        }
        else{
            return super.bookRoom(numberOfGuests, numberOfNights);
        }
    }
}
