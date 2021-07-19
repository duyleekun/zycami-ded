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
import d.r.a.h$p;
import d.r.a.h$w;
import d.r.a.h$y;
import d.r.a.i.k$a;
import d.r.a.k.a;
import d.r.a.l;
import d.r.a.n;
import d.r.a.o;
import d.r.a.r.d;
import d.r.a.u.d0;
import d.r.a.u.s;
import java.security.PublicKey;
import java.util.HashMap;

public final class k
extends d.r.a.i.o {
    public k(o o10) {
        super(o10);
    }

    public static /* synthetic */ Context d(k k10) {
        return k10.a;
    }

    public final void a(o object) {
        String string2;
        Object object2 = object;
        object2 = (h$p)object;
        long l10 = ((h$w)object2).f;
        CharSequence charSequence = String.valueOf(l10);
        HashMap<CharSequence, Object> hashMap = new HashMap<CharSequence, Object>((String)charSequence);
        l.b().e((o)((Object)hashMap));
        hashMap = d.r.a.k.a.d(this.a);
        boolean bl2 = ((a)((Object)hashMap)).l();
        charSequence = "remoteAppId";
        String string3 = "messageID";
        String string4 = "OnMessageTask";
        if (!bl2) {
            String string5 = "command  ";
            hashMap = new HashMap<CharSequence, Object>(string5);
            ((StringBuilder)((Object)hashMap)).append(object);
            ((StringBuilder)((Object)hashMap)).append(" is ignore by disable push ");
            object = ((StringBuilder)((Object)hashMap)).toString();
            s.m(string4, (String)object);
            object = new h$y(1020L);
            hashMap = new HashMap<CharSequence, Object>();
            long l11 = ((h$w)object2).f;
            object2 = String.valueOf(l11);
            hashMap.put(string3, object2);
            object2 = this.a;
            string3 = object2.getPackageName();
            object2 = d0.k((Context)object2, string3);
            boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl3) {
                hashMap.put(charSequence, object2);
            }
            ((h$y)object).c = hashMap;
            l.b().e((o)object);
            return;
        }
        object = l.b();
        boolean bl4 = ((l)object).h;
        if (bl4 && !(bl4 = this.c((PublicKey)(object = d0.o(this.a)), (String)((Object)(hashMap = ((h$p)object2).g())), string2 = ((h$w)object2).e))) {
            object = new h$y(1021L);
            hashMap = new HashMap<CharSequence, Object>();
            long l12 = ((h$w)object2).f;
            object2 = String.valueOf(l12);
            hashMap.put(string3, object2);
            object2 = this.a;
            string3 = object2.getPackageName();
            object2 = d0.k((Context)object2, string3);
            boolean bl5 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl5) {
                hashMap.put(charSequence, object2);
            }
            ((h$y)object).c = hashMap;
            l.b().e((o)object);
            return;
        }
        object = ((h$p)object2).h();
        if (object != null) {
            int n10 = ((d)object).d();
            hashMap = ((d)object).e();
            charSequence = new StringBuilder("tragetType is ");
            ((StringBuilder)charSequence).append(n10);
            ((StringBuilder)charSequence).append(" ; target is ");
            ((StringBuilder)charSequence).append((String)((Object)hashMap));
            object2 = ((StringBuilder)charSequence).toString();
            s.m(string4, (String)object2);
            object2 = new k$a(this, (d)object);
            n.c((Runnable)object2);
            return;
        }
        s.a(string4, " message is null");
    }
}

