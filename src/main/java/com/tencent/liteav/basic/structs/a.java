/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.structs;

public class a
implements Cloneable {
    public int a;
    public int b;
    public int c;
    public int d;
    public long e;
    public byte[] f;
    public int g;
    public int h;

    public Object clone() {
        Object object = super.clone();
        try {
            object = (a)object;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            cloneNotSupportedException.printStackTrace();
            object = null;
        }
        return object;
    }
}

