/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 */
package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink$DefaultAudioProcessorChain;
import com.google.android.exoplayer2.audio.MediaCodecAudioRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionRenderer;
import java.lang.constant.Constable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class DefaultRenderersFactory
implements RenderersFactory {
    public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000L;
    public static final int EXTENSION_RENDERER_MODE_OFF = 0;
    public static final int EXTENSION_RENDERER_MODE_ON = 1;
    public static final int EXTENSION_RENDERER_MODE_PREFER = 2;
    public static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;
    private static final String TAG = "DefaultRenderersFactory";
    private long allowedVideoJoiningTimeMs;
    private final Context context;
    private boolean enableAsyncQueueing;
    private boolean enableAudioTrackPlaybackParams;
    private boolean enableDecoderFallback;
    private boolean enableFloatOutput;
    private boolean enableOffload;
    private boolean enableSynchronizeCodecInteractionsWithQueueing;
    private int extensionRendererMode;
    private boolean forceAsyncQueueingSynchronizationWorkaround;
    private MediaCodecSelector mediaCodecSelector;

    public DefaultRenderersFactory(Context object) {
        this.context = object;
        this.extensionRendererMode = 0;
        this.allowedVideoJoiningTimeMs = 5000L;
        object = MediaCodecSelector.DEFAULT;
        this.mediaCodecSelector = object;
    }

    public DefaultRenderersFactory(Context context, int n10) {
        this(context, n10, 5000L);
    }

    public DefaultRenderersFactory(Context object, int n10, long l10) {
        this.context = object;
        this.extensionRendererMode = n10;
        this.allowedVideoJoiningTimeMs = l10;
        object = MediaCodecSelector.DEFAULT;
        this.mediaCodecSelector = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void buildAudioRenderers(Context context, int n10, MediaCodecSelector objectArray, boolean bl2, AudioSink audioSink, Handler handler, AudioRendererEventListener classArray, ArrayList arrayList) {
        int n11;
        int n12;
        Object exception;
        Class<Handler> clazz;
        Object[] objectArray2;
        Object[] objectArray3;
        Object object2;
        Class<AudioRendererEventListener> clazz2;
        Class<AudioSink> clazz3;
        String string2;
        ArrayList arrayList2;
        block19: {
            int n13;
            Object[] objectArray4;
            block17: {
                MediaCodecAudioRenderer mediaCodecAudioRenderer;
                arrayList2 = arrayList;
                string2 = TAG;
                clazz3 = AudioSink.class;
                clazz2 = AudioRendererEventListener.class;
                object2 = mediaCodecAudioRenderer;
                objectArray3 = objectArray;
                boolean n14 = bl2;
                objectArray4 = handler;
                objectArray2 = classArray;
                clazz = audioSink;
                mediaCodecAudioRenderer = new MediaCodecAudioRenderer(context, (MediaCodecSelector)objectArray, bl2, handler, (AudioRendererEventListener)classArray, audioSink);
                int n15 = this.enableAsyncQueueing;
                mediaCodecAudioRenderer.experimentalSetAsynchronousBufferQueueingEnabled(n15 != 0);
                n15 = this.forceAsyncQueueingSynchronizationWorkaround;
                mediaCodecAudioRenderer.experimentalSetForceAsyncQueueingSynchronizationWorkaround(n15 != 0);
                n15 = this.enableSynchronizeCodecInteractionsWithQueueing;
                mediaCodecAudioRenderer.experimentalSetSynchronizeCodecInteractionsWithQueueingEnabled(n15 != 0);
                arrayList.add(mediaCodecAudioRenderer);
                if (n10 == 0) {
                    return;
                }
                n15 = arrayList.size();
                int n16 = 2;
                if (n10 == n16) {
                    n15 += -1;
                }
                exception = null;
                n12 = 3;
                int n17 = 1;
                objectArray4 = "com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer";
                try {
                    try {
                        objectArray4 = Class.forName((String)objectArray4);
                        objectArray2 = new Class[n12];
                        clazz = Handler.class;
                        objectArray2[0] = clazz;
                        objectArray2[n17] = clazz2;
                        objectArray2[n16] = clazz3;
                        objectArray4 = objectArray4.getConstructor((Class<?>[])objectArray2);
                        objectArray2 = new Object[n12];
                        objectArray2[0] = handler;
                        objectArray2[n17] = classArray;
                        objectArray2[n16] = audioSink;
                        objectArray4 = objectArray4.newInstance(objectArray2);
                        objectArray4 = (Renderer)objectArray4;
                        n13 = n15 + 1;
                    }
                    catch (ClassNotFoundException classNotFoundException) {}
                    try {
                        arrayList2.add(n15, objectArray4);
                        object2 = "Loaded LibopusAudioRenderer.";
                        Log.i(string2, (String)object2);
                        break block17;
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        n15 = n13;
                    }
                }
                catch (Exception exception2) {
                    object2 = new RuntimeException("Error instantiating Opus extension", exception2);
                    throw object2;
                }
                n13 = n15;
            }
            object2 = "com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer";
            try {
                try {
                    object2 = Class.forName((String)object2);
                    objectArray4 = new Class[n12];
                    objectArray4[0] = clazz = Handler.class;
                    objectArray4[n17] = clazz2;
                    objectArray4[n16] = clazz3;
                    object2 = ((Class)object2).getConstructor((Class<?>[])objectArray4);
                    objectArray4 = new Object[n12];
                    objectArray4[0] = handler;
                    objectArray4[n17] = classArray;
                    objectArray4[n16] = audioSink;
                    object2 = ((Constructor)object2).newInstance(objectArray4);
                    object2 = (Renderer)object2;
                    n11 = n13 + 1;
                }
                catch (ClassNotFoundException classNotFoundException) {}
                try {
                    arrayList2.add(n13, object2);
                    object2 = "Loaded LibflacAudioRenderer.";
                    Log.i(string2, (String)object2);
                    break block19;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    n13 = n11;
                }
            }
            catch (Exception exception2) {
                object2 = new RuntimeException("Error instantiating FLAC extension", exception2);
                throw object2;
            }
            n11 = n13;
        }
        object2 = "com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer";
        try {
            object2 = Class.forName((String)object2);
            objectArray2 = new Class[n12];
            objectArray2[0] = clazz = Handler.class;
            objectArray2[n17] = clazz2;
            objectArray2[n16] = clazz3;
            object2 = ((Class)object2).getConstructor((Class<?>[])objectArray2);
            objectArray3 = new Object[n12];
            objectArray3[0] = handler;
            objectArray3[n17] = classArray;
            objectArray3[n16] = audioSink;
            exception = ((Constructor)object2).newInstance(objectArray3);
            exception = (Renderer)exception;
            arrayList2.add(n11, exception);
            exception = "Loaded FfmpegAudioRenderer.";
            Log.i(string2, (String)exception);
            return;
        }
        catch (Exception exception3) {
            object2 = new RuntimeException("Error instantiating FFmpeg extension", exception3);
            throw object2;
        }
        catch (ClassNotFoundException classNotFoundException) {}
    }

    public AudioSink buildAudioSink(Context audioProcessorArray, boolean bl2, boolean bl3, boolean bl4) {
        AudioCapabilities audioCapabilities = AudioCapabilities.getCapabilities((Context)audioProcessorArray);
        audioProcessorArray = new AudioProcessor[]{};
        DefaultAudioSink$DefaultAudioProcessorChain defaultAudioSink$DefaultAudioProcessorChain = new DefaultAudioSink$DefaultAudioProcessorChain(audioProcessorArray);
        DefaultAudioSink defaultAudioSink = new DefaultAudioSink(audioCapabilities, defaultAudioSink$DefaultAudioProcessorChain, bl2, bl3, bl4);
        return defaultAudioSink;
    }

    public void buildCameraMotionRenderers(Context object, int n10, ArrayList arrayList) {
        object = new CameraMotionRenderer();
        arrayList.add(object);
    }

    public void buildMetadataRenderers(Context object, MetadataOutput metadataOutput, Looper looper, int n10, ArrayList arrayList) {
        object = new MetadataRenderer(metadataOutput, looper);
        arrayList.add(object);
    }

    public void buildMiscellaneousRenderers(Context context, Handler handler, int n10, ArrayList arrayList) {
    }

    public void buildTextRenderers(Context object, TextOutput textOutput, Looper looper, int n10, ArrayList arrayList) {
        object = new TextRenderer(textOutput, looper);
        arrayList.add(object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void buildVideoRenderers(Context context, int n10, MediaCodecSelector mediaCodecSelector, boolean bl2, Handler handler, VideoRendererEventListener classArray, long l10, ArrayList arrayList) {
        int n11;
        Constable constable;
        int n12;
        Object object;
        Object object2;
        Class<VideoRendererEventListener> clazz;
        String string2;
        ArrayList arrayList2;
        int n13;
        block11: {
            MediaCodecVideoRenderer mediaCodecVideoRenderer;
            n13 = n10;
            arrayList2 = arrayList;
            string2 = TAG;
            clazz = VideoRendererEventListener.class;
            int n14 = 50;
            object2 = mediaCodecVideoRenderer;
            boolean n15 = bl2;
            object = handler;
            Object[] objectArray = classArray;
            mediaCodecVideoRenderer = new MediaCodecVideoRenderer(context, mediaCodecSelector, l10, bl2, handler, (VideoRendererEventListener)classArray, n14);
            int n16 = this.enableAsyncQueueing;
            mediaCodecVideoRenderer.experimentalSetAsynchronousBufferQueueingEnabled(n16 != 0);
            n16 = this.forceAsyncQueueingSynchronizationWorkaround;
            mediaCodecVideoRenderer.experimentalSetForceAsyncQueueingSynchronizationWorkaround(n16 != 0);
            n16 = this.enableSynchronizeCodecInteractionsWithQueueing;
            mediaCodecVideoRenderer.experimentalSetSynchronizeCodecInteractionsWithQueueingEnabled(n16 != 0);
            arrayList.add(mediaCodecVideoRenderer);
            if (n10 == 0) {
                return;
            }
            n16 = arrayList.size();
            int n17 = 2;
            if (n10 == n17) {
                n16 += -1;
            }
            n13 = 50;
            int n18 = 3;
            n12 = 4;
            int n19 = 1;
            object = "com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer";
            try {
                try {
                    object = Class.forName((String)object);
                    objectArray = new Class[n12];
                    objectArray[0] = constable = Long.TYPE;
                    objectArray[n19] = constable = Handler.class;
                    objectArray[n17] = clazz;
                    objectArray[n18] = constable = Integer.TYPE;
                    object = object.getConstructor((Class<?>[])objectArray);
                    objectArray = new Object[n12];
                    objectArray[0] = constable = Long.valueOf(l10);
                    objectArray[n19] = handler;
                    objectArray[n17] = classArray;
                    objectArray[n18] = constable = Integer.valueOf(n13);
                    object = object.newInstance(objectArray);
                    object = (Renderer)object;
                    n11 = n16 + 1;
                }
                catch (ClassNotFoundException classNotFoundException) {}
                try {
                    arrayList2.add(n16, object);
                    object2 = "Loaded LibvpxVideoRenderer.";
                    Log.i(string2, (String)object2);
                    break block11;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    n16 = n11;
                }
            }
            catch (Exception object3) {
                object2 = new RuntimeException("Error instantiating VP9 extension", object3);
                throw object2;
            }
            n11 = n16;
        }
        object2 = "com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer";
        try {
            Object exception;
            object2 = Class.forName((String)object2);
            object = new Class[n12];
            object[0] = constable = Long.TYPE;
            object[n19] = constable = Handler.class;
            object[n17] = clazz;
            object[n18] = constable = Integer.TYPE;
            object2 = ((Class)object2).getConstructor((Class<?>)object);
            Object[] objectArray = new Object[n12];
            object = l10;
            objectArray[0] = object;
            objectArray[n19] = handler;
            objectArray[n17] = classArray;
            objectArray[n18] = exception = Integer.valueOf(n13);
            exception = ((Constructor)object2).newInstance(objectArray);
            exception = (Renderer)exception;
            arrayList2.add(n11, exception);
            exception = "Loaded Libgav1VideoRenderer.";
            Log.i(string2, (String)exception);
            return;
        }
        catch (Exception exception2) {
            object2 = new RuntimeException("Error instantiating AV1 extension", exception2);
            throw object2;
        }
        catch (ClassNotFoundException classNotFoundException) {}
    }

    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        Renderer[] rendererArray = this;
        ArrayList arrayList = new ArrayList();
        Context context = this.context;
        int n10 = this.extensionRendererMode;
        MediaCodecSelector mediaCodecSelector = this.mediaCodecSelector;
        int n11 = this.enableDecoderFallback;
        long l10 = this.allowedVideoJoiningTimeMs;
        Renderer[] rendererArray2 = this;
        Object object = handler;
        this.buildVideoRenderers(context, n10, mediaCodecSelector, n11 != 0, handler, videoRendererEventListener, l10, arrayList);
        rendererArray2 = this.context;
        int n12 = this.enableFloatOutput;
        n10 = (int)(this.enableAudioTrackPlaybackParams ? 1 : 0);
        boolean bl2 = this.enableOffload;
        object = this.buildAudioSink((Context)rendererArray2, n12 != 0, n10 != 0, bl2);
        if (object != null) {
            context = this.context;
            n10 = this.extensionRendererMode;
            mediaCodecSelector = this.mediaCodecSelector;
            n11 = (int)(this.enableDecoderFallback ? 1 : 0);
            rendererArray2 = this;
            this.buildAudioRenderers(context, n10, mediaCodecSelector, n11 != 0, (AudioSink)object, handler, audioRendererEventListener, arrayList);
        }
        context = rendererArray.context;
        mediaCodecSelector = handler.getLooper();
        n11 = rendererArray.extensionRendererMode;
        rendererArray2 = this;
        object = arrayList;
        this.buildTextRenderers(context, textOutput, (Looper)mediaCodecSelector, n11, arrayList);
        context = rendererArray.context;
        mediaCodecSelector = handler.getLooper();
        n11 = rendererArray.extensionRendererMode;
        this.buildMetadataRenderers(context, metadataOutput, (Looper)mediaCodecSelector, n11, arrayList);
        rendererArray2 = rendererArray.context;
        n12 = rendererArray.extensionRendererMode;
        this.buildCameraMotionRenderers((Context)rendererArray2, n12, arrayList);
        rendererArray2 = rendererArray.context;
        n12 = rendererArray.extensionRendererMode;
        this.buildMiscellaneousRenderers((Context)rendererArray2, handler, n12, arrayList);
        rendererArray2 = new Renderer[]{};
        return arrayList.toArray(rendererArray2);
    }

    public DefaultRenderersFactory experimentalSetAsynchronousBufferQueueingEnabled(boolean bl2) {
        this.enableAsyncQueueing = bl2;
        return this;
    }

    public DefaultRenderersFactory experimentalSetForceAsyncQueueingSynchronizationWorkaround(boolean bl2) {
        this.forceAsyncQueueingSynchronizationWorkaround = bl2;
        return this;
    }

    public DefaultRenderersFactory experimentalSetSynchronizeCodecInteractionsWithQueueingEnabled(boolean bl2) {
        this.enableSynchronizeCodecInteractionsWithQueueing = bl2;
        return this;
    }

    public DefaultRenderersFactory setAllowedVideoJoiningTimeMs(long l10) {
        this.allowedVideoJoiningTimeMs = l10;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioFloatOutput(boolean bl2) {
        this.enableFloatOutput = bl2;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioOffload(boolean bl2) {
        this.enableOffload = bl2;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioTrackPlaybackParams(boolean bl2) {
        this.enableAudioTrackPlaybackParams = bl2;
        return this;
    }

    public DefaultRenderersFactory setEnableDecoderFallback(boolean bl2) {
        this.enableDecoderFallback = bl2;
        return this;
    }

    public DefaultRenderersFactory setExtensionRendererMode(int n10) {
        this.extensionRendererMode = n10;
        return this;
    }

    public DefaultRenderersFactory setMediaCodecSelector(MediaCodecSelector mediaCodecSelector) {
        this.mediaCodecSelector = mediaCodecSelector;
        return this;
    }
}

