/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.editorsdk.MainUseCase;
import com.zhiyun.editorsdk.fundation.EditorUseCase$OnTimeUpdateListener;
import d.v.c.i1.i2;
import d.v.e.i.h;

public class i2$c
implements EditorUseCase$OnTimeUpdateListener {
    public final /* synthetic */ i2 a;

    public i2$c(i2 i22) {
        this.a = i22;
    }

    public void a(long l10) {
        MutableLiveData mutableLiveData = i2.f(this.a);
        Long l11 = l10 - 1L;
        h.g(mutableLiveData, l11);
        i2.g(this.a);
    }

    public void b(long l10) {
        long l11;
        long l12;
        Object object;
        int n10 = d.v.v.q.h.p();
        Object object2 = this.a.G;
        boolean n11 = ((MainUseCase)object2).Q();
        long l13 = 0L;
        float f10 = 0.0f;
        if (n11) {
            object = this.a.G;
            l13 = ((MainUseCase)object).J();
            float f11 = l10;
            float f12 = l13;
            f10 = f11 / f12;
            l12 = l13;
            l13 = l10;
        } else {
            int n12 = -1;
            float f13 = 0.0f / 0.0f;
            if (n10 != n12) {
                l12 = d.v.v.q.h.Y(n10);
                long l14 = l12 - l13;
                Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object3 >= 0) {
                    object2 = this.a.G;
                    l11 = ((MainUseCase)object2).I(n10);
                    l13 = l10 - l11;
                    float f14 = l13;
                    f13 = l12;
                    f10 = f14 / f13;
                }
            } else {
                l12 = l13;
            }
        }
        l11 = 40000L;
        long l15 = l13 - (l12 -= l11);
        n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
        if (n10 >= 0) {
            f10 = 1.0f;
        }
        object = i2.m(this.a);
        object2 = Float.valueOf(f10);
        h.g((MutableLiveData)object, object2);
        object = i2.e(this.a);
        Long l16 = l10;
        h.g((MutableLiveData)object, l16);
    }
}

