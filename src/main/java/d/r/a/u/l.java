/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package d.r.a.u;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import d.r.a.u.a;
import d.r.a.u.n;
import d.r.a.u.s;

public final class l
implements a {
    private static int e;
    private static int f;
    private Resources a;
    private String b;
    private String c;
    private String d;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int e(String charSequence, String string2) {
        int n10;
        int n11;
        String string3 = "DefaultNotifyDataAdapter";
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        int n12 = -1;
        if (bl2) return n12;
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return n12;
        }
        Object object = ((String)charSequence).split("\\.");
        if (object != null && (n11 = ((String[])object).length) > 0) {
            n10 = 0;
            charSequence = object[0];
        }
        try {
            n10 = Integer.parseInt((String)charSequence);
            while (n10 > 0) {
                CharSequence charSequence2 = "vivo_push_ard";
                object = new StringBuilder((String)charSequence2);
                ((StringBuilder)object).append(n10);
                ((StringBuilder)object).append(string2);
                object = ((StringBuilder)object).toString();
                String string4 = "get notify icon : ";
                charSequence2 = new StringBuilder(string4);
                ((StringBuilder)charSequence2).append((String)object);
                charSequence2 = ((StringBuilder)charSequence2).toString();
                s.k(string3, (String)charSequence2);
                charSequence2 = this.a;
                string4 = "drawable";
                String string5 = this.b;
                n11 = charSequence2.getIdentifier((String)object, string4, string5);
                if (n11 > 0) {
                    string2 = "find notify icon : ";
                    charSequence = new StringBuilder(string2);
                    ((StringBuilder)charSequence).append((String)object);
                    charSequence = ((StringBuilder)charSequence).toString();
                    s.k(string3, (String)charSequence);
                    return n11;
                }
                n10 += -1;
            }
            return n12;
        }
        catch (Exception exception) {
            s.c(string3, exception);
        }
        return n12;
    }

    private static boolean f(int n10) {
        int n11 = -1;
        return n10 != n11 && n10 != 0;
    }

    private static boolean g(String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 < n11) {
            return false;
        }
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            s.m("DefaultNotifyDataAdapter", "systemVersion is not suit ");
            return false;
        }
        return true;
    }

    public final void a(Context object) {
        String string2;
        this.b = string2 = object.getPackageName();
        object = object.getResources();
        this.a = object;
        object = n.a();
        this.c = object;
        object = Build.VERSION.RELEASE;
        this.d = object;
    }

    public final int b() {
        int n10 = l.f(f);
        if (n10 != 0) {
            return f;
        }
        String string2 = this.d;
        int n11 = l.g(string2);
        String string3 = "_icon";
        n10 = n11 == 0 ? -1 : this.e(string2, string3);
        f = n10;
        if ((n10 = (int)(l.f(n10) ? 1 : 0)) != 0) {
            return f;
        }
        string2 = this.c;
        while (true) {
            Object object;
            n11 = TextUtils.isEmpty((CharSequence)string2);
            String string4 = "drawable";
            if (n11 != 0) {
                string2 = this.a;
                object = this.b;
                return string2.getIdentifier("vivo_push_icon", string4, (String)object);
            }
            object = this.a;
            CharSequence charSequence = new StringBuilder("vivo_push_rom");
            charSequence.append(string2);
            charSequence.append(string3);
            charSequence = charSequence.toString();
            String string5 = this.b;
            n11 = object.getIdentifier((String)charSequence, string4, string5);
            if (n11 > 0) {
                return n11;
            }
            n11 = 0;
            object = null;
            int n12 = string2.length() + -1;
            string2 = string2.substring(0, n12);
        }
    }

    public final int c() {
        int n10 = l.f(e);
        if (n10 != 0) {
            return e;
        }
        String string2 = this.d;
        int n11 = l.g(string2);
        String string3 = "_notifyicon";
        n10 = n11 == 0 ? -1 : this.e(string2, string3);
        e = n10;
        if ((n10 = (int)(l.f(n10) ? 1 : 0)) != 0) {
            return e;
        }
        string2 = this.c;
        while (true) {
            Object object;
            n11 = TextUtils.isEmpty((CharSequence)string2);
            String string4 = "drawable";
            if (n11 != 0) {
                string2 = this.a;
                object = this.b;
                return string2.getIdentifier("vivo_push_notifyicon", string4, (String)object);
            }
            object = this.a;
            CharSequence charSequence = new StringBuilder("vivo_push_rom");
            charSequence.append(string2);
            charSequence.append(string3);
            charSequence = charSequence.toString();
            String string5 = this.b;
            n11 = object.getIdentifier((String)charSequence, string4, string5);
            if (n11 > 0) {
                return n11;
            }
            n11 = 0;
            object = null;
            int n12 = string2.length() + -1;
            string2 = string2.substring(0, n12);
        }
    }

    public final int d(d.r.a.r.a a10) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return 2;
        }
        return 1;
    }
}

