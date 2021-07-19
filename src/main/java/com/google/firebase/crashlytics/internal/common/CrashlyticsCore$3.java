/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.CrashlyticsFileMarker;
import java.util.concurrent.Callable;

public class CrashlyticsCore$3
implements Callable {
    public final /* synthetic */ CrashlyticsCore this$0;

    public CrashlyticsCore$3(CrashlyticsCore crashlyticsCore) {
        this.this$0 = crashlyticsCore;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Boolean call() {
        Object object;
        try {
            object = this.this$0;
        }
        catch (Exception exception) {
            Logger.getLogger().e("Problem encountered deleting Crashlytics initialization marker.", exception);
            return Boolean.FALSE;
        }
        object = CrashlyticsCore.access$100((CrashlyticsCore)object);
        boolean bl2 = ((CrashlyticsFileMarker)object).remove();
        if (bl2) return bl2;
        Logger logger = Logger.getLogger();
        String string2 = "Initialization marker file was not properly removed.";
        logger.w(string2);
        return bl2;
    }
}

