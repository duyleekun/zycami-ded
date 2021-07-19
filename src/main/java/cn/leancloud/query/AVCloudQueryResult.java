/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.query;

import java.util.Collections;
import java.util.List;

public class AVCloudQueryResult {
    public int count;
    public List results;

    public AVCloudQueryResult() {
        List list;
        this.results = list = Collections.emptyList();
    }

    public int getCount() {
        return this.count;
    }

    public List getResults() {
        return this.results;
    }

    public void setCount(int n10) {
        this.count = n10;
    }

    public void setResults(List list) {
        this.results = list;
    }
}

