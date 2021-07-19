/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.platform.uploader;

import com.quvideo.mobile.external.platform.uploader.OooO0o$a;
import d.o.a.a.b.c.c;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OooO0o
extends AbstractQueue
implements BlockingQueue,
Serializable {
    private ArrayList OooO00o;
    private final AtomicInteger OooO0O0;
    private final ReentrantLock OooO0OO;
    private final Condition OooO0Oo;

    public OooO0o() {
        Object object = new ArrayList();
        this.OooO00o = object;
        this.OooO0O0 = object;
        super();
        this.OooO0OO = object;
        this.OooO0Oo = object = ((ReentrantLock)object).newCondition();
    }

    public c OooO00o() {
        Object object;
        Serializable serializable;
        block8: {
            serializable = this.OooO0O0;
            int n10 = ((AtomicInteger)serializable).get();
            object = null;
            if (n10 == 0) {
                return null;
            }
            serializable = this.OooO0OO;
            ((ReentrantLock)serializable).lock();
            AtomicInteger atomicInteger = this.OooO0O0;
            int n11 = atomicInteger.get();
            if (n11 <= 0) break block8;
            object = this.OooO00o;
            n11 = 0;
            atomicInteger = null;
            object = ((ArrayList)object).get(0);
            object = (c)object;
        }
        return object;
        finally {
            ((ReentrantLock)serializable).unlock();
        }
    }

    public c OooO00o(long l10, TimeUnit object) {
        Object object2;
        ReentrantLock reentrantLock;
        block13: {
            l10 = ((TimeUnit)((Object)object)).toNanos(l10);
            object = this.OooO0O0;
            reentrantLock = this.OooO0OO;
            reentrantLock.lockInterruptibly();
            while (true) {
                int n10 = ((AtomicInteger)object).get();
                if (n10 != 0) break;
                long l11 = 0L;
                long l12 = l10 - l11;
                n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                if (n10 <= 0) {
                    reentrantLock.unlock();
                    return null;
                }
                Condition condition = this.OooO0Oo;
                l10 = condition.awaitNanos(l10);
                continue;
                break;
            }
            object2 = this.OooO00o;
            int n11 = 0;
            Condition condition = null;
            object2 = ((ArrayList)object2).remove(0);
            object2 = (c)object2;
            n11 = ((AtomicInteger)object).getAndDecrement();
            int n12 = 1;
            if (n11 <= n12) break block13;
            condition = this.OooO0Oo;
            condition.signal();
        }
        return object2;
        finally {
            reentrantLock.unlock();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void OooO00o(String string2) {
        if (string2 == null) return;
        Object object = "";
        boolean bl2 = string2.equals(object);
        if (bl2) {
            return;
        }
        object = this.OooO0OO;
        ((ReentrantLock)object).lock();
        int n10 = 0;
        try {
            while (true) {
                Object object2;
                int n11;
                if (n10 >= (n11 = ((AtomicInteger)(object2 = this.OooO0O0)).get())) {
                    ((ReentrantLock)object).unlock();
                    return;
                }
                object2 = this.OooO00o;
                object2 = ((ArrayList)object2).get(n10);
                object2 = (c)object2;
                object2 = ((c)object2).a;
                n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
                if (n11 != 0) {
                    object2 = this.OooO00o;
                    ((ArrayList)object2).remove(n10);
                    object2 = this.OooO0O0;
                    ((AtomicInteger)object2).getAndDecrement();
                    continue;
                }
                ++n10;
            }
        }
        catch (Throwable throwable) {
            ((ReentrantLock)object).unlock();
            throw throwable;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean OooO00o(c object) {
        if (object == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.OooO0OO;
        AtomicInteger atomicInteger = this.OooO0O0;
        reentrantLock.lock();
        try {
            ArrayList arrayList;
            int n10;
            while (true) {
                int n11 = atomicInteger.get();
                int n12 = 0x7FFFFFFE;
                n10 = 1;
                if (n11 < n12) break;
                arrayList = this.OooO00o;
                n12 = atomicInteger.get() - n10;
                arrayList.remove(n12);
                atomicInteger.getAndDecrement();
            }
            arrayList = this.OooO00o;
            arrayList.add(object);
            object = this.OooO00o;
            Collections.sort(object);
            atomicInteger.getAndIncrement();
            object = this.OooO0Oo;
            object.signal();
            return n10 != 0;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    public boolean OooO00o(c c10, long l10, TimeUnit timeUnit) {
        return this.OooO00o(c10);
    }

    public c OooO0O0() {
        ReentrantLock reentrantLock;
        Object object;
        block10: {
            Object object2 = this.OooO0O0;
            int n10 = ((AtomicInteger)object2).get();
            object = null;
            if (n10 == 0) {
                return null;
            }
            reentrantLock = this.OooO0OO;
            reentrantLock.lock();
            int n11 = ((AtomicInteger)object2).get();
            if (n11 <= 0) break block10;
            object = this.OooO00o;
            n11 = 0;
            object = ((ArrayList)object).remove(0);
            object = (c)object;
            int n12 = ((AtomicInteger)object2).getAndDecrement();
            n11 = 1;
            if (n12 <= n11) break block10;
            object2 = this.OooO0Oo;
            object2.signal();
        }
        return object;
        finally {
            reentrantLock.unlock();
        }
    }

    public void OooO0O0(c c10) {
        this.OooO00o(c10);
    }

    public c OooO0OO() {
        AtomicInteger atomicInteger = this.OooO0O0;
        ReentrantLock reentrantLock = this.OooO0OO;
        reentrantLock.lockInterruptibly();
        try {
            Object object;
            int n10;
            while ((n10 = atomicInteger.get()) == 0) {
                object = this.OooO0Oo;
                object.await();
            }
            object = this.OooO00o;
            object = ((ArrayList)object).remove(0);
            object = (c)object;
            atomicInteger.getAndDecrement();
            return object;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    public void clear() {
        ReentrantLock reentrantLock = this.OooO0OO;
        reentrantLock.lock();
        try {
            Serializable serializable = this.OooO00o;
            ((ArrayList)serializable).clear();
            serializable = this.OooO0O0;
            ((AtomicInteger)serializable).getAndSet(0);
            return;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    public boolean contains(Object object) {
        if (object == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.OooO0OO;
        reentrantLock.lock();
        try {
            ArrayList arrayList = this.OooO00o;
            boolean bl2 = arrayList.contains(object);
            return bl2;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    public int drainTo(Collection collection) {
        return this.drainTo(collection, -1 >>> 1);
    }

    public int drainTo(Collection object, int n10) {
        Objects.requireNonNull(object);
        if (object != this) {
            if (n10 <= 0) {
                return 0;
            }
            ReentrantLock reentrantLock = this.OooO0OO;
            reentrantLock.lock();
            AtomicInteger atomicInteger = this.OooO0O0;
            int n11 = atomicInteger.get();
            try {
                n10 = Math.min(n10, n11);
                atomicInteger = null;
            }
            catch (Throwable throwable) {
                reentrantLock.unlock();
                throw throwable;
            }
            for (n11 = 0; n11 < n10; ++n11) {
                Object object2 = this.OooO00o;
                object2 = ((ArrayList)object2).remove(0);
                object2 = (c)object2;
                object.add(object2);
                continue;
            }
            reentrantLock.unlock();
            return n10;
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public Iterator iterator() {
        Object[] objectArray = this.toArray();
        OooO0o$a oooO0o$a = new OooO0o$a(this, objectArray);
        return oooO0o$a;
    }

    public int remainingCapacity() {
        int n10 = this.OooO0O0.get();
        return 0x7FFFFFFE - n10;
    }

    public boolean remove(Object object) {
        if (object == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.OooO0OO;
        reentrantLock.lock();
        try {
            ArrayList arrayList = this.OooO00o;
            arrayList.remove(object);
            object = this.OooO0O0;
            ((AtomicInteger)object).getAndDecrement();
            return true;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    public int size() {
        return this.OooO0O0.get();
    }

    public Object[] toArray() {
        ReentrantLock reentrantLock = this.OooO0OO;
        reentrantLock.lock();
        Object[] objectArray = this.OooO0O0;
        int n10 = objectArray.get();
        objectArray = new Object[n10];
        int n11 = 0;
        Object object = this.OooO00o;
        try {
            object = ((ArrayList)object).iterator();
        }
        catch (Throwable throwable) {
            reentrantLock.unlock();
            throw throwable;
        }
        while (true) {
            boolean bl2 = object.hasNext();
            if (!bl2) break;
            Object object2 = object.next();
            object2 = (c)object2;
            int n12 = n11 + 1;
            objectArray[n11] = object2;
            n11 = n12;
            continue;
            break;
        }
        reentrantLock.unlock();
        return objectArray;
    }

    public Object[] toArray(Object[] object) {
        ReentrantLock reentrantLock;
        block19: {
            int n10;
            int n11;
            AtomicInteger atomicInteger;
            block18: {
                reentrantLock = this.OooO0OO;
                reentrantLock.lock();
                atomicInteger = this.OooO0O0;
                n11 = atomicInteger.get();
                n10 = ((Object[])object).length;
                if (n10 >= n11) break block18;
                object = object.getClass();
                object = ((Class)object).getComponentType();
                object = Array.newInstance(object, n11);
                object = (Object[])object;
            }
            n11 = 0;
            atomicInteger = null;
            Object object2 = this.OooO00o;
            object2 = ((ArrayList)object2).iterator();
            while (true) {
                boolean bl2 = object2.hasNext();
                if (!bl2) break;
                Object object3 = object2.next();
                object3 = (c)object3;
                int n12 = n11 + 1;
                object[n11] = object3;
                n11 = n12;
                continue;
                break;
            }
            n10 = ((Object)object).length;
            if (n10 <= n11) break block19;
            n10 = 0;
            object2 = null;
            object[n11] = null;
        }
        return object;
        finally {
            reentrantLock.unlock();
        }
    }
}

