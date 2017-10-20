package airportSecurityState.airportStates;

import airportSecurityState.util.MyLogger;

public class HIGH_RISK implements AirportStateI {
    AirportRiskContext airportRiskContext;
    public HIGH_RISK(AirportRiskContext state){
        this.airportRiskContext = state;
        MyLogger.writeMessage("HIGH_RISK_STATE class constructor." , MyLogger.DebugLevel.CONSTRUCTOR);
    }

    @Override
    public void operationsToDo(AverageData data) {
       // int avgTrafficPerDay = AirportRiskContext.avgTrafficPerDay;
        //int avgProhibitedItemPerDay = AirportRiskContext.avgProhibitedItemPerDay;

        int avgTrafficPerDay = data.getAvgTrafficPerDay();
        int avgProhibitedItemPerDay = data.getAvgProhibitedItemPerDay();
        if( avgTrafficPerDay < 8 && avgProhibitedItemPerDay < 2)
            airportRiskContext.setState(airportRiskContext.getModerateRisk());
    }

    public String toString(){

        return "2 4 6 8 10";
    }

}
