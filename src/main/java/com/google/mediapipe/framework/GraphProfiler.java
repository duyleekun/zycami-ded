/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.google.mediapipe.proto.CalculatorProfileProto$CalculatorProfile
 */
package com.google.mediapipe.framework;

import com.google.common.base.Preconditions;
import com.google.mediapipe.framework.Graph;
import com.google.mediapipe.proto.CalculatorProfileProto;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.Serializable;
import java.util.List;

public class GraphProfiler {
    private final Graph mediapipeGraph;
    private final long nativeProfilerHandle;

    public GraphProfiler(long l10, Graph graph) {
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        l12 = l12 != false ? (long)1 : (long)0;
        Preconditions.checkState((boolean)l12, "Invalid profiler, tearDown() might have been called already.");
        this.nativeProfilerHandle = l10;
        this.mediapipeGraph = graph;
    }

    private void checkContext() {
        long l10;
        Graph graph = this.mediapipeGraph;
        long l11 = graph.getNativeHandle();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            object = 1;
        } else {
            object = 0;
            graph = null;
        }
        Preconditions.checkState((boolean)object, "Invalid context, tearDown() might have been called already.");
    }

    private native byte[][] nativeGetCalculatorProfiles(long var1);

    private native void nativePause(long var1);

    private native void nativeReset(long var1);

    private native void nativeResume(long var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List getCalculatorProfiles() {
        Graph graph = this.mediapipeGraph;
        synchronized (graph) {
            this.checkContext();
            long l10 = this.nativeProfilerHandle;
            byte[][] byArray = this.nativeGetCalculatorProfiles(l10);
            Serializable serializable = new Serializable();
            int n10 = byArray.length;
            int n11 = 0;
            while (n11 < n10) {
                Object object = byArray[n11];
                try {
                    object = CalculatorProfileProto.CalculatorProfile.parseFrom((byte[])object);
                    serializable.add(object);
                    ++n11;
                }
                catch (InvalidProtocolBufferException invalidProtocolBufferException) {
                    serializable = new Serializable(invalidProtocolBufferException);
                    throw serializable;
                }
            }
            return serializable;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void pause() {
        Graph graph = this.mediapipeGraph;
        synchronized (graph) {
            this.checkContext();
            long l10 = this.nativeProfilerHandle;
            this.nativePause(l10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void reset() {
        Graph graph = this.mediapipeGraph;
        synchronized (graph) {
            this.checkContext();
            long l10 = this.nativeProfilerHandle;
            this.nativeReset(l10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void resume() {
        Graph graph = this.mediapipeGraph;
        synchronized (graph) {
            this.checkContext();
            long l10 = this.nativeProfilerHandle;
            this.nativeResume(l10);
            return;
        }
    }
}

