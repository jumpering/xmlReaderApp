package models;

import java.util.ArrayList;
import java.util.List;

public class Section {

    private String H3;
    private List<Line> lineList;
    private Line total;

    public Section(){
        this.lineList = new ArrayList<>();
    }

    public void setListLines(Line line) {
        this.lineList.add(line);
    }

    public void setTotalLine(Line line){
        this.total = line;
    }

    public String listLinesToString(){
        String lineList = "";
        for (int i = 0; i < this.lineList.size(); i++){
            lineList += this.lineList.get(i);
            lineList += "\n";
        }
        return lineList;
    }

    public String totalLineToString(){
        return this.total.toString();
    }

    public String getH3() {
        return H3;
    }

    public void setH3(String h3) {
        H3 = h3;
    }
}
