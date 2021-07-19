/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.ContentObserver
 *  android.os.Handler
 */
package androidx.loader.content;

import android.database.ContentObserver;
import android.os.Handler;
import androidx.loader.content.Loader;

public final class Loader$ForceLoadContentObserver
extends ContentObserver {
    public final /* synthetic */ Loader this$0;

    public Loader$ForceLoadContentObserver(Loader loader) {
        this.this$0 = loader;
        super((Handler)loader);
    }

    public boolean deliverSelfNotifications() {
        return true;
    }

    public void onChange(boolean bl2) {
        this.this$0.onContentChanged();
    }
}

