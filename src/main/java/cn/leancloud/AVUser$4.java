/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVObject;
import cn.leancloud.AVUser;
import e.a.v0.o;
import java.util.Map;

public class AVUser$4
implements o {
    public final /* synthetic */ AVUser this$0;
    public final /* synthetic */ String val$platform;

    public AVUser$4(AVUser aVUser, String string2) {
        this.this$0 = aVUser;
        this.val$platform = string2;
    }

    public AVUser apply(AVObject object) {
        object = this.this$0;
        String string2 = "authData";
        if ((object = (Map)((AVObject)object).get(string2)) != null) {
            string2 = this.val$platform;
            object.remove(string2);
        }
        return this.this$0;
    }
}

