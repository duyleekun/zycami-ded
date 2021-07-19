/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.quvideo.mobile.external.platform.uploader;

import android.content.Context;
import android.text.TextUtils;
import com.quvideo.mobile.external.platform.api.oss.model.OSSUploadResponse;
import com.quvideo.mobile.external.platform.api.oss.model.OSSUploadResponse$Data;
import com.quvideo.mobile.external.platform.uploader.OooO$OooO0OO;
import com.quvideo.mobile.external.platform.uploader.OooOo00$OooO0OO;
import com.quvideo.mobile.external.platform.uploader.OooOo00$a;
import com.quvideo.mobile.external.platform.uploader.OooOo00$b;
import com.quvideo.mobile.external.platform.uploader.db.OooO;
import com.quvideo.mobile.external.platform.uploader.db.OooO0o;
import com.quvideo.mobile.external.platform.uploader.db.entity.OooO0O0;
import com.quvideo.mobile.external.platform.uploader.utils.OooO00o;
import d.o.a.a.b.c.a;
import d.o.a.a.b.c.c;
import d.o.a.a.b.c.d;
import d.o.a.a.b.c.e;
import d.o.a.a.b.c.f.b;
import e.a.z;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class OooOo00 {
    private static volatile OooOo00 i;
    public Context a;
    public com.quvideo.mobile.external.platform.uploader.listener.OooO00o b;
    public boolean c = false;
    private String d;
    private d.o.a.a.b.c.b e;
    private ConcurrentHashMap f;
    public volatile OooO0o g;
    public OooOo00$OooO0OO h;

    private OooOo00() {
        Object object = new ConcurrentHashMap();
        this.f = object;
        this.h = object = new OooOo00$a(this);
        this.e = object = new d.o.a.a.b.c.b();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static OooOo00 a() {
        Object object = i;
        if (object != null) return i;
        object = OooOo00.class;
        synchronized (object) {
            OooOo00 oooOo00 = i;
            if (oooOo00 != null) return i;
            i = oooOo00 = new OooOo00();
            return i;
        }
    }

    public static /* synthetic */ ConcurrentHashMap b(OooOo00 oooOo00) {
        return oooOo00.f;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void c(long l10, String string2, boolean bl2, boolean bl3, String string3, e e10) {
        try {
            boolean bl4;
            Object object;
            JSONObject jSONObject = new JSONObject();
            String string4 = OooO00o.OooO00o(string2);
            if (bl2) {
                string4 = OooO00o.OooO0Oo(string2);
                Object object2 = "^[a-zA-z0-9]+[_\\-]\\.*[a-zA-z0-9]+\\.[a-zA-z0-9]+";
                object2 = Pattern.compile((String)object2);
                bl2 = ((Matcher)(object2 = ((Pattern)object2).matcher(string4))).matches();
                if (!bl2) {
                    object2 = new StringBuilder();
                    string4 = OooO00o.OooO0OO(string2);
                    string4 = d.o.a.a.b.c.a.a(string4);
                    ((StringBuilder)object2).append(string4);
                    string2 = OooO00o.OooO00o(string2);
                    ((StringBuilder)object2).append(string2);
                    string4 = ((StringBuilder)object2).toString();
                }
            }
            string2 = "fileName";
            jSONObject.put(string2, (Object)string4);
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 != false) {
                string2 = "configId";
                jSONObject.put(string2, l10);
            }
            if (bl3) {
                object = "privatelyStore";
                jSONObject.put((String)object, bl3);
            }
            if (!(bl4 = TextUtils.isEmpty((CharSequence)string3))) {
                object = "countryCode";
                jSONObject.put((String)object, (Object)string3);
            }
            object = com.quvideo.mobile.external.platform.api.oss.OooO0O0.OooO00o(jSONObject);
            OooOo00$b oooOo00$b = new OooOo00$b(e10);
            ((z)object).subscribe(oooOo00$b);
            return;
        }
        catch (Exception exception) {
            if (e10 == null) return;
            boolean bl5 = false;
            Object var13_12 = null;
            String string5 = "create request error";
            e10.a(null, string5);
        }
    }

    public static void g(String string2, com.quvideo.mobile.external.platform.uploader.OooO oooO, OSSUploadResponse object) {
        long l10;
        OooO$OooO0OO oooO$OooO0OO;
        Object object2 = ((OSSUploadResponse)object).data;
        String string3 = ((OSSUploadResponse$Data)object2).ossType;
        int n10 = ((OSSUploadResponse$Data)object2).expirySeconds;
        long l11 = (long)n10 * 1000L;
        long l12 = System.currentTimeMillis();
        object2 = ((OSSUploadResponse)object).data;
        String string4 = ((OSSUploadResponse$Data)object2).accessKey;
        String string5 = ((OSSUploadResponse$Data)object2).accessSecret;
        String string6 = ((OSSUploadResponse$Data)object2).securityToken;
        String string7 = ((OSSUploadResponse$Data)object2).uploadHost;
        String string8 = ((OSSUploadResponse$Data)object2).filePath;
        String string9 = ((OSSUploadResponse$Data)object2).region;
        String string10 = ((OSSUploadResponse$Data)object2).bucket;
        String string11 = ((OSSUploadResponse$Data)object2).accessUrl;
        object2 = oooO$OooO0OO;
        oooO$OooO0OO = new OooO$OooO0OO(string3, l11 += l12, string4, string5, string6, string7, string8, string9, string10, string11);
        oooO.OooO0O0 = l10 = object.data.configId;
        oooO.OooO0oO = oooO$OooO0OO;
        object = new com.quvideo.mobile.external.platform.uploader.OooO(oooO);
        object2 = oooO.OooO;
        if (object2 != null) {
            object2.OooO00o(string2, (com.quvideo.mobile.external.platform.uploader.OooO)object);
        }
        OooOo00.a().l(string2, oooO);
    }

    public static void i(String string2, boolean bl2, boolean bl3, String string3, e e10) {
        OooOo00.c(0L, string2, bl2, bl3, string3, e10);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(Context object, com.quvideo.mobile.external.platform.uploader.listener.OooO00o oooO00o) {
        synchronized (this) {
            boolean bl2 = this.c;
            if (!bl2 && object != null) {
                boolean bl3;
                void var2_2;
                object = object.getApplicationContext();
                this.a = object;
                OooO.OooO00o((Context)object);
                this.b = var2_2;
                object = this.g = (object = new OooO0o());
                ((OooO0o)object).OooO0o0();
                this.c = bl3 = true;
            }
            return;
        }
    }

    public void e(String string2) {
        this.g.OooO00o(string2);
    }

    public void f(String string2, com.quvideo.mobile.external.platform.uploader.OooO oooO) {
        OooO0O0 oooO0O0 = this.g.OooO0O0(string2);
        if (oooO0O0 != null) {
            String string3;
            String string4 = OooO00o.OooO0O0(oooO.OooO00o);
            boolean bl2 = string4.equals(string3 = oooO0O0.OooO0Oo);
            if (bl2) {
                oooO0O0.OooO00o(oooO);
            } else {
                this.e(string2);
            }
        }
    }

    public void h(String string2, com.quvideo.mobile.external.platform.uploader.OooO oooO, com.quvideo.mobile.external.platform.uploader.OooO00o oooO00o) {
        synchronized (this) {
            Object object = this.f;
            ((ConcurrentHashMap)object).put(string2, oooO00o);
            object = this.e;
            c c10 = new c(string2, oooO, oooO00o);
            ((ThreadPoolExecutor)object).execute(c10);
            return;
        }
    }

    public String j() {
        synchronized (this) {
            Object object = this.d;
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) {
                object = new StringBuilder();
                Object object2 = this.a;
                object2 = object2.getFilesDir();
                object2 = ((File)object2).getAbsolutePath();
                ((StringBuilder)object).append((String)object2);
                object2 = "/cache/";
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
                this.d = object;
                object2 = this.d;
                object = new File((String)object2);
                boolean bl3 = ((File)object).exists();
                if (!bl3) {
                    ((File)object).mkdirs();
                }
            }
            object = this.d;
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void k(String string2) {
        synchronized (this) {
            Object object = this.f;
            object = ((ConcurrentHashMap)object).get(string2);
            object = (com.quvideo.mobile.external.platform.uploader.OooO00o)object;
            if (object != null) {
                ((com.quvideo.mobile.external.platform.uploader.OooO00o)object).OooO();
                object = this.f;
                ((ConcurrentHashMap)object).remove(string2);
            }
            return;
        }
    }

    public void l(String object, com.quvideo.mobile.external.platform.uploader.OooO oooO) {
        Object object2 = this.g.OooO0O0((String)object);
        if (object2 == null) {
            object2 = this.g;
            object = OooO0O0.OooO00o((String)object, oooO);
            ((b)object2).OooO0O0(object);
            return;
        }
        ((OooO0O0)object2).OooO0O0(oooO);
        this.g.OooO0O0((OooO0O0)object2);
    }

    public void m(String string2) {
        synchronized (this) {
            d.o.a.a.b.c.d.a(string2);
            d.o.a.a.b.c.b b10 = this.e;
            b10.a(string2);
            b10 = this.e;
            c c10 = new c(string2);
            b10.execute(c10);
            return;
        }
    }
}

