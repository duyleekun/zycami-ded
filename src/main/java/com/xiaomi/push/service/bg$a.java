/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.af;
import com.xiaomi.push.az;
import com.xiaomi.push.r;
import com.xiaomi.push.service.bg;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class bg$a
implements Runnable {
    public long a;
    public String a;

    public bg$a(String string2, long l10) {
        this.a = string2;
        this.a = l10;
    }

    public abstract void a(bg var1);

    public void run() {
        bg bg2 = bg.a();
        if (bg2 != null) {
            boolean bl2;
            bg2 = bg.a().a;
            int n10 = az.c((Context)bg2);
            if (n10 == 0) {
                return;
            }
            long l10 = System.currentTimeMillis();
            SharedPreferences sharedPreferences = bg.a(bg.a());
            CharSequence charSequence = new StringBuilder();
            String string2 = ":ts-";
            charSequence.append(string2);
            String string3 = this.a;
            charSequence.append(string3);
            charSequence = charSequence.toString();
            long l11 = 0L;
            long l12 = sharedPreferences.getLong((String)charSequence, l11);
            l10 -= l12;
            l12 = this.a;
            n10 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
            if (n10 > 0 || (bl2 = af.a((Context)bg2))) {
                bg2 = bg.a(bg.a()).edit();
                CharSequence charSequence2 = new StringBuilder();
                charSequence2.append(string2);
                String string4 = this.a;
                charSequence2.append(string4);
                charSequence2 = charSequence2.toString();
                long l13 = System.currentTimeMillis();
                r.a(bg2.putLong((String)charSequence2, l13));
                bg2 = bg.a();
                this.a(bg2);
            }
        }
    }
}

