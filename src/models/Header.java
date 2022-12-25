package models;

public class Header {

    private String pageHeader;
    private String listTitle;
    private String sectionListTitle;
    private String H4;
    private String H5;

    public String toString(){

        return this.getPageHeader() + "\n"
                + this.getListTitle() + "\n"
                + this.getsectionListTitle() + "\n"
                + getH4() + "\n" //todo falta nombrar
                + getH5() + "\n"; //todo falta nombrar
    }

    public String getPageHeader() {
        return this.pageHeader;
    }

    public void setH1(String h1) {
        this.pageHeader = h1;
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

    public String getH5() {
        //todo for separate columns in array
//        this.H5 = this.H5.trim();
//        this.H5 = this.H5.replaceAll("\\s{2,}", "  ");
//        String[] optionsH5 = this.H5.split("  ");
//        Arrays.stream(optionsH5).forEach((e) -> System.out.println("elemento: " + e));
//        System.out.println("size: "+ optionsH5.length);
        return H5;
    }

    public void setH5(String h5) {
        H5 = h5;
    }


}
