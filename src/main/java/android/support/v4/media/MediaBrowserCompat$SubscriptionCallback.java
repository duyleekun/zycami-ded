/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.browse.MediaBrowser$SubscriptionCallback
 *  android.os.Binder
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 */
package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.MediaBrowserCompat$Subscription;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class MediaBrowserCompat$SubscriptionCallback {
    public final MediaBrowser.SubscriptionCallback mSubscriptionCallbackFwk;
    public WeakReference mSubscriptionRef;
    public final IBinder mToken;

    public MediaBrowserCompat$SubscriptionCallback() {
        Object object = new Binder();
        this.mToken = object;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            super(this);
            this.mSubscriptionCallbackFwk = object;
        } else {
            n11 = 21;
            if (n10 >= n11) {
                super(this);
                this.mSubscriptionCallbackFwk = object;
            } else {
                n10 = 0;
                object = null;
                this.mSubscriptionCallbackFwk = null;
            }
        }
    }

    public void onChildrenLoaded(String string2, List list) {
    }

    public void onChildrenLoaded(String string2, List list, Bundle bundle) {
    }

    public void onError(String string2) {
    }

    public void onError(String string2, Bundle bundle) {
    }

    public void setSubscription(MediaBrowserCompat$Subscription mediaBrowserCompat$Subscription) {
        WeakReference<MediaBrowserCompat$Subscription> weakReference;
        this.mSubscriptionRef = weakReference = new WeakReference<MediaBrowserCompat$Subscription>(mediaBrowserCompat$Subscription);
    }
}

