/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.IBinder
 */
package androidx.media;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat$Token;
import androidx.media.MediaSessionManager$RemoteUserInfo;

public interface MediaBrowserServiceCompat$MediaBrowserServiceImpl {
    public Bundle getBrowserRootHints();

    public MediaSessionManager$RemoteUserInfo getCurrentBrowserInfo();

    public void notifyChildrenChanged(MediaSessionManager$RemoteUserInfo var1, String var2, Bundle var3);

    public void notifyChildrenChanged(String var1, Bundle var2);

    public IBinder onBind(Intent var1);

    public void onCreate();

    public void setSessionToken(MediaSessionCompat$Token var1);
}

