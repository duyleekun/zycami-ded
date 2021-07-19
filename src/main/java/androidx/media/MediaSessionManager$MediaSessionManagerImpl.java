/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.media;

import android.content.Context;
import androidx.media.MediaSessionManager$RemoteUserInfoImpl;

public interface MediaSessionManager$MediaSessionManagerImpl {
    public Context getContext();

    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl var1);
}

