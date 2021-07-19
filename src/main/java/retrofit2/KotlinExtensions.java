/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  kotlinx.coroutines.CancellableContinuation
 *  kotlinx.coroutines.CancellableContinuationImpl
 *  kotlinx.coroutines.Dispatchers
 */
package retrofit2;

import f.b2.c;
import f.b2.j.b;
import f.h2.s.l;
import f.h2.t.f0;
import f.o0;
import f.q1;
import k.d;
import k.f;
import k.s;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import retrofit2.KotlinExtensions$a;
import retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1;
import retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2;
import retrofit2.KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1;
import retrofit2.KotlinExtensions$b;
import retrofit2.KotlinExtensions$c;
import retrofit2.KotlinExtensions$d;
import retrofit2.KotlinExtensions$suspendAndThrow$1;

public final class KotlinExtensions {
    public static final Object a(d object, c c10) {
        c c11 = IntrinsicsKt__IntrinsicsJvmKt.d(c10);
        int n10 = 1;
        Object object2 = new CancellableContinuationImpl(c11, n10);
        c11 = object2;
        c11 = (CancellableContinuation)object2;
        Object object3 = new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1((d)object);
        c11.invokeOnCancellation((l)object3);
        object3 = new KotlinExtensions$a((CancellableContinuation)c11);
        object.h((f)object3);
        object = object2.getResult();
        object2 = b.h();
        if (object == object2) {
            f.b2.k.a.f.c(c10);
        }
        return object;
    }

    public static final Object b(d object, c c10) {
        c c11 = IntrinsicsKt__IntrinsicsJvmKt.d(c10);
        int n10 = 1;
        Object object2 = new CancellableContinuationImpl(c11, n10);
        c11 = object2;
        c11 = (CancellableContinuation)object2;
        Object object3 = new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2((d)object);
        c11.invokeOnCancellation((l)object3);
        object3 = new KotlinExtensions$b((CancellableContinuation)c11);
        object.h((f)object3);
        object = object2.getResult();
        object2 = b.h();
        if (object == object2) {
            f.b2.k.a.f.c(c10);
        }
        return object;
    }

    public static final Object c(d object, c c10) {
        c c11 = IntrinsicsKt__IntrinsicsJvmKt.d(c10);
        int n10 = 1;
        Object object2 = new CancellableContinuationImpl(c11, n10);
        c11 = object2;
        c11 = (CancellableContinuation)object2;
        Object object3 = new KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1((d)object);
        c11.invokeOnCancellation((l)object3);
        object3 = new KotlinExtensions$c((CancellableContinuation)c11);
        object.h((f)object3);
        object = object2.getResult();
        object2 = b.h();
        if (object == object2) {
            f.b2.k.a.f.c(c10);
        }
        return object;
    }

    public static final /* synthetic */ Object d(s s10) {
        f0.q(s10, "$this$create");
        f0.y(4, "T");
        return s10.g(Object.class);
    }

    /*
     * Unable to fully structure code
     */
    public static final Object e(Exception var0, c var1_1) {
        var2_2 = var1_1 instanceof KotlinExtensions$suspendAndThrow$1;
        if (!var2_2) ** GOTO lbl-1000
        var3_3 = var1_1;
        var3_3 = (KotlinExtensions$suspendAndThrow$1)var1_1;
        var4_4 = var3_3.label;
        var5_5 = -1 << -1;
        var6_6 = var4_4 & var5_5;
        if (var6_6 != 0) {
            var3_3.label = var4_4 -= var5_5;
        } else lbl-1000:
        // 2 sources

        {
            var3_3 = new KotlinExtensions$suspendAndThrow$1((c)var1_1);
        }
        var1_1 = var3_3.result;
        var7_7 = b.h();
        var5_5 = var3_3.label;
        var6_6 = 1;
        if (var5_5 == 0) ** GOTO lbl23
        if (var5_5 == var6_6) {
            var0 = (Exception)var3_3.L$0;
            o0.n(var1_1);
        } else {
            var0 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw var0;
lbl23:
            // 1 sources

            o0.n(var1_1);
            var3_3.L$0 = var0;
            var3_3.label = var6_6;
            var1_1 = Dispatchers.getDefault();
            var8_8 = var3_3.getContext();
            var9_9 = new KotlinExtensions$d(var3_3, (Exception)var0);
            var1_1.dispatch(var8_8, (Runnable)var9_9);
            var0 = b.h();
            var1_1 = b.h();
            if (var0 == var1_1) {
                f.b2.k.a.f.c(var3_3);
            }
            if (var0 == var7_7) {
                return var7_7;
            }
        }
        return q1.a;
    }
}

