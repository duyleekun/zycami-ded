/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.extractor.mp4.TrackFragment;
import com.google.android.exoplayer2.extractor.mp4.TrackSampleTable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public final class FragmentedMp4Extractor$TrackBundle {
    private static final int SINGLE_SUBSAMPLE_ENCRYPTION_DATA_LENGTH = 8;
    public int currentSampleInTrackRun;
    public int currentSampleIndex;
    public int currentTrackRunIndex;
    private boolean currentlyInFragment;
    private final ParsableByteArray defaultInitializationVector;
    public DefaultSampleValues defaultSampleValues;
    private final ParsableByteArray encryptionSignalByte;
    public int firstSampleToOutputIndex;
    public final TrackFragment fragment;
    public TrackSampleTable moovSampleTable;
    public final TrackOutput output;
    public final ParsableByteArray scratch;

    public FragmentedMp4Extractor$TrackBundle(TrackOutput object, TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues) {
        this.output = object;
        this.moovSampleTable = trackSampleTable;
        this.defaultSampleValues = defaultSampleValues;
        this.fragment = object = new TrackFragment();
        this.scratch = object = new ParsableByteArray();
        this.encryptionSignalByte = object = new ParsableByteArray(1);
        this.defaultInitializationVector = object = new ParsableByteArray();
        this.reset(trackSampleTable, defaultSampleValues);
    }

    public static /* synthetic */ boolean access$000(FragmentedMp4Extractor$TrackBundle fragmentedMp4Extractor$TrackBundle) {
        return fragmentedMp4Extractor$TrackBundle.currentlyInFragment;
    }

    public static /* synthetic */ boolean access$002(FragmentedMp4Extractor$TrackBundle fragmentedMp4Extractor$TrackBundle, boolean bl2) {
        fragmentedMp4Extractor$TrackBundle.currentlyInFragment = bl2;
        return bl2;
    }

    public int getCurrentSampleFlags() {
        int n10;
        int n11 = this.currentlyInFragment;
        if (n11 == 0) {
            int[] nArray = this.moovSampleTable.flags;
            n10 = this.currentSampleIndex;
            n11 = nArray[n10];
        } else {
            boolean[] blArray = this.fragment.sampleIsSyncFrameTable;
            n10 = this.currentSampleIndex;
            n11 = blArray[n10];
            if (n11 != 0) {
                n11 = 1;
            } else {
                n11 = 0;
                blArray = null;
            }
        }
        TrackEncryptionBox trackEncryptionBox = this.getEncryptionBoxIfEncrypted();
        if (trackEncryptionBox != null) {
            n10 = 0x40000000;
            n11 |= n10;
        }
        return n11;
    }

    public long getCurrentSampleOffset() {
        long l10;
        boolean bl2 = this.currentlyInFragment;
        if (!bl2) {
            long[] lArray = this.moovSampleTable.offsets;
            int n10 = this.currentSampleIndex;
            l10 = lArray[n10];
        } else {
            long[] lArray = this.fragment.trunDataPosition;
            int n11 = this.currentTrackRunIndex;
            l10 = lArray[n11];
        }
        return l10;
    }

    public long getCurrentSamplePresentationTimeUs() {
        long l10;
        boolean bl2 = this.currentlyInFragment;
        if (!bl2) {
            long[] lArray = this.moovSampleTable.timestampsUs;
            int n10 = this.currentSampleIndex;
            l10 = lArray[n10];
        } else {
            TrackFragment trackFragment = this.fragment;
            int n11 = this.currentSampleIndex;
            l10 = trackFragment.getSamplePresentationTimeUs(n11);
        }
        return l10;
    }

    public int getCurrentSampleSize() {
        int n10 = this.currentlyInFragment;
        if (n10 == 0) {
            int[] nArray = this.moovSampleTable.sizes;
            int n11 = this.currentSampleIndex;
            n10 = nArray[n11];
        } else {
            int[] nArray = this.fragment.sampleSizeTable;
            int n12 = this.currentSampleIndex;
            n10 = nArray[n12];
        }
        return n10;
    }

    public TrackEncryptionBox getEncryptionBoxIfEncrypted() {
        int n10 = this.currentlyInFragment;
        TrackEncryptionBox trackEncryptionBox = null;
        if (n10 == 0) {
            return null;
        }
        DefaultSampleValues defaultSampleValues = (DefaultSampleValues)Util.castNonNull(this.fragment.header);
        n10 = defaultSampleValues.sampleDescriptionIndex;
        TrackEncryptionBox trackEncryptionBox2 = this.fragment.trackEncryptionBox;
        if (trackEncryptionBox2 == null) {
            trackEncryptionBox2 = this.moovSampleTable.track.getSampleDescriptionEncryptionBox(n10);
        }
        if (trackEncryptionBox2 != null && (n10 = (int)(trackEncryptionBox2.isEncrypted ? 1 : 0)) != 0) {
            trackEncryptionBox = trackEncryptionBox2;
        }
        return trackEncryptionBox;
    }

    public boolean next() {
        int n10 = this.currentSampleIndex;
        int n11 = 1;
        this.currentSampleIndex = n10 += n11;
        n10 = (int)(this.currentlyInFragment ? 1 : 0);
        if (n10 == 0) {
            return false;
        }
        this.currentSampleInTrackRun = n10 = this.currentSampleInTrackRun + n11;
        int[] nArray = this.fragment.trunLength;
        int n12 = this.currentTrackRunIndex;
        int n13 = nArray[n12];
        if (n10 == n13) {
            this.currentTrackRunIndex = n12 += n11;
            this.currentSampleInTrackRun = 0;
            return false;
        }
        return n11 != 0;
    }

    public int outputSampleEncryptionData(int n10, int n11) {
        ParsableByteArray parsableByteArray;
        int n12;
        int n13;
        int n14;
        Object object = this.getEncryptionBoxIfEncrypted();
        byte by2 = 0;
        if (object == null) {
            return 0;
        }
        int n15 = ((TrackEncryptionBox)object).perSampleIvSize;
        if (n15 != 0) {
            object = this.fragment.sampleEncryptionData;
        } else {
            object = (byte[])Util.castNonNull(((TrackEncryptionBox)object).defaultInitializationVector);
            ParsableByteArray parsableByteArray2 = this.defaultInitializationVector;
            n14 = ((Object)object).length;
            parsableByteArray2.reset((byte[])object, n14);
            parsableByteArray2 = this.defaultInitializationVector;
            n15 = n13 = ((Object)object).length;
            object = parsableByteArray2;
        }
        Object object2 = this.fragment;
        int n16 = this.currentSampleIndex;
        n14 = (int)(((TrackFragment)object2).sampleHasSubsampleEncryptionTable(n16) ? 1 : 0);
        n16 = 1;
        int n17 = n14 == 0 && n11 == 0 ? 0 : n16;
        Object object3 = this.encryptionSignalByte.getData();
        if (n17 != 0) {
            n12 = 128;
        } else {
            n12 = 0;
            parsableByteArray = null;
        }
        object3[0] = n12 = (int)((byte)(n12 | n15));
        this.encryptionSignalByte.setPosition(0);
        object3 = this.output;
        parsableByteArray = this.encryptionSignalByte;
        object3.sampleData(parsableByteArray, n16, n16);
        object3 = this.output;
        object3.sampleData((ParsableByteArray)object, n15, n16);
        if (n17 == 0) {
            return n15 + n16;
        }
        n13 = 6;
        n17 = 3;
        int n18 = 2;
        n12 = 8;
        if (n14 == 0) {
            this.scratch.reset(n12);
            object2 = this.scratch.getData();
            object2[0] = false;
            object2[n16] = n16;
            by2 = (byte)(n11 >> 8 & 0xFF);
            object2[n18] = by2;
            n11 = (byte)(n11 & 0xFF);
            object2[n17] = n11;
            by2 = (byte)(n10 >> 24 & 0xFF);
            object2[4] = by2;
            by2 = (byte)(n10 >> 16 & 0xFF);
            object2[5] = by2;
            n11 = (byte)(n10 >> 8 & 0xFF);
            object2[n13] = n11;
            n10 = (byte)(n10 & 0xFF);
            object2[7] = n10;
            TrackOutput trackOutput = this.output;
            ParsableByteArray parsableByteArray3 = this.scratch;
            trackOutput.sampleData(parsableByteArray3, n12, n16);
            return n15 + n16 + n12;
        }
        ParsableByteArray parsableByteArray4 = this.fragment.sampleEncryptionData;
        n14 = parsableByteArray4.readUnsignedShort();
        int n19 = -2;
        parsableByteArray4.skipBytes(n19);
        n14 = n14 * n13 + n18;
        if (n11 != 0) {
            this.scratch.reset(n14);
            object = this.scratch.getData();
            parsableByteArray4.readBytes((byte[])object, 0, n14);
            n10 = (object[n18] & 0xFF) << n12;
            by2 = (byte)(object[n17] & 0xFF);
            n10 = (n10 | by2) + n11;
            n11 = (byte)(n10 >> 8 & 0xFF);
            object[n18] = n11;
            n10 = (byte)(n10 & 0xFF);
            object[n17] = n10;
            parsableByteArray4 = this.scratch;
        }
        this.output.sampleData(parsableByteArray4, n14, n16);
        return n15 + n16 + n14;
    }

    public void reset(TrackSampleTable object, DefaultSampleValues object2) {
        this.moovSampleTable = object;
        this.defaultSampleValues = object2;
        object2 = this.output;
        object = object.track.format;
        object2.format((Format)object);
        this.resetFragmentInfo();
    }

    public void resetFragmentInfo() {
        this.fragment.reset();
        this.currentSampleIndex = 0;
        this.currentTrackRunIndex = 0;
        this.currentSampleInTrackRun = 0;
        this.firstSampleToOutputIndex = 0;
        this.currentlyInFragment = false;
    }

    public void seek(long l10) {
        int n10 = this.currentSampleIndex;
        while (true) {
            long l11;
            long l12;
            Object object;
            Object object2 = this.fragment;
            int n11 = ((TrackFragment)object2).sampleCount;
            if (n10 >= n11 || (object = (l12 = (l11 = ((TrackFragment)object2).getSamplePresentationTimeUs(n10)) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1)) >= 0) break;
            object2 = this.fragment.sampleIsSyncFrameTable;
            object = object2[n10];
            if (object != false) {
                this.firstSampleToOutputIndex = n10;
            }
            ++n10;
        }
    }

    public void skipSampleEncryptionData() {
        int n10;
        Object object = this.getEncryptionBoxIfEncrypted();
        if (object == null) {
            return;
        }
        ParsableByteArray parsableByteArray = this.fragment.sampleEncryptionData;
        int n11 = ((TrackEncryptionBox)object).perSampleIvSize;
        if (n11 != 0) {
            parsableByteArray.skipBytes(n11);
        }
        if ((n11 = (int)(((TrackFragment)(object = this.fragment)).sampleHasSubsampleEncryptionTable(n10 = this.currentSampleIndex) ? 1 : 0)) != 0) {
            n11 = parsableByteArray.readUnsignedShort() * 6;
            parsableByteArray.skipBytes(n11);
        }
    }

    public void updateDrmInitData(DrmInitData parcelable) {
        Object object = this.moovSampleTable.track;
        DefaultSampleValues defaultSampleValues = (DefaultSampleValues)Util.castNonNull(this.fragment.header);
        int n10 = defaultSampleValues.sampleDescriptionIndex;
        object = (object = ((Track)object).getSampleDescriptionEncryptionBox(n10)) != null ? ((TrackEncryptionBox)object).schemeType : null;
        parcelable = parcelable.copyWithSchemeType((String)object);
        parcelable = this.moovSampleTable.track.format.buildUpon().setDrmInitData((DrmInitData)parcelable).build();
        this.output.format((Format)parcelable);
    }
}

