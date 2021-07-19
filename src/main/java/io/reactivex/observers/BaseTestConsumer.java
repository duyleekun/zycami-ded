/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.observers;

import e.a.s0.b;
import e.a.v0.r;
import e.a.w0.b.a;
import e.a.y;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.VolatileSizeArrayList;
import io.reactivex.observers.BaseTestConsumer$TestWaitStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class BaseTestConsumer
implements b {
    public final CountDownLatch a;
    public final List b;
    public final List c;
    public long d;
    public Thread e;
    public boolean f;
    public int g;
    public int h;
    public CharSequence i;
    public boolean j;

    public BaseTestConsumer() {
        Object object = new VolatileSizeArrayList();
        this.b = object;
        object = new VolatileSizeArrayList();
        this.c = object;
        this.a = object = new CountDownLatch(1);
    }

    public static String Y(Object object) {
        if (object != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(object);
            stringBuilder.append(" (class: ");
            object = object.getClass().getSimpleName();
            stringBuilder.append((String)object);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
        return "null";
    }

    public final BaseTestConsumer A(int n10) {
        List list = this.b;
        int n11 = list.size();
        if (n11 == n10) {
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Value counts differ; expected: ");
        stringBuilder.append(n10);
        stringBuilder.append(" but was: ");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        throw this.T(string2);
    }

    public final BaseTestConsumer B(Iterable object) {
        boolean bl2;
        boolean bl3;
        int n10;
        Object object2;
        block3: {
            Object e10;
            Object e11;
            object2 = this.b.iterator();
            object = object.iterator();
            n10 = 0;
            while (true) {
                bl3 = object.hasNext();
                bl2 = object2.hasNext();
                if (!bl2 || !bl3) break block3;
                e11 = object.next();
                boolean bl4 = e.a.w0.b.a.c(e11, e10 = object2.next());
                if (!bl4) break;
                ++n10;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Values at position ");
            ((StringBuilder)object).append(n10);
            ((StringBuilder)object).append(" differ; expected: ");
            object2 = BaseTestConsumer.Y(e11);
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(" but was: ");
            object2 = BaseTestConsumer.Y(e10);
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            throw this.T((String)object);
        }
        object = ")";
        if (!bl2) {
            if (!bl3) {
                return this;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Fewer values received than expected (");
            ((StringBuilder)object2).append(n10);
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            throw this.T((String)object);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("More values received than expected (");
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        throw this.T((String)object);
    }

    public final BaseTestConsumer C(Iterable iterable) {
        return this.t().B(iterable).m().p();
    }

    public final BaseTestConsumer D(Collection object) {
        boolean bl2;
        boolean bl3 = object.isEmpty();
        if (bl3) {
            this.o();
            return this;
        }
        Object object2 = this.b.iterator();
        while (bl2 = object2.hasNext()) {
            Object e10 = object2.next();
            boolean bl4 = object.contains(e10);
            if (bl4) continue;
            object = new StringBuilder();
            ((StringBuilder)object).append("Value not in the expected collection: ");
            object2 = BaseTestConsumer.Y(e10);
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            throw this.T((String)object);
        }
        return this;
    }

    public final BaseTestConsumer E(Collection collection) {
        return this.t().D(collection).m().p();
    }

    public final BaseTestConsumer F(Object ... object) {
        Object object2 = this.b;
        int n10 = object2.size();
        int n11 = ((Object[])object).length;
        String string2 = " but was: ";
        if (n10 == n11) {
            Object var6_6 = null;
            for (n11 = 0; n11 < n10; ++n11) {
                Object object3 = object[n11];
                Object e10 = this.b.get(n11);
                boolean bl2 = e.a.w0.b.a.c(object3, e10);
                if (bl2) {
                    continue;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("Values at position ");
                ((StringBuilder)object).append(n11);
                ((StringBuilder)object).append(" differ; expected: ");
                object2 = BaseTestConsumer.Y(object3);
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(string2);
                object2 = BaseTestConsumer.Y(e10);
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
                throw this.T((String)object);
            }
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Value count differs; expected: ");
        int n12 = ((Object[])object).length;
        stringBuilder.append(n12);
        String string3 = " ";
        stringBuilder.append(string3);
        object = Arrays.toString((Object[])object);
        stringBuilder.append((String)object);
        stringBuilder.append(string2);
        stringBuilder.append(n10);
        stringBuilder.append(string3);
        object = this.b;
        stringBuilder.append(object);
        object = stringBuilder.toString();
        throw this.T((String)object);
    }

    public final BaseTestConsumer G(Object ... objectArray) {
        return this.t().F(objectArray).m().p();
    }

    public final BaseTestConsumer H() {
        long l10;
        CountDownLatch countDownLatch = this.a;
        long l11 = countDownLatch.getCount();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return this;
        }
        this.a.await();
        return this;
    }

    public final boolean I(long l10, TimeUnit timeUnit) {
        boolean bl2;
        boolean bl3;
        long l11;
        CountDownLatch countDownLatch = this.a;
        long l12 = countDownLatch.getCount();
        long l13 = l12 - (l11 = 0L);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        bl3 = object == false || (bl3 = (countDownLatch = this.a).await(l10, timeUnit));
        this.j = bl2 = bl3 ^ true;
        return bl3;
    }

    public final BaseTestConsumer J(int n10) {
        BaseTestConsumer$TestWaitStrategy baseTestConsumer$TestWaitStrategy = BaseTestConsumer$TestWaitStrategy.SLEEP_10MS;
        return this.L(n10, baseTestConsumer$TestWaitStrategy, 5000L);
    }

    public final BaseTestConsumer K(int n10, Runnable runnable) {
        return this.L(n10, runnable, 5000L);
    }

    public final BaseTestConsumer L(int n10, Runnable runnable, long l10) {
        long l11 = System.currentTimeMillis();
        while (true) {
            block5: {
                block4: {
                    List list;
                    long l12;
                    long l13;
                    block3: {
                        long l14;
                        long l15;
                        long l16;
                        if ((l16 = (l15 = l10 - (l13 = 0L)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) <= 0 || (l16 = (l14 = (l12 = System.currentTimeMillis() - l11) - l10) == 0L ? 0 : (l14 < 0L ? -1 : 1)) < 0) break block3;
                        n10 = 1;
                        this.j = n10;
                        break block4;
                    }
                    CountDownLatch countDownLatch = this.a;
                    l12 = countDownLatch.getCount();
                    long l17 = l12 - l13;
                    Object object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                    if (object != false && (object = (Object)(list = this.b).size()) < n10) break block5;
                }
                return this;
            }
            runnable.run();
        }
    }

    public final BaseTestConsumer M(long l10, TimeUnit timeUnit) {
        block4: {
            CountDownLatch countDownLatch;
            try {
                countDownLatch = this.a;
            }
            catch (InterruptedException interruptedException) {
                this.dispose();
                throw ExceptionHelper.f(interruptedException);
            }
            boolean bl2 = countDownLatch.await(l10, timeUnit);
            if (bl2) break block4;
            bl2 = true;
            this.j = bl2;
            this.dispose();
        }
        return this;
    }

    public final boolean N() {
        try {
            this.H();
            return true;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final boolean O(long l10, TimeUnit timeUnit) {
        try {
            return this.I(l10, timeUnit);
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public final BaseTestConsumer P() {
        this.j = false;
        return this;
    }

    public final long Q() {
        return this.d;
    }

    public final int R() {
        return this.c.size();
    }

    public final List S() {
        return this.c;
    }

    public final AssertionError T(String object) {
        int n10 = ((String)object).length() + 64;
        Object object2 = new StringBuilder(n10);
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(" (");
        ((StringBuilder)object2).append("latch = ");
        long l10 = this.a.getCount();
        ((StringBuilder)object2).append(l10);
        object = ", ";
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("values = ");
        n10 = this.b.size();
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("errors = ");
        Object object3 = this.c;
        n10 = object3.size();
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append((String)object);
        object = "completions = ";
        ((StringBuilder)object2).append((String)object);
        l10 = this.d;
        ((StringBuilder)object2).append(l10);
        char c10 = this.j;
        if (c10 != '\u0000') {
            object = ", timeout!";
            ((StringBuilder)object2).append((String)object);
        }
        if ((c10 = this.isDisposed()) != '\u0000') {
            object = ", disposed!";
            ((StringBuilder)object2).append((String)object);
        }
        if ((object = this.i) != null) {
            object3 = ", tag = ";
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append((CharSequence)object);
        }
        c10 = ')';
        ((StringBuilder)object2).append(c10);
        object2 = ((StringBuilder)object2).toString();
        object = new AssertionError(object2);
        object2 = this.c;
        int n11 = object2.isEmpty();
        if (n11 == 0) {
            object2 = this.c;
            n11 = object2.size();
            if (n11 == (n10 = 1)) {
                object2 = this.c;
                n10 = 0;
                object3 = null;
                object2 = (Throwable)object2.get(0);
                ((Throwable)object).initCause((Throwable)object2);
            } else {
                object3 = this.c;
                object2 = new CompositeException((Iterable)object3);
                ((Throwable)object).initCause((Throwable)object2);
            }
        }
        return object;
    }

    public final List U() {
        long l10;
        long l11;
        long l12;
        ArrayList<ArrayList<y>> arrayList = new ArrayList<ArrayList<y>>();
        ArrayList<y> arrayList2 = this.a0();
        arrayList.add(arrayList2);
        arrayList2 = this.S();
        arrayList.add(arrayList2);
        arrayList2 = new ArrayList<y>();
        long l13 = 0L;
        while ((l12 = (l11 = l13 - (l10 = this.d)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
            y y10 = y.a();
            arrayList2.add(y10);
            l10 = 1L;
            l13 += l10;
        }
        arrayList.add(arrayList2);
        return arrayList;
    }

    public final boolean V() {
        long l10;
        CountDownLatch countDownLatch = this.a;
        long l11 = countDownLatch.getCount();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            object = 1;
        } else {
            object = 0;
            countDownLatch = null;
        }
        return (boolean)object;
    }

    public final boolean W() {
        return this.j;
    }

    public final Thread X() {
        return this.e;
    }

    public final int Z() {
        return this.b.size();
    }

    public final BaseTestConsumer a() {
        long l10 = this.d;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            l11 = 1L;
            long l13 = l10 - l11;
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object <= 0) {
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Multiple completions: ");
            stringBuilder.append(l10);
            String string2 = stringBuilder.toString();
            throw this.T(string2);
        }
        throw this.T("Not completed");
    }

    public final List a0() {
        return this.b;
    }

    public final BaseTestConsumer b() {
        return this.t().o().m().p();
    }

    public final BaseTestConsumer b0(CharSequence charSequence) {
        this.i = charSequence;
        return this;
    }

    /*
     * Exception decompiling
     */
    public final BaseTestConsumer c(r var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[DOLOOP]], but top level block is 0[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public final BaseTestConsumer d(Class object) {
        object = Functions.l((Class)object);
        return this.c((r)object);
    }

    public final BaseTestConsumer e(Throwable object) {
        object = Functions.i(object);
        return this.c((r)object);
    }

    public final BaseTestConsumer f(String string2) {
        Object object = this.c;
        int n10 = object.size();
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                object = this.c;
                StringBuilder stringBuilder = null;
                n11 = (int)(e.a.w0.b.a.c(string2, object = ((Throwable)object.get(0)).getMessage()) ? 1 : 0);
                if (n11 != 0) {
                    return this;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("Error message differs; exptected: ");
                stringBuilder.append(string2);
                stringBuilder.append(" but was: ");
                stringBuilder.append((String)object);
                string2 = stringBuilder.toString();
                throw this.T(string2);
            }
            throw this.T("Multiple errors");
        }
        throw this.T("No errors");
    }

    public final BaseTestConsumer g(r r10, Object ... objectArray) {
        return this.t().F(objectArray).c(r10).p();
    }

    public final BaseTestConsumer h(Class clazz, Object ... objectArray) {
        return this.t().F(objectArray).d(clazz).p();
    }

    public final BaseTestConsumer i(Class clazz, String string2, Object ... objectArray) {
        return this.t().F(objectArray).d(clazz).f(string2).p();
    }

    public final BaseTestConsumer k(r object) {
        Object object2 = this.b;
        int n10 = object2.size();
        String string2 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object3;
            block12: {
                object3 = this.b.get(i10);
                try {
                    boolean bl2 = object.test(object3);
                    if (bl2) break block12;
                    continue;
                }
                catch (Exception exception) {
                    throw ExceptionHelper.f(exception);
                }
            }
            object2 = new StringBuilder();
            object3 = "Value at position ";
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(i10);
            string2 = " matches predicate ";
            ((StringBuilder)object2).append(string2);
            object = object.toString();
            ((StringBuilder)object2).append((String)object);
            object = ", which was not expected.";
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            object = this.T((String)object);
            throw object;
        }
        return this;
    }

    public final BaseTestConsumer l(Object object) {
        Object object2 = this.b;
        int n10 = object2.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object e10 = this.b.get(i10);
            boolean bl2 = e.a.w0.b.a.c(e10, object);
            if (!bl2) {
                continue;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Value at position ");
            ((StringBuilder)object2).append(i10);
            ((StringBuilder)object2).append(" is equal to ");
            object = BaseTestConsumer.Y(object);
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append("; Expected them to be different");
            object = ((StringBuilder)object2).toString();
            throw this.T((String)object);
        }
        return this;
    }

    public final BaseTestConsumer m() {
        Object object = this.c;
        int n10 = object.size();
        if (n10 == 0) {
            return this;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Error(s) present: ");
        List list = this.c;
        ((StringBuilder)object).append(list);
        object = ((StringBuilder)object).toString();
        throw this.T((String)object);
    }

    public final BaseTestConsumer n() {
        boolean bl2 = this.j;
        if (!bl2) {
            return this;
        }
        throw this.T("Timeout?!");
    }

    public final BaseTestConsumer o() {
        return this.A(0);
    }

    public final BaseTestConsumer p() {
        long l10 = this.d;
        long l11 = 1L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            if (object <= 0) {
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Multiple completions: ");
            stringBuilder.append(l10);
            String string2 = stringBuilder.toString();
            throw this.T(string2);
        }
        throw this.T("Completed!");
    }

    public abstract BaseTestConsumer q();

    public final BaseTestConsumer r() {
        long l10;
        CountDownLatch countDownLatch = this.a;
        long l11 = countDownLatch.getCount();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            return this;
        }
        throw this.T("Subscriber terminated!");
    }

    public final BaseTestConsumer s(Object ... objectArray) {
        return this.t().F(objectArray).m().a();
    }

    public abstract BaseTestConsumer t();

    public final BaseTestConsumer u() {
        long l10;
        Object object = this.a;
        long l11 = ((CountDownLatch)object).getCount();
        long l12 = l11 - (l10 = 0L);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            l11 = this.d;
            long l13 = 1L;
            long l14 = l11 - l13;
            Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object3 <= 0) {
                boolean bl2;
                List list = this.c;
                object3 = list.size();
                if (object3 <= (bl2 = true)) {
                    Object object4 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
                    if (object4 != false && object3 != false) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Terminated with multiple completions and errors: ");
                        stringBuilder.append(l11);
                        object = stringBuilder.toString();
                        throw this.T((String)object);
                    }
                    return this;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("Terminated with multiple errors: ");
                ((StringBuilder)object).append((int)object3);
                object = ((StringBuilder)object).toString();
                throw this.T((String)object);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Terminated with multiple completions: ");
            stringBuilder.append(l11);
            object = stringBuilder.toString();
            throw this.T((String)object);
        }
        throw this.T("Subscriber still running!");
    }

    public final BaseTestConsumer v() {
        boolean bl2 = this.j;
        if (bl2) {
            return this;
        }
        throw this.T("No timeout?!");
    }

    public final BaseTestConsumer w(r object) {
        this.y(0, (r)object);
        object = this.b;
        int n10 = object.size();
        int n11 = 1;
        if (n10 <= n11) {
            return this;
        }
        throw this.T("Value present but other values as well");
    }

    public final BaseTestConsumer x(Object object) {
        Object object2 = this.b;
        int n10 = object2.size();
        String string2 = " but was: ";
        String string3 = "expected: ";
        int n11 = 1;
        if (n10 == n11) {
            object2 = this.b;
            StringBuilder stringBuilder = null;
            n11 = (int)(e.a.w0.b.a.c(object, object2 = object2.get(0)) ? 1 : 0);
            if (n11 != 0) {
                return this;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            object = BaseTestConsumer.Y(object);
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
            object = BaseTestConsumer.Y(object2);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            throw this.T((String)object);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(string3);
        object = BaseTestConsumer.Y(object);
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(string2);
        object = this.b;
        ((StringBuilder)object2).append(object);
        object = ((StringBuilder)object2).toString();
        throw this.T((String)object);
    }

    public final BaseTestConsumer y(int n10, r object) {
        List list = this.b;
        int n11 = list.size();
        if (n11 != 0) {
            list = this.b;
            n11 = list.size();
            if (n10 < n11) {
                block6: {
                    try {
                        list = this.b;
                    }
                    catch (Exception exception) {
                        throw ExceptionHelper.f(exception);
                    }
                    Object e10 = list.get(n10);
                    n10 = (int)(object.test(e10) ? 1 : 0);
                    if (n10 == 0) break block6;
                    return this;
                }
                throw this.T("Value not present");
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Invalid index: ");
            ((StringBuilder)object).append(n10);
            String string2 = ((StringBuilder)object).toString();
            throw this.T(string2);
        }
        throw this.T("No values");
    }

    public final BaseTestConsumer z(int n10, Object object) {
        Object object2 = this.b;
        int n11 = object2.size();
        if (n11 != 0) {
            if (n10 < n11) {
                object2 = this.b;
                Object object3 = object2.get(n10);
                n11 = (int)(e.a.w0.b.a.c(object, object3) ? 1 : 0);
                if (n11 != 0) {
                    return this;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("expected: ");
                object = BaseTestConsumer.Y(object);
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(" but was: ");
                object3 = BaseTestConsumer.Y(object3);
                ((StringBuilder)object2).append((String)object3);
                object3 = ((StringBuilder)object2).toString();
                throw this.T((String)object3);
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Invalid index: ");
            ((StringBuilder)object).append(n10);
            String string2 = ((StringBuilder)object).toString();
            throw this.T(string2);
        }
        throw this.T("No values");
    }
}

