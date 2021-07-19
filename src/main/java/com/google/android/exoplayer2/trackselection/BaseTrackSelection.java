/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.o0.a;
import java.util.Arrays;
import java.util.List;

public abstract class BaseTrackSelection
implements ExoTrackSelection {
    private final long[] excludeUntilTimes;
    private final Format[] formats;
    public final TrackGroup group;
    private int hashCode;
    public final int length;
    public final int[] tracks;

    public BaseTrackSelection(TrackGroup object, int ... objectArray) {
        int n10;
        Object object2;
        int n11 = objectArray.length;
        int n12 = 0;
        if (n11 > 0) {
            n11 = 1;
        } else {
            n11 = 0;
            object2 = null;
        }
        Assertions.checkState(n11 != 0);
        object2 = (Format[])Assertions.checkNotNull(object);
        this.group = object2;
        this.length = n11 = objectArray.length;
        object2 = new Format[n11];
        this.formats = object2;
        object2 = null;
        for (n11 = 0; n11 < (n10 = objectArray.length); ++n11) {
            Format format;
            Format[] formatArray = this.formats;
            int n13 = objectArray[n11];
            formatArray[n11] = format = ((TrackGroup)object).getFormat(n13);
        }
        objectArray = this.formats;
        object2 = a.a;
        Arrays.sort(objectArray, object2);
        int n14 = this.length;
        objectArray = new int[n14];
        this.tracks = objectArray;
        while (n12 < (n14 = this.length)) {
            objectArray = this.tracks;
            object2 = this.formats[n12];
            objectArray[n12] = n11 = ((TrackGroup)object).indexOf((Format)object2);
            ++n12;
        }
        object = new long[n14];
        this.excludeUntilTimes = (long[])object;
    }

    public static /* synthetic */ int a(Format format, Format format2) {
        int n10 = format2.bitrate;
        int n11 = format.bitrate;
        return n10 - n11;
    }

    public final boolean blacklist(int n10, long l10) {
        boolean bl2;
        long l11 = SystemClock.elapsedRealtime();
        boolean bl3 = this.isBlacklisted(n10, l11);
        int n11 = 0;
        while (true) {
            int n12 = this.length;
            bl2 = true;
            if (n11 >= n12 || bl3) break;
            bl3 = n11 != n10 && !(bl3 = this.isBlacklisted(n11, l11)) ? bl2 : false;
            ++n11;
        }
        if (!bl3) {
            return false;
        }
        long[] lArray = this.excludeUntilTimes;
        long l12 = lArray[n10];
        l10 = Util.addWithOverflowDefault(l11, l10, Long.MAX_VALUE);
        lArray[n10] = l10 = Math.max(l12, l10);
        return bl2;
    }

    public void disable() {
    }

    public void enable() {
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            object = (BaseTrackSelection)object;
            object3 = this.group;
            object2 = ((BaseTrackSelection)object).group;
            if (object3 != object2 || !(bl3 = Arrays.equals((int[])(object3 = (Object)this.tracks), (int[])(object = (Object)((BaseTrackSelection)object).tracks)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int evaluateQueueSize(long l10, List list) {
        return list.size();
    }

    public final Format getFormat(int n10) {
        return this.formats[n10];
    }

    public final int getIndexInTrackGroup(int n10) {
        return this.tracks[n10];
    }

    public final Format getSelectedFormat() {
        Format[] formatArray = this.formats;
        int n10 = this.getSelectedIndex();
        return formatArray[n10];
    }

    public final int getSelectedIndexInTrackGroup() {
        int[] nArray = this.tracks;
        int n10 = this.getSelectedIndex();
        return nArray[n10];
    }

    public final TrackGroup getTrackGroup() {
        return this.group;
    }

    public int hashCode() {
        int n10 = this.hashCode;
        if (n10 == 0) {
            TrackGroup trackGroup = this.group;
            n10 = System.identityHashCode(trackGroup) * 31;
            int[] nArray = this.tracks;
            int n11 = Arrays.hashCode(nArray);
            this.hashCode = n10 += n11;
        }
        return this.hashCode;
    }

    public final int indexOf(int n10) {
        int n11;
        for (int i10 = 0; i10 < (n11 = this.length); ++i10) {
            int[] nArray = this.tracks;
            n11 = nArray[i10];
            if (n11 != n10) continue;
            return i10;
        }
        return -1;
    }

    public final int indexOf(Format format) {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.length); ++i10) {
            Format format2 = this.formats[i10];
            if (format2 != format) continue;
            return i10;
        }
        return -1;
    }

    public final boolean isBlacklisted(int n10, long l10) {
        long[] lArray = this.excludeUntilTimes;
        long l11 = lArray[n10];
        long l12 = l11 - l10;
        n10 = (n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1))) > 0 ? 1 : 0;
        return n10 != 0;
    }

    public final int length() {
        return this.tracks.length;
    }

    public void onPlaybackSpeed(float f10) {
    }
}

