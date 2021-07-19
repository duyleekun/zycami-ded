/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVStatus;
import e.a.v0.o;

public class AVStatus$1
implements o {
    public final /* synthetic */ AVStatus this$0;

    public AVStatus$1(AVStatus aVStatus) {
        this.this$0 = aVStatus;
    }

    public AVStatus apply(AVStatus aVStatus) {
        this.this$0.mergeRawData(aVStatus, true);
        return aVStatus;
    }
}

