/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Joiner;
import com.google.common.base.Joiner$1;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public final class Joiner$MapJoiner {
    private final Joiner joiner;
    private final String keyValueSeparator;

    private Joiner$MapJoiner(Joiner object, String string2) {
        this.joiner = object;
        this.keyValueSeparator = object = (String)Preconditions.checkNotNull(string2);
    }

    public /* synthetic */ Joiner$MapJoiner(Joiner joiner, String string2, Joiner.1 var3_3) {
        this(joiner, string2);
    }

    public Appendable appendTo(Appendable appendable, Iterable object) {
        object = object.iterator();
        return this.appendTo(appendable, (Iterator)object);
    }

    public Appendable appendTo(Appendable appendable, Iterator iterator2) {
        Preconditions.checkNotNull(appendable);
        boolean bl2 = iterator2.hasNext();
        if (bl2) {
            Object object = (Map.Entry)iterator2.next();
            Object object2 = this.joiner;
            Object k10 = object.getKey();
            object2 = ((Joiner)object2).toString(k10);
            appendable.append((CharSequence)object2);
            object2 = this.keyValueSeparator;
            appendable.append((CharSequence)object2);
            object2 = this.joiner;
            object = object.getValue();
            object = ((Joiner)object2).toString(object);
            appendable.append((CharSequence)object);
            while (bl2 = iterator2.hasNext()) {
                object = Joiner.access$100(this.joiner);
                appendable.append((CharSequence)object);
                object = (Map.Entry)iterator2.next();
                object2 = this.joiner;
                k10 = object.getKey();
                object2 = ((Joiner)object2).toString(k10);
                appendable.append((CharSequence)object2);
                object2 = this.keyValueSeparator;
                appendable.append((CharSequence)object2);
                object2 = this.joiner;
                object = object.getValue();
                object = ((Joiner)object2).toString(object);
                appendable.append((CharSequence)object);
            }
        }
        return appendable;
    }

    public Appendable appendTo(Appendable appendable, Map object) {
        object = object.entrySet();
        return this.appendTo(appendable, (Iterable)object);
    }

    public StringBuilder appendTo(StringBuilder stringBuilder, Iterable object) {
        object = object.iterator();
        return this.appendTo(stringBuilder, (Iterator)object);
    }

    public StringBuilder appendTo(StringBuilder stringBuilder, Iterator object) {
        try {
            this.appendTo((Appendable)stringBuilder, (Iterator)object);
            return stringBuilder;
        }
        catch (IOException iOException) {
            object = new AssertionError((Object)iOException);
            throw object;
        }
    }

    public StringBuilder appendTo(StringBuilder stringBuilder, Map object) {
        object = object.entrySet();
        return this.appendTo(stringBuilder, (Iterable)object);
    }

    public String join(Iterable object) {
        object = object.iterator();
        return this.join((Iterator)object);
    }

    public String join(Iterator iterator2) {
        StringBuilder stringBuilder = new StringBuilder();
        return this.appendTo(stringBuilder, iterator2).toString();
    }

    public String join(Map object) {
        object = object.entrySet();
        return this.join((Iterable)object);
    }

    public Joiner$MapJoiner useForNull(String object) {
        object = this.joiner.useForNull((String)object);
        String string2 = this.keyValueSeparator;
        Joiner$MapJoiner joiner$MapJoiner = new Joiner$MapJoiner((Joiner)object, string2);
        return joiner$MapJoiner;
    }
}

