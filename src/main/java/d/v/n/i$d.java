/*
 * Decompiled with CFR 0.151.
 */
package d.v.n;

import com.zhiyun.live.data.api.entity.BaseReStreamInfo;
import com.zhiyun.live.data.api.entity.ReStreamChannel;
import d.v.n.i;
import k.d;
import k.f;
import k.r;

public class i$d
implements f {
    public final /* synthetic */ int a;
    public final /* synthetic */ i b;

    public i$d(i i10, int n10) {
        this.b = i10;
        this.a = n10;
    }

    public void onFailure(d object, Throwable throwable) {
        object = i.c(this.b);
        if (object != null) {
            object = i.c(this.b);
            int n10 = 377;
            object.c(n10);
        }
    }

    public void onResponse(d object, r reStreamChannelArray) {
        object = i.c(this.b);
        if (object != null) {
            int n10;
            object = reStreamChannelArray.a();
            if (object != null && (object = ((BaseReStreamInfo)reStreamChannelArray.a()).error) == null) {
                object = i.d(this.b);
                n10 = ((ReStreamChannel[])object).length;
                for (int i10 = 0; i10 < n10; ++i10) {
                    boolean bl2;
                    ReStreamChannel reStreamChannel = object[i10];
                    int n11 = reStreamChannel.id;
                    int n12 = this.a;
                    if (n11 != n12) continue;
                    reStreamChannel.active = bl2 = reStreamChannel.active ^ true;
                    object = i.c(this.b);
                    reStreamChannelArray = i.d(this.b);
                    object.a(reStreamChannelArray);
                    return;
                }
            }
            object = i.c(this.b);
            n10 = 377;
            object.c(n10);
        }
    }
}

