/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.r1;

import androidx.databinding.BaseObservable;
import java.util.Objects;

public class d
extends BaseObservable {
    private String a;
    private long b;

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object2 = this.getClass()) == (clazz = object.getClass())) {
            boolean bl3;
            object = (d)object;
            long l10 = this.b;
            long l11 = ((d)object).b;
            long l12 = l10 - l11;
            Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 != false || !(bl3 = Objects.equals(object2 = this.a, object = ((d)object).a))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        Object object = this.a;
        object = this.b;
        Object[] objectArray = new Object[]{object, object};
        return Objects.hash(objectArray);
    }

    public long s() {
        return this.b;
    }

    public String t() {
        return this.a;
    }

    public d u(long l10) {
        this.b = l10;
        return this;
    }

    public d v(String string2) {
        this.a = string2;
        return this;
    }
}

