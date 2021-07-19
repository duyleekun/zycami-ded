/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.graphics.SurfaceTexture
 *  android.opengl.GLES20
 *  android.opengl.GLSurfaceView$Renderer
 *  android.opengl.Matrix
 *  javax.microedition.khronos.egl.EGLConfig
 *  javax.microedition.khronos.opengles.GL10
 */
package com.google.android.exoplayer2.ui.spherical;

import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import com.google.android.exoplayer2.ui.spherical.OrientationListener$Listener;
import com.google.android.exoplayer2.ui.spherical.SceneRenderer;
import com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView;
import com.google.android.exoplayer2.ui.spherical.TouchTracker$Listener;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class SphericalGLSurfaceView$Renderer
implements GLSurfaceView.Renderer,
TouchTracker$Listener,
OrientationListener$Listener {
    private final float[] deviceOrientationMatrix;
    private float deviceRoll;
    private final float[] projectionMatrix;
    private final SceneRenderer scene;
    private final float[] tempMatrix;
    public final /* synthetic */ SphericalGLSurfaceView this$0;
    private float touchPitch;
    private final float[] touchPitchMatrix;
    private final float[] touchYawMatrix;
    private final float[] viewMatrix;
    private final float[] viewProjectionMatrix;

    public SphericalGLSurfaceView$Renderer(SphericalGLSurfaceView object, SceneRenderer sceneRenderer) {
        this.this$0 = object;
        int n10 = 16;
        float[] fArray = new float[n10];
        this.projectionMatrix = fArray;
        fArray = new float[n10];
        this.viewProjectionMatrix = fArray;
        fArray = new float[n10];
        this.deviceOrientationMatrix = fArray;
        float[] fArray2 = new float[n10];
        this.touchPitchMatrix = fArray2;
        float[] fArray3 = new float[n10];
        this.touchYawMatrix = fArray3;
        float[] fArray4 = new float[n10];
        this.viewMatrix = fArray4;
        object = new float[n10];
        this.tempMatrix = (float[])object;
        this.scene = sceneRenderer;
        Matrix.setIdentityM((float[])fArray, (int)0);
        Matrix.setIdentityM((float[])fArray2, (int)0);
        Matrix.setIdentityM((float[])fArray3, (int)0);
        this.deviceRoll = (float)Math.PI;
    }

    private float calculateFieldOfViewInYDirection(float f10) {
        float f11 = 1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object > 0) {
            object = true;
            f11 = Float.MIN_VALUE;
        } else {
            object = false;
            f11 = 0.0f;
        }
        if (object != false) {
            double d10 = Math.tan(Math.toRadians(45.0));
            double d11 = f10;
            return (float)(Math.toDegrees(Math.atan(d10 / d11)) * 2.0);
        }
        return 90.0f;
    }

    private void updatePitchMatrix() {
        float[] fArray = this.touchPitchMatrix;
        float f10 = -this.touchPitch;
        float f11 = (float)Math.cos(this.deviceRoll);
        float f12 = (float)Math.sin(this.deviceRoll);
        Matrix.setRotateM((float[])fArray, (int)0, (float)f10, (float)f11, (float)f12, (float)0.0f);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onDrawFrame(GL10 object) {
        float[] fArray;
        float[] fArray2;
        float[] fArray3;
        synchronized (this) {
            fArray3 = this.tempMatrix;
            fArray2 = this.deviceOrientationMatrix;
            fArray = this.touchYawMatrix;
            Matrix.multiplyMM((float[])fArray3, (int)0, (float[])fArray2, (int)0, (float[])fArray, (int)0);
            float[] fArray4 = this.viewMatrix;
            float[] fArray5 = this.touchPitchMatrix;
            float[] fArray6 = this.tempMatrix;
            Matrix.multiplyMM((float[])fArray4, (int)0, (float[])fArray5, (int)0, (float[])fArray6, (int)0);
        }
        fArray3 = this.viewProjectionMatrix;
        fArray2 = this.projectionMatrix;
        fArray = this.viewMatrix;
        Matrix.multiplyMM((float[])fArray3, (int)0, (float[])fArray2, (int)0, (float[])fArray, (int)0);
        object = this.scene;
        fArray3 = this.viewProjectionMatrix;
        ((SceneRenderer)object).drawFrame(fArray3, false);
    }

    public void onOrientationChange(float[] fArray, float f10) {
        synchronized (this) {
            float[] fArray2 = this.deviceOrientationMatrix;
            int n10 = fArray2.length;
            System.arraycopy(fArray, 0, fArray2, 0, n10);
            float f11 = -f10;
            this.deviceRoll = f11;
            this.updatePitchMatrix();
            return;
        }
    }

    public void onScrollChange(PointF pointF) {
        synchronized (this) {
            float f10 = pointF.y;
            this.touchPitch = f10;
            this.updatePitchMatrix();
            float[] fArray = this.touchYawMatrix;
            float f11 = pointF.x;
            float f12 = -f11;
            float f13 = 1.0f;
            Matrix.setRotateM((float[])fArray, (int)0, (float)f12, (float)0.0f, (float)f13, (float)0.0f);
            return;
        }
    }

    public void onSurfaceChanged(GL10 gL10, int n10, int n11) {
        GLES20.glViewport((int)0, (int)0, (int)n10, (int)n11);
        float f10 = n10;
        float f11 = n11;
        float f12 = f10 / f11;
        float f13 = this.calculateFieldOfViewInYDirection(f12);
        Matrix.perspectiveM((float[])this.projectionMatrix, (int)0, (float)f13, (float)f12, (float)0.1f, (float)100.0f);
    }

    public void onSurfaceCreated(GL10 object, EGLConfig object2) {
        synchronized (this) {
            object = this.this$0;
            object2 = this.scene;
            object2 = ((SceneRenderer)object2).init();
            SphericalGLSurfaceView.access$000((SphericalGLSurfaceView)((Object)object), (SurfaceTexture)object2);
            return;
        }
    }
}

