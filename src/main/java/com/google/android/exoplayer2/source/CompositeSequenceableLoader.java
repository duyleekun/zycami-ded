/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.SequenceableLoader;

public class CompositeSequenceableLoader
implements SequenceableLoader {
    public final SequenceableLoader[] loaders;

    public CompositeSequenceableLoader(SequenceableLoader[] sequenceableLoaderArray) {
        this.loaders = sequenceableLoaderArray;
    }

    public boolean continueLoading(long l10) {
        long l11;
        long l12;
        long l13;
        long l14;
        long l15 = l10;
        boolean bl2 = false;
        while ((l14 = (l13 = (l12 = this.getNextLoadPositionUs()) - (l11 = Long.MIN_VALUE)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
            SequenceableLoader[] sequenceableLoaderArray = this.loaders;
            int n10 = sequenceableLoaderArray.length;
            boolean bl3 = false;
            for (int i10 = 0; i10 < n10; ++i10) {
                SequenceableLoader sequenceableLoader = sequenceableLoaderArray[i10];
                long l16 = sequenceableLoader.getNextLoadPositionUs();
                long l17 = l16 - l11;
                Object object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                object = object != false && (object = l16 == l15 ? 0 : (l16 < l15 ? -1 : 1)) <= 0 ? (Object)1 : (Object)0;
                Object object2 = l16 == l12 ? 0 : (l16 < l12 ? -1 : 1);
                if (object2 != false && object == false) continue;
                boolean bl4 = sequenceableLoader.continueLoading(l15);
                bl3 |= bl4;
            }
            bl2 |= bl3;
            if (bl3) continue;
        }
        return bl2;
    }

    public final long getBufferedPositionUs() {
        long l10;
        SequenceableLoader[] sequenceableLoaderArray = this.loaders;
        int n10 = sequenceableLoaderArray.length;
        long l11 = Long.MAX_VALUE;
        int n11 = 0;
        long l12 = l11;
        while (true) {
            l10 = Long.MIN_VALUE;
            if (n11 >= n10) break;
            SequenceableLoader sequenceableLoader = sequenceableLoaderArray[n11];
            long l13 = sequenceableLoader.getBufferedPositionUs();
            long l14 = l13 - l10;
            Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object != false) {
                l12 = Math.min(l12, l13);
            }
            ++n11;
        }
        Object object = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
        if (object == false) {
            l12 = l10;
        }
        return l12;
    }

    public final long getNextLoadPositionUs() {
        long l10;
        SequenceableLoader[] sequenceableLoaderArray = this.loaders;
        int n10 = sequenceableLoaderArray.length;
        long l11 = Long.MAX_VALUE;
        int n11 = 0;
        long l12 = l11;
        while (true) {
            l10 = Long.MIN_VALUE;
            if (n11 >= n10) break;
            SequenceableLoader sequenceableLoader = sequenceableLoaderArray[n11];
            long l13 = sequenceableLoader.getNextLoadPositionUs();
            long l14 = l13 - l10;
            Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object != false) {
                l12 = Math.min(l12, l13);
            }
            ++n11;
        }
        Object object = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
        if (object == false) {
            l12 = l10;
        }
        return l12;
    }

    public boolean isLoading() {
        for (SequenceableLoader sequenceableLoader : this.loaders) {
            boolean bl2 = sequenceableLoader.isLoading();
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public final void reevaluateBuffer(long l10) {
        for (SequenceableLoader sequenceableLoader : this.loaders) {
            sequenceableLoader.reevaluateBuffer(l10);
        }
    }
}

