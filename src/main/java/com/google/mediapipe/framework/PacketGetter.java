/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.framework;

import com.google.common.base.Preconditions;
import com.google.common.flogger.FluentLogger;
import com.google.mediapipe.framework.GraphTextureFrame;
import com.google.mediapipe.framework.Packet;
import com.google.mediapipe.framework.PacketGetter$PacketPair;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class PacketGetter {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    private PacketGetter() {
    }

    public static byte[] getAudioByteData(Packet packet) {
        return PacketGetter.nativeGetAudioData(packet.getNativeHandle());
    }

    public static int getAudioDataNumChannels(Packet packet) {
        return PacketGetter.nativeGetMatrixRows(packet.getNativeHandle());
    }

    public static int getAudioDataNumSamples(Packet packet) {
        return PacketGetter.nativeGetMatrixCols(packet.getNativeHandle());
    }

    public static boolean getBool(Packet packet) {
        return PacketGetter.nativeGetBool(packet.getNativeHandle());
    }

    public static byte[] getBytes(Packet packet) {
        return PacketGetter.nativeGetBytes(packet.getNativeHandle());
    }

    public static float getFloat32(Packet packet) {
        return PacketGetter.nativeGetFloat32(packet.getNativeHandle());
    }

    public static float[] getFloat32Vector(Packet packet) {
        return PacketGetter.nativeGetFloat32Vector(packet.getNativeHandle());
    }

    public static double getFloat64(Packet packet) {
        return PacketGetter.nativeGetFloat64(packet.getNativeHandle());
    }

    public static double[] getFloat64Vector(Packet packet) {
        return PacketGetter.nativeGetFloat64Vector(packet.getNativeHandle());
    }

    public static int getGpuBufferName(Packet packet) {
        return PacketGetter.nativeGetGpuBufferName(packet.getNativeHandle());
    }

    public static boolean getImageData(Packet packet, ByteBuffer byteBuffer) {
        return PacketGetter.nativeGetImageData(packet.getNativeHandle(), byteBuffer);
    }

    public static int getImageHeight(Packet packet) {
        return PacketGetter.nativeGetImageHeight(packet.getNativeHandle());
    }

    public static int getImageWidth(Packet packet) {
        return PacketGetter.nativeGetImageWidth(packet.getNativeHandle());
    }

    public static short getInt16(Packet packet) {
        return PacketGetter.nativeGetInt16(packet.getNativeHandle());
    }

    public static short[] getInt16Vector(Packet packet) {
        return PacketGetter.nativeGetInt16Vector(packet.getNativeHandle());
    }

    public static int getInt32(Packet packet) {
        return PacketGetter.nativeGetInt32(packet.getNativeHandle());
    }

    public static int[] getInt32Vector(Packet packet) {
        return PacketGetter.nativeGetInt32Vector(packet.getNativeHandle());
    }

    public static long getInt64(Packet packet) {
        return PacketGetter.nativeGetInt64(packet.getNativeHandle());
    }

    public static long[] getInt64Vector(Packet packet) {
        return PacketGetter.nativeGetInt64Vector(packet.getNativeHandle());
    }

    public static int getMatrixCols(Packet packet) {
        return PacketGetter.nativeGetMatrixCols(packet.getNativeHandle());
    }

    public static float[] getMatrixData(Packet packet) {
        return PacketGetter.nativeGetMatrixData(packet.getNativeHandle());
    }

    public static int getMatrixRows(Packet packet) {
        return PacketGetter.nativeGetMatrixRows(packet.getNativeHandle());
    }

    public static Packet getPacketFromReference(Packet packet) {
        return Packet.create(PacketGetter.nativeGetPacketFromReference(packet.getNativeHandle()));
    }

    public static PacketGetter$PacketPair getPairOfPackets(Packet object) {
        object = PacketGetter.nativeGetPairPackets(((Packet)object).getNativeHandle());
        Packet packet = Packet.create((long)object[0]);
        object = Packet.create((long)object[1]);
        PacketGetter$PacketPair packetGetter$PacketPair = new PacketGetter$PacketPair(packet, (Packet)object);
        return packetGetter$PacketPair;
    }

    public static byte[] getProtoBytes(Packet packet) {
        return PacketGetter.nativeGetProtoBytes(packet.getNativeHandle());
    }

    public static List getProtoVector(Packet object, Parser object2) {
        int n10;
        long l10 = ((Packet)object).getNativeHandle();
        object = PacketGetter.nativeGetProtoVector(l10);
        ArrayList<Object> arrayList = "Vector of protocol buffer objects should not be null!";
        Preconditions.checkNotNull(object, arrayList);
        try {
            arrayList = new ArrayList<Object>();
            n10 = ((Object)object).length;
        }
        catch (InvalidProtocolBufferException invalidProtocolBufferException) {
            object2 = new IllegalArgumentException(invalidProtocolBufferException);
            throw object2;
        }
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object3 = object[i10];
            object3 = object2.parseFrom((byte[])object3);
            arrayList.add(object3);
            continue;
        }
        return arrayList;
    }

    public static boolean getRgbaFromRgb(Packet packet, ByteBuffer byteBuffer) {
        return PacketGetter.nativeGetRgbaFromRgb(packet.getNativeHandle(), byteBuffer);
    }

    public static String getString(Packet packet) {
        return PacketGetter.nativeGetString(packet.getNativeHandle());
    }

    public static GraphTextureFrame getTextureFrame(Packet packet) {
        long l10 = PacketGetter.nativeGetGpuBuffer(packet.getNativeHandle());
        long l11 = packet.getTimestamp();
        GraphTextureFrame graphTextureFrame = new GraphTextureFrame(l10, l11);
        return graphTextureFrame;
    }

    public static int getTimeSeriesHeaderNumChannels(Packet packet) {
        return PacketGetter.nativeGetTimeSeriesHeaderNumChannels(packet.getNativeHandle());
    }

    public static double getTimeSeriesHeaderSampleRate(Packet packet) {
        return PacketGetter.nativeGetTimeSeriesHeaderSampleRate(packet.getNativeHandle());
    }

    public static List getVectorOfPackets(Packet object) {
        long l10 = ((Packet)object).getNativeHandle();
        object = PacketGetter.nativeGetVectorPackets(l10);
        int n10 = ((Object)object).length;
        ArrayList<Packet> arrayList = new ArrayList<Packet>(n10);
        for (Object object2 : object) {
            Packet packet = Packet.create((long)object2);
            arrayList.add(packet);
        }
        return arrayList;
    }

    public static int getVideoHeaderHeight(Packet packet) {
        return PacketGetter.nativeGetVideoHeaderHeight(packet.getNativeHandle());
    }

    public static int getVideoHeaderWidth(Packet packet) {
        return PacketGetter.nativeGetVideoHeaderWidth(packet.getNativeHandle());
    }

    private static native byte[] nativeGetAudioData(long var0);

    private static native boolean nativeGetBool(long var0);

    private static native byte[] nativeGetBytes(long var0);

    private static native float nativeGetFloat32(long var0);

    private static native float[] nativeGetFloat32Vector(long var0);

    private static native double nativeGetFloat64(long var0);

    private static native double[] nativeGetFloat64Vector(long var0);

    private static native long nativeGetGpuBuffer(long var0);

    private static native int nativeGetGpuBufferName(long var0);

    private static native boolean nativeGetImageData(long var0, ByteBuffer var2);

    private static native int nativeGetImageHeight(long var0);

    private static native int nativeGetImageWidth(long var0);

    private static native short nativeGetInt16(long var0);

    private static native short[] nativeGetInt16Vector(long var0);

    private static native int nativeGetInt32(long var0);

    private static native int[] nativeGetInt32Vector(long var0);

    private static native long nativeGetInt64(long var0);

    private static native long[] nativeGetInt64Vector(long var0);

    private static native int nativeGetMatrixCols(long var0);

    private static native float[] nativeGetMatrixData(long var0);

    private static native int nativeGetMatrixRows(long var0);

    private static native long nativeGetPacketFromReference(long var0);

    private static native long[] nativeGetPairPackets(long var0);

    private static native byte[] nativeGetProtoBytes(long var0);

    private static native byte[][] nativeGetProtoVector(long var0);

    private static native boolean nativeGetRgbaFromRgb(long var0, ByteBuffer var2);

    private static native String nativeGetString(long var0);

    private static native int nativeGetTimeSeriesHeaderNumChannels(long var0);

    private static native double nativeGetTimeSeriesHeaderSampleRate(long var0);

    private static native long[] nativeGetVectorPackets(long var0);

    private static native int nativeGetVideoHeaderHeight(long var0);

    private static native int nativeGetVideoHeaderWidth(long var0);
}

