/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.sina.weibo;

import cn.sharesdk.sina.weibo.h;
import com.mob.tools.RxMob$OnSubscribe;
import com.mob.tools.RxMob$Subscriber;

public class h$2
implements RxMob$OnSubscribe {
    public final /* synthetic */ h a;

    public h$2(h h10) {
        this.a = h10;
    }

    public void call(RxMob$Subscriber rxMob$Subscriber) {
        String string2 = h.e(this.a);
        rxMob$Subscriber.onNext(string2);
    }
}

