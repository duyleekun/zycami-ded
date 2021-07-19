/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.time.format.f;
import j$.time.format.v;
import java.util.List;

final class e
implements f {
    private final f[] a;
    private final boolean b;

    e(List fArray, boolean bl2) {
        f[] fArray2 = new f[fArray.size()];
        fArray = fArray.toArray(fArray2);
        this.a = fArray;
        this.b = bl2;
    }

    e(f[] fArray, boolean bl2) {
        this.a = fArray;
        this.b = bl2;
    }

    public e a(boolean bl2) {
        boolean bl3 = this.b;
        if (bl2 == bl3) {
            return this;
        }
        f[] fArray = this.a;
        e e10 = new e(fArray, bl2);
        return e10;
    }

    public boolean m(v v10, StringBuilder stringBuilder) {
        boolean bl2;
        int n10;
        int n11;
        int n12 = stringBuilder.length();
        boolean bl3 = this.b;
        if (bl3) {
            v10.g();
        }
        f[] fArray = this.a;
        try {
            n11 = fArray.length;
            n10 = 0;
        }
        catch (Throwable throwable) {
            n12 = (int)(this.b ? 1 : 0);
            if (n12 != 0) {
                v10.a();
            }
            throw throwable;
        }
        while (true) {
            block11: {
                bl2 = true;
                if (n10 >= n11) break;
                f f10 = fArray[n10];
                boolean bl4 = f10.m(v10, stringBuilder);
                if (bl4) break block11;
                stringBuilder.setLength(n12);
                boolean bl5 = this.b;
                if (bl5) {
                    v10.a();
                }
                return bl2;
            }
            ++n10;
        }
        boolean bl6 = this.b;
        if (bl6) {
            v10.a();
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        f[] object = this.a;
        if (object != null) {
            void var2_9;
            void var2_5;
            boolean bl2 = this.b;
            if (bl2) {
                String string2 = "[";
            } else {
                String string3 = "(";
            }
            stringBuilder.append((String)var2_5);
            for (f f10 : this.a) {
                stringBuilder.append(f10);
            }
            bl2 = this.b;
            if (bl2) {
                String string4 = "]";
            } else {
                String string5 = ")";
            }
            stringBuilder.append((String)var2_9);
        }
        return stringBuilder.toString();
    }
}

