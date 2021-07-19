/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVObject;
import cn.leancloud.AVUser;
import cn.leancloud.utils.StringUtil;
import e.a.v0.o;
import java.util.concurrent.ConcurrentMap;

public class AVObject$11
implements o {
    public final /* synthetic */ AVObject this$0;
    public final /* synthetic */ String val$includeKeys;

    public AVObject$11(AVObject aVObject, String string2) {
        this.this$0 = aVObject;
        this.val$includeKeys = string2;
    }

    public AVObject apply(AVObject object) {
        Object object2 = this.val$includeKeys;
        boolean bl2 = StringUtil.isEmpty((String)object2);
        if (bl2) {
            boolean bl3;
            object2 = this.this$0.className;
            String string2 = "_User";
            bl2 = ((String)object2).equals(string2);
            if (!bl2 && !(bl3 = (object2 = this.this$0) instanceof AVUser)) {
                object2 = ((AVObject)object2).serverData;
                object2.clear();
            } else {
                object2 = this.this$0.serverData;
                string2 = "sessionToken";
                object2 = object2.get(string2);
                ConcurrentMap concurrentMap = this.this$0.serverData;
                concurrentMap.clear();
                if (object2 != null) {
                    concurrentMap = this.this$0.serverData;
                    concurrentMap.put(string2, object2);
                }
            }
        }
        object2 = this.this$0.serverData;
        object = ((AVObject)object).serverData;
        object2.putAll(object);
        this.this$0.onDataSynchronized();
        return this.this$0;
    }
}

