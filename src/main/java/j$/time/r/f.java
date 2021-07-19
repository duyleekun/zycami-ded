/*
 * Decompiled with CFR 0.151.
 */
package j$.time.r;

import j$.time.r.c;
import j$.time.r.d;
import j$.time.r.g;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

final class f
extends g {
    private final Set c;

    f() {
        Set<String> set = new Set<String>();
        for (String string2 : TimeZone.getAvailableIDs()) {
            ((HashSet)set).add(string2);
        }
        this.c = set = Collections.unmodifiableSet(set);
    }

    protected c b(String object, boolean bl2) {
        Object object2 = this.c;
        bl2 = object2.contains(object);
        if (bl2) {
            object = TimeZone.getTimeZone((String)object);
            object2 = new c((TimeZone)object);
            return object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Not a built-in time zone: ");
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object2 = new d((String)object);
        throw object2;
    }

    protected Set c() {
        return this.c;
    }
}

