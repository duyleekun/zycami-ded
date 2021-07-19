/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.MessageDigestHashFunction;
import com.google.common.hash.MessageDigestHashFunction$1;
import java.io.Serializable;

public final class MessageDigestHashFunction$SerializedForm
implements Serializable {
    private static final long serialVersionUID;
    private final String algorithmName;
    private final int bytes;
    private final String toString;

    private MessageDigestHashFunction$SerializedForm(String string2, int n10, String string3) {
        this.algorithmName = string2;
        this.bytes = n10;
        this.toString = string3;
    }

    public /* synthetic */ MessageDigestHashFunction$SerializedForm(String string2, int n10, String string3, MessageDigestHashFunction$1 messageDigestHashFunction$1) {
        this(string2, n10, string3);
    }

    private Object readResolve() {
        String string2 = this.algorithmName;
        int n10 = this.bytes;
        String string3 = this.toString;
        MessageDigestHashFunction messageDigestHashFunction = new MessageDigestHashFunction(string2, n10, string3);
        return messageDigestHashFunction;
    }
}

