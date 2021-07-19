/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.session.MediaSession$Token
 *  android.os.Bundle
 *  android.os.IBinder
 */
package androidx.media;

import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat$Token;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21;

public class MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$1
implements Runnable {
    public final /* synthetic */ MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 this$1;
    public final /* synthetic */ MediaSessionCompat$Token val$token;

    public MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$1(MediaBrowserServiceCompat$MediaBrowserServiceImplApi21 mediaBrowserServiceImplApi21, MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.this$1 = mediaBrowserServiceImplApi21;
        this.val$token = mediaSessionCompat$Token;
    }

    public void run() {
        Object object;
        Object object2 = this.this$1.mRootExtrasList;
        boolean bl2 = object2.isEmpty();
        if (!bl2) {
            object2 = this.val$token.getExtraBinder();
            if (object2 != null) {
                boolean bl3;
                object = this.this$1.mRootExtrasList.iterator();
                while (bl3 = object.hasNext()) {
                    Bundle bundle = (Bundle)object.next();
                    IBinder iBinder = object2.asBinder();
                    String string2 = "extra_session_binder";
                    BundleCompat.putBinder(bundle, string2, iBinder);
                }
            }
            object2 = this.this$1.mRootExtrasList;
            object2.clear();
        }
        object2 = this.this$1.mServiceFwk;
        object = (MediaSession.Token)this.val$token.getToken();
        object2.setSessionToken((MediaSession.Token)object);
    }
}

