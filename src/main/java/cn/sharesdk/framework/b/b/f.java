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
import cn.sharesdk.framework.b.b.f$a;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Data;

public class f
extends c {
    private static int o;
    private static long p;
    public int a;
    public String b;
    public String c;
    public f$a d;
    public String m;
    public String[] n;

    public f() {
        f$a f$a;
        this.d = f$a = new f$a();
    }

    public String a() {
        return "[SHR]";
    }

    public void a(long l10) {
        p = l10;
    }

    public int b() {
        return 5000;
    }

    public int c() {
        return 30;
    }

    public long d() {
        return o;
    }

    public long e() {
        return p;
    }

    public void f() {
        ++o;
    }

    public String toString() {
        String string2;
        Object object = super.toString();
        StringBuilder stringBuilder = new StringBuilder((String)object);
        char c10 = '|';
        stringBuilder.append(c10);
        int n10 = this.a;
        stringBuilder.append(n10);
        stringBuilder.append(c10);
        Object object2 = this.b;
        stringBuilder.append((String)object2);
        stringBuilder.append(c10);
        object2 = this.c;
        n10 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
        String string3 = "";
        object2 = n10 != 0 ? string3 : this.c;
        stringBuilder.append((String)object2);
        object2 = this.n;
        if (object2 != null && (n10 = ((String[])object2).length) > 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("[\"");
            Object object3 = this.n;
            string2 = "\",\"";
            object3 = TextUtils.join((CharSequence)string2, (Object[])object3);
            ((StringBuilder)object2).append((String)object3);
            object3 = "\"]";
            ((StringBuilder)object2).append((String)object3);
            object2 = ((StringBuilder)object2).toString();
        } else {
            object2 = string3;
        }
        stringBuilder.append(c10);
        stringBuilder.append((String)object2);
        stringBuilder.append(c10);
        object2 = this.d;
        int n11 = 16;
        string2 = "\n";
        if (object2 != null) {
            Object object4;
            block23: {
                object2 = ((f$a)object2).toString();
                object4 = this.f;
                object4 = ((String)object4).substring(0, n11);
                object2 = Data.AES128Encode((String)object4, (String)object2);
                object2 = Base64.encodeToString((byte[])object2, (int)0);
                boolean bl2 = ((String)object2).contains(string2);
                if (!bl2) break block23;
                object2 = ((String)object2).replace(string2, string3);
            }
            try {
                stringBuilder.append((String)object2);
            }
            catch (Throwable throwable) {
                object4 = SSDKLog.b();
                ((NLog)object4).d(throwable);
            }
        }
        stringBuilder.append(c10);
        object2 = this.l;
        n10 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
        if (n10 == 0) {
            object2 = this.l;
            stringBuilder.append((String)object2);
        }
        stringBuilder.append(c10);
        object = this.m;
        c10 = (char)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (c10 == '\u0000') {
            block24: {
                object = this.f;
                object = ((String)object).substring(0, n11);
                object2 = this.m;
                object = Data.AES128Encode((String)object, (String)object2);
                object = Base64.encodeToString((byte[])object, (int)0);
                n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                if (n10 != 0) break block24;
                n10 = (int)(((String)object).contains(string2) ? 1 : 0);
                if (n10 == 0) break block24;
                object = ((String)object).replace(string2, string3);
            }
            try {
                stringBuilder.append((String)object);
            }
            catch (Throwable throwable) {
                object2 = SSDKLog.b();
                ((NLog)object2).w(throwable);
            }
        }
        return stringBuilder.toString();
    }
}

