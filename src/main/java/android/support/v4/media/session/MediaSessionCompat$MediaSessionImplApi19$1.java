/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.Rating
 *  android.media.RemoteControlClient$OnMetadataUpdateListener
 */
package android.support.v4.media.session;

import android.media.Rating;
import android.media.RemoteControlClient;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi19;

public class MediaSessionCompat$MediaSessionImplApi19$1
implements RemoteControlClient.OnMetadataUpdateListener {
    public final /* synthetic */ MediaSessionCompat$MediaSessionImplApi19 this$0;

    public MediaSessionCompat$MediaSessionImplApi19$1(MediaSessionCompat$MediaSessionImplApi19 mediaSessionImplApi19) {
        this.this$0 = mediaSessionImplApi19;
    }

    public void onMetadataUpdate(int n10, Object object) {
        int n11 = 0x10000001;
        if (n10 == n11 && (n10 = object instanceof Rating) != 0) {
            MediaSessionCompat$MediaSessionImplApi19 mediaSessionCompat$MediaSessionImplApi19 = this.this$0;
            int n12 = 19;
            int n13 = -1;
            int n14 = -1;
            RatingCompat ratingCompat = RatingCompat.fromRating(object);
            mediaSessionCompat$MediaSessionImplApi19.postToHandler(n12, n13, n14, ratingCompat, null);
        }
    }
}

