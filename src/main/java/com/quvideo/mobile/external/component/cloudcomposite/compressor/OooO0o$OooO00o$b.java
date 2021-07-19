/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.component.cloudcomposite.compressor;

import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooO0o$OooO00o;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooOO0;
import java.io.FileInputStream;
import java.io.InputStream;

public class OooO0o$OooO00o$b
extends OooOO0 {
    public final /* synthetic */ String a;

    public OooO0o$OooO00o$b(OooO0o$OooO00o oooO0o$OooO00o, String string2) {
        this.a = string2;
    }

    public String OooO0O0() {
        return this.a;
    }

    public InputStream OooO0OO() {
        String string2 = this.a;
        FileInputStream fileInputStream = new FileInputStream(string2);
        return fileInputStream;
    }
}

