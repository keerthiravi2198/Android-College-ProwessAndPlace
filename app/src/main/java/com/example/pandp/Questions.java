package com.example.pandp;

public class Questions {

    private String qName;
    private String opA;
    private String opB;
    private String opC;
    private String opD;


    public Questions(String name, String A, String B, String C, String D)
    {
        qName = name;
        opA = A;
        opB = B;
        opC = C;
        opD = D;
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
}