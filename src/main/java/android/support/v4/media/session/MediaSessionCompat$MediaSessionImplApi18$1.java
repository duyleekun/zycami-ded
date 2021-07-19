/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.RemoteControlClient$OnPlaybackPositionUpdateListener
 */
package android.support.v4.media.session;

import android.media.RemoteControlClient;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18;

public class MediaSessionCompat$MediaSessionImplApi18$1
implements RemoteControlClient.OnPlaybackPositionUpdateListener {
    public final /* synthetic */ MediaSessionCompat$MediaSessionImplApi18 this$0;

    public MediaSessionCompat$MediaSessionImplApi18$1(MediaSessionCompat$MediaSessionImplApi18 mediaSessionImplApi18) {
        this.this$0 = mediaSessionImplApi18;
    }

    public void onPlaybackPositionUpdate(long l10) {
        MediaSessionCompat$MediaSessionImplApi18 mediaSessionCompat$MediaSessionImplApi18 = this.this$0;
        Long l11 = l10;
        mediaSessionCompat$MediaSessionImplApi18.postToHandler(18, -1, -1, l11, null);
    }
}

