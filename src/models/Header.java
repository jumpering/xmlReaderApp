package models;

public class Header {

    private String pageTitle;
    private String listTitle;
    private String sectionListTitle;
    private String H4;//todo falta nombrar
    private String rowTitles;
    // private String date; //necesary to separate?
    // private Integer pageNumber; //necesary to separate?

    public String toString(){
        return this.getPageTitle() + "\n"
                + this.getListTitle() + "\n"
                + this.getsectionListTitle() + "\n"
                + getH4() + "\n"
                + getRowTitles() + "\n";
    }

    public String getPageTitle() {
        return this.pageTitle;
    }

    public void setPageTitle(String pageTitle){
        this.pageTitle = pageTitle;
    }

    public void setH1(String h1) {
        //todo separate pageNumber and date?     
        this.pageTitle = h1;
    }

    public String getListTitle() {
        return this.listTitle;
    }

    public void setH2(String h2) {
        this.listTitle = h2;
    }

    public String getsectionListTitle() {
        return this.sectionListTitle;
    }

    public void setH3(String h3) {
        this.sectionListTitle = h3;
    }

    public String getH4() {
        return H4;
    }

    public void setH4(String h4) {
        H4 = h4;
    }

    public String getRowTitles() {
        return this.rowTitles;
    }

    public void setH5(String h5) {
        this.rowTitles = h5;
    }


}
