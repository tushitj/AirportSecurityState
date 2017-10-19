package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;
import airportSecurityState.util.PassengerData;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AverageCalculator {
    private int passenger;
    private int avgTrafficPerDay;
    private int avgProhibitedItemPerDay;
    private int prohibitedItem;
    private Set<Integer> daysSet;
    private List<String> prohibitedItems;

    public AverageCalculator(){
        this.daysSet = new TreeSet<>();
        prohibitedItems = new ArrayList<>();
        prohibitedItems.add("gun");
        prohibitedItems.add("knife");
        prohibitedItems.add("nailcutter");
        prohibitedItems.add("blade");

        MyLogger.writeMessage("AverageCalculator class constructor." , MyLogger.DebugLevel.CONSTRUCTOR);
    }

    public int getAvgTrafficPerDay() {
        return avgTrafficPerDay;
    }

    public int getAvgProhibitedItemPerDay() {
        return avgProhibitedItemPerDay;
    }


    public AverageData calculate(PassengerData data){
        passenger++;
        if (checkItem(data))
            prohibitedItem++;
        daysSet.add(data.getDay());
        avgTrafficPerDay = passenger/daysSet.size();
        avgProhibitedItemPerDay = prohibitedItem/daysSet.size();
        return new AverageData(avgTrafficPerDay,avgProhibitedItemPerDay);
    }
    private boolean checkItem(PassengerData data) {
        String item = data.getItem().trim().toLowerCase();
        return prohibitedItems.contains(item);
    }
}
