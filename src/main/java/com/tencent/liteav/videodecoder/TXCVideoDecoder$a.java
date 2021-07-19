/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.view.Surface
 */
package com.tencent.liteav.videodecoder;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.videodecoder.TXCVideoFfmpegDecoder;
import com.tencent.liteav.videodecoder.b;
import com.tencent.liteav.videodecoder.e;
import com.tencent.liteav.videodecoder.f;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class TXCVideoDecoder$a
extends Handler {
    public b a;
    public f b;
    public WeakReference c;
    public boolean d;
    public boolean e;
    public Surface f;
    private ByteBuffer g;
    private ByteBuffer h;

    public TXCVideoDecoder$a(Looper looper) {
        super(looper);
    }

    private void a(boolean bl2) {
        b b10 = this.a;
        String string2 = "TXCVideoDecoder";
        if (b10 != null) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("play:decode: start decode ignore hwdec: ");
            boolean bl3 = this.d;
            charSequence.append(bl3);
            charSequence = charSequence.toString();
            TXCLog.i(string2, (String)charSequence);
            return;
        }
        boolean bl4 = this.d;
        this.a = bl4 ? (b10 = new e()) : (b10 = new TXCVideoFfmpegDecoder());
        b10 = this.a;
        Object object = this.b;
        b10.setListener((f)object);
        b10 = this.a;
        object = this.c;
        b10.setNotifyListener((WeakReference)object);
        b10 = this.a;
        object = this.f;
        b10.config((Surface)object);
        b10 = this.a;
        object = this.g;
        ByteBuffer byteBuffer = this.h;
        boolean bl5 = this.e;
        b10.start((ByteBuffer)object, byteBuffer, bl2, bl5);
        CharSequence charSequence = new StringBuilder();
        charSequence.append("play:decode: start decode hwdec: ");
        bl4 = this.d;
        charSequence.append(bl4);
        charSequence.append(", hevc: ");
        bl4 = this.e;
        charSequence.append(bl4);
        charSequence = charSequence.toString();
        TXCLog.w(string2, (String)charSequence);
    }

    private void a(boolean bl2, boolean bl3) {
        this.d = bl2;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("play:decode: restart decode hwdec: ");
        boolean bl4 = this.d;
        ((StringBuilder)object).append(bl4);
        object = ((StringBuilder)object).toString();
        String string2 = "TXCVideoDecoder";
        TXCLog.w(string2, (String)object);
        object = this.a;
        if (object != null) {
            object.stop();
            object = this.a;
            bl4 = false;
            string2 = null;
            object.setListener(null);
            object = this.a;
            object.setNotifyListener(null);
            this.a = null;
        }
        this.a(bl3);
    }

    private void a(byte[] object, long l10, long l11, int n10) {
        TXSNALPacket tXSNALPacket = new TXSNALPacket();
        tXSNALPacket.nalData = object;
        tXSNALPacket.pts = l10;
        tXSNALPacket.dts = l11;
        tXSNALPacket.codecId = n10;
        object = this.a;
        if (object != null) {
            object.decode(tXSNALPacket);
        }
    }

    private void b() {
        boolean bl2;
        Object object = this.a;
        if (object != null) {
            object.stop();
            object = this.a;
            bl2 = false;
            object.setListener(null);
            object = this.a;
            object.setNotifyListener(null);
            this.a = null;
        }
        Looper.myLooper().quit();
        object = new StringBuilder();
        ((StringBuilder)object).append("play:decode: stop decode hwdec: ");
        bl2 = this.d;
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        TXCLog.w("TXCVideoDecoder", (String)object);
    }

    public void a(boolean bl2, boolean bl3, Surface surface, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, f f10, com.tencent.liteav.basic.b.b b10) {
        WeakReference<com.tencent.liteav.basic.b.b> weakReference;
        this.e = bl2;
        this.d = bl3;
        this.f = surface;
        this.g = byteBuffer;
        this.h = byteBuffer2;
        this.b = f10;
        this.c = weakReference = new WeakReference<com.tencent.liteav.basic.b.b>(b10);
    }

    public boolean a() {
        b b10 = this.a;
        if (b10 != null) {
            return b10.isHevc();
        }
        return false;
    }

    public void handleMessage(Message object) {
        int n10 = ((Message)object).what;
        switch (n10) {
            default: {
                break;
            }
            case 103: {
                n10 = ((Message)object).arg1;
                int n11 = 0;
                Object var4_6 = null;
                int n12 = 1;
                if (n10 == n12) {
                    n10 = n12;
                } else {
                    n10 = 0;
                    Object var6_9 = null;
                }
                int n13 = ((Message)object).arg2;
                if (n13 == n12) {
                    n11 = n12;
                }
                this.a(n10 != 0, n11 != 0);
                break;
            }
            case 102: {
                this.b();
                break;
            }
            case 101: {
                object = object.getData();
                CharSequence charSequence = "nal";
                byte[] byArray = object.getByteArray((String)charSequence);
                charSequence = "pts";
                long l10 = object.getLong((String)charSequence);
                charSequence = "dts";
                long l11 = object.getLong((String)charSequence);
                charSequence = "codecId";
                int n14 = object.getInt((String)charSequence);
                Object object2 = this;
                try {
                    this.a(byArray, l10, l11, n14);
                }
                catch (Exception exception) {
                    charSequence = new StringBuilder();
                    object2 = "decode frame failed.";
                    ((StringBuilder)charSequence).append((String)object2);
                    String string2 = exception.getMessage();
                    ((StringBuilder)charSequence).append(string2);
                    string2 = ((StringBuilder)charSequence).toString();
                    charSequence = "TXCVideoDecoder";
                    TXCLog.e((String)charSequence, string2);
                }
                break;
            }
            case 100: {
                object = (Boolean)((Message)object).obj;
                boolean bl2 = (Boolean)object;
                this.a(bl2);
            }
        }
    }
}

