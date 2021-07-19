/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.util.Log
 */
package androidx.media;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media.MediaBrowserServiceCompat$Result;
import java.util.List;

public class MediaBrowserServiceCompat$1
extends MediaBrowserServiceCompat$Result {
    public final /* synthetic */ MediaBrowserServiceCompat this$0;
    public final /* synthetic */ MediaBrowserServiceCompat$ConnectionRecord val$connection;
    public final /* synthetic */ Bundle val$notifyChildrenChangedOptions;
    public final /* synthetic */ String val$parentId;
    public final /* synthetic */ Bundle val$subscribeOptions;

    public MediaBrowserServiceCompat$1(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object object, MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord, String string2, Bundle bundle, Bundle bundle2) {
        this.this$0 = mediaBrowserServiceCompat;
        this.val$connection = mediaBrowserServiceCompat$ConnectionRecord;
        this.val$parentId = string2;
        this.val$subscribeOptions = bundle;
        this.val$notifyChildrenChangedOptions = bundle2;
        super(object);
    }

    public void onResultSent(List object) {
        Object object2 = this.this$0.mConnections;
        Object object3 = this.val$connection.callbacks.asBinder();
        object2 = ((SimpleArrayMap)object2).get(object3);
        object3 = this.val$connection;
        String string2 = "MBServiceCompat";
        if (object2 != object3) {
            boolean bl2 = MediaBrowserServiceCompat.DEBUG;
            if (bl2) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Not sending onLoadChildren result for connection that has been disconnected. pkg=");
                object2 = this.val$connection.pkg;
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(" id=");
                object2 = this.val$parentId;
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
                Log.d((String)string2, (String)object);
            }
            return;
        }
        int n10 = this.getFlags() & 1;
        if (n10 != 0) {
            object2 = this.this$0;
            object3 = this.val$subscribeOptions;
            object = ((MediaBrowserServiceCompat)((Object)object2)).applyOptions((List)object, (Bundle)object3);
        }
        object2 = this.val$connection;
        object2 = ((MediaBrowserServiceCompat$ConnectionRecord)object2).callbacks;
        object3 = this.val$parentId;
        Bundle bundle = this.val$subscribeOptions;
        Bundle bundle2 = this.val$notifyChildrenChangedOptions;
        try {
            object2.onLoadChildren((String)object3, (List)object, bundle, bundle2);
        }
        catch (RemoteException remoteException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Calling onLoadChildren() failed for id=");
            object2 = this.val$parentId;
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(" package=");
            object2 = this.val$connection.pkg;
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            Log.w((String)string2, (String)object);
        }
    }
}

