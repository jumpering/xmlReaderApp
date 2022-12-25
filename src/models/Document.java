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
    private String totalSections;

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
        document += this.totalSections + "\n";
        return document;
    }

    public String getTotalAllDetailsLine(){
        return this.totalSections;
    } 

    public void setHeader(Header header) {
        this.header = header;
    }

    public Header getHeader(){
        return this.header;
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

    public void setTotalSections(String totalSections){
        this.totalSections = totalSections;
    }

    public String getTotalSections(){
        return this.totalSections;
    }

    public void addSection(Section section) {
        this.sectionList.add(section);
    }
}
