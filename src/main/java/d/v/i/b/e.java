/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b;

import com.zhiyun.editorsdk.draft.DraftUseCase;
import d.v.h.f.a;
import java.util.List;
import java.util.function.Consumer;

public final class e
implements Runnable {
    public final /* synthetic */ DraftUseCase a;
    public final /* synthetic */ List b;
    public final /* synthetic */ long c;
    public final /* synthetic */ int d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ float f;
    public final /* synthetic */ boolean g;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ boolean i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ int k;
    public final /* synthetic */ a l;
    public final /* synthetic */ boolean m;
    public final /* synthetic */ int n;
    public final /* synthetic */ List o;
    public final /* synthetic */ List p;
    public final /* synthetic */ List q;
    public final /* synthetic */ List r;
    public final /* synthetic */ List s;
    public final /* synthetic */ long t;
    public final /* synthetic */ Consumer u;

    public /* synthetic */ e(DraftUseCase draftUseCase, List list, long l10, int n10, boolean bl2, float f10, boolean bl3, boolean bl4, boolean bl5, boolean bl6, int n11, a a10, boolean bl7, int n12, List list2, List list3, List list4, List list5, List list6, long l11, Consumer consumer) {
        this.a = draftUseCase;
        this.b = list;
        this.c = l10;
        this.d = n10;
        this.e = bl2;
        this.f = f10;
        this.g = bl3;
        this.h = bl4;
        this.i = bl5;
        this.j = bl6;
        this.k = n11;
        this.l = a10;
        this.m = bl7;
        this.n = n12;
        this.o = list2;
        this.p = list3;
        this.q = list4;
        this.r = list5;
        this.s = list6;
        this.t = l11;
        this.u = consumer;
    }

    public final void run() {
        DraftUseCase draftUseCase = this.a;
        List list = this.b;
        long l10 = this.c;
        int n10 = this.d;
        boolean bl2 = this.e;
        float f10 = this.f;
        boolean bl3 = this.g;
        boolean bl4 = this.h;
        boolean bl5 = this.i;
        boolean bl6 = this.j;
        int n11 = this.k;
        a a10 = this.l;
        boolean bl7 = this.m;
        int n12 = this.n;
        DraftUseCase draftUseCase2 = draftUseCase;
        List list2 = this.o;
        List list3 = this.p;
        List list4 = this.q;
        List list5 = this.r;
        List list6 = this.s;
        long l11 = this.t;
        Consumer consumer = this.u;
        draftUseCase = draftUseCase2;
        draftUseCase2.f(list, l10, n10, bl2, f10, bl3, bl4, bl5, bl6, n11, a10, bl7, n12, list2, list3, list4, list5, list6, l11, consumer);
    }
}

