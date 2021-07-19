/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import java.util.Arrays;
import java.util.Objects;

public final class EncodedPayload {
    private final byte[] bytes;
    private final Encoding encoding;

    public EncodedPayload(Encoding encoding, byte[] byArray) {
        Objects.requireNonNull(encoding, "encoding is null");
        Objects.requireNonNull(byArray, "bytes is null");
        this.encoding = encoding;
        this.bytes = byArray;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof EncodedPayload;
        if (!bl2) {
            return false;
        }
        object = (EncodedPayload)object;
        Object object2 = this.encoding;
        Encoding encoding = ((EncodedPayload)object).encoding;
        bl2 = ((Encoding)object2).equals(encoding);
        if (!bl2) {
            return false;
        }
        object2 = this.bytes;
        object = ((EncodedPayload)object).bytes;
        return Arrays.equals((byte[])object2, (byte[])object);
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public Encoding getEncoding() {
        return this.encoding;
    }

    public int hashCode() {
        int n10 = this.encoding.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        n11 = Arrays.hashCode(this.bytes);
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EncodedPayload{encoding=");
        Encoding encoding = this.encoding;
        stringBuilder.append(encoding);
        stringBuilder.append(", bytes=[...]}");
        return stringBuilder.toString();
    }
}

