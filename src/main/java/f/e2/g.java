/*
 * Decompiled with CFR 0.151.
 */
package f.e2;

import f.h2.t.f0;
import java.io.File;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;

public final class g {
    private final File a;
    private final List b;

    public g(File file, List list) {
        f0.p(file, "root");
        f0.p(list, "segments");
        this.a = file;
        this.b = list;
    }

    public static /* synthetic */ g d(g g10, File file, List list, int n10, Object object) {
        int n11 = n10 & 1;
        if (n11 != 0) {
            file = g10.a;
        }
        if ((n10 &= 2) != 0) {
            list = g10.b;
        }
        return g10.c(file, list);
    }

    public final File a() {
        return this.a;
    }

    public final List b() {
        return this.b;
    }

    public final g c(File file, List list) {
        f0.p(file, "root");
        f0.p(list, "segments");
        g g10 = new g(file, list);
        return g10;
    }

    public final File e() {
        return this.a;
    }

    public boolean equals(Object object) {
        block2: {
            block3: {
                boolean bl2;
                if (this == object) break block2;
                boolean bl3 = object instanceof g;
                if (!bl3) break block3;
                object = (g)object;
                Object object2 = this.a;
                File file = ((g)object).a;
                bl3 = f0.g(object2, file);
                if (bl3 && (bl2 = f0.g(object2 = this.b, object = ((g)object).b))) break block2;
            }
            return false;
        }
        return true;
    }

    public final String f() {
        String string2 = this.a.getPath();
        f0.o(string2, "root.path");
        return string2;
    }

    public final List g() {
        return this.b;
    }

    public final int h() {
        return this.b.size();
    }

    public int hashCode() {
        int n10;
        File file = this.a;
        int n11 = 0;
        if (file != null) {
            n10 = ((Object)file).hashCode();
        } else {
            n10 = 0;
            file = null;
        }
        n10 *= 31;
        List list = this.b;
        if (list != null) {
            n11 = ((Object)list).hashCode();
        }
        return n10 + n11;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean i() {
        void var3_6;
        String string2 = this.a.getPath();
        String string3 = "root.path";
        f0.o(string2, string3);
        int bl2 = string2.length();
        if (bl2 > 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            string2 = null;
        }
        return (boolean)var3_6;
    }

    public final File j(int n10, int n11) {
        int n12;
        if (n10 >= 0 && n10 <= n11 && n11 <= (n12 = this.h())) {
            List list = this.b.subList(n10, n11);
            String string2 = File.separator;
            f0.o(string2, "File.separator");
            String string3 = CollectionsKt___CollectionsKt.X2(list, string2, null, null, 0, null, null, 62, null);
            File file = new File(string3);
            return file;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FilePathComponents(root=");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append(", segments=");
        object = this.b;
        stringBuilder.append(object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

