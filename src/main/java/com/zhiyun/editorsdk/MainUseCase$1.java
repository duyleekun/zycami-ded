/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk;

import com.zhiyun.editorsdk.MainUseCase;
import d.v.h.e.b;
import java.util.List;

public class MainUseCase$1
implements b {
    public final /* synthetic */ MainUseCase a;

    public MainUseCase$1(MainUseCase mainUseCase) {
        this.a = mainUseCase;
    }

    public void m(boolean bl2) {
        Object object = this.a;
        MainUseCase.b((MainUseCase)object, bl2);
        MainUseCase mainUseCase = this.a;
        bl2 = MainUseCase.a(mainUseCase);
        if (bl2) {
            mainUseCase = this.a;
            object = MainUseCase.d(mainUseCase).o0();
            MainUseCase.c(mainUseCase, (List)object);
            mainUseCase = this.a;
            MainUseCase.e(mainUseCase);
        }
    }
}

