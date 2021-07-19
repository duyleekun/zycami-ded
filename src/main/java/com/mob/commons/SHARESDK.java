/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons;

import cn.sharesdk.framework.ShareSDK;
import com.mob.commons.MobProduct;

public class SHARESDK
implements MobProduct {
    public String getProductTag() {
        return "SHARESDK";
    }

    public int getSdkver() {
        return ShareSDK.SDK_VERSION_CODE;
    }
}

