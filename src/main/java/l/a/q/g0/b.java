/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.LocaleList
 */
package l.a.q.g0;

import android.os.LocaleList;
import java.util.function.IntFunction;
import l.a.q.g0.n;

public final class b
implements IntFunction {
    public final /* synthetic */ LocaleList a;

    public /* synthetic */ b(LocaleList localeList) {
        this.a = localeList;
    }

    public final Object apply(int n10) {
        return n.e(this.a, n10);
    }
}

