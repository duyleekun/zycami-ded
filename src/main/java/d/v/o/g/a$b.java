/*
 * Decompiled with CFR 0.151.
 */
package d.v.o.g;

import com.tencent.rtmp.TXLivePusher$AudioCustomProcessListener;
import d.v.o.f.e;
import d.v.o.g.a;

public class a$b
implements TXLivePusher$AudioCustomProcessListener {
    public final /* synthetic */ a a;

    public a$b(a a10) {
        this.a = a10;
    }

    public void onRecordPcmData(byte[] byArray, long l10, int n10, int n11, int n12) {
    }

    public void onRecordRawPcmData(byte[] byArray, long l10, int n10, int n11, int n12, boolean bl2) {
        Object object = d.v.o.g.a.Q(this.a);
        if (object != null) {
            object = this.a;
            e e10 = d.v.o.g.a.Q((a)object);
            e10.onRecordRawPcmData(byArray, l10, n10, n11, n12, bl2);
        }
    }
}

