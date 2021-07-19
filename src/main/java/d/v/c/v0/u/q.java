/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u;

import com.zhiyun.cama.data.me.remote.AliyunManager$OnAliyunProgressCallback;
import d.v.c.v0.u.y;

public final class q
implements AliyunManager$OnAliyunProgressCallback {
    public final /* synthetic */ y a;
    public final /* synthetic */ int b;

    public /* synthetic */ q(y y10, int n10) {
        this.a = y10;
        this.b = n10;
    }

    public final void onProgress(int n10) {
        y y10 = this.a;
        int n11 = this.b;
        y10.m(n11, n10);
    }
}

