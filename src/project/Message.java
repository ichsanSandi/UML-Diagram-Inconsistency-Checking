package project;

import java.util.ArrayList;

class Message {
    private String id;
    private String name;
    private String signature;
    private String receiveEvent;
    private String sendEvent;
    private String operationName;
    private String argument;
    static ArrayList<String> argumentList = new ArrayList<>();
    static ArrayList<Message> messageList = new ArrayList<>();

    void setId(String id){
        this.id = id;
    }

    void setName(String name){
        this.name = name;
    }

    void setSignature(String signature){
        this.signature = signature;
    }

    void setReceiveEvent(String receiveEvent){
        this.receiveEvent = receiveEvent;
    }

    void setSendEvent(String sendEvent){
        this.sendEvent = sendEvent;
    }

    void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    void setArgument(String argument) {
        this.argument = argument;
        argumentList.clear();
    }

    String getId(){
        return this.id;
    }

    String getName(){
        return this.name;
    }

    String getSignature(){
        return this.signature;
    }

    String getReceiveEvent(){
        return this.receiveEvent;
    }

    String getSendEvent(){
        return this.sendEvent;
    }

    String getOperationName() {
        return this.operationName;
    }

    String getArgument(){
        return this.argument;
    }

    void addMessageList(Message message){
        messageList.add(message);
    }

    void addArgumentList(String argument){
        argumentList.add(argument);
    }

    static void printMessageList(){
        Message message;
        System.out.println("\nMESSAGE");
        for (int messageCounter = 0; messageCounter < messageList.size(); messageCounter++){
            message = messageList.get(messageCounter);
            System.out.println("id" + (messageCounter + 1) + ": " + message.getId());
            System.out.println("name" + (messageCounter + 1) + ": " + message.getName());
            System.out.println("signature" + (messageCounter + 1) + ": " + message.getSignature());
            System.out.println("receiveEvent" + (messageCounter + 1) + ": " + message.getReceiveEvent());
            System.out.println("sendEvent" + (messageCounter + 1) + ": " + message.getSendEvent());
            System.out.println("operationName" + (messageCounter + 1) + ": " + message.getOperationName());
        }
    }

}