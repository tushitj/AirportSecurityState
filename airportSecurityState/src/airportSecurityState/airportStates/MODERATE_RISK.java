package airportSecurityState.airportStates;


import airportSecurityState.util.MyLogger;

public class MODERATE_RISK implements AirportStateI {
    AirportRiskContext airportRiskContext;

    public MODERATE_RISK(AirportRiskContext state) {
        this.airportRiskContext = state;
        MyLogger.writeMessage("MODERATE_RISK_STATE class constructor." , MyLogger.DebugLevel.CONSTRUCTOR);
    }

    @Override
    public void operationsToDo(AverageData data) {
        // int avgTrafficPerDay = AirportRiskContext.avgTrafficPerDay;
        //int avgProhibitedItemPerDay = AirportRiskContext.avgProhibitedItemPerDay;

        int avgTrafficPerDay = data.getAvgTrafficPerDay();
        int avgProhibitedItemPerDay = data.getAvgProhibitedItemPerDay();

        if (avgTrafficPerDay >= 8 || avgProhibitedItemPerDay >= 2)
            airportRiskContext.setState(airportRiskContext.getHighRisk());
        else if (avgTrafficPerDay < 4 && avgProhibitedItemPerDay < 1)
            airportRiskContext.setState(airportRiskContext.getLowRisk());


    }
    @Override
    public String toString(){
        return "2 3 5 8 9";
    }
}