package project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public abstract class Main implements ActionListener {
    public static void main(String[] args){
        //Inisiasi
        makeGUI();
        System.out.println("\nProses Selesai!");
    }

    static private void makeGUI(){
        final String[] inputFile = new String[1];

        JFrame jFrame1 = new JFrame();
        jFrame1.setTitle("UML Diagram Consistency Checking");
        jFrame1.setSize(800,600);
        jFrame1.setLayout(new BorderLayout());
        jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame1.setLocationRelativeTo(null);

        JLabel labelProcessMessage = new JLabel(" ");

        JTextField textFieldFilename = new JTextField(20);
        textFieldFilename.setEditable(false);

        //Nama textarea sesuai yang ingin ditampilkan
        //sementara pake 1, 2, 3, 4 ...
        JTextArea textAreaOperation = new JTextArea(20,13);
        textAreaOperation.setEditable(false);
        textAreaOperation.setLineWrap(true);
        textAreaOperation.setWrapStyleWord(true);

        JLabel labelOperationTextArea = new JLabel("Class Operation");
        labelOperationTextArea.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelOperation = new JPanel();
        panelOperation.setLayout(new BorderLayout());
        panelOperation.add(labelOperationTextArea, "North");
        panelOperation.add(new JScrollPane(textAreaOperation), "Center");

        JTextArea textAreaAttribute = new JTextArea(20,13);
        textAreaAttribute.setEditable(false);
        textAreaAttribute.setLineWrap(true);
        textAreaAttribute.setWrapStyleWord(true);

        JLabel labelAttributeTextArea = new JLabel("Class Attribute");
        labelAttributeTextArea.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelAttribute = new JPanel();
        panelAttribute.setLayout(new BorderLayout());
        panelAttribute.add(labelAttributeTextArea, "North");
        panelAttribute.add(new JScrollPane(textAreaAttribute), "Center");

        JTextArea textAreaClassName = new JTextArea(20,10);
        textAreaClassName.setEditable(false);
        textAreaClassName.setLineWrap(true);
        textAreaClassName.setWrapStyleWord(true);

        JLabel labelTextAreaClassName = new JLabel("Class Name");
        labelTextAreaClassName.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelClassName = new JPanel();
        panelClassName.setLayout(new BorderLayout());
        panelClassName.add(labelTextAreaClassName, "North");
        panelClassName.add(new JScrollPane(textAreaClassName), "South");

        JTextArea textAreaMessage = new JTextArea(20,16);
        textAreaMessage.setEditable(false);
        textAreaMessage.setLineWrap(true);
        textAreaMessage.setWrapStyleWord(true);

        JLabel labelMessage = new JLabel("Message");
        labelMessage.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelMessage = new JPanel();
        panelMessage.setLayout(new BorderLayout());
        panelMessage.add(labelMessage, "North");
        panelMessage.add(new JScrollPane(textAreaMessage), "South");

        JTextArea textArea5 = new JTextArea(20,13);
        textArea5.setEditable(false);
        textArea5.setLineWrap(true);
        textArea5.setWrapStyleWord(true);
//            textArea5.setMargin(new Insets(5, 5, 5, 5));
        // kalo mau pake margin
        JLabel labelTextArea5 = new JLabel("Text Area 5");
        labelTextArea5.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelTextArea5 = new JPanel();
        panelTextArea5.setLayout(new BorderLayout());
        panelTextArea5.add(labelTextArea5, "North");
        panelTextArea5.add(new JScrollPane(textArea5), "South");

        JTextArea textAreaExecutionMessage = new JTextArea(10,20);
        textAreaExecutionMessage.setEditable(false);
        textAreaExecutionMessage.setLineWrap(true);
        textAreaExecutionMessage.setWrapStyleWord(true);
//            textAreaExecutionMessage.setMargin(new Insets(5, 5, 5, 5));

        JLabel labelExecutionMessage = new JLabel("MessageList");
        labelExecutionMessage.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelExecutionMessage = new JPanel();
        panelExecutionMessage.setLayout(new BorderLayout());
        panelExecutionMessage.add(labelExecutionMessage,"North");
        panelExecutionMessage.add(new JScrollPane(textAreaExecutionMessage),"South");

        JTextArea textAreaExecutionOperation = new JTextArea(10,20);
        textAreaExecutionOperation.setEditable(false);
        textAreaExecutionOperation.setLineWrap(true);
        textAreaExecutionOperation.setWrapStyleWord(true);
//            textAreaExecutionOperation.setMargin(new Insets(5, 5, 5, 5));

        JLabel labelExecutionOperation = new JLabel("ClassOperation");
        labelExecutionOperation.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelExecutionOperation = new JPanel();
        panelExecutionOperation.setLayout(new BorderLayout());
        panelExecutionOperation.add(labelExecutionOperation,"North");
        panelExecutionOperation.add(new JScrollPane(textAreaExecutionOperation),"South");

        JTextArea textAreaExecutionSuspect = new JTextArea(10,20);
        textAreaExecutionSuspect.setEditable(false);
        textAreaExecutionSuspect.setLineWrap(true);
        textAreaExecutionSuspect.setWrapStyleWord(true);
//            textAreaExecutionSuspect.setMargin(new Insets(0, 0, 0, 0));

        JLabel labelExecutionSuspect = new JLabel("SuspectList");
        labelExecutionSuspect.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelExecutionSuspect = new JPanel();
        panelExecutionSuspect.setLayout(new BorderLayout());
        panelExecutionSuspect.add(labelExecutionSuspect,"North");
        panelExecutionSuspect.add(new JScrollPane(textAreaExecutionSuspect),"South");

        JTextArea textAreaExecutionLog = new JTextArea(10, 20);
        textAreaExecutionLog.setEditable(false);
        textAreaExecutionLog.setLineWrap(true);
        textAreaExecutionLog.setWrapStyleWord(true);

        JLabel labelExecutionLog = new JLabel("Log");
        labelExecutionLog.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelLogExecution = new JPanel();
        panelLogExecution.setLayout(new BorderLayout());
        panelLogExecution.add(labelExecutionLog, "North");
        panelLogExecution.add(new JScrollPane(textAreaExecutionLog),"South");

        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        FileNameExtensionFilter xmiFilter = new FileNameExtensionFilter("XMI File","xmi");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(xmiFilter);

        JPanel containerPage1 = new JPanel();
        containerPage1.setLayout(new BoxLayout(containerPage1,BoxLayout.Y_AXIS));

        JPanel containerPage2 = new JPanel();
        containerPage2.setLayout(new BoxLayout(containerPage2,BoxLayout.Y_AXIS));

        JPanel panelFileChooser = new JPanel();

        JPanel panelFunctionButton = new JPanel();
        panelFunctionButton.setLayout(new FlowLayout());

        JPanel panelTableList = new JPanel();
        panelTableList.setLayout(new FlowLayout());

        JPanel panelProcessMessage = new JPanel();
        panelProcessMessage.setLayout(new FlowLayout());

        JPanel panelExecutionTableList = new JPanel();
        panelExecutionTableList.setLayout(new GridBagLayout());

        JPanel panelExecution = new JPanel();
        panelExecution.setLayout(new GridBagLayout());

        JPanel panelExecutionButtonBack = new JPanel();
        panelExecutionButtonBack.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelExecutionButtonBack.setBorder(BorderFactory.createEmptyBorder(0,0,55,0));

        JButton buttonOpen = new JButton("Open");
        buttonOpen.addActionListener(e -> {
            if (!Message.messageList.isEmpty()){
                labelProcessMessage.setText("Please click Clear button");
                labelProcessMessage.setVisible(true);
            } else {
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println(selectedFile.getAbsolutePath());
                    textFieldFilename.setText(selectedFile.getAbsolutePath());
                    inputFile[0] = selectedFile.toString();
                }
                if (inputFile[0] != null) {
                    labelProcessMessage.setText(" ");
                    executeProcess(inputFile[0]);
                }
                for (int i = 0; i < ClassOwnedOperation.operationList.size(); i++) {
                    textAreaOperation.append(i + 1 + ". " + ClassOwnedOperation.operationList.get(i).getName() + " " + ClassOwnedOperation.operationList.get(i).getParameter() + "\n");
                }
                for (int i = 0; i < ClassOwnedAttribute.attributeList.size(); i++) {
                    textAreaAttribute.append(i + 1 + ". " + ClassOwnedAttribute.attributeList.get(i).getName() + "\n");
                }
                for (int i = 0; i < ClassName.classNameArrayList.size(); i++) {
                    textAreaClassName.append(i + 1 + ". " + ClassName.classNameArrayList.get(i).getName() + "\n");
                }
                for (int i = 0; i < Message.messageList.size(); i++) {
                    textAreaMessage.append(i + 1 + ". " + Message.messageList.get(i).getOperationName() + " " + Message.messageList.get(i).getArgument() + "\n");
                }
            }
        });

/*        JButton buttonRun = new JButton("Read");
        buttonRun.addActionListener(e -> {
                if (inputFile[0] != null){
                    labelProcessMessage.setText(" ");
                    executeProcess(inputFile[0]);
                } else {
                    labelProcessMessage.setText("File not found");
                    labelProcessMessage.setVisible(true);
                }
                for (int i = 0; i < ClassOwnedOperation.operationList.size(); i++){
                    textAreaOperation.append(i + 1 + ". " + ClassOwnedOperation.operationList.get(i).getName() + " " + ClassOwnedOperation.operationList.get(i).getParameter() + "\n");
                }
                for (int i = 0; i < ClassOwnedAttribute.attributeList.size(); i++){
                    textAreaAttribute.append(i + 1 + ". " + ClassOwnedAttribute.attributeList.get(i).getName() + "\n");
                }
                for (int i = 0; i < SequenceOwnedAttribute.attributeList.size(); i++){
                    textAreaClassName.append(i + 1 + ". " + SequenceOwnedAttribute.attributeList.get(i).getName() + "\n");
                }
                for (int i = 0; i < Message.messageList.size(); i++){
                    textAreaMessage.append(i + 1 + ". " + Message.messageList.get(i).getOperationName() + " " + Message.messageList.get(i).getArgument() + "\n");
                }
        });*/

        JButton buttonExecute = new JButton("Execute");
        buttonExecute.addActionListener(e -> {
            if (inputFile[0] != null){
                jFrame1.getContentPane().removeAll();
                jFrame1.getContentPane().repaint();
                jFrame1.getContentPane().add(containerPage2);
                jFrame1.revalidate();
                for (int i = 0; i < Message.messageList.size(); i++) {
                    textAreaExecutionMessage.append(i + 1 + ". " + Message.messageList.get(i).getOperationName() + Message.messageList.get(i).getArgument() + "\n");
                }
//                textAreaExecutionMessage.setCaretPosition(1);
                for (int i = 0; i < ClassOwnedOperation.operationList.size(); i++) {
                    textAreaExecutionOperation.append(i + 1 + ". " + ClassOwnedOperation.operationList.get(i).getName() + " " + ClassOwnedOperation.operationList.get(i).getParameter() + "\n");
                }
//                textAreaExecutionOperation.setCaretPosition(1);
                if (!Suspect.unknownMessageList.isEmpty()) {
                    CoreProcess.inconsistencyChecking(Suspect.unknownMessageList, ClassOwnedOperation.operationList);
                    for (int i = 0; i < Suspect.unknownMessageList.size(); i++) {
                        textAreaExecutionSuspect.append(i + 1 + ". " + Suspect.unknownMessageList.get(i).getName() + " " + Suspect.unknownMessageList.get(i).getArgument() + "\n");
                    }
//                    textAreaExecutionSuspect.setCaretPosition(1);
                }
                textAreaExecutionLog.append("Proses selesai!! Elemen diagram kelas dan diagram sekuens sudah didapatkan\n" + "------------------------------------------------------------------------------------------------------------------------------------\n");
                if (Suspect.unknownMessageList.isEmpty()){
                    textAreaExecutionLog.append("MANTAP!! Tidak ada message yang tidak konsisten\nSELAMAT!!");
                } else {
                    textAreaExecutionLog.append("Terdapat " + Suspect.unknownMessageList.size() + " message yang tidak konsisten / tidak ada di daftar fungsi di kelas, yaitu\n");
                    for (int i = 0; i < Suspect.unknownMessageList.size(); i++) {
                        textAreaExecutionLog.append(i + 1 + ". " + Suspect.unknownMessageList.get(i).getName() + " " + Suspect.unknownMessageList.get(i).getArgument() + "\n");
                    }
                    textAreaExecutionLog.append("------------------------------------------------------------------------------------------------------------------------------------\n");
                    if (!Suspect.assocWarningList.isEmpty()) {
                        textAreaExecutionLog.append("WARNING!!!\n" + "Terdapat message pada diagram sekuens yang tidak terasosiasi dengan diagram kelas, yaitu\n");
                        for (int i = 0; i < Suspect.assocWarningList.size(); i++) {
                            textAreaExecutionLog.append(i + 1 + ". " + Suspect.assocWarningList.get(i).getName() + " " + Suspect.assocWarningList.get(i).getArgument() + "\n");
                        }
//                        textAreaExecutionLog.setCaretPosition(1);
                    }
                }
            } else {
//                    System.out.println("bala bala");
                labelProcessMessage.setText("File not found");
                labelProcessMessage.setVisible(true);
            }
        });

        JButton buttonClear = new JButton("Clear");
        buttonClear.addActionListener(e -> {
            ClassOwnedOperation.operationList.clear();
            ClassOwnedAttribute.attributeList.clear();
            ClassName.classNameArrayList.clear();
            Fragment.fragmentList.clear();
            Lifeline.lifelineList.clear();
            Message.messageList.clear();
            SequenceOwnedAttribute.attributeList.clear();
            Suspect.unknownMessageList.clear();
            Suspect.assocWarningList.clear();
            textAreaOperation.setText("");
            textAreaAttribute.setText("");
            textAreaClassName.setText("");
            textAreaMessage.setText("");
            textArea5.setText("");
            textAreaExecutionMessage.setText("");
            textAreaExecutionOperation.setText("");
            textAreaExecutionSuspect.setText("");
            textFieldFilename.setText("");
            labelProcessMessage.setText(" ");
            textAreaExecutionLog.setText("");
            inputFile[0] = null;
        });

        JButton buttonBack = new JButton("Back");
        buttonBack.addActionListener(actionEvent -> {
//            Suspect.unknownMessageList.clear();
            textAreaExecutionSuspect.setText("");
            textAreaExecutionLog.setText("");
            textAreaExecutionMessage.setText("");
            textAreaExecutionOperation.setText("");
            labelProcessMessage.setText("");
            jFrame1.getContentPane().removeAll();
            jFrame1.getContentPane().repaint();
            jFrame1.getContentPane().add(containerPage1);
            jFrame1.revalidate();
        });

        panelFileChooser.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelFileChooser.setBorder(new EmptyBorder(30,0,0,0));
        panelFileChooser.add(textFieldFilename);
        panelFileChooser.add(buttonOpen);

        panelProcessMessage.add(labelProcessMessage);

//            panelFunctionButton.add(buttonRun);
        panelFunctionButton.add(buttonExecute);
        panelFunctionButton.add(buttonClear);

            /*panelTableList.add(new JScrollPane(panelOperation), "Center");
            panelTableList.add(new JScrollPane(panelAttribute), "Center");
            panelTableList.add(new JScrollPane(panelClassName), "Center");
            panelTableList.add(new JScrollPane(panelMessage), "Center");
            panelTableList.add(new JScrollPane(panelTextArea5), "Center");*/
        JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panelOperation,panelAttribute);
        JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panelClassName,panelMessage);
