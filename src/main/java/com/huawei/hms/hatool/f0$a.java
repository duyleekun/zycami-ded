/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.f0;
import com.huawei.hms.hatool.y;
import java.util.Calendar;
import java.util.UUID;

public class f0$a {
    public String a;
    public boolean b;
    public long c;
    public final /* synthetic */ f0 d;

    public f0$a(f0 f02, long l10) {
        this.d = f02;
        CharSequence charSequence = UUID.randomUUID().toString().replace("-", "");
        this.a = charSequence;
        String string2 = this.a;
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append("_");
        ((StringBuilder)charSequence).append(l10);
        charSequence = ((StringBuilder)charSequence).toString();
        this.a = charSequence;
        this.c = l10;
        this.b = true;
        f0.a(f02, false);
    }

    public void a(long l10) {
        f0 f02 = this.d;
        boolean bl2 = f0.a(f02);
        if (bl2) {
            f0.a(this.d, false);
            this.b(l10);
            return;
        }
        long l11 = this.c;
        bl2 = this.b(l11, l10);
        if (!bl2 && !(bl2 = this.a(l11 = this.c, l10))) {
            this.c = l10;
            this.b = false;
            return;
        }
        this.b(l10);
    }

    public final boolean a(long l10, long l11) {
        int n10;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l10);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(l11);
        boolean bl2 = true;
        int n11 = calendar.get((int)(bl2 ? 1 : 0));
        int n12 = calendar2.get((int)(bl2 ? 1 : 0));
        if (n11 == n12 && (n12 = calendar.get(n11 = 6)) == (n10 = calendar2.get(n11))) {
            bl2 = false;
        }
        return bl2;
    }

    public final void b(long l10) {
        y.c("hmsSdk", "getNewSession() session is flush!");
        CharSequence charSequence = UUID.randomUUID().toString();
        this.a = charSequence;
        charSequence = ((String)charSequence).replace("-", "");
        this.a = charSequence;
        charSequence = new StringBuilder();
        String string2 = this.a;
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append("_");
        ((StringBuilder)charSequence).append(l10);
        charSequence = ((StringBuilder)charSequence).toString();
        this.a = charSequence;
        this.c = l10;
        this.b = true;
    }

    public final boolean b(long l10, long l11) {
        f0 f02 = this.d;
        long l12 = (l11 -= l10) - (l10 = f0.b(f02));
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            object = 1;
        } else {
            object = 0;
            f02 = null;
        }
        return (boolean)object;
    }
}

