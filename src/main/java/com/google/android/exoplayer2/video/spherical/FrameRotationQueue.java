/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.Matrix
 */
package com.google.android.exoplayer2.video.spherical;

import android.opengl.Matrix;
import com.google.android.exoplayer2.util.TimedValueQueue;

public final class FrameRotationQueue {
    private final float[] recenterMatrix;
    private boolean recenterMatrixComputed;
    private final float[] rotationMatrix;
    private final TimedValueQueue rotations;

    public FrameRotationQueue() {
        int n10 = 16;
        float[] fArray = new float[n10];
        this.recenterMatrix = fArray;
        Object object = new float[n10];
        this.rotationMatrix = object;
        object = new TimedValueQueue;
        this.rotations = object;
    }

    public static void computeRecenterMatrix(float[] fArray, float[] fArray2) {
        float f10;
        float f11;
        Matrix.setIdentityM((float[])fArray, (int)0);
        int n10 = 10;
        float f12 = fArray2[n10];
        float f13 = fArray2[n10];
        f12 *= f13;
        int n11 = 8;
        float f14 = fArray2[n11];
        float f15 = fArray2[n11];
        f12 = (float)Math.sqrt(f12 + (f14 *= f15));
        fArray[0] = f14 = fArray2[n10] / f12;
        fArray[2] = f11 = fArray2[n11] / f12;
        fArray[n11] = f11 = -fArray2[n11] / f12;
        fArray[n10] = f10 = fArray2[n10] / f12;
    }

    private static void getRotationMatrixFromAngleAxis(float[] fArray, float[] fArray2) {
        float f10 = fArray2[0];
        int n10 = 1;
        float f11 = -fArray2[n10];
        int n11 = 2;
        float f12 = -fArray2[n11];
        float f13 = Matrix.length((float)f10, (float)f11, (float)f12);
        float f14 = f13 - 0.0f;
        Object object = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (object != false) {
            double d10 = Math.toDegrees(f13);
            float f15 = (float)d10;
            float f16 = f10 / f13;
            float f17 = f11 / f13;
            float f18 = f12 / f13;
            Matrix.setRotateM((float[])fArray, (int)0, (float)f15, (float)f16, (float)f17, (float)f18);
        } else {
            Matrix.setIdentityM((float[])fArray, (int)0);
        }
    }

    public boolean pollRotationMatrix(float[] fArray, long l10) {
        Object object = this.rotations;
        float[] fArray2 = (float[])((TimedValueQueue)object).pollFloor(l10);
        if (fArray2 == null) {
            return false;
        }
        float[] fArray3 = this.rotationMatrix;
        FrameRotationQueue.getRotationMatrixFromAngleAxis(fArray3, fArray2);
        boolean bl2 = this.recenterMatrixComputed;
        boolean bl3 = true;
        if (!bl2) {
            fArray2 = this.recenterMatrix;
            object = this.rotationMatrix;
            FrameRotationQueue.computeRecenterMatrix(fArray2, (float[])object);
            this.recenterMatrixComputed = bl3;
        }
        float[] fArray4 = this.recenterMatrix;
        float[] fArray5 = this.rotationMatrix;
        Matrix.multiplyMM((float[])fArray, (int)0, (float[])fArray4, (int)0, (float[])fArray5, (int)0);
        return bl3;
    }

    public void reset() {
        this.rotations.clear();
        this.recenterMatrixComputed = false;
    }

    public void setRotation(long l10, float[] fArray) {
        this.rotations.add(l10, fArray);
    }
}

