package project;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.jar.JarEntry;

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

            JLabel labelMessage = new JLabel(" ");

            JTextField textField = new JTextField(20);
            textField.setEditable(false);

            //Nama textarea sesuai yang ingin ditampilkan
            //sementara pake 1, 2, 3, 4 ...
            JTextArea textArea1 = new JTextArea(20,13);
            textArea1.setLineWrap(true);
            textArea1.setWrapStyleWord(true);

            JLabel labelTextArea1 = new JLabel("Text Area 1");
            labelTextArea1.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel panelTextArea1 = new JPanel();
            panelTextArea1.setLayout(new BorderLayout());
            panelTextArea1.add(labelTextArea1, "North");
            panelTextArea1.add(new JScrollPane(textArea1), "Center");

            JTextArea textArea2 = new JTextArea(20,13);
            textArea2.setLineWrap(true);
            textArea2.setWrapStyleWord(true);

            JLabel labelTextArea2 = new JLabel("Text Area 2");
            labelTextArea2.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel panelTextArea2 = new JPanel();
            panelTextArea2.setLayout(new BorderLayout());
            panelTextArea2.add(labelTextArea2, "North");
            panelTextArea2.add(new JScrollPane(textArea2), "Center");

            JTextArea textArea3 = new JTextArea(20,13);
            textArea3.setLineWrap(true);
            textArea3.setWrapStyleWord(true);

            JLabel labelTextArea3 = new JLabel("Text Area 3");
            labelTextArea3.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel panelTextArea3 = new JPanel();
            panelTextArea3.setLayout(new BorderLayout());
            panelTextArea3.add(labelTextArea3, "North");
            panelTextArea3.add(new JScrollPane(textArea3), "South");

            JTextArea textArea4 = new JTextArea(20,13);
            textArea4.setLineWrap(true);
            textArea4.setWrapStyleWord(true);

            JLabel labelTextArea4 = new JLabel("Text Area 4");
            labelTextArea4.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel panelTextArea4 = new JPanel();
            panelTextArea4.setLayout(new BorderLayout());
            panelTextArea4.add(labelTextArea4, "North");
            panelTextArea4.add(new JScrollPane(textArea4), "South");

            JTextArea textArea5 = new JTextArea(20,13);
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

            JTextArea textArea6 = new JTextArea(20,20);
            textArea6.setLineWrap(true);
            textArea6.setWrapStyleWord(true);
            textArea6.setMargin(new Insets(5, 5, 5, 5));

            JLabel labelTextArea6 = new JLabel("Text Area 6");
            labelTextArea6.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel panelTextArea6 = new JPanel();
            panelTextArea6.setLayout(new BorderLayout());
            panelTextArea6.add(labelTextArea6,"North");
            panelTextArea6.add(new JScrollPane(textArea6),"South");

            JTextArea textArea7 = new JTextArea(20,20);
            textArea7.setLineWrap(true);
            textArea7.setWrapStyleWord(true);
//            textArea7.setMargin(new Insets(5, 5, 5, 5));

            JLabel labelTextArea7 = new JLabel("Text Area 7");
            labelTextArea7.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel panelTextArea7 = new JPanel();
            panelTextArea7.setLayout(new BorderLayout());
            panelTextArea7.add(labelTextArea7,"North");
            panelTextArea7.add(new JScrollPane(textArea7),"South");

            JTextArea textArea8 = new JTextArea(20,20);
            textArea8.setLineWrap(true);
            textArea8.setWrapStyleWord(true);
