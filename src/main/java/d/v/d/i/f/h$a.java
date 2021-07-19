/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 */
package d.v.d.i.f;

import android.graphics.Rect;
import java.util.Objects;

public class h$a {
    private final int a;
    private final Rect b;

    public h$a(int n10, Rect rect) {
        this.a = n10;
        this.b = rect;
    }

    public int a() {
        return this.a;
    }

    public Rect b() {
        return this.b;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Rect rect;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (rect = this.getClass()) == (clazz = object.getClass())) {
            boolean bl3;
            object = (h$a)object;
            int n10 = this.a;
            int n11 = ((h$a)object).a;
            if (n10 != n11 || !(bl3 = (rect = this.b).equals(object = ((h$a)object).b))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        Object[] objectArray = new Object[2];
        Integer n10 = this.a;
        objectArray[0] = n10;
        n10 = this.b;
        objectArray[1] = n10;
        return Objects.hash(objectArray);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Face{id=");
        int n10 = this.a;
        stringBuilder.append(n10);
        stringBuilder.append(", rect=");
        Rect rect = this.b;
        stringBuilder.append(rect);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

