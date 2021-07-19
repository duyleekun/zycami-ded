/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 *  android.os.Environment
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.text.TextUtils
 */
package com.tencent.liteav.b;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.liteav.audio.f;
import com.tencent.liteav.audio.impl.Record.b;
import com.tencent.liteav.b.a$1;
import com.tencent.liteav.b.a$a;
import com.tencent.liteav.b.a$b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.muxer.c;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.liteav.videoencoder.d;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class a
implements f,
d {
    private b a;
    private com.tencent.liteav.videoencoder.a b;
    private c c;
    private a$a d;
    private a$b e;
    private long f = 0L;
    private long g = -1;
    private boolean h = false;
    private Handler i;

    public a(Context context) {
        Looper looper = Looper.getMainLooper();
        Object object = new a$1(this, looper);
        this.i = object;
        this.a = object;
        super();
        this.b = object;
        super(context, 2);
        this.c = object;
    }

    public static /* synthetic */ a$b a(a a10) {
        return a10.e;
    }

    private String a(int n10) {
        String string2;
        switch (n10) {
            default: {
                string2 = "";
                break;
            }
            case 10000005: {
                string2 = "Video encoding failed";
                break;
            }
            case 10000004: {
                string2 = "Video encoding failed to initialize";
                break;
            }
            case 10000003: {
                string2 = "Illegal video input parameters";
                break;
            }
            case 10000002: {
                string2 = "Video encoder is not activated";
            }
        }
        Handler handler = this.i;
        Message message = Message.obtain((Handler)handler, (int)2, (int)1, (int)0, (Object)string2);
        handler.sendMessage(message);
        return string2;
    }

    private static String a(Context object) {
        String string2 = null;
        if (object == null) {
            return null;
        }
        String string3 = "mounted";
        String string4 = Environment.getExternalStorageState();
        boolean bl2 = string3.equals(string4);
        if (!bl2 && (bl2 = Environment.isExternalStorageRemovable())) {
            object = object.getFilesDir().getPath();
        } else {
            string4 = Environment.DIRECTORY_MOVIES;
            if ((object = object.getExternalFilesDir(string4)) != null) {
                string2 = ((File)object).getPath();
            }
            object = string2;
        }
        return object;
    }

    public static String a(Context object, String string2) {
        Serializable serializable;
        Object object2;
        Object object3;
        block26: {
            long l10;
            long l11;
            if (object == null) {
                return null;
            }
            try {
                l11 = System.currentTimeMillis();
                l10 = 1000L;
            }
            catch (Exception exception) {
                TXCLog.e("TXCStreamRecord", "create file path failed.", exception);
                return null;
            }
            l11 /= l10;
            object3 = String.valueOf(l11);
            object2 = "yyyyMMdd_HHmmss";
            serializable = new SimpleDateFormat((String)object2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object3);
            object3 = "000";
            stringBuilder.append((String)object3);
            object3 = stringBuilder.toString();
            object3 = Long.valueOf((String)object3);
            long l12 = (Long)object3;
            object2 = new Date(l12);
            object3 = ((DateFormat)serializable).format((Date)object2);
            object = com.tencent.liteav.b.a.a((Context)object);
            boolean n10 = TextUtils.isEmpty((CharSequence)object);
            if (!n10) break block26;
            return null;
        }
        serializable = new StringBuilder();
        object2 = "TXUGC_%s";
        ((StringBuilder)serializable).append((String)object2);
        ((StringBuilder)serializable).append(string2);
        string2 = ((StringBuilder)serializable).toString();
        int n10 = 1;
        serializable = new Object[n10];
        object2 = null;
        serializable[0] = object3;
        string2 = String.format(string2, (Object[])serializable);
        object3 = new File((String)object, string2);
        return ((File)object3).getAbsolutePath();
    }

    public static /* synthetic */ a$a b(a a10) {
        return a10.d;
    }

    public void a() {
        Message message = null;
        this.h = false;
        this.a.a();
        this.b.stop();
        c c10 = this.c;
        int n10 = c10.b();
        int n11 = 2;
        if (n10 < 0) {
            c10 = this.i;
            int n12 = 1;
            String string2 = "mp4\u5408\u6210\u5931\u8d25";
            message = Message.obtain((Handler)c10, (int)n11, (int)n12, (int)0, (Object)string2);
            c10.sendMessage(message);
        } else {
            c10 = this.i;
            String string3 = "";
            message = Message.obtain((Handler)c10, (int)n11, (int)0, (int)0, (Object)string3);
            c10.sendMessage(message);
        }
    }

    public void a(int n10, long l10) {
        com.tencent.liteav.videoencoder.a a10 = this.b;
        a$a a$a = this.d;
        int n11 = a$a.a;
        int n12 = a$a.b;
        a10.pushVideoFrame(n10, n11, n12, l10);
    }

    public void a(int n10, long l10, long l11) {
    }

    public void a(int n10, String string2) {
    }

    public void a(MediaFormat object) {
        int n10;
        c c10 = this.c;
        c10.a((MediaFormat)object);
        object = this.c;
        boolean n102 = ((c)object).c();
        if (n102 && (n10 = ((c)(object = this.c)).a()) < 0) {
            object = this.i;
            int n11 = 2;
            int n12 = 1;
            String string2 = "mp4 wrapper failed to start";
            c10 = Message.obtain((Handler)object, (int)n11, (int)n12, (int)0, (Object)string2);
            object.sendMessage((Message)c10);
        }
    }

    public void a(a$a object) {
        int n10;
        int n11;
        Object object2;
        int n12;
        int n13;
        long l10;
        this.d = object;
        this.f = 0L;
        this.g = l10 = (long)-1;
        Object object3 = this.c;
        Object object4 = ((a$a)object).f;
        ((c)object3).a((String)object4);
        int n14 = ((a$a)object).h;
        boolean bl2 = true;
        if (n14 > 0 && (n13 = ((a$a)object).i) > 0 && (n12 = ((a$a)object).j) > 0) {
            object2 = this.a;
            int n15 = 10;
            WeakReference<a> weakReference = new WeakReference<a>(this);
            ((b)object2).a(n15, n13, n14, n12, weakReference);
            object = this.d;
            n11 = ((a$a)object).i;
            int n16 = ((a$a)object).h;
            n10 = 2;
            object = com.tencent.liteav.basic.util.g.a(n11, n16, n10);
            object4 = this.c;
            ((c)object4).b((MediaFormat)object);
            this.h = bl2;
        }
        this.b.setListener(this);
        object = new TXSVideoEncoderParam();
        object4 = this.d;
        ((TXSVideoEncoderParam)object).width = n10 = ((a$a)object4).a;
        ((TXSVideoEncoderParam)object).height = n10 = ((a$a)object4).b;
        ((TXSVideoEncoderParam)object).fps = n10 = ((a$a)object4).c;
        ((TXSVideoEncoderParam)object).glContext = object2 = ((a$a)object4).e;
        ((TXSVideoEncoderParam)object).annexb = bl2;
        ((TXSVideoEncoderParam)object).appendSpsPps = false;
        object3 = this.b;
        n11 = ((a$a)object4).d;
        ((com.tencent.liteav.videoencoder.a)object3).setBitrate(n11);
        this.b.start((TXSVideoEncoderParam)object);
    }

    public void a(a$b a$b) {
        this.e = a$b;
    }

    public void a(TXSNALPacket object, int n10) {
        if (n10 == 0) {
            c c10 = this.c;
            Object object2 = ((TXSNALPacket)object).nalData;
            int n11 = ((byte[])object2).length;
            long l10 = ((TXSNALPacket)object).pts;
            long l11 = 1000L;
            MediaCodec.BufferInfo bufferInfo = ((TXSNALPacket)object).info;
            int n12 = bufferInfo.flags;
            c10.b((byte[])object2, 0, n11, l10 *= l11, n12);
            long l12 = this.g;
            long l13 = 0L;
            n10 = (int)(l12 == l13 ? 0 : (l12 < l13 ? -1 : 1));
            if (n10 < 0) {
                this.g = l12 = ((TXSNALPacket)object).pts;
            }
            l12 = ((TXSNALPacket)object).pts;
            l13 = this.f;
            l10 = 500L;
            long l14 = l12 - (l13 += l10);
            n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
            if (n10 > 0) {
                long l15;
                bufferInfo = this.i;
                int n13 = 1;
                object2 = new Long;
                l13 = ((TXSNALPacket)object).pts;
                l10 = this.g;
                object2(l13 -= l10);
                c10 = Message.obtain((Handler)bufferInfo, (int)n13, (Object)object2);
                bufferInfo.sendMessage((Message)c10);
                this.f = l15 = ((TXSNALPacket)object).pts;
            }
        } else {
            object = this.a(n10);
            CharSequence charSequence = new StringBuilder();
            String string2 = "video encode error! errmsg: ";
            charSequence.append(string2);
            charSequence.append((String)object);
            object = charSequence.toString();
            charSequence = "TXCStreamRecord";
            TXCLog.e((String)charSequence, (String)object);
        }
    }

    public void a(byte[] object, long l10) {
        boolean bl2 = this.h;
        if (bl2) {
            b b10 = this.a;
            b10.a((byte[])object, l10);
        } else {
            object = "TXCStreamRecord";
            String string2 = "drainAudio fail because of not init yet!";
            TXCLog.e((String)object, string2);
        }
    }

    public void a(byte[] byArray, long l10, int n10, int n11, int n12) {
    }

    public void a(byte[] byArray, long l10, int n10, int n11, int n12, boolean bl2) {
    }

    public void b(byte[] byArray, long l10, int n10, int n11, int n12) {
        c c10 = this.c;
        int n13 = byArray.length;
        long l11 = l10 * 1000L;
        c10.a(byArray, 0, n13, l11, 1);
    }

    public void g(int n10) {
    }

    public void h(int n10) {
    }
}

