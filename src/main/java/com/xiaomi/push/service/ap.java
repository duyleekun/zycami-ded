/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.ap$a;
import com.xiaomi.push.service.ap$b;
import com.xiaomi.push.service.ap$c;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ap {
    private static ap a;
    private List a;
    private ConcurrentHashMap a;

    private ap() {
        Serializable serializable;
        this.a = serializable = new Serializable();
        this.a = serializable;
    }

    public static ap a() {
        Class<ap> clazz = ap.class;
        synchronized (clazz) {
            ap ap2 = a;
            if (ap2 == null) {
                a = ap2 = new ap();
            }
            ap2 = a;
            return ap2;
        }
    }

    private String a(String string2) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 != 0) {
            return null;
        }
        String string3 = "@";
        n10 = string2.indexOf(string3);
        if (n10 > 0) {
            string2 = string2.substring(0, n10);
        }
        return string2;
    }

    public int a() {
        synchronized (this) {
            ConcurrentHashMap concurrentHashMap = this.a;
            int n10 = concurrentHashMap.size();
            return n10;
        }
    }

    public ap$b a(String object, String string2) {
        synchronized (this) {
            block9: {
                ConcurrentHashMap concurrentHashMap = this.a;
                object = concurrentHashMap.get(object);
                object = (HashMap)object;
                if (object != null) break block9;
                return null;
            }
            string2 = this.a(string2);
            object = ((HashMap)object).get(string2);
            object = (ap$b)object;
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ArrayList a() {
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            Iterator iterator2 = this.a;
            iterator2 = ((ConcurrentHashMap)((Object)iterator2)).values();
            iterator2 = iterator2.iterator();
            boolean bl2;
            while (bl2 = iterator2.hasNext()) {
                Object object = iterator2.next();
                object = (HashMap)object;
                object = ((HashMap)object).values();
                arrayList.addAll(object);
            }
            return arrayList;
        }
    }

    public Collection a(String collection) {
        synchronized (this) {
            ConcurrentHashMap concurrentHashMap = this.a;
            boolean bl2 = concurrentHashMap.containsKey(collection);
            if (!bl2) {
                collection = new Collection();
                return collection;
            }
            concurrentHashMap = this.a;
            collection = concurrentHashMap.get(collection);
            collection = (HashMap)((Object)collection);
            collection = ((HashMap)((Object)collection)).clone();
            collection = (HashMap)((Object)collection);
            collection = ((HashMap)((Object)collection)).values();
            return collection;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List a(String string2) {
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            Iterator iterator2 = this.a;
            iterator2 = ((ConcurrentHashMap)((Object)iterator2)).values();
            iterator2 = iterator2.iterator();
            boolean bl2;
            block2: while (bl2 = iterator2.hasNext()) {
                Object object = iterator2.next();
                object = (HashMap)object;
                object = ((HashMap)object).values();
                object = object.iterator();
                while (true) {
                    boolean bl3;
                    if (!(bl3 = object.hasNext())) continue block2;
                    Object object2 = object.next();
                    object2 = (ap$b)object2;
                    String string3 = ((ap$b)object2).a;
                    boolean bl4 = string2.equals(string3);
                    if (!bl4) continue;
                    object2 = ((ap$b)object2).g;
                    arrayList.add(object2);
                }
                break;
            }
            return arrayList;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        synchronized (this) {
            Object object = this.a();
            object = ((ArrayList)object).iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object.hasNext())) {
                    object = this.a;
                    ((ConcurrentHashMap)object).clear();
                    return;
                }
                Object object2 = object.next();
                object2 = (ap$b)object2;
                ((ap$b)object2).a();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Context object) {
        synchronized (this) {
            object = this.a;
            object = ((ConcurrentHashMap)object).values();
            object = object.iterator();
            boolean bl2;
            block2: while (bl2 = object.hasNext()) {
                Object object2 = object.next();
                object2 = (HashMap)object2;
                object2 = ((HashMap)object2).values();
                object2 = object2.iterator();
                while (true) {
                    boolean bl3;
                    if (!(bl3 = object2.hasNext())) continue block2;
                    Object e10 = object2.next();
                    Object object3 = e10;
                    object3 = (ap$b)e10;
                    ap$c ap$c = ap$c.a;
                    int n10 = 1;
                    int n11 = 3;
                    ((ap$b)object3).a(ap$c, n10, n11, null, null);
                }
                break;
            }
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Context object, int n10) {
        synchronized (this) {
            object = this.a;
            object = ((ConcurrentHashMap)object).values();
            object = object.iterator();
            boolean bl2;
            block2: while (bl2 = object.hasNext()) {
                Object object2 = object.next();
                object2 = (HashMap)object2;
                object2 = ((HashMap)object2).values();
                object2 = object2.iterator();
                while (true) {
                    void var2_2;
                    boolean bl3;
                    if (!(bl3 = object2.hasNext())) continue block2;
                    Object e10 = object2.next();
                    Object object3 = e10;
                    object3 = (ap$b)e10;
                    ap$c ap$c = ap$c.a;
                    int n11 = 2;
                    ((ap$b)object3).a(ap$c, n11, (int)var2_2, null, null);
                }
                break;
            }
            return;
        }
    }

    public void a(ap$a ap$a) {
        synchronized (this) {
            List list = this.a;
            list.add(ap$a);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(ap$b iterator2) {
        synchronized (this) {
            Object object = this.a;
            Object object2 = ((ap$b)iterator2).g;
            object = ((ConcurrentHashMap)object).get(object2);
            object = (HashMap)object;
            if (object == null) {
                object = new HashMap();
                object2 = this.a;
                String string2 = ((ap$b)iterator2).g;
                ((ConcurrentHashMap)object2).put(string2, object);
            }
            object2 = ((ap$b)iterator2).b;
            object2 = this.a((String)object2);
            ((HashMap)object).put(object2, iterator2);
            iterator2 = this.a;
            iterator2 = iterator2.iterator();
            boolean bl2;
            while (bl2 = iterator2.hasNext()) {
                object = iterator2.next();
                object = (ap$a)object;
                object.a();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String iterator2) {
        synchronized (this) {
            Object object = this.a;
            object = ((ConcurrentHashMap)object).get(iterator2);
            object = (HashMap)object;
            if (object != null) {
                boolean bl2;
                Object object2 = ((HashMap)object).values();
                object2 = object2.iterator();
                while (bl2 = object2.hasNext()) {
                    Object object3 = object2.next();
                    object3 = (ap$b)object3;
                    ((ap$b)object3).a();
                }
                ((HashMap)object).clear();
                object = this.a;
                ((ConcurrentHashMap)object).remove(iterator2);
            }
            iterator2 = this.a;
            iterator2 = iterator2.iterator();
            boolean bl3;
            while (bl3 = iterator2.hasNext()) {
                object = iterator2.next();
                object = (ap$a)object;
                object.a();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String iterator2, String object) {
        synchronized (this) {
            boolean bl2;
            Object object2;
            AbstractMap abstractMap = this.a;
            abstractMap = ((ConcurrentHashMap)abstractMap).get(iterator2);
            abstractMap = (HashMap)abstractMap;
            if (abstractMap != null) {
                Object object3 = this.a((String)object2);
                object3 = ((HashMap)abstractMap).get(object3);
                if ((object3 = (ap$b)object3) != null) {
                    ((ap$b)object3).a();
                }
                object2 = this.a((String)object2);
                ((HashMap)abstractMap).remove(object2);
                bl2 = ((HashMap)abstractMap).isEmpty();
                if (bl2) {
                    object2 = this.a;
                    ((ConcurrentHashMap)object2).remove(iterator2);
                }
            }
            iterator2 = this.a;
            iterator2 = iterator2.iterator();
            while (bl2 = iterator2.hasNext()) {
                object2 = iterator2.next();
                object2 = (ap$a)object2;
                object2.a();
            }
            return;
        }
    }

    public void b() {
        synchronized (this) {
            List list = this.a;
            list.clear();
            return;
        }
    }
}

