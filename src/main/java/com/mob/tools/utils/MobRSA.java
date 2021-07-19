/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.SecureRandom;

public class MobRSA {
    private int keySize;

    public MobRSA(int n10) {
        this.keySize = n10;
    }

    private byte[] decodeBlock(byte[] byArray, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = new BigInteger(byArray);
        byArray = bigInteger3.modPow(bigInteger, bigInteger2).toByteArray();
        return this.recoveryPaddingBlock(byArray);
    }

    private byte[] encodeBlock(byte[] object, int n10, int n11, BigInteger bigInteger, BigInteger bigInteger2, int n12) {
        BigInteger bigInteger3;
        int n13;
        int n14 = ((byte[])object).length;
        if (n14 != n11 || n10 != 0) {
            byte[] byArray = new byte[n11];
            System.arraycopy(object, n10, byArray, 0, n11);
            object = byArray;
        }
        if ((n13 = (bigInteger3 = new BigInteger((byte[])(object = this.paddingBlock((byte[])object, n12)))).compareTo(bigInteger2)) <= 0) {
            return bigInteger3.modPow(bigInteger, bigInteger2).toByteArray();
        }
        object = new Throwable;
        object("the message must be smaller than the modulue");
        throw object;
    }

    private byte[] paddingBlock(byte[] object, int n10) {
        int n11 = ((byte[])object).length;
        int n12 = n10 + -1;
        if (n11 <= n12) {
            byte by2;
            byte by3;
            byte[] byArray = new byte[n10];
            byArray[0] = by3 = 1;
            int n13 = ((byte[])object).length;
            byArray[by3] = by2 = (byte)(n13 >> 24);
            byArray[2] = by2 = (byte)(n13 >> 16);
            byArray[3] = by2 = (byte)(n13 >> 8);
            byArray[4] = by2 = (byte)n13;
            System.arraycopy(object, 0, byArray, n10 -= n13, n13);
            return byArray;
        }
        object = new Throwable;
        object("Message too large");
        throw object;
    }

    private byte[] recoveryPaddingBlock(byte[] object) {
        int n10 = object[0];
        int n11 = 1;
        if (n10 == n11) {
            n10 = (object[n11] & 0xFF) << 24;
            n11 = (object[2] & 0xFF) << 16;
            n10 += n11;
            n11 = (object[3] & 0xFF) << 8;
            n10 += n11;
            n11 = object[4] & 0xFF;
            byte[] byArray = new byte[n10 += n11];
            int n12 = ((byte[])object).length - n10;
            System.arraycopy(object, n12, byArray, 0, n10);
            return byArray;
        }
        object = new Throwable;
        object("Not RSA Block");
        throw object;
    }

    public byte[] decode(byte[] object, BigInteger bigInteger, BigInteger bigInteger2) {
        int n10;
        Closeable closeable = new ByteArrayInputStream((byte[])object);
        object = new DataInputStream;
        ((DataInputStream)object)((InputStream)closeable);
        closeable = new ByteArrayOutputStream();
        while ((n10 = ((FilterInputStream)object).available()) > 0) {
            n10 = ((DataInputStream)object).readInt();
            byte[] byArray = new byte[n10];
            ((DataInputStream)object).readFully(byArray);
            byArray = this.decodeBlock(byArray, bigInteger, bigInteger2);
            ((OutputStream)closeable).write(byArray);
        }
        ((FilterInputStream)object).close();
        ((ByteArrayOutputStream)closeable).close();
        return ((ByteArrayOutputStream)closeable).toByteArray();
    }

    public byte[] encode(byte[] byArray, BigInteger bigInteger, BigInteger bigInteger2) {
        int n10;
        byte[] byArray2 = byArray;
        int n11 = this.keySize / 8;
        int n12 = n11 + -11;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        int n13 = 0;
        Object object = null;
        for (int i10 = 0; (n13 = byArray2.length) > i10; i10 += n10) {
            n13 = byArray2.length - i10;
            n10 = Math.min(n13, n12);
            object = this;
            object = this.encodeBlock(byArray, i10, n10, bigInteger, bigInteger2, n11);
            int n14 = ((Object)object).length;
            dataOutputStream.writeInt(n14);
            dataOutputStream.write((byte[])object);
        }
        dataOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public BigInteger[] genKeys() {
        Serializable serializable = new SecureRandom();
        BigInteger bigInteger = BigInteger.probablePrime(this.keySize / 2 + -1, serializable);
        BigInteger bigInteger2 = BigInteger.probablePrime(this.keySize / 2 + -1, serializable);
        serializable = BigInteger.probablePrime(this.keySize / 2, serializable);
        return this.genKeys(bigInteger, bigInteger2, (BigInteger)serializable);
    }

    public BigInteger[] genKeys(BigInteger serializable, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = BigInteger.ONE;
        int n10 = bigInteger2.compareTo(bigInteger3);
        if (n10 > 0) {
            n10 = 3;
            BigInteger[] bigIntegerArray = new BigInteger[n10];
            BigInteger bigInteger4 = ((BigInteger)serializable).multiply(bigInteger);
            int n11 = bigInteger2.compareTo((BigInteger)(serializable = bigInteger4.subtract((BigInteger)serializable).subtract(bigInteger).add(bigInteger3)));
            if (n11 < 0) {
                bigInteger = ((BigInteger)serializable).gcd(bigInteger2);
                n11 = bigInteger.compareTo(bigInteger3);
                if (n11 == 0) {
                    serializable = bigInteger2.modInverse((BigInteger)serializable);
                    bigIntegerArray[0] = bigInteger2;
                    bigIntegerArray[1] = serializable;
                    bigIntegerArray[2] = bigInteger4;
                    return bigIntegerArray;
                }
                serializable = new Throwable("e must be coprime with (p-1)*(q-1)");
                throw serializable;
            }
            serializable = new Throwable("e must be smaller than (p-1)*(q-1)");
            throw serializable;
        }
        serializable = new Throwable("e must be larger than 1");
        throw serializable;
    }
}

