/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.t.f0;
import f.n2.m;
import f.n2.q;
import f.x1.c0;
import java.io.Serializable;
import java.util.Iterator;
import kotlin.collections.SlidingWindowKt$a;
import kotlin.collections.SlidingWindowKt$windowedIterator$1;

public final class SlidingWindowKt {
    public static final void a(int n10, int n11) {
        String string2;
        boolean bl2;
        if (n10 > 0 && n11 > 0) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        if (!bl2) {
            Serializable serializable;
            String string3;
            string2 = " must be greater than zero.";
            if (n10 != n11) {
                StringBuilder stringBuilder = new StringBuilder();
                String string4 = "Both size ";
                stringBuilder.append(string4);
                stringBuilder.append(n10);
                stringBuilder.append(" and step ");
                stringBuilder.append(n11);
                stringBuilder.append(string2);
                string3 = stringBuilder.toString();
            } else {
                serializable = new StringBuilder();
                String string5 = "size ";
                serializable.append(string5);
                serializable.append(n10);
                serializable.append(string2);
                string3 = serializable.toString();
            }
            string3 = string3.toString();
            serializable = new IllegalArgumentException(string3);
            throw serializable;
        }
    }

    public static final Iterator b(Iterator iterator2, int n10, int n11, boolean bl2, boolean bl3) {
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1;
        Object object = "iterator";
        f0.p(iterator2, (String)object);
        boolean bl4 = iterator2.hasNext();
        if (!bl4) {
            return c0.a;
        }
        object = slidingWindowKt$windowedIterator$1;
        slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(n10, n11, iterator2, bl3, bl2, null);
        return q.d(slidingWindowKt$windowedIterator$1);
    }

    public static final m c(m m10, int n10, int n11, boolean bl2, boolean bl3) {
        f0.p(m10, "$this$windowedSequence");
        SlidingWindowKt.a(n10, n11);
        SlidingWindowKt$a slidingWindowKt$a = new SlidingWindowKt$a(m10, n10, n11, bl2, bl3);
        return slidingWindowKt$a;
    }
}

