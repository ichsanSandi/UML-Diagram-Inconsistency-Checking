package project;

import java.util.ArrayList;

public class Suspect {
    private String name;
    static ArrayList<Suspect> messageSuspectList = new ArrayList<>();
    public static ArrayList<Suspect> inconsistencyList = new ArrayList<>();


    void setName(String name) {
        this.name = name;
    }

    String getName(){
        return this.name;
    }
}
