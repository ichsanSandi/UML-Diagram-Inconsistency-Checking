package project;

import java.util.ArrayList;
import java.util.Calendar;

public class ClassOwnedAttribute {
    private String id;
    private String name;
    private String type;
    static ArrayList<ClassOwnedAttribute> attributeList = new ArrayList<ClassOwnedAttribute>();
    private static ClassOwnedAttribute attribute = new ClassOwnedAttribute();

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

    public void addAttributeList(ClassOwnedAttribute attribute){
        attributeList.add(attribute);
    }

    public static void printAttributeList(){
        System.out.println("\nCLASS ATTRIBUTE:");
        for (int attrCounter = 0; attrCounter<attributeList.size(); attrCounter++){
            attribute = attributeList.get(attrCounter);
            System.out.println("id" + (attrCounter + 1) + ": " + attribute.getId());
            System.out.println("name" + (attrCounter + 1) + ": " + attribute.getName());
            System.out.println("type" + (attrCounter + 1) + ": " + attribute.getType());
        }
    }


}
