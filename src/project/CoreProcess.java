package project;

import java.util.*;

class CoreProcess {

    /**
     * method inconsistencyChecking
     *
     * Digunakan untuk mendeteksi message yang tidak memiliki signature sebagai tanda
     * asosiasi dengan operasi yang ada di kelas
     *
     * Jika nama dan argument message sama dengan nama dan parameter yang ada pada daftar
     * operasi, maka message tersebut tidak dikatakan inkonsisten, dan dihapus dari daftar
     * message yang inkonsisten
     *
     * @param suspectArrayList arraylist yang berisi message yang dicurigai
     * @param operationArrayList arraylist yang berisi daftar operasi
     */
    static void inconsistencyChecking(ArrayList<Suspect> suspectArrayList, ArrayList<ClassOwnedOperation> operationArrayList) {
        ArrayList<ClassOwnedOperation> setOperationList = new ArrayList<>(operationArrayList);
        Suspect suspect;
        ClassOwnedOperation operation;
        for (int i = 0; i < suspectArrayList.size(); i++) {
            suspect = suspectArrayList.get(i);
            for (int j = 0; j < setOperationList.size(); j++) {
                operation = setOperationList.get(j);
                if (suspect.getName().equals(operation.getName()) && suspect.getArgument().equals(operation.getParameter())) {
                    Suspect.assocWarningList.add(Suspect.unknownMessageList.remove(i));
                    i = i - 1;
                    break;
                }
            }
        }
    }

    /**
     * mengecek signature pada message dengan id yang ada pada operasi kelas
     * untuk menyesuaikan nama dan argument message
     */
    void checkSignature() {
        for (int i = 0; i < Message.messageList.size(); i++) {
            for (int j = 0; j < ClassOwnedOperation.operationList.size(); j++) {
                if (Message.messageList.get(i).getSignature().equals(ClassOwnedOperation.operationList.get(j).getId())) {
                    Message.messageList.get(i).setOperationName(ClassOwnedOperation.operationList.get(j).getName());
                    Message.messageList.get(i).setArgument(ClassOwnedOperation.operationList.get(j).getParameter());
                    break;
                } else {
                    Message.messageList.get(i).setOperationName(Message.messageList.get(i).getName());
                }
            }
        }
    }

    /**
     * method GetLifelineCheck
     * berfungsi untuk mengganti nama lifeline yang mempunyai
     * asosiasi dengan kelas dengan nama kelas yang tersasosiasi
     *
     * @param seqAttrType atribut type dari salah satu objek dari kelas SequenceOwnedAttribute
     */
    private static String getLifelineCheck(String seqAttrType) {
        for (int i = 0; i < ClassName.classNameArrayList.size(); i++) {
            if (seqAttrType.equals(ClassName.classNameArrayList.get(i).getId())) {
                return ClassName.classNameArrayList.get(i).getName();
            }
        }
        return null;
    }

    /**
     * Digunakan untuk mengecek apakah Lifeline mempunyai asosiasi dengan kelas melalui element represent
     * yang dicocokkan dengna id pada atribute Sequence.
     *
     * Lifeline yang mempunyai asosiasi dengan kelas, element represent cocok dengan id atribute
     * sequence dan pada atribute dengan id tersebut mempunyai element Type. Jika tidak ada tipe
     * maka tidak memiliki asosiasi dengan kelas
     */
    void checkingLifelineRepresent() {
        for (int i = 0; i < Lifeline.lifelineList.size(); i++) {
            for (int j = 0; j < SequenceOwnedAttribute.attributeList.size(); j++) {
                if (Lifeline.lifelineList.get(i).getRepresent().equals(SequenceOwnedAttribute.attributeList.get(j).getId())) {
                    if (SequenceOwnedAttribute.attributeList.get(j).getType().isEmpty()) {
                        Suspect.lifelineLists.add(Lifeline.lifelineList.get(i).getName());
                        for (int k = 0; k < ClassName.classNameArrayList.size(); k++){
                            if (Lifeline.lifelineList.get(i).getName().equalsIgnoreCase(ClassName.classNameArrayList.get(k).getName())){
                                Suspect.lifelineAssocLists.add(Suspect.lifelineLists.remove(Suspect.lifelineLists.size()-1));
//                                Suspect.lifelineAssocLists.add(Lifeline.lifelineList.get(i).getName());
                                break;
                            }
                        }
                        break;
                    } else {
                        Lifeline.lifelineList.get(i).setName(getLifelineCheck(SequenceOwnedAttribute.attributeList.get(j).getType()));
                        break;
                    }
                }
            }
        }
    }

