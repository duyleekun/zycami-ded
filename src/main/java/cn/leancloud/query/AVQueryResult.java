/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.query;

import cn.leancloud.json.JSON;
import java.util.List;

public class AVQueryResult {
    private String className = "";
    private int count = 0;
    private List results = null;

    public static AVQueryResult fromJSONString(String string2) {
        return (AVQueryResult)JSON.parseObject(string2, AVQueryResult.class);
    }

    public String getClassName() {
        return this.className;
    }

    public int getCount() {
        return this.count;
    }

    public List getResults() {
        return this.results;
    }

    public void setClassName(String string2) {
        this.className = string2;
    }

    public void setCount(int n10) {
        this.count = n10;
    }

    public void setResults(List list) {
        this.results = list;
    }

    public String toJSONString() {
        return JSON.toJSONString(this);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"count\":");
        int n10 = this.count;
        stringBuilder.append(n10);
        stringBuilder.append(", \"results\":");
        List list = this.results;
        stringBuilder.append(list);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

