/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Sensor
 *  android.hardware.SensorEvent
 *  android.hardware.SensorEventListener
 *  android.hardware.SensorManager
 *  android.opengl.Matrix
 *  android.view.Display
 */
package com.google.android.exoplayer2.ui.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import com.google.android.exoplayer2.ui.spherical.OrientationListener$Listener;
import com.google.android.exoplayer2.video.spherical.FrameRotationQueue;

public final class OrientationListener
implements SensorEventListener {
    private final float[] angles;
    private final float[] deviceOrientationMatrix4x4;
    private final Display display;
    private final OrientationListener$Listener[] listeners;
    private final float[] recenterMatrix4x4;
    private boolean recenterMatrixComputed;
    private final float[] tempMatrix4x4;

    public OrientationListener(Display display, OrientationListener$Listener ... orientationListener$ListenerArray) {
        int n10 = 16;
        float[] fArray = new float[n10];
        this.deviceOrientationMatrix4x4 = fArray;
        fArray = new float[n10];
        this.tempMatrix4x4 = fArray;
        float[] fArray2 = new float[n10];
        this.recenterMatrix4x4 = fArray2;
        fArray2 = new float[3];
        this.angles = fArray2;
        this.display = display;
        this.listeners = orientationListener$ListenerArray;
    }

    private float extractRoll(float[] fArray) {
        float[] fArray2 = this.tempMatrix4x4;
        SensorManager.remapCoordinateSystem((float[])fArray, (int)1, (int)131, (float[])fArray2);
        fArray = this.tempMatrix4x4;
        fArray2 = this.angles;
        SensorManager.getOrientation((float[])fArray, (float[])fArray2);
        return this.angles[2];
    }

    private void notifyListeners(float[] fArray, float f10) {
        for (OrientationListener$Listener orientationListener$Listener : this.listeners) {
            orientationListener$Listener.onOrientationChange(fArray, f10);
        }
    }

    private void recenter(float[] fArray) {
        float[] fArray2;
        boolean bl2 = this.recenterMatrixComputed;
        if (!bl2) {
            fArray2 = this.recenterMatrix4x4;
            FrameRotationQueue.computeRecenterMatrix(fArray2, fArray);
            this.recenterMatrixComputed = bl2 = true;
        }
        fArray2 = this.tempMatrix4x4;
        int n10 = fArray2.length;
        System.arraycopy(fArray, 0, fArray2, 0, n10);
        float[] fArray3 = this.tempMatrix4x4;
        float[] fArray4 = this.recenterMatrix4x4;
        Matrix.multiplyMM((float[])fArray, (int)0, (float[])fArray3, (int)0, (float[])fArray4, (int)0);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private void rotateAroundZ(float[] object, int n10) {
        void var2_3;
        if (var2_3 != false) {
            int n11 = 130;
            float f10 = 1.82E-43f;
            int n12 = 129;
            float f11 = 1.81E-43f;
            int n13 = 2;
            float f12 = 2.8E-45f;
            int n14 = 1;
            float f13 = Float.MIN_VALUE;
            if (var2_3 != n14) {
                if (var2_3 != n13) {
                    n12 = 3;
                    f11 = 4.2E-45f;
                    if (var2_3 != n12) {
                        IllegalStateException illegalStateException = new IllegalStateException();
                        throw illegalStateException;
                    }
                    n12 = n14;
                    f11 = f13;
                } else {
                    int n15 = n12;
                    float f14 = f11;
                    n12 = n11;
                    f11 = f10;
                    n11 = n15;
                    f10 = f14;
                }
            } else {
                n11 = n13;
                f10 = f12;
            }
            float[] fArray = this.tempMatrix4x4;
            n13 = fArray.length;
            n14 = 0;
            f13 = 0.0f;
            System.arraycopy(object, 0, fArray, 0, n13);
            fArray = this.tempMatrix4x4;
            SensorManager.remapCoordinateSystem((float[])fArray, (int)n11, (int)n12, (float[])object);
        }
    }

    private static void rotateYtoSky(float[] fArray) {
        Matrix.rotateM((float[])fArray, (int)0, (float)90.0f, (float)1.0f, (float)0.0f, (float)0.0f);
    }

    public void onAccuracyChanged(Sensor sensor, int n10) {
    }

    public void onSensorChanged(SensorEvent object) {
        float[] fArray = this.deviceOrientationMatrix4x4;
        object = object.values;
        SensorManager.getRotationMatrixFromVector((float[])fArray, (float[])object);
        object = this.deviceOrientationMatrix4x4;
        int n10 = this.display.getRotation();
        this.rotateAroundZ((float[])object, n10);
        object = this.deviceOrientationMatrix4x4;
        float f10 = this.extractRoll((float[])object);
        OrientationListener.rotateYtoSky(this.deviceOrientationMatrix4x4);
        fArray = this.deviceOrientationMatrix4x4;
        this.recenter(fArray);
        fArray = this.deviceOrientationMatrix4x4;
        this.notifyListeners(fArray, f10);
    }
}

