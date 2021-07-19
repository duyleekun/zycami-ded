/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.template.edit;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.template.edit.TemplateEditViewModel;
import com.zhiyun.editorsdk.MainUseCase;
import com.zhiyun.editorsdk.fundation.EditorUseCase$OnTimeUpdateListener;
import d.v.e.i.h;

public class TemplateEditViewModel$b
implements EditorUseCase$OnTimeUpdateListener {
    public final /* synthetic */ TemplateEditViewModel a;

    public TemplateEditViewModel$b(TemplateEditViewModel templateEditViewModel) {
        this.a = templateEditViewModel;
    }

    public void a(long l10) {
        MutableLiveData mutableLiveData = TemplateEditViewModel.g(this.a);
        Long l11 = l10;
        h.g(mutableLiveData, l11);
    }

    public void b(long l10) {
        long l11;
        Object object = TemplateEditViewModel.i(this.a);
        l10 = ((MainUseCase)object).E();
        int n10 = d.v.v.q.h.p();
        Object object2 = TemplateEditViewModel.i(this.a);
        boolean n11 = ((MainUseCase)object2).Q();
        long l12 = 0L;
        float f10 = 0.0f;
        if (n11) {
            l12 = TemplateEditViewModel.i(this.a).J();
            float f11 = l10;
            float f12 = l12;
            f10 = f11 / f12;
            MutableLiveData mutableLiveData = TemplateEditViewModel.f(this.a);
            object2 = l10;
            h.g(mutableLiveData, object2);
        } else {
            int n12 = -1;
            float f13 = 0.0f / 0.0f;
            if (n10 != n12) {
                long l13 = d.v.v.q.h.Y(n10);
                long l14 = l13 - l12;
                Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object3 >= 0) {
                    object2 = TemplateEditViewModel.i(this.a);
                    l11 = ((MainUseCase)object2).I(n10);
                    float f14 = l10 -= l11;
                    f13 = l13;
                    f10 = f14 / f13;
                } else {
                    l10 = l12;
                }
                l12 = l13;
            } else {
                l10 = l12;
            }
        }
        l11 = 40000L;
        long l15 = l10 - (l12 -= l11);
        long l16 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (l16 >= 0) {
            f10 = 1.0f;
        }
        object = TemplateEditViewModel.p(this.a);
        Float f15 = Float.valueOf(f10);
        h.e((MutableLiveData)object, f15);
    }
}

