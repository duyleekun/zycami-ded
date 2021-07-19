/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.muxer.jni;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.muxer.jni.TXSWMuxerJNI$AVOptions;
import java.nio.ByteBuffer;

public class TXSWMuxerJNI {
    private long a = -1;
    private volatile boolean b;
    private volatile boolean c;

    public TXSWMuxerJNI() {
        long l10;
        this.a = l10 = this.init();
        this.b = true;
    }

    private byte[] b(ByteBuffer byteBuffer, int n10) {
        if (byteBuffer == null) {
            return null;
        }
        byte[] byArray = new byte[n10];
        byteBuffer.get(byArray);
        return byArray;
    }

    private native long init();

    private native void release(long var1);

    private native void setAVParams(long var1, TXSWMuxerJNI$AVOptions var3);

    private native void setAudioCSD(long var1, byte[] var3);

    private native void setDstPath(long var1, String var3);

    private native void setVideoCSD(long var1, byte[] var3, byte[] var4);

    private native int start(long var1);

    private native int stop(long var1);

    private native int writeFrame(long var1, byte[] var3, int var4, int var5, int var6, int var7, long var8);

    public int a() {
        int n10 = this.b;
        String string2 = "TXSWMuxerJNI";
        if (n10 != 0) {
            long l10 = this.a;
            n10 = this.start(l10);
            if (n10 == 0) {
                boolean bl2;
                this.c = bl2 = true;
            } else {
                String string3 = "Start Muxer Error!!!";
                TXCLog.e(string2, string3);
            }
            return n10;
        }
        TXCLog.e(string2, "Muxer isn't init yet!");
        return -1;
    }

    public int a(ByteBuffer byteBuffer, int n10, int n11, int n12, int n13, long l10) {
        int n14 = this.b;
        int n15 = -1;
        String string2 = "TXSWMuxerJNI";
        if (n14 != 0) {
            n14 = this.c;
            if (n14 != 0) {
                long l11 = this.a;
                byte[] byArray = this.b(byteBuffer, n12);
                n14 = this.writeFrame(l11, byArray, n10, n11, n12, n13, l10);
                if (n14 != 0) {
                    String string3 = "Muxer write frame error!";
                    TXCLog.e(string2, string3);
                }
                return n14;
            }
            TXCLog.e(string2, "Muxer isn't start yet!");
            return n15;
        }
        TXCLog.e(string2, "Muxer isn't init yet!");
        return n15;
    }

    public void a(TXSWMuxerJNI$AVOptions object) {
        boolean bl2 = this.b;
        if (bl2) {
            long l10 = this.a;
            this.setAVParams(l10, (TXSWMuxerJNI$AVOptions)object);
        } else {
            object = "TXSWMuxerJNI";
            String string2 = "Muxer isn't init yet!";
            TXCLog.e((String)object, string2);
        }
    }

    public void a(String string2) {
        boolean bl2 = this.b;
        if (bl2) {
            long l10 = this.a;
            this.setDstPath(l10, string2);
        } else {
            string2 = "TXSWMuxerJNI";
            String string3 = "Muxer isn't init yet!";
            TXCLog.e(string2, string3);
        }
    }

    public void a(ByteBuffer object, int n10) {
        boolean bl2 = this.b;
        if (bl2) {
            long l10 = this.a;
            object = this.b((ByteBuffer)object, n10);
            this.setAudioCSD(l10, (byte[])object);
        } else {
            object = "TXSWMuxerJNI";
            String string2 = "Muxer isn't init yet!";
            TXCLog.e((String)object, string2);
        }
    }

    public void a(ByteBuffer object, int n10, ByteBuffer byteBuffer, int n11) {
        boolean bl2 = this.b;
        if (bl2) {
            long l10 = this.a;
            object = this.b((ByteBuffer)object, n10);
            byte[] byArray = this.b(byteBuffer, n11);
            this.setVideoCSD(l10, (byte[])object, byArray);
        } else {
            object = "TXSWMuxerJNI";
            String string2 = "Muxer isn't init yet!";
            TXCLog.e((String)object, string2);
        }
    }

    public int b() {
        int n10 = this.b;
        int n11 = -1;
        String string2 = "TXSWMuxerJNI";
        if (n10 != 0) {
            n10 = this.c;
            if (n10 != 0) {
                this.c = false;
                long l10 = this.a;
                n10 = this.stop(l10);
                if (n10 != 0) {
                    String string3 = "Stop Muxer Error!!!";
                    TXCLog.e(string2, string3);
                }
                return n10;
            }
            TXCLog.e(string2, "Muxer isn't start yet!");
            return n11;
        }
        TXCLog.e(string2, "Muxer isn't init yet!");
        return n11;
    }

    public void c() {
        boolean bl2 = this.b;
        if (bl2) {
            long l10 = this.a;
            this.release(l10);
            bl2 = false;
            Object var4_3 = null;
            this.b = false;
            this.c = false;
        } else {
            String string2 = "TXSWMuxerJNI";
            String string3 = "Muxer isn't init yet!";
            TXCLog.e(string2, string3);
        }
    }
}

