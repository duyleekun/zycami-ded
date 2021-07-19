/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.os.Bundle
 */
package android.support.v4.media;

import android.content.ComponentName;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat$CustomActionCallback;
import android.support.v4.media.MediaBrowserCompat$ItemCallback;
import android.support.v4.media.MediaBrowserCompat$SearchCallback;
import android.support.v4.media.MediaBrowserCompat$SubscriptionCallback;
import android.support.v4.media.session.MediaSessionCompat$Token;

public interface MediaBrowserCompat$MediaBrowserImpl {
    public void connect();

    public void disconnect();

    public Bundle getExtras();

    public void getItem(String var1, MediaBrowserCompat$ItemCallback var2);

    public Bundle getNotifyChildrenChangedOptions();

    public String getRoot();

    public ComponentName getServiceComponent();

    public MediaSessionCompat$Token getSessionToken();

    public boolean isConnected();

    public void search(String var1, Bundle var2, MediaBrowserCompat.SearchCallback var3);

    public void sendCustomAction(String var1, Bundle var2, MediaBrowserCompat$CustomActionCallback var3);

    public void subscribe(String var1, Bundle var2, MediaBrowserCompat.SubscriptionCallback var3);

    public void unsubscribe(String var1, MediaBrowserCompat.SubscriptionCallback var2);
}

