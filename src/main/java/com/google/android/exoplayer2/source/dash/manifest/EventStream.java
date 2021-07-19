/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;

public final class EventStream {
    public final EventMessage[] events;
    public final long[] presentationTimesUs;
    public final String schemeIdUri;
    public final long timescale;
    public final String value;

    public EventStream(String string2, String string3, long l10, long[] lArray, EventMessage[] eventMessageArray) {
        this.schemeIdUri = string2;
        this.value = string3;
        this.timescale = l10;
        this.presentationTimesUs = lArray;
        this.events = eventMessageArray;
    }

    public String id() {
        String string2 = this.schemeIdUri;
        String string3 = this.value;
        int n10 = String.valueOf(string2).length() + 1;
        int n11 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append(string2);
        stringBuilder.append("/");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }
}

