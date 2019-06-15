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
        jFrame1.setTitle("Deteksi Inkonsistensi Diagram Kelas dan Diagram Sekuens");
        jFrame1.setSize(1000, 700);
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
        JTextArea textAreaOperation = new JTextArea(13, 38);
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
         * Text area untuk menampilkan list message yang ada di diagram sekuens
         * Label untuk memberikan judul pada kolom
         * Panel untuk meletakkan textarea dan label*/
        JTextArea textAreaMessage = new JTextArea(13, 38);
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
         * Text area untuk menampilkan log laporan pengecekan inkonsistensi
         * Label untuk memberikan judul pada kolom
         * Panel untuk meletakkan textarea dan label*/
        JTextArea textAreaExecutionReport = new JTextArea(13,38);
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

        /*
        frame untuk popup
         */
        JFrame bantuanFrame = new JFrame("Bantuan");

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));

        JLabel howToUseLabel = new JLabel("Cara Penggunaan");
        howToUseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel howToUsePanel = new JPanel();
        howToUsePanel.setLayout(new BorderLayout());

        JTextArea howToUseTextArea = new JTextArea();
        howToUseTextArea.setEditable(false);
        howToUseTextArea.setLineWrap(true);
        howToUseTextArea.setWrapStyleWord(true);
        howToUseTextArea.setText(
                "1. Sebelum menggunakan program ini, siapkan dahulu file .xmi untuk diperiksa. File .xmi yang dieperiksa adalah file hasil export dari StarUML dengan menggunakan extension.\n2. Masukkan file .xmi yang akan diperiksa dengan menekan tombol Cari.\n3. Program akan secara otomatis memeriksa inkonsistensi dari file XMI yang dimasukkan.\n4. Kolom 'Class Diagram' berisi daftar kelas dan operasinya yang didapat dari diagram kelas.\n5. Kolom 'Sequence Diagram' berisi daftar message, termasuk lifeline pengirim dan penerimanya yang didapat dari diagram sekuens.\n6. Kolom 'Report' berisi log dari hasil pemeriksaan inkonsistensi file XMI."
        );
//        howToUsePanel.setBackground(Color.white);
        howToUsePanel.setBorder(BorderFactory.createCompoundBorder(howToUseTextArea.getBorder(),BorderFactory.createEmptyBorder(5,10,5,10)));
        howToUsePanel.add(howToUseLabel,"North");
        howToUsePanel.add(howToUseTextArea,"South");

        JLabel rulesLabel = new JLabel("Penjelasan Inkonsistensi");
        rulesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JTextArea rulesTextArea = new JTextArea();
        rulesTextArea.setEditable(false);
        rulesTextArea.setLineWrap(true);
        rulesTextArea.setWrapStyleWord(true);
        rulesTextArea.setText(
                "Inkonsistensi 1\n" +
                        "Diagram dikatakan tidak konsisten jika message yang ada di diagram sekuens tidak terdapat pada daftar operasi di diagram kelas.\n" + "Inkonsistensi 2\n" +
                        "Diagram dikatakan tidak konsisten jika message yang ada di diagram sekuens tidak memiliki atribut signature. Atribut signature dapat dilihat pada file XMI.\n" +
                        "Inkonsistensi 3\n" +
                        "Diagram dikatakan tidak konsisten jika lifeline yang ada di diagram sekuens bukan merupakan kelas.\n" +
                        "Inkonsistensi 4\n" +
                        "Diagram dikatakan tidak konsisten jika lifeline tidak memiliki kelas yang terasosisasi.\n" +
                        "Inkonsistensi 5\n" +
                        "Diagram dikatakan tidak konsisten jika message yang dikirimkan bukan merupakan operasi dari kelas lifeline penerima.\n" + "Inkonsistensi 6\n" +
                        "Diagram dikatakan tidak konsisten jika terdapat reply message yang muncul tanpa ada message yang memicunya"
        );
        JPanel rulesPanel = new JPanel();
        rulesPanel.setLayout(new BorderLayout());
        rulesPanel.setBorder(BorderFactory.createCompoundBorder(rulesTextArea.getBorder(),BorderFactory.createEmptyBorder(0,10,5,10)));

        rulesPanel.add(rulesLabel, "North");
        rulesPanel.add(rulesTextArea,"Center");

        container.add(howToUsePanel);
