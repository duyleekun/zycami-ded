/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.n;

import android.text.TextUtils;
import com.zhiyun.live.data.api.entity.LiveInfo;
import d.v.n.i;
import d.v.n.k.a;

public class i$e
extends a {
    public final /* synthetic */ i c;

    public i$e(i i10) {
        this.c = i10;
    }

    public void a(LiveInfo object) {
        boolean bl2;
        Object object2 = this.c;
        i.f((i)object2, (LiveInfo)object);
        object = i.e(this.c).getRtmpUrl();
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (!bl3 && (bl2 = ((String)object).startsWith((String)(object2 = "rtmp://")))) {
            object = i.c(this.c);
            object2 = i.e(this.c).getRtmpUrl();
            object.b((String)object2);
        }
    }

    public void onError(Throwable throwable, int n10, String string2) {
        i.c(this.c).c(n10);
    }
}

