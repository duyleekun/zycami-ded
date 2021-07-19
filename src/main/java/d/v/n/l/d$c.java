/*
 * Decompiled with CFR 0.151.
 */
package d.v.n.l;

import com.zhiyun.live.data.api.entity.ThirdpartyAccessTokenInfo;
import d.v.n.k.a;
import d.v.n.l.d;
import d.v.n.l.e;

public class d$c
extends a {
    public final /* synthetic */ String c;
    public final /* synthetic */ d d;

    public d$c(d d10, String string2) {
        this.d = d10;
        this.c = string2;
    }

    public void a(ThirdpartyAccessTokenInfo thirdpartyAccessTokenInfo) {
        Object object = this.d.d;
        if (object != null) {
            object = this.c;
            Object object2 = "kuaishou";
            boolean bl2 = ((String)object).equals(object2);
            if (bl2) {
                object = this.d;
                object2 = thirdpartyAccessTokenInfo.accessToken;
                d.v.n.l.d.c((d)object, (String)object2, "ks694398768641986964");
                object = e.d();
                object2 = Boolean.TRUE;
                String string2 = "SP_LIVE_LOGIN_WEB";
                ((e)object).e(string2, (Boolean)object2);
            }
            if (bl2 = ((String)(object = this.c)).equals(object2 = "restream")) {
                object = this.d;
                object2 = thirdpartyAccessTokenInfo.accessToken;
                d.v.n.l.d.d((d)object, (String)object2);
            }
            object = this.d.d;
            object.b(thirdpartyAccessTokenInfo);
        }
    }

    public void onError(Throwable object, int n10, String string2) {
        object = this.d.d;
        if (object != null) {
            object.a();
            object = e.d();
            String string3 = this.c;
            ((e)object).b(string3);
        }
    }
}

