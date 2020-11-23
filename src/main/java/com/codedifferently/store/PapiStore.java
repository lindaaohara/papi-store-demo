// like the last name of the family of objects
 package com.codedifferently.store;
// this is importing utilities needed
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//the public class PapiStore with its private states that create the object; the boolean says true or false for whether the store is open
//the Array list holds who has a tab and the map consists of a name as a Key and an amount of how much the person owes Papi as a Value

public class PapiStore {
    private boolean isStoreOpen;
    private ArrayList<String> tabs;
    Map<String, Double> owesPapiMoney;

    // this is the constructor which sets the initial state of this object
    public PapiStore(){
        this.isStoreOpen = false;
        this.tabs = new ArrayList();
		
	//HashMap class implements the Map interface which allows us to store key & value pairs
        this.owesPapiMoney = new HashMap<>();
    }
//this is another constructor to set an alternative opening state
    public PapiStore(Boolean isOpen, ArrayList<String> tabsIn){
        this.isStoreOpen = isOpen;
        this.tabs = tabsIn;
        this.owesPapiMoney = new HashMap<>();
    }

    public void closeStore(){

    }

    public void openStore(){
        this.isStoreOpen = true;
    }

    public boolean isStoreOpen() {
        return isStoreOpen;
    }

    //checks if a person is allowed to use a tab based on their name in the tab array and they don't have an overdue balance.  The default is false.
	
    public Boolean allowToUseTab(String name){
        Boolean response = false;
        if(hasAnActiveTab(name) && !hasAnOverDueBalance(name))
            response = true;
        return response;
    }
// this is a private helper method to mark who owes money
    private boolean hasAnOverDueBalance(String name){
        if(!owesPapiMoney.containsKey(name))
            return false;
        Double money = owesPapiMoney.get(name);
        Boolean owes = false;
        if(money > 0.0)
            owes = true;
        return owes;
    }
    //only the objects made from this class can call this method because it's private; it's
    //like a helper class to the public allowToUseTab; it checks if they have an active tab
    //for every String tab in tabs; if tab equals name, return true;
    //otherwise return false
    private boolean hasAnActiveTab(String name){
        for (String tab : tabs){
            if (tab.equals(name))
                return true;
        }
        return false;
    }
    //this adds names to the tabs array list
    public void createActiveTab(String name){
        this.tabs.add(name);
    }


    public static void main(String[] args) {
        System.out.println("Welcome to Papi Store, Hola");
    }


}
