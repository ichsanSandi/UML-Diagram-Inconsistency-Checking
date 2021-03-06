package project;

import java.util.ArrayList;


class Suspect {
    private String name;
    private String argument;
    private String classAssoc;
    private String receiveEvent;
    private String sendEvent;
    private String parent;
    private int Counter;
    /**List untuk nambahin argumen message saja*/
    static ArrayList<String> argumentList = new ArrayList<>();

    /**List message yang tidak ada di operasi kelas*/
    static ArrayList<Suspect> unknownMessageList = new ArrayList<>();

    /**List untuk message yang tidak ada relasi dengan operasi di kelas*/
    static ArrayList<Suspect> assocWarningList = new ArrayList<>();

    /**List untuk message yang tidak ada di operasi kelas penerima*/
    static ArrayList<Suspect> classAssocWarningList = new ArrayList<>();

    /**List untuk lifeline yang tidak ada di kelas*/
    static ArrayList<String> lifelineLists = new ArrayList<>();

    /**List untuk lifeline yang tidak memiliki relasi dengan kelas*/
    static ArrayList<String> lifelineAssocLists = new ArrayList<>();

    /**List untuk pengecekan message reply*/
    static ArrayList<Message> replySuspectList = new ArrayList<>();

    /**List untuk reply yang bermasalah**/
    static ArrayList<Message> replyList = new ArrayList<>();

    static void addUnknownMessageList(Suspect suspect) {
        unknownMessageList.add(suspect);
    }

    void setName(String name) {
        this.name = name;
    }

    void setArgument(String argument) {
        this.argument = argument;
        argumentList.clear();
    }

    void setClassAssoc(String classAssoc) {
        this.classAssoc = classAssoc;
    }

    void setReceiveEvent(String receiveEvent) {
        this.receiveEvent = receiveEvent;
    }

    void setSendEvent(String sendEvent) {
        this.sendEvent = sendEvent;
    }

    void setCounter(int counter) {
        Counter = counter;
    }

    void setParent(String parent) {
        this.parent = parent;
    }

    String getName(){
        return this.name;
    }

    String getArgument() {
        return argument;
    }

    String getClassAssoc() {
        return classAssoc;
    }

    String getReceiveEvent() {
        return receiveEvent;
    }

    String getSendEvent() {
        return sendEvent;
    }

    int getCounter() {
        return Counter;
    }

    void addArgument(String argument){
        argumentList.add(argument);
    }
}