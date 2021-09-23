package test.demo;

public class DictionaryObject {
    String fullString;
    String subString1;
    String subString2;

    public DictionaryObject(String fullString, String subString1, String subString2) {
        this.fullString = fullString;
        this.subString1 = subString1;
        this.subString2 = subString2;
    }

    public String getFullString() {
        return fullString;
    }

    public void setFullString(String fullString) {
        this.fullString = fullString;
    }

    public String getSubString1() {
        return subString1;
    }

    public void setSubString1(String subString1) {
        this.subString1 = subString1;
    }

    public String getSubString2() {
        return subString2;
    }

    public void setSubString2(String subString2) {
        this.subString2 = subString2;
    }

    public String toString(){
        return getSubString1() + " + " + getSubString2() + " => " + getFullString();
    }
}
