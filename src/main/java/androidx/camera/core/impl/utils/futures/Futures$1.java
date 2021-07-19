/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.futures;

import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;

public class Futures$1
implements AsyncFunction {
    public final /* synthetic */ Function val$function;

    public Futures$1(Function function) {
        this.val$function = function;
    }

    public ListenableFuture apply(Object object) {
        return Futures.immediateFuture(this.val$function.apply(object));
    }
}

