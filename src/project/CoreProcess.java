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
                    Suspect.assocWarningList.add(Suspect.unknownMessageList.remove(i));
//                    Suspect.unknownMessageList.remove(i);
                    i = i-1;
                    break;
                }
            }
        }
        /*for (int i = 0; i < Message.messageList.size(); i++){
            for (int j = 0; j < ClassOwnedOperation.operationList.size(); j++){
                if (Message.messageList.get(i).getSignature().equals(ClassOwnedOperation.operationList.get(j).getId())){
                    Message.messageList.get(i).setOperationName(ClassOwnedOperation.operationList.get(j).getName());
                    Message.messageList.get(i).setArgument(ClassOwnedOperation.operationList.get(j).getParameter());
                    break;
                }else {
                    Message.messageList.get(i).setOperationName(Message.messageList.get(i).getName());
                }
            }
        }*/
//        System.out.println(Suspect.unknownMessageList.size());
//        System.out.println(ClassOwnedOperation.operationList.size());
//        System.out.println(setOperationList.size());
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

    private static void getLifelineCheck(String seqAttrType){
        for (int i = 0; i < ClassName.classNameArrayList.size(); i++){
            if (seqAttrType.equals(ClassName.classNameArrayList.get(i).getId())){
                Lifeline.lifelineList.get(i).setName(ClassName.classNameArrayList.get(i).getName());
                break;
            }
        }
    }

    static void checkingRepresent() {
        for (int i = 0; i < Lifeline.lifelineList.size(); i++){
            for (int j = 0; j < SequenceOwnedAttribute.attributeList.size(); j++){
                if (Lifeline.lifelineList.get(i).getRepresent().equals(SequenceOwnedAttribute.attributeList.get(j).getId())){
                    if (SequenceOwnedAttribute.attributeList.get(j).getType().isEmpty()){
                        Suspect.lifelineLists.add(Lifeline.lifelineList.get(i).getName());
                        break;
                    }
                    else {
                        getLifelineCheck(SequenceOwnedAttribute.attributeList.get(j).getType());
                        break;
                    }
                }
            }
        }
    }

    static void checkingNoise(){
        for (int i = 0; i < SequenceOwnedAttribute.attributeList.size(); i++){
            for (int j = 0; j < Lifeline.lifelineList.size(); j++){
                /*
                * Isi kode buat ngehapus role 3 di testcase2.xmi
                * Cek listnya, kalo seq lifeline sama, break
                * kalo seq lifeline tidak sama, flag (?), lanjut
                * kalo seq lifeline tidak sama && j=lifelinelist.size-1. remove seq[i]
                * */
            }
        }
    }
}
