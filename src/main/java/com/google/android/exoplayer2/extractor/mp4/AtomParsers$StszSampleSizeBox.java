/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom;
import com.google.android.exoplayer2.extractor.mp4.AtomParsers$SampleSizeBox;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public final class AtomParsers$StszSampleSizeBox
implements AtomParsers$SampleSizeBox {
    private final ParsableByteArray data;
    private final int fixedSampleSize;
    private final int sampleCount;

    public AtomParsers$StszSampleSizeBox(Atom$LeafAtom object, Format format) {
        int n10;
        this.data = object = ((Atom$LeafAtom)object).data;
        ((ParsableByteArray)object).setPosition(12);
        int n11 = ((ParsableByteArray)object).readUnsignedIntToInt();
        String string2 = format.sampleMimeType;
        CharSequence charSequence = "audio/raw";
        boolean n12 = ((String)charSequence).equals(string2);
        if (n12) {
            int n13;
            int n14 = format.pcmEncoding;
            int n15 = format.channelCount;
            n15 = Util.getPcmFrameSize(n14, n15);
            if (n11 == 0 || (n13 = n11 % n15) != 0) {
                int n16 = 88;
                super(n16);
                ((StringBuilder)charSequence).append("Audio sample size mismatch. stsd sample size: ");
                ((StringBuilder)charSequence).append(n15);
                ((StringBuilder)charSequence).append(", stsz sample size: ");
                ((StringBuilder)charSequence).append(n11);
                String string3 = ((StringBuilder)charSequence).toString();
                string2 = "AtomParsers";
                Log.w(string2, string3);
                n11 = n15;
            }
        }
        if (n11 == 0) {
            n11 = -1;
        }
        this.fixedSampleSize = n11;
        this.sampleCount = n10 = ((ParsableByteArray)object).readUnsignedIntToInt();
    }

    public int getFixedSampleSize() {
        return this.fixedSampleSize;
    }

    public int getSampleCount() {
        return this.sampleCount;
    }

    public int readNextSampleSize() {
        int n10 = this.fixedSampleSize;
        int n11 = -1;
        if (n10 == n11) {
            ParsableByteArray parsableByteArray = this.data;
            n10 = parsableByteArray.readUnsignedIntToInt();
        }
        return n10;
    }
}

