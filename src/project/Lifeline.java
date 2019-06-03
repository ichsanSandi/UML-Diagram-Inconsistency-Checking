package project;

import java.util.ArrayList;

public class Lifeline {
    private String id;
    private String name;
    private String represent;
    static ArrayList<Lifeline> lifelineList = new ArrayList<>();

    void setId(String id){
        this.id = id;
    }

    void setName(String name){
        this.name = name;
    }

    void setRepresent(String represent){
        this.represent = represent;
    }

    String getId(){
        return this.id;
    }

    String getName(){
        return this.name;
    }

    String getRepresent(){
        return this.represent;
    }

    void addLifelineList(Lifeline lifeline){
        lifelineList.add(lifeline);
    }

    public static void printLifelineList(){
        System.out.println("\nLIFELINE");
        Lifeline lifeline;
        for (int lifelineCounter = 0; lifelineCounter < lifelineList.size(); lifelineCounter++){
            lifeline = lifelineList.get(lifelineCounter);
            System.out.println("id" + (lifelineCounter + 1) + ": " + lifeline.getId());
            System.out.println("name" + (lifelineCounter + 1) + ": " + lifeline.getName());
            System.out.println("represent" + (lifelineCounter + 1) + ": " + lifeline.getRepresent());
        }
    }

    static boolean checkIdOwnedAttribute(String ownedAttribute){
        Lifeline lifeline;
        for (int lifelineCounter = 0; lifelineCounter < lifelineList.size(); lifelineCounter++){
            lifeline = lifelineList.get(lifelineCounter);
            if (ownedAttribute.equals(lifeline.getRepresent())){
                return true;
            }
        }
        return false;
    }
}