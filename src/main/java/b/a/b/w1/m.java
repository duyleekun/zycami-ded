/*
 * Decompiled with CFR 0.151.
 */
package b.a.b.w1;

import androidx.camera.core.impl.UseCaseAttachState;
import androidx.camera.core.impl.UseCaseAttachState$AttachStateFilter;
import androidx.camera.core.impl.UseCaseAttachState$UseCaseAttachInfo;

public final class m
implements UseCaseAttachState$AttachStateFilter {
    public static final /* synthetic */ m a;

    static {
        m m10;
        a = m10 = new m();
    }

    public final boolean filter(UseCaseAttachState$UseCaseAttachInfo useCaseAttachState$UseCaseAttachInfo) {
        return UseCaseAttachState.b(useCaseAttachState$UseCaseAttachInfo);
    }
}

