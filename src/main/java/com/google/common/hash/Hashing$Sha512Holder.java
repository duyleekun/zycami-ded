/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.HashFunction;
import com.google.common.hash.MessageDigestHashFunction;

public class Hashing$Sha512Holder {
    public static final HashFunction SHA_512;

    static {
        MessageDigestHashFunction messageDigestHashFunction = new MessageDigestHashFunction("SHA-512", "Hashing.sha512()");
        SHA_512 = messageDigestHashFunction;
    }

    private Hashing$Sha512Holder() {
    }
}

