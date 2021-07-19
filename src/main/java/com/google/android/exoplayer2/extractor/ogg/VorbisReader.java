/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.VorbisUtil;
import com.google.android.exoplayer2.extractor.VorbisUtil$CommentHeader;
import com.google.android.exoplayer2.extractor.VorbisUtil$Mode;
import com.google.android.exoplayer2.extractor.VorbisUtil$VorbisIdHeader;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.extractor.ogg.StreamReader$SetupData;
import com.google.android.exoplayer2.extractor.ogg.VorbisReader$VorbisSetup;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Arrays;

public final class VorbisReader
extends StreamReader {
    private VorbisUtil$CommentHeader commentHeader;
    private int previousPacketBlockSize;
    private boolean seenFirstAudioPacket;
    private VorbisUtil$VorbisIdHeader vorbisIdHeader;
    private VorbisReader$VorbisSetup vorbisSetup;

    public static void appendNumberOfSamples(ParsableByteArray parsableByteArray, long l10) {
        byte by2;
        byte by3;
        byte[] byArray;
        int n10;
        int n11 = parsableByteArray.capacity();
        if (n11 < (n10 = parsableByteArray.limit() + 4)) {
            byArray = parsableByteArray.getData();
            n10 = parsableByteArray.limit() + 4;
            byArray = Arrays.copyOf(byArray, n10);
            parsableByteArray.reset(byArray);
        } else {
            n11 = parsableByteArray.limit() + 4;
            parsableByteArray.setLimit(n11);
        }
        byArray = parsableByteArray.getData();
        n10 = parsableByteArray.limit() + -4;
        long l11 = 255L;
        byArray[n10] = by3 = (byte)(l10 & l11);
        n10 = parsableByteArray.limit() + -3;
        byArray[n10] = by3 = (byte)(l10 >>> 8 & l11);
        n10 = parsableByteArray.limit() + -2;
        byArray[n10] = by3 = (byte)(l10 >>> 16 & l11);
        int n12 = parsableByteArray.limit() + -1;
        byArray[n12] = by2 = (byte)(l10 >>> 24 & l11);
    }

    private static int decodeBlockSize(byte by2, VorbisReader$VorbisSetup vorbisReader$VorbisSetup) {
        int n10 = vorbisReader$VorbisSetup.iLogModes;
        int n11 = 1;
        by2 = (byte)VorbisReader.readBits(by2, n10, n11);
        VorbisUtil$Mode[] vorbisUtil$ModeArray = vorbisReader$VorbisSetup.modes;
        Object object = vorbisUtil$ModeArray[by2];
        by2 = (byte)(((VorbisUtil$Mode)object).blockFlag ? 1 : 0);
        if (by2 == 0) {
            object = vorbisReader$VorbisSetup.idHeader;
            by2 = (byte)((VorbisUtil$VorbisIdHeader)object).blockSize0;
        } else {
            object = vorbisReader$VorbisSetup.idHeader;
            by2 = (byte)((VorbisUtil$VorbisIdHeader)object).blockSize1;
        }
        return by2;
    }

    public static int readBits(byte by2, int n10, int n11) {
        by2 = (byte)(by2 >> n11);
        n10 = 8 - n10;
        n10 = 255 >>> n10;
        return by2 & n10;
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        boolean bl2 = true;
        try {
            return VorbisUtil.verifyVorbisHeaderCapturePattern((int)(bl2 ? 1 : 0), parsableByteArray, bl2);
        }
        catch (ParserException parserException) {
            return false;
        }
    }

    public void onSeekEnd(long l10) {
        VorbisUtil$VorbisIdHeader vorbisUtil$VorbisIdHeader;
        super.onSeekEnd(l10);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 0;
        if (l12 != false) {
            l12 = 1;
        } else {
            l12 = 0;
            vorbisUtil$VorbisIdHeader = null;
        }
        this.seenFirstAudioPacket = l12;
        vorbisUtil$VorbisIdHeader = this.vorbisIdHeader;
        if (vorbisUtil$VorbisIdHeader != null) {
            n10 = vorbisUtil$VorbisIdHeader.blockSize0;
        }
        this.previousPacketBlockSize = n10;
    }

    public long preparePayload(ParsableByteArray parsableByteArray) {
        byte[] byArray = parsableByteArray.getData();
        int n10 = 0;
        int n11 = byArray[0];
        int n12 = 1;
        if ((n11 &= n12) == n12) {
            return -1;
        }
        byArray = parsableByteArray.getData();
        n11 = byArray[0];
        VorbisReader$VorbisSetup vorbisReader$VorbisSetup = (VorbisReader$VorbisSetup)Assertions.checkStateNotNull(this.vorbisSetup);
        n11 = VorbisReader.decodeBlockSize((byte)n11, vorbisReader$VorbisSetup);
        boolean bl2 = this.seenFirstAudioPacket;
        if (bl2) {
            n10 = (this.previousPacketBlockSize + n11) / 4;
        }
        long l10 = n10;
        VorbisReader.appendNumberOfSamples(parsableByteArray, l10);
        this.seenFirstAudioPacket = n12;
        this.previousPacketBlockSize = n11;
        return l10;
    }

    public boolean readHeaders(ParsableByteArray object, long l10, StreamReader$SetupData streamReader$SetupData) {
        VorbisReader$VorbisSetup vorbisReader$VorbisSetup = this.vorbisSetup;
        if (vorbisReader$VorbisSetup != null) {
            Assertions.checkNotNull(streamReader$SetupData.format);
            return false;
        }
        this.vorbisSetup = object = this.readSetupHeaders((ParsableByteArray)object);
        boolean bl2 = true;
        if (object == null) {
            return bl2;
        }
        VorbisUtil$VorbisIdHeader vorbisUtil$VorbisIdHeader = ((VorbisReader$VorbisSetup)object).idHeader;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        byte[] byArray = vorbisUtil$VorbisIdHeader.data;
        arrayList.add(byArray);
        object = ((VorbisReader$VorbisSetup)object).setupHeaderData;
        arrayList.add(object);
        object = new Format$Builder();
        object = ((Format$Builder)object).setSampleMimeType("audio/vorbis");
        int n10 = vorbisUtil$VorbisIdHeader.bitrateNominal;
        object = ((Format$Builder)object).setAverageBitrate(n10);
        n10 = vorbisUtil$VorbisIdHeader.bitrateMaximum;
        object = ((Format$Builder)object).setPeakBitrate(n10);
        n10 = vorbisUtil$VorbisIdHeader.channels;
        object = ((Format$Builder)object).setChannelCount(n10);
        int n11 = vorbisUtil$VorbisIdHeader.sampleRate;
        streamReader$SetupData.format = object = ((Format$Builder)object).setSampleRate(n11).setInitializationData(arrayList).build();
        return bl2;
    }

    public VorbisReader$VorbisSetup readSetupHeaders(ParsableByteArray object) {
        VorbisUtil$VorbisIdHeader vorbisUtil$VorbisIdHeader = this.vorbisIdHeader;
        int n10 = 0;
        Object object2 = null;
        if (vorbisUtil$VorbisIdHeader == null) {
            this.vorbisIdHeader = object = VorbisUtil.readVorbisIdentificationHeader((ParsableByteArray)object);
            return null;
        }
        VorbisUtil$CommentHeader vorbisUtil$CommentHeader = this.commentHeader;
        if (vorbisUtil$CommentHeader == null) {
            this.commentHeader = object = VorbisUtil.readVorbisCommentHeader((ParsableByteArray)object);
            return null;
        }
        byte[] byArray = new byte[((ParsableByteArray)object).limit()];
        object2 = ((ParsableByteArray)object).getData();
        int n11 = ((ParsableByteArray)object).limit();
        System.arraycopy(object2, 0, byArray, 0, n11);
        n10 = vorbisUtil$VorbisIdHeader.channels;
        VorbisUtil$Mode[] vorbisUtil$ModeArray = VorbisUtil.readVorbisModes((ParsableByteArray)object, n10);
        int n12 = VorbisUtil.iLog(vorbisUtil$ModeArray.length + -1);
        object2 = object;
        object = new VorbisReader$VorbisSetup(vorbisUtil$VorbisIdHeader, vorbisUtil$CommentHeader, byArray, vorbisUtil$ModeArray, n12);
        return object;
    }

    public void reset(boolean bl2) {
        super.reset(bl2);
        if (bl2) {
            bl2 = false;
            this.vorbisSetup = null;
            this.vorbisIdHeader = null;
            this.commentHeader = null;
        }
        this.previousPacketBlockSize = 0;
        this.seenFirstAudioPacket = false;
    }
}

