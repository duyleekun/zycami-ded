/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.license;

import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import javax.crypto.Cipher;

public class h {
    public static final byte[] a = "#PART#".getBytes();

    public static byte[] a(byte[] byArray, byte[] object) {
        Object object2 = new PKCS8EncodedKeySpec((byte[])object);
        object = KeyFactory.getInstance("RSA").generatePrivate((KeySpec)object2);
        object2 = Cipher.getInstance("RSA/None/PKCS1Padding");
        ((Cipher)object2).init(2, (Key)object);
        return ((Cipher)object2).doFinal(byArray);
    }

    public static byte[] b(byte[] byArray, byte[] object) {
        int n10;
        Object object2 = a;
        int n11 = ((byte[])object2).length;
        if (n11 <= 0) {
            return h.a(byArray, (byte[])object);
        }
        int n12 = byArray.length;
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>(1024);
        int n13 = 0;
        int n14 = 0;
        byte[] byArray2 = null;
        for (int i10 = 0; i10 < n12; i10 += n10) {
            Object object3;
            int n15;
            byte[] byArray3;
            int n16;
            int n17;
            block7: {
                block9: {
                    block10: {
                        block8: {
                            n17 = byArray[i10];
                            n16 = n12 + -1;
                            n10 = 1;
                            if (i10 != n16) break block8;
                            n17 = n12 - n14;
                            byArray3 = new byte[n17];
                            System.arraycopy(byArray, n14, byArray3, 0, n17);
                            byArray2 = h.a(byArray3, (byte[])object);
                            n17 = byArray2.length;
                            byArray3 = null;
                            for (n16 = 0; n16 < n17; ++n16) {
                                n15 = byArray2[n16];
                                object3 = (byte)n15;
                                arrayList.add((byte[])object3);
                            }
                            n14 = i10 + n11;
                            i10 = n14 + -1;
                            break block9;
                        }
                        byArray3 = a;
                        n16 = byArray3[0];
                        if (n17 != n16) break block9;
                        if (n11 <= n10) break block10;
                        n17 = i10 + n11;
                        if (n17 >= n12) break block9;
                        n16 = 0;
                        byArray3 = null;
                        for (n17 = n10; n17 < n11; ++n17) {
                            object3 = a;
                            n15 = object3[n17];
                            int n18 = i10 + n17;
                            if (n15 == (n18 = byArray[n18])) {
                                n15 = n11 + -1;
                                if (n17 != n15) continue;
                                n16 = n10;
                                continue;
                            }
                            break block7;
                        }
                        break block7;
                    }
                    n16 = n10;
                    break block7;
                }
                n16 = 0;
                byArray3 = null;
            }
            if (n16 == 0) continue;
            n17 = i10 - n14;
            byArray3 = new byte[n17];
            System.arraycopy(byArray, n14, byArray3, 0, n17);
            byArray2 = h.a(byArray3, (byte[])object);
            n17 = byArray2.length;
            byArray3 = null;
            for (n16 = 0; n16 < n17; ++n16) {
                n15 = byArray2[n16];
                object3 = (byte)n15;
                arrayList.add((byte[])object3);
            }
            int n19 = (i10 += n11) + -1;
            n14 = i10;
            i10 = n19;
        }
        int n20 = arrayList.size();
        byArray = new byte[n20];
        object = arrayList.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object2 = (Byte)object.next();
            n12 = n13 + 1;
            byArray[n13] = n11 = (int)object2.byteValue();
            n13 = n12;
        }
        return byArray;
    }
}

