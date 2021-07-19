/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.authorize;

import com.mob.MobSDK;
import com.mob.commons.MobProduct;
import com.mob.commons.authorize.a;

public class a$3
implements MobProduct {
    public final /* synthetic */ a a;

    public a$3(a a10) {
        this.a = a10;
    }

    public String getProductTag() {
        return "COMMON";
    }

    public int getSdkver() {
        return MobSDK.SDK_VERSION_CODE;
    }
}

