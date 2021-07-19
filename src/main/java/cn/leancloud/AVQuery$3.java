/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVLogger;
import cn.leancloud.AVQuery;
import e.a.e0;
import e.a.v0.o;
import e.a.z;
import java.util.List;

public class AVQuery$3
implements o {
    public final /* synthetic */ AVQuery this$0;

    public AVQuery$3(AVQuery aVQuery) {
        this.this$0 = aVQuery;
    }

    public e0 apply(List list) {
        AVLogger aVLogger = AVQuery.access$000();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("flatMap: ");
        charSequence.append(list);
        charSequence = charSequence.toString();
        aVLogger.d((String)charSequence);
        return z.W2(list);
    }
}

