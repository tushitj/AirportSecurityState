package airportSecurityState.util;

import java.time.LocalTime;

public class PassengerData {
    private int day;
    private LocalTime time;
    private String airline;
    private String item;

    public PassengerData(int dayI, LocalTime timeI, String airlineI, String itemI){
        this.day = dayI;
        this.time = timeI;
        this.airline = airlineI;
        this.item = itemI;
    }
    public int getDay() {
        return day;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getAirline() {
        return airline;
    }

    public String getItem() {
        return item;
    }
}
