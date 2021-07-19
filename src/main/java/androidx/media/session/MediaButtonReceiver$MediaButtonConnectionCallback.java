/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver$PendingResult
 *  android.content.Context
 *  android.content.Intent
 *  android.view.KeyEvent
 */
package androidx.media.session;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompat$ConnectionCallback;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.view.KeyEvent;

public class MediaButtonReceiver$MediaButtonConnectionCallback
extends MediaBrowserCompat$ConnectionCallback {
    private final Context mContext;
    private final Intent mIntent;
    private MediaBrowserCompat mMediaBrowser;
    private final BroadcastReceiver.PendingResult mPendingResult;

    public MediaButtonReceiver$MediaButtonConnectionCallback(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
        this.mContext = context;
        this.mIntent = intent;
        this.mPendingResult = pendingResult;
    }

    private void finish() {
        this.mMediaBrowser.disconnect();
        this.mPendingResult.finish();
    }

    public void onConnected() {
        Context context = this.mContext;
        MediaSessionCompat$Token mediaSessionCompat$Token = this.mMediaBrowser.getSessionToken();
        MediaControllerCompat mediaControllerCompat = new MediaControllerCompat(context, mediaSessionCompat$Token);
        context = (KeyEvent)this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        mediaControllerCompat.dispatchMediaButtonEvent((KeyEvent)context);
        this.finish();
    }

    public void onConnectionFailed() {
        this.finish();
    }

    public void onConnectionSuspended() {
        this.finish();
    }

    public void setMediaBrowser(MediaBrowserCompat mediaBrowserCompat) {
        this.mMediaBrowser = mediaBrowserCompat;
    }
}

