package project;

import java.util.*;

class CoreProcess {
//    private ArrayList<ClassOwnedOperation> operationList = new ArrayList<ClassOwnedOperation>();
//    private ArrayList<Message> messageList = new ArrayList<Message>();

    static void inconsistencyChecking(ArrayList<Message> messageArrayList, ArrayList<ClassOwnedOperation> operationArrayList){
        ArrayList<Message> setMessageList = new ArrayList<>(messageArrayList);
        ArrayList<ClassOwnedOperation> setOperationList = new ArrayList<>(operationArrayList);
        Message message;
        ClassOwnedOperation operation;
        int flag = 0;
        for (int i = 0; i < setMessageList.size(); i++){
            message = setMessageList.get(i);
            for (int j = 0; j < setOperationList.size(); j++){
                operation = setOperationList.get(j);
//                message.getSignature().compareTo(operation.getId());
//                System.out.println(message.getSignature() + " + " + operation.getId());
                if (message.getSignature().equals(operation.getId())){
//                    System.out.println("sama");
                    setOperationList.remove(j);
                    //masih dipikir perlu dihapus atau pindah list, atau counter aja. tergantung
                    //penggunaan nanti. pikir2 sek
                    flag = 1;
                    break;
                    //kalau sama kasih flag = 1. kalau masih flag = 0 berarti tidak konsisten
                }
                else if (flag == 0){
//                    System.out.println("tidak sama");
                }
            }
        }
        System.out.println(Suspect.messageSuspectList.size());
//        System.out.println(ClassOwnedOperation.operationList.size());
        System.out.println(setOperationList.size());
    }

    static void checkSignature(){
        for (int i = 0; i < Message.messageList.size(); i++){
            for (int j = 0; j < ClassOwnedOperation.operationList.size(); j++){
                if (Message.messageList.get(i).getSignature().equals(ClassOwnedOperation.operationList.get(j).getId())){
                    Message.messageList.get(i).setOperationName(ClassOwnedOperation.operationList.get(j).getName());
                    break;
                }else {
                    Message.messageList.get(i).setOperationName(Message.messageList.get(i).getName());
                }
            }
        }
    }

}