    /**
     * Fungsi untuk mendapatkan nama lifeline yang akan
     * menjadi nama untuk receiveEvent dan sendEvent
     *
     * @param fragment
     * objek fragment yang digunakan sebagai pembanding
     *
     * @return
     * string nama lifeline
     */
    private static String updateEvent(Fragment fragment){
        for (int k = 0; k < Lifeline.lifelineList.size();k++){
            if (fragment.getCovered().equals(Lifeline.lifelineList.get(k).getId())){
                for (int l = 0; l < SequenceOwnedAttribute.attributeList.size(); l++){
                    if (Lifeline.lifelineList.get(k).getRepresent().equals(SequenceOwnedAttribute.attributeList.get(l).getId()) && !SequenceOwnedAttribute.attributeList.get(l).getType().isEmpty()){
                        for (int m = 0; m < ClassName.classNameArrayList.size(); m++){
                            if (SequenceOwnedAttribute.attributeList.get(l).getType().equals(ClassName.classNameArrayList.get(m).getId())){
                                return ClassName.classNameArrayList.get(m).getName();
                            }
                        }
                    } else if (Lifeline.lifelineList.get(k).getRepresent().equals(SequenceOwnedAttribute.attributeList.get(l).getId()) && SequenceOwnedAttribute.attributeList.get(l).getType().isEmpty()){
                        return Lifeline.lifelineList.get(k).getName();
                    }
                }
            }
        }
        return null;
    }

    /**
     * Memperbarui receiveEvent Message dan sendEvent Message
     */
    void makeMessageTriplet(){
        for (int i = 0; i < Message.messageList.size(); i++){
            for (int j = 0; j < Fragment.fragmentList.size();j++){
                if (Message.messageList.get(i).getReceiveEvent().equals(Fragment.fragmentList.get(j).getId())){
                    Message.messageList.get(i).setReceiveEvent(updateEvent(Fragment.fragmentList.get(j)));
                } else if (Message.messageList.get(i).getSendEvent().equals(Fragment.fragmentList.get(j).getId())){
                    Message.messageList.get(i).setSendEvent(updateEvent(Fragment.fragmentList.get(j)));
                }
            }
        }

        for (int i = 0; i < Suspect.unknownMessageList.size(); i++){
            for (int j = 0; j < Fragment.fragmentList.size();j++){
                if (Suspect.unknownMessageList.get(i).getReceiveEvent().equals(Fragment.fragmentList.get(j).getId())){
                    Suspect.unknownMessageList.get(i).setReceiveEvent(updateEvent(Fragment.fragmentList.get(j)));
                } else if (Suspect.unknownMessageList.get(i).getSendEvent().equals(Fragment.fragmentList.get(j).getId())){
                    Suspect.unknownMessageList.get(i).setSendEvent(updateEvent(Fragment.fragmentList.get(j)));
                }
            }
        }
    }

    /**
     * Isi kode buat ngehapus role 3 di testcase2.xmi
     * Cek listnya, kalo seq lifeline sama, break
     * kalo seq lifeline tidak sama, flag (?), lanjut
     * kalo seq lifeline tidak sama && j=lifelinelist.size-1. remove seq[i]
     *
     * Menghapus "role" yang dibaca sebagai atribut kelas. Padahal itu adalah
     * role dari lifeline, biasanya jika menghapus lifeline tanpa menghapus role
     * "role" ini akan muncul
     */
    void checkingNoise() {
        for (int i = 0; i < ClassOwnedAttribute.attributeList.size(); i++) {
            for (int j = 0; j < Lifeline.lifelineList.size(); j++) {
                if (ClassOwnedAttribute.attributeList.get(i).getId().equals(Lifeline.lifelineList.get(j).getRepresent())) {
                    break;
                } else if (j == Lifeline.lifelineList.size() - 1) {
                    ClassOwnedAttribute.attributeList.remove(i);
                    break;
                }
            }
        }
    }

