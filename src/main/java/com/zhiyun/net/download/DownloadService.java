/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

import g.z;
import g.z$a;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import k.s;
import k.s$b;
import okhttp3.Protocol;

public class DownloadService {
    private static s retrofit;

    private static String getBasUrl(String string2) {
        String string3;
        CharSequence charSequence = "://";
        int n10 = string2.indexOf((String)charSequence);
        boolean bl2 = false;
        CharSequence charSequence2 = null;
        int n11 = -1;
        if (n10 != n11) {
            string3 = string2.substring(0, n10 += 3);
            string2 = string2.substring(n10);
        } else {
            string3 = "";
        }
        charSequence = "/";
        n10 = string2.indexOf((String)charSequence);
        if (n10 != n11) {
            string2 = string2.substring(0, ++n10);
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string2);
        string2 = ((StringBuilder)charSequence).toString();
        charSequence = "http://";
        bl2 = string2.contains(charSequence);
        if (!bl2 && !(bl2 = string2.contains(charSequence2 = "https://"))) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append((String)charSequence);
            ((StringBuilder)charSequence2).append(string2);
            string2 = ((StringBuilder)charSequence2).toString();
        }
        return string2;
    }

    public static s getDownloadRetrofit(String object, int n10) {
        Object object2 = retrofit;
        if (object2 == null) {
            object2 = new s$b();
            Object object3 = new z$a();
            long l10 = n10;
            Object object4 = TimeUnit.SECONDS;
            object4 = ((z$a)object3).k(l10, (TimeUnit)((Object)object4)).j0(l10, (TimeUnit)((Object)object4)).R0(l10, (TimeUnit)((Object)object4));
            object3 = Collections.singletonList(Protocol.HTTP_1_1);
            object4 = ((z$a)object4).f0((List)object3).f();
            object4 = ((s$b)object2).j((z)object4);
            object = DownloadService.getBasUrl((String)object);
            retrofit = object = ((s$b)object4).c((String)object).f();
        }
        return retrofit;
    }
}

