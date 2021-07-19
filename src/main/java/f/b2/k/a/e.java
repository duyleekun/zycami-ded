/*
 * Decompiled with CFR 0.151.
 */
package f.b2.k.a;

import f.b2.k.a.d;
import f.b2.k.a.g;
import f.h2.t.f0;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;

public final class e {
    private static final int a = 1;

    private static final void a(int n10, int n11) {
        if (n11 <= n10) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Debug metadata version mismatch. Expected: ");
        stringBuilder.append(n10);
        stringBuilder.append(", got ");
        stringBuilder.append(n11);
        stringBuilder.append(". Please update the Kotlin standard library.");
        String string2 = stringBuilder.toString();
        string2 = string2.toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    private static final d b(BaseContinuationImpl baseContinuationImpl) {
        return baseContinuationImpl.getClass().getAnnotation(d.class);
    }

    private static final int c(BaseContinuationImpl object) {
        int n10;
        int n11;
        block10: {
            block9: {
                AnnotatedElement annotatedElement = object.getClass();
                String string2 = "label";
                annotatedElement = ((Class)annotatedElement).getDeclaredField(string2);
                string2 = "field";
                f0.o(annotatedElement, string2);
                n11 = 1;
                ((Field)annotatedElement).setAccessible(n11 != 0);
                object = ((Field)annotatedElement).get(object);
                boolean bl2 = object instanceof Integer;
                if (!bl2) {
                    n10 = 0;
                    object = null;
                }
                object = (Integer)object;
                if (object == null) break block9;
                try {
                    n10 = (Integer)object;
                    break block10;
                }
                catch (Exception exception) {
                    n10 = -1;
                }
            }
            n10 = 0;
            object = null;
        }
        n10 -= n11;
        return n10;
    }

    public static final String[] d(BaseContinuationImpl stringArray) {
        f0.p(stringArray, "$this$getSpilledVariableFieldMapping");
        d d10 = e.b((BaseContinuationImpl)stringArray);
        if (d10 != null) {
            int n10 = d10.v();
            int n11 = 1;
            e.a(n11, n10);
            ArrayList<String> arrayList = new ArrayList<String>();
            int n12 = e.c((BaseContinuationImpl)stringArray);
            int[] nArray = d10.i();
            int n13 = nArray.length;
            for (int i10 = 0; i10 < n13; ++i10) {
                int n14 = nArray[i10];
                if (n14 != n12) continue;
                String string2 = d10.s()[i10];
                arrayList.add(string2);
                string2 = d10.n()[i10];
                arrayList.add(string2);
            }
            stringArray = new String[]{};
            stringArray = arrayList.toArray(stringArray);
            Objects.requireNonNull(stringArray, "null cannot be cast to non-null type kotlin.Array<T>");
            return stringArray;
        }
        return null;
    }

    public static final StackTraceElement e(BaseContinuationImpl object) {
        f0.p(object, "$this$getStackTraceElementImpl");
        Object object2 = e.b((BaseContinuationImpl)object);
        if (object2 != null) {
            Object object3;
            int n10 = object2.v();
            e.a(1, n10);
            int n11 = e.c((BaseContinuationImpl)object);
            if (n11 < 0) {
                n11 = -1;
            } else {
                object3 = object2.l();
                n11 = object3[n11];
            }
            object3 = g.c;
            object = ((g)object3).b((BaseContinuationImpl)object);
            if (object == null) {
                object = object2.c();
            } else {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object);
                char c10 = '/';
                ((StringBuilder)object3).append(c10);
                object = object2.c();
                ((StringBuilder)object3).append((String)object);
                object = ((StringBuilder)object3).toString();
            }
            String string2 = object2.m();
            object2 = object2.f();
            object3 = new StackTraceElement((String)object, string2, (String)object2, n11);
            return object3;
        }
        return null;
    }
}

