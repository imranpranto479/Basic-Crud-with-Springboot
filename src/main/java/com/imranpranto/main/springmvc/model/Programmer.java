package com.imranpranto.main.springmvc.model;

public class Programmer {

 
    private int pId;
    private String pName;
    private String pLang;

    public Programmer() {
    }
    public Programmer(int pId, String pName, String pLang) {
        this.pId = pId;
        this.pName = pName;
        this.pLang = pLang;
    }
    public int getpId() {
        return pId;
    }
    public void setpId(int pId) {
        this.pId = pId;
    }
    public String getpName() {
        return pName;
    }
    public void setpName(String pName) {
        this.pName = pName;
    }
    public String getpLang() {
        return pLang;
    }
    public void setpLang(String pLang) {
        this.pLang = pLang;
    }
    @Override
    public String toString() {
        return "Programmer [pId=" + pId + ", pName=" + pName + ", pLang=" + pLang + "]";
    }
}
