/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.CommonPattern;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;

public class Predicates$ContainsPatternPredicate
implements Predicate,
Serializable {
    private static final long serialVersionUID;
    public final CommonPattern pattern;

    public Predicates$ContainsPatternPredicate(CommonPattern commonPattern) {
        this.pattern = commonPattern = (CommonPattern)Preconditions.checkNotNull(commonPattern);
    }

    public boolean apply(CharSequence charSequence) {
        return this.pattern.matcher(charSequence).find();
    }

    public boolean equals(Object object) {
        int n10 = object instanceof Predicates$ContainsPatternPredicate;
        boolean bl2 = false;
        if (n10 != 0) {
            int n11;
            String string2;
            object = (Predicates$ContainsPatternPredicate)object;
            Object object2 = this.pattern.pattern();
            n10 = Objects.equal(object2, string2 = ((Predicates$ContainsPatternPredicate)object).pattern.pattern());
            if (n10 != 0 && (n10 = ((CommonPattern)(object2 = this.pattern)).flags()) == (n11 = ((CommonPattern)(object = ((Predicates$ContainsPatternPredicate)object).pattern)).flags())) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        Object object = this.pattern.pattern();
        Object[] objectArray = new Object[]{object, object = Integer.valueOf(this.pattern.flags())};
        return Objects.hashCode(objectArray);
    }

    public String toString() {
        Object object = MoreObjects.toStringHelper(this.pattern);
        CharSequence charSequence = this.pattern.pattern();
        object = ((MoreObjects$ToStringHelper)object).add("pattern", charSequence);
        int n10 = this.pattern.flags();
        object = ((MoreObjects$ToStringHelper)object).add("pattern.flags", n10).toString();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Predicates.contains(");
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(")");
        return ((StringBuilder)charSequence).toString();
    }
}

