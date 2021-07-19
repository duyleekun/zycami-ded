/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractHashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.MacHashFunction$MacHasher;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

public final class MacHashFunction
extends AbstractHashFunction {
    private final int bits;
    private final Key key;
    private final Mac prototype;
    private final boolean supportsClone;
    private final String toString;

    public MacHashFunction(String object, Key object2, String string2) {
        boolean bl2;
        int n10;
        this.prototype = object = MacHashFunction.getMac((String)object, (Key)object2);
        object2 = (Key)Preconditions.checkNotNull(object2);
        this.key = object2;
        this.toString = object2 = (String)Preconditions.checkNotNull(string2);
        this.bits = n10 = ((Mac)object).getMacLength() * 8;
        this.supportsClone = bl2 = MacHashFunction.supportsClone((Mac)object);
    }

    private static Mac getMac(String object, Key serializable) {
        object = Mac.getInstance((String)object);
        try {
            ((Mac)object).init((Key)serializable);
            return object;
        }
        catch (InvalidKeyException invalidKeyException) {
            serializable = new IllegalArgumentException(invalidKeyException);
            throw serializable;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            serializable = new IllegalStateException(noSuchAlgorithmException);
            throw serializable;
        }
    }

    private static boolean supportsClone(Mac mac) {
        try {
            mac.clone();
            return true;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return false;
        }
    }

    public int bits() {
        return this.bits;
    }

    public Hasher newHasher() {
        MacHashFunction$MacHasher macHashFunction$MacHasher;
        Object object;
        boolean bl2 = this.supportsClone;
        if (bl2) {
            try {
                object = this.prototype;
            }
            catch (CloneNotSupportedException cloneNotSupportedException) {}
            object = ((Mac)object).clone();
            object = (Mac)object;
            macHashFunction$MacHasher = new MacHashFunction$MacHasher((Mac)object, null);
            return macHashFunction$MacHasher;
        }
        object = this.prototype.getAlgorithm();
        Key key = this.key;
        object = MacHashFunction.getMac((String)object, key);
        macHashFunction$MacHasher = new MacHashFunction$MacHasher((Mac)object, null);
        return macHashFunction$MacHasher;
    }

    public String toString() {
        return this.toString;
    }
}

