/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package android.support.v4.media.session;

import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat$Callback;
import android.support.v4.media.session.MediaControllerCompat$Callback$StubCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import java.util.List;

public class MediaControllerCompat$MediaControllerImplApi21$ExtraCallback
extends MediaControllerCompat$Callback$StubCompat {
    public MediaControllerCompat$MediaControllerImplApi21$ExtraCallback(MediaControllerCompat$Callback mediaControllerCompat$Callback) {
        super(mediaControllerCompat$Callback);
    }

    public void onExtrasChanged(Bundle object) {
        object = new AssertionError();
        throw object;
    }

    public void onMetadataChanged(MediaMetadataCompat object) {
        object = new AssertionError();
        throw object;
    }

    public void onQueueChanged(List object) {
        object = new AssertionError();
        throw object;
    }

    public void onQueueTitleChanged(CharSequence object) {
        object = new AssertionError();
        throw object;
    }

    public void onSessionDestroyed() {
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    public void onVolumeInfoChanged(ParcelableVolumeInfo object) {
        object = new AssertionError();
        throw object;
    }
}

