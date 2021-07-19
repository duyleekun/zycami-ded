/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVObject;
import cn.leancloud.AVUser;
import cn.leancloud.Transformer;
import e.a.v0.o;

public final class AVUser$2
implements o {
    public final /* synthetic */ Class val$clazz;

    public AVUser$2(Class clazz) {
        this.val$clazz = clazz;
    }

    public AVUser apply(AVUser aVUser) {
        Class clazz = this.val$clazz;
        aVUser = (AVUser)Transformer.transform((AVObject)aVUser, clazz);
        AVUser.changeCurrentUser(aVUser, true);
        return aVUser;
    }
}

