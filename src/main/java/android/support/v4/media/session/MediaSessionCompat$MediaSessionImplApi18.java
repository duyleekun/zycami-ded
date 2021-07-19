/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.Context
 *  android.media.AudioManager
 *  android.media.RemoteControlClient
 *  android.media.RemoteControlClient$OnPlaybackPositionUpdateListener
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.SystemClock
 *  android.util.Log
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat$Callback;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18$1;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import androidx.versionedparcelable.VersionedParcelable;

public class MediaSessionCompat$MediaSessionImplApi18
extends MediaSessionCompat$MediaSessionImplBase {
    private static boolean sIsMbrPendingIntentSupported = true;

    public MediaSessionCompat$MediaSessionImplApi18(Context context, String string2, ComponentName componentName, PendingIntent pendingIntent, VersionedParcelable versionedParcelable, Bundle bundle) {
        super(context, string2, componentName, pendingIntent, versionedParcelable, bundle);
    }

    public int getRccTransportControlFlagsFromActions(long l10) {
        int n10 = super.getRccTransportControlFlagsFromActions(l10);
        long l11 = 0L;
        long l12 = (l10 &= 0x100L) - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            n10 |= 0x100;
        }
        return n10;
    }

    public void registerMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
        boolean bl2 = sIsMbrPendingIntentSupported;
        if (bl2) {
            AudioManager audioManager = this.mAudioManager;
            try {
                audioManager.registerMediaButtonEventReceiver(pendingIntent);
            }
            catch (NullPointerException nullPointerException) {
                String string2 = "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.";
                Log.w((String)"MediaSessionCompat", (String)string2);
                bl2 = false;
                audioManager = null;
                sIsMbrPendingIntentSupported = false;
            }
        }
        if (!(bl2 = sIsMbrPendingIntentSupported)) {
            super.registerMediaButtonEventReceiver(pendingIntent, componentName);
        }
    }

    public void setCallback(MediaSessionCompat$Callback object, Handler handler) {
        super.setCallback((MediaSessionCompat$Callback)object, handler);
        if (object == null) {
            object = this.mRcc;
            handler = null;
            object.setPlaybackPositionUpdateListener(null);
        } else {
            object = new MediaSessionCompat$MediaSessionImplApi18$1(this);
            handler = this.mRcc;
            handler.setPlaybackPositionUpdateListener((RemoteControlClient.OnPlaybackPositionUpdateListener)object);
        }
    }

    public void setRccState(PlaybackStateCompat playbackStateCompat) {
        RemoteControlClient remoteControlClient;
        long l10;
        long l11;
        Object object;
        int n10;
        long l12 = playbackStateCompat.getPosition();
        float f10 = playbackStateCompat.getPlaybackSpeed();
        long l13 = playbackStateCompat.getLastPositionUpdateTime();
        long l14 = SystemClock.elapsedRealtime();
        int n11 = playbackStateCompat.getState();
        if (n11 == (n10 = 3) && (object = (l11 = l12 - (l10 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) > 0) {
            object = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1);
            if (object > 0) {
                float f11;
                l10 = l14 - l13;
                float f12 = 0.0f;
                remoteControlClient = null;
                float f13 = f10 - 0.0f;
                Object object2 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
                if (object2 > 0 && (object2 = (f11 = f10 - (f12 = 1.0f)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) != false) {
                    f12 = (float)l10 * f10;
                    l10 = (long)f12;
                }
            }
            l12 += l10;
        }
        remoteControlClient = this.mRcc;
        int n12 = playbackStateCompat.getState();
        n12 = this.getRccStateFromState(n12);
        remoteControlClient.setPlaybackState(n12, l12, f10);
    }

    public void unregisterMediaButtonEventReceiver(PendingIntent pendingIntent, ComponentName componentName) {
        boolean bl2 = sIsMbrPendingIntentSupported;
        if (bl2) {
            componentName = this.mAudioManager;
            componentName.unregisterMediaButtonEventReceiver(pendingIntent);
        } else {
            super.unregisterMediaButtonEventReceiver(pendingIntent, componentName);
        }
    }
}

