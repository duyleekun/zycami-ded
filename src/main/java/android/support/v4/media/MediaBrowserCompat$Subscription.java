/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat$SubscriptionCallback;
import androidx.media.MediaBrowserCompatUtils;
import java.util.ArrayList;
import java.util.List;

public class MediaBrowserCompat$Subscription {
    private final List mCallbacks;
    private final List mOptionsList;

    public MediaBrowserCompat$Subscription() {
        ArrayList arrayList;
        this.mCallbacks = arrayList = new ArrayList();
        this.mOptionsList = arrayList = new ArrayList();
    }

    public MediaBrowserCompat$SubscriptionCallback getCallback(Bundle bundle) {
        List list;
        int n10;
        for (int i10 = 0; i10 < (n10 = (list = this.mOptionsList).size()); ++i10) {
            list = (Bundle)this.mOptionsList.get(i10);
            n10 = MediaBrowserCompatUtils.areSameOptions((Bundle)list, bundle) ? 1 : 0;
            if (n10 == 0) continue;
            return (MediaBrowserCompat$SubscriptionCallback)this.mCallbacks.get(i10);
        }
        return null;
    }

    public List getCallbacks() {
        return this.mCallbacks;
    }

    public List getOptionsList() {
        return this.mOptionsList;
    }

    public boolean isEmpty() {
        return this.mCallbacks.isEmpty();
    }

    public void putCallback(Bundle bundle, MediaBrowserCompat$SubscriptionCallback mediaBrowserCompat$SubscriptionCallback) {
        List list;
        int n10;
        for (int i10 = 0; i10 < (n10 = (list = this.mOptionsList).size()); ++i10) {
            list = (Bundle)this.mOptionsList.get(i10);
            n10 = MediaBrowserCompatUtils.areSameOptions((Bundle)list, bundle) ? 1 : 0;
            if (n10 == 0) continue;
            this.mCallbacks.set(i10, mediaBrowserCompat$SubscriptionCallback);
            return;
        }
        this.mCallbacks.add(mediaBrowserCompat$SubscriptionCallback);
        this.mOptionsList.add(bundle);
    }
}

