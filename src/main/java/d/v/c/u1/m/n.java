/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package d.v.c.u1.m;

import android.util.SparseArray;
import com.zhiyun.cama.template.edit.AiUseCase;
import java.util.List;
import java.util.function.IntUnaryOperator;

public final class n
implements IntUnaryOperator {
    public final /* synthetic */ AiUseCase a;
    public final /* synthetic */ List b;
    public final /* synthetic */ List c;
    public final /* synthetic */ List d;
    public final /* synthetic */ SparseArray e;
    public final /* synthetic */ boolean f;

    public /* synthetic */ n(AiUseCase aiUseCase, List list, List list2, List list3, SparseArray sparseArray, boolean bl2) {
        this.a = aiUseCase;
        this.b = list;
        this.c = list2;
        this.d = list3;
        this.e = sparseArray;
        this.f = bl2;
    }

    public final int applyAsInt(int n10) {
        AiUseCase aiUseCase = this.a;
        List list = this.b;
        List list2 = this.c;
        List list3 = this.d;
        SparseArray sparseArray = this.e;
        boolean bl2 = this.f;
        return aiUseCase.G(list, list2, list3, sparseArray, bl2, n10);
    }
}

