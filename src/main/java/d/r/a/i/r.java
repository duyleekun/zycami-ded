/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.r.a.i;

import android.content.Context;
import android.text.TextUtils;
import d.r.a.h$v;
import d.r.a.h$w;
import d.r.a.h$y;
import d.r.a.l;
import d.r.a.o;
import d.r.a.u.d;
import d.r.a.u.d0;
import d.r.a.u.s;
import java.security.PublicKey;
import java.util.HashMap;

public final class r
extends d.r.a.i.o {
    public r(o o10) {
        super(o10);
    }

    public final void a(o object) {
        HashMap<String, Object> hashMap;
        long l10;
        long l11;
        long l12;
        long l13;
        CharSequence charSequence;
        object = (h$v)object;
        Object object2 = l.b();
        boolean bl2 = ((l)object2).h;
        CharSequence charSequence2 = "remoteAppId";
        String string2 = "messageID";
        Object object3 = "OnUndoMsgTask";
        if (bl2 && !(bl2 = this.c((PublicKey)(object2 = d0.o(this.a)), (String)(charSequence = (l13 = (l12 = (l11 = ((h$v)object).g) - (l10 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false ? String.valueOf(l11) : null), (String)((Object)(hashMap = ((h$w)object).e))))) {
            s.m((String)object3, " vertify msg is error ");
            long l14 = 1021L;
            object2 = new h$y(l14);
            object3 = new HashMap();
            l11 = ((h$w)object).f;
            object = String.valueOf(l11);
            ((HashMap)object3).put(string2, object);
            object = this.a;
            string2 = object.getPackageName();
            object = d0.k((Context)object, string2);
            boolean bl3 = TextUtils.isEmpty((CharSequence)object);
            if (!bl3) {
                ((HashMap)object3).put(charSequence2, object);
            }
            ((h$y)object2).c = object3;
            l.b().e((o)object2);
            return;
        }
        object2 = this.a;
        l11 = ((h$v)object).g;
        bl2 = d.r.a.u.d.h((Context)object2, l11);
        charSequence = new StringBuilder("undo message ");
        long l15 = ((h$v)object).g;
        ((StringBuilder)charSequence).append(l15);
        hashMap = ", ";
        ((StringBuilder)charSequence).append((String)((Object)hashMap));
        ((StringBuilder)charSequence).append(bl2);
        charSequence = ((StringBuilder)charSequence).toString();
        s.m((String)object3, (String)charSequence);
        if (bl2) {
            object2 = this.a;
            charSequence = "\u56de\u6536client\u901a\u77e5\u6210\u529f, \u4e0a\u62a5\u57cb\u70b9 1031, messageId = ";
            object3 = new StringBuilder((String)charSequence);
            l11 = ((h$v)object).g;
            ((StringBuilder)object3).append(l11);
            object3 = ((StringBuilder)object3).toString();
            s.j((Context)object2, (String)object3);
            object2 = this.a;
            long l16 = ((h$v)object).g;
            object = new StringBuilder("report message: ");
            ((StringBuilder)object).append(l16);
            ((StringBuilder)object).append(", reportType: 1031");
            object = ((StringBuilder)object).toString();
            s.m("ClientReportUtil", (String)object);
            l15 = 1031L;
            object = new h$y(l15);
            hashMap = new HashMap<String, Object>();
            object3 = String.valueOf(l16);
            hashMap.put(string2, object3);
            string2 = object2.getPackageName();
            object2 = d0.k((Context)object2, string2);
            boolean bl4 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl4) {
                hashMap.put((String)charSequence2, object2);
            }
            ((h$y)object).c = hashMap;
            l.b().e((o)object);
            return;
        }
        object2 = new StringBuilder("undo message fail\uff0cmessageId = ");
        long l17 = ((h$v)object).g;
        ((StringBuilder)object2).append(l17);
        object2 = ((StringBuilder)object2).toString();
        s.m((String)object3, (String)object2);
        object2 = this.a;
        charSequence2 = new StringBuilder("\u56de\u6536client\u901a\u77e5\u5931\u8d25\uff0cmessageId = ");
        long l18 = ((h$v)object).g;
        ((StringBuilder)charSequence2).append(l18);
        object = ((StringBuilder)charSequence2).toString();
        s.l((Context)object2, (String)object);
    }
}

