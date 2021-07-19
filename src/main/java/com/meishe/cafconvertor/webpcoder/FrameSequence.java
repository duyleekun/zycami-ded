/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.util.Log
 */
package com.meishe.cafconvertor.webpcoder;

import android.graphics.Bitmap;
import android.util.Log;
import com.meishe.cafconvertor.webpcoder.FrameSequence$a;

public class FrameSequence {
    private long a;
    private int b;

    static {
        System.loadLibrary("nvs-webp");
    }

    public FrameSequence() {
    }

    public FrameSequence(long l10) {
        this.a = l10;
    }

    public static /* synthetic */ long a(long l10, int n10, Bitmap bitmap, int n11) {
        return FrameSequence.nativeGetFrame(l10, n10, bitmap, n11);
    }

    public static /* synthetic */ void c(long l10) {
        FrameSequence.nativeDestroyState(l10);
    }

    public static FrameSequence d(byte[] byArray) {
        int n10 = byArray.length;
        long l10 = FrameSequence.nativeDecodeByteArray(byArray, 0, n10);
        FrameSequence frameSequence = new FrameSequence(l10);
        return frameSequence;
    }

    public static FrameSequence e(byte[] object, int n10, int n11) {
        if (object != null) {
            int n12;
            int n13;
            if (n10 >= 0 && n11 >= 0 && (n13 = n10 + n11) <= (n12 = ((byte[])object).length)) {
                long l10 = FrameSequence.nativeDecodeByteArray(object, n10, n11);
                FrameSequence frameSequence = new FrameSequence(l10);
                return frameSequence;
            }
            object = new IllegalArgumentException;
            object("invalid offset/length parameters");
            throw object;
        }
        object = new IllegalArgumentException;
        object();
        throw object;
    }

    private static native int getFrameCount(long var0);

    private static native int getHeight(long var0);

    private static native int getWidth(long var0);

    private static native boolean isOpaque(long var0);

    private static native long nativeCreateState(long var0);

    private static native long nativeDecodeByteArray(byte[] var0, int var1, int var2);

    public static native void nativeDestroyFrameSequence(long var0);

    private static native void nativeDestroyState(long var0);

    private static native long nativeGetFrame(long var0, int var2, Bitmap var3, int var4);

    public FrameSequence$a b() {
        long l10 = this.a;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            long l13 = (l10 = FrameSequence.nativeCreateState(l10)) - l11;
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 == false) {
                return null;
            }
            FrameSequence$a frameSequence$a = new FrameSequence$a(l10);
            return frameSequence$a;
        }
        IllegalStateException illegalStateException = new IllegalStateException("attempted to use incorrectly built FrameSequence");
        throw illegalStateException;
    }

    public void f() {
        long l10 = this.a;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            FrameSequence.nativeDestroyFrameSequence(l10);
        }
    }

    public void finalize() {
        block4: {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("finalize: mNativeFrameSequence is ");
            long l10 = this.a;
            charSequence.append(l10);
            charSequence = charSequence.toString();
            String string2 = "FrameSequence";
            Log.d((String)string2, (String)charSequence);
            long l11 = this.a;
            long l12 = 0L;
            long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (l13 == false) break block4;
            FrameSequence.nativeDestroyFrameSequence(l11);
        }
        return;
        finally {
            super.finalize();
        }
    }

    public int g() {
        return this.b;
    }

    public int h() {
        return FrameSequence.getFrameCount(this.a);
    }

    public int i() {
        return FrameSequence.getHeight(this.a);
    }

    public int j() {
        return FrameSequence.getWidth(this.a);
    }

    public boolean k() {
        return FrameSequence.isOpaque(this.a);
    }

    public void l(int n10) {
        this.b = n10;
    }
}

