/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVUser;
import e.a.v0.o;

public class AVUser$3
implements o {
    public final /* synthetic */ AVUser this$0;

    public AVUser$3(AVUser aVUser) {
        this.this$0 = aVUser;
    }

    public AVUser apply(AVUser aVUser) {
        this.this$0.resetByRawData(aVUser);
        AVUser.changeCurrentUser(this.this$0, true);
        return this.this$0;
    }
}

