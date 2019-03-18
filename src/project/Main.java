package project;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public abstract class Main implements ActionListener {
        public static void main(String[] args){
            //Inisiasi

/*            //Load file SEQCase.xmi
            String inputFile ="SEQCase.xmi";

            //XML handling using XPath
            XPathHandler xPathHandler = new XPathHandler();
            xPathHandler.main(inputFile);
            Message.printMessageList();
            Lifeline.printLifelineList();
            Fragment.printFragmentList();
            SequenceOwnedAttribute.printAttributeList();
            ClassOwnedAttribute.printAttributeList();
            ClassOwnedOperation.printOperationList();

            CoreProcess.inconsistencyChecking(Message.messageList, ClassOwnedOperation.operationList);*/

            makeGUI();
            System.out.println("\nProses Selesai!");
        }

        static private void makeGUI(){
            JFrame jFrame1 = new JFrame();
            jFrame1.setTitle("UML Diagram Consistency Checking");
            jFrame1.setSize(800,600);
            jFrame1.setLayout(new BorderLayout());
            jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame1.setLocationRelativeTo(null);

            JTextField textField = new JTextField(20);

            JTextArea textArea1 = new JTextArea(20,13);
            textArea1.setLineWrap(true);
            textArea1.setWrapStyleWord(true);

            JTextArea textArea2 = new JTextArea(20,13);
            textArea2.setLineWrap(true);
            textArea2.setWrapStyleWord(true);

            JTextArea textArea3 = new JTextArea(20,13);
            textArea3.setLineWrap(true);
            textArea3.setWrapStyleWord(true);

            JTextArea textArea4 = new JTextArea(20,13);
            textArea4.setLineWrap(true);
            textArea4.setWrapStyleWord(true);

            JTextArea textArea5 = new JTextArea(20,13);
            textArea5.setLineWrap(true);
            textArea5.setWrapStyleWord(true);
//            textArea5.setMargin(new Insets(5, 5, 5, 5));
            // kalo mau pake margin

            JTextArea textArea6 = new JTextArea(20,20);
            textArea6.setLineWrap(true);
            textArea6.setWrapStyleWord(true);
            textArea6.setMargin(new Insets(5, 5, 5, 5));

            JTextArea textArea7 = new JTextArea(20,20);
            textArea7.setLineWrap(true);
            textArea7.setWrapStyleWord(true);
            textArea7.setMargin(new Insets(5, 5, 5, 5));

            DefaultTableModel tableModel = new DefaultTableModel();
//            tableModel.getDataVector().add(ClassOwnedOperation.operationList);

            JTable table = new JTable(tableModel);
            JScrollPane tableContainer = new JScrollPane(table);

            JFileChooser fileChooser = new JFileChooser();

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
            panel4.setLayout(new BorderLayout());
            panel4.add(textArea6);

            JPanel panel5 = new JPanel();
            panel5.setLayout(new BorderLayout());
            panel5.add(textArea7);

            JSplitPane splitPane = new JSplitPane(1, panel4, panel5);
            splitPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            JPanel mainPanel = new JPanel();
            mainPanel.add(splitPane);

            container1.add(panel1);
            container1.add(panel2);
            container1.add(panel3);

            container2.add(mainPanel, "Center");
            splitPane.setDividerLocation(jFrame1.getWidth() / 2);

            JButton buttonOpen = new JButton("Open");
            buttonOpen.addActionListener(e ->
                    ClassOwnedOperation.printOperationList()
            );

            JButton buttonRun = new JButton("Read");
            buttonRun.addActionListener(e -> {
                executeProcess();
                for (int i = 0; i < ClassOwnedOperation.operationList.size(); i++){
                    textArea1.append(ClassOwnedOperation.operationList.get(i).getName() + "\n");
                }
            });

            JButton buttonExecute = new JButton("Execute");
            buttonExecute.addActionListener(e -> {
                jFrame1.getContentPane().removeAll();
                jFrame1.getContentPane().add(container2);
                jFrame1.revalidate();
            });

            JButton buttonClear = new JButton("Clear");
            buttonClear.addActionListener(e -> {
                ClassOwnedOperation.operationList.clear();
                textArea1.setText("");
            });

            panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
            panel1.setBorder(new EmptyBorder(30,0,0,0));
            panel1.add(textField);
            panel1.add(buttonOpen);

            panel2.add(buttonRun);
            panel2.add(buttonExecute);
            panel2.add(buttonClear);

            panel3.add(new JScrollPane(textArea1), "Center");
            panel3.add(new JScrollPane(textArea2), "Center");
            panel3.add(new JScrollPane(textArea3), "Center");
            panel3.add(new JScrollPane(textArea4), "Center");
            panel3.add(new JScrollPane(textArea5), "Center");

            jFrame1.add(container1);

            jFrame1.setVisible(true);
        }

        static private void executeProcess(){
            //Inisiasi

            //Load file SEQCase.xmi
            String inputFile ="SEQCase.xmi";

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
