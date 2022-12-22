package models;

public class Header {

    private String H1;
    private String H2;
    private String H3;
    private String H4;
    private String H5;

    public String toString(){

        return getH1() + "\n"
                + getH2() + "\n"
                + getH3() + "\n"
                + getH4() + "\n"
                + getH5() + "\n";
    }

    public String getH1() {
        return H1;
    }

    public void setH1(String h1) {
        H1 = h1;
    }

    public String getH2() {
        return H2;
    }

    public void setH2(String h2) {
        H2 = h2;
    }

    public String getH3() {
        return H3;
    }

    public void setH3(String h3) {
        H3 = h3;
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
