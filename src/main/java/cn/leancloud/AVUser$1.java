/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVUser;
import e.a.v0.o;

public class AVUser$1
implements o {
    public final /* synthetic */ AVUser this$0;

    public AVUser$1(AVUser aVUser) {
        this.this$0 = aVUser;
    }

    public AVUser apply(AVUser aVUser) {
        this.this$0.mergeRawData(aVUser, true);
        this.this$0.onSaveSuccess();
        return this.this$0;
    }
}

