/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.quvideo.mobile.external.component.cloudengine.model;

import android.net.Uri;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.MediaType;

public class CompositeConfig$Media {
    private MediaType OooO00o;
    private Uri OooO0O0;

    public CompositeConfig$Media(MediaType mediaType, Uri uri) {
        this.OooO00o = mediaType;
        this.OooO0O0 = uri;
    }

    public static /* synthetic */ MediaType OooO00o(CompositeConfig$Media compositeConfig$Media) {
        return compositeConfig$Media.OooO00o;
    }

    public static /* synthetic */ Uri OooO0O0(CompositeConfig$Media compositeConfig$Media) {
        return compositeConfig$Media.OooO0O0;
    }

    public MediaType getMediaType() {
        return this.OooO00o;
    }

    public Uri getUri() {
        return this.OooO0O0;
    }
}

