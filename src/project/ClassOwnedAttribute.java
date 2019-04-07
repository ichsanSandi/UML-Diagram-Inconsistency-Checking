package project;

import java.util.ArrayList;

class ClassOwnedAttribute {
    private String id;
    private String name;
    private String type;
    static ArrayList<ClassOwnedAttribute> attributeList = new ArrayList<>();

    void setId(String id) {
        this.id = id;
    }

    void setName(String name) {
        this.name = name;
    }

    void setType(String type) {
        this.type = type;
    }

    String getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getType() {
        return type;
    }

    void addAttributeList(ClassOwnedAttribute attribute){
        attributeList.add(attribute);
    }

    static void printAttributeList(){
        ClassOwnedAttribute attribute;
        System.out.println("\nCLASS ATTRIBUTE:");
        for (int attrCounter = 0; attrCounter<attributeList.size(); attrCounter++){
            attribute = attributeList.get(attrCounter);
            System.out.println("id" + (attrCounter + 1) + ": " + attribute.getId());
            System.out.println("name" + (attrCounter + 1) + ": " + attribute.getName());
            System.out.println("type" + (attrCounter + 1) + ": " + attribute.getType());
        }
    }
}