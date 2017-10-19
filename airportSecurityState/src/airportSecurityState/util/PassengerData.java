package airportSecurityState.util;

import java.time.LocalTime;

public class PassengerData {
    private int day;
    private LocalTime time;
    private String airline;
    private String item;

    public PassengerData(int dayI, LocalTime timeI, String airlineI, String itemI) {
        this.day = dayI;
        this.time = timeI;
        this.airline = airlineI;
        this.item = itemI;
        MyLogger.writeMessage("PassengerData class constructor.", MyLogger.DebugLevel.CONSTRUCTOR);
        if (item.equalsIgnoreCase("nailcutter") || item.equalsIgnoreCase("knife") || item.equalsIgnoreCase("gun") || item.equalsIgnoreCase("blade")) {
            MyLogger.writeMessage("Prohibited item " + item + " came in.", MyLogger.DebugLevel.IN_RESULTS);
        }
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
            String str = "";
            time = LocalTime.parse(getValue("TOD", words));
            airline = getValue("Airline", words);
            item = getValue("Item", words);
            return new PassengerData(day, time, airline, item);
        }
        return null;
    }

    static String getValue(String key, String[] sarr) {

        for (int i = 0; i < sarr.length; i++) {

            if (sarr[i].toLowerCase().contains(key.toLowerCase())) {
                if (key.equalsIgnoreCase("tod")) {
                    return sarr[i].split(":")[1] + ":" + sarr[i].split(":")[2];
                }
                else
                    return sarr[i].split(":")[1];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return day + " " + item;
    }
}
