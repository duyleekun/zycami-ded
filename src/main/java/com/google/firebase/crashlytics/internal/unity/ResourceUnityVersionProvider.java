/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.crashlytics.internal.unity;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.unity.UnityVersionProvider;

public class ResourceUnityVersionProvider
implements UnityVersionProvider {
    private final Context context;
    private boolean hasRead = false;
    private String unityVersion;

    public ResourceUnityVersionProvider(Context context) {
        this.context = context;
    }

    public String getUnityVersion() {
        String string2;
        boolean bl2 = this.hasRead;
        if (!bl2) {
            this.unityVersion = string2 = CommonUtils.resolveUnityEditorVersion(this.context);
            this.hasRead = bl2 = true;
        }
        if ((string2 = this.unityVersion) != null) {
            return string2;
        }
        return null;
    }
}

