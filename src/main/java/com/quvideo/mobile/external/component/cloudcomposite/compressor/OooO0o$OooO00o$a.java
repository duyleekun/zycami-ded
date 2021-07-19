/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudcomposite.compressor;

import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooO0o$OooO00o;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooOO0;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class OooO0o$OooO00o$a
extends OooOO0 {
    public final /* synthetic */ File a;

    public OooO0o$OooO00o$a(OooO0o$OooO00o oooO0o$OooO00o, File file) {
        this.a = file;
    }

    public String OooO0O0() {
        return this.a.getAbsolutePath();
    }

    public InputStream OooO0OO() {
        File file = this.a;
        FileInputStream fileInputStream = new FileInputStream(file);
        return fileInputStream;
    }
}

