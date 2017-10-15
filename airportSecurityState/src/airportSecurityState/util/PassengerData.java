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

    public static PassengerData parser(String input) {
        int day;
        LocalTime time;
        String airline;
        String item;

        String[] words = input.split(";");
        //code
        if (words.length == 4) {
            day = Integer.parseInt(getValue("day", words));
            String str ="";
            time = LocalTime.parse((str = getValue("TOD", words))+":"+getValue(str,words));

            airline = getValue("Airline", words);

            item = getValue("Item", words);
            return new PassengerData(day,time,airline,item);
        }
        return null;
    }

    static String getValue(String key, String[] sarr) {
        for (int i = 0; i < sarr.length ; i++) {
            if (sarr[i].toLowerCase().contains(key.toLowerCase()))
                return sarr[i].split(":")[1];
        }
        return null;
    }

    @Override
    public String toString() {
        return day + " " + item;
    }
}
