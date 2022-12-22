import models.Line;
import models.Section;
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

    public void mapSectionLineValues(NodeList nodeList, Section section) {
        List<Node> childNodes = getChildNodes(nodeList);
        for (int i = 0; i < childNodes.size(); i++) {
            if (childNodes.get(i).getNodeName().equals("Line")) {
                Line line = new Line(childNodes.get(i).getTextContent());
                section.addLineToList(line);
            }
        }
    }

    public static List<Node> getChildNodes(NodeList nodeList) {
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
}
