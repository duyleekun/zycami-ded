/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVUser;
import e.a.v0.o;

public final class AVUser$5
implements o {
    public final /* synthetic */ boolean val$saveToCurrentUser;

    public AVUser$5(boolean bl2) {
        this.val$saveToCurrentUser = bl2;
    }

    public AVUser apply(AVUser aVUser) {
        boolean bl2 = this.val$saveToCurrentUser;
        if (bl2) {
            bl2 = true;
            AVUser.changeCurrentUser(aVUser, bl2);
        }
        return aVUser;
    }
}

