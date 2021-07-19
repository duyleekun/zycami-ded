/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.authorize;

import com.mob.commons.LockAction;
import com.mob.commons.MobProduct;
import com.mob.commons.authorize.a;
import com.mob.tools.utils.FileLocker;

public class a$1
implements LockAction {
    public final /* synthetic */ String[] a;
    public final /* synthetic */ MobProduct b;
    public final /* synthetic */ String c;
    public final /* synthetic */ a d;

    public a$1(a a10, String[] stringArray, MobProduct mobProduct, String string2) {
        this.d = a10;
        this.a = stringArray;
        this.b = mobProduct;
        this.c = string2;
    }

    public boolean run(FileLocker object) {
        boolean bl2 = com.mob.commons.authorize.a.a(this.d);
        String[] stringArray = this.a;
        a a10 = this.d;
        MobProduct mobProduct = this.b;
        String string2 = this.c;
        stringArray[0] = object = com.mob.commons.authorize.a.a(a10, mobProduct, bl2, string2);
        return false;
    }
}

