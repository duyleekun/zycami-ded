/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.framework;

import com.google.mediapipe.framework.Graph;
import com.google.mediapipe.framework.GraphGlSyncToken;
import com.google.mediapipe.framework.Packet;
import com.google.mediapipe.framework.TextureFrame;
import com.google.mediapipe.framework.TextureReleaseCallback;
import com.google.protobuf.MessageLite;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class PacketCreator {
    public Graph mediapipeGraph;

    public PacketCreator(Graph graph) {
        this.mediapipeGraph = graph;
    }

    private static void checkAudioDataSize(int n10, int n11, int n12) {
        if ((n11 = n11 * n12 * 2) == n10) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Please check the audio data size, has to be num_channels * num_samples * 2 = ");
        stringBuilder.append(n11);
        stringBuilder.append(" but was ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    private native long nativeCreateAudioPacket(long var1, byte[] var3, int var4, int var5, int var6);

    private native long nativeCreateAudioPacketDirect(long var1, ByteBuffer var3, int var4, int var5);

    private native long nativeCreateBool(long var1, boolean var3);

    private native long nativeCreateCalculatorOptions(long var1, byte[] var3);

    private native long nativeCreateCameraIntrinsics(long var1, float var3, float var4, float var5, float var6, float var7, float var8);

    private native long nativeCreateFloat32(long var1, float var3);

    private native long nativeCreateFloat32Array(long var1, float[] var3);

    private native long nativeCreateFloat64(long var1, double var3);

    private native long nativeCreateFloatImageFrame(long var1, FloatBuffer var3, int var4, int var5);

    private native long nativeCreateGpuBuffer(long var1, int var3, int var4, int var5, TextureReleaseCallback var6);

    private native long nativeCreateGrayscaleImage(long var1, ByteBuffer var3, int var4, int var5);

    private native long nativeCreateInt16(long var1, short var3);

    private native long nativeCreateInt32(long var1, int var3);

    private native long nativeCreateInt32Array(long var1, int[] var3);

    private native long nativeCreateInt64(long var1, long var3);

    private native long nativeCreateMatrix(long var1, int var3, int var4, float[] var5);

    private native long nativeCreateReferencePacket(long var1, long var3);

    private native long nativeCreateRgbImage(long var1, ByteBuffer var3, int var4, int var5);

    private native long nativeCreateRgbImageFromRgba(long var1, ByteBuffer var3, int var4, int var5);

    private native long nativeCreateRgbaImageFrame(long var1, ByteBuffer var3, int var4, int var5);

    private native long nativeCreateString(long var1, String var3);

    private native long nativeCreateStringFromByteArray(long var1, byte[] var3);

    private native long nativeCreateTimeSeriesHeader(long var1, int var3, double var4);

    private native long nativeCreateVideoHeader(long var1, int var3, int var4);

    private void releaseWithSyncToken(long l10, TextureReleaseCallback textureReleaseCallback) {
        GraphGlSyncToken graphGlSyncToken = new GraphGlSyncToken(l10);
        textureReleaseCallback.release(graphGlSyncToken);
    }

    public Packet createAudioPacket(ByteBuffer object, int n10, int n11) {
        PacketCreator.checkAudioDataSize(((Buffer)object).remaining(), n10, n11);
        boolean n12 = ((ByteBuffer)object).isDirect();
        if (n12) {
            long l10 = this.mediapipeGraph.getNativeHandle();
            ByteBuffer byteBuffer = ((ByteBuffer)object).slice();
            int n13 = n10;
            return Packet.create(this.nativeCreateAudioPacketDirect(l10, byteBuffer, n10, n11));
        }
        boolean bl2 = ((ByteBuffer)object).hasArray();
        if (bl2) {
            long l11 = this.mediapipeGraph.getNativeHandle();
            byte[] byArray = ((ByteBuffer)object).array();
            int n14 = ((ByteBuffer)object).arrayOffset();
            int n15 = ((Buffer)object).position();
            int n16 = n14 + n15;
            return Packet.create(this.nativeCreateAudioPacket(l11, byArray, n16, n10, n11));
        }
        object = new IllegalArgumentException("Data must be either a direct byte buffer or be backed by a byte array.");
        throw object;
    }

    public Packet createAudioPacket(byte[] byArray, int n10, int n11) {
        PacketCreator.checkAudioDataSize(byArray.length, n10, n11);
        long l10 = this.mediapipeGraph.getNativeHandle();
        return Packet.create(this.nativeCreateAudioPacket(l10, byArray, 0, n10, n11));
    }

    public Packet createBool(boolean bl2) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        return Packet.create(this.nativeCreateBool(l10, bl2));
    }

    public Packet createByteArray(byte[] byArray) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        return Packet.create(this.nativeCreateStringFromByteArray(l10, byArray));
    }

    public Packet createCalculatorOptions(MessageLite object) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        object = object.toByteArray();
        return Packet.create(this.nativeCreateCalculatorOptions(l10, (byte[])object));
    }

    public Packet createCameraIntrinsics(float f10, float f11, float f12, float f13, float f14, float f15) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        return Packet.create(this.nativeCreateCameraIntrinsics(l10, f10, f11, f12, f13, f14, f15));
    }

    public Packet createFloat32(float f10) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        return Packet.create(this.nativeCreateFloat32(l10, f10));
    }

    public Packet createFloat32Array(float[] fArray) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        return Packet.create(this.nativeCreateFloat32Array(l10, fArray));
    }

    public Packet createFloat32Vector(float[] object) {
        object = new UnsupportedOperationException;
        object("Not implemented yet");
        throw object;
    }

    public Packet createFloat64(double d10) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        return Packet.create(this.nativeCreateFloat64(l10, d10));
    }

    public Packet createFloat64Vector(double[] object) {
        object = new UnsupportedOperationException;
        object("Not implemented yet");
        throw object;
    }

    public Packet createFloatImageFrame(FloatBuffer object, int n10, int n11) {
        int n12;
        int n13 = ((Buffer)object).capacity();
        if (n13 == (n12 = n10 * n11 * 4)) {
            long l10 = this.mediapipeGraph.getNativeHandle();
            return Packet.create(this.nativeCreateFloatImageFrame(l10, (FloatBuffer)object, n10, n11));
        }
        object = new RuntimeException("buffer doesn't have the correct size.");
        throw object;
    }

    public Packet createGpuBuffer(int n10, int n11, int n12) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        return Packet.create(this.nativeCreateGpuBuffer(l10, n10, n11, n12, null));
    }

    public Packet createGpuBuffer(int n10, int n11, int n12, TextureReleaseCallback textureReleaseCallback) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        return Packet.create(this.nativeCreateGpuBuffer(l10, n10, n11, n12, textureReleaseCallback));
    }

    public Packet createGpuBuffer(TextureFrame textureFrame) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        int n10 = textureFrame.getTextureName();
        int n11 = textureFrame.getWidth();
        int n12 = textureFrame.getHeight();
        return Packet.create(this.nativeCreateGpuBuffer(l10, n10, n11, n12, textureFrame));
    }

    public Packet createGrayscaleImage(ByteBuffer object, int n10, int n11) {
        int n12 = n10 * n11;
        int n13 = ((Buffer)object).capacity();
        if (n12 == n13) {
            long l10 = this.mediapipeGraph.getNativeHandle();
            return Packet.create(this.nativeCreateGrayscaleImage(l10, (ByteBuffer)object, n10, n11));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The size of the buffer should be: ");
        stringBuilder.append(n12);
        stringBuilder.append(" but is ");
        int n14 = ((Buffer)object).capacity();
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        RuntimeException runtimeException = new RuntimeException((String)object);
        throw runtimeException;
    }

    public Packet createInt16(short s10) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        return Packet.create(this.nativeCreateInt16(l10, s10));
    }

    public Packet createInt16Vector(short[] object) {
        object = new UnsupportedOperationException;
        object("Not implemented yet");
        throw object;
    }

    public Packet createInt32(int n10) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        return Packet.create(this.nativeCreateInt32(l10, n10));
    }

    public Packet createInt32Array(int[] nArray) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        return Packet.create(this.nativeCreateInt32Array(l10, nArray));
    }

    public Packet createInt32Vector(int[] object) {
        object = new UnsupportedOperationException;
        object("Not implemented yet");
        throw object;
    }

    public Packet createInt64(long l10) {
        long l11 = this.mediapipeGraph.getNativeHandle();
        return Packet.create(this.nativeCreateInt64(l11, l10));
    }

    public Packet createInt64Vector(long[] object) {
        object = new UnsupportedOperationException;
        object("Not implemented yet");
        throw object;
    }

    public Packet createMatrix(int n10, int n11, float[] fArray) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        return Packet.create(this.nativeCreateMatrix(l10, n10, n11, fArray));
    }

    public Packet createReferencePacket(Packet packet) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        long l11 = packet.getNativeHandle();
        return Packet.create(this.nativeCreateReferencePacket(l10, l11));
    }

    public Packet createRgbImage(ByteBuffer object, int n10, int n11) {
        int n12 = (n10 * 3 + 3) / 4 * 4 * n11;
        int n13 = ((Buffer)object).capacity();
        if (n12 == n13) {
            long l10 = this.mediapipeGraph.getNativeHandle();
            return Packet.create(this.nativeCreateRgbImage(l10, (ByteBuffer)object, n10, n11));
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("The size of the buffer should be: ");
        charSequence.append(n12);
        charSequence = charSequence.toString();
        object = new RuntimeException((String)charSequence);
        throw object;
    }

    public Packet createRgbImageFromRgba(ByteBuffer object, int n10, int n11) {
        int n12 = n10 * n11 * 4;
        int n13 = ((Buffer)object).capacity();
        if (n12 == n13) {
            long l10 = this.mediapipeGraph.getNativeHandle();
            return Packet.create(this.nativeCreateRgbImageFromRgba(l10, (ByteBuffer)object, n10, n11));
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("The size of the buffer should be: ");
        charSequence.append(n12);
        charSequence = charSequence.toString();
        object = new RuntimeException((String)charSequence);
        throw object;
    }

    public Packet createRgbaImageFrame(ByteBuffer object, int n10, int n11) {
        int n12;
        int n13 = ((Buffer)object).capacity();
        if (n13 == (n12 = n10 * n11 * 4)) {
            long l10 = this.mediapipeGraph.getNativeHandle();
            return Packet.create(this.nativeCreateRgbaImageFrame(l10, (ByteBuffer)object, n10, n11));
        }
        object = new RuntimeException("buffer doesn't have the correct size.");
        throw object;
    }

    public Packet createSerializedProto(MessageLite object) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        object = object.toByteArray();
        return Packet.create(this.nativeCreateStringFromByteArray(l10, (byte[])object));
    }

    public Packet createString(String string2) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        return Packet.create(this.nativeCreateString(l10, string2));
    }

    public Packet createTimeSeriesHeader(int n10, double d10) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        return Packet.create(this.nativeCreateTimeSeriesHeader(l10, n10, d10));
    }

    public Packet createVideoHeader(int n10, int n11) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        return Packet.create(this.nativeCreateVideoHeader(l10, n10, n11));
    }
}

