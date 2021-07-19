/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package com.baidu.location.h;

import android.content.Context;
import android.os.Build;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.f;
import com.baidu.location.h.l;

public class b {
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static int i;
    private static b j;
    public String a = null;
    public String b = null;
    public String c = null;
    public String d = null;
    private boolean k = false;

    private b() {
        Context context = com.baidu.location.f.getServiceContext();
        if (context != null) {
            context = com.baidu.location.f.getServiceContext();
            this.a(context);
        }
    }

    public static b a() {
        b b10 = j;
        if (b10 == null) {
            j = b10 = new b();
        }
        return j;
    }

    public String a(boolean bl2) {
        return this.a(bl2, null);
    }

    /*
     * Enabled aggressive block sorting
     */
    public String a(boolean bl2, String string2) {
        int n10;
        float f10;
        int n11;
        CharSequence charSequence;
        StringBuffer stringBuffer;
        block23: {
            block22: {
                String string3;
                block21: {
                    stringBuffer = new StringBuffer(256);
                    charSequence = "&sdk=";
                    stringBuffer.append((String)charSequence);
                    n11 = 1090938470;
                    f10 = 8.4f;
                    stringBuffer.append(f10);
                    if (bl2) {
                        charSequence = l.g;
                        string3 = "all";
                        n11 = (int)(((String)charSequence).equals(string3) ? 1 : 0);
                        if (n11 != 0) {
                            charSequence = "&addr=allj2";
                            stringBuffer.append((String)charSequence);
                        }
                        if ((n11 = (int)(l.i ? 1 : 0)) != 0) {
                            charSequence = "&adtp=n2";
                            stringBuffer.append((String)charSequence);
                        }
                        n11 = (int)(l.h ? 1 : 0);
                        if (n11 != 0 || (n11 = (int)(l.k ? 1 : 0)) != 0 || (n11 = (int)(l.l ? 1 : 0)) != 0 || (n11 = (int)(l.j ? 1 : 0)) != 0) {
                            charSequence = "&sema=";
                            stringBuffer.append((String)charSequence);
                            n11 = (int)(l.h ? 1 : 0);
                            if (n11 != 0) {
                                charSequence = "aptag|";
                                stringBuffer.append((String)charSequence);
                            }
                            if ((n11 = (int)(l.j ? 1 : 0)) != 0) {
                                charSequence = "aptagd2|";
                                stringBuffer.append((String)charSequence);
                            }
                            if ((n11 = (int)(l.k ? 1 : 0)) != 0) {
                                charSequence = "poiregion|";
                                stringBuffer.append((String)charSequence);
                            }
                            if ((n11 = (int)(l.l ? 1 : 0)) != 0) {
                                charSequence = "regular";
                                stringBuffer.append((String)charSequence);
                            }
                        }
                    }
                    if (bl2) {
                        if (string2 == null) {
                            string2 = "&coor=gcj02";
                        } else {
                            charSequence = "&coor=";
                            stringBuffer.append((String)charSequence);
                        }
                        stringBuffer.append(string2);
                        string2 = com.baidu.location.f.f.l();
                        if (string2 != null) {
                            stringBuffer.append(string2);
                        }
                    }
                    if ((string2 = this.c) != null) break block21;
                    string2 = "&im=";
                    break block22;
                }
                stringBuffer.append("&cu=");
                string2 = this.c;
                stringBuffer.append(string2);
                string2 = this.a;
                if (string2 == null || (n10 = string2.equals(charSequence = "NULL")) != 0) break block23;
                string2 = this.c;
                string3 = this.a;
                charSequence = new StringBuffer(string3);
                n10 = string2.contains(charSequence = ((StringBuffer)charSequence).reverse().toString());
                if (n10 != 0) break block23;
                string2 = "&Aim=";
            }
            stringBuffer.append(string2);
            string2 = this.a;
            stringBuffer.append(string2);
        }
        if ((string2 = this.b) != null) {
            stringBuffer.append("&snd=");
            string2 = this.b;
            stringBuffer.append(string2);
        }
        if ((string2 = this.d) != null) {
            stringBuffer.append("&Aid=");
            string2 = this.d;
            stringBuffer.append(string2);
        }
        stringBuffer.append("&fw=");
        float f11 = com.baidu.location.f.getFrameVersion();
        stringBuffer.append(f11);
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        string2 = Build.MODEL;
        stringBuffer.append(string2);
        if (bl2 && (string2 = l.c()) != null) {
            charSequence = "&laip=";
            stringBuffer.append((String)charSequence);
            stringBuffer.append(string2);
        }
        stringBuffer.append("&resid=");
        stringBuffer.append("12");
        string2 = "&os=A";
        stringBuffer.append(string2);
        n10 = Build.VERSION.SDK_INT;
        stringBuffer.append(n10);
        if (bl2) {
            stringBuffer.append("&sv=");
            String string4 = Build.VERSION.RELEASE;
            if (string4 != null) {
                n10 = string4.length();
                n11 = 6;
                f10 = 8.4E-45f;
                if (n10 > n11) {
                    n10 = 0;
                    f11 = 0.0f;
                    string2 = null;
                    string4 = string4.substring(0, n11);
                }
            }
            stringBuffer.append(string4);
        }
        return stringBuffer.toString();
    }

