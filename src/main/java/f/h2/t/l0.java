/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;
import f.h2.t.r;
import java.util.Collection;
import kotlin.jvm.KotlinReflectionNotSupportedError;

public final class l0
implements r {
    private final Class a;
    private final String b;

    public l0(Class clazz, String string2) {
        f0.p(clazz, "jClass");
        f0.p(string2, "moduleName");
        this.a = clazz;
        this.b = string2;
    }

    public Collection a() {
        KotlinReflectionNotSupportedError kotlinReflectionNotSupportedError = new KotlinReflectionNotSupportedError();
        throw kotlinReflectionNotSupportedError;
    }

    public boolean equals(Object object) {
        Class clazz;
        boolean bl2;
        boolean bl3 = object instanceof l0;
        if (bl3 && (bl2 = f0.g(clazz = this.o(), object = ((l0)object).o()))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public int hashCode() {
        return this.o().hashCode();
    }

    public Class o() {
        return this.a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.o().toString();
        stringBuilder.append(string2);
        stringBuilder.append(" (Kotlin reflection is not available)");
        return stringBuilder.toString();
    }
}

