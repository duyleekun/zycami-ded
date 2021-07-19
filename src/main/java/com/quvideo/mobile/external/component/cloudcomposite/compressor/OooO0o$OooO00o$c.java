/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.net.Uri
 */
package com.quvideo.mobile.external.component.cloudcomposite.compressor;

import android.content.ContentResolver;
import android.net.Uri;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooO0o$OooO00o;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooOO0;
import java.io.InputStream;

public class OooO0o$OooO00o$c
extends OooOO0 {
    public final /* synthetic */ Uri a;
    public final /* synthetic */ OooO0o$OooO00o b;

    public OooO0o$OooO00o$c(OooO0o$OooO00o oooO0o$OooO00o, Uri uri) {
        this.b = oooO0o$OooO00o;
        this.a = uri;
    }

    public String OooO0O0() {
        return this.a.getPath();
    }

    public InputStream OooO0OO() {
        ContentResolver contentResolver = OooO0o$OooO00o.OooO0OO(this.b).getContentResolver();
        Uri uri = this.a;
        return contentResolver.openInputStream(uri);
    }
}

