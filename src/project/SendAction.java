package project;

import java.util.ArrayList;

public class SendAction {
    private String id;
    private String name;
    static ArrayList<SendAction> sendActionArrayList = new ArrayList<>();

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    void addSendAction (SendAction sendAction){
        sendActionArrayList.add(sendAction);
    }

    static void printSendActionList(){
        SendAction sendAction;
        System.out.println("\nSEND ACTION");
        for (int sendActionCounter = 0; sendActionCounter< sendActionArrayList.size(); sendActionCounter++){
            sendAction = sendActionArrayList.get(sendActionCounter);
            System.out.println("id" + (sendActionCounter + 1) + ": " + sendAction.getId());
            System.out.println("name" + (sendActionCounter + 1) + ": " + sendAction.getName());
        }
    }
}
