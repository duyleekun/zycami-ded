/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package d.h.a.a.m0.o.g;

import android.net.Uri;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker$MediaPlaylistBundle;

public final class a
implements Runnable {
    public final /* synthetic */ DefaultHlsPlaylistTracker$MediaPlaylistBundle a;
    public final /* synthetic */ Uri b;

    public /* synthetic */ a(DefaultHlsPlaylistTracker$MediaPlaylistBundle mediaPlaylistBundle, Uri uri) {
        this.a = mediaPlaylistBundle;
        this.b = uri;
    }

    public final void run() {
        DefaultHlsPlaylistTracker$MediaPlaylistBundle defaultHlsPlaylistTracker$MediaPlaylistBundle = this.a;
        Uri uri = this.b;
        defaultHlsPlaylistTracker$MediaPlaylistBundle.b(uri);
    }
}

