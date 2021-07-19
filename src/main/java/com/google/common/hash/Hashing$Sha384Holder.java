/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.HashFunction;
import com.google.common.hash.MessageDigestHashFunction;

public class Hashing$Sha384Holder {
    public static final HashFunction SHA_384;

    static {
        MessageDigestHashFunction messageDigestHashFunction = new MessageDigestHashFunction("SHA-384", "Hashing.sha384()");
        SHA_384 = messageDigestHashFunction;
    }

    private Hashing$Sha384Holder() {
    }
}

