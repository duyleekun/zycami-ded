/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.HashFunction;
import com.google.common.hash.MessageDigestHashFunction;

public class Hashing$Sha1Holder {
    public static final HashFunction SHA_1;

    static {
        MessageDigestHashFunction messageDigestHashFunction = new MessageDigestHashFunction("SHA-1", "Hashing.sha1()");
        SHA_1 = messageDigestHashFunction;
    }

    private Hashing$Sha1Holder() {
    }
}

