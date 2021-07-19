/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.util.Log
 */
package android.support.v4.media;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.media.MediaBrowserCompat$CustomActionCallback;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.util.Log;

public class MediaBrowserCompat$CustomActionResultReceiver
extends ResultReceiver {
    private final String mAction;
    private final MediaBrowserCompat$CustomActionCallback mCallback;
    private final Bundle mExtras;

    public MediaBrowserCompat$CustomActionResultReceiver(String string2, Bundle bundle, MediaBrowserCompat$CustomActionCallback mediaBrowserCompat$CustomActionCallback, Handler handler) {
        super(handler);
        this.mAction = string2;
        this.mExtras = bundle;
        this.mCallback = mediaBrowserCompat$CustomActionCallback;
    }

    public void onReceiveResult(int n10, Bundle object) {
        Object object2 = this.mCallback;
        if (object2 == null) {
            return;
        }
        MediaSessionCompat.ensureClassLoader(object);
        int n11 = -1;
        if (n10 != n11) {
            if (n10 != 0) {
                n11 = 1;
                if (n10 != n11) {
                    object2 = new StringBuilder();
                    String string2 = "Unknown result code: ";
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append(n10);
                    ((StringBuilder)object2).append(" (extras=");
                    Object object3 = this.mExtras;
                    ((StringBuilder)object2).append(object3);
                    ((StringBuilder)object2).append(", resultData=");
                    ((StringBuilder)object2).append(object);
                    ((StringBuilder)object2).append(")");
                    object3 = ((StringBuilder)object2).toString();
                    object = "MediaBrowserCompat";
                    Log.w((String)object, (String)object3);
                } else {
                    MediaBrowserCompat$CustomActionCallback mediaBrowserCompat$CustomActionCallback = this.mCallback;
                    object2 = this.mAction;
                    Bundle bundle = this.mExtras;
                    mediaBrowserCompat$CustomActionCallback.onProgressUpdate((String)object2, bundle, (Bundle)object);
                }
            } else {
                MediaBrowserCompat$CustomActionCallback mediaBrowserCompat$CustomActionCallback = this.mCallback;
                object2 = this.mAction;
                Bundle bundle = this.mExtras;
                mediaBrowserCompat$CustomActionCallback.onResult((String)object2, bundle, (Bundle)object);
            }
        } else {
            MediaBrowserCompat$CustomActionCallback mediaBrowserCompat$CustomActionCallback = this.mCallback;
            object2 = this.mAction;
            Bundle bundle = this.mExtras;
            mediaBrowserCompat$CustomActionCallback.onError((String)object2, bundle, (Bundle)object);
        }
    }
}

