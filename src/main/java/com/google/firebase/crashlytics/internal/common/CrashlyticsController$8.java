/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import com.google.firebase.crashlytics.internal.common.MetaDataStore;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Callable;

public class CrashlyticsController$8
implements Callable {
    public final /* synthetic */ CrashlyticsController this$0;
    public final /* synthetic */ Map val$keyData;

    public CrashlyticsController$8(CrashlyticsController crashlyticsController, Map map) {
        this.this$0 = crashlyticsController;
        this.val$keyData = map;
    }

    public Void call() {
        String string2 = CrashlyticsController.access$100(this.this$0);
        Object object = this.this$0.getFilesDir();
        MetaDataStore metaDataStore = new MetaDataStore((File)object);
        object = this.val$keyData;
        metaDataStore.writeKeyData(string2, (Map)object);
        return null;
    }
}

