/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.hu;
import com.xiaomi.push.ix;
import com.xiaomi.push.iy;
import com.xiaomi.push.jf;
import com.xiaomi.push.jg;
import com.xiaomi.push.ji;
import com.xiaomi.push.jj;
import com.xiaomi.push.jl;
import com.xiaomi.push.jn;
import java.io.Serializable;
import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class if
implements ix,
Serializable,
Cloneable {
    private static final jf a;
    private static final jn a;
    public List a;

    static {
        Object object = new jn("XmPushActionCollectData");
        a = object;
        a = object = new jf("", 15, 1);
    }

    public int a(if object) {
        int n10;
        boolean bl2;
        Constable constable;
        Constable constable2 = this.getClass();
        int n11 = constable2.equals(constable = object.getClass());
        if (n11 == 0) {
            constable2 = this.getClass().getName();
            object = object.getClass().getName();
            return ((String)((Object)constable2)).compareTo((String)object);
        }
        constable2 = this.a();
        n11 = ((Boolean)constable2).compareTo((Boolean)(constable = Boolean.valueOf(bl2 = ((if)object).a())));
        if (n11 != 0) {
            return n11;
        }
        n11 = (int)(this.a() ? 1 : 0);
        if (n11 != 0 && (n10 = iy.a((List)((Object)(constable2 = this.a)), (List)(object = ((if)object).a))) != 0) {
            return n10;
        }
        return 0;
    }

    public if a(List list) {
        this.a = list;
        return this;
    }

    public void a() {
        Object object = this.a;
        if (object != null) {
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Required field 'dataCollectionItems' was not present! Struct: ");
        String string2 = this.toString();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        object = new jj((String)charSequence);
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(ji ji2) {
        ji2.a();
        while (true) {
            Object object = ji2.a();
            int n10 = ((jf)object).a;
            if (n10 == 0) {
                ji2.f();
                this.a();
                return;
            }
            int n11 = ((jf)object).a;
            int n12 = 1;
            if (n11 != n12 || n10 != (n11 = 15)) {
                jl.a(ji2, (byte)n10);
            } else {
                ArrayList arrayList;
                object = ji2.a();
                n12 = ((jg)object).a;
                this.a = arrayList = new ArrayList(n12);
                arrayList = null;
                for (n10 = 0; n10 < (n12 = ((jg)object).a); ++n10) {
                    hu hu2 = new hu();
                    hu2.a(ji2);
                    List list = this.a;
                    list.add(hu2);
                }
                ji2.i();
            }
            ji2.g();
        }
    }

    public boolean a() {
        boolean bl2;
        List list = this.a;
        if (list != null) {
            bl2 = true;
        } else {
            bl2 = false;
            list = null;
        }
        return bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean a(if object) {
        if (object == null) {
            return false;
        }
        boolean bl2 = this.a();
        boolean bl3 = ((if)object).a();
        if (!bl2 && !bl3) return true;
        if (!bl2 || !bl3) return false;
        List list = this.a;
        object = ((if)object).a;
        boolean bl4 = list.equals(object);
        if (bl4) return true;
        return false;
    }

    public void b(ji ji2) {
        this.a();
        Iterator iterator2 = a;
        ji2.a((jn)((Object)iterator2));
        iterator2 = this.a;
        if (iterator2 != null) {
            iterator2 = a;
            ji2.a((jf)((Object)iterator2));
            byte by2 = 12;
            List list = this.a;
            int n10 = list.size();
            iterator2 = new Iterator(by2, n10);
            ji2.a((jg)((Object)iterator2));
            iterator2 = this.a.iterator();
            while ((by2 = (byte)(iterator2.hasNext() ? 1 : 0)) != 0) {
                hu hu2 = (hu)iterator2.next();
                hu2.b(ji2);
            }
            ji2.e();
            ji2.b();
        }
        ji2.c();
        ji2.a();
    }

    public /* synthetic */ int compareTo(Object object) {
        object = (if)object;
        return this.a((if)object);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl2 = object instanceof if;
        if (bl2) {
            object = (if)object;
            return this.a((if)object);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("XmPushActionCollectData(");
        stringBuilder.append("dataCollectionItems:");
        Object object = this.a;
        if (object == null) {
            object = "null";
            stringBuilder.append((String)object);
        } else {
            stringBuilder.append(object);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

