package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Document {

    private String printer;
    private String fontFamily;
    private String fontSize;
    private String orientation;
    private Header header;
    private List<Section> sectionList;
    private String totalSections;

    public Document() {
        
        this.sectionList = new ArrayList<>();
    }

    //todo 
    //only works with first section!
    public String sectionsToStringLimitedLines(Integer firstLine, Integer lineLimit) {
        String[] arraySectionLines = this.sectionList.get(0).listLinesToString().split("\n");
        List<String> listOfSectionLines = Stream.of(arraySectionLines).collect(Collectors.toList());

        while(firstLine > 0){//todo nullpointer exc
            listOfSectionLines.remove(0);
            firstLine--;
        };
        String sectionLinesLimited = "";
        while(lineLimit != 0){//todo nullpointer exc
            sectionLinesLimited = sectionLinesLimited.concat(listOfSectionLines.get(0) + "\n");
            listOfSectionLines.remove(0);
            lineLimit--;
        }
        sectionLinesLimited = sectionLinesLimited.concat(this.sectionList.get(0).totalLineToString());
        return sectionLinesLimited;
    }

    public void addSection(Section section) {
        this.sectionList.add(section);
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Header getHeader() {
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

    public void setTotalSections(String totalSections) {
        this.totalSections = totalSections;
    }

    public String getTotalSections() {
        return this.totalSections;
    }
}
