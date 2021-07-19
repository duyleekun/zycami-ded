/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package com.google.android.exoplayer2.extractor.wav;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.wav.WavHeader;
import com.google.android.exoplayer2.extractor.wav.WavHeaderReader$ChunkHeader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public final class WavHeaderReader {
    private static final String TAG = "WavHeaderReader";

    private WavHeaderReader() {
    }

    public static WavHeader peek(ExtractorInput object) {
        Object object2;
        long l10;
        Assertions.checkNotNull(object);
        int n10 = 16;
        Object object3 = new ParsableByteArray(n10);
        Object object4 = WavHeaderReader$ChunkHeader.peek((ExtractorInput)object, (ParsableByteArray)object3);
        int n11 = ((WavHeaderReader$ChunkHeader)object4).id;
        int n12 = 0;
        byte[] byArray = null;
        int n13 = 1380533830;
        if (n11 != n13) {
            return null;
        }
        object4 = ((ParsableByteArray)object3).getData();
        object.peekFully((byte[])object4, 0, 4);
        ((ParsableByteArray)object3).setPosition(0);
        n11 = ((ParsableByteArray)object3).readInt();
        n13 = 1463899717;
        if (n11 != n13) {
            object3 = new StringBuilder(36);
            ((StringBuilder)object3).append("Unsupported RIFF format: ");
            ((StringBuilder)object3).append(n11);
            object = ((StringBuilder)object3).toString();
            Log.e(TAG, (String)object);
            return null;
        }
        object4 = WavHeaderReader$ChunkHeader.peek((ExtractorInput)object, (ParsableByteArray)object3);
        while ((n12 = ((WavHeaderReader$ChunkHeader)object4).id) != (n13 = 1718449184)) {
            l10 = ((WavHeaderReader$ChunkHeader)object4).size;
            n11 = (int)l10;
            object.advancePeekPosition(n11);
            object4 = WavHeaderReader$ChunkHeader.peek((ExtractorInput)object, (ParsableByteArray)object3);
        }
        long l11 = ((WavHeaderReader$ChunkHeader)object4).size;
        long l12 = 16;
        long l13 = l11 - l12;
        n12 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
        if (n12 >= 0) {
            n12 = 1;
        } else {
            n12 = 0;
            byArray = null;
        }
        Assertions.checkState(n12 != 0);
        byArray = ((ParsableByteArray)object3).getData();
        object.peekFully(byArray, 0, n10);
        ((ParsableByteArray)object3).setPosition(0);
        int n14 = ((ParsableByteArray)object3).readLittleEndianUnsignedShort();
        int n15 = ((ParsableByteArray)object3).readLittleEndianUnsignedShort();
        int n16 = ((ParsableByteArray)object3).readLittleEndianUnsignedIntToInt();
        int n17 = ((ParsableByteArray)object3).readLittleEndianUnsignedIntToInt();
        int n18 = ((ParsableByteArray)object3).readLittleEndianUnsignedShort();
        int n19 = ((ParsableByteArray)object3).readLittleEndianUnsignedShort();
        l10 = ((WavHeaderReader$ChunkHeader)object4).size;
        int n20 = (int)l10 - n10;
        if (n20 > 0) {
            byte[] byArray2 = new byte[n20];
            object.peekFully(byArray2, 0, n20);
            object2 = byArray2;
        } else {
            object2 = object = (Object)Util.EMPTY_BYTE_ARRAY;
        }
        object = new WavHeader(n14, n15, n16, n17, n18, n19, (byte[])object2);
        return object;
    }

    public static Pair skipToData(ExtractorInput object) {
        String string2;
        Object object2;
        Object object3;
        int n10;
        block4: {
            Assertions.checkNotNull(object);
            object.resetPeekPosition();
            n10 = 8;
            object3 = new ParsableByteArray(n10);
            object2 = WavHeaderReader$ChunkHeader.peek((ExtractorInput)object, (ParsableByteArray)object3);
            while (true) {
                long l10;
                long l11;
                int n11;
                int n12 = ((WavHeaderReader$ChunkHeader)object2).id;
                int n13 = 1684108385;
                string2 = TAG;
                if (n12 == n13) break block4;
                n13 = 1380533830;
                if (n12 != n13 && n12 != (n11 = 1718449184)) {
                    n11 = 39;
                    StringBuilder stringBuilder = new StringBuilder(n11);
                    String string3 = "Ignoring unknown WAV chunk: ";
                    stringBuilder.append(string3);
                    stringBuilder.append(n12);
                    String string4 = stringBuilder.toString();
                    Log.w(string2, string4);
                }
                long l12 = 8;
                long l13 = ((WavHeaderReader$ChunkHeader)object2).size + l12;
                n12 = ((WavHeaderReader$ChunkHeader)object2).id;
                if (n12 == n13) {
                    l13 = 12;
                }
                if ((n12 = (int)((l11 = l13 - (l10 = Integer.MAX_VALUE)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) > 0) break;
                int n14 = (int)l13;
                object.skipFully(n14);
                object2 = WavHeaderReader$ChunkHeader.peek((ExtractorInput)object, (ParsableByteArray)object3);
            }
            int n15 = ((WavHeaderReader$ChunkHeader)object2).id;
            object2 = new StringBuilder(51);
            ((StringBuilder)object2).append("Chunk is too large (~2GB+) to skip; id: ");
            ((StringBuilder)object2).append(n15);
            object3 = ((StringBuilder)object2).toString();
            object = new ParserException((String)object3);
            throw object;
        }
        object.skipFully(n10);
        long l14 = object.getPosition();
        long l15 = ((WavHeaderReader$ChunkHeader)object2).size + l14;
        long l16 = object.getLength();
        long l17 = -1;
        long l18 = l16 == l17 ? 0 : (l16 < l17 ? -1 : 1);
        if (l18 != false && (l18 = l15 == l16 ? 0 : (l15 < l16 ? -1 : 1)) > 0) {
            l18 = 69;
            StringBuilder stringBuilder = new StringBuilder((int)l18);
            stringBuilder.append("Data exceeds input length: ");
            stringBuilder.append(l15);
            stringBuilder.append(", ");
            stringBuilder.append(l16);
            object = stringBuilder.toString();
            Log.w(string2, (String)object);
            l15 = l16;
        }
        object = l14;
        object3 = l15;
        return Pair.create((Object)object, (Object)object3);
    }
}

