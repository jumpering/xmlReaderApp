package models;

public class Document {

    private String Printer;
    private String FontFamily;
    private String FontSize;
    private String Orientation;

    private Integer maxSize; //todo how? to size by printer or document. for example, DinA4 = 21 x 29,7 cm
    private Header header;
    private Section section;

    public String printConsole(){

        String document = "";
        document += this.header.toString();
        document += this.section.linesToString();

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

    public void setSection(Section section) {
        this.section = section;
    }
}
