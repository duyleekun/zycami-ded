/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.NotificationManager
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package d.r.a.i;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import d.r.a.h$i;
import d.r.a.h$r;
import d.r.a.h$w;
import d.r.a.i.l$a;
import d.r.a.i.o;
import d.r.a.k.a;
import d.r.a.m;
import d.r.a.n;
import d.r.a.r.c;
import d.r.a.u.d0;
import d.r.a.u.i;
import d.r.a.u.s;
import d.r.a.u.w;
import java.security.PublicKey;
import java.util.HashMap;

public final class l
extends o {
    public l(d.r.a.o o10) {
        super(o10);
    }

    public static /* synthetic */ Context d(l l10) {
        return l10.a;
    }

    public static /* synthetic */ void e(l object, String string2) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String string3 = "1";
        hashMap.put("srt", string3);
        String string4 = "message_id";
        hashMap.put(string4, string2);
        object = ((m)object).a;
        string2 = object.getPackageName();
        object = d0.k((Context)object, string2);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            string2 = "app_id";
            hashMap.put(string2, object);
        }
        hashMap.put("type", string3);
        hashMap.put("dtp", string3);
        i.a(6, hashMap);
    }

    public static /* synthetic */ void f(l l10, String string2, int n10) {
        l10.g(string2, n10);
    }

    private void g(String string2, int n10) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("messageID", string2);
        string2 = this.a;
        String string3 = string2.getPackageName();
        string2 = d0.k((Context)string2, string3);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            string3 = "remoteAppId";
            hashMap.put(string3, string2);
        }
        i.a(n10, hashMap);
    }

    public static /* synthetic */ Context h(l l10) {
        return l10.a;
    }

    public static /* synthetic */ Context i(l l10) {
        return l10.a;
    }

    public static /* synthetic */ Context j(l l10) {
        return l10.a;
    }

    public static /* synthetic */ Context k(l l10) {
        return l10.a;
    }

    public static /* synthetic */ Context l(l l10) {
        return l10.a;
    }

    public static /* synthetic */ Context m(l l10) {
        return l10.a;
    }

    public static /* synthetic */ Context o(l l10) {
        return l10.a;
    }

    public static /* synthetic */ Context p(l l10) {
        return l10.a;
    }

    public static /* synthetic */ Context q(l l10) {
        return l10.a;
    }

    public final void a(d.r.a.o object) {
        int n10;
        CharSequence charSequence;
        String string2;
        Object object2;
        String string3;
        Object object3;
        Object object4;
        block19: {
            boolean bl2;
            object4 = "OnNotificationArrivedTask";
            if (object == null) {
                s.a((String)object4, "command is null");
                return;
            }
            object3 = d.r.a.k.a.d(this.a);
            boolean n11 = ((a)object3).l();
            object = (h$r)object;
            long l10 = ((h$w)object).f;
            string3 = String.valueOf(l10);
            object2 = this.a;
            string2 = object2.getPackageName();
            n10 = w.d((Context)object2, string2, (String)(charSequence = "com.vivo.pushservice.action.RECEIVE"));
            if (n10 == 0) {
                this.g(string3, 2101);
                return;
            }
            long l11 = ((h$w)object).f;
            string2 = String.valueOf(l11);
            object2 = new h$i(string2);
            d.r.a.l.b().e((d.r.a.o)object2);
            object2 = new StringBuilder("PushMessageReceiver ");
            string2 = this.a.getPackageName();
            ((StringBuilder)object2).append(string2);
            string2 = " isEnablePush :";
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(n11);
            object2 = ((StringBuilder)object2).toString();
            s.m((String)object4, (String)object2);
            if (!n11) {
                this.g(string3, 1020);
                return;
            }
            object3 = d.r.a.l.b();
            boolean bl3 = ((d.r.a.l)object3).h;
            if (bl3 && !(bl2 = this.c((PublicKey)(object3 = d0.o(this.a)), (String)(object2 = ((h$r)object).h()), string2 = ((h$w)object).e))) {
                this.g(string3, 1021);
                return;
            }
            int n12 = Build.VERSION.SDK_INT;
            n10 = 24;
            if (n12 >= n10) {
                int n13;
                object2 = (NotificationManager)this.a.getSystemService("notification");
                string2 = "pkg name : ";
                if (object2 != null && (n13 = (int)(object2.areNotificationsEnabled() ? 1 : 0)) == 0) {
                    object = new StringBuilder(string2);
                    object3 = this.a.getPackageName();
                    ((StringBuilder)object).append((String)object3);
                    ((StringBuilder)object).append(" notify switch is false");
                    object = ((StringBuilder)object).toString();
                    s.h((String)object4, (String)object);
                    s.j(this.a, "\u901a\u77e5\u5f00\u5173\u5173\u95ed\uff0c\u5bfc\u81f4\u901a\u77e5\u65e0\u6cd5\u5c55\u793a\uff0c\u8bf7\u5230\u8bbe\u7f6e\u9875\u6253\u5f00\u5e94\u7528\u901a\u77e5\u5f00\u5173");
                    this.g(string3, 2104);
                    return;
                }
                n13 = 26;
                if (n12 >= n13 && object2 != null) {
                    object3 = "vivo_push_channel";
                    object3 = object2.getNotificationChannel((String)object3);
                    if (object3 == null) break block19;
                    int n14 = object3.getImportance();
                    if (n14 != 0) break block19;
                    object3 = new StringBuilder(string2);
                    object2 = this.a;
                    object2 = object2.getPackageName();
                    ((StringBuilder)object3).append((String)object2);
                    object2 = " notify channel switch is false";
                    ((StringBuilder)object3).append((String)object2);
                    object3 = ((StringBuilder)object3).toString();
                    s.h((String)object4, (String)object3);
                    object3 = this.a;
                    object2 = "\u901a\u77e5\u901a\u9053\u5f00\u5173\u5173\u95ed\uff0c\u5bfc\u81f4\u901a\u77e5\u65e0\u6cd5\u5c55\u793a\uff0c\u8bf7\u5230\u8bbe\u7f6e\u9875\u6253\u5f00\u5e94\u7528\u901a\u77e5\u5f00\u5173";
                    s.j((Context)object3, (String)object2);
                    int n15 = 2121;
                    try {
                        this.g(string3, n15);
                        return;
                    }
                    catch (Exception exception) {
                        object3 = "\u5224\u65ad\u901a\u77e5\u901a\u9053\u51fa\u73b0\u7cfb\u7edf\u9519\u8bef";
                        s.h((String)object4, (String)object3);
                    }
                }
            }
        }
        if ((object3 = ((h$r)object).g()) != null) {
            n10 = ((c)object3).o();
            string2 = ((c)object3).q();
            charSequence = new StringBuilder("targetType is ");
            ((StringBuilder)charSequence).append(n10);
            ((StringBuilder)charSequence).append(" ; target is ");
            ((StringBuilder)charSequence).append(string2);
            object2 = ((StringBuilder)charSequence).toString();
            s.m((String)object4, (String)object2);
            object4 = new l$a(this, (d.r.a.r.a)object3, string3, (h$r)object);
            n.c((Runnable)object4);
            return;
        }
        s.a((String)object4, "notify is null");
        object4 = this.a;
        object3 = new StringBuilder("\u901a\u77e5\u5185\u5bb9\u4e3a\u7a7a\uff0c");
        long l12 = ((h$w)object).f;
        ((StringBuilder)object3).append(l12);
        object = ((StringBuilder)object3).toString();
        s.l((Context)object4, (String)object);
        this.g(string3, 1027);
    }
}

