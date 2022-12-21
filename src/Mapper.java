import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Mapper {

    public <T> void mapValues(NodeList nodeList, T obj) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {//todo cambiar a generic el segundo parameter
        NodeList childNodeList = nodeList.item(0).getChildNodes();
        for (int i = 0; i < childNodeList.getLength(); i++) {
            Node node = childNodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                //construct method with reflection
                String methodString = "set" + node.getNodeName();
                Method method = obj.getClass().getMethod(methodString, String.class);
                method.invoke(obj, node.getTextContent());
            }
        }
    }

    public <T> void mapAttributes(NamedNodeMap nodeMap, T obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {//todo cambiar a generic el segundo parameter
        for (int i = 0; i < nodeMap.getLength(); i++){
            //construct method with reflection
            String methodString = "set" + nodeMap.item(i).getNodeName();
            Method method = obj.getClass().getMethod(methodString, String.class);
            method.invoke(obj, nodeMap.item(i).getTextContent());
        }
    }
}
