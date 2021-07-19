/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.IMultiInstanceInvalidationCallback$Stub;
import androidx.room.MultiInstanceInvalidationClient;
import androidx.room.MultiInstanceInvalidationClient$1$1;
import java.util.concurrent.Executor;

public class MultiInstanceInvalidationClient$1
extends IMultiInstanceInvalidationCallback$Stub {
    public final /* synthetic */ MultiInstanceInvalidationClient this$0;

    public MultiInstanceInvalidationClient$1(MultiInstanceInvalidationClient multiInstanceInvalidationClient) {
        this.this$0 = multiInstanceInvalidationClient;
    }

    public void onInvalidation(String[] stringArray) {
        Executor executor = this.this$0.mExecutor;
        MultiInstanceInvalidationClient$1$1 multiInstanceInvalidationClient$1$1 = new MultiInstanceInvalidationClient$1$1(this, stringArray);
        executor.execute(multiInstanceInvalidationClient$1$1);
    }
}

