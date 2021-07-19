/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Splitter$1;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class Splitter$MapSplitter {
    private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
    private final Splitter entrySplitter;
    private final Splitter outerSplitter;

    private Splitter$MapSplitter(Splitter splitter, Splitter splitter2) {
        this.outerSplitter = splitter;
        this.entrySplitter = splitter = (Splitter)Preconditions.checkNotNull(splitter2);
    }

    public /* synthetic */ Splitter$MapSplitter(Splitter splitter, Splitter splitter2, Splitter.1 var3_3) {
        this(splitter, splitter2);
    }

    public Map split(CharSequence object) {
        boolean bl2;
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        Object object2 = this.outerSplitter;
        object = ((Splitter)object2).split((CharSequence)object).iterator();
        while (bl2 = object.hasNext()) {
            object2 = (String)object.next();
            Iterator iterator2 = Splitter.access$000(this.entrySplitter, (CharSequence)object2);
            boolean bl3 = iterator2.hasNext();
            String string2 = INVALID_ENTRY_MESSAGE;
            Preconditions.checkArgument(bl3, string2, object2);
            String string3 = (String)iterator2.next();
            boolean bl4 = linkedHashMap.containsKey(string3) ^ true;
            String string4 = "Duplicate key [%s] found.";
            Preconditions.checkArgument(bl4, string4, (Object)string3);
            bl4 = iterator2.hasNext();
            Preconditions.checkArgument(bl4, string2, object2);
            String string5 = (String)iterator2.next();
            linkedHashMap.put(string3, string5);
            boolean bl5 = iterator2.hasNext() ^ true;
            Preconditions.checkArgument(bl5, string2, object2);
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }
}

