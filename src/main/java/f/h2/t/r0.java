/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class r0 {
    private final ArrayList a;

    public r0(int n10) {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList(n10);
    }

    public void a(Object object) {
        this.a.add(object);
    }

    public void b(Object object) {
        block9: {
            block6: {
                int n10;
                block8: {
                    block7: {
                        block5: {
                            if (object == null) {
                                return;
                            }
                            n10 = object instanceof Object[];
                            if (n10 == 0) break block5;
                            n10 = ((Object[])(object = (Object[])object)).length;
                            if (n10 > 0) {
                                ArrayList arrayList = this.a;
                                int n11 = arrayList.size();
                                int n12 = ((Object[])object).length;
                                arrayList.ensureCapacity(n11 += n12);
                                arrayList = this.a;
                                Collections.addAll(arrayList, object);
                            }
                            break block6;
                        }
                        n10 = object instanceof Collection;
                        if (n10 == 0) break block7;
                        ArrayList arrayList = this.a;
                        object = (Collection)object;
                        arrayList.addAll(object);
                        break block6;
                    }
                    n10 = object instanceof Iterable;
                    if (n10 == 0) break block8;
                    object = ((Iterable)object).iterator();
                    while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                        Object e10 = object.next();
                        ArrayList arrayList = this.a;
                        arrayList.add(e10);
                    }
                    break block6;
                }
                n10 = object instanceof Iterator;
                if (n10 != 0) {
                    object = (Iterator)object;
                    while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                        ArrayList arrayList = this.a;
                        Object e11 = object.next();
                        arrayList.add(e11);
                    }
                }
                break block9;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Don't know how to spread ");
        object = object.getClass();
        stringBuilder.append(object);
        object = stringBuilder.toString();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)object);
        throw unsupportedOperationException;
    }

    public int c() {
        return this.a.size();
    }

    public Object[] d(Object[] objectArray) {
        return this.a.toArray(objectArray);
    }
}

