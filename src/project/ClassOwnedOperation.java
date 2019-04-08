package project;

import java.util.ArrayList;

class ClassOwnedOperation {
    private String id;
    private String name;
    private String parameter;
    private String associatedClass;
    static ArrayList<String> parameterList = new ArrayList<>();
    static ArrayList<ClassOwnedOperation> operationList = new ArrayList<>();

    void setId(String id) {
        this.id = id;
    }

    void setName(String name) {
        this.name = name;
    }

    void setParameter(String parameter) {
        this.parameter = parameter;
        parameterList.clear();
    }

    void setAssociatedClass(String associatedClass) {
        this.associatedClass = associatedClass;
    }

    void addParameter(String parameter) {
        parameterList.add(parameter);
    }

    String getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getParameter() {
        return parameter;
    }

    String getAssociatedClass() {
        return associatedClass;
    }

    void addOperationList(ClassOwnedOperation attribute){
        operationList.add(attribute);
    }

    static void printOperationList(){
        ClassOwnedOperation operation;
        System.out.println("\nCLASS OPERATION:");
        for (int operCounter = 0; operCounter<operationList.size(); operCounter++){
            operation = operationList.get(operCounter);
            System.out.println("id" + (operCounter + 1) + ": " + operation.getId());
            System.out.println("name" + (operCounter + 1) + ": " + operation.getName());
            System.out.println("parameter" + (operCounter + 1) + ": " + operation.getParameter());
            System.out.println("Associated Class" + (operCounter + 1) + ": " + operation.getAssociatedClass());
        }
    }
}