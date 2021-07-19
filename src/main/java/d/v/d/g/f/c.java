/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioRecord
 */
package d.v.d.g.f;

import android.media.AudioRecord;
import d.v.d.g.f.a;
import d.v.d.g.f.c$b;
import d.v.d.h.f;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class c {
    private int a;
    private int b;
    private int c;
    private int d;
    private AudioRecord e;
    private boolean f;
    private double g = 0.0;
    private final List h;
    private int i;
    private final Runnable j;

    public c() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(this);
        this.j = copyOnWriteArrayList;
        this.h = copyOnWriteArrayList = new CopyOnWriteArrayList();
    }

    public static /* synthetic */ int a(c c10) {
        return c10.i;
    }

    public static /* synthetic */ boolean b(c c10) {
        return c10.f;
    }

    public static /* synthetic */ AudioRecord c(c c10) {
        return c10.e;
    }

    public static /* synthetic */ AudioRecord d(c c10, AudioRecord audioRecord) {
        c10.e = audioRecord;
        return audioRecord;
    }

    public static /* synthetic */ void e(c c10, byte[] byArray) {
        c10.h(byArray);
    }

    public static /* synthetic */ List f(c c10) {
        return c10.h;
    }

    private void h(byte[] byArray) {
        List list = this.h;
        int n10 = list.size();
        if (n10 <= 0) {
            return;
        }
        list = this.h;
        a a10 = new a(byArray);
        list.forEach(a10);
    }

    public static /* synthetic */ void k(byte[] byArray, c$b c$b) {
        c$b.a(byArray);
    }

    private void m(ByteBuffer byteBuffer, int n10) {
        block7: {
            byteBuffer.mark();
            byte[] byArray = new byte[n10];
            byteBuffer.get(byArray, 0, n10);
            byteBuffer.reset();
            byteBuffer = this.e;
            if (byteBuffer == null) break block7;
            double d10 = 0.0;
            for (int i10 = 0; i10 < n10; ++i10) {
                byte by2 = byArray[i10];
                double d11 = by2;
                d10 += d11;
            }
            double d12 = n10;
            d10 /= d12;
            d12 = Math.abs(d10);
            try {
                this.g = d12;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void g(c$b c$b) {
        List list = this.h;
        boolean bl2 = list.contains(c$b);
        if (bl2) {
            return;
        }
        this.h.add(c$b);
    }

    public int i() {
        return this.i;
    }

    public int j() {
        return (int)(this.g * 10.0);
    }

    public void l() {
        int n10;
        int n11;
        int n12 = this.a;
        if (n12 > 0 && (n11 = this.b) > 0 && (n10 = this.c) > 0) {
            n10 = 1;
            n11 = n11 > n10 ? 12 : 16;
            this.i = n12 = AudioRecord.getMinBufferSize((int)n12, (int)n11, (int)2);
            int n13 = this.d;
            int n14 = this.a;
            int n15 = this.i;
            Object object = new AudioRecord(n13, n14, n11, 2, n15);
            this.e = object;
            object = new StringBuilder();
            ((StringBuilder)object).append("mBufferSize=");
            n11 = this.i;
            ((StringBuilder)object).append(n11);
            ((StringBuilder)object).append(",mSampleRate=");
            n11 = this.a;
            ((StringBuilder)object).append(n11);
            d.v.d.h.f.a(((StringBuilder)object).toString());
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("\u8bf7\u68c0\u67e5\u97f3\u9891\u53c2\u6570 !!! ");
        throw illegalStateException;
    }

    public void n(c$b c$b) {
        this.h.remove(c$b);
    }

    public void o(int n10) {
        this.c = n10;
    }

    public void p(int n10) {
        this.b = n10;
    }

    public void q(int n10) {
        this.d = n10;
    }

    public void r(int n10) {
        this.a = n10;
    }

    public void s() {
        Object object = this.e;
        if (object != null) {
            boolean bl2;
            d.v.d.h.f.a("start audio receiver");
            this.e.startRecording();
            this.f = bl2 = true;
            Runnable runnable = this.j;
            object = new Thread(runnable);
            ((Thread)object).start();
        }
    }

    public void t() {
        d.v.d.h.f.a("stop audio receiver");
        this.f = false;
    }
}

