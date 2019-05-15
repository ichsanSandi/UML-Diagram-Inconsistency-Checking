package project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public abstract class Main implements ActionListener {
    public static void main(String[] args) {
        //Inisiasi
        makeGUI();
        System.out.println("\nProses Selesai!");
    }

    static private void makeGUI() {
        final String[] inputFile = new String[1];

        /*Inisiasi window frame utama*/
        JFrame jFrame1 = new JFrame();
        jFrame1.setTitle("UML Diagram Consistency Checking");
        jFrame1.setSize(800, 600);
        jFrame1.setLayout(new BorderLayout());
        jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame1.setLocationRelativeTo(null);

        JLabel labelInputFile = new JLabel("Masukkan file XMI");

        /*Label untuk menampilkan respon pada program*/
        JLabel labelProcessMessage = new JLabel("Silakan pilih file XMI dengan mengklik tombol Open");

        /*Textfield untuk meletakkan alamat file XML*/
        JTextField textFieldFilename = new JTextField(20);
        textFieldFilename.setEditable(false);

        /*
         * Text area untuk menampilkan list operasi yang ada pada kelas
         * Label untuk memberikan judul pada kolom
         * Panel untuk meletakkan textarea dan label
         * */
        JTextArea textAreaOperation = new JTextArea(11, 32);
        textAreaOperation.setEditable(false);
        textAreaOperation.setLineWrap(true);
        textAreaOperation.setWrapStyleWord(true);

        JLabel labelOperationTextArea = new JLabel("Class Diagram");
        labelOperationTextArea.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelOperation = new JPanel();
        panelOperation.setLayout(new BorderLayout());
        panelOperation.add(labelOperationTextArea, "North");
        panelOperation.add(new JScrollPane(textAreaOperation, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS), "South");

        /*
         * Text area untuk menampilkan list atribut yang ada pada kelas
         * Label untuk memberikan judul pada kolom
         * Panel untuk meletakkan textarea dan label
         * */
//        JTextArea textAreaAttribute = new JTextArea(20, 13);
//        textAreaAttribute.setEditable(false);
//        textAreaAttribute.setLineWrap(true);
//        textAreaAttribute.setWrapStyleWord(true);
//
//        JLabel labelAttributeTextArea = new JLabel("Class Attribute");
//        labelAttributeTextArea.setHorizontalAlignment(SwingConstants.CENTER);
//
//        JPanel panelAttribute = new JPanel();
//        panelAttribute.setLayout(new BorderLayout());
//        panelAttribute.add(labelAttributeTextArea, "North");
//        panelAttribute.add(new JScrollPane(textAreaAttribute), "Center");

        /*
         * Text area untuk menampilkan list nama kelas yang ada pada kelas diagram
         * Label untuk memberikan judul pada kolom
         * Panel untuk meletakkan textarea dan label*/
//        JTextArea textAreaClassName = new JTextArea(20, 10);
//        textAreaClassName.setEditable(false);
//        textAreaClassName.setLineWrap(true);
//        textAreaClassName.setWrapStyleWord(true);
//
//        JLabel labelTextAreaClassName = new JLabel("Class Name");
//        labelTextAreaClassName.setHorizontalAlignment(SwingConstants.CENTER);
//
//        JPanel panelClassName = new JPanel();
//        panelClassName.setLayout(new BorderLayout());
//        panelClassName.add(labelTextAreaClassName, "North");
//        panelClassName.add(new JScrollPane(textAreaClassName), "South");

        /*
         * Text area untuk menampilkan list message yang ada di diagram sekuens
         * Label untuk memberikan judul pada kolom
         * Panel untuk meletakkan textarea dan label*/
        JTextArea textAreaMessage = new JTextArea(11, 32);
        textAreaMessage.setEditable(false);
        textAreaMessage.setLineWrap(true);
        textAreaMessage.setWrapStyleWord(true);

        JLabel labelMessage = new JLabel("Sequence Diagram");
        labelMessage.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelMessage = new JPanel();
        panelMessage.setLayout(new BorderLayout());
        panelMessage.add(labelMessage, "North");
        panelMessage.add(new JScrollPane(textAreaMessage, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS), "South");

        /*
         * Text area untuk menampilkan list seluruh message pada halaman eksekusi
         * Label untuk memberikan judul pada kolom
         * Panel untuk meletakkan textarea dan label*/
//        JTextArea textAreaExecutionMessage = new JTextArea(10, 30);
//        textAreaExecutionMessage.setEditable(false);
//        textAreaExecutionMessage.setLineWrap(true);
//        textAreaExecutionMessage.setWrapStyleWord(true);
////            textAreaExecutionMessage.setMargin(new Insets(5, 5, 5, 5));
//
//        JLabel labelExecutionMessage = new JLabel("MessageList");
//        labelExecutionMessage.setHorizontalAlignment(SwingConstants.CENTER);
//
//        JPanel panelExecutionMessage = new JPanel();
//        panelExecutionMessage.setLayout(new BorderLayout());
//        panelExecutionMessage.add(labelExecutionMessage, "North");
//        panelExecutionMessage.add(new JScrollPane(textAreaExecutionMessage), "South");

        /*
         * Text area untuk menampilkan list seluruh operasi yang ada pada kelas
         * Label untuk memberikan judul pada kolom
         * Panel untuk meletakkan textarea dan label*/
//        JTextArea textAreaExecutionOperation = new JTextArea(10, 60);
//        textAreaExecutionOperation.setEditable(false);
//        textAreaExecutionOperation.setLineWrap(true);
//        textAreaExecutionOperation.setWrapStyleWord(true);
////            textAreaExecutionOperation.setMargin(new Insets(5, 5, 5, 5));
//
//        JLabel labelExecutionOperation = new JLabel("ClassOperation");
//        labelExecutionOperation.setHorizontalAlignment(SwingConstants.CENTER);
//
//        JPanel panelExecutionOperation = new JPanel();
//        panelExecutionOperation.setLayout(new BorderLayout());
//        panelExecutionOperation.add(labelExecutionOperation, "North");
//        panelExecutionOperation.add(new JScrollPane(textAreaExecutionOperation), "South");

        /*
         * Text area untuk menampilkan list message yang tidak ada pada daftar operasi kelas
         * Label untuk memberikan judul pada kolom
         * Panel untuk meletakkan textarea dan label*/
//        JTextArea textAreaExecutionSuspect = new JTextArea(10, 20);
//        textAreaExecutionSuspect.setEditable(false);
//        textAreaExecutionSuspect.setLineWrap(true);
//        textAreaExecutionSuspect.setWrapStyleWord(true);
////            textAreaExecutionSuspect.setMargin(new Insets(0, 0, 0, 0));
//
//        JLabel labelExecutionSuspect = new JLabel("SuspectList");
//        labelExecutionSuspect.setHorizontalAlignment(SwingConstants.CENTER);
//
//        JPanel panelExecutionSuspect = new JPanel();
//        panelExecutionSuspect.setLayout(new BorderLayout());
//        panelExecutionSuspect.add(labelExecutionSuspect, "North");
//        panelExecutionSuspect.add(new JScrollPane(textAreaExecutionSuspect), "South");

        /*
         * Text area untuk menampilkan log laporan pengecekan inkonsistensi
         * Label untuk memberikan judul pada kolom
         * Panel untuk meletakkan textarea dan label*/
        JTextArea textAreaExecutionReport = new JTextArea(12,34);
        textAreaExecutionReport.setEditable(false);
        textAreaExecutionReport.setLineWrap(true);
        textAreaExecutionReport.setWrapStyleWord(true);

        JLabel labelExecutionLog = new JLabel("Report");
        labelExecutionLog.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panelReportExecution = new JPanel();
        panelReportExecution.setLayout(new BorderLayout());
        panelReportExecution.add(labelExecutionLog, "North");
        panelReportExecution.add(new JScrollPane(textAreaExecutionReport, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS), "South");

        /*
         * fileChooser digunakan untuk mengambil alamat dari file xml yang ingin dicek*/
        JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        FileNameExtensionFilter xmiFilter = new FileNameExtensionFilter("XMI File", "xmi");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(xmiFilter);

        /*
        containerPage1 digunakan untuk menampilkan halaman awal
         */
        JPanel containerPage1 = new JPanel();
        containerPage1.setLayout(new BoxLayout(containerPage1, BoxLayout.Y_AXIS));

        /*
        containerPage2 digunakan untuk menampilkan halaman eksekusi
         */
//        JPanel containerPage2 = new JPanel();
//        containerPage2.setLayout(new BoxLayout(containerPage2, BoxLayout.Y_AXIS));

        /*
        panel yang digunakan untuk meletakkan filechooser dan tombol open
         */
        JPanel panelFileChooser = new JPanel();

        /*
        panel yang digunakan untuk meletakkan button execute dan clear
         */
        JPanel panelFunctionButton = new JPanel();
        panelFunctionButton.setLayout(new FlowLayout());

        /*
        panel yang digunakan untuk meletakkan panel dari masing-masing
        textarea daftar nama kelas, textarea daftar atribut kelas,
        textarea daftar operasi kelas, dan textarea daftar message
         */
        JPanel panelTableList = new JPanel();
        panelTableList.setLayout(new FlowLayout());

        /*
        panel yang digunakan untuk meletakkan label respon program
         */
        JPanel panelProcessMessage = new JPanel();
        panelProcessMessage.setLayout(new FlowLayout());

        /*
        panel yang digunakan untuk meletakkan panel textarea daftar message,
        daftar operasi kelas, dan daftar message yang tidak ada pada daftar operasi
        pada halaman eksekusi/halaman kedua
         */
        JPanel panelExecutionTableList = new JPanel();
        panelExecutionTableList.setLayout(new GridBagLayout());

        /*
        panel yang digunakan untuk meletakkan seluruh komponen textarea pada halaman eksekusi/halaman kedua
        yang berisi textarea daftar message, textarea daftar operasi, textarea daftar message yang tidak ada pada
        daftar operasi, dan textarea untuk log
         */
        JPanel panelExecution = new JPanel();
        panelExecution.setLayout(new GridBagLayout());

        /*
        panel yang digunakan untuk meletakkan tombol back
         */
        JPanel panelExecutionButtonBack = new JPanel();
        panelExecutionButtonBack.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelExecutionButtonBack.setBorder(BorderFactory.createEmptyBorder(0, 0, 55, 0));

        //fungsi tombol button
        JButton buttonOpen = new JButton("Open");
        buttonOpen.addActionListener(e -> {
            boolean isConsistent = true;
            if (!Message.messageList.isEmpty()) {
                labelProcessMessage.setText("Tekan tombol reset dahulu untuk memulai kembali");
                labelProcessMessage.setVisible(true);
            } else {
                /*
                memilih file xmi, memberikan hasil berupa string alamat file xmi
                yang akan digunakan sebagai parameter pada fungsi executeProcess(inputfile[0])
                 */
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println(selectedFile.getAbsolutePath());
                    textFieldFilename.setText(selectedFile.getAbsolutePath());
                    inputFile[0] = selectedFile.toString();
                }
                if (inputFile[0] != null) {
                    labelProcessMessage.setText("Proses pembacaan file XMI selesai. Klik tombol reset jika ingin memulai kembali");
//                    textAreaMessage.append("Berikut ini daftar MESSAGE yang ada pada DIAGRAM SEKUENS:\n\n(LifelineSender -> Message -> LifelineReceiver)\n\n");
//                    textAreaOperation.append("Berikut ini daftar OPERATION yang ada pada DIAGRAM KELAS:\n");
                    executeProcess(inputFile[0]);
//                    textAreaMessage.setText("");
//                    textAreaOperation.setText("");
//                    textAreaExecutionReport.setText("");
                    textAreaMessage.append("Berikut ini daftar MESSAGE yang ada pada DIAGRAM SEKUENS:\n\n(LifelineSender -> Message -> LifelineReceiver)\n\n");
                    textAreaOperation.append("Berikut ini daftar OPERATION yang ada pada DIAGRAM KELAS:\n");

                    for (int i = 0; i < ClassName.classNameArrayList.size(); i++) {
                        textAreaOperation.append("\n" + ClassName.classNameArrayList.get(i).getName() + ":\n");
                        int counter = 1;
                        for (int j = 0; j < ClassOwnedOperation.operationList.size(); j++) {
                            if (ClassOwnedOperation.operationList.get(j).getAssociatedClass().equalsIgnoreCase(ClassName.classNameArrayList.get(i).getName())) {
                                textAreaOperation.append(counter + ". " + ClassOwnedOperation.operationList.get(j).getName() + ClassOwnedOperation.operationList.get(j).getParameter() + "\n");
                                counter++;
                            }
                        }
                    }
                    textAreaOperation.setCaretPosition(1);
                    for (int i = 0; i < Message.messageList.size(); i++) {
//                        textAreaMessage.append((i + 1) + ". " + Message.messageList.get(i).getCounter() + ": " + Message.messageList.get(i).getSendEvent() + " -> "+ Message.messageList.get(i).getOperationName() + Message.messageList.get(i).getArgument() + " -> " + Message.messageList.get(i).getReceiveEvent() + "\n");
                        textAreaMessage.append((i + 1) + ". " + Message.messageList.get(i).getSendEvent() + " -> "+ Message.messageList.get(i).getOperationName() + Message.messageList.get(i).getArgument() + " -> " + Message.messageList.get(i).getReceiveEvent() + "\n");
                    }
                    textAreaMessage.setCaretPosition(1);

                    textAreaExecutionReport.append("Rule 1: Message yang ada pada Diagram Sekuens harus merupakan operasi yang ada di salah satu kelas pada Diagram Kelas\n");
                    if (!Suspect.unknownMessageList.isEmpty()) {
                        isConsistent = false;
                        CoreProcess.inconsistencyChecking(Suspect.unknownMessageList, ClassOwnedOperation.operationList);
                        textAreaExecutionReport.append("\nPERINGATAN!1! RULE 1 TIDAK TERPENUHI\nTerdapat " + Suspect.unknownMessageList.size() + " message yang bukan merupakan operasi di kelas pada Diagram Kelas, yaitu:\n");
                        for (int i = 0; i < Suspect.unknownMessageList.size(); i++) {
                            textAreaExecutionReport.append(i + 1 + ". Message " + Suspect.unknownMessageList.get(i).getCounter() + ": " + Suspect.unknownMessageList.get(i).getSendEvent() + " -> " + Suspect.unknownMessageList.get(i).getName()+ Suspect.unknownMessageList.get(i).getArgument() + " -> " + Suspect.unknownMessageList.get(i).getReceiveEvent() + " tidak ada di daftar operasi yang ada pada kelas\n");

                        }
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    else {
                        textAreaExecutionReport.append("RULE 1 TERPENUHI\n");
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    textAreaExecutionReport.append("\nRule 2: Message yang ada pada Diagram Sekuens harus memiliki relasi / berasosiasi dengan operasi yang ada pada kelas di Diagram Kelas\n");
                    if (!Suspect.assocWarningList.isEmpty()) {
                        isConsistent = false;
                        textAreaExecutionReport.append("\nPERINGATAN!1! RULE 2 TIDAK TERPENUHI\nTerdapat " + Suspect.assocWarningList.size() + " message pada Diagram Sekuens yang tidak mempunyai relasi / tidak berasosiasi dengan operasi yang ada di kelas pada Diagram Kelas, yaitu:\n");
                        for (int i = 0; i < Suspect.assocWarningList.size(); i++) {
                            textAreaExecutionReport.append(i + 1 + ". Message " + Suspect.assocWarningList.get(i).getCounter() + ": " + Suspect.assocWarningList.get(i).getName() + " " + Suspect.assocWarningList.get(i).getArgument() + " tidak mempunyai relasi dengan operasi yang ada di kelas\n");
                        }
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    else {
                        textAreaExecutionReport.append("RULE 2 TERPENUHI\n");
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    textAreaExecutionReport.append("\nRule 3: Lifeline yang ada pada Diagram Sekuens harus merupakan salah satu kelas yang ada pada Diagram Kelas\n");
                    if (!Suspect.lifelineLists.isEmpty()) {
                        isConsistent = false;
                        textAreaExecutionReport.append("\nPERINGATAN!1! RULE 3 TIDAK TERPENUHI\nTerdapat " + Suspect.lifelineLists.size() + " Lifeline yang bukan merupakan kelas pada Diagram Kelas, yaitu:\n");
                        for (int i = 0; i < Suspect.lifelineLists.size(); i++) {
                            textAreaExecutionReport.append(i + 1 + ". Lifeline " + Suspect.lifelineLists.get(i) + " bukan merupakan kelas\n");
                        }
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    else {
                        textAreaExecutionReport.append("RULE 3 TERPENUHI\n");
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    textAreaExecutionReport.append("\nRule 4: Lifeline yang ada pada Diagram Sekuens harus memiliki relasi / berasosisasi dengan salah satu kelas yang ada pada Diagram Kelas\n");
                    if (!Suspect.lifelineAssocLists.isEmpty()) {
                        isConsistent = false;
                        textAreaExecutionReport.append("\nPERINGATAN!1! RULE 4 TIDAK TERPENUHI\nTerdapat " + Suspect.lifelineAssocLists.size() + " Lifeline yang tidak berelasi / berasosiasi dengan salah satu kelas pada Diagram Kelas, yaitu:\n");
                        for (int i = 0; i < Suspect.lifelineAssocLists.size(); i++) {
                            textAreaExecutionReport.append(i + 1 + ". Lifeline " + Suspect.lifelineAssocLists.get(i) + " tidak memiliki relasi\n");
                        }
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    else {
                        textAreaExecutionReport.append("RULE 4 TERPENUHI\n");
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    textAreaExecutionReport.append("\nRule 5: Message yang dikirimkan antara dua lifeline, harus merupakan operasi yang ada pada kelas Lifeline penerima\n");
                    if (!Suspect.classAssocWarningList.isEmpty()) {
                        isConsistent = false;
                        textAreaExecutionReport.append("\nPERINGATAN!!! RULE 5 TIDAK TERPENUHI\nTerdapat " + Suspect.classAssocWarningList.size() + " message yang bukan merupakan operasi dari kelas Lifeline penerima, yaitu:\n");
                        for (int i = 0; i < Suspect.classAssocWarningList.size(); i++) {
                            textAreaExecutionReport.append(i + 1 + ". " + "Message " + Suspect.classAssocWarningList.get(i).getName() + " " + Suspect.classAssocWarningList.get(i).getArgument() + " tidak terdaftar sebagai operasi pada kelas " + Suspect.classAssocWarningList.get(i).getClassAssoc() + "\n");
                        }
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    else {
                        textAreaExecutionReport.append("RULE 4 TERPENUHI\n");
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    if (isConsistent) {
                        textAreaExecutionReport.setCaretPosition(1);
                        textAreaExecutionReport.append("MANTAP!! Diagram Sekuens dan Diagram Kelas konsisten\nSELAMAT!!\n");
                    }
                    textAreaExecutionReport.setCaretPosition(1);
                }
                /*
                menampilkan hasil dari daftar operasi, atribut, dan nama kelas,
                dan daftar message pada masing-masing textarea
                 */
                /*for (int i = 0; i < ClassOwnedOperation.operationList.size(); i++) {
                    textAreaOperation.append(i + 1 + ". " + ClassOwnedOperation.operationList.get(i).getAssociatedClass() + " -> " + ClassOwnedOperation.operationList.get(i).getName() + ClassOwnedOperation.operationList.get(i).getParameter() + "\n");*/
//                }
                /*for (int i = 0; i < ClassOwnedAttribute.attributeList.size(); i++) {
                    textAreaAttribute.append(i + 1 + ". " + ClassOwnedAttribute.attributeList.get(i).getName() + "\n");
                }*/
                /*for (int i = 0; i < ClassName.classNameArrayList.size(); i++) {
                    textAreaClassName.append(i + 1 + ". " + ClassName.classNameArrayList.get(i).getName() + "\n");
                }*/
            }
        });

        /*JButton buttonExecute = new JButton("Run");
        buttonExecute.addActionListener(e -> {
            *//*
            kode untuk pindah ke halaman eksekusi/halaman kedua
            dan mengisi textarea yang ada dengan daftar message, operasi kelas,
            kelas yang tidak ada pada daftar operasi, dan log
             *//*
            if (inputFile[0] != null) {
                textAreaMessage.setText("");
                textAreaOperation.setText("");
                textAreaExecutionReport.setText("");
                labelProcessMessage.setText("Klik tombol reset jika ingin memulai kembali");
                textAreaMessage.append("Berikut ini daftar MESSAGE yang ada pada DIAGRAM SEKUENS:\n\n(LifelineSender -> Message -> LifelineReceiver)\n\n");
                textAreaOperation.append("Berikut ini daftar OPERATION yang ada pada DIAGRAM KELAS:\n");
//                jFrame1.getContentPane().removeAll();
//                jFrame1.getContentPane().repaint();
//                jFrame1.getContentPane().add(containerPage2);
//                jFrame1.revalidate();

//                for (int i = 0; i < ClassName.classNameArrayList.size(); i++) {
//                    textAreaOperation.append("\n" + ClassName.classNameArrayList.get(i).getName() + ":\n");
//                    int counter = 1;
//                    for (int j = 0; j < ClassOwnedOperation.operationList.size(); j++) {
//                        if (ClassOwnedOperation.operationList.get(j).getAssociatedClass().equalsIgnoreCase(ClassName.classNameArrayList.get(i).getName())) {
//                            textAreaOperation.append(counter + ". " + ClassOwnedOperation.operationList.get(j).getName() + ClassOwnedOperation.operationList.get(j).getParameter() + "\n");
//                            counter++;
//                        }
//                    }
//                }
//                textAreaOperation.setCaretPosition(1);
//                for (int i = 0; i < Message.messageList.size(); i++) {
//                    textAreaMessage.append((i + 1) + ". " + Message.messageList.get(i).getCounter() + ": " + Message.messageList.get(i).getSendEvent() + " -> "+ Message.messageList.get(i).getOperationName() + Message.messageList.get(i).getArgument() + " -> " + Message.messageList.get(i).getReceiveEvent() + "\n");
//                }
                textAreaMessage.setCaretPosition(1);
                for (int i = 0; i < Message.messageList.size(); i++) {
//                    textAreaExecutionMessage.append(i + 1 + ". " + Message.messageList.get(i).getOperationName() + Message.messageList.get(i).getArgument() + "\n");
                }
//                textAreaExecutionMessage.setCaretPosition(1);
                for (int i = 0; i < ClassOwnedOperation.operationList.size(); i++) {
//                    textAreaExecutionOperation.append(i + 1 + ". " + ClassOwnedOperation.operationList.get(i).getName() + " " + ClassOwnedOperation.operationList.get(i).getParameter() + "\n");
                }
//                textAreaExecutionOperation.setCaretPosition(1);
//                if (!Suspect.unknownMessageList.isEmpty()) {
//
//                    for (int i = 0; i < Suspect.unknownMessageList.size(); i++) {
////                        textAreaExecutionSuspect.append(i + 1 + ". Message " + Suspect.unknownMessageList.get(i).getCounter() + ": " + Suspect.unknownMessageList.get(i).getSendEvent() + " -> " + Suspect.unknownMessageList.get(i).getName() + Suspect.unknownMessageList.get(i).getArgument()+ " -> " + Suspect.unknownMessageList.get(i).getReceiveEvent() + "\n");
//                    }
////                    textAreaExecutionSuspect.setCaretPosition(1);
//                }
//                if (!Suspect.unknownMessageList.isEmpty()) {
//                    CoreProcess.inconsistencyChecking(Suspect.unknownMessageList, ClassOwnedOperation.operationList);
//                    textAreaExecutionReport.append("Terdapat " + Suspect.unknownMessageList.size() + " message yang tidak konsisten / tidak ada di daftar fungsi di kelas, yaitu\n");
//                    for (int i = 0; i < Suspect.unknownMessageList.size(); i++) {
//                        textAreaExecutionReport.append(i + 1 + ". Message " + Suspect.unknownMessageList.get(i).getCounter() + ": " + Suspect.unknownMessageList.get(i).getSendEvent() + " -> " + Suspect.unknownMessageList.get(i).getName()+ Suspect.unknownMessageList.get(i).getArgument() + " -> " + Suspect.unknownMessageList.get(i).getReceiveEvent() + " tidak ada di daftar operasi yang ada pada kelas\n");
//
//                    }
//                    textAreaExecutionReport.append("-----------------------------------------------------------------------------------------------------------------------------------------\n");
//                }
//                if (!Suspect.assocWarningList.isEmpty()) {
//                    textAreaExecutionReport.append("WARNING!!!\n" + "Terdapat message pada diagram sekuens yang tidak terasosiasi dengan diagram kelas, yaitu\n");
//                    for (int i = 0; i < Suspect.assocWarningList.size(); i++) {
//                        textAreaExecutionReport.append(i + 1 + ". Message " + Suspect.assocWarningList.get(i).getCounter() + ": " + Suspect.assocWarningList.get(i).getName() + " " + Suspect.assocWarningList.get(i).getArgument() + " tidak mempunyai asosiasi dengan operasi yang ada di kelas\n");
//                    }
//                    textAreaExecutionReport.append("-----------------------------------------------------------------------------------------------------------------------------------------\n");
////                        textAreaExecutionReport.setCaretPosition(1);
//                }
//                if (!Suspect.lifelineLists.isEmpty()) {
//                    textAreaExecutionReport.append("WARNING!!!\n" + "Terdapat Lifeline yang tidak konsisten, yaitu\n");
//                    for (int i = 0; i < Suspect.lifelineLists.size(); i++) {
//                        textAreaExecutionReport.append(i + 1 + ". Lifeline " + Suspect.lifelineLists.get(i) + " tidak ada di daftar kelas\n");
//                    }
//                    textAreaExecutionReport.append("-----------------------------------------------------------------------------------------------------------------------------------------\n");
////                        textAreaExecutionReport.setCaretPosition(1);
//                }
//                if (!Suspect.classAssocWarningList.isEmpty()) {
//                    textAreaExecutionReport.append("WARNING!!!\n" + "Terdapat message yang tidak konsisten, yaitu\n");
//                    for (int i = 0; i < Suspect.classAssocWarningList.size(); i++) {
//                        textAreaExecutionReport.append(i + 1 + ". " + "Message " + Suspect.classAssocWarningList.get(i).getName() + " " + Suspect.classAssocWarningList.get(i).getArgument() + " tidak terdaftar sebagai operasi pada kelas " + Suspect.classAssocWarningList.get(i).getClassAssoc() + "\n");
//                    }
//                    textAreaExecutionReport.append("-----------------------------------------------------------------------------------------------------------------------------------------\n");
//                } else if (Suspect.unknownMessageList.isEmpty()) {
//                    textAreaExecutionReport.append("MANTAP!! Tidak ada message yang tidak konsisten\nSELAMAT!!");
//                }
//                textAreaExecutionReport.setCaretPosition(1);
            } else {
//                    System.out.println("bala bala");
                labelProcessMessage.setText("File not found");
                labelProcessMessage.setVisible(true);
            }
        });*/

        JButton buttonReset = new JButton("Reset");
        /*
        fungsi untuk mengosongkan seluruh list dan textarea
        agar bisa digunkana kembali
         */
        buttonReset.addActionListener(e -> {
            ClassOwnedOperation.operationList.clear();
            ClassOwnedAttribute.attributeList.clear();
            ClassName.classNameArrayList.clear();
            Fragment.fragmentList.clear();
            Lifeline.lifelineList.clear();
            Message.messageList.clear();
            SequenceOwnedAttribute.attributeList.clear();
            Suspect.unknownMessageList.clear();
            Suspect.assocWarningList.clear();
            Suspect.lifelineLists.clear();
            Suspect.classAssocWarningList.clear();
            textAreaOperation.setText("");
//            textAreaAttribute.setText("");
//            textAreaClassName.setText("");
            textAreaMessage.setText("");
//            textAreaExecutionMessage.setText("");
//            textAreaExecutionOperation.setText("");
//            textAreaExecutionSuspect.setText("");
            textFieldFilename.setText("");
            labelProcessMessage.setText("Silakan pilih file XMI dengan mengklik tombol Open");
            textAreaExecutionReport.setText("");
            inputFile[0] = null;
        });

        JButton buttonBack = new JButton("Back");
        /*
        fungsi untuk berpindah dari halaman eksekusi/halaman kedua
        kembali ke halaman awal/halaman pertama
         */
        buttonBack.addActionListener(actionEvent -> {
//            Suspect.unknownMessageList.clear();
//            textAreaExecutionSuspect.setText("");
            textAreaExecutionReport.setText("");
//            textAreaExecutionMessage.setText("");
//            textAreaExecutionOperation.setText("");
            labelProcessMessage.setText("");
            jFrame1.getContentPane().removeAll();
            jFrame1.getContentPane().repaint();
            jFrame1.getContentPane().add(containerPage1);
            jFrame1.revalidate();
        });

        /*
        panel meletakkan tombol open
         */
        panelFileChooser.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelFileChooser.setBorder(new EmptyBorder(30, 0, 0, 0));
        panelFileChooser.add(labelInputFile);
        panelFileChooser.add(textFieldFilename);
        panelFileChooser.add(buttonOpen);
        panelFileChooser.add(buttonReset);

        /*
        panel meletakkan respon program
         */
        panelProcessMessage.add(labelProcessMessage);

        /*
        panel meletakkan tombol execute dan clear
         */
//            panelFunctionButton.add(buttonRun);
//        panelFunctionButton.add(buttonExecute);

            /*panelTableList.add(new JScrollPane(panelOperation), "Center");
            panelTableList.add(new JScrollPane(panelAttribute), "Center");
            panelTableList.add(new JScrollPane(panelClassName), "Center");
            panelTableList.add(new JScrollPane(panelMessage), "Center");
            panelTableList.add(new JScrollPane(panelTextArea5), "Center");*/

            /*
            menyusun susunan textarea pada halaman awal dan meletakkannya pada panelTableList
             */
        JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelOperation, panelMessage);
//        JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelClassName, panelMessage);
//        JSplitPane splitPane3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane1, panelClassName);
//        JSplitPane splitPane4 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane1, panelClassName);
        panelTableList.add(splitPane1);

        JSplitPane splitPanef = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelTableList ,panelReportExecution);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel1.add(splitPanef);

        /*
        container untuk menampung dan meletakkan seluruh element yang ada pada halaman awal
         */
        containerPage1.add(panelFileChooser);
        containerPage1.add(panelProcessMessage);
//        containerPage1.add(panelFunctionButton);
        containerPage1.add(panel1);

        /*
        panel untuk menyusun textarea daftar message dan operasi di halaman kedua
         */
//        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelExecutionMessage, panelExecutionOperation);
//        splitPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        /*
        panel untuk menambahkan panel textarea daftar message, operasi, dan message yang tidak
        ada pada daftar operasi
         */
//        panelExecutionTableList.add(splitPane);
//        panelExecutionTableList.add(panelExecutionSuspect);

        /*
        panel untuk split textarea daftar dan log
        dan menambahkan tombol back
         */
//        JSplitPane splitPaneLog = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelExecutionTableList, panelReportExecution);
        panelExecutionButtonBack.add(buttonBack);

//        panelExecution.add(panelReportExecution);

        /*
        container untuk menampung dan meletakkan seluruh element yang ada pada halaman kedua
         */
//        containerPage2.add(panelExecution);
//        containerPage2.add(panelExecutionButtonBack);

        jFrame1.add(containerPage1);

        jFrame1.setVisible(true);
    }

    static private void executeProcess(String inputFile) {
        //Inisiasi

        /*XML Read and Extraction*/
        XPathHandler.main(inputFile);


//        Fragment.printFragmentList();
//        SequenceOwnedAttribute.printAttributeList();
//        ClassOwnedAttribute.printAttributeList();
//        ClassOwnedOperation.printOperationList();
        CoreProcess.checkingNoise();
        CoreProcess.checkSignature();
        CoreProcess.checkMessageAssociationDirection();
        CoreProcess.checkingLifelineRepresent();
        CoreProcess.makeMessageTriplet();
//        Lifeline.printLifelineList();
//        Message.printMessageList();
//        ClassName.printClassName();

//        System.out.println(ClassName.classNameArrayList.size());
//        System.out.println(Suspect.unknownMessageList.size());
//        System.out.println(Suspect.classAssocWarningList.size());
//        System.out.println(Suspect.lifelineLists.toString());
//        System.out.println(Suspect.lifelineAssocLists.toString());
//        System.out.println(Lifeline.lifelineList.size());

//            CoreProcess.inconsistencyChecking(Message.messageList, ClassOwnedOperation.operationList);
    }
}