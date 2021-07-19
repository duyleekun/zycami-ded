/*
 * Decompiled with CFR 0.151.
 */
package b.a.b.w1;

import androidx.camera.core.impl.UseCaseAttachState;
import androidx.camera.core.impl.UseCaseAttachState$AttachStateFilter;
import androidx.camera.core.impl.UseCaseAttachState$UseCaseAttachInfo;

public final class n
implements UseCaseAttachState$AttachStateFilter {
    public static final /* synthetic */ n a;

    static {
        n n10;
        a = n10 = new n();
    }

    public final boolean filter(UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo) {
        return UseCaseAttachState.a(useCaseAttachState$UseCaseAttachInfo);
    }
}

