/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.utag;

import com.mob.commons.ForbThrowable;
import com.mob.commons.b;
import com.mob.commons.utag.TagRequester;
import com.mob.tools.RxMob$QuickSubscribe;
import com.mob.tools.RxMob$Subscriber;
import java.util.HashMap;

public class TagRequester$2
extends RxMob$QuickSubscribe {
    public final /* synthetic */ TagRequester a;

    public TagRequester$2(TagRequester tagRequester) {
        this.a = tagRequester;
    }

    public void doNext(RxMob$Subscriber object) {
        boolean bl2 = b.Z();
        if (!bl2) {
            TagRequester.a();
            HashMap hashMap = TagRequester.b();
            ((RxMob$Subscriber)object).onNext(hashMap);
            return;
        }
        object = new ForbThrowable();
        throw object;
    }
}

