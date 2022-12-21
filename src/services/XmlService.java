package services;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

public interface XmlService {

    public abstract NodeList getNodeListByTagName(String tagName);

    public abstract NamedNodeMap getAttributeNodeByTagName(String tagName);
}
