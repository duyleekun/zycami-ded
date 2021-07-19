/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.utils.AVUtils;
import e.a.v0.o;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class AVObject$1
implements o {
    public final /* synthetic */ AVObject this$0;

    public AVObject$1(AVObject aVObject) {
        this.this$0 = aVObject;
    }

    public AVObject apply(List object) {
        int n10;
        if (object != null && (n10 = object.isEmpty()) == 0) {
            Object object2 = AVObject.logger;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("batchSave result: ");
            String string2 = object.toString();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            ((AVLogger)object2).d((String)charSequence);
            n10 = object.size() + -1;
            object = (Map)object.get(n10);
            if (object != null) {
                object2 = this.this$0.serverData;
                AVUtils.mergeConcurrentMap((ConcurrentMap)object2, (Map)object);
                object = this.this$0;
                ((AVObject)object).onSaveSuccess();
            }
        }
        return this.this$0;
    }
}

