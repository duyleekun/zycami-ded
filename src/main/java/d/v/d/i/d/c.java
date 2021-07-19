/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 */
package d.v.d.i.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import d.v.d.h.f;
import d.v.d.i.d.a;

public class c
extends d.v.d.i.a.a {
    private int h;
    private int i;
    private int j;
    private final Handler k;

    public c() {
        Handler handler;
        HandlerThread handlerThread = new HandlerThread("pcm");
        handlerThread.start();
        handlerThread = handlerThread.getLooper();
        this.k = handler = new Handler((Looper)handlerThread);
    }

    private /* synthetic */ void r(byte[] byArray) {
        c.super.set(byArray);
    }

    public void b() {
        super.b();
        this.k.getLooper().quitSafely();
    }

    public int o() {
        return this.j;
    }

    public int p() {
        return this.i;
    }

    public int q() {
        return this.h;
    }

    public /* synthetic */ void s(byte[] byArray) {
        this.r(byArray);
    }

    public void t(byte[] byArray) {
        if (byArray == null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("pcm set bytes=");
        int n10 = byArray.length;
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        stringBuilder = this.k;
        a a10 = new a(this, byArray);
        stringBuilder.post(a10);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LivePcm{mSampleRate=");
        int n10 = this.h;
        stringBuilder.append(n10);
        stringBuilder.append(", mChannels=");
        n10 = this.i;
        stringBuilder.append(n10);
        stringBuilder.append(", mBits=");
        n10 = this.j;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void u(int n10) {
        this.j = n10;
    }

    public void v(int n10) {
        this.i = n10;
    }

    public void w(int n10) {
        this.h = n10;
    }
}

