/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 */
package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.session.MediaSessionCompat$Token;
import java.util.List;

public interface MediaBrowserServiceCompat$ServiceCallbacks {
    public IBinder asBinder();

    public void onConnect(String var1, MediaSessionCompat$Token var2, Bundle var3);

    public void onConnectFailed();

    public void onLoadChildren(String var1, List var2, Bundle var3, Bundle var4);
}

