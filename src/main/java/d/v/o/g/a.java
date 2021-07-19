/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.v.o.g;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.TXLivePusher$AudioCustomProcessListener;
import com.zhiyun.livepusher.pusher.ImageFormat;
import com.zhiyun.livepusher.pusher.PusherType;
import d.v.o.f.c;
import d.v.o.f.d;
import d.v.o.f.e;
import d.v.o.g.a$a;
import d.v.o.g.a$b;
import d.v.o.g.a$c;

public class a
extends d.v.o.f.a {
    public static final String w = "TencentLivePusher";
    private static int x = 2;
    private final int i;
    private TXLivePusher j;
    private TXLivePushConfig k;
    private boolean l = false;
    private long m = 0L;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 0x100000;
    private HandlerThread r;
    private Handler s;
    private Handler.Callback t;
    private e u;
    private ITXLivePushListener v;

    public a(Context object) {
        super((Context)object);
        this.i = 1;
        Object object2 = new a$a(this);
        this.t = object2;
        this.u = null;
        this.v = object2 = new a$c(this);
        this.j = object2 = new TXLivePusher((Context)object);
        super();
        this.k = object;
        ((TXLivePushConfig)object).setCustomModeType(2);
        object = this.k;
        int n10 = x;
        ((TXLivePushConfig)object).setHardwareAcceleration(n10);
        object = this.j;
        object2 = this.v;
        ((TXLivePusher)object).setPushListener((ITXLivePushListener)object2);
        object = new HandlerThread(w);
        this.r = object;
        object.start();
        object2 = this.r.getLooper();
        Handler.Callback callback = this.t;
        object = new Handler((Looper)object2, callback);
        this.s = object;
    }

    public static /* synthetic */ d A(a a10) {
        return a10.g;
    }

    public static /* synthetic */ int B(int n10) {
        x = n10;
        return n10;
    }

    public static /* synthetic */ TXLivePushConfig C(a a10) {
        return a10.k;
    }

    public static /* synthetic */ TXLivePusher D(a a10) {
        return a10.j;
    }

    public static /* synthetic */ d E(a a10) {
        return a10.g;
    }

    public static /* synthetic */ d F(a a10) {
        return a10.g;
    }

    public static /* synthetic */ long G(a a10) {
        return a10.m;
    }

    public static /* synthetic */ d H(a a10) {
        return a10.g;
    }

    public static /* synthetic */ long I(a a10, long l10) {
        a10.m = l10;
        return l10;
    }

    public static /* synthetic */ int J(a a10) {
        return a10.o;
    }

    public static /* synthetic */ int K(a a10, int n10) {
        a10.o = n10;
        return n10;
    }

    public static /* synthetic */ int L(a a10) {
        return a10.p;
    }

    public static /* synthetic */ int M(a a10, int n10) {
        a10.p = n10;
        return n10;
    }

    public static /* synthetic */ d N(a a10) {
        return a10.g;
    }

    public static /* synthetic */ Handler O(a a10) {
        return a10.s;
    }

    public static /* synthetic */ boolean P(a a10) {
        return a10.l;
    }

    public static /* synthetic */ e Q(a a10) {
        return a10.u;
    }

    public static /* synthetic */ d R(a a10) {
        return a10.g;
    }

    private void S(boolean bl2, int n10, int n11) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Tx user hope width:");
        charSequence.append(n10);
        charSequence.append(" height:");
        charSequence.append(n11);
        charSequence = charSequence.toString();
        String string2 = w;
        Log.i((String)string2, (String)charSequence);
        int n12 = 480;
        int n13 = 640;
        if (n10 == n13 && n11 == n12 || n10 == n12 && n11 == n13) {
            CharSequence charSequence2 = new StringBuilder();
            String string3 = "Tx pushConfig video resolution 480P horizontal:";
            charSequence2.append(string3);
            charSequence2.append(bl2);
            charSequence2 = charSequence2.toString();
            Log.i((String)string2, (String)charSequence2);
            if (!bl2) {
                TXLivePushConfig tXLivePushConfig = this.k;
                n10 = 13;
                tXLivePushConfig.setVideoResolution(n10);
            } else {
                TXLivePushConfig tXLivePushConfig = this.k;
                n10 = 16;
                tXLivePushConfig.setVideoResolution(n10);
            }
            return;
        }
        n12 = 720;
        n13 = 1280;
        if (n10 == n13 && n11 == n12 || n10 == n12 && n11 == n13) {
            CharSequence charSequence3 = new StringBuilder();
            String string4 = "Tx pushConfig video resolution 720P  horizontal:";
            charSequence3.append(string4);
            charSequence3.append(bl2);
            charSequence3 = charSequence3.toString();
            Log.i((String)string2, (String)charSequence3);
            if (!bl2) {
                TXLivePushConfig tXLivePushConfig = this.k;
                n10 = 2;
                tXLivePushConfig.setVideoResolution(n10);
            } else {
                TXLivePushConfig tXLivePushConfig = this.k;
                n10 = 5;
                tXLivePushConfig.setVideoResolution(n10);
            }
            return;
        }
        CharSequence charSequence4 = new StringBuilder();
        String string5 = "Tx pushConfig video resolution 1080P horizontal:";
        charSequence4.append(string5);
        charSequence4.append(bl2);
        charSequence4 = charSequence4.toString();
        Log.i((String)string2, (String)charSequence4);
        if (!bl2) {
            TXLivePushConfig tXLivePushConfig = this.k;
            n10 = 30;
            tXLivePushConfig.setVideoResolution(n10);
        } else {
            TXLivePushConfig tXLivePushConfig = this.k;
            n10 = 31;
            tXLivePushConfig.setVideoResolution(n10);
        }
    }

    private void T() {
        Handler handler;
        boolean bl2 = this.l;
        if (bl2 && (handler = this.s) != null) {
            handler.removeCallbacksAndMessages(null);
            handler = this.s;
            int n10 = 1;
            handler.sendEmptyMessage(n10);
        }
    }

    private void U() {
        Handler handler = this.s;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    private boolean V(String object) {
        Object object2;
        int n10 = TextUtils.isEmpty((CharSequence)object);
        String string2 = w;
        boolean bl2 = false;
        if (n10 != 0) {
            Log.e((String)string2, (String)"TencentLivePusher txStartPush , pushUrl can not be null or empty . ");
            return false;
        }
        object = this.j;
        if (object == null) {
            Log.e((String)string2, (String)"TencentLivePusher txStartPush , mLivePusher can not be null .");
            return false;
        }
        object = this.k;
        boolean bl3 = true;
        if (object != null) {
            int n11;
            int n12 = this.d;
            int n13 = 3;
            if (n12 != 0 && n12 != (n11 = 180)) {
                ((TXLivePushConfig)object).setHomeOrientation(n13);
                object = this.e;
                n10 = ((c)object).g();
                object2 = this.e;
                n12 = ((c)object2).f();
                this.S(false, n10, n12);
            } else {
                ((TXLivePushConfig)object).setHomeOrientation(n13);
                object = this.e;
                n10 = ((c)object).g();
                object2 = this.e;
                n12 = ((c)object2).f();
                this.S(bl3, n10, n12);
            }
            object = this.k;
            ((TXLivePushConfig)object).setAutoAdjustBitrate(bl3);
        }
        object = this.j;
        object2 = new a$b(this);
        ((TXLivePusher)object).setAudioProcessListener((TXLivePusher$AudioCustomProcessListener)object2);
        object = this.j;
        object2 = this.k;
        ((TXLivePusher)object).setConfig((TXLivePushConfig)object2);
        object = this.j;
        object2 = this.f;
        n10 = ((TXLivePusher)object).startPusher((String)object2);
        if (n10 != 0) {
            bl3 = false;
            string2 = null;
        }
        if (bl3) {
            bl2 = bl3;
        }
        this.l = bl2;
        this.T();
        return bl3;
    }

    public static /* synthetic */ d t(a a10) {
        return a10.g;
    }

    public static /* synthetic */ int u(a a10) {
        return a10.n;
    }

    public static /* synthetic */ d v(a a10) {
        return a10.g;
    }

    public static /* synthetic */ int w(a a10, int n10) {
        a10.n = n10;
        return n10;
    }

    public static /* synthetic */ d x(a a10) {
        return a10.g;
    }

    public static /* synthetic */ d y(a a10) {
        return a10.g;
    }

    public static /* synthetic */ d z(a a10) {
        return a10.g;
    }

    public void a() {
        boolean bl2 = this.l;
        String string2 = w;
        if (bl2) {
            Log.i((String)string2, (String)"Tx Pusher stopPush.");
            Object object = this.j;
            if (object != null) {
                long l10;
                ((TXLivePusher)object).stopPusher();
                bl2 = false;
                object = null;
                this.l = false;
                this.m = l10 = 0L;
            }
            this.U();
            object = this.g;
            if (object != null) {
                object.d();
            }
        } else {
            String string3 = "Tx Pusher stopPush. please startPush first.";
            Log.i((String)string2, (String)string3);
        }
    }

    public void b(boolean bl2) {
        TXLivePusher tXLivePusher = this.j;
        if (tXLivePusher != null) {
            tXLivePusher.setMute(bl2);
        }
    }

    public boolean e() {
        String string2 = this.f;
        return this.V(string2);
    }

    public boolean f(byte[] byArray, ImageFormat object, int n10, int n11) {
        int n12 = this.l;
        boolean bl2 = false;
        String string2 = w;
        if (n12 == 0) {
            Log.e((String)string2, (String)"Tx please start push first.");
            return false;
        }
        if (byArray != null && (n12 = byArray.length) != 0) {
            int n13;
            ImageFormat imageFormat = ImageFormat.YUV420P;
            int n14 = 3;
            if (object != imageFormat && object == (imageFormat = ImageFormat.RGB_RGBA)) {
                n14 = 5;
            }
            if ((n13 = ((TXLivePusher)(object = this.j)).sendCustomVideoData(byArray, n14, n10, n11)) != 0) {
                object = new StringBuilder();
                String string3 = "Tx sendCustomVideoData fail: ";
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append(n13);
                object = ((StringBuilder)object).toString();
                Log.e((String)string2, (String)object);
            }
            if (n13 == 0) {
                bl2 = true;
            }
            return bl2;
        }
        Log.e((String)string2, (String)"Tx sendVideoFrame video data can not be null or empty.");
        return false;
    }

    public boolean g(int n10, int n11, int n12) {
        boolean bl2 = this.l;
        boolean bl3 = false;
        if (!bl2) {
            Log.e((String)w, (String)"Tx please start push first.");
            return false;
        }
        TXLivePusher tXLivePusher = this.j;
        if (tXLivePusher != null && (n10 = tXLivePusher.sendCustomVideoTexture(n10, n11, n12)) == 0) {
            bl3 = true;
        }
        return bl3;
    }

    public void h(e e10) {
        this.u = e10;
    }

    public boolean i(String string2) {
        this.f = string2;
        return this.V(string2);
    }

    public PusherType j() {
        return PusherType.TENCENT_PUSHER;
    }

    public void l() {
    }

    public void m(c c10) {
        super.m(c10);
        if (c10 != null) {
            TXLivePushConfig tXLivePushConfig = this.k;
            int n10 = c10.e();
            n10 = n10 <= 0 ? 5 : c10.e();
            tXLivePushConfig.setVideoEncodeGop(n10);
            int n11 = c10.i();
            if (n11 > 0) {
                tXLivePushConfig = this.k;
                n10 = c10.i();
                tXLivePushConfig.setVideoFPS(n10);
            }
            if ((n11 = c10.h()) > 0) {
                tXLivePushConfig = this.k;
                n10 = c10.h();
                tXLivePushConfig.setVideoBitrate(n10);
            }
            if ((n11 = c10.c()) > 0) {
                tXLivePushConfig = this.k;
                n10 = c10.c();
                tXLivePushConfig.setAudioChannels(n10);
            }
            if ((n11 = c10.d()) > 0) {
                tXLivePushConfig = this.k;
                int n12 = c10.d();
                tXLivePushConfig.setAudioSampleRate(n12);
            }
        }
    }

    public void n(byte[] byArray) {
        int n10 = this.l;
        String string2 = w;
        if (n10 == 0) {
            Log.e((String)string2, (String)"Tx please start push first.");
            return;
        }
        if (byArray != null && (n10 = byArray.length) != 0) {
            this.j.sendCustomPCMData(byArray);
            return;
        }
        Log.e((String)string2, (String)"pcmData can not be null or length can not be  zero.");
    }

    public void o() {
    }

    public ImageFormat[] p() {
        ImageFormat imageFormat = ImageFormat.YUV420P;
        imageFormat = ImageFormat.RGB_RGBA;
        ImageFormat[] imageFormatArray = new ImageFormat[]{imageFormat, imageFormat};
        return imageFormatArray;
    }

    public void release() {
        super.release();
        this.a();
        Handler handler = this.s;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.s = null;
        }
        if ((handler = this.r) != null) {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 18;
            if (n10 >= n11) {
                handler.quitSafely();
            } else {
                handler.quit();
            }
            this.r = null;
        }
    }
}

