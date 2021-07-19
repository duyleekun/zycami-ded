/*
 * Decompiled with CFR 0.151.
 */
package b.a.b.w1;

import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.OptionsBundle;
import java.util.Comparator;

public final class l
implements Comparator {
    public static final /* synthetic */ l a;

    static {
        l l10;
        a = l10 = new l();
    }

    public final int compare(Object object, Object object2) {
        object = (Config$Option)object;
        object2 = (Config$Option)object2;
        return OptionsBundle.a((Config$Option)object, (Config$Option)object2);
    }
}

