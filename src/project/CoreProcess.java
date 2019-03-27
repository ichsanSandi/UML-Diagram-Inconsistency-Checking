package project;

import java.util.*;

class CoreProcess {
//    private ArrayList<ClassOwnedOperation> operationList = new ArrayList<ClassOwnedOperation>();
//    private ArrayList<Message> messageList = new ArrayList<Message>();

    static void inconsistencyChecking(ArrayList<Suspect> suspectArrayList, ArrayList<ClassOwnedOperation> operationArrayList){
        ArrayList<ClassOwnedOperation> setOperationList = new ArrayList<>(operationArrayList);
        Suspect suspect;
        ClassOwnedOperation operation;
        for (int i = 0; i < suspectArrayList.size(); i++){
            suspect = suspectArrayList.get(i);
            for (int j = 0; j < setOperationList.size(); j++){
                operation = setOperationList.get(j);
//                suspect.getSignature().compareTo(operation.getId());
//                System.out.println(suspect.getSignature() + " + " + operation.getId());
                if (suspect.getName().equals(operation.getName()) && suspect.getArgument().equals(operation.getParameter())){
//                    System.out.println("sama");
                    //masih dipikir perlu dihapus atau pindah list, atau counter aja. tergantung
                    //penggunaan nanti. pikir2 sek
                    Suspect.warningList.add(Suspect.messageSuspectList.remove(i));
//                    Suspect.messageSuspectList.remove(i);
                    i = i-1;
                    break;
                    //kalau sama kasih flag = 1. kalau masih flag = 0 berarti tidak konsisten
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
                    Message.messageList.get(i).setArgument(ClassOwnedOperation.operationList.get(j).getParameter());
                    break;
                }else {
                    Message.messageList.get(i).setOperationName(Message.messageList.get(i).getName());
                }
            }
        }
    }

//    static void checkMessageArgument(){
//        for (int i = 0; i < Message.messageList.size(); i++){
//            for (int j = 0; j < ClassOwnedOperation.operationList.size(); j++){
//
//            }
//        }
//    }

}
