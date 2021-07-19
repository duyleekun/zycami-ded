/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.r0;

import com.google.android.exoplayer2.util.Util;
import java.util.concurrent.ThreadFactory;

public final class e
implements ThreadFactory {
    public final /* synthetic */ String a;

    public /* synthetic */ e(String string2) {
        this.a = string2;
    }

    public final Thread newThread(Runnable runnable) {
        return Util.a(this.a, runnable);
    }
}

