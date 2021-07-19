/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVException;
import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.Transformer;
import cn.leancloud.utils.StringUtil;
import e.a.v0.o;

public class AVQuery$2
implements o {
    public final /* synthetic */ AVQuery this$0;

    public AVQuery$2(AVQuery aVQuery) {
        this.this$0 = aVQuery;
    }

    public AVObject apply(AVObject object) {
        String string2;
        boolean bl2;
        if (object != null && !(bl2 = StringUtil.isEmpty(string2 = ((AVObject)object).getObjectId()))) {
            string2 = this.this$0.getClassName();
            return Transformer.transform((AVObject)object, string2);
        }
        object = new AVException(101, "Object is not found.");
        throw object;
    }
}

