/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.b.a.b;

import android.text.TextUtils;
import com.android.billingclient.api.SkuDetails;
import d.b.a.b.g;
import d.b.a.b.y;
import java.util.ArrayList;

public class g$a {
    private String a;
    private String b;
    private String c;
    private String d;
    private int e = 0;
    private ArrayList f;
    private boolean g;

    private g$a() {
    }

    public /* synthetic */ g$a(y y10) {
        this();
    }

    public g a() {
        int n10;
        Object object = this.f;
        if (object != null && (n10 = ((ArrayList)object).isEmpty()) == 0) {
            Object object2;
            Object object3;
            object = this.f;
            int n11 = ((ArrayList)object).size();
            int n12 = 0;
            Object object4 = null;
            for (int i10 = 0; i10 < n11; i10 += 1) {
                object3 = ((ArrayList)object).get(i10);
                if ((object3 = (SkuDetails)object3) != null) continue;
                object = new IllegalArgumentException("SKU cannot be null.");
                throw object;
            }
            object = this.f;
            n10 = ((ArrayList)object).size();
            if (n10 > (n11 = 1)) {
                int n13;
                object = (SkuDetails)this.f.get(0);
                object2 = ((SkuDetails)object).q();
                object4 = this.f;
                int n14 = ((ArrayList)object4).size();
                String string2 = null;
                for (n13 = 0; n13 < n14; ++n13) {
                    Object object5 = ((ArrayList)object4).get(n13);
                    boolean bl2 = ((String)object2).equals(object5 = ((SkuDetails)object5).q());
                    if (bl2) continue;
                    object = new IllegalArgumentException("SKUs should have the same type.");
                    throw object;
                }
                object = ((SkuDetails)object).r();
                n11 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                object4 = "All SKUs must have the same package name.";
                if (n11) {
                    object = this.f;
                    n11 = ((ArrayList)object).size();
                    while (n12 < n11) {
                        object3 = ((ArrayList)object).get(n12);
                        n12 += 1;
                        n14 = (int)(TextUtils.isEmpty(object3 = ((SkuDetails)object3).r()) ? 1 : 0);
                        if (n14 != 0) continue;
                        object = new IllegalArgumentException((String)object4);
                        throw object;
                    }
                } else {
                    object2 = this.f;
                    n14 = ((ArrayList)object2).size();
                    while (n12 < n14) {
                        string2 = (String)((ArrayList)object2).get(n12);
                        n12 += 1;
                        n13 = (int)(((String)object).equals(string2 = ((SkuDetails)((Object)string2)).r()) ? 1 : 0);
                        if (n13 != 0) continue;
                        object = new IllegalArgumentException((String)object4);
                        throw object;
                    }
                }
            }
            object = new g(null);
            d.b.a.b.g.j((g)object, null);
            object2 = this.a;
            d.b.a.b.g.o((g)object, (String)object2);
            object2 = this.d;
            d.b.a.b.g.p((g)object, (String)object2);
            object2 = this.b;
            d.b.a.b.g.s((g)object, (String)object2);
            object2 = this.c;
            d.b.a.b.g.u((g)object, (String)object2);
            n11 = this.e;
            d.b.a.b.g.i((g)object, n11);
            object2 = this.f;
            d.b.a.b.g.l((g)object, (ArrayList)object2);
            n11 = (int)(this.g ? 1 : 0);
            d.b.a.b.g.m((g)object, n11 != 0);
            return object;
        }
        object = new IllegalArgumentException("SkuDetails must be provided.");
        throw object;
    }

    public g$a b(String string2) {
        this.a = string2;
        return this;
    }

    public g$a c(String string2) {
        this.d = string2;
        return this;
    }

    public g$a d(String string2, String string3) {
        this.b = string2;
        this.c = string3;
        return this;
    }

    public g$a e(int n10) {
        this.e = n10;
        return this;
    }

    public g$a f(SkuDetails skuDetails) {
        ArrayList<SkuDetails> arrayList = new ArrayList<SkuDetails>();
        arrayList.add(skuDetails);
        this.f = arrayList;
        return this;
    }

    public g$a g(boolean bl2) {
        this.g = bl2;
        return this;
    }
}

