/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package com.xiaomi.push.service;

import android.net.Uri;
import android.os.Build;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.az;
import com.xiaomi.push.cz$b;
import com.xiaomi.push.gu;
import com.xiaomi.push.hg;
import com.xiaomi.push.t;
import java.io.IOException;
import java.net.URL;

public class au$a
implements cz$b {
    public String a(String string2) {
        CharSequence charSequence;
        long l10;
        string2 = Uri.parse((String)string2).buildUpon();
        Object object = String.valueOf(39);
        string2.appendQueryParameter("sdkver", (String)object);
        object = String.valueOf(Build.VERSION.SDK_INT);
        string2.appendQueryParameter("osver", (String)object);
        object = new StringBuilder();
        String string3 = Build.MODEL;
        ((StringBuilder)object).append(string3);
        string3 = ":";
        ((StringBuilder)object).append(string3);
        String string4 = Build.VERSION.INCREMENTAL;
        ((StringBuilder)object).append(string4);
        object = gu.a(((StringBuilder)object).toString());
        string2.appendQueryParameter("os", (String)object);
        int n10 = t.a();
        object = String.valueOf(n10);
        string2.appendQueryParameter("mi", (String)object);
        string2 = string2.toString();
        object = new StringBuilder();
        string4 = "fetch bucket from : ";
        ((StringBuilder)object).append(string4);
        ((StringBuilder)object).append(string2);
        b.c(((StringBuilder)object).toString());
        object = new URL(string2);
        int n11 = ((URL)object).getPort();
        int n12 = -1;
        n11 = n11 == n12 ? 80 : ((URL)object).getPort();
        try {
            l10 = System.currentTimeMillis();
        }
        catch (IOException iOException) {
            charSequence = new StringBuilder();
            object = ((URL)object).getHost();
            charSequence.append((String)object);
            charSequence.append(string3);
            charSequence.append(n11);
            hg.a(charSequence.toString(), n12, iOException);
            throw iOException;
        }
        Object object2 = t.a();
        object2 = az.a(object2, (URL)object);
        long l11 = System.currentTimeMillis() - l10;
        CharSequence charSequence2 = new StringBuilder();
        charSequence = ((URL)object).getHost();
        charSequence2.append((String)charSequence);
        charSequence2.append(string3);
        charSequence2.append(n11);
        charSequence2 = charSequence2.toString();
        int n13 = (int)l11;
        hg.a((String)charSequence2, n13, null);
        return object2;
    }
}

