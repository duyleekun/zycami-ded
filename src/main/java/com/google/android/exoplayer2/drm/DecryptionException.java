/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

public class DecryptionException
extends Exception {
    public final int errorCode;

    public DecryptionException(int n10, String string2) {
        super(string2);
        this.errorCode = n10;
    }
}

