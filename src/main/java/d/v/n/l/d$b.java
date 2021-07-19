/*
 * Decompiled with CFR 0.151.
 */
package d.v.n.l;

import com.zhiyun.live.data.api.entity.ThirdpartyPollInfo;
import d.v.n.k.a;
import d.v.n.l.d;

public class d$b
extends a {
    public final /* synthetic */ d c;

    public d$b(d d10) {
        this.c = d10;
    }

    public void a(ThirdpartyPollInfo object) {
        int n10 = ((ThirdpartyPollInfo)object).status;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                int n12 = 2;
                if (n10 == n12 && (object = this.c.d) != null) {
                    object.a();
                }
            } else {
                d d10 = this.c;
                String string2 = ((ThirdpartyPollInfo)object).platform;
                object = ((ThirdpartyPollInfo)object).code;
                d.b(d10, string2, (String)object);
            }
        } else {
            d d11 = this.c;
            object = ((ThirdpartyPollInfo)object).platform;
            d.a(d11, (String)object);
        }
    }

    public void onError(Throwable object, int n10, String string2) {
        object = this.c.d;
        if (object != null) {
            object.a();
        }
    }
}

