/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 *  android.opengl.GLES20
 *  android.os.Handler
 *  android.util.Log
 *  javax.microedition.khronos.egl.EGLContext
 */
package com.google.mediapipe.components;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.util.Log;
import com.google.mediapipe.components.TextureFrameConsumer;
import com.google.mediapipe.framework.AppTextureFrame;
import com.google.mediapipe.glutil.ExternalTextureRenderer;
import com.google.mediapipe.glutil.GlThread;
import com.google.mediapipe.glutil.ShaderUtil;
import d.h.b.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.microedition.khronos.egl.EGLContext;

public class ExternalTextureConverter$RenderThread
extends GlThread
implements SurfaceTexture.OnFrameAvailableListener {
    private static final long NANOS_PER_MICRO = 1000L;
    private final List consumers;
    public int destinationHeight;
    public int destinationWidth;
    private long nextFrameTimestampOffset;
    private int outputFrameIndex = -1;
    private List outputFrames = null;
    private long previousTimestamp;
    private boolean previousTimestampValid;
    private ExternalTextureRenderer renderer = null;
    private volatile SurfaceTexture surfaceTexture = null;
    private long timestampOffsetNanos;

    public ExternalTextureConverter$RenderThread(EGLContext object, int n10) {
        super(object);
        ArrayList arrayList;
        long l10;
        this.nextFrameTimestampOffset = l10 = 0L;
        this.timestampOffsetNanos = l10;
        this.previousTimestamp = l10;
        this.previousTimestampValid = false;
        this.destinationWidth = 0;
        this.destinationHeight = 0;
        this.outputFrames = arrayList = new ArrayList();
        object = Collections.nCopies(n10, null);
        arrayList.addAll(object);
        super();
        this.renderer = object;
        super();
        this.consumers = object;
    }

    private /* synthetic */ void a(SurfaceTexture surfaceTexture) {
        this.renderNext(surfaceTexture);
    }

    private AppTextureFrame nextOutputFrame() {
        int n10;
        int n11 = this.outputFrameIndex + 1;
        int n12 = this.outputFrames.size();
        this.outputFrameIndex = n11 %= n12;
        List list = this.outputFrames;
        Object object = (AppTextureFrame)list.get(n11);
        if (object == null || (n12 = ((AppTextureFrame)object).getWidth()) != (n10 = this.destinationWidth) || (n12 = ((AppTextureFrame)object).getHeight()) != (n10 = this.destinationHeight)) {
            n11 = this.outputFrameIndex;
            this.setupDestination(n11);
            object = this.outputFrames;
            n12 = this.outputFrameIndex;
            object = (AppTextureFrame)object.get(n12);
        }
        this.waitUntilReleased((AppTextureFrame)object);
        return object;
    }

    private void setupDestination(int n10) {
        this.teardownDestination(n10);
        int n11 = this.destinationWidth;
        int n12 = this.destinationHeight;
        n11 = ShaderUtil.createRgbaTexture(n11, n12);
        Object object = n11;
        Object object2 = new Object[]{object, object = Integer.valueOf(this.destinationWidth), object = Integer.valueOf(this.destinationHeight)};
        object2 = String.format("Created output texture: %d width: %d height: %d", (Object[])object2);
        Log.d((String)"ExternalTextureConv", (String)object2);
        n12 = this.destinationWidth;
        int n13 = this.destinationHeight;
        this.bindFramebuffer(n11, n12, n13);
        object2 = this.outputFrames;
        int n14 = this.destinationWidth;
        int n15 = this.destinationHeight;
        object = new AppTextureFrame(n11, n14, n15);
        object2.set(n10, object);
    }

    private void teardownDestination(int n10) {
        Object object = this.outputFrames.get(n10);
        if (object != null) {
            int n11;
            object = (AppTextureFrame)this.outputFrames.get(n10);
            this.waitUntilReleased((AppTextureFrame)object);
            int n12 = 1;
            int[] nArray = new int[n12];
            AppTextureFrame appTextureFrame = (AppTextureFrame)this.outputFrames.get(n10);
            nArray[0] = n11 = appTextureFrame.getTextureName();
            GLES20.glDeleteTextures((int)n12, (int[])nArray, (int)0);
            object = this.outputFrames;
            nArray = null;
            object.set(n10, null);
        }
    }

    private void updateOutputFrame(AppTextureFrame appTextureFrame) {
        long l10;
        long l11;
        int n10 = appTextureFrame.getTextureName();
        int n11 = this.destinationWidth;
        int n12 = this.destinationHeight;
        this.bindFramebuffer(n10, n11, n12);
        ExternalTextureRenderer externalTextureRenderer = this.renderer;
        SurfaceTexture surfaceTexture = this.surfaceTexture;
        externalTextureRenderer.render(surfaceTexture);
        externalTextureRenderer = this.surfaceTexture;
        long l12 = externalTextureRenderer.getTimestamp();
        long l13 = this.timestampOffsetNanos;
        l12 += l13;
        l13 = 1000L;
        l12 /= l13;
        n12 = (int)(this.previousTimestampValid ? 1 : 0);
        if (n12 != 0 && (n12 = (int)((l11 = (l13 = this.nextFrameTimestampOffset + l12) - (l10 = this.previousTimestamp)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) <= 0) {
            l13 = 1L;
            this.nextFrameTimestampOffset = l10 = l10 + l13 - l12;
        }
        l13 = this.nextFrameTimestampOffset;
        appTextureFrame.setTimestamp(l12 += l13);
        this.previousTimestamp = l12 = appTextureFrame.getTimestamp();
        this.previousTimestampValid = true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void waitUntilReleased(AppTextureFrame object) {
        Object object2 = "ExternalTextureConv";
        int n10 = 2;
        try {
            Object[] objectArray;
            String string2;
            boolean bl2 = Log.isLoggable((String)object2, (int)n10);
            int n11 = 1;
            int n12 = 0;
            Integer n13 = null;
            int n14 = 3;
            if (bl2) {
                string2 = "Waiting for tex: %d width: %d height: %d";
                objectArray = new Object[n14];
                int n15 = ((AppTextureFrame)object).getTextureName();
                Integer n16 = n15;
                objectArray[0] = n16;
                n15 = ((AppTextureFrame)object).getWidth();
                n16 = n15;
                objectArray[n11] = n16;
                n15 = ((AppTextureFrame)object).getHeight();
                n16 = n15;
                objectArray[n10] = n16;
                string2 = String.format(string2, objectArray);
                Log.v((String)object2, (String)string2);
            }
            ((AppTextureFrame)object).waitUntilReleased();
            bl2 = Log.isLoggable((String)object2, (int)n10);
            if (bl2) {
                string2 = "Finished waiting for tex: %d width: %d height: %d";
                Object[] objectArray2 = new Object[n14];
                int n17 = ((AppTextureFrame)object).getTextureName();
                objectArray2[0] = objectArray = Integer.valueOf(n17);
                n12 = ((AppTextureFrame)object).getWidth();
                n13 = n12;
                objectArray2[n11] = n13;
                int n18 = ((AppTextureFrame)object).getHeight();
                objectArray2[n10] = object = Integer.valueOf(n18);
                object = String.format(string2, objectArray2);
                Log.v((String)object2, (String)object);
            }
            return;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("thread was unexpectedly interrupted: ");
            String string3 = interruptedException.getMessage();
            stringBuilder.append(string3);
            String string4 = stringBuilder.toString();
            Log.e((String)object2, (String)string4);
            object2 = new RuntimeException(interruptedException);
            throw object2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addConsumer(TextureFrameConsumer textureFrameConsumer) {
        List list = this.consumers;
        synchronized (list) {
            List list2 = this.consumers;
            list2.add(textureFrameConsumer);
            return;
        }
    }

    public /* synthetic */ void b(SurfaceTexture surfaceTexture) {
        this.a(surfaceTexture);
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Handler handler = this.handler;
        c c10 = new c(this, surfaceTexture);
        handler.post((Runnable)c10);
    }

    public void prepareGl() {
        super.prepareGl();
        GLES20.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        this.renderer.setup();
    }

    public void releaseGl() {
        List list;
        int n10;
        for (int i10 = 0; i10 < (n10 = (list = this.outputFrames).size()); ++i10) {
            this.teardownDestination(i10);
        }
        this.renderer.release();
        super.releaseGl();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void removeConsumer(TextureFrameConsumer textureFrameConsumer) {
        List list = this.consumers;
        synchronized (list) {
            List list2 = this.consumers;
            list2.remove(textureFrameConsumer);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void renderNext(SurfaceTexture object) {
        Object object2 = this.surfaceTexture;
        if (object != object2) {
            return;
        }
        object = this.consumers;
        synchronized (object) {
            boolean bl2;
            object2 = this.consumers;
            object2 = object2.iterator();
            int n10 = 1;
            int n11 = 0;
            TextureFrameConsumer textureFrameConsumer = null;
            while (bl2 = object2.hasNext()) {
                textureFrameConsumer = (TextureFrameConsumer)object2.next();
                textureFrameConsumer = textureFrameConsumer;
                AppTextureFrame appTextureFrame = this.nextOutputFrame();
                this.updateOutputFrame(appTextureFrame);
                if (textureFrameConsumer != null) {
                    String string2 = "ExternalTextureConv";
                    int n12 = 2;
                    boolean bl3 = Log.isLoggable((String)string2, (int)n12);
                    if (bl3) {
                        string2 = "ExternalTextureConv";
                        String string3 = "Locking tex: %d width: %d height: %d";
                        int n13 = 3;
                        Object[] objectArray = new Object[n13];
                        int n14 = appTextureFrame.getTextureName();
                        Integer n15 = n14;
                        objectArray[0] = n15;
                        n14 = appTextureFrame.getWidth();
                        n15 = n14;
                        objectArray[n10] = n15;
                        n14 = appTextureFrame.getHeight();
                        n15 = n14;
                        objectArray[n12] = n15;
                        String string4 = String.format(string3, objectArray);
                        Log.v((String)string2, (String)string4);
                    }
                    appTextureFrame.setInUse();
                    textureFrameConsumer.onNewFrame(appTextureFrame);
                }
                n11 = n10;
            }
            if (n11 == 0) {
                object2 = this.nextOutputFrame();
                this.updateOutputFrame((AppTextureFrame)object2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setConsumer(TextureFrameConsumer textureFrameConsumer) {
        List list = this.consumers;
        synchronized (list) {
            List list2 = this.consumers;
            list2.clear();
            list2 = this.consumers;
            list2.add(textureFrameConsumer);
            return;
        }
    }

    public void setFlipY(boolean bl2) {
        this.renderer.setFlipY(bl2);
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture, int n10, int n11) {
        SurfaceTexture surfaceTexture2 = this.surfaceTexture;
        if (surfaceTexture2 != null) {
            surfaceTexture2 = this.surfaceTexture;
            surfaceTexture2.setOnFrameAvailableListener(null);
        }
        if ((surfaceTexture = (this.surfaceTexture = surfaceTexture)) != null) {
            surfaceTexture = this.surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)this);
        }
        this.destinationWidth = n10;
        this.destinationHeight = n11;
    }

    public void setSurfaceTextureAndAttachToGLContext(SurfaceTexture surfaceTexture, int n10, int n11) {
        this.setSurfaceTexture(surfaceTexture, n10, n11);
        int n12 = 1;
        int[] nArray = new int[n12];
        GLES20.glGenTextures((int)n12, (int[])nArray, (int)0);
        surfaceTexture = this.surfaceTexture;
        n10 = nArray[0];
        surfaceTexture.attachToGLContext(n10);
    }

    public void setTimestampOffsetNanos(long l10) {
        this.timestampOffsetNanos = l10;
    }
}

