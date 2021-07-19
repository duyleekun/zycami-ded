/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

public final class AdPlaybackState$AdGroup {
    public final int count;
    public final long[] durationsUs;
    public final int[] states;
    public final Uri[] uris;

    public AdPlaybackState$AdGroup() {
        int[] nArray = new int[]{};
        Uri[] uriArray = new Uri[]{};
        long[] lArray = new long[]{};
        this(-1, nArray, uriArray, lArray);
    }

    private AdPlaybackState$AdGroup(int n10, int[] nArray, Uri[] uriArray, long[] lArray) {
        int n11 = nArray.length;
        int n12 = uriArray.length;
        n11 = n11 == n12 ? 1 : 0;
        Assertions.checkArgument(n11 != 0);
        this.count = n10;
        this.states = nArray;
        this.uris = uriArray;
        this.durationsUs = lArray;
    }

    private static long[] copyDurationsUsWithSpaceForAdCount(long[] lArray, int n10) {
        int n11 = lArray.length;
        n10 = Math.max(n10, n11);
        lArray = Arrays.copyOf(lArray, n10);
        Arrays.fill(lArray, n11, n10, -9223372036854775807L);
        return lArray;
    }

    private static int[] copyStatesWithSpaceForAdCount(int[] nArray, int n10) {
        int n11 = nArray.length;
        n10 = Math.max(n10, n11);
        nArray = Arrays.copyOf(nArray, n10);
        Arrays.fill(nArray, n11, n10, 0);
        return nArray;
    }

