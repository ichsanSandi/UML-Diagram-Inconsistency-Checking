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
        jFrame1.setTitle("Deteksi Ketidakkonsistenan Diagram Kelas dan Diagram Sekuens");
        jFrame1.setSize(1020, 720);
        jFrame1.setLayout(new BorderLayout());
        jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame1.setLocationRelativeTo(null);

        JLabel labelInputFile = new JLabel("Masukkan file XMI");

        /*Label untuk menampilkan respon pada program*/
        JLabel labelProcessMessage = new JLabel("<html><center>Silakan pilih file XMI dengan mengklik tombol 'Cari'<br/><br/><center><html>");

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

        JLabel labelOperationTextArea = new JLabel("Diagram Kelas");
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

        JLabel labelMessage = new JLabel("Diagram Sekuens");
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

        JLabel labelExecutionLog = new JLabel("Laporan");
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
        panel yang digunakan untuk meletakkan filechooser dan tombol Cari, Reset, dan Bantuan
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
                "1. Sebelum menggunakan program ini, siapkan dahulu file .xmi untuk diperiksa. File .xmi yang dieperiksa adalah file hasil export dari StarUML dengan menggunakan extension.\n2. Masukkan file .xmi yang akan diperiksa dengan menekan tombol Cari.\n3. Program akan secara otomatis memeriksa ketidakkonsistenan dari file XMI yang dimasukkan.\n4. Kolom 'Class Diagram' berisi daftar kelas dan operasinya yang didapat dari diagram kelas.\n5. Kolom 'Sequence Diagram' berisi daftar message, termasuk lifeline pengirim dan penerimanya yang didapat dari diagram sekuens.\n6. Kolom 'Report' berisi log dari hasil pemeriksaan ketidakkonsistenan file XMI."
        );
//        howToUsePanel.setBackground(Color.white);
        howToUsePanel.setBorder(BorderFactory.createCompoundBorder(howToUseTextArea.getBorder(),BorderFactory.createEmptyBorder(5,10,5,10)));
        howToUsePanel.add(howToUseLabel,"North");
        howToUsePanel.add(howToUseTextArea,"South");

        JLabel rulesLabel = new JLabel("Penjelasan Ketidakkonsistenan");
        rulesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JTextArea rulesTextArea = new JTextArea();
        rulesTextArea.setEditable(false);
        rulesTextArea.setLineWrap(true);
        rulesTextArea.setWrapStyleWord(true);
        rulesTextArea.setText(
                "Aturan ke-1\n" +
                        "Diagram dianggap tidak konsisten jika message yang ada di diagram sekuens tidak terdapat pada daftar operasi di diagram kelas.\n" + "Aturan ke-2\n" +
                        "Diagram dianggap tidak konsisten jika message yang ada di diagram sekuens ada pada diagram kelas, namun tidak berasosiasi dengan operasi yang ada pada diagram kelas.\n" +
                        "Aturan ke-3\n" +
                        "Diagram dianggap tidak konsisten jika lifeline yang ada di diagram sekuens bukan merupakan kelas yang ada di diagram kelas\n" +
                        "Aturan ke-4\n" +
                        "Diagram dianggap tidak konsisten jika lifeline yang ada di diagram sekuens ada pada diagram kelas, namun tidak berasosiasi dengan kelas yang ada pada diagram kelas.\n" +
                        "Aturan ke-5\n" +
                        "Diagram dianggap tidak konsisten jika message yang dikirimkan antara dua lifeline tidak ada pada daftar operasi dari kelas yang direpresentasikan oleh lifeline penerima.\n" + "Aturan ke-6\n" +
                        "Diagram dianggap tidak konsisten jika message reply yang dikirimkan dari lifeline A ke lifeline B tidak didahului oleh message yang dikirim dari lifeline B ke lifeline A"
        );
        JPanel rulesPanel = new JPanel();
        rulesPanel.setLayout(new BorderLayout());
        rulesPanel.setBorder(BorderFactory.createCompoundBorder(rulesTextArea.getBorder(),BorderFactory.createEmptyBorder(0,10,5,10)));

        rulesPanel.add(rulesLabel, "North");
        rulesPanel.add(rulesTextArea,"Center");

        container.add(howToUsePanel);
