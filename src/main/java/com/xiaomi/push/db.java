/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.cu;
import com.xiaomi.push.cv;
import com.xiaomi.push.cz;
import java.util.ArrayList;
import java.util.Collection;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class db
extends cv {
    public cv a;
    public final /* synthetic */ cz a;
    public final /* synthetic */ cv b;

    public db(cz object, String string2, cv cv2) {
        this.a = object;
        this.b = cv2;
        super(string2);
        this.a = cv2;
        ((cv)this).b = object = ((cv)this).b;
        if (cv2 != null) {
            this.f = object = cv2.f;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ArrayList a(boolean bl2) {
        synchronized (this) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            Object object = this.a;
            boolean bl3 = true;
            if (object != null) {
                object = ((cv)object).a(bl3);
                arrayList.addAll((Collection<Object>)object);
            }
            object = cz.b;
            synchronized (object) {
                Object object2 = cz.b;
                String string2 = ((cv)this).b;
                object2 = object2.get(string2);
                object2 = (cv)object2;
                if (object2 != null) {
                    boolean bl4;
                    Object object3 = ((cv)object2).a(bl3);
                    object3 = ((ArrayList)object3).iterator();
                    while (bl4 = object3.hasNext()) {
                        int n10;
                        object2 = object3.next();
                        int n11 = arrayList.indexOf(object2 = (String)object2);
                        if (n11 != (n10 = -1)) continue;
                        arrayList.add(object2);
                    }
                    object3 = ((cv)this).b;
                    arrayList.remove(object3);
                    object3 = ((cv)this).b;
                    arrayList.add(object3);
                }
                return arrayList;
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String string2, cu cu2) {
        synchronized (this) {
            cv cv2 = this.a;
            if (cv2 != null) {
                void var2_2;
                cv2.a(string2, (cu)var2_2);
            }
            return;
        }
    }

    public boolean b() {
        return false;
    }
}

