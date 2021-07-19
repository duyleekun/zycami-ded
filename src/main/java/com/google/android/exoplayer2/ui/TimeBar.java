/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.ui;

import com.google.android.exoplayer2.ui.TimeBar$OnScrubListener;

public interface TimeBar {
    public void addListener(TimeBar$OnScrubListener var1);

    public long getPreferredUpdateDelay();

    public void removeListener(TimeBar$OnScrubListener var1);

    public void setAdGroupTimesMs(long[] var1, boolean[] var2, int var3);

    public void setBufferedPosition(long var1);

    public void setDuration(long var1);

    public void setEnabled(boolean var1);

    public void setKeyCountIncrement(int var1);

    public void setKeyTimeIncrement(long var1);

    public void setPosition(long var1);
}