//        container.add(rulesPanel, BorderLayout.PAGE_END);
        bantuanFrame.add(container);

        JDialog dialog = new JDialog(bantuanFrame, "Bantuan & Penjelasan Aturan Ketidakkonsistenan");
        dialog.setLayout(new BorderLayout());
        dialog.add(howToUsePanel,BorderLayout.PAGE_START);
        dialog.add(rulesPanel, BorderLayout.CENTER);
        dialog.setSize(500,600);
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
                labelProcessMessage.setText("Tekan tombol 'Reset' dahulu untuk memulai kembali");
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

                    textAreaExecutionReport.append("Rule 1: Message yang ada pada Diagram Sekuens harus merupakan operasi yang ada pada Diagram Kelas\n");
                    if (!Suspect.unknownMessageList.isEmpty()) {
                        isConsistent = false;
                        textAreaExecutionReport.append("\nPERINGATAN!!! RULE 1 TIDAK TERPENUHI\nTerdapat " + Suspect.unknownMessageList.size() + " message yang bukan merupakan operasi di kelas pada Diagram Kelas, yaitu:\n");
                        for (int i = 0; i < Suspect.unknownMessageList.size(); i++) {
                            textAreaExecutionReport.append(i + 1 + ". Message " + Suspect.unknownMessageList.get(i).getCounter() + ": " + Suspect.unknownMessageList.get(i).getSendEvent() + " -> " + Suspect.unknownMessageList.get(i).getName()+ Suspect.unknownMessageList.get(i).getArgument() + " -> " + Suspect.unknownMessageList.get(i).getReceiveEvent() + " tidak ada di daftar operasi yang ada pada kelas\n");
                        }
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    else {
                        textAreaExecutionReport.append("RULE 1 TERPENUHI\n");
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    textAreaExecutionReport.append("\nRule 2: Message yang ada pada Diagram Sekuens harus ada pada Diagram Kelas dan memiliki relasi / berasosiasi dengan operasi pada Diagram Kelas\n");
                    if (!Suspect.assocWarningList.isEmpty()) {
                        isConsistent = false;
                        textAreaExecutionReport.append("\nPERINGATAN!!! RULE 2 TIDAK TERPENUHI\nTerdapat " + Suspect.assocWarningList.size() + " message pada Diagram Sekuens yang tidak mempunyai relasi / tidak berasosiasi dengan operasi yang ada di kelas pada Diagram Kelas, yaitu:\n");
                        for (int i = 0; i < Suspect.assocWarningList.size(); i++) {
                            textAreaExecutionReport.append(i + 1 + ". Message " + Suspect.assocWarningList.get(i).getCounter() + ": " + Suspect.assocWarningList.get(i).getName() + " " + Suspect.assocWarningList.get(i).getArgument() + " tidak mempunyai relasi dengan operasi yang ada di kelas\n");
                        }
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    else {
                        textAreaExecutionReport.append("RULE 2 TERPENUHI\n");
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    textAreaExecutionReport.append("\nRule 3: Lifeline yang ada pada Diagram Sekuens harus ada pada Diagram Kelas\n");
                    if (!Suspect.lifelineLists.isEmpty()) {
                        isConsistent = false;
                        textAreaExecutionReport.append("\nPERINGATAN!!! RULE 3 TIDAK TERPENUHI\nTerdapat " + Suspect.lifelineLists.size() + " Lifeline yang bukan merupakan kelas pada Diagram Kelas, yaitu:\n");
                        for (int i = 0; i < Suspect.lifelineLists.size(); i++) {
                            textAreaExecutionReport.append(i + 1 + ". Lifeline " + Suspect.lifelineLists.get(i) + " bukan merupakan kelas\n");
                        }
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    else {
                        textAreaExecutionReport.append("RULE 3 TERPENUHI\n");
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    textAreaExecutionReport.append("\nRule 4: Lifeline yang ada pada Diagram Sekuens harus ada pada Diagram Kelas dan memiliki relasi / berasosisasi dengan kelas pada Diagram Kelas\n");
                    if (!Suspect.lifelineAssocLists.isEmpty()) {
                        isConsistent = false;
                        textAreaExecutionReport.append("\nPERINGATAN!!! RULE 4 TIDAK TERPENUHI\nTerdapat " + Suspect.lifelineAssocLists.size() + " Lifeline yang tidak berelasi / berasosiasi dengan salah satu kelas pada Diagram Kelas, yaitu:\n");
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
                    textAreaExecutionReport.append("\nRule 6: Reply message yang dikirimkan dari lifeline A ke lifeline B, harus didahului oleh pengiriman message dari lifeline B ke lifeline A \n");
                    if (!Suspect.replySuspectList.isEmpty()) {
                        isConsistent = false;
                        textAreaExecutionReport.append("\nPERINGATAN!!! RULE 6 TIDAK TERPENUHI\nTerdapat " + Suspect.replySuspectList.size() + " reply message yang muncul tanpa ada message pemicu yaitu:\n");
                        for (int i = 0; i < Suspect.replySuspectList.size(); i++) {
                            textAreaExecutionReport.append(i + 1 + ". " + "Message " + Suspect.replySuspectList.get(i).getCounter() + ": " + Suspect.replySuspectList.get(i).getName() + " " + Suspect.replySuspectList.get(i).getArgument() + "\n");
                        }
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    else {
                        textAreaExecutionReport.append("RULE 6 TERPENUHI\n");
                        textAreaExecutionReport.append("__________________________________________________________________________________________________________\n");
                    }
                    if (isConsistent) {
                        textAreaExecutionReport.setCaretPosition(1);
                        textAreaExecutionReport.setText("MANTAP!! Diagram Sekuens dan Diagram Kelas konsisten\nSELAMAT!!\n\n\n" + textAreaExecutionReport.getText());
                        labelProcessMessage.setText("<html><center>DIAGRAM KONSISTEN!!<br/>Proses pembacaan file XMI selesai. Klik tombol reset jika ingin memulai kembali<center><html>");
                    }
                    if (!isConsistent){
                        textAreaExecutionReport.setCaretPosition(1);
                        textAreaExecutionReport.setText("Diagram tidak konsisten. Harap periksa kembali desain diagram\n\n\n" + textAreaExecutionReport.getText());
                        labelProcessMessage.setText("<html><center>DIAGRAM TIDAK KONSISTEN!!<br/>Proses pembacaan file XMI selesai. Klik tombol reset jika ingin memulai kembali<center><html>");
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
            labelProcessMessage.setText("<html><center>Silakan pilih file XMI dengan mengklik tombol 'Cari'<br/><br/><center><html>");
            textAreaExecutionReport.setText("");
            inputFile[0] = null;
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
        panelTableList.add(splitPane1);

        JSplitPane splitPanef = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelTableList ,panelReportExecution);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel1.add(splitPanef);

        JLabel creditLabelCrafted = new JLabel("<html><center>Crafted with ♥ by Ichsan Sandi D (05111540000167)<center><html>");

        JLabel creditLabelTitle = new JLabel("<html><center>Rancang Bangun Kakas Bantu Pemeriksa Ketidakkonsistenan Diagram Kelas dan Diagram Sekuens<center><html>");

        JLabel creditLabelInformatika = new JLabel("<html><center>Informatika ITS  Surabaya 2019<center><html>");

        JPanel creditPanel = new JPanel();
        creditPanel.setLayout(new BorderLayout());
        creditPanel.add(creditLabelCrafted, BorderLayout.PAGE_START);
        creditPanel.add(creditLabelTitle, BorderLayout.CENTER);
        creditPanel.add(creditLabelInformatika, BorderLayout.SOUTH);

        /*
        container untuk menampung dan meletakkan seluruh element yang ada pada halaman awal
         */
        containerPage1.add(panelFileChooser);
        containerPage1.add(panelProcessMessage);
        containerPage1.add(panel1);
        containerPage1.add(creditPanel);

        jFrame1.add(containerPage1);

        jFrame1.setVisible(true);
    }

    static private void executeProcess(String inputFile) {
        /*XML Read and Extraction*/
        XPathHandler.main(inputFile);

        CoreProcess coreProcess = new CoreProcess();
        coreProcess.inconsistencyChecking(Suspect.unknownMessageList, ClassOwnedOperation.operationList);
        coreProcess.checkingNoise();
        coreProcess.checkSignature();
        coreProcess.checkMessageAssociationDirection();
        coreProcess.checkingLifelineRepresent();
        coreProcess.makeMessageTriplet();
        coreProcess.checkReply();
    }
}