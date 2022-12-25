package models;

import java.util.ArrayList;
import java.util.List;

public class Document {

    private String Printer;
    private String FontFamily;
    private String FontSize;
    private String Orientation;
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
            document += section.listLinesToString();
            document += section.totalLineToString();
        }
        document += this.total;

        return document;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public String getPrinter() {
        return Printer;
    }

    public void setPrinter(String printer) {
        Printer = printer;
    }

    public String getFontFamily() {
        return FontFamily;
    }

    public void setFontFamily(String fontFamily) {
        FontFamily = fontFamily;
    }

    public String getFontSize() {
        return FontSize;
    }

    public void setFontSize(String fontSize) {
        FontSize = fontSize;
    }

    public String getOrientation() {
        return Orientation;
    }

    public void setOrientation(String orientation) {
        Orientation = orientation;
    }

    public void setTotal(String total){
        this.total = total;
    }

    public void addSection(Section section) {
        this.sectionList.add(section);
    }
}
