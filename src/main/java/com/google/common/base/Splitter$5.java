/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import java.util.Iterator;

public class Splitter$5
implements Iterable {
    public final /* synthetic */ Splitter this$0;
    public final /* synthetic */ CharSequence val$sequence;

    public Splitter$5(Splitter splitter, CharSequence charSequence) {
        this.this$0 = splitter;
        this.val$sequence = charSequence;
    }

    public Iterator iterator() {
        Splitter splitter = this.this$0;
        CharSequence charSequence = this.val$sequence;
        return Splitter.access$000(splitter, charSequence);
    }

    public String toString() {
        Object object = Joiner.on(", ");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        object = ((Joiner)object).appendTo(stringBuilder, (Iterable)this);
        ((StringBuilder)object).append(']');
        return ((StringBuilder)object).toString();
    }
}

