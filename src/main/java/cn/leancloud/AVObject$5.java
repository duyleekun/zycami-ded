/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVObject;
import e.a.v0.o;

public class AVObject$5
implements o {
    public final /* synthetic */ AVObject this$0;
    public final /* synthetic */ boolean val$needFetch;

    public AVObject$5(AVObject aVObject, boolean bl2) {
        this.this$0 = aVObject;
        this.val$needFetch = bl2;
    }

    public AVObject apply(AVObject aVObject) {
        AVObject aVObject2 = this.this$0;
        boolean bl2 = this.val$needFetch;
        aVObject2.mergeRawData(aVObject, bl2);
        this.this$0.onSaveSuccess();
        return this.this$0;
    }
}

