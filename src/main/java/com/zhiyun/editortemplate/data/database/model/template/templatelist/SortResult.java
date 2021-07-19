/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.templatelist;

import java.util.List;
import java.util.Objects;

public class SortResult {
    private int count;
    private List idList;
    private int nextPage;
    private String pageType;

    public SortResult(String string2, int n10, int n11, List list) {
        this.pageType = string2;
        this.nextPage = n10;
        this.count = n11;
        this.idList = list;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            object = (SortResult)object;
            int n10 = this.nextPage;
            int n11 = ((SortResult)object).nextPage;
            if (n10 != n11 || (n10 = this.count) != (n11 = ((SortResult)object).count) || (n10 = (int)(((String)(object3 = this.pageType)).equals(object2 = ((SortResult)object).pageType) ? 1 : 0)) == 0 || !(bl3 = Objects.equals(object3 = this.idList, object = ((SortResult)object).idList))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getCount() {
        return this.count;
    }

    public List getIdList() {
        return this.idList;
    }

    public int getNextPage() {
        return this.nextPage;
    }

    public String getPageType() {
        return this.pageType;
    }

    public int hashCode() {
        Object object = this.pageType;
        object = this.nextPage;
        Object[] objectArray = new Object[]{object, object, object = Integer.valueOf(this.count), object = this.idList};
        return Objects.hash(objectArray);
    }

    public void setCount(int n10) {
        this.count = n10;
    }

    public void setIdList(List list) {
        this.idList = list;
    }

    public void setNextPage(int n10) {
        this.nextPage = n10;
    }

    public void setPageType(String string2) {
        this.pageType = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SortResult{pageType='");
        Object object = this.pageType;
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append(", nextPage=");
        int n10 = this.nextPage;
        stringBuilder.append(n10);
        stringBuilder.append(", count=");
        n10 = this.count;
        stringBuilder.append(n10);
        stringBuilder.append(", idList=");
        object = this.idList;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

