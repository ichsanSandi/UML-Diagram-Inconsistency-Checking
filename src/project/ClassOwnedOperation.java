package project;

import java.util.ArrayList;

public class ClassOwnedOperation {
    private String id;
    private String name;
    private String parameter;
    public static ArrayList<ClassOwnedOperation> operationList = new ArrayList<ClassOwnedOperation>();
    private static ClassOwnedOperation operation = new ClassOwnedOperation();

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getParameter() {
        return parameter;
    }

    public void addOperationList(ClassOwnedOperation attribute){
        operationList.add(attribute);
    }

    public static void printOperationList(){
        System.out.println("\nCLASS OPERATION:");
        for (int operCounter = 0; operCounter<operationList.size(); operCounter++){
            operation = operationList.get(operCounter);
            System.out.println("id" + (operCounter + 1) + ": " + operation.getId());
            System.out.println("name" + (operCounter + 1) + ": " + operation.getName());
        }
    }
}
