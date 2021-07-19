/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVObject;
import e.a.v0.o;
import java.util.concurrent.ConcurrentMap;

public class AVObject$10
implements o {
    public final /* synthetic */ AVObject this$0;

    public AVObject$10(AVObject aVObject) {
        this.this$0 = aVObject;
    }

    public AVObject apply(AVObject object) {
        this.this$0.serverData.clear();
        ConcurrentMap concurrentMap = this.this$0.serverData;
        object = ((AVObject)object).serverData;
        concurrentMap.putAll(object);
        this.this$0.onDataSynchronized();
        return this.this$0;
    }
}

