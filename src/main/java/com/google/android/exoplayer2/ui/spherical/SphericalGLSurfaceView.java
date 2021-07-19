/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.hardware.Sensor
 *  android.hardware.SensorEventListener
 *  android.hardware.SensorManager
 *  android.opengl.GLSurfaceView
 *  android.opengl.GLSurfaceView$Renderer
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.AttributeSet
 *  android.view.Display
 *  android.view.Surface
 *  android.view.View$OnTouchListener
 *  android.view.WindowManager
 */
package com.google.android.exoplayer2.ui.spherical;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import com.google.android.exoplayer2.Player$VideoComponent;
import com.google.android.exoplayer2.ui.spherical.OrientationListener;
import com.google.android.exoplayer2.ui.spherical.OrientationListener$Listener;
import com.google.android.exoplayer2.ui.spherical.SceneRenderer;
import com.google.android.exoplayer2.ui.spherical.SingleTapListener;
import com.google.android.exoplayer2.ui.spherical.TouchTracker;
import com.google.android.exoplayer2.ui.spherical.TouchTracker$Listener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import d.h.a.a.p0.f0.b;
import d.h.a.a.p0.f0.c;

public final class SphericalGLSurfaceView
extends GLSurfaceView {
    private static final int FIELD_OF_VIEW_DEGREES = 90;
    private static final float PX_PER_DEGREES = 25.0f;
    public static final float UPRIGHT_ROLL = (float)Math.PI;
    private static final float Z_FAR = 100.0f;
    private static final float Z_NEAR = 0.1f;
    private boolean isOrientationListenerRegistered;
    private boolean isStarted;
    private final Handler mainHandler;
    private final OrientationListener orientationListener;
    private final Sensor orientationSensor;
    private final SceneRenderer scene;
    private final SensorManager sensorManager;
    private Surface surface;
    private SurfaceTexture surfaceTexture;
    private final TouchTracker touchTracker;
    private boolean useSensorRotation;
    private Player$VideoComponent videoComponent;

    public SphericalGLSurfaceView(Context context) {
        this(context, null);
    }

    public SphericalGLSurfaceView(Context context, AttributeSet object) {
        super(context, object);
        OrientationListener orientationListener;
        Object object2 = Looper.getMainLooper();
        super(object2);
        this.mainHandler = object;
        object = (SensorManager)Assertions.checkNotNull(context.getSystemService("sensor"));
        this.sensorManager = object;
        int n10 = Util.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            n10 = 15;
            object2 = object.getDefaultSensor(n10);
        } else {
            n10 = 0;
            object2 = null;
        }
        if (object2 == null) {
            n10 = 11;
            object2 = object.getDefaultSensor(n10);
        }
        this.orientationSensor = object2;
        super();
        this.scene = object;
        super(this, (SceneRenderer)object);
        super(context, (TouchTracker$Listener)object2, 25.0f);
        this.touchTracker = object;
        context = ((WindowManager)Assertions.checkNotNull((WindowManager)context.getSystemService("window"))).getDefaultDisplay();
        int n12 = 2;
        OrientationListener$Listener[] orientationListener$ListenerArray = new OrientationListener$Listener[n12];
        orientationListener$ListenerArray[0] = object;
        int n13 = 1;
        orientationListener$ListenerArray[n13] = object2;
        this.orientationListener = orientationListener = new OrientationListener((Display)context, orientationListener$ListenerArray);
        this.useSensorRotation = n13;
        this.setEGLContextClientVersion(n12);
        this.setRenderer((GLSurfaceView.Renderer)object2);
        this.setOnTouchListener((View.OnTouchListener)object);
    }

    private /* synthetic */ void a() {
        Surface surface = this.surface;
        if (surface != null) {
            Player$VideoComponent player$VideoComponent = this.videoComponent;
            if (player$VideoComponent != null) {
                player$VideoComponent.clearVideoSurface(surface);
            }
            surface = this.surfaceTexture;
            player$VideoComponent = this.surface;
            SphericalGLSurfaceView.releaseSurface((SurfaceTexture)surface, (Surface)player$VideoComponent);
            surface = null;
            this.surfaceTexture = null;
            this.surface = null;
        }
    }

    public static /* synthetic */ void access$000(SphericalGLSurfaceView sphericalGLSurfaceView, SurfaceTexture surfaceTexture) {
        sphericalGLSurfaceView.onSurfaceTextureAvailable(surfaceTexture);
    }

    private /* synthetic */ void c(SurfaceTexture object) {
        Surface surface;
        SurfaceTexture surfaceTexture = this.surfaceTexture;
        Surface surface2 = this.surface;
        this.surfaceTexture = object;
        this.surface = surface = new Surface((SurfaceTexture)object);
        object = this.videoComponent;
        if (object != null) {
            object.setVideoSurface(surface);
        }
        SphericalGLSurfaceView.releaseSurface(surfaceTexture, surface2);
    }

    private void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture) {
        Handler handler = this.mainHandler;
        c c10 = new c(this, surfaceTexture);
        handler.post((Runnable)c10);
    }

    private static void releaseSurface(SurfaceTexture surfaceTexture, Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    private void updateOrientationListenerRegistration() {
        boolean bl2;
        boolean bl3 = this.useSensorRotation;
        SensorManager sensorManager = null;
        bl3 = bl3 && (bl3 = this.isStarted);
        Object object = this.orientationSensor;
        if (object != null && bl3 != (bl2 = this.isOrientationListenerRegistered)) {
            if (bl3) {
                SensorManager sensorManager2 = this.sensorManager;
                OrientationListener orientationListener = this.orientationListener;
                sensorManager2.registerListener((SensorEventListener)orientationListener, object, 0);
            } else {
                sensorManager = this.sensorManager;
                object = this.orientationListener;
                sensorManager.unregisterListener((SensorEventListener)object);
            }
            this.isOrientationListenerRegistered = bl3;
        }
    }

    public /* synthetic */ void b() {
        this.a();
    }

    public /* synthetic */ void d(SurfaceTexture surfaceTexture) {
        this.c(surfaceTexture);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Handler handler = this.mainHandler;
        b b10 = new b(this);
        handler.post((Runnable)b10);
    }

    public void onPause() {
        this.isStarted = false;
        this.updateOrientationListenerRegistration();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.isStarted = true;
        this.updateOrientationListenerRegistration();
    }

    public void setDefaultStereoMode(int n10) {
        this.scene.setDefaultStereoMode(n10);
    }

    public void setSingleTapListener(SingleTapListener singleTapListener) {
        this.touchTracker.setSingleTapListener(singleTapListener);
    }

    public void setUseSensorRotation(boolean bl2) {
        this.useSensorRotation = bl2;
        this.updateOrientationListenerRegistration();
    }

    public void setVideoComponent(Player$VideoComponent player$VideoComponent) {
        Object object = this.videoComponent;
        if (player$VideoComponent == object) {
            return;
        }
        if (object != null) {
            Object object2 = this.surface;
            if (object2 != null) {
                object.clearVideoSurface((Surface)object2);
            }
            object = this.videoComponent;
            object2 = this.scene;
            object.clearVideoFrameMetadataListener((VideoFrameMetadataListener)object2);
            object = this.videoComponent;
            object2 = this.scene;
            object.clearCameraMotionListener((CameraMotionListener)object2);
        }
        this.videoComponent = player$VideoComponent;
        if (player$VideoComponent != null) {
            object = this.scene;
            player$VideoComponent.setVideoFrameMetadataListener((VideoFrameMetadataListener)object);
            player$VideoComponent = this.videoComponent;
            object = this.scene;
            player$VideoComponent.setCameraMotionListener((CameraMotionListener)object);
            player$VideoComponent = this.videoComponent;
            object = this.surface;
            player$VideoComponent.setVideoSurface((Surface)object);
        }
    }
}

