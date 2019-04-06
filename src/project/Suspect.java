package project;

import java.util.ArrayList;

class Suspect {
    private String name;
    private String argument;
    static ArrayList<String> argumentList = new ArrayList<>();
    static ArrayList<Suspect> messageSuspectList = new ArrayList<>();
    static ArrayList<Suspect> warningList = new ArrayList<>();
    static ArrayList<Suspect> lifelineLists = new ArrayList<>();
    
    void setName(String name) {
        this.name = name;
    }

    void setArgument(String argument) {
        this.argument = argument;
        argumentList.clear();
    }

    String getName(){
        return this.name;
    }

    String getArgument() {
        return argument;
    }

    void addArgument(String argument){
        argumentList.add(argument);
    }
}