//        container.add(rulesPanel, BorderLayout.PAGE_END);
        bantuanFrame.add(container);

        JDialog dialog = new JDialog(bantuanFrame, "Bantuan & Penjelasan Aturan Inkonsistensi");
        dialog.setLayout(new BorderLayout());
        dialog.add(howToUsePanel,BorderLayout.PAGE_START);
        dialog.add(rulesPanel, BorderLayout.CENTER);
        dialog.setSize(500,550);
        dialog.setLocationRelativeTo(null);
        dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);

        //fungsi tombol cara penggunaan
        JButton buttonHelp = new JButton("Bantuan");
        buttonHelp.addActionListener(actionEvent -> {
            dialog.setVisible(true);
        });

        //fungsi tombol button
        JButton buttonOpen = new JButton("Cari");
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

                    executeProcess(inputFile[0]);

                    textAreaMessage.append("Berikut ini daftar MESSAGE yang ada pada DIAGRAM SEKUENS:\n\n(LifelineSender -> Message -> LifelineReceiver)\n\n");
                    textAreaOperation.append("Berikut ini daftar OPERATION yang ada pada DIAGRAM KELAS:\n");

                    for (int i = 0; i < ClassName.classNameArrayList.size(); i++) {
                        if (ClassName.classNameArrayList.get(i).getType().equals("uml:Actor")){
                            continue;
                        }
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
                        textAreaMessage.append((i + 1) + ". " + Message.messageList.get(i).getSendEvent() + " -> "+ Message.messageList.get(i).getOperationName() + Message.messageList.get(i).getArgument() + " -> " + Message.messageList.get(i).getReceiveEvent() + "\n");
                    }
                    textAreaMessage.setCaretPosition(1);

                    textAreaExecutionReport.append("Rule 1: Message yang ada pada Diagram Sekuens harus merupakan operasi yang ada di salah satu kelas pada Diagram Kelas\n");
                    if (!Suspect.unknownMessageList.isEmpty()) {
                        isConsistent = false;
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
                        textAreaExecutionReport.append("RULE 5 TERPENUHI\n");
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    textAreaExecutionReport.append("\nRule 6: Reply message harus memiliki message yang memicu untuk muncul \n");
                    if (!Suspect.replySuspectList.isEmpty()) {
                        isConsistent = false;
                        textAreaExecutionReport.append("\nPERINGATAN!!! RULE 6 TIDAK TERPENUHI\nTerdapat " + Suspect.replySuspectList.size() + " reply message yang muncul tanpa ada message pemicu yaitu:\n");
                        for (int i = 0; i < Suspect.replySuspectList.size(); i++) {
                            textAreaExecutionReport.append(i + 1 + ". " + "Message " + Suspect.replySuspectList.get(i).getCounter() + Suspect.replySuspectList.get(i).getName() + " " + Suspect.replySuspectList.get(i).getArgument() + "\n");
                        }
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    else {
                        textAreaExecutionReport.append("RULE 6 TERPENUHI\n");
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    if (isConsistent) {
                        textAreaExecutionReport.setCaretPosition(1);
                        textAreaExecutionReport.append("MANTAP!! Diagram Sekuens dan Diagram Kelas konsisten\nSELAMAT!!\n");
                    }
                    textAreaExecutionReport.setCaretPosition(1);
                }
            }
        });

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
            Suspect.replySuspectList.clear();
            Suspect.lifelineAssocLists.clear();
            textAreaOperation.setText("");
            textAreaMessage.setText("");
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
        panelFileChooser.add(buttonHelp);

        /*
        panel meletakkan respon program
         */
        panelProcessMessage.add(labelProcessMessage);

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
        /*XML Read and Extraction*/
        XPathHandler.main(inputFile);

        CoreProcess coreProcess = new CoreProcess();

//        Fragment.printFragmentList();
//        SequenceOwnedAttribute.printAttributeList();
//        ClassOwnedAttribute.printAttributeList();
//        ClassOwnedOperation.printOperationList();
        CoreProcess.inconsistencyChecking(Suspect.unknownMessageList, ClassOwnedOperation.operationList);
        coreProcess.checkingNoise();
        coreProcess.checkSignature();
        coreProcess.checkMessageAssociationDirection();
        coreProcess.checkingLifelineRepresent();
        coreProcess.makeMessageTriplet();
        coreProcess.checkReply();
//        Lifeline.printLifelineList();
//        ClassName.printClassName();

//        Message.printMessageList();
//        System.out.println(Suspect.replySuspectList.size());

//        System.out.println(ClassName.classNameArrayList.size());
//        System.out.println(Suspect.unknownMessageList.size());
//        System.out.println(Suspect.classAssocWarningList.size());
//        System.out.println(Suspect.lifelineLists.toString());
//        System.out.println(Suspect.lifelineAssocLists.toString());
//        System.out.println(Lifeline.lifelineList.size());

//            CoreProcess.inconsistencyChecking(Message.messageList, ClassOwnedOperation.operationList);
    }
}