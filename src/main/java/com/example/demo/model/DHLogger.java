package com.example.demo.model;

public class DHLogger {
    private int p;
    private int g;
    private int a; // client private key
    private int b; // server private key
    private double publicKeyA;
    private double publicKeyB;
    private double aDash;
    private double bDash;

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public double getPublicKeyA() {
        return publicKeyA;
    }

    public void setPublicKeyA(double publicKeyA) {
        this.publicKeyA = publicKeyA;
    }

    public double getPublicKeyB() {
        return publicKeyB;
    }

    public void setPublicKeyB(double publicKeyB) {
        this.publicKeyB = publicKeyB;
    }

    public double getaDash() {
        return aDash;
    }

    public void setaDash(double aDash) {
        this.aDash = aDash;
    }

    public double getbDash() {
        return bDash;
    }

    public void setbDash(double bDash) {
        this.bDash = bDash;
    }
}
