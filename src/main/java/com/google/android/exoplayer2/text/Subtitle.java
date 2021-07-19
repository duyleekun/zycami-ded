/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text;

import java.util.List;

public interface Subtitle {
    public List getCues(long var1);

    public long getEventTime(int var1);

    public int getEventTimeCount();

    public int getNextEventTimeIndex(long var1);
}

