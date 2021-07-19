/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;

public interface TrackSelection {
    public Format getFormat(int var1);

    public int getIndexInTrackGroup(int var1);

    public TrackGroup getTrackGroup();

    public int indexOf(int var1);

    public int indexOf(Format var1);

    public int length();
}

