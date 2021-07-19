/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class jf {
    public final byte a;
    public final String a;
    public final short a;

    public jf() {
        this("", 0, 0);
    }

    public jf(String string2, byte by2, short s10) {
        this.a = string2;
        this.a = by2;
        this.a = s10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<TField name:'");
        String string2 = this.a;
        stringBuilder.append(string2);
        stringBuilder.append("' type:");
        short s10 = this.a;
        stringBuilder.append(s10);
        stringBuilder.append(" field-id:");
        s10 = this.a;
        stringBuilder.append(s10);
        stringBuilder.append(">");
        return stringBuilder.toString();
    }
}

