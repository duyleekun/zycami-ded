/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.constants.Strength;
import com.zhiyun.stabilizer.Stabilizer;
import java.util.function.Predicate;

public final class c4
implements Predicate {
    public static final /* synthetic */ c4 a;

    static {
        c4 c42;
        a = c42 = new c4();
    }

    public final boolean test(Object object) {
        return Stabilizer.S4((Strength)((Object)object));
    }
}

