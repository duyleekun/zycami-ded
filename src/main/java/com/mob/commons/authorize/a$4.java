/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.authorize;

import com.mob.commons.LockAction;
import com.mob.commons.authorize.a;
import com.mob.tools.utils.FileLocker;
import java.util.HashMap;

public class a$4
implements LockAction {
    public final /* synthetic */ HashMap a;
    public final /* synthetic */ a b;

    public a$4(a a10, HashMap hashMap) {
        this.b = a10;
        this.a = hashMap;
    }

    public boolean run(FileLocker object) {
        object = this.b;
        HashMap hashMap = this.a;
        com.mob.commons.authorize.a.a((a)object, hashMap, false);
        return false;
    }
}

