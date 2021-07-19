/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons;

import java.io.ByteArrayOutputStream;

public final class b$5
extends ByteArrayOutputStream {
    public final /* synthetic */ byte[][] a;
    public final /* synthetic */ int[] b;

    public b$5(byte[][] byArray, int[] nArray) {
        this.a = byArray;
        this.b = nArray;
    }

    public void close() {
        super.close();
        Object object = this.a;
        byte[] byArray = this.buf;
        object[0] = byArray;
        object = this.b;
        int n10 = this.count;
        object[0] = (byte[])n10;
    }
}

