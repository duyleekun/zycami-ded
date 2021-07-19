/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.s.l;
import f.h2.s.p;
import f.h2.t.f0;
import f.l2.q;
import f.x1.c;
import f.x1.c$a;
import f.x1.e;
import f.x1.j$a;
import f.x1.n;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;

public final class j
extends e {
    private static final Object[] d;
    private static final int e = 0x7FFFFFF7;
    private static final int f = 10;
    public static final j$a g;
    private int a;
    private Object[] b;
    private int c;

    static {
        j$a j$a;
        g = j$a = new j$a(null);
        d = new Object[0];
    }

    public j() {
        Object[] objectArray = d;
        this.b = objectArray;
    }

    public j(int n10) {
        block4: {
            Object[] objectArray;
            block3: {
                block2: {
                    if (n10 != 0) break block2;
                    objectArray = d;
                    break block3;
                }
                if (n10 <= 0) break block4;
                objectArray = new Object[n10];
            }
            this.b = objectArray;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Illegal Capacity: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public j(Collection objectArray) {
        int n10;
        f0.p(objectArray, "elements");
        boolean bl2 = false;
        Object object = new Object[]{};
        objectArray = objectArray.toArray((T[])object);
        object = "null cannot be cast to non-null type kotlin.Array<T>";
        Objects.requireNonNull(objectArray, (String)object);
        this.b = objectArray;
        this.c = n10 = objectArray.length;
        int n11 = objectArray.length;
        if (n11 == 0) {
            bl2 = true;
        }
        if (bl2) {
            objectArray = d;
            this.b = objectArray;
        }
    }

    public static final /* synthetic */ int g(j j10) {
        return j10.size();
    }

    public static final /* synthetic */ void k(j j10, Object[] objectArray) {
        j10.b = objectArray;
    }

    public static final /* synthetic */ void l(j j10, int n10) {
        j10.a = n10;
    }

    private final void n(int n10, Collection collection) {
        Object e10;
        Object[] objectArray;
        boolean bl2;
        Iterator iterator2 = collection.iterator();
        Object[] objectArray2 = this.b;
        int n11 = objectArray2.length;
        while (n10 < n11 && (bl2 = iterator2.hasNext())) {
            objectArray = this.b;
            e10 = iterator2.next();
            objectArray[n10] = e10;
            ++n10;
        }
        n11 = this.a;
        for (n10 = 0; n10 < n11 && (bl2 = iterator2.hasNext()); ++n10) {
            objectArray = this.b;
            e10 = iterator2.next();
            objectArray[n10] = e10;
        }
        n10 = this.size();
        int n12 = collection.size();
        this.c = n10 += n12;
    }

    private final void o(int n10) {
        Object[] objectArray = new Object[n10];
        Object[] objectArray2 = this.b;
        int n11 = this.a;
        int n12 = objectArray2.length;
        n.c1(objectArray2, objectArray, 0, n11, n12);
        objectArray2 = this.b;
        n11 = objectArray2.length;
        n12 = this.a;
        n.c1(objectArray2, objectArray, n11 -= n12, 0, n12);
        this.a = 0;
        this.b = objectArray;
    }

    private final int p(int n10) {
        if (n10 == 0) {
            Object[] objectArray = this.b;
            n10 = ArraysKt___ArraysKt.Rd(objectArray);
        } else {
            n10 += -1;
        }
        return n10;
    }

    private final void q(int n10) {
        if (n10 >= 0) {
            Object[] objectArray = this.b;
            int n11 = objectArray.length;
            if (n10 <= n11) {
                return;
            }
            Object object = d;
            if (objectArray == object) {
                Object[] objectArray2 = new Object[q.n(n10, 10)];
                this.b = objectArray2;
                return;
            }
            object = g;
            int n12 = objectArray.length;
            n10 = ((j$a)object).a(n12, n10);
            this.o(n10);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Deque is too big.");
        throw illegalStateException;
    }

    private final boolean r(l objectArray) {
        int n10 = this.isEmpty();
        int n11 = 0;
        if (n10 == 0) {
            Object[] objectArray2 = this.b;
            n10 = objectArray2.length;
            int n12 = 1;
            float f10 = Float.MIN_VALUE;
            if (n10 == 0) {
                n10 = n12;
            } else {
                n10 = 0;
                objectArray2 = null;
            }
            if (n10 == 0) {
                n10 = this.size();
                int n13 = this.a + n10;
                n10 = this.z(n13);
                n13 = this.a;
                int n14 = this.a;
                if (n14 < n10) {
                    for (n14 = this.a; n14 < n10; ++n14) {
                        Object object = this.b[n14];
                        Object[] objectArray3 = (Object[])objectArray.invoke(object);
                        boolean bl2 = objectArray3.booleanValue();
                        if (bl2) {
                            objectArray3 = this.b;
                            int n15 = n13 + 1;
                            objectArray3[n13] = object;
                            n13 = n15;
                            continue;
                        }
                        n11 = n12;
                    }
                    objectArray = this.b;
                    n.n2(objectArray, null, n13, n10);
                } else {
                    Object object = this.b;
                    int n16 = ((Object[])object).length;
                    int n17 = 0;
                    Object var10_12 = null;
                    for (n14 = this.a; n14 < n16; ++n14) {
                        Object object2 = this.b[n14];
                        ((j)this).b[n14] = null;
                        Object[] objectArray4 = (Object[])objectArray.invoke(object2);
                        boolean bl3 = objectArray4.booleanValue();
                        if (bl3) {
                            objectArray4 = this.b;
                            int n18 = n13 + 1;
                            objectArray4[n13] = object2;
                            n13 = n18;
                            continue;
                        }
                        n17 = n12;
                    }
                    n13 = this.z(n13);
                    while (n11 < n10) {
                        Object object3 = this.b[n11];
                        ((j)this).b[n11] = null;
                        object = (Boolean)objectArray.invoke(object3);
                        n16 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                        if (n16 != 0) {
                            object = this.b;
                            object[n13] = object3;
                            n13 = this.t(n13);
                        } else {
                            n17 = n12;
                        }
                        ++n11;
                    }
                    n11 = n17;
                }
                if (n11 != 0) {
                    int n19 = this.a;
                    n13 -= n19;
                    n19 = this.y(n13);
                    this.c = n19;
                }
            }
        }
        return n11 != 0;
    }

    private final int t(int n10) {
        Object[] objectArray = this.b;
        int n11 = ArraysKt___ArraysKt.Rd(objectArray);
        n10 = n10 == n11 ? 0 : ++n10;
        return n10;
    }

    private final Object u(int n10) {
        return this.b[n10];
    }

    private final int v(int n10) {
        int n11 = this.a + n10;
        return this.z(n11);
    }

    private final int y(int n10) {
        if (n10 < 0) {
            Object[] objectArray = this.b;
            int n11 = objectArray.length;
            n10 += n11;
        }
        return n10;
    }

    private final int z(int n10) {
        Object[] objectArray = this.b;
        int n11 = objectArray.length;
        if (n10 >= n11) {
            int n12 = objectArray.length;
            n10 -= n12;
        }
        return n10;
    }

    public final Object A() {
        Object object;
        boolean bl2 = this.isEmpty();
        if (bl2) {
            bl2 = false;
            object = null;
        } else {
            object = this.removeFirst();
        }
        return object;
    }

    public final Object B() {
        Object object;
        boolean bl2 = this.isEmpty();
        if (bl2) {
            bl2 = false;
            object = null;
        } else {
            object = this.removeLast();
        }
        return object;
    }

    public void add(int n10, Object object) {
        c$a c$a = f.x1.c.a;
        int n11 = this.size();
        c$a.c(n10, n11);
        int n12 = this.size();
        if (n10 == n12) {
            this.addLast(object);
            return;
        }
        if (n10 == 0) {
            this.addFirst(object);
            return;
        }
        n12 = this.size();
        n11 = 1;
        this.q(n12 += n11);
        n12 = this.a + n10;
        n12 = this.z(n12);
        int n13 = this.size() + n11 >> n11;
        int n14 = 0;
        Object[] objectArray = null;
        if (n10 < n13) {
            Object[] objectArray2;
            n10 = this.p(n12);
            n12 = this.a;
            n12 = this.p(n12);
            n13 = this.a;
            if (n10 >= n13) {
                Object object2;
                objectArray = this.b;
                objectArray[n12] = object2 = objectArray[n13];
                int n15 = n13 + 1;
                int n16 = n10 + 1;
                n.c1(objectArray, objectArray, n13, n15, n16);
            } else {
                Object object3;
                Object[] objectArray3 = this.b;
                int n17 = n13 + -1;
                int n18 = objectArray3.length;
                n.c1(objectArray3, objectArray3, n17, n13, n18);
                objectArray2 = this.b;
                int n19 = objectArray2.length - n11;
                objectArray2[n19] = object3 = objectArray2[0];
                n19 = n10 + 1;
                n.c1(objectArray2, objectArray2, 0, n11, n19);
            }
            objectArray2 = this.b;
            objectArray2[n10] = object;
            this.a = n12;
        } else {
            Object[] objectArray4;
            n10 = this.size();
            n13 = this.a + n10;
            n10 = this.z(n13);
            if (n12 < n10) {
                Object[] objectArray5 = this.b;
                n14 = n12 + 1;
                n.c1(objectArray5, objectArray5, n14, n12, n10);
            } else {
                Object object4 = this.b;
                n.c1(object4, object4, n11, 0, n10);
                objectArray4 = this.b;
                n13 = objectArray4.length - n11;
                objectArray4[0] = object4 = objectArray4[n13];
                n13 = n12 + 1;
                n14 = objectArray4.length - n11;
                n.c1(objectArray4, objectArray4, n13, n12, n14);
            }
            objectArray4 = this.b;
            objectArray4[n12] = object;
        }
        this.c = n10 = this.size() + n11;
    }

    public boolean add(Object object) {
        this.addLast(object);
        return true;
    }

    public boolean addAll(int n10, Collection collection) {
        f0.p(collection, "elements");
        Object[] objectArray = f.x1.c.a;
        int n11 = this.size();
        objectArray.c(n10, n11);
        int n12 = collection.isEmpty();
        n11 = 0;
        Object[] objectArray2 = null;
        if (n12 != 0) {
            return false;
        }
        n12 = this.size();
        if (n10 == n12) {
            return this.addAll(collection);
        }
        n12 = this.size();
        int n13 = collection.size();
        this.q(n12 += n13);
        n12 = this.size();
        n13 = this.a + n12;
        n12 = this.z(n13);
        n13 = this.a + n10;
        n13 = this.z(n13);
        int n14 = collection.size();
        int n15 = this.size();
        int n16 = 1;
        n15 = n15 + n16 >> n16;
        if (n10 < n15) {
            n10 = this.a;
            n12 = n10 - n14;
            if (n13 >= n10) {
                if (n12 >= 0) {
                    objectArray2 = this.b;
                    n.c1(objectArray2, objectArray2, n12, n10, n13);
                } else {
                    Object[] objectArray3 = this.b;
                    int n17 = objectArray3.length;
                    int n18 = objectArray3.length - (n12 += n17);
                    if (n18 >= (n17 = n13 - n10)) {
                        n.c1(objectArray3, objectArray3, n12, n10, n13);
                    } else {
                        n17 = n10 + n18;
                        n.c1(objectArray3, objectArray3, n12, n10, n17);
                        Object[] objectArray4 = this.b;
                        n15 = this.a + n18;
                        n.c1(objectArray4, objectArray4, 0, n15, n13);
                    }
                }
            } else {
                Object[] objectArray5 = this.b;
                int n19 = objectArray5.length;
                n.c1(objectArray5, objectArray5, n12, n10, n19);
                if (n14 >= n13) {
                    Object[] objectArray6 = this.b;
                    n15 = objectArray6.length - n14;
                    n.c1(objectArray6, objectArray6, n15, 0, n13);
                } else {
                    Object[] objectArray7 = this.b;
                    n15 = objectArray7.length - n14;
                    n.c1(objectArray7, objectArray7, n15, 0, n14);
                    objectArray7 = this.b;
                    n.c1(objectArray7, objectArray7, 0, n14, n13);
                }
            }
            this.a = n12;
            n10 = this.y(n13 -= n14);
            this.n(n10, collection);
        } else {
            n10 = n13 + n14;
            if (n13 < n12) {
                Object[] objectArray8 = this.b;
                int n20 = objectArray8.length;
                if ((n14 += n12) <= n20) {
                    n.c1(objectArray8, objectArray8, n10, n13, n12);
                } else {
                    n20 = objectArray8.length;
                    if (n10 >= n20) {
                        n11 = objectArray8.length;
                        n.c1(objectArray8, objectArray8, n10 -= n11, n13, n12);
                    } else {
                        n20 = objectArray8.length;
                        n14 -= n20;
                        n14 = n12 - n14;
                        n.c1(objectArray8, objectArray8, 0, n14, n12);
                        objectArray = this.b;
                        n.c1(objectArray, objectArray, n10, n13, n14);
                    }
                }
            } else {
                Object[] objectArray9 = this.b;
                n.c1(objectArray9, objectArray9, n14, 0, n12);
                objectArray = this.b;
                n15 = objectArray.length;
                if (n10 >= n15) {
                    n11 = objectArray.length;
                    n10 -= n11;
                    n11 = objectArray.length;
                    n.c1(objectArray, objectArray, n10, n13, n11);
                } else {
                    n15 = objectArray.length - n14;
                    int n21 = objectArray.length;
                    n.c1(objectArray, objectArray, 0, n15, n21);
                    objectArray = this.b;
                    n11 = objectArray.length - n14;
                    n.c1(objectArray, objectArray, n10, n13, n11);
                }
            }
            this.n(n13, collection);
        }
        return n16 != 0;
    }

    public boolean addAll(Collection collection) {
        String string2 = "elements";
        f0.p(collection, string2);
        int n10 = collection.isEmpty();
        if (n10 != 0) {
            return false;
        }
        n10 = this.size();
        int n11 = collection.size();
        this.q(n10 += n11);
        n10 = this.size();
        n11 = this.a + n10;
        n10 = this.z(n11);
        this.n(n10, collection);
        return true;
    }

    public final void addFirst(Object object) {
        int n10;
        int n11 = this.size() + 1;
        this.q(n11);
        n11 = this.a;
        this.a = n11 = this.p(n11);
        this.b[n11] = object;
        this.c = n10 = this.size() + 1;
    }

    public final void addLast(Object object) {
        int n10;
        int n11 = this.size() + 1;
        this.q(n11);
        Object[] objectArray = this.b;
        int n12 = this.size();
        int n13 = this.a + n12;
        n12 = this.z(n13);
        objectArray[n12] = object;
        this.c = n10 = this.size() + 1;
    }

    public int b() {
        return this.c;
    }

    public Object c(int n10) {
        Object[] objectArray = f.x1.c.a;
        int n11 = this.size();
        objectArray.b(n10, n11);
        int n12 = CollectionsKt__CollectionsKt.G(this);
        if (n10 == n12) {
            return this.removeLast();
        }
        if (n10 == 0) {
            return this.removeFirst();
        }
        n12 = this.a + n10;
        n12 = this.z(n12);
        Object object = this.b[n12];
        int n13 = this.size();
        int n14 = 1;
        int n15 = 0;
        if (n10 < (n13 >>= n14)) {
            Object[] objectArray2;
            n10 = this.a;
            if (n12 >= n10) {
                Object[] objectArray3 = this.b;
                n15 = n10 + 1;
                n.c1(objectArray3, objectArray3, n15, n10, n12);
            } else {
                objectArray2 = this.b;
                n.c1(objectArray2, objectArray2, n14, 0, n12);
                objectArray2 = this.b;
                n12 = objectArray2.length - n14;
                objectArray = objectArray2[n12];
                objectArray2[0] = objectArray;
                n12 = this.a;
                n13 = n12 + 1;
                n15 = objectArray2.length - n14;
                n.c1(objectArray2, objectArray2, n13, n12, n15);
            }
            objectArray2 = this.b;
            n12 = this.a;
            objectArray2[n12] = null;
            this.a = n10 = this.t(n12);
        } else {
            n10 = CollectionsKt__CollectionsKt.G(this);
            n13 = this.a + n10;
            n10 = this.z(n13);
            if (n12 <= n10) {
                Object[] objectArray4 = this.b;
                n15 = n12 + 1;
                int n16 = n10 + 1;
                n.c1(objectArray4, objectArray4, n12, n15, n16);
            } else {
                Object object2;
                Object[] objectArray5 = this.b;
                int n17 = n12 + 1;
                int n18 = objectArray5.length;
                n.c1(objectArray5, objectArray5, n12, n17, n18);
                objectArray = this.b;
                n13 = objectArray.length - n14;
                objectArray[n13] = object2 = objectArray[0];
                n13 = n10 + 1;
                n.c1(objectArray, objectArray, 0, n14, n13);
            }
            objectArray = this.b;
            objectArray[n10] = null;
        }
        this.c = n10 = this.size() - n14;
        return object;
    }

    public void clear() {
        int n10 = this.size();
        int n11 = this.a + n10;
        n11 = this.a;
        n10 = this.z(n11);
        if (n11 < n10) {
            Object[] objectArray = this.b;
            n.n2(objectArray, null, n11, n10);
        } else {
            n11 = this.isEmpty() ^ 1;
            if (n11 != 0) {
                Object[] objectArray = this.b;
                int n12 = this.a;
                int n13 = objectArray.length;
                n.n2(objectArray, null, n12, n13);
                objectArray = this.b;
                n.n2(objectArray, null, 0, n10);
            }
        }
        this.a = 0;
        this.c = 0;
    }

    public boolean contains(Object object) {
        int n10;
        int n11 = this.indexOf(object);
        if (n11 != (n10 = -1)) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        return n11 != 0;
    }

    public final Object first() {
        int n10 = this.isEmpty();
        if (n10 == 0) {
            n10 = this.a;
            return this.b[n10];
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("ArrayDeque is empty.");
        throw noSuchElementException;
    }

    public Object get(int n10) {
        c$a c$a = f.x1.c.a;
        int n11 = this.size();
        c$a.b(n10, n11);
        int n12 = this.a + n10;
        n10 = this.z(n12);
        return this.b[n10];
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int indexOf(Object objectArray) {
        int n10;
        int n11 = this.size();
        int n12 = this.a + n11;
        n12 = this.a;
        n11 = this.z(n12);
        if (n12 < n11) {
            while (n12 < n11) {
                Object object = this.b[n12];
                boolean bl2 = f0.g(objectArray, object);
                if (bl2) {
                    n10 = this.a;
                    return n12 - n10;
                }
                ++n12;
            }
            return -1;
        }
        if (n12 < n11) return -1;
        Object[] objectArray2 = this.b;
        int n13 = objectArray2.length;
        while (n12 < n13) {
            Object object = this.b[n12];
            boolean bl3 = f0.g(objectArray, object);
            if (bl3) {
                n10 = this.a;
                return n12 - n10;
            }
            ++n12;
        }
        for (n12 = 0; n12 < n11; ++n12) {
            Object object = this.b[n12];
            n13 = (int)(f0.g(objectArray, object) ? 1 : 0);
            if (n13 == 0) continue;
            objectArray = this.b;
            n10 = objectArray.length;
            n12 += n10;
            n10 = this.a;
            return n12 - n10;
        }
        return -1;
    }

    public boolean isEmpty() {
        int n10 = this.size();
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public final Object last() {
        int n10 = this.isEmpty();
        if (n10 == 0) {
            n10 = CollectionsKt__CollectionsKt.G(this);
            int n11 = this.a + n10;
            n10 = this.z(n11);
            return this.b[n10];
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("ArrayDeque is empty.");
        throw noSuchElementException;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int lastIndexOf(Object objectArray) {
        int n10;
        int n11 = this.size();
        int n12 = this.a + n11;
        n12 = this.a;
        n11 = this.z(n12);
        if (n12 < n11) {
            if ((n11 += -1) < n12) return -1;
            while (true) {
                Object object;
                boolean bl2;
                if (bl2 = f0.g(objectArray, object = this.b[n11])) {
                    n10 = this.a;
                    return n11 - n10;
                }
                if (n11 == n12) return -1;
                n11 += -1;
            }
        }
        if (n12 <= n11) return -1;
        n11 += -1;
        while (n11 >= 0) {
            Object object = this.b[n11];
            n12 = (int)(f0.g(objectArray, object) ? 1 : 0);
            if (n12 != 0) {
                objectArray = this.b;
                n10 = objectArray.length;
                n11 += n10;
                n10 = this.a;
                return n11 - n10;
            }
            n11 += -1;
        }
        Object[] objectArray2 = this.b;
        n11 = ArraysKt___ArraysKt.Rd(objectArray2);
        if (n11 < (n12 = this.a)) return -1;
        while (true) {
            Object object;
            boolean bl3;
            if (bl3 = f0.g(objectArray, object = this.b[n11])) {
                n10 = this.a;
                return n11 - n10;
            }
            if (n11 == n12) return -1;
            n11 += -1;
        }
    }

    public boolean remove(Object object) {
        int n10;
        int n11 = this.indexOf(object);
        if (n11 == (n10 = -1)) {
            return false;
        }
        this.remove(n11);
        return true;
    }

    public boolean removeAll(Collection objectArray) {
        Object[] objectArray2 = "elements";
        f0.p(objectArray, (String)objectArray2);
        int n10 = this.isEmpty();
        int n11 = 0;
        if (n10 == 0) {
            objectArray2 = this.b;
            n10 = objectArray2.length;
            int n12 = 1;
            float f10 = Float.MIN_VALUE;
            if (n10 == 0) {
                n10 = n12;
            } else {
                n10 = 0;
                objectArray2 = null;
            }
            if (n10 == 0) {
                n10 = this.size();
                int n13 = this.a + n10;
                n10 = this.z(n13);
                n13 = this.a;
                int n14 = this.a;
                if (n14 < n10) {
                    for (n14 = this.a; n14 < n10; ++n14) {
                        Object object = this.b[n14];
                        int n15 = objectArray.contains(object) ^ n12;
                        if (n15 != 0) {
                            Object[] objectArray3 = this.b;
                            int n16 = n13 + 1;
                            objectArray3[n13] = object;
                            n13 = n16;
                            continue;
                        }
                        n11 = n12;
                    }
                    objectArray = this.b;
                    n.n2(objectArray, null, n13, n10);
                } else {
                    Object[] objectArray4 = this.b;
                    int n17 = objectArray4.length;
                    int n18 = 0;
                    Object var11_14 = null;
                    for (n14 = this.a; n14 < n17; ++n14) {
                        Object object = this.b[n14];
                        Object[] objectArray5 = this.b;
                        objectArray5[n14] = null;
                        int n19 = objectArray.contains(object) ^ n12;
                        if (n19 != 0) {
                            objectArray5 = this.b;
                            int n20 = n13 + 1;
                            objectArray5[n13] = object;
                            n13 = n20;
                            continue;
                        }
                        n18 = n12;
                    }
                    n13 = this.z(n13);
                    while (n11 < n10) {
                        Object object = this.b[n11];
                        objectArray4 = this.b;
                        objectArray4[n11] = null;
                        n17 = objectArray.contains(object) ^ n12;
                        if (n17 != 0) {
                            objectArray4 = this.b;
                            objectArray4[n13] = object;
                            n13 = this.t(n13);
                        } else {
                            n18 = n12;
                        }
                        ++n11;
                    }
                    n11 = n18;
                }
                if (n11 != 0) {
                    int n21 = this.a;
                    n13 -= n21;
                    n21 = this.y(n13);
                    this.c = n21;
                }
            }
        }
        return n11 != 0;
    }

    public final Object removeFirst() {
        int n10 = this.isEmpty();
        if (n10 == 0) {
            int n11;
            n10 = this.a;
            Object object = this.b[n10];
            Object[] objectArray = this.b;
            int n12 = this.a;
            objectArray[n12] = null;
            this.a = n11 = this.t(n12);
            this.c = n11 = this.size() + -1;
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("ArrayDeque is empty.");
        throw noSuchElementException;
    }

    public final Object removeLast() {
        int n10 = this.isEmpty();
        if (n10 == 0) {
            n10 = CollectionsKt__CollectionsKt.G(this);
            int n11 = this.a + n10;
            n10 = this.z(n11);
            Object object = this.b[n10];
            this.b[n10] = null;
            this.c = n10 = this.size() + -1;
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("ArrayDeque is empty.");
        throw noSuchElementException;
    }

    public boolean retainAll(Collection objectArray) {
        Object[] objectArray2 = "elements";
        f0.p(objectArray, (String)objectArray2);
        int n10 = this.isEmpty();
        int n11 = 0;
        if (n10 == 0) {
            objectArray2 = this.b;
            n10 = objectArray2.length;
            int n12 = 1;
            float f10 = Float.MIN_VALUE;
            if (n10 == 0) {
                n10 = n12;
            } else {
                n10 = 0;
                objectArray2 = null;
            }
            if (n10 == 0) {
                n10 = this.size();
                int n13 = this.a + n10;
                n10 = this.z(n13);
                n13 = this.a;
                int n14 = this.a;
                if (n14 < n10) {
                    for (n14 = this.a; n14 < n10; ++n14) {
                        Object object = this.b[n14];
                        boolean bl2 = objectArray.contains(object);
                        if (bl2) {
                            Object[] objectArray3 = this.b;
                            int n15 = n13 + 1;
                            objectArray3[n13] = object;
                            n13 = n15;
                            continue;
                        }
                        n11 = n12;
                    }
                    objectArray = this.b;
                    n.n2(objectArray, null, n13, n10);
                } else {
                    Object[] objectArray4 = this.b;
                    int n16 = objectArray4.length;
                    int n17 = 0;
                    Object var11_14 = null;
                    for (n14 = this.a; n14 < n16; ++n14) {
                        Object object = this.b[n14];
                        Object[] objectArray5 = this.b;
                        objectArray5[n14] = null;
                        boolean bl3 = objectArray.contains(object);
                        if (bl3) {
                            objectArray5 = this.b;
                            int n18 = n13 + 1;
                            objectArray5[n13] = object;
                            n13 = n18;
                            continue;
                        }
                        n17 = n12;
                    }
                    n13 = this.z(n13);
                    while (n11 < n10) {
                        Object object = this.b[n11];
                        objectArray4 = this.b;
                        objectArray4[n11] = null;
                        n16 = (int)(objectArray.contains(object) ? 1 : 0);
                        if (n16 != 0) {
                            objectArray4 = this.b;
                            objectArray4[n13] = object;
                            n13 = this.t(n13);
                        } else {
                            n17 = n12;
                        }
                        ++n11;
                    }
                    n11 = n17;
                }
                if (n11 != 0) {
                    int n19 = this.a;
                    n13 -= n19;
                    n19 = this.y(n13);
                    this.c = n19;
                }
            }
        }
        return n11 != 0;
    }

    public final Object s() {
        Object object;
        int n10 = this.isEmpty();
        if (n10 != 0) {
            n10 = 0;
            object = null;
        } else {
            n10 = this.a;
            Object[] objectArray = this.b;
            object = objectArray[n10];
        }
        return object;
    }

    public Object set(int n10, Object object) {
        Object object2 = f.x1.c.a;
        int n11 = this.size();
        ((c$a)object2).b(n10, n11);
        int n12 = this.a + n10;
        n10 = this.z(n12);
        object2 = this.b[n10];
        this.b[n10] = object;
        return object2;
    }

    public final void w(p p10) {
        Object[] objectArray = "structure";
        f0.p(p10, (String)objectArray);
        int n10 = this.size();
        int n11 = this.a + n10;
        int n12 = this.z(n11);
        n10 = (int)(this.isEmpty() ? 1 : 0);
        n11 = 0;
        Object object = null;
        if (n10 != 0) {
            objectArray = this.a;
            object = new Object[]{};
            p10.invoke(objectArray, object);
            return;
        }
        n10 = this.size();
        objectArray = new Object[n10];
        int n13 = this.a;
        if (n13 < n12) {
            Object[] objectArray2 = this.b;
            boolean bl2 = false;
            int n14 = 2;
            n.l1(objectArray2, objectArray, 0, n13, n12, n14, null);
            n11 = this.a;
            object = n11;
            p10.invoke(object, objectArray);
        } else {
            Object[] objectArray3 = this.b;
            int n15 = 10;
            n.l1(objectArray3, objectArray, 0, n13, 0, n15, null);
            Object[] objectArray4 = this.b;
            int n16 = objectArray4.length;
            int n17 = this.a;
            n.c1(objectArray4, objectArray, n16 -= n17, 0, n12);
            n11 = this.a;
            objectArray4 = this.b;
            int n18 = objectArray4.length;
            object = n11 -= n18;
            p10.invoke(object, objectArray);
        }
    }

    public final Object x() {
        Object object;
        int n10 = this.isEmpty();
        if (n10 != 0) {
            n10 = 0;
            object = null;
        } else {
            n10 = CollectionsKt__CollectionsKt.G(this);
            int n11 = this.a + n10;
            n10 = this.z(n11);
            Object[] objectArray = this.b;
            object = objectArray[n10];
        }
        return object;
    }
}

