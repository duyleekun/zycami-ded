/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public class OpusUtil {
    private static final int DEFAULT_SEEK_PRE_ROLL_SAMPLES = 3840;
    private static final int FULL_CODEC_INITIALIZATION_DATA_BUFFER_COUNT = 3;
    public static final int SAMPLE_RATE = 48000;

    private OpusUtil() {
    }

    public static List buildInitializationData(byte[] byArray) {
        long l10 = OpusUtil.sampleCountToNanoseconds(OpusUtil.getPreSkipSamples(byArray));
        long l11 = OpusUtil.sampleCountToNanoseconds(3840L);
        ArrayList<byte[]> arrayList = new ArrayList<byte[]>(3);
        arrayList.add(byArray);
        byArray = OpusUtil.buildNativeOrderByteArray(l10);
        arrayList.add(byArray);
        byArray = OpusUtil.buildNativeOrderByteArray(l11);
        arrayList.add(byArray);
        return arrayList;
    }

    private static byte[] buildNativeOrderByteArray(long l10) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        return byteBuffer.order(byteOrder).putLong(l10).array();
    }

    public static int getChannelCount(byte[] byArray) {
        return byArray[9] & 0xFF;
    }

    public static int getPreSkipSamples(List object) {
        int n10;
        int n11 = object.size();
        if (n11 == (n10 = 3)) {
            object = ByteBuffer.wrap((byte[])object.get(1));
            ByteOrder byteOrder = ByteOrder.nativeOrder();
            return (int)OpusUtil.nanosecondsToSampleCount(((ByteBuffer)object).order(byteOrder).getLong());
        }
        return OpusUtil.getPreSkipSamples((byte[])object.get(0));
    }

    private static int getPreSkipSamples(byte[] byArray) {
        int n10 = (byArray[11] & 0xFF) << 8;
        return byArray[10] & 0xFF | n10;
    }

    public static int getSeekPreRollSamples(List object) {
        int n10;
        int n11 = object.size();
        if (n11 == (n10 = 3)) {
            object = ByteBuffer.wrap((byte[])object.get(2));
            ByteOrder byteOrder = ByteOrder.nativeOrder();
            return (int)OpusUtil.nanosecondsToSampleCount(((ByteBuffer)object).order(byteOrder).getLong());
        }
        return 3840;
    }

    private static long nanosecondsToSampleCount(long l10) {
        return l10 * 48000L / 1000000000L;
    }

    private static long sampleCountToNanoseconds(long l10) {
        return l10 * 1000000000L / 48000L;
    }
}

