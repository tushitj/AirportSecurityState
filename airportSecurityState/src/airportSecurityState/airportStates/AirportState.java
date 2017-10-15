package airportSecurityState.airportStates;

public class AirportState {
    AirportStateI LOW_RISK_state;
    AirportStateI MODERATE_RISK_state;
    AirportStateI HIGH_RISK_state;

    AirportStateI state;
    int AvgTraffic = 0;
    int AvgProhibitedItems = 0;

    public AirportState(int avgProhibitedItemsIn, int avgTrafficIn) {
        LOW_RISK_state = new LOW_RISK(this);
        MODERATE_RISK_state = new MODERATE_RISK(this);
        HIGH_RISK_state = new HIGH_RISK(this);

        AvgTraffic = avgTrafficIn;
        AvgProhibitedItems = avgProhibitedItemsIn;

        if (avgTrafficIn < 4 && avgProhibitedItemsIn < 1) {
            state = LOW_RISK_state;
        } else if (avgTrafficIn < 8 && avgProhibitedItemsIn < 2) {
            state = MODERATE_RISK_state;
        } else if (avgTrafficIn >= 8 && avgProhibitedItemsIn >= 2) {
            state = HIGH_RISK_state;
        }
    }
    public void tightenOrLoosenSecurity() {
        state.operationsToDo();
    }


}

