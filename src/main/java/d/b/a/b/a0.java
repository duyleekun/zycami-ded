/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import d.b.a.b.h;
import d.b.a.b.h$a;

public final class a0 {
    public static final h a;
    public static final h b;
    public static final h c;
    public static final h d;
    public static final h e;
    public static final h f;
    public static final h g;
    public static final h h;
    public static final h i;
    public static final h j;
    public static final h k;
    public static final h l;
    private static final h m;
    public static final h n;
    private static final h o;
    public static final h p;
    public static final h q;
    public static final h r;
    public static final h s;
    public static final h t;
    public static final h u;

    static {
        h$a h$a = d.b.a.b.h.c();
        int n10 = 3;
        a = h$a.c(n10).b("Google Play In-app Billing API version is less than 3").a();
        b = d.b.a.b.h.c().c(n10).b("Google Play In-app Billing API version is less than 9").a();
        c = d.b.a.b.h.c().c(n10).b("Billing service unavailable on device.").a();
        h$a = d.b.a.b.h.c();
        int n11 = 5;
        d = h$a.c(n11).b("Client is already in the process of connecting to billing service.").a();
        e = d.b.a.b.h.c().c(n10).b("Play Store version installed does not support cross selling products.").a();
        f = d.b.a.b.h.c().c(n11).b("The list of SKUs can't be empty.").a();
        g = d.b.a.b.h.c().c(n11).b("SKU type can't be empty.").a();
        h$a = d.b.a.b.h.c();
        n10 = -2;
        h = h$a.c(n10).b("Client does not support extra params.").a();
        i = d.b.a.b.h.c().c(n10).b("Client does not support the feature.").a();
        j = d.b.a.b.h.c().c(n10).b("Client does not support get purchase history.").a();
        k = d.b.a.b.h.c().c(n11).b("Invalid purchase token.").a();
        l = d.b.a.b.h.c().c(6).b("An internal error occurred.").a();
        m = d.b.a.b.h.c().c(4).b("Item is unavailable for purchase.").a();
        n = d.b.a.b.h.c().c(n11).b("SKU can't be null.").a();
        o = d.b.a.b.h.c().c(n11).b("SKU type can't be null.").a();
        p = d.b.a.b.h.c().c(0).a();
        q = d.b.a.b.h.c().c(-1).b("Service connection is disconnected.").a();
        r = d.b.a.b.h.c().c(-3).b("Timeout communicating with service.").a();
        s = d.b.a.b.h.c().c(n10).b("Client doesn't support subscriptions.").a();
        t = d.b.a.b.h.c().c(n10).b("Client doesn't support subscriptions update.").a();
        u = d.b.a.b.h.c().c(n11).b("Unknown feature").a();
    }
}

