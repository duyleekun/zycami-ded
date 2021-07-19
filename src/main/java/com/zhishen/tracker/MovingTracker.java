/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  android.graphics.Bitmap
 *  android.graphics.PointF
 *  android.graphics.RectF
 *  android.util.Log
 */
package com.zhishen.tracker;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import com.zhishen.tracker.MovingTracker$TrackerType;
import java.util.ArrayList;
import org.opencv.android.Utils;
import org.opencv.core.Mat;

public class MovingTracker {
    private static String c = "com.zhiyun.tracker.MovingTracker";
    public final long a;
    public boolean b = false;

    static {
        System.loadLibrary("tracker");
        String string2 = c;
        String string3 = MovingTracker.info();
        Log.d((String)string2, (String)string3);
    }

    public MovingTracker() {
        long l10;
        this.a = l10 = MovingTracker.n_MovingTracker(MovingTracker$TrackerType.cmt.value());
    }

    public MovingTracker(long l10) {
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 != false) {
            this.a = l10;
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Native object address is NULL");
        throw unsupportedOperationException;
    }

    public MovingTracker(MovingTracker$TrackerType movingTracker$TrackerType) {
        long l10;
        this.a = l10 = MovingTracker.n_MovingTracker(movingTracker$TrackerType.value());
    }

    private static native float[] getBoundingBox(long var0);

    private static native float[] getMotionCompensation(long var0);

    private static native void getTargetList(long var0, long var2, ArrayList var4);

    private static native String info();

    public static native void initResource(AssetManager var0);

    private static native long n_MovingTracker(long var0);

    private static native void processImage(long var0, long var2);

    private static native void setTrackingRange(long var0, float var2, float var3, float var4, float var5);

    private static native void setTrackingTargets(long var0, ArrayList var2);

    private static native void start(long var0);

    private static native void stop(long var0);

    public RectF a() {
        float[] fArray = MovingTracker.getBoundingBox(this.a);
        float f10 = fArray[0];
        int n10 = 1;
        float f11 = fArray[n10];
        float f12 = fArray[0];
        float f13 = fArray[2];
        float f14 = fArray[n10];
        float f15 = fArray[3];
        RectF rectF = new RectF(f10, f11, f12 += f13, f14 += f15);
        return rectF;
    }

    public Bitmap b() {
        return null;
    }

    public PointF c() {
        float[] fArray = MovingTracker.getMotionCompensation(this.a);
        float f10 = fArray[0];
        float f11 = fArray[1];
        PointF pointF = new PointF(f10, f11);
        return pointF;
    }

    public void d(Bitmap bitmap, ArrayList arrayList) {
        Mat mat = new Mat();
        Utils.a(bitmap, mat);
        long l10 = this.a;
        long l11 = mat.V();
        MovingTracker.getTargetList(l10, l11, arrayList);
    }

    public void e(Bitmap bitmap) {
        Mat mat = new Mat();
        Utils.a(bitmap, mat);
        long l10 = this.a;
        long l11 = mat.V();
        MovingTracker.processImage(l10, l11);
        boolean bl2 = this.b;
        if (bl2) {
            Utils.g(mat, bitmap);
        }
        mat.u0();
    }

    public void f(ArrayList arrayList) {
        MovingTracker.setTrackingTargets(this.a, arrayList);
    }

    public void g(RectF rectF) {
        long l10 = this.a;
        float f10 = rectF.left;
        float f11 = rectF.top;
        float f12 = rectF.width();
        float f13 = rectF.height();
        MovingTracker.setTrackingRange(l10, f10, f11, f12, f13);
        MovingTracker.start(this.a);
    }

    public void h() {
        MovingTracker.stop(this.a);
    }
}