    public void a(Context object) {
        boolean bl2;
        if (object != null && !(bl2 = this.k)) {
            boolean bl3;
            bl2 = false;
            String string2 = null;
            Object object2 = LBSAuthManager.getInstance((Context)object);
            object2 = ((LBSAuthManager)object2).getCUID();
            try {
                this.c = object2;
            }
            catch (Exception exception) {
                this.c = null;
            }
            object = object.getPackageName();
            try {
                e = object;
            }
            catch (Exception exception) {
                e = null;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("");
            string2 = this.c;
            ((StringBuilder)object).append(string2);
            l.q = object = ((StringBuilder)object).toString();
            this.k = bl3 = true;
        }
    }

    public void a(String string2, String string3) {
        f = string2;
        e = string3;
    }

    public String b() {
        CharSequence charSequence = this.c;
        String string2 = "|";
        String string3 = "v8.4|";
        if (charSequence != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string3);
            string3 = this.c;
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string3);
            string3 = this.a;
        }
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string2);
        string2 = Build.MODEL;
        ((StringBuilder)charSequence).append(string2);
        return ((StringBuilder)charSequence).toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String c() {
        int n10 = 200;
        StringBuffer stringBuffer = new StringBuffer(n10);
        String string2 = this.c;
        if (string2 != null) {
            stringBuffer.append("&cu=");
            string2 = this.c;
        } else {
            stringBuffer.append("&im=");
            string2 = this.a;
        }
        stringBuffer.append(string2);
        string2 = "&mb=";
        try {
            stringBuffer.append(string2);
            string2 = Build.MODEL;
            stringBuffer.append(string2);
        }
        catch (Exception exception) {}
        string2 = "&pack=";
        stringBuffer.append(string2);
        try {
            string2 = e;
            stringBuffer.append(string2);
        }
        catch (Exception exception) {}
        stringBuffer.append("&sdk=");
        stringBuffer.append(8.4f);
        return stringBuffer.toString();
    }

    public String d() {
        StringBuffer stringBuffer = new StringBuffer();
        CharSequence charSequence = this.c;
        if (charSequence == null) {
            stringBuffer.append("&im=");
            charSequence = this.a;
        } else {
            stringBuffer.append("&cu=");
            charSequence = this.c;
        }
        stringBuffer.append((String)charSequence);
        stringBuffer.append("&sdk=");
        stringBuffer.append(8.4f);
        stringBuffer.append("&mb=");
        charSequence = Build.MODEL;
        stringBuffer.append((String)charSequence);
        stringBuffer.append("&stp=1");
        stringBuffer.append("&os=A");
        charSequence = Build.VERSION.SDK;
        stringBuffer.append((String)charSequence);
        stringBuffer.append("&prod=");
        charSequence = new StringBuilder();
        String string2 = f;
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(":");
        string2 = e;
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuffer.append((String)charSequence);
        charSequence = l.f(com.baidu.location.f.getServiceContext());
        stringBuffer.append((String)charSequence);
        stringBuffer.append("&resid=");
        stringBuffer.append("12");
        return stringBuffer.toString();
    }
}

