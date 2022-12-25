package models;

import java.util.ArrayList;
import java.util.List;

public class Document {

    private String printer;
    private String fontFamily;
    private String fontSize;
    private String orientation;
    private Header header;
    private List<Section> sectionList;
    private String total;

    public Document(){
        this.sectionList = new ArrayList<>();
    }

    public String printConsole(){
        String document = "";
        document += this.header.toString();
        for (Section section : sectionList) {
            document += section.listLinesToString() + "\n";
            document += section.totalLineToString() + "\n";
        }
        document += this.total + "\n";

        return document;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public String getPrinter() {
        return this.printer;
    }

    public void setPrinter(String printer) {
        this.printer = printer;
    }

    public String getFontFamily() {
        return this.fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public String getFontSize() {
        return this.fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public void setTotal(String total){
        this.total = total;
    }

    public void addSection(Section section) {
        this.sectionList.add(section);
    }
}
