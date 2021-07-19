/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.t.u;
import f.t;
import java.util.Map;
import kotlin.text.CharCategory;

public final class CharCategory$a {
    private CharCategory$a() {
    }

    public /* synthetic */ CharCategory$a(u u10) {
        this();
    }

    private final Map a() {
        t t10 = CharCategory.access$getCategoryMap$cp();
        return (Map)t10.getValue();
    }

    public final CharCategory b(int n10) {
        Object object = this.a();
        Comparable<Integer> comparable = n10;
        if ((object = (CharCategory)((Object)object.get(comparable))) != null) {
            return object;
        }
        comparable = new Comparable<Integer>();
        ((StringBuilder)comparable).append("Category #");
        ((StringBuilder)comparable).append(n10);
        ((StringBuilder)comparable).append(" is not defined.");
        String string2 = ((StringBuilder)comparable).toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }
}

