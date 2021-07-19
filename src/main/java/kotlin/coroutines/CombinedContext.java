/*
 * Decompiled with CFR 0.151.
 */
package kotlin.coroutines;

import f.h2.s.p;
import f.h2.t.f0;
import f.q1;
import java.io.Serializable;
import java.util.Objects;
import kotlin.coroutines.CombinedContext$Serialized;
import kotlin.coroutines.CombinedContext$toString$1;
import kotlin.coroutines.CombinedContext$writeReplace$1;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext$DefaultImpls;
import kotlin.coroutines.CoroutineContext$a;
import kotlin.coroutines.CoroutineContext$b;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Ref$IntRef;

public final class CombinedContext
implements CoroutineContext,
Serializable {
    private final CoroutineContext$a element;
    private final CoroutineContext left;

    public CombinedContext(CoroutineContext coroutineContext, CoroutineContext$a coroutineContext$a) {
        f0.p(coroutineContext, "left");
        f0.p(coroutineContext$a, "element");
        this.left = coroutineContext;
        this.element = coroutineContext$a;
    }

    private final boolean c(CoroutineContext$a coroutineContext$a) {
        CoroutineContext$b coroutineContext$b = coroutineContext$a.getKey();
        return f0.g(this.get(coroutineContext$b), coroutineContext$a);
    }

    private final boolean d(CombinedContext coroutineContext) {
        boolean bl2;
        do {
            CoroutineContext$a coroutineContext$a;
            if (bl2 = this.c(coroutineContext$a = coroutineContext.element)) continue;
            return false;
        } while (bl2 = (coroutineContext = coroutineContext.left) instanceof CombinedContext);
        Objects.requireNonNull(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
        coroutineContext = (CoroutineContext$a)coroutineContext;
        return this.c((CoroutineContext$a)coroutineContext);
    }

    private final int e() {
        int n10 = 2;
        CoroutineContext coroutineContext = this;
        while (true) {
            boolean bl2;
            if (!(bl2 = (coroutineContext = coroutineContext.left) instanceof CombinedContext)) {
                coroutineContext = null;
            }
            if (coroutineContext == null) break;
            ++n10;
        }
        return n10;
    }

    private final Object writeReplace() {
        int n10 = this.e();
        Object object = new CoroutineContext[n10];
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        boolean bl2 = false;
        ref$IntRef.element = 0;
        q1 q12 = q1.a;
        CombinedContext$writeReplace$1 combinedContext$writeReplace$1 = new CombinedContext$writeReplace$1((CoroutineContext[])object, ref$IntRef);
        this.fold(q12, combinedContext$writeReplace$1);
        int n11 = ref$IntRef.element;
        if (n11 == n10) {
            bl2 = true;
        }
        if (bl2) {
            CombinedContext$Serialized combinedContext$Serialized = new CombinedContext$Serialized((CoroutineContext[])object);
            return combinedContext$Serialized;
        }
        object = "Check failed.".toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public boolean equals(Object object) {
        boolean bl2;
        int n10;
        int n11;
        if (!(this == object || (n11 = object instanceof CombinedContext) != 0 && (n11 = super.e()) == (n10 = this.e()) && (bl2 = super.d(this)))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public Object fold(Object object, p p10) {
        f0.p(p10, "operation");
        object = this.left.fold(object, p10);
        CoroutineContext$a coroutineContext$a = this.element;
        return p10.invoke(object, coroutineContext$a);
    }

    public CoroutineContext$a get(CoroutineContext$b coroutineContext$b) {
        boolean bl2;
        f0.p(coroutineContext$b, "key");
        CoroutineContext coroutineContext = this;
        do {
            CoroutineContext$a coroutineContext$a;
            if ((coroutineContext$a = ((CombinedContext)coroutineContext).element.get(coroutineContext$b)) == null) continue;
            return coroutineContext$a;
        } while (bl2 = (coroutineContext = ((CombinedContext)coroutineContext).left) instanceof CombinedContext);
        return coroutineContext.get(coroutineContext$b);
    }

    public int hashCode() {
        int n10 = this.left.hashCode();
        int n11 = this.element.hashCode();
        return n10 + n11;
    }

    public CoroutineContext minusKey(CoroutineContext$b object) {
        f0.p(object, "key");
        CoroutineContext coroutineContext = this.element.get((CoroutineContext$b)object);
        if (coroutineContext != null) {
            return this.left;
        }
        if ((object = this.left.minusKey((CoroutineContext$b)object)) == (coroutineContext = this.left)) {
            object = this;
        } else {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
            if (object == coroutineContext) {
                object = this.element;
            } else {
                CoroutineContext$a coroutineContext$a = this.element;
                coroutineContext = new CombinedContext((CoroutineContext)object, coroutineContext$a);
                object = coroutineContext;
            }
        }
        return object;
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        f0.p(coroutineContext, "context");
        return CoroutineContext$DefaultImpls.a(this, coroutineContext);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Object object = CombinedContext$toString$1.INSTANCE;
        object = (String)this.fold("", (p)object);
        stringBuilder.append((String)object);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

