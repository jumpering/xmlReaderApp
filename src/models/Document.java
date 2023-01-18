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
    private String totalSections;
    private Integer pageNumber = 1;

    private List<Line> currentSectionLinesToPrint = new ArrayList<>();
    private Integer currentSectionPosition = 0;

    public String toString(Integer maxLines) {
        maxLines = maxLines - this.header.getSize() - 1;// 1 is total section
        StringBuilder linesToString = new StringBuilder();
        linesToString.append(this.getHeader().toString(this.pageNumber));
        this.getSectionsLimitedLines(maxLines).forEach(e -> linesToString.append(e.toString() + "\n"));
        if (this.currentSectionPosition == this.sectionList.size()){
            linesToString.append(this.getTotalSections().toString());
        }
        this.pageNumber++;
        return linesToString.toString();
    }

    public List<Line> getSectionsLimitedLines(Integer maxLines) {
        maxLines--; // -1 for total section line
        List<Line> linesToPrint = new ArrayList<>();
        if (this.currentSectionLinesToPrint.size() == 0) {
            for (int i = 0; i < this.sectionList.get(this.currentSectionPosition).getSize(); i++) {
                this.currentSectionLinesToPrint.add(this.sectionList.get(this.currentSectionPosition).getLine(i));
            }
        }
        if (this.currentSectionLinesToPrint.size() < maxLines) {
            maxLines = this.currentSectionLinesToPrint.size();
        }
        this.currentSectionLinesToPrint.subList(0, maxLines).forEach(e -> linesToPrint.add(e));
        linesToPrint.add(this.sectionList.get(this.currentSectionPosition).getTotal());
        this.currentSectionLinesToPrint.subList(0, maxLines).clear();
        if (this.currentSectionLinesToPrint.size() == 0) {
            this.currentSectionPosition++;
        }
        return linesToPrint;
    }

    public boolean remainLines() {
        if (this.currentSectionPosition == this.sectionList.size()) {
            this.currentSectionPosition = 0;
            return false;
        }
        return true;
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
