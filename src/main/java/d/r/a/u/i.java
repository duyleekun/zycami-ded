/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.r.a.u;

import android.text.TextUtils;
import d.r.a.h$y;
import d.r.a.l;
import d.r.a.u.s;
import java.util.HashMap;

public final class i {
    public static boolean a(long l10, HashMap object) {
        h$y h$y = new h$y(l10);
        h$y.c = object;
        String string2 = "ReporterCommand";
        if (object == null) {
            String string3 = "reportParams is empty";
            s.m(string2, string3);
        } else {
            CharSequence charSequence = new StringBuilder("report message reportType:");
            long l11 = h$y.d;
            charSequence.append(l11);
            charSequence.append(",msgId:");
            object = h$y.c;
            String string4 = "messageID";
            object = (String)((HashMap)object).get(string4);
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) {
                object = h$y.c;
                string4 = "message_id";
                object = (String)((HashMap)object).get(string4);
            }
            charSequence.append((String)object);
            charSequence = charSequence.toString();
            s.m(string2, (String)charSequence);
        }
        l.b().e(h$y);
        return true;
    }
}

