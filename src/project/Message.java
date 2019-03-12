package project;

import java.util.ArrayList;
import java.util.List;

public class Message {
    private String id;
    private String name;
    private String signature;
    private String receiveEvent;
    private String sendEvent;
    public static ArrayList<Message> messageList = new ArrayList<Message>();

    public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSignature(String signature){
        this.signature = signature;
    }

    public void setReceiveEvent(String receiveEvent){
        this.receiveEvent = receiveEvent;
    }

    public void setSendEvent(String sendEvent){
        this.sendEvent = sendEvent;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getSignature(){
        return this.signature;
    }

    public String getReceiveEvent(){
        return this.receiveEvent;
    }

    public String getSendEvent(){
        return this.sendEvent;
    }

    public void addMessageList(Message message){
        messageList.add((Message) message);
    }

    public static void printMessageList(){
        Message message = new Message();
        System.out.println("\nMESSAGE");
        for (int messageCounter = 0; messageCounter < messageList.size(); messageCounter++){
            message = messageList.get(messageCounter);
            System.out.println("id" + (messageCounter + 1) + ": " + message.getId());
            System.out.println("name" + (messageCounter + 1) + ": " + message.getName());
            System.out.println("signature" + (messageCounter + 1) + ": " + message.getSignature());
            System.out.println("receiveEvent" + (messageCounter + 1) + ": " + message.getReceiveEvent());
            System.out.println("sendEvent" + (messageCounter + 1) + ": " + message.getSendEvent());
        }
//        Iterator<String> iterator = messageList.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

//        for (int i = 0; i < messageNameList.size(); i++){
//            System.out.println(getId());
//        }
//        messageNameList.forEach(System.out::println);
//        Iterator<Object> i = messageNameList.iterator();
//        while (i.hasNext()) {
//            System.out.println(i.next());
//        }
    }
}
