/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVStatus;
import cn.leancloud.AVStatusQuery;
import cn.leancloud.StatusIterator;
import e.a.v0.o;
import java.util.Iterator;
import java.util.List;

public class AVStatusQuery$1
implements o {
    public final /* synthetic */ AVStatusQuery this$0;

    public AVStatusQuery$1(AVStatusQuery aVStatusQuery) {
        this.this$0 = aVStatusQuery;
    }

    public List apply(List list) {
        int n10;
        int n11;
        if (list != null && (n11 = list.size()) >= (n10 = 1)) {
            Iterator iterator2 = list.iterator();
            while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                AVStatus aVStatus = (AVStatus)iterator2.next();
                StatusIterator statusIterator = AVStatusQuery.access$000(this.this$0);
                statusIterator.encounter(aVStatus);
            }
        }
        return list;
    }
}

