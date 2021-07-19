/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.TreeBasedTable;
import java.util.Iterator;
import java.util.Map;

public class TreeBasedTable$1
implements Function {
    public final /* synthetic */ TreeBasedTable this$0;

    public TreeBasedTable$1(TreeBasedTable treeBasedTable) {
        this.this$0 = treeBasedTable;
    }

    public Iterator apply(Map map) {
        return map.keySet().iterator();
    }
}

