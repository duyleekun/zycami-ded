/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.content.pm;

import java.util.ArrayList;
import java.util.List;

public abstract class ShortcutInfoCompatSaver {
    public abstract Object addShortcuts(List var1);

    public List getShortcuts() {
        ArrayList arrayList = new ArrayList();
        return arrayList;
    }

    public abstract Object removeAllShortcuts();

    public abstract Object removeShortcuts(List var1);
}

