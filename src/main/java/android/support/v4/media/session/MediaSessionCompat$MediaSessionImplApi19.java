/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.Context
 *  android.media.RemoteControlClient$MetadataEditor
 *  android.media.RemoteControlClient$OnMetadataUpdateListener
 *  android.os.Bundle
 *  android.os.Handler
 */
package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.media.RemoteControlClient;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.media.session.MediaSessionCompat$Callback;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi19$1;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.versionedparcelable.VersionedParcelable;

public class MediaSessionCompat$MediaSessionImplApi19
extends MediaSessionCompat$MediaSessionImplApi18 {
    public MediaSessionCompat$MediaSessionImplApi19(Context context, String string2, ComponentName componentName, PendingIntent pendingIntent, VersionedParcelable versionedParcelable, Bundle bundle) {
        super(context, string2, componentName, pendingIntent, versionedParcelable, bundle);
    }

    public RemoteControlClient.MetadataEditor buildRccMetadata(Bundle bundle) {
        RemoteControlClient.MetadataEditor metadataEditor = super.buildRccMetadata(bundle);
        Object object = this.mState;
        long l10 = 0L;
        long l11 = object == null ? l10 : ((PlaybackStateCompat)object).getActions();
        long l12 = 128L;
        long l13 = (l11 &= l12) - l10;
        long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        int n10 = 0x10000001;
        if (l14 != false) {
            metadataEditor.addEditableKey(n10);
        }
        if (bundle == null) {
            return metadataEditor;
        }
        object = "android.media.metadata.YEAR";
        int n11 = bundle.containsKey((String)object);
        if (n11 != 0) {
            n11 = 8;
            l11 = bundle.getLong((String)object);
            metadataEditor.putLong(n11, l11);
        }
        if ((n11 = (int)(bundle.containsKey((String)(object = "android.media.metadata.RATING")) ? 1 : 0)) != 0) {
            n11 = 101;
            object = bundle.getParcelable((String)object);
            metadataEditor.putObject(n11, object);
        }
        if ((n11 = (int)(bundle.containsKey((String)(object = "android.media.metadata.USER_RATING")) ? 1 : 0)) != 0) {
            bundle = bundle.getParcelable((String)object);
            metadataEditor.putObject(n10, (Object)bundle);
        }
        return metadataEditor;
    }

    public int getRccTransportControlFlagsFromActions(long l10) {
        int n10 = super.getRccTransportControlFlagsFromActions(l10);
        long l11 = 0L;
        long l12 = (l10 &= 0x80L) - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            n10 |= 0x200;
        }
        return n10;
    }

    public void setCallback(MediaSessionCompat$Callback object, Handler handler) {
        super.setCallback((MediaSessionCompat$Callback)object, handler);
        if (object == null) {
            object = this.mRcc;
            handler = null;
            object.setMetadataUpdateListener(null);
        } else {
            object = new MediaSessionCompat$MediaSessionImplApi19$1(this);
            handler = this.mRcc;
            handler.setMetadataUpdateListener((RemoteControlClient.OnMetadataUpdateListener)object);
        }
    }
}

