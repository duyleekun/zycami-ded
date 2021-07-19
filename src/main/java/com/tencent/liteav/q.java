/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.Surface
 *  android.view.TextureView
 */
package com.tencent.liteav;

import android.content.Context;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.basic.a.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.o;
import com.tencent.liteav.h;
import com.tencent.liteav.r;
import com.tencent.rtmp.TXLivePlayer$ITXAudioRawDataListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon$ITXVideoRecordListener;
import java.lang.ref.WeakReference;

public abstract class q {
    public h b = null;
    public Context c = null;
    public TXCloudVideoView d = null;
    public WeakReference e;

    public q(Context context) {
        if (context != null) {
            this.c = context = context.getApplicationContext();
        }
    }

    public int a(String string2) {
        return -1;
    }

    public abstract int a(String var1, int var2);

    public abstract int a(boolean var1);

    public void a() {
        TXCLog.w("TXIPlayer", "pause not support");
    }

    public abstract void a(int var1);

    public void a(int n10, int n11) {
    }

    public void a(Surface surface) {
    }

    public void a(com.tencent.liteav.basic.b.b b10) {
        WeakReference<com.tencent.liteav.basic.b.b> weakReference;
        this.e = weakReference = new WeakReference<com.tencent.liteav.basic.b.b>(b10);
    }

    public abstract void a(o var1);

    public void a(h h10) {
        this.b = h10;
        if (h10 == null) {
            this.b = h10 = new h();
        }
    }

    public void a(r r10, b b10, Object object) {
    }

    public void a(TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener) {
    }

    public void a(TXCloudVideoView tXCloudVideoView) {
        this.d = tXCloudVideoView;
    }

    public void a(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
    }

    public abstract void a(boolean var1, int var2);

    public void b() {
        TXCLog.w("TXIPlayer", "resume not support");
    }

    public void b(float f10) {
        TXCLog.w("TXIPlayer", "rate not implement");
    }

    public abstract void b(int var1);

    public abstract void b(boolean var1);

    public abstract void c(int var1);

    public abstract void c(boolean var1);

    public abstract boolean c();

    public abstract int d(int var1);

    public TextureView d() {
        return null;
    }

    public boolean d(boolean bl2) {
        return false;
    }

    public abstract int e();

    public void e(int n10) {
        TXCLog.w("TXIPlayer", "seek not support");
    }

    public void e(boolean bl2) {
        TXCLog.w("TXIPlayer", "autoPlay not implement");
    }

    public boolean f() {
        return false;
    }

    public void g() {
    }

    public abstract int i();

    public h q() {
        return this.b;
    }
}