    /**
     * method untuk menambah message yang tidak ada di daftar operasi di kelas lifeline penerima ke dalam daftar suspect
     * @param name adalah nama message
     * @param argument adalah argument message
     * @param classAssoc adalah class yang operasinya diwakili oleh message
     */
    void addSuspectLifelineReceiver(String name, String argument, String classAssoc){
        Suspect suspect = new Suspect();
        suspect.setName(name);
        suspect.setArgument(argument);
        suspect.setClassAssoc(classAssoc);
        Suspect.classAssocWarningList.add(suspect);
    }

    /**
     * method checkMessageAssociationDirection
     *
     * Digunakan untuk mengecek arah message. Apakah lifeline penerima mempunyai operasi yang dikirimkam.
     *
     * Untuk message yang mempunyai asosiasi dengan operasi di kelas
     * maka alurnya adalah sebagai berikut:
     * Message.receiveEvent = Fragment.id -> Get Fragment.covered
     * Fragment.covered = Lifeline.id -> get Lifeline.represent
     * Lifeline.represent = SequenceOwnedAttribute.id -> get SequenceOwnedAttribute.type
     *
     * Jika type tidak ada, maka lifeline tidak mempunyai asosiasi dengan kelas:
     * Message.signature = OwnedOperation.id-> get OwnedOperation.associatedClass
     * Jika OwnedOperation.associatedClass = Lifeline.name maka konsisten, jika sebaliknya maka inkonsisten
     *
     * Jika type ada, maka lifeline mempunyai asosiasi dengan kelas:
     * Message.signature = OwnedOperation.id -> get OwnedOperation.associatedClass
     * SequenceAttribute.type = ClassName.id -> get ClassName.name
     * Jika ClassName.name = OwnedOperation.associatedClass maka konsisten, jika sebaliknya maka inkonsisten
     *
     * Untuk message yang tidak mempunyai asosiasi dengan operasi di kelas
     * maka alurnya adalah sebagai berikut:
     * Message.receiveEvent = Fragment.id -> Get Fragment.covered
     * Fragment.covered = Lifeline.id -> get Lifeline.represent
     * Lifeline.represent = SequenceOwnedAttribute.id -> get SequenceOwnedAttribute.type
     *
     * Jika type tidak ada, maka lifeline tidak mempunyai asosiasi dengan kelas:
     * Message.name = OwnedOperation.name-> get OwnedOperation.associatedClass
     * Jika OwnedOperation.associatedClass = Lifeline.name maka konsisten, jika sebaliknya maka inkonsisten
     *
     * Jika type ada, maka lifeline mempunyai asosiasi dengan kelas:
     * Message.name = OwnedOperation.name -> get OwnedOperation.associatedClass
     * SequenceAttribute.type = ClassName.id -> get ClassName.name
     * Jika ClassName.name = OwnedOperation.associatedClass maka konsisten, jika sebaliknya maka inkonsisten
     */
    void checkMessageAssociationDirection() {
        for (int i = 0; i < Message.messageList.size(); i++) {
            for (int j = 0; j < Fragment.fragmentList.size(); j++) {
                if (Message.messageList.get(i).getReceiveEvent().equals(Fragment.fragmentList.get(j).getId())) {
                    for (int k = 0; k < Lifeline.lifelineList.size(); k++) {
                        if (Fragment.fragmentList.get(j).getCovered().equals(Lifeline.lifelineList.get(k).getId())) {
                            for (int l = 0; l < ClassOwnedOperation.operationList.size(); l++) {
                                if (!Message.messageList.get(i).getSignature().equals("no signature")) {
                                    if (Message.messageList.get(i).getSignature().equals(ClassOwnedOperation.operationList.get(l).getId()) && !Lifeline.lifelineList.get(k).getName().equalsIgnoreCase(ClassOwnedOperation.operationList.get(l).getAssociatedClass())) {
                                        for (int m = 0; m < SequenceOwnedAttribute.attributeList.size(); m++) {
                                            if (Lifeline.lifelineList.get(k).getRepresent().equals(SequenceOwnedAttribute.attributeList.get(m).getId()) && !SequenceOwnedAttribute.attributeList.get(m).getType().isEmpty()) {
                                                for (int o = 0; o < ClassName.classNameArrayList.size(); o++) {
                                                    if (SequenceOwnedAttribute.attributeList.get(m).getType().equals(ClassName.classNameArrayList.get(o).getId()) && !ClassName.classNameArrayList.get(o).getName().equalsIgnoreCase(ClassOwnedOperation.operationList.get(l).getAssociatedClass())) {
                                                        addSuspectLifelineReceiver(Message.messageList.get(i).getOperationName(), Message.messageList.get(i).getArgument(), ClassName.classNameArrayList.get(o).getName());
                                                        break;
                                                    }
                                                }
                                            }
                                            if (Lifeline.lifelineList.get(k).getRepresent().equals(SequenceOwnedAttribute.attributeList.get(m).getId()) && SequenceOwnedAttribute.attributeList.get(m).getType().isEmpty()) {
                                                /*Gak bisa pake type,
                                                nanti yang lifeline bener gak kedetect*/
                                                addSuspectLifelineReceiver(ClassOwnedOperation.operationList.get(l).getName(), ClassOwnedOperation.operationList.get(l).getParameter(), Lifeline.lifelineList.get(k).getName());
                                                break;
                                            }
                                        }
                                    }
                                } else if (Message.messageList.get(i).getSignature().equals("no signature")) {
                                    if (Message.messageList.get(i).getName().equals(ClassOwnedOperation.operationList.get(l).getName()) && !Lifeline.lifelineList.get(k).getName().equalsIgnoreCase(ClassOwnedOperation.operationList.get(l).getAssociatedClass())) {
                                        for (int m = 0; m < SequenceOwnedAttribute.attributeList.size(); m++) {
                                            /*tambahin else if
                                             * kalo misal lifelinenya bener*/
                                            if (Lifeline.lifelineList.get(k).getRepresent().equals(SequenceOwnedAttribute.attributeList.get(m).getId()) && !SequenceOwnedAttribute.attributeList.get(m).getType().isEmpty()) {
                                                for (int o = 0; o < ClassName.classNameArrayList.size(); o++) {
                                                    if (SequenceOwnedAttribute.attributeList.get(m).getType().equals(ClassName.classNameArrayList.get(o).getId()) && !ClassName.classNameArrayList.get(o).getName().equalsIgnoreCase(ClassOwnedOperation.operationList.get(l).getAssociatedClass())) {
                                                        addSuspectLifelineReceiver(Message.messageList.get(i).getName(), Message.messageList.get(i).getArgument(), ClassName.classNameArrayList.get(o).getName());
                                                        break;
                                                    }
                                                }
                                            }
                                            if (Lifeline.lifelineList.get(k).getRepresent().equals(SequenceOwnedAttribute.attributeList.get(m).getId()) && SequenceOwnedAttribute.attributeList.get(m).getType().isEmpty()) {
                                                /*Gak bisa pake type,
                                                nanti yang lifeline bener gak kedetect*/
                                                addSuspectLifelineReceiver(Message.messageList.get(i).getName(),Message.messageList.get(i).getArgument(), Lifeline.lifelineList.get(k).getName());
                                                break;
                                            }
                                        }
                                        break;
                                    }
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

    /** method argoUMLMessage
     * digunakan untuk membentuk struktur message yang semirip mungkin
     * dengan struktur yang didapat dari StarUML.
     */
    void argoUMLMessage(){
        for (int i = 0; i < Message.messageList.size(); i++){
            for (int j = 0; j < SendAction.sendActionArrayList.size(); j++){
                if (Message.messageList.get(i).getOperationName().equals(SendAction.sendActionArrayList.get(j).getId())){
                    Message.messageList.get(i).setOperationName(SendAction.sendActionArrayList.get(j).getName());
                }
            }
        }

    }

    /** method checkReply untuk mengecek reply yang ada
     * apakah ada triggernya atau tidak
     */
    void checkReply() {
        Message suspect, message;
        for (int i = 0; i < Suspect.replySuspectList.size(); i++){
            suspect = Suspect.replySuspectList.get(i);
            System.out.println(suspect.getCounter() + "+" + suspect.getParent());
            for (int j = 0; j < suspect.getCounter() + 1; j++){
                message = Message.messageList.get(j);
                if (suspect.getParent().equals(message.getParent()) && suspect.getReceiveEvent().equals(message.getSendEvent()) && suspect.getSendEvent().equals(message.getReceiveEvent())){
                    Suspect.replySuspectList.remove(suspect);
                    i--;
                }
            }
        }

    }
}