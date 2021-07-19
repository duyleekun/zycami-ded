/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.cache;

import f.h2.s.l;
import f.h2.t.f0;
import f.q1;
import java.io.IOException;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.cache.DiskLruCache$Editor;

public final class DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1
extends Lambda
implements l {
    public final /* synthetic */ int $index$inlined;
    public final /* synthetic */ DiskLruCache$Editor this$0;

    public DiskLruCache$Editor$newSink$$inlined$synchronized$lambda$1(DiskLruCache$Editor diskLruCache$Editor, int n10) {
        this.this$0 = diskLruCache$Editor;
        this.$index$inlined = n10;
        super(1);
    }

    public final void invoke(IOException object) {
        Object object2 = "it";
        f0.p(object, (String)object2);
        object = this.this$0.d;
        synchronized (object) {
            object2 = this.this$0;
            ((DiskLruCache$Editor)object2).c();
            object2 = q1.a;
            return;
        }
    }
}

