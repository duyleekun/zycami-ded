/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.MediaMetadata;

public final class MediaMetadata$Builder {
    private String title;

    public MediaMetadata build() {
        String string2 = this.title;
        MediaMetadata mediaMetadata = new MediaMetadata(string2, null);
        return mediaMetadata;
    }

    public MediaMetadata$Builder setTitle(String string2) {
        this.title = string2;
        return this;
    }
}

