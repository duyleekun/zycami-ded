/*
 * Decompiled with CFR 0.151.
 */
package kotlin.text;

import f.h2.t.u;
import f.t;
import java.util.Map;
import kotlin.text.CharDirectionality;

public final class CharDirectionality$a {
    private CharDirectionality$a() {
    }

    public /* synthetic */ CharDirectionality$a(u u10) {
        this();
    }

    private final Map a() {
        t t10 = CharDirectionality.access$getDirectionalityMap$cp();
        return (Map)t10.getValue();
    }

    public final CharDirectionality b(int n10) {
        Object object = this.a();
        Comparable<Integer> comparable = n10;
        if ((object = (CharDirectionality)((Object)object.get(comparable))) != null) {
            return object;
        }
        comparable = new Comparable<Integer>();
        ((StringBuilder)comparable).append("Directionality #");
        ((StringBuilder)comparable).append(n10);
        ((StringBuilder)comparable).append(" is not defined.");
        String string2 = ((StringBuilder)comparable).toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }
}

