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

            String expression = "/XMI/Model/packagedElement/packagedElement/ownedMember/lifeline | " +
                    "/XMI/Model/packagedElement/packagedElement/ownedMember/message | " +
                    "/XMI/Model/packagedElement/packagedElement/ownedMember/fragment | " +
                    "/XMI/Model/packagedElement/packagedElement/ownedAttribute | " +
                    "/XMI/Model/packagedElement/packagedElement/ownedOperation |" +  "/XMI/Model/packagedElement/packagedElement/ownedOperation/ownedParameter";
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
                    doc, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nNode = nodeList.item(i);
                if (nNode.getNodeName().equals("message")){
                    Message message = new Message();
                    Element element = (Element) nNode;
                    message.setId(element.getAttribute("xmi:id"));
                    message.setName(element.getAttribute("name"));
                    message.setReceiveEvent(element.getAttribute("receiveEvent"));
                    message.setSendEvent(element.getAttribute("sendEvent"));
                    message.setSignature(element.getAttribute("signature"));
                    message.addMessageList(message);
                }
                else if (nNode.getNodeName().equals("lifeline")){
                    Lifeline lifeline = new Lifeline();
                    Element element = (Element) nNode;
                    lifeline.setId(element.getAttribute("xmi:id"));
                    lifeline.setName(element.getAttribute("name"));
                    lifeline.setRepresent(element.getAttribute("represents"));
                    lifeline.addLifelineList(lifeline);
                }
                else if (nNode.getNodeName().equals("fragment")){
                    Fragment fragment = new Fragment();
                    Element element = (Element) nNode;
                    fragment.setId(element.getAttribute("xmi:id"));
                    fragment.setCovered(element.getAttribute("covered"));
                    fragment.addFragmentList(fragment);
                }

                else if (nNode.getNodeName().equals("ownedAttribute")){
                    Element element = (Element) nNode;
                        if (Lifeline.checkIdOwnedAttribute(element.getAttribute("xmi:id"))){
                            SequenceOwnedAttribute attribute = new SequenceOwnedAttribute();
                            attribute.setId(element.getAttribute("xmi:id"));
                            attribute.setName(element.getAttribute("name"));
                            attribute.setType(element.getAttribute("type"));
                            attribute.addAttributeList(attribute);
                        }
                        else{
                            ClassOwnedAttribute attribute = new ClassOwnedAttribute();
                            attribute.setId(element.getAttribute("xmi:id"));
                            attribute.setName(element.getAttribute("name"));
                            attribute.setType(element.getAttribute("type"));
                            attribute.addAttributeList(attribute);
                        }
                }
                else if (nNode.getNodeName().equals("ownedOperation")){
//                    NodeList rootNode = doc.getChildNodes();
//                    checkChild((NodeList) nNode);
                    Element element2 = (Element) nNode;
                    System.out.println(element2.getChildNodes().getLength());
                    for (int o = 0 ; o < nNode.getChildNodes().getLength(); o++){
                        String element = element2.getChildNodes().item(o).getNodeName();

                        //cari anak yang namanya ownedparameter
                        if (element2.getChildNodes().item(o).getNodeName().equals("ownedParameter")){
                            /*asosiasi dengan getParentNode ?*/
                            System.out.println(element2.getChildNodes().item(o).getParentNode().getNodeName());
                            /*mendapatkan nama parameter*/
                            System.out.println(element2.getChildNodes().item(o).getAttributes().getNamedItem("name"));
                        }
/*                        Node node = nodeList.item(o);
                        System.out.println(node.getNodeName());
                        System.out.println(element2.getAttribute("name"));*/
                    }
                    ClassOwnedOperation operation= new ClassOwnedOperation();
                    Element element = (Element) nNode;
                    operation.setId(element.getAttribute("xmi:id"));
                    operation.setName(element.getAttribute("name"));
                    System.out.println(element.getAttribute("name"));
                    operation.addOperationList(operation);
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
