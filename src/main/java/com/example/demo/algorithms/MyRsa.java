package com.example.demo.algorithms;

import com.example.demo.model.KeyData;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Objects;

public class MyRsa {

    private BigInteger p, q, n, phi_n;
    private SecureRandom secureRandom = new SecureRandom();
    static int bitLength = 1024;
    private BigInteger publicKeyE;
    private BigInteger privateKeyD;

    public String encrypt(String msg) {
        return new BigInteger(msg.getBytes()).modPow(publicKeyE, n).toString();
    }

    public String encryptService(BigInteger publicKeyE, BigInteger n, String msg) {
        return new BigInteger(msg.getBytes()).modPow(publicKeyE, n).toString();
    }

    public String decrypt(String cipher) {
        BigInteger bi = new BigInteger(cipher).modPow(privateKeyD, n);
        return new String(bi.toByteArray());
    }

    public String decryptService(BigInteger privateKeyD, BigInteger n, String cipher) {
        BigInteger bi = new BigInteger(cipher).modPow(privateKeyD, n);
        return new String(bi.toByteArray());
    }

    public void createKeys() {
        if (Objects.nonNull(p) && Objects.nonNull(q) && Objects.nonNull(phi_n))
        {
            return;
        }
        p = BigInteger.probablePrime(bitLength, secureRandom);
        q = BigInteger.probablePrime(bitLength, secureRandom);
        phi_n = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        n = p.multiply(q);
        publicKeyE  = new BigInteger("65537");
        privateKeyD = publicKeyE.modInverse(phi_n);

    }

    public KeyData getKeyData() {
        KeyData keyData = new KeyData();
        keyData.setPublicKeyE(publicKeyE.toString());
        keyData.setPrivateKeyD(privateKeyD.toString());
        keyData.setNumberN(n.toString());
        return keyData;
    }

}

