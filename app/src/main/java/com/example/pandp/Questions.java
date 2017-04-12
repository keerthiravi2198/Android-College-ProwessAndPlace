package com.example.pandp;

public class Questions {

    private String qName;
    private String opA;
    private String opB;
    private String opC;
    private String opD;
    private Integer ans;
    private Integer qNo;


    public Questions(Integer No, String name, String A, String B, String C, String D, Integer answer) {
        qNo = No;
        qName = name;
        opA = A;
        opB = B;
        opC = C;
        opD = D;
        ans = answer;
    }


    public String getqName() {
        return qName;
    }
    public String getopA() {
        return opA;
    }
    public String getopB() {
        return opB;
    }
    public String getopC() {
        return opC;
    }
    public String getopD() {
        return opD;
    }
    public Integer getAns() {
        return ans;
    }
    public Integer getqNo() {
        return qNo;
    }

}