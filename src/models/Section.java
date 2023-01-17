package models;

import java.util.ArrayList;
import java.util.List;

public class Section {

    private String title;
    private List<Line> lineList;
    private Line total;

    public Section(){
        this.lineList = new ArrayList<>();
    }

    public Integer getSize(){
        return lineList.size();
    }

    public Line getLine(Integer lineNumber){
        return this.lineList.get(lineNumber);
    }

    // public String totalLineToString(){
    //     return this.total.toString();
    // }

    public Line getTotal(){
        return this.total;
    }

    public void setListLines(Line line) {
        this.lineList.add(line);
    }

    public void setTotalLine(Line line){
        this.total = line;
    }

    public String getTitle() {
        return this.title;
    }

    public void setH3(String h3) {
        this.title = h3;
    }
}
