package airportSecurityState.airportStates;

import airportSecurityState.util.PassengerData;

import java.util.*;

public class AirportRiskContext implements AirportStateI {

    static int passenger =0;

    static int prohibitedItem=0;

    List<String> prohibitedItems;

    public static int avgTrafficPerDay;
    public static int avgProhibitedItemPerDay;

    static Set<Integer> daysSet;

    private AirportStateI LowRisk;
    private AirportStateI ModerateRisk;
    private AirportStateI HighRisk;

    AirportStateI state;


    public AirportRiskContext() {
        this.LowRisk = new LOW_RISK(this);
        this.ModerateRisk = new MODERATE_RISK(this);
        this.HighRisk = new HIGH_RISK(this);

        this.daysSet = new TreeSet<>();
        prohibitedItems = new ArrayList<>();

        prohibitedItems.add("gun");
        prohibitedItems.add("knife");
        prohibitedItems.add("nailcutter");
        prohibitedItems.add("blade");

        this.setState(getLowRisk());
    }

    public void setState(AirportStateI stateI) {
        this.state = stateI;

    }

    @Override
    public void operationsToDo() {
        state.operationsToDo();
    }

    public void tightenOrLoosenSecurity(PassengerData data) {
        passenger++;
        if (checkItem(data))
            prohibitedItem++;
        daysSet.add(data.getDay());


        avgTrafficPerDay = passenger/daysSet.size();
        avgProhibitedItemPerDay = prohibitedItem/daysSet.size();
        operationsToDo();
        System.out.println(this.state.toString());
    }

    public boolean checkItem(PassengerData data) {
        String item = data.getItem().trim().toLowerCase();
        return prohibitedItems.contains(item);
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

