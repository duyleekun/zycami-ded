/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.constants.Strength;
import com.zhiyun.stabilizer.Stabilizer;
import java.util.function.Predicate;

public final class c3
implements Predicate {
    public static final /* synthetic */ c3 a;

    static {
        c3 c32;
        a = c32 = new c3();
    }

    public final boolean test(Object object) {
        return Stabilizer.H4((Strength)((Object)object));
    }
}

