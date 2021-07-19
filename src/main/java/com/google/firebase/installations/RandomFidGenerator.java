/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.google.firebase.installations;

import android.util.Base64;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.UUID;

public class RandomFidGenerator {
    private static final byte FID_4BIT_PREFIX = 0;
    private static final int FID_LENGTH = 22;
    private static final byte REMOVE_PREFIX_MASK;

    static {
        int n10 = 2;
        FID_4BIT_PREFIX = Byte.parseByte("01110000", n10);
        REMOVE_PREFIX_MASK = Byte.parseByte("00001111", n10);
    }

    private static String encodeFidBase64UrlSafe(byte[] byArray) {
        byArray = Base64.encode((byte[])byArray, (int)11);
        Charset charset = Charset.defaultCharset();
        String string2 = new String(byArray, charset);
        return string2.substring(0, 22);
    }

    private static byte[] getBytesFromUUID(UUID uUID, byte[] object) {
        object = ByteBuffer.wrap((byte[])object);
        long l10 = uUID.getMostSignificantBits();
        ((ByteBuffer)object).putLong(l10);
        l10 = uUID.getLeastSignificantBits();
        ((ByteBuffer)object).putLong(l10);
        return ((ByteBuffer)object).array();
    }

    public String createRandomFid() {
        Object object;
        Object object2 = UUID.randomUUID();
        byte[] byArray = new byte[17];
        object2 = RandomFidGenerator.getBytesFromUUID((UUID)object2, byArray);
        object2[16] = object = object2[0];
        object = REMOVE_PREFIX_MASK;
        Object object3 = object2[0];
        object = object & object3;
        object3 = FID_4BIT_PREFIX;
        object2[0] = object = (Object)((byte)(object | object3));
        return RandomFidGenerator.encodeFidBase64UrlSafe((byte[])object2);
    }
}

