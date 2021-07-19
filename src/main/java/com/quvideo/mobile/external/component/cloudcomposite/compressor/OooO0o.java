/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.quvideo.mobile.external.component.cloudcomposite.compressor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooO00o;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooO0O0;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooO0o$OooO00o;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooOO0O;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooOOO;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooOOO0;
import d.o.a.a.a.a.a.a;
import d.o.a.a.a.a.a.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OooO0o
implements Handler.Callback {
    private List OooO;
    private String OooO00o;
    private boolean OooO0O0;
    private int OooO0OO;
    private int OooO0Oo;
    private OooOOO OooO0o;
    private boolean OooO0o0;
    private OooOOO0 OooO0oO;
    private OooO0O0 OooO0oo;

    private OooO0o(OooO0o$OooO00o object) {
        int n10;
        Object object2 = OooO0o$OooO00o.OooO00o((OooO0o$OooO00o)object);
        this.OooO00o = object2;
        this.OooO0o = object2 = OooO0o$OooO00o.OooO0O0((OooO0o$OooO00o)object);
        this.OooO = object2 = OooO0o$OooO00o.OooO0Oo((OooO0o$OooO00o)object);
        this.OooO0oO = object2 = OooO0o$OooO00o.OooO0o0((OooO0o$OooO00o)object);
        this.OooO0OO = n10 = OooO0o$OooO00o.OooO0o((OooO0o$OooO00o)object);
        this.OooO0Oo = n10 = OooO0o$OooO00o.OooO0oO((OooO0o$OooO00o)object);
        n10 = (int)(OooO0o$OooO00o.OooO0oo((OooO0o$OooO00o)object) ? 1 : 0);
        this.OooO0o0 = n10;
        this.OooO0oo = object = OooO0o$OooO00o.OooO((OooO0o$OooO00o)object);
        object2 = Looper.getMainLooper();
        object = new Handler((Looper)object2, (Handler.Callback)this);
    }

    public /* synthetic */ OooO0o(OooO0o$OooO00o oooO0o$OooO00o, a a10) {
        this(oooO0o$OooO00o);
    }

    private File OooO00o(Context object, OooOO0O oooOO0O) {
        try {
            object = this.OooO0O0((Context)object, oooOO0O);
            return object;
        }
        finally {
            oooOO0O.close();
        }
    }

    private static File OooO00o(Context object, String string2) {
        if ((object = object.getExternalCacheDir()) != null) {
            File file = new File((File)object, string2);
            boolean bl2 = file.mkdirs();
            if (!(bl2 || (bl2 = file.exists()) && (bl2 = file.isDirectory()))) {
                return null;
            }
            return file;
        }
        string2 = "Compressor";
        boolean bl3 = Log.isLoggable((String)string2, (int)6);
        if (bl3) {
            object = "default disk cache dir is null";
            com.quvideo.mobile.external.platform.log.OooO00o.OooO0O0(string2, (String)object);
        }
        return null;
    }

    private List OooO00o(Context context) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator2 = this.OooO.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (OooOO0O)iterator2.next();
            object = this.OooO00o(context, (OooOO0O)object);
            arrayList.add(object);
            iterator2.remove();
        }
        return arrayList;
    }

    public static /* synthetic */ List OooO00o(OooO0o oooO0o, Context context) {
        return oooO0o.OooO00o(context);
    }

    private File OooO0O0(Context context) {
        return com.quvideo.mobile.external.component.cloudcomposite.compressor.OooO0o.OooO00o(context, "luban_disk_cache");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private File OooO0O0(Context object, OooOO0O object2) {
        OooO00o oooO00o = com.quvideo.mobile.external.component.cloudcomposite.compressor.OooO00o.SINGLE;
        Object object3 = oooO00o.extSuffix((OooOO0O)object2);
        object3 = this.OooO0O0((Context)object, (String)object3);
        Object object4 = this.OooO0o;
        if (object4 != null) {
            object3 = object2.OooO0O0();
            object3 = object4.OooO00o((String)object3);
            object3 = this.OooO0OO((Context)object, (String)object3);
        }
        Object object5 = object3;
        object = this.OooO0oo;
        if (object != null) {
            object3 = object2.OooO0O0();
            int n10 = object.OooO00o((String)object3);
            if (n10 != 0) {
                n10 = this.OooO0OO;
                object3 = object2.OooO0O0();
                if ((n10 = (int)(oooO00o.needCompress(n10, (String)object3) ? 1 : 0)) != 0) {
                    boolean bl2 = this.OooO0O0;
                    int n11 = this.OooO0Oo;
                    boolean bl3 = this.OooO0o0;
                    object4 = object;
                    object = new b((OooOO0O)object2, (File)object5, bl2, n11, bl3);
                    return ((b)object).b();
                }
            }
            object2 = object2.OooO0O0();
            return new File((String)object2);
        }
        int n12 = this.OooO0OO;
        object3 = object2.OooO0O0();
        if ((n12 = (int)(oooO00o.needCompress(n12, (String)object3) ? 1 : 0)) != 0) {
            boolean bl4 = this.OooO0O0;
            int n13 = this.OooO0Oo;
            boolean bl5 = this.OooO0o0;
            object4 = object;
            object = new b((OooOO0O)object2, (File)object5, bl4, n13, bl5);
            return ((b)object).b();
        }
        object2 = object2.OooO0O0();
        return new File((String)object2);
    }

    private File OooO0O0(Context object, String object2) {
        String string2 = this.OooO00o;
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 != 0) {
            object = this.OooO0O0((Context)object).getAbsolutePath();
            this.OooO00o = object;
        }
        object = new StringBuilder();
        string2 = this.OooO00o;
        ((StringBuilder)object).append(string2);
        string2 = "/";
        ((StringBuilder)object).append(string2);
        long l10 = System.currentTimeMillis();
        ((StringBuilder)object).append(l10);
        double d10 = Math.random();
        double d11 = 1000.0;
        n10 = (int)(d10 *= d11);
        ((StringBuilder)object).append(n10);
        n10 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
        if (n10 != 0) {
            object2 = ".jpg";
        }
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        object2 = new File((String)object);
        return object2;
    }

    public static OooO0o$OooO00o OooO0OO(Context context) {
        OooO0o$OooO00o oooO0o$OooO00o = new OooO0o$OooO00o(context);
        return oooO0o$OooO00o;
    }

    private File OooO0OO(Context object, String object2) {
        String string2 = this.OooO00o;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            object = this.OooO0O0((Context)object).getAbsolutePath();
            this.OooO00o = object;
        }
        object = new StringBuilder();
        string2 = this.OooO00o;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("/");
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        object2 = new File((String)object);
        return object2;
    }

    public boolean handleMessage(Message object) {
        OooOOO0 oooOOO0 = this.OooO0oO;
        if (oooOOO0 == null) {
            return false;
        }
        int n10 = object.what;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 == n11) {
                    object = (Throwable)object.obj;
                    oooOOO0.onError((Throwable)object);
                }
            } else {
                oooOOO0.OooO00o();
            }
        } else {
            object = (File)object.obj;
            oooOOO0.OooO00o((File)object);
        }
        return false;
    }
}

