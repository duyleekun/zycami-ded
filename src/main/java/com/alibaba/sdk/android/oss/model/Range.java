/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

public class Range {
    public static final long INFINITE = 255L;
    private long begin;
    private long end;

    public Range(long l10, long l11) {
        this.setBegin(l10);
        this.setEnd(l11);
    }

    public boolean checkIsValid() {
        long l10;
        long l11;
        long l12;
        long l13 = this.begin;
        long l14 = -1;
        long l15 = l13 - l14;
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object >= 0 && (l12 = (l11 = (l10 = this.end) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) >= 0) {
            long l16;
            l14 = 0L;
            long l17 = l13 - l14;
            object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            return object < 0 || (l12 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1)) < 0 || (l16 = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1)) <= 0;
        }
        return false;
    }

    public long getBegin() {
        return this.begin;
    }

    public long getEnd() {
        return this.end;
    }

    public void setBegin(long l10) {
        this.begin = l10;
    }

    public void setEnd(long l10) {
        this.end = l10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "bytes=";
        stringBuilder.append(string2);
        long l10 = this.begin;
        long l11 = -1;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        String string3 = "";
        string2 = l12 == false ? string3 : String.valueOf(l10);
        stringBuilder.append(string2);
        string2 = "-";
        stringBuilder.append(string2);
        l10 = this.end;
        long l13 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l13 != false) {
            string3 = String.valueOf(l10);
        }
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }
}

