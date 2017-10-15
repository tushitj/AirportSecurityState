package airportSecurityState.airportStates;

import airportSecurityState.util.PassengerData;

public class HIGH_RISK implements AirportStateI {
    AirportRiskContext airportRiskContext;
    public HIGH_RISK(AirportRiskContext state){
        this.airportRiskContext = state;
    }

    @Override
    public void operationsToDo() {
        int avgTrafficPerDay = AirportRiskContext.avgTrafficPerDay;
        int avgProhibitedItemPerDay = AirportRiskContext.avgProhibitedItemPerDay;

        if( avgTrafficPerDay < 8 && avgProhibitedItemPerDay < 2)
            airportRiskContext.setState(airportRiskContext.getModerateRisk());
    }

    public String toString(){
        return "2 4 6 8 10";
    }

}
