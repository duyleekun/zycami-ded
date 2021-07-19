/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package cn.sharesdk.framework.authorize;

import android.os.Bundle;

public interface SSOListener {
    public void onCancel();

    public void onComplete(Bundle var1);

    public void onFailed(Throwable var1);
}

