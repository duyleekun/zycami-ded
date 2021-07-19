/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2;

import android.net.Uri;
import com.google.android.exoplayer2.util.Util;

public final class MediaItem$Subtitle {
    public final String label;
    public final String language;
    public final String mimeType;
    public final int roleFlags;
    public final int selectionFlags;
    public final Uri uri;

    public MediaItem$Subtitle(Uri uri, String string2, String string3) {
        this(uri, string2, string3, 0);
    }

    public MediaItem$Subtitle(Uri uri, String string2, String string3, int n10) {
        this(uri, string2, string3, n10, 0, null);
    }

    public MediaItem$Subtitle(Uri uri, String string2, String string3, int n10, int n11, String string4) {
        this.uri = uri;
        this.mimeType = string2;
        this.language = string3;
        this.selectionFlags = n10;
        this.roleFlags = n11;
        this.label = string4;
    }

    public boolean equals(Object object) {
        boolean bl2;
        int n10;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        int n11 = object instanceof MediaItem$Subtitle;
        if (n11 == 0) {
            return false;
        }
        object = (MediaItem$Subtitle)object;
        Object object2 = this.uri;
        Object object3 = ((MediaItem$Subtitle)object).uri;
        n11 = object2.equals(object3);
        if (n11 == 0 || (n11 = ((String)(object2 = this.mimeType)).equals(object3 = ((MediaItem$Subtitle)object).mimeType)) == 0 || (n11 = Util.areEqual(object2 = this.language, object3 = ((MediaItem$Subtitle)object).language)) == 0 || (n11 = this.selectionFlags) != (n10 = ((MediaItem$Subtitle)object).selectionFlags) || (n11 = this.roleFlags) != (n10 = ((MediaItem$Subtitle)object).roleFlags) || !(bl2 = Util.areEqual(object2 = this.label, object = ((MediaItem$Subtitle)object).label))) {
            bl3 = false;
        }
        return bl3;
    }

    public int hashCode() {
        Uri uri = this.uri;
        int n10 = uri.hashCode() * 31;
        int n11 = this.mimeType.hashCode();
        n10 = (n10 + n11) * 31;
        String string2 = this.language;
        int n12 = 0;
        if (string2 == null) {
            n11 = 0;
            string2 = null;
        } else {
            n11 = string2.hashCode();
        }
        n10 = (n10 + n11) * 31;
        n11 = this.selectionFlags;
        n10 = (n10 + n11) * 31;
        n11 = this.roleFlags;
        n10 = (n10 + n11) * 31;
        string2 = this.label;
        if (string2 != null) {
            n12 = string2.hashCode();
        }
        return n10 + n12;
    }
}

