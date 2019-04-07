package project;

import java.util.ArrayList;

public class ClassName {
    private String id;
    private String name;
    private String type;
    static ArrayList<ClassName> classNameArrayList = new ArrayList<>();

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    void addClassList(ClassName classNameMember){
        classNameArrayList.add(classNameMember);
    }
}