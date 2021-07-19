/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.graphics.Bitmap
 *  android.media.AudioFormat
 *  android.media.AudioFormat$Builder
 *  android.util.Log
 */
package com.google.mediapipe.components;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.media.AudioFormat;
import android.util.Log;
import com.google.common.base.Preconditions;
import com.google.mediapipe.components.AudioDataConsumer;
import com.google.mediapipe.components.AudioDataProcessor;
import com.google.mediapipe.components.FrameProcessor$1;
import com.google.mediapipe.components.FrameProcessor$2;
import com.google.mediapipe.components.FrameProcessor$OnWillAddFrameListener;
import com.google.mediapipe.components.TextureFrameConsumer;
import com.google.mediapipe.components.TextureFrameProcessor;
import com.google.mediapipe.framework.AndroidAssetUtil;
import com.google.mediapipe.framework.AndroidPacketCreator;
import com.google.mediapipe.framework.Graph;
import com.google.mediapipe.framework.GraphService;
import com.google.mediapipe.framework.MediaPipeException;
import com.google.mediapipe.framework.Packet;
import com.google.mediapipe.framework.PacketCallback;
import com.google.mediapipe.framework.SurfaceOutput;
import com.google.mediapipe.framework.TextureFrame;
import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class FrameProcessor
implements TextureFrameProcessor,
AudioDataProcessor {
    private static final int AUDIO_ENCODING = 2;
    private static final int BYTES_PER_MONO_SAMPLE = 2;
    private static final String TAG = "FrameProcessor";
    private FrameProcessor$OnWillAddFrameListener addFrameListener;
    private List audioConsumers;
    private String audioInputStream;
    private String audioOutputStream;
    private double audioSampleRate;
    private Graph mediapipeGraph;
    private int numAudioChannels;
    private AndroidPacketCreator packetCreator;
    private final AtomicBoolean started;
    private List videoConsumers;
    private String videoInputStream;
    private String videoInputStreamCpu;
    private String videoOutputStream;
    private SurfaceOutput videoSurfaceOutput;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public FrameProcessor(Context object, long l10, String object2, String object3, String string2) {
        String string3;
        int n10;
        Object object4 = new ArrayList();
        this.videoConsumers = object4;
        object4 = new ArrayList();
        this.audioConsumers = object4;
        super(false);
        this.started = object4;
        this.numAudioChannels = n10 = 1;
        this.mediapipeGraph = object4 = new Graph();
        this.videoInputStream = object3;
        this.videoOutputStream = string2;
        try {
            object3 = new File((String)object2);
            boolean bl2 = ((File)object3).isAbsolute();
            if (bl2) {
                object = this.mediapipeGraph;
                ((Graph)object).loadBinaryGraph((String)object2);
            } else {
                object3 = this.mediapipeGraph;
                object = object.getAssets();
                object = AndroidAssetUtil.getAssetBytes((AssetManager)object, (String)object2);
                ((Graph)object3).loadBinaryGraph((byte[])object);
            }
            object2 = this.mediapipeGraph;
            super((Graph)object2);
            this.packetCreator = object;
            object = this.mediapipeGraph;
            object2 = this.videoOutputStream;
            object3 = new FrameProcessor$1(this);
            ((Graph)object).addPacketCallback((String)object2, (PacketCallback)object3);
            object = this.mediapipeGraph;
            ((Graph)object).setParentGlContext(l10);
        }
        catch (MediaPipeException mediaPipeException) {
            string3 = TAG;
            String string4 = "Mediapipe error: ";
            Log.e((String)string3, (String)string4, (Throwable)mediaPipeException);
        }
        object = this.mediapipeGraph;
        string3 = this.videoOutputStream;
        object = ((Graph)object).addSurfaceOutput(string3);
        this.videoSurfaceOutput = object;
    }

    public static /* synthetic */ List access$000(FrameProcessor frameProcessor) {
        return frameProcessor.videoConsumers;
    }

    public static /* synthetic */ List access$100(FrameProcessor frameProcessor) {
        return frameProcessor.audioConsumers;
    }

    private boolean maybeAcceptNewFrame() {
        AtomicBoolean atomicBoolean = this.started;
        boolean bl2 = true;
        boolean bl3 = atomicBoolean.getAndSet(bl2);
        if (!bl3) {
            this.startGraph();
        }
        return bl2;
    }

    private void startGraph() {
        this.mediapipeGraph.startRunningGraph();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addAudioConsumer(AudioDataConsumer audioDataConsumer) {
        synchronized (this) {
            List list = this.audioConsumers;
            ArrayList<AudioDataConsumer> arrayList = new ArrayList<AudioDataConsumer>(list);
            arrayList.add(audioDataConsumer);
            this.audioConsumers = arrayList;
            return;
        }
    }

    public void addAudioStreams(String object, String object2, int n10, double d10) {
        String string2;
        this.audioInputStream = object;
        this.audioOutputStream = object2;
        this.numAudioChannels = n10;
        this.audioSampleRate = d10;
        if (object != null) {
            object = this.packetCreator.createTimeSeriesHeader(n10, d10);
            object2 = this.mediapipeGraph;
            string2 = this.audioInputStream;
            ((Graph)object2).setStreamHeader(string2, (Packet)object);
        }
        if ((object = this.audioOutputStream) != null) {
            object = new AudioFormat.Builder();
            object = object.setEncoding(2);
            int n11 = (int)d10;
            object = object.setSampleRate(n11);
            n11 = this.numAudioChannels;
            object = object.setChannelMask(n11).build();
            object2 = this.mediapipeGraph;
            string2 = this.audioOutputStream;
            FrameProcessor$2 frameProcessor$2 = new FrameProcessor$2(this, (AudioFormat)object);
            ((Graph)object2).addPacketCallback(string2, frameProcessor$2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addConsumer(TextureFrameConsumer textureFrameConsumer) {
        synchronized (this) {
            List list = this.videoConsumers;
            ArrayList<TextureFrameConsumer> arrayList = new ArrayList<TextureFrameConsumer>(list);
            arrayList.add(textureFrameConsumer);
            this.videoConsumers = arrayList;
            return;
        }
    }

    public void addPacketCallback(String string2, PacketCallback packetCallback) {
        this.mediapipeGraph.addPacketCallback(string2, packetCallback);
    }

    public void close() {
        String string2 = "Mediapipe error: ";
        String string3 = TAG;
        Object object = this.started;
        boolean bl2 = ((AtomicBoolean)object).get();
        if (bl2) {
            object = this.mediapipeGraph;
            ((Graph)object).closeAllPacketSources();
            object = this.mediapipeGraph;
            try {
                ((Graph)object).waitUntilGraphDone();
            }
            catch (MediaPipeException mediaPipeException) {
                Log.e((String)string3, (String)string2, (Throwable)mediaPipeException);
            }
            object = this.mediapipeGraph;
            try {
                ((Graph)object).tearDown();
            }
            catch (MediaPipeException mediaPipeException) {
                Log.e((String)string3, (String)string2, (Throwable)mediaPipeException);
            }
        }
    }

    public Graph getGraph() {
        return this.mediapipeGraph;
    }

    public AndroidPacketCreator getPacketCreator() {
        return this.packetCreator;
    }

    public SurfaceOutput getVideoSurfaceOutput() {
        return this.videoSurfaceOutput;
    }

    public void onNewAudioData(ByteBuffer object, long l10, AudioFormat object2) {
        int n10;
        int n11;
        double d10;
        double d11;
        double d12;
        double d13;
        Object object3 = this.started;
        int n112 = 1;
        boolean n12 = ((AtomicBoolean)object3).getAndSet(n112 != 0);
        if (!n12) {
            this.startGraph();
        }
        int n13 = object2.getChannelCount();
        n112 = this.numAudioChannels;
        String string2 = TAG;
        if (n13 == n112 && (d13 = (d12 = (d11 = (double)object2.getSampleRate()) - (d10 = this.audioSampleRate)) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1)) == false && (n11 = object2.getEncoding()) == (n10 = 2)) {
            object2 = this.audioInputStream;
            Preconditions.checkNotNull(object2);
            n11 = ((Buffer)object).limit() / n10;
            int n14 = this.numAudioChannels;
            AndroidPacketCreator androidPacketCreator = this.packetCreator;
            object = androidPacketCreator.createAudioPacket((ByteBuffer)object, n14, n11 /= n14);
            object2 = this.mediapipeGraph;
            object3 = this.audioInputStream;
            try {
                ((Graph)object2).addConsumablePacketToInputStream((String)object3, (Packet)object, l10);
            }
            catch (MediaPipeException mediaPipeException) {
                String string3 = "Mediapipe error: ";
                Log.e((String)string2, (String)string3, (Throwable)mediaPipeException);
            }
            ((Packet)object).release();
            return;
        }
        Log.e((String)string2, (String)"Producer's AudioFormat doesn't match FrameProcessor's AudioFormat");
    }

    public void onNewFrame(Bitmap object, long l10) {
        boolean bl2 = this.maybeAcceptNewFrame();
        if (!bl2) {
            return;
        }
        Object object2 = this.addFrameListener;
        if (object2 != null) {
            object2.onWillAddFrame(l10);
        }
        object2 = this.getPacketCreator();
        object = ((AndroidPacketCreator)object2).createRgbImageFrame((Bitmap)object);
        object2 = this.mediapipeGraph;
        String string2 = this.videoInputStreamCpu;
        try {
            ((Graph)object2).addConsumablePacketToInputStream(string2, (Packet)object, l10);
        }
        catch (MediaPipeException mediaPipeException) {
            String string3 = TAG;
            object2 = "Mediapipe error: ";
            Log.e((String)string3, (String)object2, (Throwable)mediaPipeException);
        }
        ((Packet)object).release();
    }

    public void onNewFrame(TextureFrame textureFrame) {
        Object object;
        Object object2;
        Object object3;
        String string2 = TAG;
        int n10 = 2;
        int n11 = Log.isLoggable((String)string2, (int)n10);
        if (n11 != 0) {
            n11 = 3;
            object3 = new Object[n11];
            Integer n12 = textureFrame.getTextureName();
            object3[0] = n12;
            int n13 = textureFrame.getWidth();
            n12 = n13;
            object3[1] = n12;
            int n14 = textureFrame.getHeight();
            object3[n10] = object2 = Integer.valueOf(n14);
            object = String.format("Input tex: %d width: %d height: %d", (Object[])object3);
            Log.v((String)string2, (String)object);
        }
        if ((n10 = (int)(this.maybeAcceptNewFrame() ? 1 : 0)) == 0) {
            textureFrame.release();
            return;
        }
        object = this.addFrameListener;
        if (object != null) {
            long l10 = textureFrame.getTimestamp();
            object.onWillAddFrame(l10);
        }
        object = this.packetCreator.createGpuBuffer(textureFrame);
        object3 = this.mediapipeGraph;
        object2 = this.videoInputStream;
        long l11 = textureFrame.getTimestamp();
        try {
            ((Graph)object3).addConsumablePacketToInputStream((String)object2, (Packet)object, l11);
        }
        catch (MediaPipeException mediaPipeException) {
            object3 = "Mediapipe error: ";
            Log.e((String)string2, (String)object3, (Throwable)mediaPipeException);
        }
        ((Packet)object).release();
    }

    public void preheat() {
        AtomicBoolean atomicBoolean = this.started;
        boolean bl2 = true;
        boolean bl3 = atomicBoolean.getAndSet(bl2);
        if (!bl3) {
            this.startGraph();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean removeAudioConsumer(AudioDataConsumer audioDataConsumer) {
        synchronized (this) {
            List list = this.audioConsumers;
            ArrayList arrayList = new ArrayList(list);
            boolean bl2 = arrayList.remove(audioDataConsumer);
            this.audioConsumers = arrayList;
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean removeConsumer(TextureFrameConsumer textureFrameConsumer) {
        synchronized (this) {
            List list = this.videoConsumers;
            ArrayList arrayList = new ArrayList(list);
            boolean bl2 = arrayList.remove(textureFrameConsumer);
            this.videoConsumers = arrayList;
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setAudioConsumer(AudioDataConsumer object) {
        synchronized (this) {
            int n10 = 1;
            AudioDataConsumer[] audioDataConsumerArray = new AudioDataConsumer[n10];
            audioDataConsumerArray[0] = object;
            this.audioConsumers = object = Arrays.asList(audioDataConsumerArray);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setConsumer(TextureFrameConsumer object) {
        synchronized (this) {
            int n10 = 1;
            TextureFrameConsumer[] textureFrameConsumerArray = new TextureFrameConsumer[n10];
            textureFrameConsumerArray[0] = object;
            this.videoConsumers = object = Arrays.asList(textureFrameConsumerArray);
            return;
        }
    }

    public void setInputSidePackets(Map map) {
        Preconditions.checkState(this.started.get() ^ true, "setInputSidePackets must be called before the graph is started");
        this.mediapipeGraph.setInputSidePackets(map);
    }

    public void setOnWillAddFrameListener(FrameProcessor$OnWillAddFrameListener frameProcessor$OnWillAddFrameListener) {
        this.addFrameListener = frameProcessor$OnWillAddFrameListener;
    }

    public void setServiceObject(GraphService graphService, Object object) {
        synchronized (this) {
            Graph graph = this.mediapipeGraph;
            graph.setServiceObject(graphService, object);
            return;
        }
    }

    public void setVideoInputStreamCpu(String string2) {
        this.videoInputStreamCpu = string2;
    }

    public void waitUntilIdle() {
        Graph graph = this.mediapipeGraph;
        try {
            graph.waitUntilGraphIdle();
        }
        catch (MediaPipeException mediaPipeException) {
            String string2 = TAG;
            String string3 = "Mediapipe error: ";
            Log.e((String)string2, (String)string3, (Throwable)mediaPipeException);
        }
    }
}