//        JSplitPane splitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane1, panelClassName);
        JSplitPane splitPane4 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane1,splitPane2);
        panelTableList.add(splitPane4);

        containerPage1.add(panelFileChooser);
        containerPage1.add(panelProcessMessage);
        containerPage1.add(panelFunctionButton);
        containerPage1.add(panelTableList);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelExecutionMessage, panelExecutionOperation);
        splitPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        panelExecutionTableList.add(splitPane);
        panelExecutionTableList.add(panelExecutionSuspect);

        JSplitPane splitPaneLog = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelExecutionTableList, panelLogExecution);
        panelExecutionButtonBack.add(buttonBack);

        panelExecution.add(splitPaneLog);
        containerPage2.add(panelExecution);
        containerPage2.add(panelExecutionButtonBack);

        jFrame1.add(containerPage1);

        jFrame1.setVisible(true);
    }

    static private void executeProcess(String inputFile){
        //Inisiasi

        /*XML Read and Extraction*/
        XPathHandler.main(inputFile);


//            Fragment.printFragmentList();
//            SequenceOwnedAttribute.printAttributeList();
//            ClassOwnedAttribute.printAttributeList();
//        ClassOwnedOperation.printOperationList();
        CoreProcess.checkSignature();
        CoreProcess.checkingRepresent();
//        Lifeline.printLifelineList();
//            Message.printMessageList();

//        System.out.println(ClassName.classNameArrayList.size());
//        System.out.println(Suspect.lifelineLists.size());
//        System.out.println(Suspect.lifelineLists.toString());

//            CoreProcess.inconsistencyChecking(Message.messageList, ClassOwnedOperation.operationList);
    }
}