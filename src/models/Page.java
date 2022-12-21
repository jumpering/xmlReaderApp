package models;

public class Page {

    private String Printer;
    private String FontFamily;
    private String FontSize;
    private String Orientation;

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
}
