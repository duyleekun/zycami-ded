/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Base64
 */
package cn.sharesdk.framework.b.b;

import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.b.b.c;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Data;

public class b
extends c {
    private static int m;
    private static long n;
    public int a;
    public String b;
    public String c;
    public String d;

    public String a() {
        return "[AUT]";
    }

    public void a(long l10) {
        n = l10;
    }

    public int b() {
        return 5000;
    }

    public int c() {
        return 5;
    }

    public long d() {
        return m;
    }

    public long e() {
        return n;
    }

    public void f() {
        ++m;
    }

    public String toString() {
        String string2 = "\n";
        String string3 = super.toString();
        StringBuilder stringBuilder = new StringBuilder(string3);
        char c10 = '|';
        stringBuilder.append(c10);
        int n10 = this.a;
        stringBuilder.append(n10);
        stringBuilder.append(c10);
        Object object = this.b;
        stringBuilder.append((String)object);
        stringBuilder.append(c10);
        object = this.d;
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n10 == 0) {
            block13: {
                object = this.f;
                int n11 = 16;
                object = ((String)object).substring(0, n11);
                String string4 = this.d;
                object = Data.AES128Encode((String)object, string4);
                object = Base64.encodeToString((byte[])object, (int)0);
                n11 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                if (n11 != 0) break block13;
                n11 = (int)(((String)object).contains(string2) ? 1 : 0);
                if (n11 == 0) break block13;
                string4 = "";
                object = ((String)object).replace(string2, string4);
            }
            try {
                stringBuilder.append((String)object);
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                ((NLog)object).d(throwable);
            }
        }
        stringBuilder.append(c10);
        string2 = this.l;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            string2 = this.l;
            stringBuilder.append(string2);
        }
        stringBuilder.append(c10);
        string2 = this.c;
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            string2 = this.c;
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }
}

