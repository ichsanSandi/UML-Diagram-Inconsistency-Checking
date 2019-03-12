package project;

import java.util.ArrayList;
import java.util.List;

public class Lifeline {
    private String id;
    private String name;
    private String represent;
    static ArrayList<Lifeline> lifelineList = new ArrayList<Lifeline>();
    static Lifeline lifeline = new Lifeline();

    public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setRepresent(String represent){
        this.represent = represent;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getRepresent(){
        return this.represent;
    }

    public void addLifelineList(Lifeline lifeline){
        lifelineList.add(lifeline);
    }

    public static void printLifelineList(){
        System.out.println("\nLIFELINE");
        for (int lifelineCounter = 0; lifelineCounter < lifelineList.size(); lifelineCounter++){
            lifeline = lifelineList.get(lifelineCounter);
            System.out.println("id" + (lifelineCounter + 1) + ": " + lifeline.getId());
            System.out.println("name" + (lifelineCounter + 1) + ": " + lifeline.getName());
            System.out.println("represent" + (lifelineCounter + 1) + ": " + lifeline.getRepresent());
        }
    }


    public static boolean checkIdOwnedAttribute(String ownedAttribute){
        for (int lifelineCounter = 0; lifelineCounter < lifelineList.size(); lifelineCounter++){
            lifeline = lifelineList.get(lifelineCounter);
            if (ownedAttribute.equals(lifeline.getRepresent())){
                return true;
            }
        }
        return false;
    }
}
