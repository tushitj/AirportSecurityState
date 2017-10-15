package airportSecurityState.airportStates;

import airportSecurityState.util.PassengerData;

public class MODERATE_RISK implements AirportStateI {
    AirportRiskContext airportRiskContext;

    public MODERATE_RISK(AirportRiskContext state) {
        this.airportRiskContext = state;
    }

    @Override
    public void operationsToDo() {
        int avgTrafficPerDay = AirportRiskContext.avgTrafficPerDay;
        int avgProhibitedItemPerDay = AirportRiskContext.avgProhibitedItemPerDay;

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