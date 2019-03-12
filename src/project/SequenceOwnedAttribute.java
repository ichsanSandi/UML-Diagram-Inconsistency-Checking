package project;

import java.util.ArrayList;

public class SequenceOwnedAttribute {
    private String id;
    private String name;
    private String type; //package element ID atau class ID
    static ArrayList<SequenceOwnedAttribute> attributeList = new ArrayList<SequenceOwnedAttribute>();

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

    public void addAttributeList(SequenceOwnedAttribute attribute){
        attributeList.add(attribute);
    }

    public static void printAttributeList(){
        SequenceOwnedAttribute attribute = new SequenceOwnedAttribute();
        System.out.println("\nSEQUENCE ATTRIBUTE");
        for (int attrCounter = 0; attrCounter < attributeList.size(); attrCounter++){
            attribute = attributeList.get(attrCounter);
            System.out.println("id" + (attrCounter + 1) + ": " + attribute.getId());
            System.out.println("name" + (attrCounter + 1) + ": " + attribute.getName());
            System.out.println("type" + (attrCounter + 1) + ": " + attribute.getType());
        }
    }
}
