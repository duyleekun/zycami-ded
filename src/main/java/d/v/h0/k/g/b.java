/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 */
package d.v.h0.k.g;

import android.media.MediaCodec;
import com.zhiyun.vtpusher.VtDataType;
import d.v.h0.k.c;
import d.v.h0.k.e;
import d.v.h0.k.g.a;
import d.v.h0.k.g.b$b;
import java.util.concurrent.ConcurrentLinkedQueue;

public class b
extends a {
    private MediaCodec b;
    private e c;
    private final ConcurrentLinkedQueue d;

    public b() {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        this.d = concurrentLinkedQueue = new ConcurrentLinkedQueue();
    }

    public static /* synthetic */ MediaCodec k(b b10) {
        return b10.b;
    }

    public static /* synthetic */ MediaCodec l(b b10, MediaCodec mediaCodec) {
        b10.b = mediaCodec;
        return mediaCodec;
    }

    public static /* synthetic */ ConcurrentLinkedQueue m(b b10) {
        return b10.d;
    }

    public static /* synthetic */ e n(b b10) {
        return b10.c;
    }

    public void b(e e10) {
        this.c = e10;
    }

    public void c(byte[] byArray) {
        this.d.clear();
        this.d.offer(byArray);
    }

    public c g() {
        b$b b$b = new b$b(this, null);
        return b$b;
    }

    public VtDataType h() {
        return VtDataType.ByteType;
    }

    public void i(MediaCodec mediaCodec) {
        this.b = mediaCodec;
    }

    public int j() {
        return 2135033992;
    }
}

