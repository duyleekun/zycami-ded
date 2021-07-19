/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 */
package d.v.j.g;

import android.util.SparseIntArray;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import d.v.j.g.k;
import d.v.j.g.l;
import d.v.j.g.m;
import d.v.j.g.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import m.a.a;

public class y {
    public static List a(List list, List object) {
        boolean bl2;
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            boolean bl3 = y.f(list, e10);
            if (bl3) continue;
            arrayList.add(e10);
        }
        return arrayList;
    }

    public static List b(List object) {
        if (object != null) {
            boolean bl2;
            ArrayList<Long> arrayList = new ArrayList<Long>();
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                long l10 = ((d.v.j.e.e.a)object.next()).getId();
                Long l11 = l10;
                arrayList.add(l11);
            }
            return arrayList;
        }
        return null;
    }

    public static List c(List ... listArray) {
        ArrayList arrayList = new ArrayList();
        List list = null;
        if (listArray != null) {
            for (List list2 : listArray) {
                if (list2 == null) continue;
                list = list != null ? y.d(list, list2) : list2;
            }
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    private static List d(List object, List list) {
        boolean bl2;
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            boolean bl3 = y.f(list, e10);
            if (!bl3) continue;
            arrayList.add(e10);
        }
        return arrayList;
    }

    public static List e(List ... listArray) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        if (listArray != null) {
            for (List list : listArray) {
                boolean bl2;
                if (list == null) continue;
                Iterator iterator2 = list.iterator();
                while (bl2 = iterator2.hasNext()) {
                    Object e10 = iterator2.next();
                    boolean bl3 = hashSet.add(e10);
                    if (!bl3) continue;
                    arrayList.add(e10);
                }
            }
        }
        return arrayList;
    }

    private static boolean f(List object, Object object2) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            bl2 = Objects.equals(object2, e10);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static /* synthetic */ int g(SparseIntArray sparseIntArray, Function function, Object object, Object object2) {
        int n10 = (Integer)function.apply(object);
        n10 = sparseIntArray.get(n10);
        int n11 = (Integer)function.apply(object2);
        int n12 = sparseIntArray.get(n11);
        return n10 - n12;
    }

    public static /* synthetic */ int h(Function function, Object object, Object object2) {
        int n10 = (Integer)function.apply(object);
        int n11 = (Integer)function.apply(object2);
        return n10 - n11;
    }

    public static /* synthetic */ List i(List objectArray, Function function, List list) {
        int n10;
        int n11 = 1;
        SparseIntArray sparseIntArray = new Object[n11];
        sparseIntArray[0] = list;
        a.b("sortData, \u6392\u5e8f\u4e4b\u524d\u7684\u6570\u636e: %s", (Object[])sparseIntArray);
        sparseIntArray = new SparseIntArray();
        objectArray = objectArray.iterator();
        int n12 = 0;
        while ((n10 = objectArray.hasNext()) != 0) {
            Long l10 = (Long)objectArray.next();
            n10 = l10.intValue();
            int n13 = n12 + 1;
            sparseIntArray.append(n10, n12);
            n12 = n13;
        }
        objectArray = new k(sparseIntArray, function);
        Collections.sort(list, objectArray);
        objectArray = new Object[n11];
        objectArray[0] = list;
        a.b("sortData, \u6392\u5e8f\u4e4b\u540e\u7684\u6570\u636e: %s", objectArray);
        return list;
    }

    public static /* synthetic */ List j(Function objectArray, List list) {
        int n10 = 1;
        Object object = new Object[n10];
        object[0] = list;
        String string2 = "sortData, \u6392\u5e8f\u4e4b\u524d\u7684\u6570\u636e: %s";
        a.b(string2, object);
        object = new m((Function)objectArray);
        Collections.sort(list, object);
        objectArray = new Object[n10];
        objectArray[0] = list;
        a.b(string2, objectArray);
        return list;
    }

    public static LiveData k(LiveData liveData, Function function) {
        l l10 = new l(function);
        return Transformations.map(liveData, l10);
    }

    public static LiveData l(List list, LiveData liveData, Function function) {
        n n10 = new n(list, function);
        return Transformations.map(liveData, n10);
    }
}

