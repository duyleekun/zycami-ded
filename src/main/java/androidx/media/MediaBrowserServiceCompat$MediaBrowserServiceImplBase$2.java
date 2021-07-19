/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 */
package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase;
import java.util.Iterator;

public class MediaBrowserServiceCompat$MediaBrowserServiceImplBase$2
implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplBase this$1;
    public final /* synthetic */ Bundle val$options;
    public final /* synthetic */ String val$parentId;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplBase$2(MediaBrowserServiceCompat$MediaBrowserServiceImplBase mediaBrowserServiceCompat$MediaBrowserServiceImplBase, String string2, Bundle bundle) {
        this.this$1 = mediaBrowserServiceCompat$MediaBrowserServiceImplBase;
        this.val$parentId = string2;
        this.val$options = bundle;
    }

    public void run() {
        boolean bl2;
        Iterator iterator2 = this.this$1.this$0.mConnections.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (IBinder)iterator2.next();
            object = (MediaBrowserServiceCompat$ConnectionRecord)this.this$1.this$0.mConnections.get(object);
            MediaBrowserServiceCompat$MediaBrowserServiceImplBase mediaBrowserServiceCompat$MediaBrowserServiceImplBase = this.this$1;
            String string2 = this.val$parentId;
            Bundle bundle = this.val$options;
            mediaBrowserServiceCompat$MediaBrowserServiceImplBase.notifyChildrenChangedOnHandler((MediaBrowserServiceCompat$ConnectionRecord)object, string2, bundle);
        }
    }
}

