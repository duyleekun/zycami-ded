/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.bn$a;
import com.xiaomi.push.bo;
import com.xiaomi.push.fs;
import com.xiaomi.push.fv;
import com.xiaomi.push.ge;
import java.text.SimpleDateFormat;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bn
implements ge {
    public static boolean a = false;
    private bn$a a;
    private fs a;
    private fv a;
    private final String a;
    private SimpleDateFormat a;
    private bn$a b;

    public bn(fs fs2) {
        SimpleDateFormat simpleDateFormat;
        this.a = simpleDateFormat = new SimpleDateFormat("hh:mm:ss aaa");
        this.a = null;
        this.a = null;
        this.b = null;
        this.a = null;
        this.a = "[Slim] ";
        this.a = fs2;
        this.a();
    }

    public static /* synthetic */ fs a(bn bn2) {
        return bn2.a;
    }

    public static /* synthetic */ SimpleDateFormat a(bn bn2) {
        return bn2.a;
    }

    private void a() {
        Object object = new bn$a(this, true);
        this.a = object;
        object = new bn$a(this, false);
        this.b = object;
        object = this.a;
        bn$a bn$a = this.a;
        ((fs)object).a(bn$a, bn$a);
        object = this.a;
        bn$a = this.b;
        ((fs)object).b(bn$a, bn$a);
        this.a = object = new bo(this);
    }
}

