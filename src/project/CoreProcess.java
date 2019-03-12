package project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoreProcess {
//    private ArrayList<ClassOwnedOperation> operationList = new ArrayList<ClassOwnedOperation>();
//    private ArrayList<Message> messageList = new ArrayList<Message>();
    static ArrayList list = new ArrayList();
    static ArrayList inconsistencyList = new ArrayList();

//    void setOperationList(ArrayList<ClassOwnedOperation> operationListParam){
//        this.operationList = operationListParam;
//    }

    static void inconsistencyChecking(ArrayList<Message> list1, ArrayList<ClassOwnedOperation> list2){
        ArrayList<Message> set1 = new ArrayList<Message>(list1);
        ArrayList<ClassOwnedOperation> set2 = new ArrayList<ClassOwnedOperation>(list2);
        Message message = new Message();
        ClassOwnedOperation operation = new ClassOwnedOperation();
        for (int i = 0; i < list1.size(); i++){
            message = list1.get(i);
            for (int j = 0; j < list2.size(); j++){
                operation = list2.get(j);
                message.getSignature().compareTo(operation.getId());
                if (message.getSignature().equals(operation.getId()) || operation.getId().equals(message.getSignature())){
                    System.out.println("sama");
                    break;
                }
                else {
                    System.out.println("tidak sama");
                    inconsistencyList.add(message);
                }
            }
        }
        System.out.println(inconsistencyList.size());
    }
}
