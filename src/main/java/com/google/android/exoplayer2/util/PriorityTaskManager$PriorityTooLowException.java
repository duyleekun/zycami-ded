/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import java.io.IOException;

public class PriorityTaskManager$PriorityTooLowException
extends IOException {
    public PriorityTaskManager$PriorityTooLowException(int n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder(60);
        stringBuilder.append("Priority too low [priority=");
        stringBuilder.append(n10);
        stringBuilder.append(", highest=");
        stringBuilder.append(n11);
        stringBuilder.append("]");
        String string2 = stringBuilder.toString();
        super(string2);
    }
}

