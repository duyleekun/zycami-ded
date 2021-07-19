/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.Log
 */
package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat$ConnectionCallback;
import android.support.v4.media.MediaBrowserCompat$CustomActionCallback;
import android.support.v4.media.MediaBrowserCompat$ItemCallback;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImpl;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi23;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi26;
import android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase;
import android.support.v4.media.MediaBrowserCompat$SearchCallback;
import android.support.v4.media.MediaBrowserCompat$SubscriptionCallback;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.text.TextUtils;
import android.util.Log;

public final class MediaBrowserCompat {
    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    public static final boolean DEBUG = false;
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    public static final String TAG = "MediaBrowserCompat";
    private final MediaBrowserCompat$MediaBrowserImpl mImpl;

    static {
        DEBUG = Log.isLoggable((String)TAG, (int)3);
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, MediaBrowserCompat$ConnectionCallback mediaBrowserCompat$ConnectionCallback, Bundle bundle) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            MediaBrowserCompat$MediaBrowserImplApi26 mediaBrowserCompat$MediaBrowserImplApi26 = new MediaBrowserCompat$MediaBrowserImplApi26(context, componentName, mediaBrowserCompat$ConnectionCallback, bundle);
            this.mImpl = mediaBrowserCompat$MediaBrowserImplApi26;
        } else {
            n11 = 23;
            if (n10 >= n11) {
                MediaBrowserCompat$MediaBrowserImplApi23 mediaBrowserCompat$MediaBrowserImplApi23 = new MediaBrowserCompat$MediaBrowserImplApi23(context, componentName, mediaBrowserCompat$ConnectionCallback, bundle);
                this.mImpl = mediaBrowserCompat$MediaBrowserImplApi23;
            } else {
                n11 = 21;
                if (n10 >= n11) {
                    MediaBrowserCompat$MediaBrowserImplApi21 mediaBrowserCompat$MediaBrowserImplApi21 = new MediaBrowserCompat$MediaBrowserImplApi21(context, componentName, mediaBrowserCompat$ConnectionCallback, bundle);
                    this.mImpl = mediaBrowserCompat$MediaBrowserImplApi21;
                } else {
                    MediaBrowserCompat$MediaBrowserImplBase mediaBrowserCompat$MediaBrowserImplBase = new MediaBrowserCompat$MediaBrowserImplBase(context, componentName, mediaBrowserCompat$ConnectionCallback, bundle);
                    this.mImpl = mediaBrowserCompat$MediaBrowserImplBase;
                }
            }
        }
    }

    public void connect() {
        Log.d((String)TAG, (String)"Connecting to a MediaBrowserService.");
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public void getItem(String string2, MediaBrowserCompat$ItemCallback mediaBrowserCompat$ItemCallback) {
        this.mImpl.getItem(string2, mediaBrowserCompat$ItemCallback);
    }

    public Bundle getNotifyChildrenChangedOptions() {
        return this.mImpl.getNotifyChildrenChangedOptions();
    }

    public String getRoot() {
        return this.mImpl.getRoot();
    }

    public ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    public MediaSessionCompat$Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    public void search(String object, Bundle bundle, MediaBrowserCompat$SearchCallback mediaBrowserCompat$SearchCallback) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            if (mediaBrowserCompat$SearchCallback != null) {
                this.mImpl.search((String)object, bundle, mediaBrowserCompat$SearchCallback);
                return;
            }
            object = new IllegalArgumentException("callback cannot be null");
            throw object;
        }
        object = new IllegalArgumentException("query cannot be empty");
        throw object;
    }

    public void sendCustomAction(String object, Bundle bundle, MediaBrowserCompat$CustomActionCallback mediaBrowserCompat$CustomActionCallback) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            this.mImpl.sendCustomAction((String)object, bundle, mediaBrowserCompat$CustomActionCallback);
            return;
        }
        object = new IllegalArgumentException("action cannot be empty");
        throw object;
    }

    public void subscribe(String object, Bundle bundle, MediaBrowserCompat$SubscriptionCallback mediaBrowserCompat$SubscriptionCallback) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            if (mediaBrowserCompat$SubscriptionCallback != null) {
                if (bundle != null) {
                    this.mImpl.subscribe((String)object, bundle, mediaBrowserCompat$SubscriptionCallback);
                    return;
                }
                object = new IllegalArgumentException("options are null");
                throw object;
            }
            object = new IllegalArgumentException("callback is null");
            throw object;
        }
        object = new IllegalArgumentException("parentId is empty");
        throw object;
    }

    public void subscribe(String object, MediaBrowserCompat$SubscriptionCallback mediaBrowserCompat$SubscriptionCallback) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            if (mediaBrowserCompat$SubscriptionCallback != null) {
                this.mImpl.subscribe((String)object, null, mediaBrowserCompat$SubscriptionCallback);
                return;
            }
            object = new IllegalArgumentException("callback is null");
            throw object;
        }
        object = new IllegalArgumentException("parentId is empty");
        throw object;
    }

    public void unsubscribe(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            this.mImpl.unsubscribe((String)object, null);
            return;
        }
        object = new IllegalArgumentException("parentId is empty");
        throw object;
    }

    public void unsubscribe(String object, MediaBrowserCompat$SubscriptionCallback mediaBrowserCompat$SubscriptionCallback) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            if (mediaBrowserCompat$SubscriptionCallback != null) {
                this.mImpl.unsubscribe((String)object, mediaBrowserCompat$SubscriptionCallback);
                return;
            }
            object = new IllegalArgumentException("callback is null");
            throw object;
        }
        object = new IllegalArgumentException("parentId is empty");
        throw object;
    }
}

