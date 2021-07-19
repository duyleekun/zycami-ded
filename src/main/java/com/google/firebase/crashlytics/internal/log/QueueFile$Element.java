/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.log;

public class QueueFile$Element {
    public static final int HEADER_LENGTH = 4;
    public static final QueueFile$Element NULL;
    public final int length;
    public final int position;

    static {
        QueueFile$Element queueFile$Element;
        NULL = queueFile$Element = new QueueFile$Element(0, 0);
    }

    public QueueFile$Element(int n10, int n11) {
        this.position = n10;
        this.length = n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.getClass().getSimpleName();
        stringBuilder.append(string2);
        stringBuilder.append("[position = ");
        int n10 = this.position;
        stringBuilder.append(n10);
        stringBuilder.append(", length = ");
        n10 = this.length;
        stringBuilder.append(n10);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

