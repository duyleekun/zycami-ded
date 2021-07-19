/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata$SeekTable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.VorbisComment;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FlacStreamMetadata {
    public static final int NOT_IN_LOOKUP_TABLE = 255;
    private static final String SEPARATOR = "=";
    private static final String TAG = "FlacStreamMetadata";
    public final int bitsPerSample;
    public final int bitsPerSampleLookupKey;
    public final int channels;
    public final int maxBlockSizeSamples;
    public final int maxFrameSize;
    private final Metadata metadata;
    public final int minBlockSizeSamples;
    public final int minFrameSize;
    public final int sampleRate;
    public final int sampleRateLookupKey;
    public final FlacStreamMetadata$SeekTable seekTable;
    public final long totalSamples;

    private FlacStreamMetadata(int n10, int n11, int n12, int n13, int n14, int n15, int n16, long l10, FlacStreamMetadata$SeekTable flacStreamMetadata$SeekTable, Metadata metadata) {
        this.minBlockSizeSamples = n10;
        this.maxBlockSizeSamples = n11;
        this.minFrameSize = n12;
        this.maxFrameSize = n13;
        this.sampleRate = n14;
        this.sampleRateLookupKey = n10 = FlacStreamMetadata.getSampleRateLookupKey(n14);
        this.channels = n15;
        this.bitsPerSample = n16;
        this.bitsPerSampleLookupKey = n10 = FlacStreamMetadata.getBitsPerSampleLookupKey(n16);
        this.totalSamples = l10;
        this.seekTable = flacStreamMetadata$SeekTable;
        this.metadata = metadata;
    }

    public FlacStreamMetadata(int n10, int n11, int n12, int n13, int n14, int n15, int n16, long l10, ArrayList arrayList, ArrayList arrayList2) {
        Metadata metadata = FlacStreamMetadata.buildMetadata(arrayList, arrayList2);
        this(n10, n11, n12, n13, n14, n15, n16, l10, null, metadata);
    }

    public FlacStreamMetadata(byte[] byArray, int n10) {
        long l10;
        ParsableBitArray parsableBitArray = new ParsableBitArray(byArray);
        parsableBitArray.setPosition(n10 *= 8);
        int n11 = 16;
        this.minBlockSizeSamples = n10 = parsableBitArray.readBits(n11);
        this.maxBlockSizeSamples = n11 = parsableBitArray.readBits(n11);
        n11 = 24;
        this.minFrameSize = n10 = parsableBitArray.readBits(n11);
        this.maxFrameSize = n11 = parsableBitArray.readBits(n11);
        this.sampleRate = n11 = parsableBitArray.readBits(20);
        this.sampleRateLookupKey = n11 = FlacStreamMetadata.getSampleRateLookupKey(n11);
        this.channels = n11 = parsableBitArray.readBits(3) + 1;
        this.bitsPerSample = n11 = parsableBitArray.readBits(5) + 1;
        this.bitsPerSampleLookupKey = n11 = FlacStreamMetadata.getBitsPerSampleLookupKey(n11);
        this.totalSamples = l10 = parsableBitArray.readBitsToLong(36);
        this.seekTable = null;
        this.metadata = null;
    }

    private static Metadata buildMetadata(List list, List list2) {
        int n10;
        boolean bl2 = list.isEmpty();
        Metadata metadata = null;
        if (bl2 && (bl2 = list2.isEmpty())) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            int n11;
            Object object = (String)list.get(i10);
            Object object2 = Util.splitAtFirst((String)object, SEPARATOR);
            int n12 = ((String[])object2).length;
            if (n12 != (n11 = 2)) {
                object2 = "Failed to parse Vorbis comment: ";
                n12 = ((String)(object = String.valueOf(object))).length();
                object = n12 != 0 ? object2.concat((String)object) : new String((String)object2);
                object2 = TAG;
                Log.w((String)object2, (String)object);
                continue;
            }
            String string2 = object2[0];
            n11 = 1;
            object2 = object2[n11];
            object = new VorbisComment(string2, (String)object2);
            arrayList.add(object);
        }
        arrayList.addAll(list2);
        boolean bl3 = arrayList.isEmpty();
        if (!bl3) {
            metadata = new Metadata(arrayList);
        }
        return metadata;
    }

    private static int getBitsPerSampleLookupKey(int n10) {
        int n11 = 8;
        if (n10 != n11) {
            n11 = 12;
            if (n10 != n11) {
                n11 = 16;
                if (n10 != n11) {
                    n11 = 20;
                    if (n10 != n11) {
                        n11 = 24;
                        if (n10 != n11) {
                            return -1;
                        }
                        return 6;
                    }
                    return 5;
                }
                return 4;
            }
            return 2;
        }
        return 1;
    }

    private static int getSampleRateLookupKey(int n10) {
        switch (n10) {
            default: {
                return -1;
            }
            case 192000: {
                return 3;
            }
            case 176400: {
                return 2;
            }
            case 96000: {
                return 11;
            }
            case 88200: {
                return 1;
            }
            case 48000: {
                return 10;
            }
            case 44100: {
                return 9;
            }
            case 32000: {
                return 8;
            }
            case 24000: {
                return 7;
            }
            case 22050: {
                return 6;
            }
            case 16000: {
                return 5;
            }
            case 8000: 
        }
        return 4;
    }

    public FlacStreamMetadata copyWithPictureFrames(List object) {
        object = FlacStreamMetadata.buildMetadata(Collections.emptyList(), (List)object);
        Metadata metadata = this.getMetadataCopyWithAppendedEntriesFrom((Metadata)object);
        int n10 = this.minBlockSizeSamples;
        int n11 = this.maxBlockSizeSamples;
        int n12 = this.minFrameSize;
        int n13 = this.maxFrameSize;
        int n14 = this.sampleRate;
        int n15 = this.channels;
        int n16 = this.bitsPerSample;
        long l10 = this.totalSamples;
        FlacStreamMetadata$SeekTable flacStreamMetadata$SeekTable = this.seekTable;
        object = new FlacStreamMetadata(n10, n11, n12, n13, n14, n15, n16, l10, flacStreamMetadata$SeekTable, metadata);
        return object;
    }

    public FlacStreamMetadata copyWithSeekTable(FlacStreamMetadata$SeekTable flacStreamMetadata$SeekTable) {
        int n10 = this.minBlockSizeSamples;
        int n11 = this.maxBlockSizeSamples;
        int n12 = this.minFrameSize;
        int n13 = this.maxFrameSize;
        int n14 = this.sampleRate;
        int n15 = this.channels;
        int n16 = this.bitsPerSample;
        long l10 = this.totalSamples;
        Metadata metadata = this.metadata;
        FlacStreamMetadata flacStreamMetadata = new FlacStreamMetadata(n10, n11, n12, n13, n14, n15, n16, l10, flacStreamMetadata$SeekTable, metadata);
        return flacStreamMetadata;
    }

    public FlacStreamMetadata copyWithVorbisComments(List object) {
        Object object2 = Collections.emptyList();
        object = FlacStreamMetadata.buildMetadata((List)object, object2);
        Metadata metadata = this.getMetadataCopyWithAppendedEntriesFrom((Metadata)object);
        int n10 = this.minBlockSizeSamples;
        int n11 = this.maxBlockSizeSamples;
        int n12 = this.minFrameSize;
        int n13 = this.maxFrameSize;
        int n14 = this.sampleRate;
        int n15 = this.channels;
        int n16 = this.bitsPerSample;
        long l10 = this.totalSamples;
        FlacStreamMetadata$SeekTable flacStreamMetadata$SeekTable = this.seekTable;
        object2 = object;
        object = new FlacStreamMetadata(n10, n11, n12, n13, n14, n15, n16, l10, flacStreamMetadata$SeekTable, metadata);
        return object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public long getApproxBytesPerFrame() {
        long l10;
        long l11;
        int n10 = this.maxFrameSize;
        if (n10 > 0) {
            l11 = n10;
            int n11 = this.minFrameSize;
            l10 = n11;
            l11 = (l11 + l10) / (long)2;
            l10 = 1L;
            return l11 += l10;
        } else {
            n10 = this.minBlockSizeSamples;
            int n12 = this.maxBlockSizeSamples;
            l11 = n10 == n12 && n10 > 0 ? (long)n10 : 4096L;
            l10 = this.channels;
            l11 *= l10;
            int n13 = this.bitsPerSample;
            l10 = n13;
            l11 = l11 * l10 / (long)8;
            l10 = 64;
            return l11 += l10;
        }
    }

    public int getDecodedBitrate() {
        int n10 = this.bitsPerSample;
        int n11 = this.sampleRate;
        n10 *= n11;
        n11 = this.channels;
        return n10 * n11;
    }

    public long getDurationUs() {
        long l10 = this.totalSamples;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            l10 = -9223372036854775807L;
        } else {
            l10 *= 1000000L;
            object = this.sampleRate;
            l11 = object;
            l10 /= l11;
        }
        return l10;
    }

    public Format getFormat(byte[] object, Metadata metadata) {
        int n10;
        object[4] = n10 = -128;
        int n11 = this.maxFrameSize;
        if (n11 <= 0) {
            n11 = -1;
        }
        metadata = this.getMetadataCopyWithAppendedEntriesFrom(metadata);
        Format$Builder format$Builder = new Format$Builder();
        Format$Builder format$Builder2 = format$Builder.setSampleMimeType("audio/flac").setMaxInputSize(n11);
        n10 = this.channels;
        format$Builder2 = format$Builder2.setChannelCount(n10);
        n10 = this.sampleRate;
        format$Builder2 = format$Builder2.setSampleRate(n10);
        object = Collections.singletonList(object);
        return format$Builder2.setInitializationData((List)object).setMetadata(metadata).build();
    }

    public int getMaxDecodedFrameSize() {
        int n10 = this.maxBlockSizeSamples;
        int n11 = this.channels;
        n10 *= n11;
        n11 = this.bitsPerSample / 8;
        return n10 * n11;
    }

    public Metadata getMetadataCopyWithAppendedEntriesFrom(Metadata metadata) {
        Metadata metadata2 = this.metadata;
        if (metadata2 != null) {
            metadata = metadata2.copyWithAppendedEntriesFrom(metadata);
        }
        return metadata;
    }

    public long getSampleNumber(long l10) {
        long l11 = this.sampleRate;
        long l12 = l10 * l11 / 1000000L;
        long l13 = this.totalSamples - 1L;
        return Util.constrainValue(l12, 0L, l13);
    }
}

