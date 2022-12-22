package models;

import java.util.ArrayList;
import java.util.List;

public class Section {

    private List<Line> lineList = new ArrayList<>();

    public void addLineToList(Line line) {
        this.lineList.add(line);
    }

    public String linesToString(){
        String lineList = "";
        for (int i = 0; i < this.lineList.size(); i++){
            lineList += this.lineList.get(i);
            lineList += "\n";
        }
        return lineList;
    }

    public Integer getLinesSize(){
        return this.lineList.size();
    }
}
