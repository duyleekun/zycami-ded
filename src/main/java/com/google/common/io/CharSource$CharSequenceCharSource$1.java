/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Splitter;
import com.google.common.collect.AbstractIterator;
import com.google.common.io.CharSource$CharSequenceCharSource;
import java.util.Iterator;

public class CharSource$CharSequenceCharSource$1
extends AbstractIterator {
    public Iterator lines;
    public final /* synthetic */ CharSource$CharSequenceCharSource this$0;

    public CharSource$CharSequenceCharSource$1(CharSource$CharSequenceCharSource iterator2) {
        this.this$0 = iterator2;
        Splitter splitter = CharSource$CharSequenceCharSource.access$100();
        iterator2 = ((CharSource$CharSequenceCharSource)iterator2).seq;
        this.lines = iterator2 = splitter.split((CharSequence)((Object)iterator2)).iterator();
    }

    public String computeNext() {
        Object object = this.lines;
        boolean bl2 = object.hasNext();
        if (bl2) {
            object = (String)this.lines.next();
            Iterator iterator2 = this.lines;
            boolean bl3 = iterator2.hasNext();
            if (bl3 || !(bl3 = ((String)object).isEmpty())) {
                return object;
            }
        }
        return (String)this.endOfData();
    }
}

