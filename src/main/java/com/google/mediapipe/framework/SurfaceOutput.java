/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.framework;

import com.google.mediapipe.framework.Graph;
import com.google.mediapipe.framework.Packet;

public class SurfaceOutput {
    private Graph mediapipeGraph;
    private Packet surfaceHolderPacket;

    public SurfaceOutput(Graph graph, Packet packet) {
        this.mediapipeGraph = graph;
        this.surfaceHolderPacket = packet;
    }

    private native void nativeSetEglSurface(long var1, long var3, long var5);

    private native void nativeSetFlipY(long var1, boolean var3);

    private native void nativeSetSurface(long var1, long var3, Object var5);

    public void setEglSurface(long l10) {
        long l11 = this.mediapipeGraph.getNativeHandle();
        long l12 = this.surfaceHolderPacket.getNativeHandle();
        this.nativeSetEglSurface(l11, l12, l10);
    }

    public void setFlipY(boolean bl2) {
        long l10 = this.surfaceHolderPacket.getNativeHandle();
        this.nativeSetFlipY(l10, bl2);
    }

    public void setSurface(Object object) {
        long l10 = this.mediapipeGraph.getNativeHandle();
        long l11 = this.surfaceHolderPacket.getNativeHandle();
        this.nativeSetSurface(l10, l11, object);
    }
}

