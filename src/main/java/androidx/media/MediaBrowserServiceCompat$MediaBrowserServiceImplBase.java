/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Messenger
 */
package androidx.media;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat$Token;
import androidx.core.util.Pair;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaBrowserServiceCompat$ConnectionRecord;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImpl;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$2;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$3;
import androidx.media.MediaBrowserServiceCompat$ServiceHandler;
import androidx.media.MediaSessionManager$RemoteUserInfo;
import java.util.List;

public class MediaBrowserServiceCompat$MediaBrowserServiceImplBase
implements MediaBrowserServiceCompat$MediaBrowserServiceImpl {
    private Messenger mMessenger;
    public final /* synthetic */ MediaBrowserServiceCompat this$0;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplBase(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.this$0 = mediaBrowserServiceCompat;
    }

    public Bundle getBrowserRootHints() {
        Object object = this.this$0.mCurConnection;
        if (object != null) {
            object = ((MediaBrowserServiceCompat$ConnectionRecord)object).rootHints;
            if (object == null) {
                object = null;
            } else {
                Bundle bundle = this.this$0.mCurConnection.rootHints;
                object = new Bundle(bundle);
            }
            return object;
        }
        object = new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        throw object;
    }

    public MediaSessionManager$RemoteUserInfo getCurrentBrowserInfo() {
        Object object = this.this$0.mCurConnection;
        if (object != null) {
            return ((MediaBrowserServiceCompat$ConnectionRecord)object).browserInfo;
        }
        object = new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        throw object;
    }

    public void notifyChildrenChanged(MediaSessionManager$RemoteUserInfo mediaSessionManager$RemoteUserInfo, String string2, Bundle bundle) {
        MediaBrowserServiceCompat$ServiceHandler mediaBrowserServiceCompat$ServiceHandler = this.this$0.mHandler;
        MediaBrowserServiceCompat$MediaBrowserServiceImplBase$3 mediaBrowserServiceCompat$MediaBrowserServiceImplBase$3 = new MediaBrowserServiceCompat$MediaBrowserServiceImplBase$3(this, mediaSessionManager$RemoteUserInfo, string2, bundle);
        mediaBrowserServiceCompat$ServiceHandler.post(mediaBrowserServiceCompat$MediaBrowserServiceImplBase$3);
    }

    public void notifyChildrenChanged(String string2, Bundle bundle) {
        MediaBrowserServiceCompat$ServiceHandler mediaBrowserServiceCompat$ServiceHandler = this.this$0.mHandler;
        MediaBrowserServiceCompat$MediaBrowserServiceImplBase$2 mediaBrowserServiceCompat$MediaBrowserServiceImplBase$2 = new MediaBrowserServiceCompat$MediaBrowserServiceImplBase$2(this, string2, bundle);
        mediaBrowserServiceCompat$ServiceHandler.post(mediaBrowserServiceCompat$MediaBrowserServiceImplBase$2);
    }

    public void notifyChildrenChangedOnHandler(MediaBrowserServiceCompat$ConnectionRecord mediaBrowserServiceCompat$ConnectionRecord, String string2, Bundle bundle) {
        Object object = (List)mediaBrowserServiceCompat$ConnectionRecord.subscriptions.get(string2);
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                Pair pair = (Pair)object.next();
                Object object2 = (Bundle)pair.second;
                boolean bl3 = MediaBrowserCompatUtils.hasDuplicatedItems(bundle, (Bundle)object2);
                if (!bl3) continue;
                object2 = this.this$0;
                pair = (Bundle)pair.second;
                ((MediaBrowserServiceCompat)((Object)object2)).performLoadChildren(string2, mediaBrowserServiceCompat$ConnectionRecord, (Bundle)pair, bundle);
            }
        }
    }

    public IBinder onBind(Intent object) {
        String string2 = "android.media.browse.MediaBrowserService";
        boolean bl2 = string2.equals(object = object.getAction());
        if (bl2) {
            return this.mMessenger.getBinder();
        }
        return null;
    }

    public void onCreate() {
        Messenger messenger;
        MediaBrowserServiceCompat$ServiceHandler mediaBrowserServiceCompat$ServiceHandler = this.this$0.mHandler;
        this.mMessenger = messenger = new Messenger((Handler)mediaBrowserServiceCompat$ServiceHandler);
    }

    public void setSessionToken(MediaSessionCompat$Token mediaSessionCompat$Token) {
        MediaBrowserServiceCompat$ServiceHandler mediaBrowserServiceCompat$ServiceHandler = this.this$0.mHandler;
        MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1 mediaBrowserServiceCompat$MediaBrowserServiceImplBase$1 = new MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1(this, mediaSessionCompat$Token);
        mediaBrowserServiceCompat$ServiceHandler.post(mediaBrowserServiceCompat$MediaBrowserServiceImplBase$1);
    }
}

