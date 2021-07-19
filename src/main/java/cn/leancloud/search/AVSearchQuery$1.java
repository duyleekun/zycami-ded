/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.search;

import cn.leancloud.search.AVSearchQuery;
import cn.leancloud.search.AVSearchResponse;
import e.a.v0.o;
import java.util.List;

public class AVSearchQuery$1
implements o {
    public final /* synthetic */ AVSearchQuery this$0;

    public AVSearchQuery$1(AVSearchQuery aVSearchQuery) {
        this.this$0 = aVSearchQuery;
    }

    public List apply(AVSearchResponse aVSearchResponse) {
        return AVSearchQuery.access$000(this.this$0, aVSearchResponse);
    }
}

