/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.l.a.f.b;

import android.text.TextUtils;
import d.l.a.c;
import d.l.a.f.b.a;

public final class a$b {
    private String a;
    private int b;
    private String c;
    private String[] d;

    public a a() {
        int n10 = 0;
        Object object = new a(null);
        String[] stringArray = d.l.a.c.f().c();
        int n11 = TextUtils.isEmpty((CharSequence)stringArray);
        if (n11 == 0) {
            d.l.a.f.b.a.c((a)object, (String)stringArray);
            stringArray = d.l.a.c.f().e();
            n11 = TextUtils.isEmpty((CharSequence)stringArray);
            if (n11 == 0) {
                d.l.a.f.b.a.d((a)object, (String)stringArray);
                stringArray = this.a;
                n10 = TextUtils.isEmpty((CharSequence)stringArray);
                if (n10 == 0) {
                    stringArray = this.a;
                    ((a)object).n((String)stringArray);
                    n10 = this.b;
                    n11 = 1;
                    if (n10 != n11 && n10 != (n11 = 2)) {
                        object = new IllegalArgumentException("loginType is illegal");
                        throw object;
                    }
                    ((a)object).l(n10);
                    stringArray = this.c;
                    String string2 = "code";
                    n10 = (int)(stringArray.equals(string2) ? 1 : 0);
                    if (n10 != 0) {
                        stringArray = this.c;
                        ((a)object).k((String)stringArray);
                        stringArray = this.d;
                        if (stringArray == null || (n10 = stringArray.length) == 0) {
                            stringArray = new String[]{"kwai_app"};
                            this.d = stringArray;
                        }
                        stringArray = this.d;
                        ((a)object).m(stringArray);
                        d.l.a.f.b.a.e((a)object);
                        return object;
                    }
                    object = new IllegalArgumentException("authMode is illegal");
                    throw object;
                }
                object = new IllegalArgumentException("state is empty");
                throw object;
            }
            object = new IllegalArgumentException("scope is empty");
            throw object;
        }
        object = new IllegalArgumentException("appId is empty, please set in build.gradle");
        throw object;
    }

    public a$b b(String string2) {
        this.c = string2;
        return this;
    }

    public a$b c(int n10) {
        this.b = n10;
        return this;
    }

    public a$b d(String[] stringArray) {
        this.d = stringArray;
        return this;
    }

    public a$b e(String string2) {
        this.a = string2;
        return this;
    }
}

