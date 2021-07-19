/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 *  android.media.MediaFormat
 *  android.opengl.GLES20
 *  android.opengl.Matrix
 */
package com.google.android.exoplayer2.ui.spherical;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ui.spherical.ProjectionRenderer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import com.google.android.exoplayer2.video.spherical.FrameRotationQueue;
import com.google.android.exoplayer2.video.spherical.Projection;
import com.google.android.exoplayer2.video.spherical.ProjectionDecoder;
import d.h.a.a.p0.f0.a;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SceneRenderer
implements VideoFrameMetadataListener,
CameraMotionListener {
    private volatile int defaultStereoMode;
    private final AtomicBoolean frameAvailable;
    private final FrameRotationQueue frameRotationQueue;
    private byte[] lastProjectionData;
    private int lastStereoMode;
    private final TimedValueQueue projectionQueue;
    private final ProjectionRenderer projectionRenderer;
    private final AtomicBoolean resetRotationAtNextFrame;
    private final float[] rotationMatrix;
    private final TimedValueQueue sampleTimestampQueue;
    private SurfaceTexture surfaceTexture;
    private final float[] tempMatrix;
    private int textureId;

    public SceneRenderer() {
        Object object = new AtomicBoolean();
        this.frameAvailable = object;
        object = new AtomicBoolean(true);
        this.resetRotationAtNextFrame = object;
        this.projectionRenderer = object = new ProjectionRenderer();
        this.frameRotationQueue = object = new FrameRotationQueue();
        this.sampleTimestampQueue = object = new TimedValueQueue();
        this.projectionQueue = object = new TimedValueQueue();
        int n10 = 16;
        float[] fArray = new float[n10];
        this.rotationMatrix = fArray;
        object = new float[n10];
        this.tempMatrix = (float[])object;
        this.defaultStereoMode = 0;
        this.lastStereoMode = -1;
    }

    private /* synthetic */ void a(SurfaceTexture surfaceTexture) {
        this.frameAvailable.set(true);
    }

    private void setProjection(byte[] object, int n10, long l10) {
        byte[] byArray = this.lastProjectionData;
        int n11 = this.lastStereoMode;
        this.lastProjectionData = object;
        int n12 = -1;
        if (n10 == n12) {
            n10 = this.defaultStereoMode;
        }
        this.lastStereoMode = n10;
        if (n11 == n10 && (n12 = (int)(Arrays.equals(byArray, object = this.lastProjectionData) ? 1 : 0)) != 0) {
            return;
        }
        n12 = 0;
        object = null;
        byte[] byArray2 = this.lastProjectionData;
        if (byArray2 != null) {
            n12 = this.lastStereoMode;
            object = ProjectionDecoder.decode(byArray2, n12);
        }
        if (object == null || (n10 = (int)(ProjectionRenderer.isSupported((Projection)object) ? 1 : 0)) == 0) {
            n12 = this.lastStereoMode;
            object = Projection.createEquirectangular(n12);
        }
        this.projectionQueue.add(l10, object);
    }

    public /* synthetic */ void b(SurfaceTexture surfaceTexture) {
        this.a(surfaceTexture);
    }

    public void drawFrame(float[] object, boolean bl2) {
        Object object2;
        Object object3;
        GLES20.glClear((int)16384);
        GlUtil.checkGlError();
        Object object32 = this.frameAvailable;
        boolean bl3 = true;
        Object object4 = null;
        boolean n10 = ((AtomicBoolean)object32).compareAndSet(bl3, false);
        if (n10) {
            long l10;
            ((SurfaceTexture)Assertions.checkNotNull(this.surfaceTexture)).updateTexImage();
            GlUtil.checkGlError();
            object32 = this.resetRotationAtNextFrame;
            boolean bl4 = ((AtomicBoolean)object32).compareAndSet(bl3, false);
            if (bl4) {
                object32 = this.rotationMatrix;
                Matrix.setIdentityM((float[])object32, (int)0);
            }
            if ((object4 = (Object)((Long)this.sampleTimestampQueue.poll(l10 = (object32 = this.surfaceTexture).getTimestamp()))) != null) {
                FrameRotationQueue frameRotationQueue = this.frameRotationQueue;
                object3 = this.rotationMatrix;
                long l11 = (Long)object4;
                frameRotationQueue.pollRotationMatrix((float[])object3, l11);
            }
            if ((object32 = (Projection)((TimedValueQueue)(object4 = (Object)this.projectionQueue)).pollFloor(l10)) != null) {
                object2 = this.projectionRenderer;
                ((ProjectionRenderer)object2).setProjection((Projection)object32);
            }
        }
        object4 = this.tempMatrix;
        float[] fArray = this.rotationMatrix;
        object3 = object;
        Matrix.multiplyMM((float[])object4, (int)0, (float[])object, (int)0, (float[])fArray, (int)0);
        object = this.projectionRenderer;
        int n11 = this.textureId;
        object2 = this.tempMatrix;
        ((ProjectionRenderer)object).draw(n11, (float[])object2, bl2);
    }

    public SurfaceTexture init() {
        SurfaceTexture surfaceTexture;
        int n10;
        float f10 = 0.5f;
        GLES20.glClearColor((float)f10, (float)f10, (float)f10, (float)1.0f);
        GlUtil.checkGlError();
        this.projectionRenderer.init();
        GlUtil.checkGlError();
        int n11 = this.textureId = (n10 = GlUtil.createExternalTexture());
        this.surfaceTexture = surfaceTexture = new SurfaceTexture(n11);
        a a10 = new a(this);
        surfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener)a10);
        return this.surfaceTexture;
    }

    public void onCameraMotion(long l10, float[] fArray) {
        this.frameRotationQueue.setRotation(l10, fArray);
    }

    public void onCameraMotionReset() {
        this.sampleTimestampQueue.clear();
        this.frameRotationQueue.reset();
        this.resetRotationAtNextFrame.set(true);
    }

    public void onVideoFrameAboutToBeRendered(long l10, long l11, Format format, MediaFormat object) {
        object = this.sampleTimestampQueue;
        Object object2 = l10;
        ((TimedValueQueue)object).add(l11, object2);
        object2 = format.projectionData;
        int n10 = format.stereoMode;
        this.setProjection((byte[])object2, n10, l11);
    }

    public void setDefaultStereoMode(int n10) {
        this.defaultStereoMode = n10;
    }

    public void shutdown() {
        this.projectionRenderer.shutdown();
    }
}

