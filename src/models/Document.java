package models;

import java.util.ArrayList;
import java.util.List;

public class Document {

    private String printer;
    private String fontFamily;
    private String fontSize;
    private String orientation;
    private Header header;

    private List<Section> sectionList = new ArrayList<>();
    private List<Line> linesInSectionsList = new ArrayList<>();

    private String totalSections;
    private Integer pageNumber = 1;

    public String toString(Integer maxLinesPerPage) {
        maxLinesPerPage = maxLinesPerPage - this.header.getSize() - 1;// 1 is line totalSections
        StringBuilder linesToString = new StringBuilder();
        linesToString.append(this.getHeader().toString(this.pageNumber));
        if (this.linesInSectionsList.size() == 0) {
            for (Section section : this.sectionList) {
                for (int i = 0; i < section.getSize(); i++) {
                    this.linesInSectionsList.add(section.geLine(i));
                }
            }
        }
        if (maxLinesPerPage > this.linesInSectionsList.size()) {
            maxLinesPerPage = this.linesInSectionsList.size();
        }
        for (int i = 0; i < maxLinesPerPage; i++) {
            linesToString.append(this.linesInSectionsList.get(i) + "\n");
        }
        linesToString.append(this.getTotalSections().toString());
        this.linesInSectionsList.subList(0, maxLinesPerPage).clear();
        this.pageNumber++;
        return linesToString.toString();
    }

    public boolean end() {
        return this.linesInSectionsList.size() > 0;
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
