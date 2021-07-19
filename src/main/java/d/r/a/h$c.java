/*
 * Decompiled with CFR 0.151.
 */
package d.r.a;

import d.r.a.g;
import d.r.a.h$d;

public final class h$c
extends h$d {
    private String i;
    public String j;
    public String k;
    private String l;

    /*
     * WARNING - void declaration
     */
    public h$c(boolean bl2, String string2) {
        void var2_5;
        void var1_4;
        if (bl2) {
            int n10 = 2006;
        } else {
            int n11 = 2007;
        }
        super((int)var1_4, (String)var2_5);
    }

    public final void d(g g10) {
        super.d(g10);
        String string2 = this.i;
        g10.f("sdk_clients", string2);
        g10.d("sdk_version", 305L);
        string2 = this.k;
        g10.f("BaseAppCommand.EXTRA_APPID", string2);
        string2 = this.j;
        g10.f("BaseAppCommand.EXTRA_APPKEY", string2);
        string2 = this.l;
        g10.f("PUSH_REGID", string2);
    }

    public final void e(g object) {
        String string2;
        super.e((g)object);
        this.i = string2 = ((g)object).b("sdk_clients");
        this.k = string2 = ((g)object).b("BaseAppCommand.EXTRA_APPID");
        this.j = string2 = ((g)object).b("BaseAppCommand.EXTRA_APPKEY");
        this.l = object = ((g)object).b("PUSH_REGID");
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("AppCommand:");
        int n10 = this.a;
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }
}

