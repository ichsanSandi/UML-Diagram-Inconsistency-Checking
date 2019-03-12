package project;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
        public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
            // write your code here
//        Scanner scanner = new Scanner(System.in);
//        String  input = scanner.next();
//        System.out.println(input);

            //Inisiasi

            //Load file SEQCase.xmi
            String inputFile ="SEQCase.xmi";

            //XML handling using SAX
//            SAXHandler saxHandler = new SAXHandler();
//            saxHandler.readDataFromXML(inputFile);

            //XML handling using XPath
            XPathHandler xPathHandler = new XPathHandler();
            xPathHandler.main(inputFile);
            Message.printMessageList();
            Lifeline.printLifelineList();
            Fragment.printFragmentList();
            SequenceOwnedAttribute.printAttributeList();
            ClassOwnedAttribute.printAttributeList();
            ClassOwnedOperation.printOperationList();

            CoreProcess.inconsistencyChecking(Message.messageList, ClassOwnedOperation.operationList);

            System.out.println("\nProses Selesai!");
    }
}
