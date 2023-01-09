package models;

import java.util.HashMap;
import java.util.Map;

public class Header {

    private String date;
    private Map<String, Line> lineMap = new HashMap<String, Line>();

    public String toString(Integer pageNumber) {
        return this.getPageTitle().toString()
                + " Fecha " + this.date
                + "Página " + pageNumber
                + "\n"
                + this.getListTitle().toString() + "\n"
                + this.getsectionListTitle().toString() + "\n"
                + this.getColumnGroup().toString() + "\n"
                + this.getRowTitles().toString() + "\n";
    }

    public Integer getSize() {
        return this.lineMap.size();
    }

    public Line getPageTitle() {
        return this.lineMap.get("pageTitle");
    }

    public void setPageTitle(String pageTitle) {
        this.lineMap.put("pageTitle", new Line(pageTitle));
    }

    public void setH1(String h1) {
        String[] separateTitleDateAndPage = h1.split("\\bFecha | \\bPágina");
        String title = separateTitleDateAndPage[0];
        this.date = separateTitleDateAndPage[1];
        this.lineMap.put("pageTitle", new Line(title));
    }

    public Line getListTitle() {
        return this.lineMap.get("listTitle");
    }

    public void setH2(String h2) {
        this.lineMap.put("listTitle", new Line(h2));
    }

    public Line getsectionListTitle() {
        return this.lineMap.get("sectionListTitle");
    }

    public void setH3(String h3) {
        this.lineMap.put("sectionListTitle", new Line(h3));
    }

    public Line getColumnGroup() {
        return this.lineMap.get("columnGroup");
    }

    public void setH4(String h4) {
        this.lineMap.put("columnGroup", new Line(h4));
    }

    public Line getRowTitles() {
        return this.lineMap.get("rowTitles");
    }

    public void setH5(String h5) {
        this.lineMap.put("rowTitles", new Line(h5));
    }
}
