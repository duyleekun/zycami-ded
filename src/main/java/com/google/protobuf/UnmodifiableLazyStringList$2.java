/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.UnmodifiableLazyStringList;
import java.util.Iterator;

public class UnmodifiableLazyStringList$2
implements Iterator {
    public Iterator iter;
    public final /* synthetic */ UnmodifiableLazyStringList this$0;

    public UnmodifiableLazyStringList$2(UnmodifiableLazyStringList object) {
        this.this$0 = object;
        this.iter = object = UnmodifiableLazyStringList.access$000((UnmodifiableLazyStringList)object).iterator();
    }

    public boolean hasNext() {
        return this.iter.hasNext();
    }

    public String next() {
        return (String)this.iter.next();
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

