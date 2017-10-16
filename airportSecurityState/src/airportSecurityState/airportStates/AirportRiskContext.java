package airportSecurityState.airportStates;

import airportSecurityState.util.PassengerData;

public class AirportRiskContext implements AirportStateI {
    private AverageCalculator averageCalculator;

    private AirportStateI LowRisk;
    private AirportStateI ModerateRisk;
    private AirportStateI HighRisk;

    AirportStateI state;

    public AirportRiskContext() {
        this.LowRisk = new LOW_RISK(this);
        this.ModerateRisk = new MODERATE_RISK(this);
        this.HighRisk = new HIGH_RISK(this);
        this.setState(getLowRisk());

        averageCalculator = new AverageCalculator();
    }

    public void setState(AirportStateI stateI) {
        this.state = stateI;
    }

    @Override
    public void operationsToDo(AverageData data) {
        state.operationsToDo(data);
    }

    public void tightenOrLoosenSecurity(PassengerData data) {
        AverageData averageData= averageCalculator.calculate(data);
        operationsToDo(averageData);
        System.out.println(this.state.toString());
    }



    public AirportStateI getLowRisk() {
        return LowRisk;
    }

    public AirportStateI getModerateRisk() {
        return ModerateRisk;
    }

    public AirportStateI getHighRisk() {
        return HighRisk;
    }
}

