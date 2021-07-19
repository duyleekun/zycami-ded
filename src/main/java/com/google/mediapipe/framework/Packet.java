/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.framework;

public class Packet {
    private long nativePacketHandle;

    private Packet(long l10) {
        this.nativePacketHandle = l10;
    }

    public static Packet create(long l10) {
        Packet packet = new Packet(l10);
        return packet;
    }

    private native long nativeCopyPacket(long var1);

    private native long nativeGetTimestamp(long var1);

    private native void nativeReleasePacket(long var1);

    public Packet copy() {
        long l10 = this.nativePacketHandle;
        l10 = this.nativeCopyPacket(l10);
        Packet packet = new Packet(l10);
        return packet;
    }

    public long getNativeHandle() {
        return this.nativePacketHandle;
    }

    public long getTimestamp() {
        long l10 = this.nativePacketHandle;
        return this.nativeGetTimestamp(l10);
    }

    public void release() {
        long l10 = this.nativePacketHandle;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.nativeReleasePacket(l10);
            this.nativePacketHandle = l11;
        }
    }
}

