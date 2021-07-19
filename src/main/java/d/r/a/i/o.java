/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Base64
 */
package d.r.a.i;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import d.r.a.l;
import d.r.a.m;
import d.r.a.s.c;
import d.r.a.u.s;
import d.r.a.u.x;
import java.security.PublicKey;

public abstract class o
extends m {
    public c d;

    public o(d.r.a.o o10) {
        super(o10);
    }

    public final void b(c c10) {
        this.d = c10;
    }

    public final boolean c(PublicKey object, String string2, String object2) {
        String string3 = "vertify fail srcDigest is ";
        l l10 = l.b();
        boolean bl2 = l10.q();
        boolean bl3 = true;
        String string4 = "OnVerifyCallBackCommand";
        if (!bl2) {
            s.m(string4, "vertify is not support , vertify is ignore");
            return bl3;
        }
        bl2 = false;
        l10 = null;
        if (object == null) {
            s.m(string4, "vertify key is null");
            return false;
        }
        boolean bl4 = TextUtils.isEmpty((CharSequence)string2);
        if (bl4) {
            s.m(string4, "contentTag is null");
            return false;
        }
        bl4 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl4) {
            block23: {
                int n10;
                Object object3;
                try {
                    object3 = new StringBuilder();
                    n10 = string2.hashCode();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    s.m(string4, "vertify exception");
                    return false;
                }
                ((StringBuilder)object3).append(n10);
                String string5 = " = ";
                ((StringBuilder)object3).append(string5);
                ((StringBuilder)object3).append((String)object2);
                object3 = ((StringBuilder)object3).toString();
                s.m(string4, (String)object3);
                object3 = "UTF-8";
                object3 = string2.getBytes((String)object3);
                n10 = 2;
                object2 = Base64.decode((String)object2, (int)n10);
                boolean bl5 = x.b((byte[])object3, (PublicKey)object, (byte[])object2);
                if (!bl5) break block23;
                object = "vertify id is success";
                s.m(string4, (String)object);
                return bl3;
            }
            object = new StringBuilder(string3);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            s.m(string4, (String)object);
            object = this.a;
            object2 = new StringBuilder(string3);
            ((StringBuilder)object2).append(string2);
            string2 = ((StringBuilder)object2).toString();
            s.l((Context)object, string2);
            return false;
        }
        s.m(string4, "vertify id is null");
        return false;
    }
}

