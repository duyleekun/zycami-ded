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
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.util.Log;
import androidx.media.MediaBrowserServiceCompat$BrowserRoot;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase;
import java.util.Iterator;

public class MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1
implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplBase this$1;
    public final /* synthetic */ MediaSessionCompat$Token val$token;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1(MediaBrowserServiceCompat$MediaBrowserServiceImplBase mediaBrowserServiceImplBase, MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.this$1 = mediaBrowserServiceImplBase;
        this.val$token = mediaSessionCompat$Token;
    }

    public void run() {
        boolean bl2;
        Iterator iterator2 = this.this$1.this$0.mConnections.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (MediaBrowserServiceCompat$ConnectionRecord)iterator2.next();
            Object object2 = ((MediaBrowserServiceCompat$ConnectionRecord)object).callbacks;
            Object object3 = ((MediaBrowserServiceCompat$ConnectionRecord)object).root;
            object3 = ((MediaBrowserServiceCompat$BrowserRoot)object3).getRootId();
            MediaSessionCompat$Token mediaSessionCompat$Token = this.val$token;
            MediaBrowserServiceCompat$BrowserRoot mediaBrowserServiceCompat$BrowserRoot = ((MediaBrowserServiceCompat$ConnectionRecord)object).root;
            mediaBrowserServiceCompat$BrowserRoot = mediaBrowserServiceCompat$BrowserRoot.getExtras();
            try {
                object2.onConnect((String)object3, mediaSessionCompat$Token, (Bundle)mediaBrowserServiceCompat$BrowserRoot);
            }
            catch (RemoteException remoteException) {
                object2 = new StringBuilder();
                object3 = "Connection for ";
                ((StringBuilder)object2).append((String)object3);
                object = ((MediaBrowserServiceCompat$ConnectionRecord)object).pkg;
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(" is no longer valid.");
                object = ((StringBuilder)object2).toString();
                object2 = "MBServiceCompat";
                Log.w((String)object2, (String)object);
                iterator2.remove();
            }
        }
    }
}

