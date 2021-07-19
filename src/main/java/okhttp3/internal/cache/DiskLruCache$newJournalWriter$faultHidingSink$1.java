/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.cache;

import f.h2.s.l;
import f.h2.t.f0;
import g.h0.d;
import java.io.IOException;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.cache.DiskLruCache;

public final class DiskLruCache$newJournalWriter$faultHidingSink$1
extends Lambda
implements l {
    public final /* synthetic */ DiskLruCache this$0;

    public DiskLruCache$newJournalWriter$faultHidingSink$1(DiskLruCache diskLruCache) {
        this.this$0 = diskLruCache;
        super(1);
    }

    public final void invoke(IOException object) {
        Object object2 = "it";
        f0.p(object, (String)object2);
        object = this.this$0;
        boolean bl2 = d.h;
        if (bl2 && !(bl2 = Thread.holdsLock(object))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Object object3 = Thread.currentThread();
            f0.o(object3, "Thread.currentThread()");
            object3 = ((Thread)object3).getName();
            stringBuilder.append((String)object3);
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new AssertionError(object);
            throw object2;
        }
        DiskLruCache.n0(this.this$0, true);
    }
}

