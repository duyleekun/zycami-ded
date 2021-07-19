/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.media;

import android.os.Bundle;

public final class MediaBrowserServiceCompat$BrowserRoot {
    public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
    public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
    public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";
    public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
    private final Bundle mExtras;
    private final String mRootId;

    public MediaBrowserServiceCompat$BrowserRoot(String object, Bundle bundle) {
        if (object != null) {
            this.mRootId = object;
            this.mExtras = bundle;
            return;
        }
        object = new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead");
        throw object;
    }

    public static /* synthetic */ String access$000(MediaBrowserServiceCompat$BrowserRoot mediaBrowserServiceCompat$BrowserRoot) {
        return mediaBrowserServiceCompat$BrowserRoot.mRootId;
    }

    public static /* synthetic */ Bundle access$100(MediaBrowserServiceCompat$BrowserRoot mediaBrowserServiceCompat$BrowserRoot) {
        return mediaBrowserServiceCompat$BrowserRoot.mExtras;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getRootId() {
        return this.mRootId;
    }
}

