/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.h;

import com.zhiyun.editortemplate.data.resource.Status;

public class k {
    public final Status a;
    public final String b;
    public final Object c;

    public k(Status status, Object object, String string2) {
        this.a = status;
        this.c = object;
        this.b = string2;
    }

    public static k a(Object object) {
        Status status = Status.CACHE;
        k k10 = new k(status, object, null);
        return k10;
    }

    public static k b(String string2, Object object) {
        Status status = Status.ERROR;
        k k10 = new k(status, object, string2);
        return k10;
    }

    public static k c(Object object) {
        Status status = Status.LOADING;
        k k10 = new k(status, object, null);
        return k10;
    }

    public static k d(Object object) {
        Status status = Status.SUCCESS;
        k k10 = new k(status, object, null);
        return k10;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            object = (k)object;
            object3 = this.a;
            object2 = ((k)object).a;
            if (object3 != object2) {
                return false;
            }
            object3 = this.b;
            if (object3 != null ? !(bl3 = ((String)object3).equals(object2 = ((k)object).b)) : (object3 = ((k)object).b) != null) {
                return false;
            }
            object3 = this.c;
            object = ((k)object).c;
            if (object3 != null) {
                bl2 = object3.equals(object);
            } else if (object != null) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10;
        Status status = this.a;
        int n11 = status.hashCode() * 31;
        Object object = this.b;
        int n12 = 0;
        if (object != null) {
            n10 = ((String)object).hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        n11 = (n11 + n10) * 31;
        object = this.c;
        if (object != null) {
            n12 = object.hashCode();
        }
        return n11 + n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Resource{status=");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append(", message='");
        object = this.b;
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append(", data=");
        object = this.c;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

