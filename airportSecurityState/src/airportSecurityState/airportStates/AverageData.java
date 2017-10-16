package airportSecurityState.airportStates;

public class AverageData {
    private int avgTrafficPerDay;
    private int avgProhibitedItemPerDay;

    public AverageData(int avgTrafficPerDayI,int avgProhibitedItemPerDayI){
        this.avgTrafficPerDay = avgTrafficPerDayI;
        this.avgProhibitedItemPerDay =avgProhibitedItemPerDayI;
    }

    public int getAvgTrafficPerDay() {
        return avgTrafficPerDay;
    }

    public int getAvgProhibitedItemPerDay() {
        return avgProhibitedItemPerDay;
    }
}
