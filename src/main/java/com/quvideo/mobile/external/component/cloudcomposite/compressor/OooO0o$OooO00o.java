/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 */
package com.quvideo.mobile.external.component.cloudcomposite.compressor;

import android.content.Context;
import android.net.Uri;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooO0O0;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooO0o;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooO0o$OooO00o$a;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooO0o$OooO00o$b;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooO0o$OooO00o$c;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooOOO;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooOOO0;
import java.io.File;
import java.util.List;

public class OooO0o$OooO00o {
    private List OooO;
    private Context OooO00o;
    private String OooO0O0;
    private int OooO0OO = 100;
    private int OooO0Oo = 60;
    private OooOOO OooO0o;
    private boolean OooO0o0 = false;
    private OooOOO0 OooO0oO;
    private OooO0O0 OooO0oo;

    public OooO0o$OooO00o(Context object) {
        this.OooO00o = object;
        this.OooO = object;
    }

    public static /* synthetic */ OooO0O0 OooO(OooO0o$OooO00o oooO0o$OooO00o) {
        return oooO0o$OooO00o.OooO0oo;
    }

    private OooO0o OooO00o() {
        OooO0o oooO0o = new OooO0o(this, null);
        return oooO0o;
    }

    public static /* synthetic */ String OooO00o(OooO0o$OooO00o oooO0o$OooO00o) {
        return oooO0o$OooO00o.OooO0O0;
    }

    public static /* synthetic */ OooOOO OooO0O0(OooO0o$OooO00o oooO0o$OooO00o) {
        return oooO0o$OooO00o.OooO0o;
    }

    public static /* synthetic */ Context OooO0OO(OooO0o$OooO00o oooO0o$OooO00o) {
        return oooO0o$OooO00o.OooO00o;
    }

    public static /* synthetic */ List OooO0Oo(OooO0o$OooO00o oooO0o$OooO00o) {
        return oooO0o$OooO00o.OooO;
    }

    public static /* synthetic */ int OooO0o(OooO0o$OooO00o oooO0o$OooO00o) {
        return oooO0o$OooO00o.OooO0OO;
    }

    public static /* synthetic */ OooOOO0 OooO0o0(OooO0o$OooO00o oooO0o$OooO00o) {
        return oooO0o$OooO00o.OooO0oO;
    }

    public static /* synthetic */ int OooO0oO(OooO0o$OooO00o oooO0o$OooO00o) {
        return oooO0o$OooO00o.OooO0Oo;
    }

    public static /* synthetic */ boolean OooO0oo(OooO0o$OooO00o oooO0o$OooO00o) {
        return oooO0o$OooO00o.OooO0o0;
    }

    public OooO0o$OooO00o OooO00o(int n10) {
        this.OooO0OO = n10;
        return this;
    }

    public OooO0o$OooO00o OooO00o(Uri uri) {
        List list = this.OooO;
        OooO0o$OooO00o$c oooO0o$OooO00o$c = new OooO0o$OooO00o$c(this, uri);
        list.add(oooO0o$OooO00o$c);
        return this;
    }

    public OooO0o$OooO00o OooO00o(File file) {
        List list = this.OooO;
        OooO0o$OooO00o$a oooO0o$OooO00o$a = new OooO0o$OooO00o$a(this, file);
        list.add(oooO0o$OooO00o$a);
        return this;
    }

    public OooO0o$OooO00o OooO00o(String string2) {
        List list = this.OooO;
        OooO0o$OooO00o$b oooO0o$OooO00o$b = new OooO0o$OooO00o$b(this, string2);
        list.add(oooO0o$OooO00o$b);
        return this;
    }

    public OooO0o$OooO00o OooO00o(List object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            boolean bl3 = object2 instanceof String;
            if (bl3) {
                object2 = (String)object2;
                this.OooO00o((String)object2);
                continue;
            }
            bl3 = object2 instanceof File;
            if (bl3) {
                object2 = (File)object2;
                this.OooO00o((File)object2);
                continue;
            }
            bl3 = object2 instanceof Uri;
            if (bl3) {
                object2 = (Uri)object2;
                this.OooO00o((Uri)object2);
                continue;
            }
            object = new IllegalArgumentException("Incoming data type exception, it must be String, File, Uri or Bitmap");
            throw object;
        }
        return this;
    }

    public OooO0o$OooO00o OooO0O0(int n10) {
        int n11 = 1;
        if (n10 >= n11 && n10 <= (n11 = 100)) {
            this.OooO0Oo = n10;
        }
        return this;
    }

    public List OooO0O0() {
        OooO0o oooO0o = this.OooO00o();
        Context context = this.OooO00o;
        return com.quvideo.mobile.external.component.cloudcomposite.compressor.OooO0o.OooO00o(oooO0o, context);
    }
}

