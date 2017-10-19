package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class AverageData {
    private int avgTrafficPerDay;
    private int avgProhibitedItemPerDay;

    public AverageData(int avgTrafficPerDayI,int avgProhibitedItemPerDayI){
        this.avgTrafficPerDay = avgTrafficPerDayI;
        this.avgProhibitedItemPerDay =avgProhibitedItemPerDayI;
        MyLogger.writeMessage("AverageData class constructor." , MyLogger.DebugLevel.CONSTRUCTOR);
    }

    public int getAvgTrafficPerDay() {
        return avgTrafficPerDay;
    }

    public int getAvgProhibitedItemPerDay() {
        return avgProhibitedItemPerDay;
    }
}