//            textArea8.setMargin(new Insets(0, 0, 0, 0));

            JLabel labelTextArea8 = new JLabel("Text Area 8");
            labelTextArea8.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel panelTextArea8 = new JPanel();
            panelTextArea8.setLayout(new BorderLayout());
            panelTextArea8.add(labelTextArea8,"North");
            panelTextArea8.add(new JScrollPane(textArea8),"South");

            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            FileNameExtensionFilter xmiFilter = new FileNameExtensionFilter("XMI File","xmi");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(xmiFilter);

            JPanel container1 = new JPanel();
            container1.setLayout(new BoxLayout(container1,BoxLayout.Y_AXIS));

            JPanel container2 = new JPanel();
            container2.setLayout(new BoxLayout(container2,BoxLayout.Y_AXIS));

            JPanel panel1 = new JPanel();

            JPanel panel2 = new JPanel();
            panel2.setLayout(new FlowLayout());

            JPanel panel3 = new JPanel();
            panel3.setLayout(new FlowLayout());

            JPanel panel4 = new JPanel();
            panel4.setLayout(new FlowLayout());

            JPanel panel5 = new JPanel();
            panel5.setLayout(new GridBagLayout());

            JPanel panel6 = new JPanel();
            panel6.setLayout(new FlowLayout(FlowLayout.CENTER));
            panel6.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));

            JButton buttonOpen = new JButton("Open");
            buttonOpen.addActionListener(e -> {
//                int returnValue = fileChooser.showOpenDialog(null);
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                    File selectedFile = fileChooser.getSelectedFile();
                    System.out.println(selectedFile.getAbsolutePath());
                    textField.setText(selectedFile.getAbsolutePath());
                    inputFile[0] = selectedFile.toString();
                }
            });

            JButton buttonRun = new JButton("Read");
            buttonRun.addActionListener(e -> {
                if (inputFile[0] != null){
                    labelMessage.setText(" ");
                    executeProcess(inputFile[0]);
                } else {
                    labelMessage.setText("File not found");
                    labelMessage.setVisible(true);
                }
                for (int i = 0; i < ClassOwnedOperation.operationList.size(); i++){
                    textArea1.append(ClassOwnedOperation.operationList.get(i).getName() + "\n");
                }
            });

            JButton buttonExecute = new JButton("Execute");
            buttonExecute.addActionListener(e -> {
                if (inputFile[0] != null){
                    jFrame1.getContentPane().removeAll();
                    jFrame1.getContentPane().repaint();
                    jFrame1.getContentPane().add(container2);
                    jFrame1.revalidate();
                } else {
//                    System.out.println("bala bala");
                    labelMessage.setText("File not found");
                    labelMessage.setVisible(true);
                }
            });

            JButton buttonClear = new JButton("Clear");
            buttonClear.addActionListener(e -> {
                ClassOwnedOperation.operationList.clear();
                textArea1.setText("");
                textField.setText("");
                labelMessage.setText(" ");
                inputFile[0] = null;
            });

            JButton buttonBack = new JButton("Back");
            buttonBack.addActionListener(actionEvent -> {
                jFrame1.getContentPane().removeAll();
                jFrame1.getContentPane().repaint();
                jFrame1.getContentPane().add(container1);
                jFrame1.revalidate();
            });

            panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
            panel1.setBorder(new EmptyBorder(30,0,0,0));
            panel1.add(textField);
            panel1.add(buttonOpen);

            panel4.add(labelMessage);

            panel2.add(buttonRun);
            panel2.add(buttonExecute);
            panel2.add(buttonClear);

            /*panel3.add(new JScrollPane(panelTextArea1), "Center");
            panel3.add(new JScrollPane(panelTextArea2), "Center");
            panel3.add(new JScrollPane(panelTextArea3), "Center");
            panel3.add(new JScrollPane(panelTextArea4), "Center");
            panel3.add(new JScrollPane(panelTextArea5), "Center");*/
            JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panelTextArea1,panelTextArea2);
            JSplitPane sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panelTextArea4,panelTextArea5);
            JSplitPane sp3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp, panelTextArea3);
            JSplitPane sp4 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp3,sp2);
            panel3.add(sp4);

            container1.add(panel1);
            container1.add(panel4);
            container1.add(panel2);
            container1.add(panel3);

            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelTextArea6, panelTextArea7);
            splitPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            panel5.add(splitPane);
            panel5.add(panelTextArea8);
            panel6.add(buttonBack);
            container2.add(panel5);
            container2.add(panel6);

            jFrame1.add(container1);

            jFrame1.setVisible(true);
        }

        static private void executeProcess(String inputFile){
            //Inisiasi

            //Load file SEQCase.xmi
//            String inputFile ="SEQCase.xmi";

            //XML handling using XPath
            XPathHandler xPathHandler = new XPathHandler();
            XPathHandler.main(inputFile);
            Message.printMessageList();
            Lifeline.printLifelineList();
            Fragment.printFragmentList();
            SequenceOwnedAttribute.printAttributeList();
            ClassOwnedAttribute.printAttributeList();
            ClassOwnedOperation.printOperationList();

            CoreProcess.inconsistencyChecking(Message.messageList, ClassOwnedOperation.operationList);
        }
}