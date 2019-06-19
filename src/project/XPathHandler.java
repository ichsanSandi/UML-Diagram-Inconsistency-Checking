package project;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;

class XPathHandler {

    static void main(String inputFile) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;

            dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();

            String expression = "//lifeline | " +
                    "//message | " +
                    "//fragment | " +
                    "//ownedAttribute | " +
                    "//ownedOperation |" +
                    "//ownedParameter |" +
                    "//packagedElement |" +
                    "//ownedMember";

            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

            int messageCounter = 0;

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                switch (nNode.getNodeName()) {
                    case "message": {
                        Message message = new Message();
                        Element element = (Element) nNode;
                        Element element1 = (Element) element.getParentNode();

                        message.setId(element.getAttribute("xmi:id"));
                        if (element.getAttribute("name").contains("()")){
                            String name = element.getAttribute("name");
                            name = name.replace("()","");
                            message.setName(name);
                        }
                        else {
                            message.setName(element.getAttribute("name"));
                        }
                        message.setReceiveEvent(element.getAttribute("receiveEvent"));
                        message.setSendEvent(element.getAttribute("sendEvent"));
                        message.setParent(element1.getAttribute("xmi:id"));
                        message.setCounter(++messageCounter);
                        if (element.getAttribute("signature").isEmpty() && !element.getAttribute("messageSort").equals("reply") && !element.getAttribute("messageSort").equals("createMessage") && !element.getAttribute("messageSort").equals("deleteMessage")){
                            Suspect suspect = new Suspect();
                            Element element2 = (Element) nNode;
                            message.setSignature("no signature");
                            suspect.setName(message.getName());
                            suspect.setReceiveEvent(element.getAttribute("receiveEvent"));
                            suspect.setSendEvent(element.getAttribute("sendEvent"));
                            suspect.setParent(element1.getAttribute("xmi:id"));
                            suspect.setCounter(messageCounter);
                            for (int o = 0; o < nNode.getChildNodes().getLength(); o++) {
                                if (element2.getChildNodes().item(o).getNodeName().equals("argument")) {
                                    Element element3 = (Element) element.getChildNodes().item(o);
                                    message.addArgumentList(element3.getAttribute("value"));
                                    suspect.addArgument(element3.getAttribute("value"));
                                }
                            }
                            suspect.setArgument(Suspect.argumentList.toString().replace("[","(").replace("]", ")"));
                            Suspect.addUnknownMessageList(suspect);
                        } else {
                            message.setSignature(element.getAttribute("signature"));
                        }
                        if (element.getAttribute("messageSort").equals("reply") && element.getAttribute("signature").isEmpty()){
                            Suspect.replySuspectList.add(message);
                        }
                        message.setArgument(Message.argumentList.toString().replace("[","(").replace("]", ")"));
                        message.addMessageList(message);
                        break;
                    }
                    case "lifeline": {
                        Lifeline lifeline = new Lifeline();
                        Element element = (Element) nNode;
                        lifeline.setId(element.getAttribute("xmi:id"));
                        lifeline.setName(element.getAttribute("name"));
                        lifeline.setRepresent(element.getAttribute("represents"));
                        lifeline.addLifelineList(lifeline);
                        break;
                    }
                    case "fragment": {
                        Fragment fragment = new Fragment();
                        Element element = (Element) nNode;
                        fragment.setId(element.getAttribute("xmi:id"));
                        fragment.setCovered(element.getAttribute("covered"));
                        fragment.addFragmentList(fragment);
                        break;
                    }
                    case "ownedAttribute": {
                        Element element = (Element) nNode;
                        Element parentElement = (Element) nNode.getParentNode();
                        if (Lifeline.checkIdOwnedAttribute(element.getAttribute("xmi:id"))) {
                            SequenceOwnedAttribute attribute = new SequenceOwnedAttribute();
                            attribute.setId(element.getAttribute("xmi:id"));
                            attribute.setName(element.getAttribute("name"));
                            attribute.setType(element.getAttribute("type"));
                            attribute.addAttributeList(attribute);
                        } else if (parentElement.getAttribute("xmi:type").equals("uml:Class")) {
                            ClassOwnedAttribute attribute = new ClassOwnedAttribute();
                            attribute.setId(element.getAttribute("xmi:id"));
                            attribute.setName(element.getAttribute("name"));
                            attribute.setType(element.getAttribute("type"));
                            attribute.addAttributeList(attribute);
                        }
                        break;
                    }
                    case "ownedOperation": {
                        Element element2 = (Element) nNode;
                        ClassOwnedOperation operation = new ClassOwnedOperation();
                        Element element3 = (Element) element2.getParentNode();
                        operation.setAssociatedClass(element3.getAttribute("name"));
                        for (int o = 0; o < nNode.getChildNodes().getLength(); o++) {
                            //cari anak yang namanya ownedparameter
                            if (element2.getChildNodes().item(o).getNodeName().equals("ownedParameter") && !element2.getChildNodes().item(o).getAttributes().getNamedItem("direction").toString().equals("direction=\"return\"")) {
                                Element element = (Element) element2.getChildNodes().item(o);
                                /*mendapatkan nama parameter*/
                                operation.addParameter(element.getAttribute("name"));
                            }
                        }
                        Element element = (Element) nNode;
                        operation.setParameter(ClassOwnedOperation.parameterList.toString().replace("[","(").replace("]", ")"));
                        operation.setId(element.getAttribute("xmi:id"));
                        operation.setName(element.getAttribute("name"));
                        operation.addOperationList(operation);
                        break;
                    }
                    case "packagedElement" :{
                        Element element = (Element) nNode;
                        ClassName classNameMember = new ClassName();
                        if (element.getAttribute("xmi:type").equals("uml:Class") || element.getAttribute("xmi:type").equals("uml:Actor")) {
                            classNameMember.setId(element.getAttribute("xmi:id"));
                            classNameMember.setName(element.getAttribute("name"));
                            classNameMember.setType(element.getAttribute("xmi:type"));
                            classNameMember.addClassList(classNameMember);
                        }
                        break;
                    }
                    case "ownedMember" :{
                        Element element = (Element) nNode;
                        ClassName className = new ClassName();
                        if (element.getAttribute("xmi:type").equals("uml:Actor")){
                            className.setId(element.getAttribute("xmi:id"));
                            className.setName(element.getAttribute("name"));
                            className.setType(element.getAttribute("xmi:type"));
                            className.addClassList(className);
                        }
                        break;
                    }
                }

                // Ketika pakai 1 expression
                /*if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Id:" + eElement.getAttribute("xmi:id"));
                    System.out.println("Type: " + eElement.getAttribute("xmi:type"));
                    System.out.println("Name: " + eElement.getAttribute("name"));
                }*/
            }
        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}