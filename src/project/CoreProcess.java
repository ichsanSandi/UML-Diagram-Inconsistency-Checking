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
        /*
         * Isi kode buat ngehapus role 3 di testcase2.xmi
         * Cek listnya, kalo seq lifeline sama, break
         * kalo seq lifeline tidak sama, flag (?), lanjut
         * kalo seq lifeline tidak sama && j=lifelinelist.size-1. remove seq[i]
         * */
        for (int i = 0; i < ClassOwnedAttribute.attributeList.size(); i++){
            for (int j = 0; j < Lifeline.lifelineList.size(); j++){
                if (ClassOwnedAttribute.attributeList.get(i).getId().equals(Lifeline.lifelineList.get(j).getRepresent())){
                    break;
                }
                else if (j == Lifeline.lifelineList.size()-1){
                    ClassOwnedAttribute.attributeList.remove(i);
                    break;
                }
            }
        }
    }

    static void checkMessageAssociationDirection(){
        int flag = 0;
        for (int i = 0; i < Message.messageList.size(); i++){
            if (Message.messageList.get(i).getSignature().equals("no signature")){
                for (int j = 0; j < Fragment.fragmentList.size(); j++){
                    if (Message.messageList.get(i).getReceiveEvent().equals(Fragment.fragmentList.get(j).getId())){
                        for (int k = 0; k < Lifeline.lifelineList.size(); k++){
                            if (Fragment.fragmentList.get(j).getCovered().equals(Lifeline.lifelineList.get(k).getId())){
                                for (int l = 0; l < ClassOwnedOperation.operationList.size(); l++){
                                    if (Message.messageList.get(i).getName().equals(ClassOwnedOperation.operationList.get(l).getName()) && !Lifeline.lifelineList.get(k).getName().equalsIgnoreCase(ClassOwnedOperation.operationList.get(l).getAssociatedClass())){
                                        for (int m = 0; m < SequenceOwnedAttribute.attributeList.size(); m++){
                                            /*tambahin else if
                                             * kalo misal lifelinenya bener*/
                                            if (Lifeline.lifelineList.get(k).getRepresent().equals(SequenceOwnedAttribute.attributeList.get(m).getId()) && !SequenceOwnedAttribute.attributeList.get(m).getType().isEmpty()){
                                                for (int o = 0; o < ClassName.classNameArrayList.size(); o++){
                                                    if (SequenceOwnedAttribute.attributeList.get(m).getType().equals(ClassName.classNameArrayList.get(o).getId()) && !ClassName.classNameArrayList.get(o).getName().equalsIgnoreCase(ClassOwnedOperation.operationList.get(l).getAssociatedClass())){
                                                        System.out.println(ClassName.classNameArrayList.get(o).getName() + " + " + ClassOwnedOperation.operationList.get(l).getAssociatedClass() + " + " + Message.messageList.get(i).getName());
                                                    }
                                                }
                                                break;
                                            }
                                            if (Lifeline.lifelineList.get(k).getRepresent().equals(SequenceOwnedAttribute.attributeList.get(m).getId()) && SequenceOwnedAttribute.attributeList.get(m).getType().isEmpty()){
                                                /*Gak bisa pake type,
                                                nanti yang lifeline bener gak kedetect*/
//                                                flag = 1;
                                                break;
                                            }
                                            else/* if (flag == 0)*/{
                                                System.out.println(Lifeline.lifelineList.get(k).getName() + " + " + ClassOwnedOperation.operationList.get(l).getAssociatedClass() + " + " + Message.messageList.get(i).getName());
                                                Suspect suspect = new Suspect();
                                                suspect.setName(Message.messageList.get(i).getName());
                                                suspect.setArgument(Message.messageList.get(i).getArgument());
                                                suspect.setClassAssoc(Lifeline.lifelineList.get(k).getName());
                                                Suspect.classAssocWarningList.add(suspect);
//                                                flag = 0;
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
}
