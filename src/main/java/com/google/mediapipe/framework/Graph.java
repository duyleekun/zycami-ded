/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.google.mediapipe.proto.GraphTemplateProto$CalculatorGraphTemplate
 */
package com.google.mediapipe.framework;

import com.google.common.base.Preconditions;
import com.google.common.flogger.AbstractLogger;
import com.google.common.flogger.FluentLogger;
import com.google.common.flogger.FluentLogger$Api;
import com.google.mediapipe.framework.Graph$PacketBufferItem;
import com.google.mediapipe.framework.GraphProfiler;
import com.google.mediapipe.framework.GraphService;
import com.google.mediapipe.framework.MediaPipeException;
import com.google.mediapipe.framework.Packet;
import com.google.mediapipe.framework.PacketCallback;
import com.google.mediapipe.framework.SurfaceOutput;
import com.google.mediapipe.proto.CalculatorProto$CalculatorGraphConfig;
import com.google.mediapipe.proto.CalculatorProto$CalculatorGraphConfig$Node;
import com.google.mediapipe.proto.GraphTemplateProto;
import com.google.protobuf.AbstractMessageLite;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Graph {
    private static final int MAX_BUFFER_SIZE = 20;
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();
    private boolean graphRunning;
    private long nativeGraphHandle;
    private Map packetBuffers;
    private final List packetCallbacks;
    private Map sidePackets;
    private boolean startRunningGraphCalled;
    private boolean stepMode;
    private Map streamHeaders;
    private final Object terminationLock;

    public Graph() {
        long l10;
        Object object = new ArrayList();
        this.packetCallbacks = object;
        this.sidePackets = object;
        super();
        this.streamHeaders = object;
        this.stepMode = false;
        this.startRunningGraphCalled = false;
        this.graphRunning = false;
        super();
        this.packetBuffers = object;
        this.terminationLock = object = new Object();
        this.nativeGraphHandle = l10 = this.nativeCreateGraph();
    }

    private boolean addPacketToBuffer(String object, Packet entry, long l10) {
        int n10;
        Object object2 = this.packetBuffers;
        int n11 = object2.containsKey(object);
        if (n11 == 0) {
            object2 = this.packetBuffers;
            ArrayList arrayList = new ArrayList();
            object2.put(object, arrayList);
        }
        if ((n11 = (object = (List)(object2 = this.packetBuffers).get(object)).size()) > (n10 = 20)) {
            boolean bl2;
            object = this.streamHeaders.entrySet().iterator();
            while (bl2 = object.hasNext()) {
                entry = object.next();
                Object object3 = entry.getValue();
                if (object3 != null) continue;
                object3 = (FluentLogger$Api)logger.atSevere();
                entry = entry.getKey();
                String string2 = "Stream: %s might be missing.";
                object3.log(string2, entry);
            }
            object = new RuntimeException("Graph is not started because of missing streams");
            throw object;
        }
        Long l11 = l10;
        object2 = new Graph$PacketBufferItem((Packet)((Object)entry), l11, null);
        object.add((Object)object2);
        return true;
    }

    private boolean hasAllStreamHeaders() {
        boolean bl2;
        Iterator iterator2 = this.streamHeaders.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object v10 = iterator2.next().getValue();
            if (v10 != null) continue;
            return false;
        }
        return true;
    }

    private void moveBufferedPacketsToInputStream() {
        Object object = this.packetBuffers;
        boolean bl2 = object.isEmpty();
        if (!bl2) {
            boolean bl3;
            object = this.packetBuffers.entrySet().iterator();
            while (bl3 = object.hasNext()) {
                boolean bl4;
                Map.Entry entry = (Map.Entry)object.next();
                Object object2 = ((ArrayList)entry.getValue()).iterator();
                while (bl4 = object2.hasNext()) {
                    long l10;
                    Object object3 = (Graph$PacketBufferItem)object2.next();
                    try {
                        l10 = this.nativeGraphHandle;
                    }
                    catch (MediaPipeException mediaPipeException) {
                        object2 = (FluentLogger$Api)logger.atSevere();
                        entry = entry.getKey();
                        object3 = mediaPipeException.getMessage();
                        object2.log("AddPacket for stream: %s failed: %s.", (Object)entry, object3);
                        throw mediaPipeException;
                    }
                    Object object4 = entry.getKey();
                    Object object5 = object4;
                    object5 = (String)object4;
                    object4 = ((Graph$PacketBufferItem)object3).packet;
                    long l11 = ((Packet)object4).getNativeHandle();
                    object4 = ((Graph$PacketBufferItem)object3).timestamp;
                    long l12 = (Long)object4;
                    object4 = this;
                    this.nativeMovePacketToInputStream(l10, (String)object5, l11, l12);
                    object3 = ((Graph$PacketBufferItem)object3).packet;
                    ((Packet)object3).release();
                }
            }
            object = this.packetBuffers;
            object.clear();
        }
    }

    private native void nativeAddPacketCallback(long var1, String var3, PacketCallback var4);

    private native void nativeAddPacketToInputStream(long var1, String var3, long var4, long var6);

    private native long nativeAddSurfaceOutput(long var1, String var3);

    private native void nativeCancelGraph(long var1);

    private native void nativeCloseAllInputStreams(long var1);

    private native void nativeCloseAllPacketSources(long var1);

    private native void nativeCloseInputStream(long var1, String var3);

    private native long nativeCreateGraph();

    private native byte[] nativeGetCalculatorGraphConfig(long var1);

    private native long nativeGetProfiler(long var1);

    private native void nativeLoadBinaryGraph(long var1, String var3);

    private native void nativeLoadBinaryGraphBytes(long var1, byte[] var3);

    private native void nativeLoadBinaryGraphTemplate(long var1, byte[] var3);

    private native void nativeMovePacketToInputStream(long var1, String var3, long var4, long var6);

    private native void nativeReleaseGraph(long var1);

    private native void nativeRunGraphUntilClose(long var1, String[] var3, long[] var4);

    private native void nativeSetGraphInputStreamBlockingMode(long var1, boolean var3);

    private native void nativeSetGraphOptions(long var1, byte[] var3);

    private native void nativeSetGraphType(long var1, String var3);

    private native void nativeSetParentGlContext(long var1, long var3);

    private native void nativeStartRunningGraph(long var1, String[] var3, long[] var4, String[] var5, long[] var6);

    private native void nativeUpdatePacketReference(long var1, long var3);

    private native void nativeWaitUntilGraphDone(long var1);

    private native void nativeWaitUntilGraphIdle(long var1);

    private static void splitStreamNamePacketMap(Map iterator2, String[] stringArray, long[] lArray) {
        int n10;
        int n11 = iterator2.size();
        if (n11 == (n10 = stringArray.length) && (n11 = iterator2.size()) == (n10 = lArray.length)) {
            n11 = 0;
            iterator2 = iterator2.entrySet().iterator();
            while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                long l10;
                String string2;
                Object object = iterator2.next();
                stringArray[n11] = string2 = (String)object.getKey();
                object = (Packet)object.getValue();
                lArray[n11] = l10 = ((Packet)object).getNativeHandle();
                ++n11;
            }
            return;
        }
        iterator2 = new Iterator("Input array length doesn't match the map size!");
        throw iterator2;
    }

    public void addConsumablePacketToInputStream(String string2, Packet packet, long l10) {
        synchronized (this) {
            Object object;
            long l11;
            block12: {
                block11: {
                    long l12 = this.nativeGraphHandle;
                    long l13 = 0L;
                    l11 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
                    if (l11 == false) break block11;
                    l11 = 1;
                    break block12;
                }
                l11 = 0;
                object = null;
            }
            String string3 = "Invalid context, tearDown() might have been called.";
            Preconditions.checkState((boolean)l11, string3);
            l11 = (long)this.graphRunning;
            if (l11 == false) {
                object = packet.copy();
                this.addPacketToBuffer(string2, (Packet)object, l10);
                packet.release();
            } else {
                long l14 = this.nativeGraphHandle;
                long l15 = packet.getNativeHandle();
                object = this;
                this.nativeMovePacketToInputStream(l14, string2, l15, l10);
                packet.release();
            }
            return;
        }
    }

    public void addPacketCallback(String string2, PacketCallback packetCallback) {
        synchronized (this) {
            List list;
            boolean bl2;
            long l10;
            block10: {
                block9: {
                    long l11;
                    block11: {
                        block8: {
                            l10 = this.nativeGraphHandle;
                            long l12 = 0L;
                            l11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
                            bl2 = true;
                            if (l11 == false) break block8;
                            l11 = (long)bl2;
                            break block11;
                        }
                        l11 = 0;
                        list = null;
                    }
                    String string3 = "Invalid context, tearDown() might have been called already.";
                    Preconditions.checkState((boolean)l11, string3);
                    Preconditions.checkNotNull(string2);
                    Preconditions.checkNotNull(packetCallback);
                    l11 = (long)this.graphRunning;
                    if (l11 != false) break block9;
                    l11 = (long)this.startRunningGraphCalled;
                    if (l11 == false) break block10;
                }
                bl2 = false;
            }
            Preconditions.checkState(bl2);
            list = this.packetCallbacks;
            list.add(packetCallback);
            l10 = this.nativeGraphHandle;
            this.nativeAddPacketCallback(l10, string2, packetCallback);
            return;
        }
    }

    public void addPacketToInputStream(String string2, Packet packet, long l10) {
        synchronized (this) {
            long l11 = this.nativeGraphHandle;
            long l12 = 0L;
            long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            l13 = l13 != false ? (long)1 : (long)0;
            String string3 = "Invalid context, tearDown() might have been called.";
            Preconditions.checkState((boolean)l13, string3);
            l13 = (long)this.graphRunning;
            if (l13 == false) {
                packet = packet.copy();
                this.addPacketToBuffer(string2, packet, l10);
            } else {
                long l14 = this.nativeGraphHandle;
                long l15 = packet.getNativeHandle();
                this.nativeAddPacketToInputStream(l14, string2, l15, l10);
            }
            return;
        }
    }

    public void addStreamNameExpectingHeader(String string2) {
        synchronized (this) {
            Map map;
            boolean bl2;
            block7: {
                block6: {
                    bl2 = this.graphRunning;
                    if (bl2) break block6;
                    bl2 = this.startRunningGraphCalled;
                    if (bl2) break block6;
                    bl2 = true;
                    break block7;
                }
                bl2 = false;
                map = null;
            }
            Preconditions.checkState(bl2);
            map = this.streamHeaders;
            map.put(string2, null);
            return;
        }
    }

    public SurfaceOutput addSurfaceOutput(String object) {
        synchronized (this) {
            SurfaceOutput surfaceOutput;
            boolean bl2;
            block12: {
                block11: {
                    long l10;
                    block13: {
                        block10: {
                            long l11 = this.nativeGraphHandle;
                            long l12 = 0L;
                            l10 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                            bl2 = true;
                            if (l10 == false) break block10;
                            l10 = (long)bl2;
                            break block13;
                        }
                        l10 = 0;
                        surfaceOutput = null;
                    }
                    String string2 = "Invalid context, tearDown() might have been called.";
                    Preconditions.checkState((boolean)l10, string2);
                    Preconditions.checkNotNull(object);
                    l10 = (long)this.graphRunning;
                    if (l10 != false) break block11;
                    l10 = (long)this.startRunningGraphCalled;
                    if (l10 == false) break block12;
                }
                bl2 = false;
            }
            Preconditions.checkState(bl2);
            long l13 = this.nativeGraphHandle;
            l13 = this.nativeAddSurfaceOutput(l13, (String)object);
            object = Packet.create(l13);
            surfaceOutput = new SurfaceOutput(this, (Packet)object);
            return surfaceOutput;
        }
    }

    public void cancelGraph() {
        synchronized (this) {
            long l10;
            long l11;
            block6: {
                block5: {
                    l11 = this.nativeGraphHandle;
                    long l12 = 0L;
                    l10 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                    if (l10 == false) break block5;
                    l10 = 1;
                    break block6;
                }
                l10 = 0;
                Object var6_4 = null;
            }
            String string2 = "Invalid context, tearDown() might have been called already.";
            Preconditions.checkState((boolean)l10, string2);
            l11 = this.nativeGraphHandle;
            this.nativeCancelGraph(l11);
            return;
        }
    }

    public void closeAllInputStreams() {
        synchronized (this) {
            long l10;
            long l11;
            block6: {
                block5: {
                    l11 = this.nativeGraphHandle;
                    long l12 = 0L;
                    l10 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                    if (l10 == false) break block5;
                    l10 = 1;
                    break block6;
                }
                l10 = 0;
                Object var6_4 = null;
            }
            String string2 = "Invalid context, tearDown() might have been called.";
            Preconditions.checkState((boolean)l10, string2);
            l11 = this.nativeGraphHandle;
            this.nativeCloseAllInputStreams(l11);
            return;
        }
    }

    public void closeAllPacketSources() {
        synchronized (this) {
            long l10;
            long l11;
            block6: {
                block5: {
                    l11 = this.nativeGraphHandle;
                    long l12 = 0L;
                    l10 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                    if (l10 == false) break block5;
                    l10 = 1;
                    break block6;
                }
                l10 = 0;
                Object var6_4 = null;
            }
            String string2 = "Invalid context, tearDown() might have been called.";
            Preconditions.checkState((boolean)l10, string2);
            l11 = this.nativeGraphHandle;
            this.nativeCloseAllPacketSources(l11);
            return;
        }
    }

    public void closeInputStream(String string2) {
        synchronized (this) {
            long l10 = this.nativeGraphHandle;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            l12 = l12 != false ? (long)1 : (long)0;
            String string3 = "Invalid context, tearDown() might have been called.";
            Preconditions.checkState((boolean)l12, string3);
            l10 = this.nativeGraphHandle;
            this.nativeCloseInputStream(l10, string2);
            return;
        }
    }

    public void createGlRunner(String string2, long l10) {
        synchronized (this) {
            String string3;
            long l11;
            block8: {
                block7: {
                    long l12 = this.nativeGraphHandle;
                    long l13 = 0L;
                    l11 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
                    if (l11 == false) break block7;
                    l11 = 1;
                    break block8;
                }
                l11 = 0;
                string3 = null;
            }
            String string4 = "Invalid context, tearDown() might have been called already.";
            Preconditions.checkState((boolean)l11, string4);
            string3 = "gpu_shared";
            boolean bl2 = string2.equals(string3);
            Preconditions.checkArgument(bl2);
            this.setParentGlContext(l10);
            return;
        }
    }

    public CalculatorProto$CalculatorGraphConfig getCalculatorGraphConfig() {
        synchronized (this) {
            block11: {
                Object object;
                long l10;
                long l11;
                block12: {
                    block10: {
                        l11 = this.nativeGraphHandle;
                        long l12 = 0L;
                        l10 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                        if (l10 == false) break block10;
                        l10 = 1;
                        break block12;
                    }
                    l10 = 0;
                    object = null;
                }
                String string2 = "Invalid context, tearDown() might have been called already.";
                Preconditions.checkState((boolean)l10, string2);
                l11 = this.nativeGraphHandle;
                object = this.nativeGetCalculatorGraphConfig(l11);
                if (object == null) break block11;
                object = CalculatorProto$CalculatorGraphConfig.parseFrom(object);
                return object;
            }
            return null;
            finally {
            }
        }
    }

    public long getNativeHandle() {
        synchronized (this) {
            long l10 = this.nativeGraphHandle;
            return l10;
        }
    }

    public GraphProfiler getProfiler() {
        GraphProfiler graphProfiler;
        long l10 = this.nativeGraphHandle;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            object = 1;
        } else {
            object = 0;
            graphProfiler = null;
        }
        Preconditions.checkState((boolean)object, "Invalid context, tearDown() might have been called already.");
        long l13 = this.nativeGraphHandle;
        l13 = this.nativeGetProfiler(l13);
        graphProfiler = new GraphProfiler(l13, this);
        return graphProfiler;
    }

    public boolean getStepMode() {
        synchronized (this) {
            boolean bl2 = this.stepMode;
            return bl2;
        }
    }

    public void loadBinaryGraph(CalculatorProto$CalculatorGraphConfig object) {
        synchronized (this) {
            object = ((AbstractMessageLite)object).toByteArray();
            this.loadBinaryGraph((byte[])object);
            return;
        }
    }

    public void loadBinaryGraph(String string2) {
        synchronized (this) {
            long l10 = this.nativeGraphHandle;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            l12 = l12 != false ? (long)1 : (long)0;
            String string3 = "Invalid context, tearDown() might have been called already.";
            Preconditions.checkState((boolean)l12, string3);
            l10 = this.nativeGraphHandle;
            this.nativeLoadBinaryGraph(l10, string2);
            return;
        }
    }

    public void loadBinaryGraph(byte[] byArray) {
        synchronized (this) {
            long l10 = this.nativeGraphHandle;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            l12 = l12 != false ? (long)1 : (long)0;
            String string2 = "Invalid context, tearDown() might have been called already.";
            Preconditions.checkState((boolean)l12, string2);
            l10 = this.nativeGraphHandle;
            this.nativeLoadBinaryGraphBytes(l10, byArray);
            return;
        }
    }

    public void loadBinaryGraphTemplate(GraphTemplateProto.CalculatorGraphTemplate object) {
        synchronized (this) {
            long l10 = this.nativeGraphHandle;
            object = object.toByteArray();
            this.nativeLoadBinaryGraphTemplate(l10, (byte[])object);
            return;
        }
    }

    public void runGraphUntilClose() {
        synchronized (this) {
            String[] stringArray;
            long l10;
            long l11;
            block14: {
                block13: {
                    long l12 = this.nativeGraphHandle;
                    l11 = 0L;
                    l10 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
                    if (l10 == false) break block13;
                    l10 = 1;
                    break block14;
                }
                l10 = 0;
                stringArray = null;
            }
            Object object = "Invalid context, tearDown() might have been called.";
            Preconditions.checkState((boolean)l10, object);
            stringArray = this.sidePackets;
            Preconditions.checkNotNull(stringArray);
            stringArray = this.sidePackets;
            l10 = stringArray.size();
            stringArray = new String[l10];
            object = this.sidePackets;
            int n10 = object.size();
            object = new long[n10];
            Map map = this.sidePackets;
            Graph.splitStreamNamePacketMap(map, stringArray, (long[])object);
            l11 = this.nativeGraphHandle;
            this.nativeRunGraphUntilClose(l11, stringArray, (long[])object);
            return;
        }
    }

    public void setGraphInputStreamBlockingMode(boolean bl2) {
        synchronized (this) {
            boolean bl3;
            long l10;
            block6: {
                l10 = this.nativeGraphHandle;
                long l11 = 0L;
                long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                bl3 = true;
                l12 = l12 != false ? (long)bl3 : (long)0;
                String string2 = "Invalid context, tearDown() might have been called.";
                Preconditions.checkState((boolean)l12, string2);
                l12 = (long)this.graphRunning;
                if (l12 == false) break block6;
                bl3 = false;
            }
            Preconditions.checkState(bl3);
            l10 = this.nativeGraphHandle;
            this.nativeSetGraphInputStreamBlockingMode(l10, bl2);
            return;
        }
    }

    public void setGraphOptions(CalculatorProto$CalculatorGraphConfig$Node object) {
        synchronized (this) {
            long l10 = this.nativeGraphHandle;
            object = ((AbstractMessageLite)object).toByteArray();
            this.nativeSetGraphOptions(l10, (byte[])object);
            return;
        }
    }

    public void setGraphType(String string2) {
        synchronized (this) {
            long l10 = this.nativeGraphHandle;
            this.nativeSetGraphType(l10, string2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setInputSidePackets(Map iterator2) {
        synchronized (this) {
            Map map;
            Object object;
            long l10 = this.nativeGraphHandle;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            boolean bl2 = true;
            String string2 = null;
            if (l12 != false) {
                l12 = (long)bl2;
            } else {
                l12 = 0;
                object = null;
            }
            String string3 = "Invalid context, tearDown() might have been called.";
            Preconditions.checkState((boolean)l12, string3);
            l12 = (long)this.graphRunning;
            if (l12 != false || (l12 = (long)this.startRunningGraphCalled) != false) {
                bl2 = false;
                map = null;
            }
            Preconditions.checkState(bl2);
            iterator2 = iterator2.entrySet();
            iterator2 = iterator2.iterator();
            while ((l12 = (long)iterator2.hasNext()) != false) {
                object = iterator2.next();
                object = (Map.Entry)object;
                map = this.sidePackets;
                string2 = (String)object.getKey();
                string2 = string2;
                object = object.getValue();
                object = (Packet)object;
                object = ((Packet)object).copy();
                map.put(string2, object);
            }
            return;
        }
    }

    public void setParentGlContext(long l10) {
        synchronized (this) {
            boolean bl2;
            long l11;
            block6: {
                l11 = this.nativeGraphHandle;
                long l12 = 0L;
                long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                bl2 = true;
                l13 = l13 != false ? (long)bl2 : (long)0;
                String string2 = "Invalid context, tearDown() might have been called already.";
                Preconditions.checkState((boolean)l13, string2);
                l13 = (long)this.graphRunning;
                if (l13 == false) break block6;
                bl2 = false;
            }
            Preconditions.checkState(bl2);
            l11 = this.nativeGraphHandle;
            this.nativeSetParentGlContext(l11, l10);
            return;
        }
    }

    public void setServiceObject(GraphService graphService, Object object) {
        synchronized (this) {
            long l10 = this.nativeGraphHandle;
            graphService.installServiceObject(l10, object);
            return;
        }
    }

    public void setStepMode(boolean bl2) {
        synchronized (this) {
            this.stepMode = bl2;
            return;
        }
    }

    public void setStreamHeader(String string2, Packet packet) {
        synchronized (this) {
            this.setStreamHeader(string2, packet, false);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setStreamHeader(String object, Packet object2, boolean bl2) {
        synchronized (this) {
            Object object3;
            Object object4 = this.streamHeaders;
            object4 = object4.get(object);
            object4 = (Packet)object4;
            if (object4 != null) {
                boolean bl3;
                if (!bl3) {
                    return;
                }
                bl3 = this.graphRunning;
                if (bl3) {
                    object3 = "Can't override an existing stream header, after graph started running.";
                    object = new IllegalArgumentException((String)object3);
                    throw object;
                }
                ((Packet)object4).release();
            }
            Map map = this.streamHeaders;
            object3 = ((Packet)object3).copy();
            map.put(object, object3);
            boolean bl4 = this.graphRunning;
            if (!bl4 && (bl4 = this.startRunningGraphCalled) && (bl4 = this.hasAllStreamHeaders())) {
                this.startRunningGraph();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void startRunningGraph() {
        synchronized (this) {
            Object object;
            long l10 = this.nativeGraphHandle;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            int n10 = 1;
            if (l12 != false) {
                l12 = n10;
            } else {
                l12 = 0;
                object = null;
            }
            Object object2 = "Invalid context, tearDown() might have been called.";
            Preconditions.checkState((boolean)l12, object2);
            this.startRunningGraphCalled = n10;
            l12 = (long)this.hasAllStreamHeaders();
            if (l12 == false) {
                object = logger;
                object = ((AbstractLogger)object).atInfo();
                object = (FluentLogger$Api)object;
                String string2 = "MediaPipe graph won't start until all stream headers are available.";
                object.log(string2);
                return;
            }
            object = this.sidePackets;
            l12 = object.size();
            String[] stringArray = new String[l12];
            object = this.sidePackets;
            l12 = object.size();
            long[] lArray = new long[l12];
            object = this.sidePackets;
            Graph.splitStreamNamePacketMap((Map)object, stringArray, lArray);
            object = this.streamHeaders;
            l12 = object.size();
            String[] stringArray2 = new String[l12];
            object = this.streamHeaders;
            l12 = object.size();
            long[] lArray2 = new long[l12];
            object = this.streamHeaders;
            Graph.splitStreamNamePacketMap((Map)object, stringArray2, lArray2);
            long l13 = this.nativeGraphHandle;
            object2 = this;
            this.nativeStartRunningGraph(l13, stringArray, lArray, stringArray2, lArray2);
            this.graphRunning = n10;
            this.moveBufferedPacketsToInputStream();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void tearDown() {
        synchronized (this) {
            Object object;
            boolean bl2;
            Object object2;
            long l10 = this.nativeGraphHandle;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 != false) {
                l12 = 1;
            } else {
                l12 = 0;
                object2 = null;
            }
            Iterator iterator2 = "Invalid context, tearDown() might have been called already.";
            Preconditions.checkState((boolean)l12, iterator2);
            object2 = this.sidePackets;
            object2 = object2.entrySet();
            object2 = object2.iterator();
            while (bl2 = object2.hasNext()) {
                iterator2 = object2.next();
                iterator2 = (Map.Entry)((Object)iterator2);
                iterator2 = iterator2.getValue();
                iterator2 = (Packet)((Object)iterator2);
                ((Packet)((Object)iterator2)).release();
            }
            object2 = this.sidePackets;
            object2.clear();
            object2 = this.streamHeaders;
            object2 = object2.entrySet();
            object2 = object2.iterator();
            while (bl2 = object2.hasNext()) {
                iterator2 = object2.next();
                object = (iterator2 = (Map.Entry)((Object)iterator2)).getValue();
                if (object == null) continue;
                iterator2 = iterator2.getValue();
                iterator2 = (Packet)((Object)iterator2);
                ((Packet)((Object)iterator2)).release();
            }
            object2 = this.streamHeaders;
            object2.clear();
            object2 = this.packetBuffers;
            object2 = object2.entrySet();
            object2 = object2.iterator();
            while (bl2 = object2.hasNext()) {
                boolean bl3;
                iterator2 = object2.next();
                iterator2 = (Map.Entry)((Object)iterator2);
                iterator2 = iterator2.getValue();
                iterator2 = (ArrayList)((Object)iterator2);
                iterator2 = ((ArrayList)((Object)iterator2)).iterator();
                while (bl3 = iterator2.hasNext()) {
                    object = iterator2.next();
                    object = (Graph$PacketBufferItem)object;
                    object = ((Graph$PacketBufferItem)object).packet;
                    ((Packet)object).release();
                }
            }
            object2 = this.packetBuffers;
            object2.clear();
            object2 = this.terminationLock;
            synchronized (object2) {
                long l13 = this.nativeGraphHandle;
                bl2 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1);
                if (bl2) {
                    this.nativeReleaseGraph(l13);
                    this.nativeGraphHandle = l11;
                }
            }
            object2 = this.packetCallbacks;
            object2.clear();
            return;
        }
    }

    public void updatePacketReference(Packet packet, Packet packet2) {
        synchronized (this) {
            long l10 = this.nativeGraphHandle;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            l12 = l12 != false ? (long)1 : (long)0;
            String string2 = "Invalid context, tearDown() might have been called already.";
            Preconditions.checkState((boolean)l12, string2);
            l10 = packet.getNativeHandle();
            long l13 = packet2.getNativeHandle();
            this.nativeUpdatePacketReference(l10, l13);
            return;
        }
    }

    public void waitUntilGraphDone() {
        synchronized (this) {
            long l10;
            long l11;
            block6: {
                block5: {
                    l11 = this.nativeGraphHandle;
                    long l12 = 0L;
                    l10 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                    if (l10 == false) break block5;
                    l10 = 1;
                    break block6;
                }
                l10 = 0;
                Object var6_4 = null;
            }
            String string2 = "Invalid context, tearDown() might have been called.";
            Preconditions.checkState((boolean)l10, string2);
            l11 = this.nativeGraphHandle;
            this.nativeWaitUntilGraphDone(l11);
            return;
        }
    }

    public void waitUntilGraphIdle() {
        synchronized (this) {
            long l10;
            long l11;
            block6: {
                block5: {
                    l11 = this.nativeGraphHandle;
                    long l12 = 0L;
                    l10 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                    if (l10 == false) break block5;
                    l10 = 1;
                    break block6;
                }
                l10 = 0;
                Object var6_4 = null;
            }
            String string2 = "Invalid context, tearDown() might have been called.";
            Preconditions.checkState((boolean)l10, string2);
            l11 = this.nativeGraphHandle;
            this.nativeWaitUntilGraphIdle(l11);
            return;
        }
    }
}

