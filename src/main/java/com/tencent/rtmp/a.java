/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.opengl.EGLContext
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.view.Surface
 *  javax.microedition.khronos.egl.EGLContext
 *  org.json.JSONObject
 */
package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.o;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.h;
import com.tencent.liteav.j;
import com.tencent.liteav.q;
import com.tencent.liteav.r;
import com.tencent.liteav.s;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.rtmp.TXLivePlayer$ITXAudioRawDataListener;
import com.tencent.rtmp.TXLivePlayer$ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePlayer$ITXLivePlayVideoRenderListener;
import com.tencent.rtmp.TXLivePlayer$ITXSnapshotListener;
import com.tencent.rtmp.TXLivePlayer$ITXVideoRawDataListener;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.a$1;
import com.tencent.rtmp.a$2;
import com.tencent.rtmp.a$3;
import com.tencent.rtmp.a$4;
import com.tencent.rtmp.a$5;
import com.tencent.rtmp.a$a;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon$ITXVideoRecordListener;
import java.util.Vector;
import javax.microedition.khronos.egl.EGLContext;
import org.json.JSONObject;

public class a
implements b {
    private String A;
    private int B;
    private Vector C;
    private long D;
    private TXLivePlayer$ITXAudioVolumeEvaluationListener E;
    private int F;
    private long G;
    private String H;
    private int I;
    private a$a J;
    private TXLivePlayer$ITXAudioRawDataListener K;
    private TXCloudVideoView a;
    private Surface b;
    private int c;
    private int d;
    private ITXLivePlayListener e;
    private TXLivePlayConfig f;
    private boolean g = false;
    private boolean h;
    private int i;
    private int j;
    private String k;
    private boolean l;
    private int m;
    private TXLivePlayer$ITXVideoRawDataListener n;
    private byte[] o;
    private Object p;
    private TXLivePlayer$ITXLivePlayVideoRenderListener q;
    private Context r;
    private Handler s;
    private q t;
    private boolean u;
    private float v;
    private boolean w;
    private j x;
    private boolean y;
    private long z;

    public a(Context context) {
        Vector vector;
        boolean bl2;
        this.h = bl2 = true;
        this.k = "";
        this.l = false;
        this.m = 100;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.u = bl2;
        this.v = 1.0f;
        this.w = false;
        this.B = -1;
        this.C = vector = new Vector();
        this.D = 0L;
        this.E = null;
        this.F = 0;
        this.J = null;
        this.e = null;
        this.r = context = context.getApplicationContext();
        TXCCommonUtil.setAppContext(context);
        TXCLog.init();
        Looper looper = Looper.getMainLooper();
        super(looper);
        this.s = context;
        TXCCommonUtil.setAppContext(this.r);
        TXCLog.init();
    }

    public static /* synthetic */ long a(a a10, long l10) {
        a10.z = l10;
        return l10;
    }

    public static /* synthetic */ q a(a a10) {
        return a10.t;
    }

    private String a(Bundle object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" IP:");
        String string2 = object.getString("SERVER_IP");
        stringBuilder.append(string2);
        stringBuilder.append(" RES:");
        int n10 = object.getInt("VIDEO_WIDTH");
        stringBuilder.append(n10);
        stringBuilder.append("*");
        n10 = object.getInt("VIDEO_HEIGHT");
        stringBuilder.append(n10);
        stringBuilder.append(" FPS:");
        n10 = object.getInt("VIDEO_FPS");
        stringBuilder.append(n10);
        stringBuilder.append(" GOP:");
        n10 = object.getInt("VIDEO_GOP");
        stringBuilder.append(n10);
        stringBuilder.append("s Speed:");
        n10 = object.getInt("NET_SPEED");
        stringBuilder.append(n10);
        stringBuilder.append("Kbps AudioSpeed:");
        n10 = object.getInt("AUDIO_BITRATE");
        stringBuilder.append(n10);
        stringBuilder.append("Kbps VideoSpeed:");
        n10 = object.getInt("VIDEO_BITRATE");
        stringBuilder.append(n10);
        stringBuilder.append("Kbps AudioCache:");
        n10 = object.getInt("AUDIO_CACHE");
        stringBuilder.append(n10);
        stringBuilder.append(" VideoCache:");
        n10 = object.getInt("VIDEO_CACHE");
        stringBuilder.append(n10);
        stringBuilder.append(" VideoCacheFrameCount:");
        n10 = object.getInt("V_SUM_CACHE_SIZE");
        stringBuilder.append(n10);
        stringBuilder.append(" VideoDecoderCacheFrameCount:");
        n10 = object.getInt("V_DEC_CACHE_SIZE");
        stringBuilder.append(n10);
        stringBuilder.append(" AVJitterSync:");
        n10 = object.getInt("AV_RECV_INTERVAL");
        stringBuilder.append(n10);
        stringBuilder.append(" AVPlaySync:");
        n10 = object.getInt("AV_PLAY_INTERVAL");
        stringBuilder.append(n10);
        stringBuilder.append(" AudioParamsInfo:");
        object = object.getString("AUDIO_PLAY_INFO");
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    private void a(int n10, Bundle object) {
        int n11 = 15001;
        if (n10 == n11 && object != null) {
            String string2;
            this.H = string2 = this.a((Bundle)object);
            string2 = "AUDIO_CACHE";
            Object var5_6 = null;
            n10 = object.getInt(string2, 0);
            String string3 = "NET_SPEED";
            int n12 = object.getInt(string3, 0);
            n11 = object.getInt("VIDEO_FPS", 0);
            String string4 = "AV_RECV_INTERVAL";
            int n13 = object.getInt(string4);
            String string5 = "AV_PLAY_INTERVAL";
            int n14 = object.getInt(string5);
            int n15 = this.I;
            if (n15 > n10 || n12 < (n10 = 10) || n11 < (n10 = 3) || (n10 = Math.abs(n13)) > (n11 = 5000) || (n10 = Math.abs(n14)) > n11) {
                this.h();
            }
        } else {
            n11 = 2007;
            if (n10 == n11 || n10 == (n11 = 2105)) {
                StringBuilder stringBuilder = new StringBuilder();
                String string6 = "[Event]code:";
                stringBuilder.append(string6);
                stringBuilder.append(n10);
                stringBuilder.append(" param:");
                stringBuilder.append(object);
                String string7 = stringBuilder.toString();
                object = "TXLivePlayer";
                TXCLog.i((String)object, string7);
                this.h();
            }
        }
    }

    private void a(TXLivePlayer$ITXSnapshotListener tXLivePlayer$ITXSnapshotListener, Bitmap bitmap) {
        if (tXLivePlayer$ITXSnapshotListener == null) {
            return;
        }
        Object object = Looper.getMainLooper();
        Handler handler = new Handler(object);
        object = new a$5(this, tXLivePlayer$ITXSnapshotListener, bitmap);
        handler.post((Runnable)object);
    }

    public static /* synthetic */ void a(a a10, TXLivePlayer$ITXSnapshotListener tXLivePlayer$ITXSnapshotListener, Bitmap bitmap) {
        a10.a(tXLivePlayer$ITXSnapshotListener, bitmap);
    }

    public static /* synthetic */ boolean a(a a10, boolean bl2) {
        a10.w = bl2;
        return bl2;
    }

    public static /* synthetic */ byte[] a(a a10, byte[] byArray) {
        a10.o = byArray;
        return byArray;
    }

    public static /* synthetic */ TXLivePlayer$ITXAudioVolumeEvaluationListener b(a a10) {
        return a10.E;
    }

    public static /* synthetic */ Handler c(a a10) {
        return a10.s;
    }

    private String c(String string2, int n10) {
        int n11 = 6;
        if (n10 != n11) {
            Object object = "UTF-8";
            object = string2.getBytes((String)object);
            int n12 = ((Object)object).length;
            CharSequence charSequence = new StringBuilder(n12);
            n12 = 0;
            String string3 = null;
            int n13 = 0;
            while (true) {
                char c10;
                block21: {
                    block20: {
                        c10 = ((Object)object).length;
                        if (n13 >= c10) break;
                        c10 = (char)object[n13];
                        if (c10 >= 0) break block20;
                        c10 = (char)(object[n13] + 256);
                        break block21;
                    }
                    c10 = (char)object[n13];
                }
                char c11 = ' ';
                if (c10 > c11 && c10 < (c11 = '\u007f') && c10 != (c11 = '\"') && c10 != (c11 = '%') && c10 != (c11 = '<') && c10 != (c11 = '>') && c10 != (c11 = '[') && c10 != (c11 = '}') && c10 != (c11 = '\\') && c10 != (c11 = ']') && c10 != (c11 = '^') && c10 != (c11 = '`') && c10 != (c11 = '{') && c10 != (c11 = '|')) {
                    c10 = c10;
                    ((StringBuilder)charSequence).append(c10);
                } else {
                    String string4 = "%%%02X";
                    int n14 = 1;
                    Object[] objectArray = new Object[n14];
                    Object object2 = (int)c10;
                    objectArray[0] = object2;
                    object2 = String.format(string4, objectArray);
                    ((StringBuilder)charSequence).append((String)object2);
                }
                ++n13;
            }
            try {
                string2 = ((StringBuilder)charSequence).toString();
            }
            catch (Exception exception) {
                charSequence = "TXLivePlayer";
                string3 = "check play url failed.";
                TXCLog.e((String)charSequence, string3, exception);
            }
        }
        return string2.trim();
    }

    public static /* synthetic */ a$a d(a a10) {
        return a10.J;
    }

    public static /* synthetic */ TXLivePlayer$ITXLivePlayVideoRenderListener e(a a10) {
        return a10.q;
    }

    private void f() {
        Object object = this.t;
        if (object != null) {
            int n10 = this.F;
            int n11 = n10 > 0 ? 1 : 0;
            ((q)object).a(n11 != 0, n10);
            int n12 = this.F;
            if (n12 > 0) {
                a$a a$a;
                object = this.J;
                if (object == null) {
                    n10 = 0;
                    a$a = null;
                    this.J = object = new a$a(this, null);
                }
                object = this.J;
                n10 = this.F;
                ((a$a)object).a(n10);
                object = this.s;
                if (object != null) {
                    a$a = this.J;
                    object.removeCallbacks((Runnable)a$a);
                    object = this.s;
                    a$a = this.J;
                    n11 = this.F;
                    long l10 = n11;
                    object.postDelayed((Runnable)a$a, l10);
                }
            }
        }
    }

    public static /* synthetic */ byte[] f(a a10) {
        return a10.o;
    }

    public static /* synthetic */ TXLivePlayer$ITXVideoRawDataListener g(a a10) {
        return a10.n;
    }

    private void g() {
        q q10 = this.t;
        if (q10 != null) {
            q10.a(false, 0);
        }
        if ((q10 = this.s) != null) {
            a$a a$a = this.J;
            q10.removeCallbacks(a$a);
        }
        this.J = null;
        this.F = 0;
    }

    private void h() {
        long l10 = System.currentTimeMillis();
        long l11 = this.G;
        long l12 = 3000L;
        long l13 = (l11 = l10 - l11) - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object > 0) {
            this.G = l10;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("[Statistics]play:");
            int n10 = this.hashCode();
            charSequence.append(n10);
            charSequence.append(" statistics:");
            String string2 = this.H;
            charSequence.append(string2);
            charSequence = charSequence.toString();
            string2 = "TXLivePlayer";
            TXCLog.i(string2, (String)charSequence);
        }
    }

    private boolean i() {
        String string2 = Build.MANUFACTURER;
        String string3 = "HUAWEI";
        boolean bl2 = string2.equalsIgnoreCase(string3);
        return bl2 && (bl2 = (string2 = Build.MODEL).equalsIgnoreCase(string3 = "Che2-TL00"));
    }

    public int a(TXLivePlayer$ITXLivePlayVideoRenderListener object, Object object2) {
        Object object3 = "TXLivePlayer";
        if (object2 != null) {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 17;
            int n12 = -1;
            String string2 = "[API] setVideoRenderListener error when glContext error ";
            if (n10 >= n11) {
                n10 = object2 instanceof EGLContext;
                if (n10 == 0 && (n10 = object2 instanceof android.opengl.EGLContext) == 0) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append(object2);
                    object = ((StringBuilder)object).toString();
                    TXCLog.w((String)object3, (String)object);
                    return n12;
                }
            } else {
                n10 = object2 instanceof EGLContext;
                if (n10 == 0) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append(object2);
                    object = ((StringBuilder)object).toString();
                    TXCLog.w((String)object3, (String)object);
                    return n12;
                }
            }
        }
        Object object4 = new StringBuilder();
        object4.append("[API] setVideoRenderListener ");
        object4.append(object);
        String string3 = ", context ";
        object4.append(string3);
        object4.append(object2);
        object4 = object4.toString();
        TXCLog.i((String)object3, (String)object4);
        this.p = object2;
        this.q = object;
        object3 = this.t;
        if (object3 != null) {
            if (object != null) {
                object = new a$2(this);
                object4 = com.tencent.liteav.basic.a.b.c;
                ((q)object3).a((r)object, (com.tencent.liteav.basic.a.b)((Object)object4), object2);
            } else {
                object = com.tencent.liteav.basic.a.b.a;
                object2 = null;
                ((q)object3).a(null, (com.tencent.liteav.basic.a.b)((Object)object), null);
            }
        }
        return 0;
    }

    public int a(String string2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[SwitchStream][API] switchStream url:");
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        String string3 = "TXLivePlayer";
        TXCLog.i(string3, (String)object);
        object = this.t;
        if (object != null) {
            return ((q)object).a(string2);
        }
        return -1;
    }

    public int a(String object, int n10) {
        Object object2;
        CharSequence charSequence;
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("[API] startPlay ");
        ((StringBuilder)object3).append(this);
        object3 = ((StringBuilder)object3).toString();
        String string2 = "TXLivePlayer";
        TXCLog.i(string2, (String)object3);
        boolean n11 = TextUtils.isEmpty((CharSequence)object);
        int n12 = -1;
        if (n11) {
            object = new StringBuilder();
            ((StringBuilder)object).append("start play error when url is empty ");
            ((StringBuilder)object).append(this);
            object = ((StringBuilder)object).toString();
            TXCLog.e(string2, (String)object);
            return n12;
        }
        object3 = this.k;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object3);
        if (!bl2) {
            boolean bl3;
            object3 = this.k;
            boolean bl4 = ((String)object3).equalsIgnoreCase((String)object);
            if (bl4 && (bl3 = this.a())) {
                object = new StringBuilder();
                String string3 = "start play error when new url is the same with old url  ";
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append(this);
                object = ((StringBuilder)object).toString();
                TXCLog.e(string2, (String)object);
                int n13 = this.y;
                if (n13 != 0) {
                    n13 = 2004;
                    string3 = new Bundle();
                    this.onNotifyEvent(n13, (Bundle)string3);
                }
                if ((n13 = (int)(this.y ? 1 : 0)) != 0) {
                    n12 = 0;
                }
                return n12;
            }
            object3 = new StringBuilder();
            charSequence = " stop old play when new url is not the same with old url  ";
            ((StringBuilder)object3).append((String)charSequence);
            ((StringBuilder)object3).append(this);
            object3 = ((StringBuilder)object3).toString();
            TXCLog.w(string2, (String)object3);
            object3 = this.t;
            if (object3 != null) {
                ((q)object3).a(false);
            }
            this.k = object3 = "";
        }
        TXCDRApi.initCrashReport(this.r);
        object3 = "[API] ===========================================================================================================================================================";
        TXCLog.i(string2, (String)object3);
        TXCLog.i(string2, (String)object3);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("[API] =====  StartPlay url = ");
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(" playType = ");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append(" DeviceName = ");
        String string4 = com.tencent.liteav.basic.util.g.c();
        ((StringBuilder)charSequence).append(string4);
        ((StringBuilder)charSequence).append(" SDKVersion = ");
        int n14 = TXCCommonUtil.getSDKID();
        ((StringBuilder)charSequence).append(n14);
        ((StringBuilder)charSequence).append(" , ");
        string4 = TXCCommonUtil.getSDKVersionStr();
        ((StringBuilder)charSequence).append(string4);
        string4 = "    ======";
        ((StringBuilder)charSequence).append(string4);
        charSequence = ((StringBuilder)charSequence).toString();
        TXCLog.i(string2, (String)charSequence);
        TXCLog.i(string2, (String)object3);
        TXCLog.i(string2, (String)object3);
        int n15 = this.B;
        if (n15 == n12 || n15 != n10) {
            this.t = object3 = com.tencent.liteav.s.a(this.r, n10);
        }
        this.B = n10;
        object3 = this.t;
        if (object3 == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("liteav_api startPlay create palyer failed");
            ((StringBuilder)object).append(this);
            object = ((StringBuilder)object).toString();
            TXCLog.i(string2, (String)object);
            return -2;
        }
        this.k = object = this.c((String)object, n10);
        object = this.f;
        this.a((TXLivePlayConfig)object);
        object = this.a;
        if (object != null) {
            ((TXCloudVideoView)((Object)object)).clearLog();
            object = this.a;
            object.setVisibility(0);
        }
        object = this.t;
        object3 = this.a;
        ((q)object).a((TXCloudVideoView)((Object)object3));
        this.t.a(this);
        object = this.t;
        boolean bl5 = this.u;
        ((q)object).e(bl5);
        object = this.b;
        if (object != null) {
            object3 = this.t;
            ((q)object3).a((Surface)object);
            object = this.t;
            int n16 = this.c;
            int n17 = this.d;
            ((q)object).a(n16, n17);
        }
        object = this.t;
        object3 = this.k;
        ((q)object).a((String)object3, n10);
        object = this.t;
        n10 = (int)(this.l ? 1 : 0);
        ((q)object).b(n10 != 0);
        object = this.t;
        n10 = this.m;
        ((q)object).c(n10);
        object = this.t;
        float f10 = this.v;
        ((q)object).b(f10);
        object = this.t;
        n10 = this.j;
        ((q)object).b(n10);
        object = this.t;
        n10 = this.i;
        ((q)object).a(n10);
        object = this.t;
        Object object4 = this.K;
        ((q)object).a((TXLivePlayer$ITXAudioRawDataListener)object4);
        object = this.n;
        if (object != null) {
            this.a((TXLivePlayer$ITXVideoRawDataListener)object);
        }
        if ((object = this.q) != null) {
            object4 = this.p;
            this.a((TXLivePlayer$ITXLivePlayVideoRenderListener)object, object4);
        }
        if ((object2 = ((q)(object = this.t)).f()) != 0) {
            this.A = object = this.k;
            object = this.x;
            long l10 = 0L;
            long l11 = object != null ? ((j)object).a() : l10;
            this.z = l11;
            object2 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
            if (object2 > 0) {
                object = this.t;
                ((q)object).g();
            }
        }
        this.f();
        return 0;
    }

    public int a(boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[API] stopPlay ");
        ((StringBuilder)object).append(bl2);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(this);
        object = ((StringBuilder)object).toString();
        String string2 = "TXLivePlayer";
        TXCLog.i(string2, (String)object);
        if (bl2 && (object = this.a) != null) {
            int n10 = 8;
            object.setVisibility(n10);
        }
        this.g();
        object = this.t;
        if (object != null) {
            ((q)object).a(bl2);
        }
        this.k = "";
        this.z = 0L;
        this.x = null;
        this.y = false;
        return 0;
    }

    public void a(float f10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[API] setRate ");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXLivePlayer";
        TXCLog.i(string2, (String)object);
        this.v = f10;
        object = this.t;
        if (object != null) {
            ((q)object).b(f10);
        }
    }

    public void a(int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[API] setRenderMode ");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXLivePlayer";
        TXCLog.i(string2, (String)object);
        this.i = n10;
        object = this.t;
        if (object != null) {
            ((q)object).a(n10);
        }
    }

    public void a(int n10, int n11) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[API] setSurfaceSize ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("x");
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(this);
        object = ((StringBuilder)object).toString();
        String string2 = "TXLivePlayer";
        TXCLog.i(string2, (String)object);
        this.c = n10;
        this.d = n11;
        object = this.t;
        if (object != null) {
            ((q)object).a(n10, n11);
        }
    }

    public void a(Surface surface) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[API] setSurface old : ");
        Object object2 = this.b;
        ((StringBuilder)object).append(object2);
        ((StringBuilder)object).append(", new : ");
        ((StringBuilder)object).append(surface);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(this);
        object = ((StringBuilder)object).toString();
        object2 = "TXLivePlayer";
        TXCLog.i((String)object2, (String)object);
        this.b = surface;
        object = this.t;
        if (object != null) {
            ((q)object).a(surface);
        }
    }

    public void a(ITXLivePlayListener iTXLivePlayListener) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("[API] setPlayListener ");
        charSequence.append(this);
        charSequence = charSequence.toString();
        TXCLog.i("TXLivePlayer", (String)charSequence);
        this.e = iTXLivePlayListener;
    }

    public void a(TXLivePlayConfig object) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("[API] setConfig ");
        ((StringBuilder)object2).append(this);
        object2 = ((StringBuilder)object2).toString();
        String string2 = "TXLivePlayer";
        TXCLog.i(string2, (String)object2);
        this.f = object;
        if (object == null) {
            this.f = object = new TXLivePlayConfig();
        }
        if ((object = this.t) != null) {
            boolean bl2;
            boolean bl3;
            int n10;
            String string3;
            boolean bl4;
            int n11;
            boolean bl5;
            int n12;
            int n13;
            int bl22;
            float f10;
            int n102;
            if ((object = ((q)object).q()) == null) {
                object = new h();
            }
            object2 = this.f;
            float f11 = ((TXLivePlayConfig)object2).mMinAutoAdjustCacheTime;
            this.I = n102 = (int)(1000.0f * f11);
            ((h)object).a = f10 = ((TXLivePlayConfig)object2).mCacheTime;
            n102 = (int)(((TXLivePlayConfig)object2).mAutoAdjustCacheTime ? 1 : 0);
            ((h)object).g = n102;
            ((h)object).c = f11;
            ((h)object).b = f11 = ((TXLivePlayConfig)object2).mMaxAutoAdjustCacheTime;
            ((h)object).d = bl22 = ((TXLivePlayConfig)object2).mVideoBlockThreshold;
            ((h)object).e = n13 = ((TXLivePlayConfig)object2).mConnectRetryCount;
            ((h)object).f = n12 = ((TXLivePlayConfig)object2).mConnectRetryInterval;
            ((h)object).i = bl5 = ((TXLivePlayConfig)object2).mEnableNearestIP;
            ((h)object).m = n11 = ((TXLivePlayConfig)object2).mRtmpChannelType;
            ((h)object).h = bl4 = this.g;
            ((h)object).n = string3 = ((TXLivePlayConfig)object2).mCacheFolderPath;
            ((h)object).o = n10 = ((TXLivePlayConfig)object2).mMaxCacheItems;
            ((h)object).j = bl3 = ((TXLivePlayConfig)object2).mEnableMessage;
            ((h)object).k = bl2 = ((TXLivePlayConfig)object2).mEnableMetaData;
            ((h)object).l = string3 = ((TXLivePlayConfig)object2).mFlvSessionKey;
            ((h)object).q = object2 = ((TXLivePlayConfig)object2).mHeaders;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("liteav_api setConfig [cacheTime:");
            f11 = this.f.mCacheTime;
            ((StringBuilder)object2).append(f11);
            ((StringBuilder)object2).append("][autoAdjustCacheTime:");
            boolean bl6 = this.f.mAutoAdjustCacheTime;
            ((StringBuilder)object2).append(bl6);
            ((StringBuilder)object2).append("][minAutoAdjustCacheTime:");
            f11 = this.f.mMinAutoAdjustCacheTime;
            ((StringBuilder)object2).append(f11);
            ((StringBuilder)object2).append("][maxAutoAdjustCacheTime:");
            f11 = this.f.mMaxAutoAdjustCacheTime;
            ((StringBuilder)object2).append(f11);
            ((StringBuilder)object2).append("][videoBlockThreshold:");
            int n14 = this.f.mVideoBlockThreshold;
            ((StringBuilder)object2).append(n14);
            ((StringBuilder)object2).append("][connectRetryCount:");
            int n15 = this.f.mConnectRetryCount;
            ((StringBuilder)object2).append(n15);
            ((StringBuilder)object2).append("][connectRetryInterval:");
            int n16 = this.f.mConnectRetryInterval;
            ((StringBuilder)object2).append(n16);
            ((StringBuilder)object2).append("][enableHWDec:");
            boolean bl7 = this.g;
            ((StringBuilder)object2).append(bl7);
            ((StringBuilder)object2).append("][enableMessage:");
            boolean bl8 = this.f.mEnableMessage;
            ((StringBuilder)object2).append(bl8);
            ((StringBuilder)object2).append("][enableMetaData:");
            boolean bl9 = this.f.mEnableMetaData;
            ((StringBuilder)object2).append(bl9);
            ((StringBuilder)object2).append("][flvSessionKey:");
            string3 = this.f.mFlvSessionKey;
            ((StringBuilder)object2).append(string3);
            object2 = ((StringBuilder)object2).toString();
            TXCLog.i(string2, (String)object2);
            object2 = this.t;
            ((q)object2).a((h)object);
        }
    }

    public void a(TXLivePlayer$ITXAudioRawDataListener tXLivePlayer$ITXAudioRawDataListener) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[API] setAudioRawDataListener ");
        ((StringBuilder)object).append(tXLivePlayer$ITXAudioRawDataListener);
        object = ((StringBuilder)object).toString();
        String string2 = "TXLivePlayer";
        TXCLog.i(string2, (String)object);
        this.K = tXLivePlayer$ITXAudioRawDataListener;
        object = this.t;
        if (object != null) {
            ((q)object).a(tXLivePlayer$ITXAudioRawDataListener);
        }
    }

    public void a(TXLivePlayer$ITXAudioVolumeEvaluationListener tXLivePlayer$ITXAudioVolumeEvaluationListener) {
        this.E = tXLivePlayer$ITXAudioVolumeEvaluationListener;
    }

    public void a(TXLivePlayer$ITXSnapshotListener tXLivePlayer$ITXSnapshotListener) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[API] snapshot ");
        ((StringBuilder)object).append(tXLivePlayer$ITXSnapshotListener);
        object = ((StringBuilder)object).toString();
        Object object2 = "TXLivePlayer";
        TXCLog.i((String)object2, (String)object);
        boolean bl2 = this.w;
        if (!bl2 && tXLivePlayer$ITXSnapshotListener != null) {
            this.w = bl2 = true;
            object = this.t;
            if (object != null) {
                object2 = new a$1(this, tXLivePlayer$ITXSnapshotListener);
                ((q)object).a((o)object2);
            } else {
                tXLivePlayer$ITXSnapshotListener = null;
                this.w = false;
            }
        }
    }

    public void a(TXLivePlayer$ITXVideoRawDataListener object) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("[API] setVideoRawDataListener ");
        ((StringBuilder)object2).append(object);
        object2 = ((StringBuilder)object2).toString();
        String string2 = "TXLivePlayer";
        TXCLog.i(string2, (String)object2);
        this.n = object;
        object2 = this.t;
        if (object2 == null) {
            return;
        }
        string2 = null;
        if (object != null) {
            object = new a$3(this);
            com.tencent.liteav.basic.a.b b10 = com.tencent.liteav.basic.a.b.b;
            ((q)object2).a((r)object, b10, null);
        } else {
            object = com.tencent.liteav.basic.a.b.a;
            ((q)object2).a(null, (com.tencent.liteav.basic.a.b)((Object)object), null);
        }
    }

    public void a(TXCloudVideoView tXCloudVideoView) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[API] setPlayerView old view : ");
        Object object2 = this.a;
        ((StringBuilder)object).append(object2);
        ((StringBuilder)object).append(", new view : ");
        ((StringBuilder)object).append((Object)tXCloudVideoView);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(this);
        object = ((StringBuilder)object).toString();
        object2 = "TXLivePlayer";
        TXCLog.i((String)object2, (String)object);
        this.a = tXCloudVideoView;
        object = this.t;
        if (object != null) {
            ((q)object).a(tXCloudVideoView);
        }
    }

    public void a(TXRecordCommon$ITXVideoRecordListener tXRecordCommon$ITXVideoRecordListener) {
        String string2 = "[API] setVideoRecordListener";
        TXCLog.i("TXLivePlayer", string2);
        q q10 = this.t;
        if (q10 != null) {
            q10.a(tXRecordCommon$ITXVideoRecordListener);
        }
    }

    public boolean a() {
        q q10 = this.t;
        if (q10 != null) {
            return q10.c();
        }
        return false;
    }

    public boolean a(byte[] byArray) {
        boolean bl2;
        Object object = this.k;
        if (object != null && !(bl2 = ((String)object).isEmpty())) {
            bl2 = this.g;
            String string2 = "TXLivePlayer";
            if (bl2) {
                TXLog.e(string2, "can not addVideoRawData because of hw decode has set!");
                return false;
            }
            object = this.t;
            if (object == null) {
                TXCLog.e(string2, "player hasn't created or not instanceof live player");
                return false;
            }
            this.o = byArray;
            return true;
        }
        return false;
    }

    public int b(String string2, int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[API] prepareLiveSeek ");
        ((StringBuilder)object).append(this);
        object = ((StringBuilder)object).toString();
        String string3 = "TXLivePlayer";
        TXCLog.i(string3, (String)object);
        object = this.x;
        if (object == null) {
            this.x = object = new j();
        }
        if ((object = this.x) != null) {
            string3 = this.k;
            a$4 a$4 = new a$4(this);
            return ((j)object).a(string3, string2, n10, a$4);
        }
        return -1;
    }

    public void b() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[API] pause ");
        ((StringBuilder)object).append(this);
        object = ((StringBuilder)object).toString();
        String string2 = "TXLivePlayer";
        TXCLog.i(string2, (String)object);
        object = this.t;
        if (object != null) {
            TXCLog.w(string2, "pause play");
            object = this.t;
            ((q)object).a();
        }
    }

    public void b(int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[API] setRenderRotation ");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXLivePlayer";
        TXCLog.i(string2, (String)object);
        this.j = n10;
        object = this.t;
        if (object != null) {
            ((q)object).b(n10);
        }
    }

    public void b(String string2) {
        block28: {
            String string3;
            String string4;
            Object object;
            CharSequence charSequence;
            block25: {
                boolean bl2;
                block29: {
                    JSONObject jSONObject;
                    block27: {
                        boolean bl3;
                        block26: {
                            block24: {
                                boolean bl4;
                                JSONObject jSONObject2;
                                block23: {
                                    charSequence = "enable";
                                    object = "params";
                                    string4 = "api";
                                    string3 = "TXLivePlayer";
                                    jSONObject2 = new JSONObject(string2);
                                    bl4 = jSONObject2.has(string4);
                                    if (bl4) break block23;
                                    charSequence = new StringBuilder();
                                    object = "callExperimentalAPI[lack api or illegal type]: ";
                                    ((StringBuilder)charSequence).append((String)object);
                                    ((StringBuilder)charSequence).append(string2);
                                    charSequence = ((StringBuilder)charSequence).toString();
                                    TXCLog.e(string3, (String)charSequence);
                                    return;
                                }
                                string4 = jSONObject2.getString(string4);
                                bl4 = false;
                                jSONObject = null;
                                boolean bl5 = jSONObject2.has((String)object);
                                if (!bl5) break block24;
                                jSONObject = jSONObject2.getJSONObject((String)object);
                            }
                            object = "muteRemoteAudioInSpeaker";
                            bl3 = string4.equals(object);
                            if (!bl3) break block25;
                            if (jSONObject != null) break block26;
                            charSequence = "muteRemoteAudioInSpeaker[lack parameter]";
                            TXCLog.e(string3, (String)charSequence);
                            return;
                        }
                        bl3 = jSONObject.has((String)charSequence);
                        if (bl3) break block27;
                        charSequence = "muteRemoteAudioInSpeaker[lack parameter]: enable";
                        TXCLog.e(string3, (String)charSequence);
                        return;
                    }
                    boolean bl6 = jSONObject.getInt((String)charSequence);
                    object = this.t;
                    if (object == null) break block28;
                    bl2 = true;
                    if (bl6 == bl2) break block29;
                    bl2 = false;
                    string4 = null;
                }
                ((q)object).c(bl2);
            }
            charSequence = new StringBuilder();
            object = "callExperimentalAPI[illegal api]: ";
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(string4);
            charSequence = ((StringBuilder)charSequence).toString();
            try {
                TXCLog.e(string3, (String)charSequence);
            }
            catch (Exception exception) {
                charSequence = new StringBuilder();
                object = "callExperimentalAPI[failed]: ";
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append(string2);
                string2 = ((StringBuilder)charSequence).toString();
                TXCLog.e(string3, string2);
            }
        }
    }

    public boolean b(boolean bl2) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[API] enableHardwareDecode ");
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        String string2 = "TXLivePlayer";
        TXCLog.i(string2, (String)object);
        if (bl2) {
            n10 = Build.VERSION.SDK_INT;
            int n11 = 18;
            String string3 = "HardwareDecode";
            if (n10 < n11) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append("enableHardwareDecode failed, android system build.version = ");
                charSequence.append(n10);
                charSequence.append(", the minimum build.version should be 18(android 4.3 or later)");
                charSequence = charSequence.toString();
                TXCLog.e(string3, (String)charSequence);
                return false;
            }
            n10 = (int)(this.i() ? 1 : 0);
            if (n10 != 0) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append("enableHardwareDecode failed, MANUFACTURER = ");
                object = Build.MANUFACTURER;
                charSequence.append((String)object);
                charSequence.append(", MODEL");
                object = Build.MODEL;
                charSequence.append((String)object);
                charSequence = charSequence.toString();
                TXCLog.e(string3, (String)charSequence);
                return false;
            }
        }
        this.g = bl2;
        Object object2 = this.t;
        if (object2 != null) {
            if ((object2 = ((q)object2).q()) == null) {
                object2 = new h();
            }
            n10 = (int)(this.g ? 1 : 0);
            ((h)object2).h = n10;
            object = this.t;
            ((q)object).a((h)object2);
        }
        return true;
    }

    public void c() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[API] resume ");
        ((StringBuilder)object).append(this);
        object = ((StringBuilder)object).toString();
        String string2 = "TXLivePlayer";
        TXCLog.i(string2, (String)object);
        object = this.t;
        if (object != null) {
            TXCLog.w(string2, "resume play");
            this.t.b();
            object = this.t;
            Object object2 = ((q)object).f();
            if (object2 != 0) {
                object = this.x;
                long l10 = 0L;
                long l11 = object != null ? ((j)object).a() : l10;
                this.z = l11;
                object2 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
                if (object2 > 0) {
                    object = this.t;
                    ((q)object).g();
                }
            }
        }
    }

    public void c(int n10) {
        int n11;
        if (n10 < 0) {
            n10 = 0;
        }
        if (n10 > (n11 = 100)) {
            n10 = n11;
        }
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[API] setVolume volume = ");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXLivePlayer";
        TXCLog.i(string2, (String)object);
        this.m = n10;
        object = this.t;
        if (object != null) {
            ((q)object).c(n10);
        }
    }

    public void c(boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[API] setMute ");
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        String string2 = "TXLivePlayer";
        TXCLog.i(string2, (String)object);
        this.l = bl2;
        object = this.t;
        if (object != null) {
            ((q)object).b(bl2);
        }
    }

    public int d() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[API] stopRecord ");
        ((StringBuilder)object).append(this);
        object = ((StringBuilder)object).toString();
        String string2 = "TXLivePlayer";
        TXCLog.i(string2, (String)object);
        object = this.t;
        if (object != null) {
            return ((q)object).e();
        }
        return -1;
    }

    public void d(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("[API] setAudioRoute ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        TXCLog.i("TXLivePlayer", (String)charSequence);
        TXCAudioEngine.setAudioRoute(n10);
    }

    public void d(boolean bl2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("[API] setAutoPlay ");
        charSequence.append(bl2);
        charSequence = charSequence.toString();
        TXCLog.i("TXLivePlayer", (String)charSequence);
        this.u = bl2;
    }

    public int e() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("[API] resumeLive ");
        charSequence.append(this);
        charSequence = charSequence.toString();
        String string2 = "TXLivePlayer";
        TXCLog.i(string2, (String)charSequence);
        boolean bl2 = this.y;
        if (bl2) {
            this.y = false;
            charSequence = this.A;
            return this.a((String)charSequence, 1);
        }
        return -1;
    }

    public void e(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("[API] enableAudioVolumeEvaluation intervalMs = ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string2 = "TXLivePlayer";
        TXCLog.i(string2, (String)charSequence);
        if (n10 > 0) {
            int n11 = 100;
            if (n10 < n11) {
                n10 = n11;
            }
            this.F = n10;
            this.f();
        } else {
            n10 = 0;
            this.F = 0;
            this.g();
        }
    }

    public int f(int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[API] startRecord ");
        ((StringBuilder)object).append(this);
        object = ((StringBuilder)object).toString();
        String string2 = "TXLivePlayer";
        TXCLog.i(string2, (String)object);
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 18;
        if (n11 < n12) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("API levl is too low (record need 18, current is");
            charSequence.append(n11);
            charSequence.append(")");
            charSequence = charSequence.toString();
            TXCLog.e(string2, (String)charSequence);
            return -3;
        }
        n11 = (int)(this.a() ? 1 : 0);
        n12 = -1;
        if (n11 == 0) {
            TXCLog.e(string2, "startRecord: there is no playing stream");
            return n12;
        }
        object = this.t;
        if (object != null) {
            return ((q)object).d(n10);
        }
        return n12;
    }

    /*
     * WARNING - void declaration
     */
    public void g(int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[API] seek ");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXLivePlayer";
        TXCLog.d(string2, (String)object);
        object = this.t;
        if (object != null) {
            boolean bl2;
            boolean n11 = ((q)object).f();
            if (!n11 && !(bl2 = this.y)) {
                object = this.t;
                ((q)object).e(n10);
            } else {
                object = this.x;
                if (object != null) {
                    long l10 = n10;
                    object = ((j)object).a(l10);
                } else {
                    object = "";
                }
                int n12 = TextUtils.isEmpty((CharSequence)object);
                if (n12 == 0) {
                    void var4_9;
                    n12 = 3;
                    int n13 = this.a((String)object, n12);
                    if (n13 == 0) {
                        boolean bl3 = true;
                    } else {
                        boolean bl4 = false;
                        object = null;
                    }
                    this.y = var4_9;
                    if (var4_9 != false) {
                        long l11;
                        this.z = l11 = (long)(n10 *= 1000);
                    }
                } else {
                    ITXLivePlayListener iTXLivePlayListener = this.e;
                    if (iTXLivePlayListener != null) {
                        int n14 = -2301;
                        string2 = new Bundle();
                        iTXLivePlayListener.onPlayEvent(n14, (Bundle)string2);
                    }
                }
            }
        }
    }

    /*
     * Exception decompiling
     */
    public void onNotifyEvent(int var1_1, Bundle var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous, and can't clone.
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:611)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:94)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:512)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }
}

