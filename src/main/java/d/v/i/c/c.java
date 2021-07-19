/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.c;

import com.zhiyun.editorsdk.template.StickerBean;
import com.zhiyun.editorsdk.template.TemplateUseCase;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

public final class c
implements Consumer {
    public final /* synthetic */ AtomicReference a;
    public final /* synthetic */ AtomicReference b;

    public /* synthetic */ c(AtomicReference atomicReference, AtomicReference atomicReference2) {
        this.a = atomicReference;
        this.b = atomicReference2;
    }

    public final void accept(Object object) {
        AtomicReference atomicReference = this.a;
        AtomicReference atomicReference2 = this.b;
        object = (StickerBean)object;
        TemplateUseCase.G(atomicReference, atomicReference2, (StickerBean)object);
    }
}

