/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.browse.MediaBrowser$SubscriptionCallback
 *  android.os.Bundle
 */
package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaBrowserCompat$Subscription;
import android.support.v4.media.MediaBrowserCompat$SubscriptionCallback;
import java.lang.ref.Reference;
import java.util.Collections;
import java.util.List;

public class MediaBrowserCompat$SubscriptionCallback$SubscriptionCallbackApi21
extends MediaBrowser.SubscriptionCallback {
    public final /* synthetic */ MediaBrowserCompat$SubscriptionCallback this$0;

    public MediaBrowserCompat$SubscriptionCallback$SubscriptionCallbackApi21(MediaBrowserCompat$SubscriptionCallback mediaBrowserCompat$SubscriptionCallback) {
        this.this$0 = mediaBrowserCompat$SubscriptionCallback;
    }

    public List applyOptions(List list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        String string2 = "android.media.browse.extra.PAGE";
        int n10 = -1;
        int n11 = bundle.getInt(string2, n10);
        String string3 = "android.media.browse.extra.PAGE_SIZE";
        int n12 = bundle.getInt(string3, n10);
        if (n11 == n10 && n12 == n10) {
            return list;
        }
        n10 = n12 * n11;
        int n13 = n10 + n12;
        if (n11 >= 0 && n12 >= (n11 = 1) && n10 < (n12 = list.size())) {
            n12 = list.size();
            if (n13 > n12) {
                n13 = list.size();
            }
            return list.subList(n10, n13);
        }
        return Collections.emptyList();
    }

    public void onChildrenLoaded(String string2, List list) {
        Object object = this.this$0.mSubscriptionRef;
        object = object == null ? null : (MediaBrowserCompat$Subscription)((Reference)object).get();
        if (object == null) {
            object = this.this$0;
            list = MediaBrowserCompat$MediaItem.fromMediaItemList(list);
            ((MediaBrowserCompat$SubscriptionCallback)object).onChildrenLoaded(string2, list);
        } else {
            int n10;
            list = MediaBrowserCompat$MediaItem.fromMediaItemList(list);
            List list2 = ((MediaBrowserCompat$Subscription)object).getCallbacks();
            object = ((MediaBrowserCompat$Subscription)object).getOptionsList();
            for (int i10 = 0; i10 < (n10 = list2.size()); ++i10) {
                Object object2 = (Bundle)object.get(i10);
                if (object2 == null) {
                    object2 = this.this$0;
                    ((MediaBrowserCompat$SubscriptionCallback)object2).onChildrenLoaded(string2, list);
                    continue;
                }
                MediaBrowserCompat$SubscriptionCallback mediaBrowserCompat$SubscriptionCallback = this.this$0;
                List list3 = this.applyOptions(list, (Bundle)object2);
                mediaBrowserCompat$SubscriptionCallback.onChildrenLoaded(string2, list3, (Bundle)object2);
            }
        }
    }

    public void onError(String string2) {
        this.this$0.onError(string2);
    }
}

