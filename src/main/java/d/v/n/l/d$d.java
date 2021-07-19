/*
 * Decompiled with CFR 0.151.
 */
package d.v.n.l;

import com.zhiyun.live.data.LivePlatform;
import com.zhiyun.live.data.api.entity.ThirdpartyAccessTokenInfo;
import d.v.n.k.a;
import d.v.n.l.d;
import d.v.n.l.d$f;
import d.v.n.l.e;

public class d$d
extends a {
    public final /* synthetic */ LivePlatform c;
    public final /* synthetic */ d d;

    public d$d(d d10, LivePlatform livePlatform) {
        this.d = d10;
        this.c = livePlatform;
    }

    public void a(ThirdpartyAccessTokenInfo thirdpartyAccessTokenInfo) {
        d$f d$f = this.d.d;
        if (d$f == null) {
            return;
        }
        d$f.b(thirdpartyAccessTokenInfo);
    }

    public void onError(Throwable object, int n10, String string2) {
        object = this.d.d;
        if (object != null) {
            object.a();
            object = e.d();
            String string3 = this.c.getPlatformName();
            ((e)object).b(string3);
        }
    }
}

