/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import java.util.List;
import java.util.Random;

public final class RandomTrackSelection
extends BaseTrackSelection {
    private final Random random;
    private int selectedIndex;

    public RandomTrackSelection(TrackGroup object, int ... nArray) {
        super((TrackGroup)object, nArray);
        int n10;
        this.random = object = new Random();
        int n11 = this.length;
        this.selectedIndex = n10 = ((Random)object).nextInt(n11);
    }

    public RandomTrackSelection(TrackGroup trackGroup, int[] nArray, long l10) {
        Random random = new Random(l10);
        this(trackGroup, nArray, random);
    }

    public RandomTrackSelection(TrackGroup trackGroup, int[] nArray, Random random) {
        super(trackGroup, nArray);
        this.random = random;
        int n10 = this.length;
        this.selectedIndex = n10 = random.nextInt(n10);
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    public Object getSelectionData() {
        return null;
    }

    public int getSelectionReason() {
        return 3;
    }

    public void updateSelectedTrack(long l10, long l11, long l12, List list, MediaChunkIterator[] mediaChunkIteratorArray) {
        int n10;
        int n11;
        l10 = SystemClock.elapsedRealtime();
        int n12 = 0;
        Random random = null;
        int n13 = 0;
        for (n11 = 0; n11 < (n10 = this.length); ++n11) {
            n10 = (int)(this.isBlacklisted(n11, l10) ? 1 : 0);
            if (n10 != 0) continue;
            ++n13;
        }
        random = this.random;
        this.selectedIndex = n11 = random.nextInt(n13);
        n11 = this.length;
        if (n13 != n11) {
            n11 = 0;
            random = null;
            while (n12 < (n13 = this.length)) {
                n13 = (int)(this.isBlacklisted(n12, l10) ? 1 : 0);
                if (n13 == 0) {
                    n13 = this.selectedIndex;
                    n10 = n11 + 1;
                    if (n13 == n11) {
                        this.selectedIndex = n12;
                        return;
                    }
                    n11 = n10;
                }
                ++n12;
            }
        }
    }
}

