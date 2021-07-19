/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Messenger
 */
package android.support.v4.media;

import android.os.Bundle;
import android.os.Messenger;
import android.support.v4.media.session.MediaSessionCompat$Token;
import java.util.List;

public interface MediaBrowserCompat$MediaBrowserServiceCallbackImpl {
    public void onConnectionFailed(Messenger var1);

    public void onLoadChildren(Messenger var1, String var2, List var3, Bundle var4, Bundle var5);

    public void onServiceConnected(Messenger var1, String var2, MediaSessionCompat$Token var3, Bundle var4);
}