    public boolean equals(Object object) {
        Object[] objectArray;
        Object[] objectArray2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (objectArray2 = AdPlaybackState$AdGroup.class) == (objectArray = object.getClass())) {
            boolean bl3;
            object = (AdPlaybackState$AdGroup)object;
            int n10 = this.count;
            int n11 = ((AdPlaybackState$AdGroup)object).count;
            if (n10 != n11 || (n10 = (int)(Arrays.equals(objectArray2 = this.uris, objectArray = ((AdPlaybackState$AdGroup)object).uris) ? 1 : 0)) == 0 || (n10 = (int)(Arrays.equals((int[])(objectArray2 = (Object[])this.states), (int[])(objectArray = (Object[])((AdPlaybackState$AdGroup)object).states)) ? 1 : 0)) == 0 || !(bl3 = Arrays.equals((long[])(objectArray2 = (Object[])this.durationsUs), (long[])(object = (Object)((AdPlaybackState$AdGroup)object).durationsUs)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getFirstAdIndexToPlay() {
        return this.getNextAdIndexToPlay(-1);
    }

    public int getNextAdIndexToPlay(int n10) {
        int n11;
        int[] nArray;
        int n12;
        int n13 = 1;
        n10 += n13;
        while (n10 < (n12 = (nArray = this.states).length) && (n12 = nArray[n10]) != 0 && (n11 = nArray[n10]) != n13) {
            ++n10;
        }
        return n10;
    }

    public boolean hasUnplayedAds() {
        int n10 = this.count;
        int n11 = -1;
        n10 = n10 != n11 && (n10 = this.getFirstAdIndexToPlay()) >= (n11 = this.count) ? 0 : 1;
        return n10 != 0;
    }

    public int hashCode() {
        int n10 = this.count * 31;
        int n11 = Arrays.hashCode(this.uris);
        n10 = (n10 + n11) * 31;
        n11 = Arrays.hashCode(this.states);
        n10 = (n10 + n11) * 31;
        n11 = Arrays.hashCode(this.durationsUs);
        return n10 + n11;
    }

    public AdPlaybackState$AdGroup withAdCount(int n10) {
        int[] nArray = AdPlaybackState$AdGroup.copyStatesWithSpaceForAdCount(this.states, n10);
        long[] lArray = AdPlaybackState$AdGroup.copyDurationsUsWithSpaceForAdCount(this.durationsUs, n10);
        Uri[] uriArray = Arrays.copyOf(this.uris, n10);
        AdPlaybackState$AdGroup adPlaybackState$AdGroup = new AdPlaybackState$AdGroup(n10, nArray, uriArray, lArray);
        return adPlaybackState$AdGroup;
    }

    public AdPlaybackState$AdGroup withAdDurationsUs(long[] lArray) {
        int n10 = lArray.length;
        Uri[] uriArray = this.uris;
        int n11 = uriArray.length;
        if (n10 < n11) {
            n10 = uriArray.length;
            lArray = AdPlaybackState$AdGroup.copyDurationsUsWithSpaceForAdCount(lArray, n10);
        } else {
            n10 = this.count;
            n11 = -1;
            if (n10 != n11 && (n10 = lArray.length) > (n11 = uriArray.length)) {
                n10 = uriArray.length;
                lArray = Arrays.copyOf(lArray, n10);
            }
        }
        int n12 = this.count;
        int[] nArray = this.states;
        Uri[] uriArray2 = this.uris;
        AdPlaybackState$AdGroup adPlaybackState$AdGroup = new AdPlaybackState$AdGroup(n12, nArray, uriArray2, lArray);
        return adPlaybackState$AdGroup;
    }

    public AdPlaybackState$AdGroup withAdState(int n10, int n11) {
        int[] nArray;
        int n12 = this.count;
        int n13 = 0;
        long[] lArray = null;
        int n14 = 1;
        int n15 = -1;
        if (n12 != n15 && n11 >= n12) {
            n12 = 0;
            nArray = null;
        } else {
            n12 = n14;
        }
        Assertions.checkArgument(n12 != 0);
        nArray = this.states;
        n15 = n11 + 1;
        nArray = AdPlaybackState$AdGroup.copyStatesWithSpaceForAdCount(nArray, n15);
        n15 = nArray[n11];
        if (n15 == 0 || (n15 = nArray[n11]) == n14 || (n15 = nArray[n11]) == n10) {
            n13 = n14;
        }
        Assertions.checkArgument(n13 != 0);
        lArray = this.durationsUs;
        n14 = lArray.length;
        n15 = nArray.length;
        if (n14 != n15) {
            n14 = nArray.length;
            lArray = AdPlaybackState$AdGroup.copyDurationsUsWithSpaceForAdCount(lArray, n14);
        }
        Uri[] uriArray = this.uris;
        n15 = uriArray.length;
        int n16 = nArray.length;
        if (n15 != n16) {
            n15 = nArray.length;
            uriArray = Arrays.copyOf(uriArray, n15);
        }
        nArray[n11] = n10;
        n11 = this.count;
        AdPlaybackState$AdGroup adPlaybackState$AdGroup = new AdPlaybackState$AdGroup(n11, nArray, uriArray, lArray);
        return adPlaybackState$AdGroup;
    }

    public AdPlaybackState$AdGroup withAdUri(Uri object, int n10) {
        int[] nArray = this.states;
        long[] lArray = this.durationsUs;
        int n11 = lArray.length;
        int n12 = n10 + 1;
        int n13 = (nArray = AdPlaybackState$AdGroup.copyStatesWithSpaceForAdCount(nArray, n12)).length;
        if (n11 != n13) {
            n11 = nArray.length;
            lArray = AdPlaybackState$AdGroup.copyDurationsUsWithSpaceForAdCount(lArray, n11);
        }
        Uri[] uriArray = this.uris;
        n13 = nArray.length;
        uriArray = Arrays.copyOf(uriArray, n13);
        uriArray[n10] = object;
        nArray[n10] = 1;
        n10 = this.count;
        object = new AdPlaybackState$AdGroup(n10, nArray, uriArray, lArray);
        return object;
    }

    public AdPlaybackState$AdGroup withAllAdsSkipped() {
        int n10 = this.count;
        AdPlaybackState$AdGroup adPlaybackState$AdGroup = null;
        int n11 = -1;
        if (n10 == n11) {
            int[] nArray = new int[]{};
            Uri[] uriArray = new Uri[]{};
            long[] lArray = new long[]{};
            AdPlaybackState$AdGroup adPlaybackState$AdGroup2 = new AdPlaybackState$AdGroup(0, nArray, uriArray, lArray);
            return adPlaybackState$AdGroup2;
        }
        int[] nArray = this.states;
        n11 = nArray.length;
        nArray = Arrays.copyOf(nArray, n11);
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12 = nArray[i10];
            int n13 = 1;
            if (n12 != n13 && (n12 = nArray[i10]) != 0) continue;
            nArray[i10] = n12 = 2;
        }
        Uri[] uriArray = this.uris;
        long[] lArray = this.durationsUs;
        adPlaybackState$AdGroup = new AdPlaybackState$AdGroup(n11, nArray, uriArray, lArray);
        return adPlaybackState$AdGroup;
    }
}

