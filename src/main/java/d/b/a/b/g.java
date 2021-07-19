/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import com.android.billingclient.api.SkuDetails;
import d.b.a.b.g$a;
import d.b.a.b.y;
import java.util.ArrayList;

public class g {
    public static final String i = "accountId";
    public static final String j = "prorationMode";
    public static final String k = "vr";
    public static final String l = "skusToReplace";
    public static final String m = "oldSkuPurchaseToken";
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f = 0;
    private ArrayList g;
    private boolean h;

    private g() {
    }

    public /* synthetic */ g(y y10) {
        this();
    }

    public static g$a h() {
        g$a g$a = new g$a(null);
        return g$a;
    }

    public static /* synthetic */ int i(g g10, int n10) {
        g10.f = n10;
        return n10;
    }

    public static /* synthetic */ String j(g g10, String string2) {
        g10.a = null;
        return null;
    }

    public static /* synthetic */ ArrayList l(g g10, ArrayList arrayList) {
        g10.g = arrayList;
        return arrayList;
    }

    public static /* synthetic */ boolean m(g g10, boolean bl2) {
        g10.h = bl2;
        return bl2;
    }

    public static /* synthetic */ String o(g g10, String string2) {
        g10.b = string2;
        return string2;
    }

    public static /* synthetic */ String p(g g10, String string2) {
        g10.e = string2;
        return string2;
    }

    public static /* synthetic */ String s(g g10, String string2) {
        g10.c = string2;
        return string2;
    }

    public static /* synthetic */ String u(g g10, String string2) {
        g10.d = string2;
        return string2;
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public int c() {
        return this.f;
    }

    public String d() {
        return ((SkuDetails)this.g.get(0)).n();
    }

    public SkuDetails e() {
        return (SkuDetails)this.g.get(0);
    }

    public String f() {
        return ((SkuDetails)this.g.get(0)).q();
    }

    public boolean g() {
        return this.h;
    }

    public final ArrayList k() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.g;
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    public final String n() {
        return this.b;
    }

    public final boolean q() {
        String string2;
        boolean bl2;
        boolean bl3;
        int n10;
        block3: {
            block2: {
                Object object;
                boolean bl4;
                ArrayList arrayList = this.g;
                n10 = arrayList.size();
                int n11 = 0;
                do {
                    bl3 = true;
                    if (n11 >= n10) break block2;
                    object = arrayList.get(n11);
                    ++n11;
                } while (!(bl4 = ((String)(object = ((SkuDetails)object).r())).isEmpty()));
                bl2 = false;
                arrayList = null;
                break block3;
            }
            bl2 = bl3;
        }
        n10 = (int)(this.h ? 1 : 0);
        if (n10 == 0 && (string2 = this.b) == null && (string2 = this.a) == null && (string2 = this.e) == null && (n10 = this.f) == 0 && !bl2) {
            return false;
        }
        return bl3;
    }

    public final String r() {
        return this.e;
    }

    public final String t() {
        return this.a;
    }
}

