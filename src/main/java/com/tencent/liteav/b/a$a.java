/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.b;

public class a$a {
    public int a = 544;
    public int b = 960;
    public int c = 20;
    public int d = 1000;
    public Object e;
    public String f;
    public String g;
    public int h = 0;
    public int i = 0;
    public int j = 16;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("TXCStreamRecordParams: [width=");
        int n10 = this.a;
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("; height=");
        n10 = this.b;
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("; fps=");
        n10 = this.c;
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("; bitrate=");
        n10 = this.d;
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("; channels=");
        n10 = this.h;
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("; samplerate=");
        n10 = this.i;
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("; bits=");
        n10 = this.j;
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("; EGLContext=");
        Object object = this.e;
        ((StringBuilder)charSequence).append(object);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("; coveriamge=");
        object = this.g;
        ((StringBuilder)charSequence).append((String)object);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("; outputpath=");
        object = this.f;
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append("]");
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        return stringBuilder.toString();
    }
}

