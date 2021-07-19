/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import com.google.firebase.crashlytics.internal.common.MetaDataStore;
import com.google.firebase.crashlytics.internal.common.UserMetadata;
import java.io.File;
import java.util.concurrent.Callable;

public class CrashlyticsController$7
implements Callable {
    public final /* synthetic */ CrashlyticsController this$0;
    public final /* synthetic */ UserMetadata val$userMetaData;

    public CrashlyticsController$7(CrashlyticsController crashlyticsController, UserMetadata userMetadata) {
        this.this$0 = crashlyticsController;
        this.val$userMetaData = userMetadata;
    }

    public Void call() {
        String string2 = CrashlyticsController.access$100(this.this$0);
        if (string2 == null) {
            Logger.getLogger().d("Tried to cache user data while no session was open.");
            return null;
        }
        CrashlyticsController.access$300(this.this$0).persistUserId(string2);
        Object object = this.this$0.getFilesDir();
        MetaDataStore metaDataStore = new MetaDataStore((File)object);
        object = this.val$userMetaData;
        metaDataStore.writeUserData(string2, (UserMetadata)object);
        return null;
    }
}

