package com.example.demo.algorithms;

import com.example.demo.model.ClientDHData;
import com.example.demo.model.DHLogger;
import org.springframework.stereotype.Service;

@Service
public class MyDH {
    private int p;
    private int g;
    private final int a = 4; // client private key
    private final int b = 3; // server private key
    private double A;
    private double B;
    private double aDash;
    private double bDash;

    public void calculatePublicClientKey(ClientDHData clientDHData) {
        p = clientDHData.getClientP();
        g = clientDHData.getClientG();
        A = ((Math.pow(g, a)) % p); // calculation of A public key
    }

    public void calculatePublicServerKey() {
        B = ((Math.pow(g, b)) % p); // calculation of B publick key
    }

    public void calculateSecurityClientKey() {
        if (B != 0) {
            aDash = ((Math.pow(B, a)) % p); // calculation of Adash
        }
    }

    public void calculateSecurityServerKey() {
        if (A != 0) {
            bDash = ((Math.pow(A, b)) % p); // calculation of Bdash
        }
    }


    public DHLogger setUpDHViewLogger() {
        DHLogger dhLogger = new DHLogger();
        dhLogger.setP(p);
        dhLogger.setG(g);
        dhLogger.setA(a);
        dhLogger.setB(b);
        dhLogger.setPublicKeyA(A);
        dhLogger.setPublicKeyB(B);
        dhLogger.setaDash(aDash);
        dhLogger.setbDash(bDash);
        return dhLogger;
    }
}
