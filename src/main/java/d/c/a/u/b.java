/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.u;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

public final class b
extends ArrayMap {
    private int a;

    public void clear() {
        this.a = 0;
        super.clear();
    }

    public int hashCode() {
        int n10 = this.a;
        if (n10 == 0) {
            this.a = n10 = super.hashCode();
        }
        return this.a;
    }

    public Object put(Object object, Object object2) {
        this.a = 0;
        return super.put(object, object2);
    }

    public void putAll(SimpleArrayMap simpleArrayMap) {
        this.a = 0;
        super.putAll(simpleArrayMap);
    }

    public Object removeAt(int n10) {
        this.a = 0;
        return super.removeAt(n10);
    }

    public Object setValueAt(int n10, Object object) {
        this.a = 0;
        return super.setValueAt(n10, object);
    }
}

