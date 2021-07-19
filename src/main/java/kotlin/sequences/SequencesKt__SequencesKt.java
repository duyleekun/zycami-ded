/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.h2.s.a;
import f.h2.s.l;
import f.h2.s.p;
import f.h2.t.f0;
import f.k2.e;
import f.k2.e$a;
import f.n2.g;
import f.n2.i;
import f.n2.j;
import f.n2.m;
import f.n2.q;
import f.n2.r;
import f.n2.w;
import f.w0;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.sequences.SequencesKt__SequencesKt$a;
import kotlin.sequences.SequencesKt__SequencesKt$b;
import kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1;
import kotlin.sequences.SequencesKt__SequencesKt$flatten$1;
import kotlin.sequences.SequencesKt__SequencesKt$flatten$2;
import kotlin.sequences.SequencesKt__SequencesKt$flatten$3;
import kotlin.sequences.SequencesKt__SequencesKt$generateSequence$1;
import kotlin.sequences.SequencesKt__SequencesKt$generateSequence$2;
import kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1;
import kotlin.sequences.SequencesKt__SequencesKt$shuffled$1;

public class SequencesKt__SequencesKt
extends r {
    private static final m g(a a10) {
        SequencesKt__SequencesKt$a sequencesKt__SequencesKt$a = new SequencesKt__SequencesKt$a(a10);
        return sequencesKt__SequencesKt$a;
    }

    public static final m h(Iterator iterator2) {
        f0.p(iterator2, "$this$asSequence");
        SequencesKt__SequencesKt$b sequencesKt__SequencesKt$b = new SequencesKt__SequencesKt$b(iterator2);
        return SequencesKt__SequencesKt.i(sequencesKt__SequencesKt$b);
    }

    public static final m i(m object) {
        Object object2 = "$this$constrainOnce";
        f0.p(object, (String)object2);
        boolean bl2 = object instanceof f.n2.a;
        object = bl2 ? (f.n2.a)object : (object2 = new f.n2.a((m)object));
        return object;
    }

    public static final m j() {
        return g.a;
    }

    public static final m k(m m10, p p10, l l10) {
        f0.p(m10, "source");
        f0.p(p10, "transform");
        f0.p(l10, "iterator");
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$1 = new SequencesKt__SequencesKt$flatMapIndexed$1(m10, p10, l10, null);
        return q.e(sequencesKt__SequencesKt$flatMapIndexed$1);
    }

    public static final m l(m m10) {
        f0.p(m10, "$this$flatten");
        SequencesKt__SequencesKt$flatten$1 sequencesKt__SequencesKt$flatten$1 = SequencesKt__SequencesKt$flatten$1.INSTANCE;
        return SequencesKt__SequencesKt.m(m10, sequencesKt__SequencesKt$flatten$1);
    }

    private static final m m(m m10, l l10) {
        boolean bl2 = m10 instanceof w;
        if (bl2) {
            return ((w)m10).e(l10);
        }
        SequencesKt__SequencesKt$flatten$3 sequencesKt__SequencesKt$flatten$3 = SequencesKt__SequencesKt$flatten$3.INSTANCE;
        i i10 = new i(m10, sequencesKt__SequencesKt$flatten$3, l10);
        return i10;
    }

    public static final m n(m m10) {
        f0.p(m10, "$this$flatten");
        SequencesKt__SequencesKt$flatten$2 sequencesKt__SequencesKt$flatten$2 = SequencesKt__SequencesKt$flatten$2.INSTANCE;
        return SequencesKt__SequencesKt.m(m10, sequencesKt__SequencesKt$flatten$2);
    }

    public static final m o(Object object, l l10) {
        Object object2 = "nextFunction";
        f0.p(l10, (String)object2);
        if (object == null) {
            object = g.a;
        } else {
            SequencesKt__SequencesKt$generateSequence$2 sequencesKt__SequencesKt$generateSequence$2 = new SequencesKt__SequencesKt$generateSequence$2(object);
            object = object2 = new j(sequencesKt__SequencesKt$generateSequence$2, l10);
        }
        return object;
    }

    public static final m p(a a10) {
        f0.p(a10, "nextFunction");
        SequencesKt__SequencesKt$generateSequence$1 sequencesKt__SequencesKt$generateSequence$1 = new SequencesKt__SequencesKt$generateSequence$1(a10);
        j j10 = new j(a10, sequencesKt__SequencesKt$generateSequence$1);
        return SequencesKt__SequencesKt.i(j10);
    }

    public static final m q(a a10, l l10) {
        f0.p(a10, "seedFunction");
        f0.p(l10, "nextFunction");
        j j10 = new j(a10, l10);
        return j10;
    }

    public static final m r(m m10, a a10) {
        f0.p(m10, "$this$ifEmpty");
        f0.p(a10, "defaultValue");
        SequencesKt__SequencesKt$ifEmpty$1 sequencesKt__SequencesKt$ifEmpty$1 = new SequencesKt__SequencesKt$ifEmpty$1(m10, a10, null);
        return q.e(sequencesKt__SequencesKt$ifEmpty$1);
    }

    private static final m s(m m10) {
        if (m10 == null) {
            m10 = SequencesKt__SequencesKt.j();
        }
        return m10;
    }

    public static final m t(Object ... object) {
        String string2 = "elements";
        f0.p(object, string2);
        int n10 = ((Object[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        object = n10 != 0 ? SequencesKt__SequencesKt.j() : ArraysKt___ArraysKt.h5(object);
        return object;
    }

    public static final m u(m m10) {
        f0.p(m10, "$this$shuffled");
        e$a e$a = e.b;
        return SequencesKt__SequencesKt.v(m10, e$a);
    }

    public static final m v(m m10, e e10) {
        f0.p(m10, "$this$shuffled");
        f0.p(e10, "random");
        SequencesKt__SequencesKt$shuffled$1 sequencesKt__SequencesKt$shuffled$1 = new SequencesKt__SequencesKt$shuffled$1(m10, e10, null);
        return q.e(sequencesKt__SequencesKt$shuffled$1);
    }

    public static final Pair w(m object) {
        boolean bl2;
        f0.p(object, "$this$unzip");
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ArrayList<Object> arrayList2 = new ArrayList<Object>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Pair)object.next();
            Object object3 = ((Pair)object2).getFirst();
            arrayList.add(object3);
            object2 = ((Pair)object2).getSecond();
            arrayList2.add(object2);
        }
        return w0.a(arrayList, arrayList2);
    }
}

