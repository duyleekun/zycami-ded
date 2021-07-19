/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Joiner$1;
import com.google.common.base.Joiner$2;
import com.google.common.base.Joiner$3;
import com.google.common.base.Joiner$MapJoiner;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class Joiner {
    private final String separator;

    private Joiner(Joiner object) {
        this.separator = object = ((Joiner)object).separator;
    }

    public /* synthetic */ Joiner(Joiner joiner, Joiner$1 joiner$1) {
        this(joiner);
    }

    private Joiner(String string2) {
        this.separator = string2 = (String)Preconditions.checkNotNull(string2);
    }

    public static /* synthetic */ String access$100(Joiner joiner) {
        return joiner.separator;
    }

    private static Iterable iterable(Object object, Object object2, Object[] objectArray) {
        Preconditions.checkNotNull(objectArray);
        Joiner$3 joiner$3 = new Joiner$3(objectArray, object, object2);
        return joiner$3;
    }

    public static Joiner on(char c10) {
        String string2 = String.valueOf(c10);
        Joiner joiner = new Joiner(string2);
        return joiner;
    }

    public static Joiner on(String string2) {
        Joiner joiner = new Joiner(string2);
        return joiner;
    }

    public Appendable appendTo(Appendable appendable, Iterable object) {
        object = object.iterator();
        return this.appendTo(appendable, (Iterator)object);
    }

    public final Appendable appendTo(Appendable appendable, Object object, Object object2, Object ... objectArray) {
        object = Joiner.iterable(object, object2, objectArray);
        return this.appendTo(appendable, (Iterable)object);
    }

    public Appendable appendTo(Appendable appendable, Iterator iterator2) {
        Preconditions.checkNotNull(appendable);
        boolean bl2 = iterator2.hasNext();
        if (bl2) {
            Object object = iterator2.next();
            object = this.toString(object);
            appendable.append((CharSequence)object);
            while (bl2 = iterator2.hasNext()) {
                object = this.separator;
                appendable.append((CharSequence)object);
                object = iterator2.next();
                object = this.toString(object);
                appendable.append((CharSequence)object);
            }
        }
        return appendable;
    }

    public final Appendable appendTo(Appendable appendable, Object[] object) {
        object = Arrays.asList(object);
        return this.appendTo(appendable, (Iterable)object);
    }

    public final StringBuilder appendTo(StringBuilder stringBuilder, Iterable object) {
        object = object.iterator();
        return this.appendTo(stringBuilder, (Iterator)object);
    }

    public final StringBuilder appendTo(StringBuilder stringBuilder, Object object, Object object2, Object ... objectArray) {
        object = Joiner.iterable(object, object2, objectArray);
        return this.appendTo(stringBuilder, (Iterable)object);
    }

    public final StringBuilder appendTo(StringBuilder stringBuilder, Iterator object) {
        try {
            this.appendTo((Appendable)stringBuilder, (Iterator)object);
            return stringBuilder;
        }
        catch (IOException iOException) {
            object = new AssertionError((Object)iOException);
            throw object;
        }
    }

    public final StringBuilder appendTo(StringBuilder stringBuilder, Object[] object) {
        object = Arrays.asList(object);
        return this.appendTo(stringBuilder, (Iterable)object);
    }

    public final String join(Iterable object) {
        object = object.iterator();
        return this.join((Iterator)object);
    }

    public final String join(Object object, Object object2, Object ... objectArray) {
        object = Joiner.iterable(object, object2, objectArray);
        return this.join((Iterable)object);
    }

    public final String join(Iterator iterator2) {
        StringBuilder stringBuilder = new StringBuilder();
        return this.appendTo(stringBuilder, iterator2).toString();
    }

    public final String join(Object[] object) {
        object = Arrays.asList(object);
        return this.join((Iterable)object);
    }

    public Joiner skipNulls() {
        Joiner$2 joiner$2 = new Joiner$2(this, this);
        return joiner$2;
    }

    public CharSequence toString(Object object) {
        Preconditions.checkNotNull(object);
        boolean bl2 = object instanceof CharSequence;
        object = bl2 ? (CharSequence)object : object.toString();
        return object;
    }

    public Joiner useForNull(String string2) {
        Preconditions.checkNotNull(string2);
        Joiner$1 joiner$1 = new Joiner$1(this, this, string2);
        return joiner$1;
    }

    public Joiner$MapJoiner withKeyValueSeparator(char c10) {
        String string2 = String.valueOf(c10);
        return this.withKeyValueSeparator(string2);
    }

    public Joiner$MapJoiner withKeyValueSeparator(String string2) {
        Joiner$MapJoiner joiner$MapJoiner = new Joiner$MapJoiner(this, string2, null);
        return joiner$MapJoiner;
    }
}

