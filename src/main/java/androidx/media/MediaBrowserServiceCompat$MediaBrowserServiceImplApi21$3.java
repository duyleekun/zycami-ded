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
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21;
import java.util.Iterator;

public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3
implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 this$1;
    public final /* synthetic */ Bundle val$options;
    public final /* synthetic */ String val$parentId;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3(MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21, String string2, Bundle bundle) {
        this.this$1 = mediaBrowserServiceCompat$MediaBrowserServiceImplApi21;
        this.val$parentId = string2;
        this.val$options = bundle;
    }

    public void run() {
        boolean bl2;
        Iterator iterator2 = this.this$1.this$0.mConnections.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (IBinder)iterator2.next();
            object = (MediaBrowserServiceCompat$ConnectionRecord)this.this$1.this$0.mConnections.get(object);
            MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 mediaBrowserServiceCompat$MediaBrowserServiceImplApi21 = this.this$1;
            String string2 = this.val$parentId;
            Bundle bundle = this.val$options;
            mediaBrowserServiceCompat$MediaBrowserServiceImplApi21.notifyChildrenChangedForCompatOnHandler((MediaBrowserServiceCompat$ConnectionRecord)object, string2, bundle);
        }
    }
}

