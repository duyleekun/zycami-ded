/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import e.a.e0;
import e.a.v0.o;
import java.util.List;

public class AVQuery$4
implements o {
    public final /* synthetic */ AVQuery this$0;

    public AVQuery$4(AVQuery aVQuery) {
        this.this$0 = aVQuery;
    }

    public e0 apply(List list) {
        return AVObject.deleteAllInBackground(list);
    }
}

