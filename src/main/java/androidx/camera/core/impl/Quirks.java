/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Quirk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Quirks {
    private final List mQuirks;

    public Quirks(List list) {
        ArrayList arrayList;
        this.mQuirks = arrayList = new ArrayList(list);
    }

    public boolean contains(Class clazz) {
        boolean bl2;
        Iterator iterator2 = this.mQuirks.iterator();
        while (bl2 = iterator2.hasNext()) {
            Class<?> clazz2 = ((Quirk)iterator2.next()).getClass();
            bl2 = clazz.isAssignableFrom(clazz2);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public Quirk get(Class clazz) {
        boolean bl2;
        Iterator iterator2 = this.mQuirks.iterator();
        while (bl2 = iterator2.hasNext()) {
            Quirk quirk = (Quirk)iterator2.next();
            Class<?> clazz2 = quirk.getClass();
            if (clazz2 != clazz) continue;
            return quirk;
        }
        return null;
    }
}

