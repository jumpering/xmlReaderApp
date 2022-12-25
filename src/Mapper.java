import models.Line;
import models.Section;
import models.Document;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class Mapper {

    public <T> void mapValues(NodeList nodeList, T obj) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        List<Node> childNodes = getChildNodes(nodeList);
        for (int i = 0; i < childNodes.size(); i++) {
            //construct method with reflection
            String methodString = "set" + childNodes.get(i).getNodeName();
            Method method = obj.getClass().getMethod(methodString, String.class);
            method.invoke(obj, childNodes.get(i).getTextContent());
        }
    }

    public <T> void mapAttributes(NamedNodeMap nodeMap, T obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (int i = 0; i < nodeMap.getLength(); i++) {
            //construct method with reflection
            String methodString = "set" + nodeMap.item(i).getNodeName();
            Method method = obj.getClass().getMethod(methodString, String.class);
            method.invoke(obj, nodeMap.item(i).getTextContent());
        }
    }

    public void mapDetailsValuesToDocument(NodeList nodeList, Document document) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Node> detailNodeList = getChildNodes(nodeList);
        for (Node node : detailNodeList) {
            if (node.getNodeName().equals("Section")){
                Section section = new Section();
                NodeList childNodeList = node.getChildNodes();
                this.mapSectionLinesValues(childNodeList, section);
                this.mapSectionTotalValue(childNodeList, section);
                 this.mapAttributes(node.getAttributes(), section);
                document.addSection(section);
            }
             if (node.getNodeName().equals("Total")){
                document.setTotal(node.getTextContent().strip());
            }
        }        
    }

    private List<Node> getChildNodes(NodeList nodeList) {
        NodeList childNodeList = nodeList.item(0).getChildNodes();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < childNodeList.getLength(); i++) {
            Node node = childNodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                list.add(node);
            }
        }
        return list;
    }

    private void mapSectionLinesValues(NodeList nodeList, Section section) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals("Line")) {
                Line line = new Line(nodeList.item(i).getTextContent());
                section.setListLines(line);
            }
        }
    }

    private void mapSectionTotalValue(NodeList nodeList, Section section){
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals("Total")) {
                Line line = new Line(nodeList.item(i).getTextContent().strip());
                section.setTotalLine(line);
            }
        }
    }
}
