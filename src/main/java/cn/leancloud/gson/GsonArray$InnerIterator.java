/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.gson;

import cn.leancloud.gson.GsonWrapper;
import com.google.gson.JsonElement;
import java.util.Iterator;

public class GsonArray$InnerIterator
implements Iterator {
    private Iterator gsonIterator = null;

    public GsonArray$InnerIterator(Iterator iterator2) {
        this.gsonIterator = iterator2;
    }

    public boolean hasNext() {
        return this.gsonIterator.hasNext();
    }

    public Object next() {
        JsonElement jsonElement = (JsonElement)this.gsonIterator.next();
        if (jsonElement == null) {
            return null;
        }
        return GsonWrapper.toJavaObject(jsonElement);
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("remove");
        throw unsupportedOperationException;
    }
}

