/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.HashFunction;
import com.google.common.hash.MessageDigestHashFunction;

public class Hashing$Md5Holder {
    public static final HashFunction MD5;

    static {
        MessageDigestHashFunction messageDigestHashFunction = new MessageDigestHashFunction("MD5", "Hashing.md5()");
        MD5 = messageDigestHashFunction;
    }

    private Hashing$Md5Holder() {
    }
}

