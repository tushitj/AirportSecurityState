package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class LOW_RISK implements AirportStateI {
    AirportRiskContext airportRiskContext;
    public LOW_RISK(AirportRiskContext state){
        this.airportRiskContext = state;
        MyLogger.writeMessage("LOW_RISK_STATE class constructor." , MyLogger.DebugLevel.CONSTRUCTOR);
    }

    /**
     * LOW_RISK
     *0 ≤ average traffic per day < 4 OR
     *0 ≤ average prohibited items per day < 1
     */
    @Override
    public void operationsToDo(AverageData data) {
        // int avgTrafficPerDay = AirportRiskContext.avgTrafficPerDay;
        //int avgProhibitedItemPerDay = AirportRiskContext.avgProhibitedItemPerDay;

        int avgTrafficPerDay = data.getAvgTrafficPerDay();
        int avgProhibitedItemPerDay = data.getAvgProhibitedItemPerDay();

        if( avgTrafficPerDay>=4 || avgProhibitedItemPerDay>=1)
            airportRiskContext.setState(airportRiskContext.getModerateRisk());
    }

    public String toString(){
        return "1 3 5 7 9";
    }
}
