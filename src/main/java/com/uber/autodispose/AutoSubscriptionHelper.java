/*
 * Decompiled with CFR 0.151.
 */
package com.uber.autodispose;

import d.q.a.p;
import e.a.a1.a;
import i.g.e;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class AutoSubscriptionHelper
extends Enum
implements e {
    public static final /* enum */ AutoSubscriptionHelper CANCELLED;
    private static final /* synthetic */ AutoSubscriptionHelper[] a;

    static {
        AutoSubscriptionHelper autoSubscriptionHelper;
        CANCELLED = autoSubscriptionHelper = new AutoSubscriptionHelper("CANCELLED", 0);
        AutoSubscriptionHelper[] autoSubscriptionHelperArray = new AutoSubscriptionHelper[]{autoSubscriptionHelper};
        a = autoSubscriptionHelperArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AutoSubscriptionHelper() {
        void var2_-1;
        void var1_-1;
    }

    public static boolean cancel(AtomicReference object) {
        AutoSubscriptionHelper autoSubscriptionHelper;
        e e10 = (e)((AtomicReference)object).get();
        if (e10 != (autoSubscriptionHelper = CANCELLED) && (object = (e)((AtomicReference)object).getAndSet(autoSubscriptionHelper)) != autoSubscriptionHelper) {
            if (object != null) {
                object.cancel();
            }
            return true;
        }
        return false;
    }

    public static void deferredRequest(AtomicReference object, AtomicLong atomicLong, long l10) {
        e e10 = (e)((AtomicReference)object).get();
        if (e10 != null) {
            e10.request(l10);
        } else {
            boolean bl2 = AutoSubscriptionHelper.validate(l10);
            if (bl2) {
                long l11;
                long l12;
                long l13;
                d.q.a.e.a(atomicLong, l10);
                object = (e)((AtomicReference)object).get();
                if (object != null && (l13 = (l12 = (l11 = atomicLong.getAndSet(l10 = 0L)) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
                    object.request(l11);
                }
            }
        }
    }

    public static boolean deferredSetOnce(AtomicReference atomicReference, AtomicLong atomicLong, e e10) {
        boolean bl2 = AutoSubscriptionHelper.setOnce(atomicReference, e10);
        if (bl2) {
            long l10 = 0L;
            long l11 = atomicLong.getAndSet(l10);
            long l12 = l11 - l10;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object != false) {
                e10.request(l11);
            }
            return true;
        }
        return false;
    }

    public static boolean isCancelled(e e10) {
        boolean bl2;
        AutoSubscriptionHelper autoSubscriptionHelper = CANCELLED;
        if (e10 == autoSubscriptionHelper) {
            bl2 = true;
        } else {
            bl2 = false;
            e10 = null;
        }
        return bl2;
    }

    public static boolean replace(AtomicReference atomicReference, e e10) {
        e e11;
        boolean bl2;
        do {
            AutoSubscriptionHelper autoSubscriptionHelper;
            if ((e11 = (e)atomicReference.get()) != (autoSubscriptionHelper = CANCELLED)) continue;
            if (e10 != null) {
                e10.cancel();
            }
            return false;
        } while (!(bl2 = atomicReference.compareAndSet(e11, e10)));
        return true;
    }

    public static void reportMoreProduced(long l10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("More produced than requested: ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        e.a.a1.a.Y(illegalStateException);
    }

    public static void reportSubscriptionSet() {
        IllegalStateException illegalStateException = new IllegalStateException("Subscription already set!");
        e.a.a1.a.Y(illegalStateException);
    }

    public static boolean set(AtomicReference atomicReference, e e10) {
        e e11;
        boolean bl2;
        do {
            AutoSubscriptionHelper autoSubscriptionHelper;
            if ((e11 = (e)atomicReference.get()) != (autoSubscriptionHelper = CANCELLED)) continue;
            if (e10 != null) {
                e10.cancel();
            }
            return false;
        } while (!(bl2 = atomicReference.compareAndSet(e11, e10)));
        if (e11 != null) {
            e11.cancel();
        }
        return true;
    }

    public static boolean setIfNotSet(AtomicReference atomicReference, e e10) {
        p.a(e10, "s is null");
        return atomicReference.compareAndSet(null, e10);
    }

    public static boolean setOnce(AtomicReference atomicReference, e e10) {
        p.a(e10, "s is null");
        boolean bl2 = atomicReference.compareAndSet(null, e10);
        if (!bl2) {
            e10.cancel();
            atomicReference = atomicReference.get();
            e10 = CANCELLED;
            if (atomicReference != e10) {
                AutoSubscriptionHelper.reportSubscriptionSet();
            }
            return false;
        }
        return true;
    }

    public static boolean validate(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("n > 0 required but it was ");
            stringBuilder.append(l10);
            String string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            e.a.a1.a.Y(illegalArgumentException);
            return false;
        }
        return true;
    }

    public static boolean validate(e object, e e10) {
        if (e10 == null) {
            object = new NullPointerException("next is null");
            e.a.a1.a.Y((Throwable)object);
            return false;
        }
        if (object != null) {
            e10.cancel();
            AutoSubscriptionHelper.reportSubscriptionSet();
            return false;
        }
        return true;
    }

    public static AutoSubscriptionHelper valueOf(String string2) {
        return Enum.valueOf(AutoSubscriptionHelper.class, string2);
    }

    public static AutoSubscriptionHelper[] values() {
        return (AutoSubscriptionHelper[])a.clone();
    }

    public void cancel() {
    }

    public void request(long l10) {
    }
}

