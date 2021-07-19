/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import java.util.Collections;
import java.util.List;

public class PageResult {
    public static final int APPEND = 1;
    private static final PageResult EMPTY_RESULT;
    public static final int INIT = 0;
    private static final PageResult INVALID_RESULT;
    public static final int PREPEND = 2;
    public static final int TILE = 3;
    public final int leadingNulls;
    public final List page;
    public final int positionOffset;
    public final int trailingNulls;

    static {
        PageResult pageResult;
        List list = Collections.emptyList();
        EMPTY_RESULT = pageResult = new PageResult(list, 0);
        list = Collections.emptyList();
        INVALID_RESULT = pageResult = new PageResult(list, 0);
    }

    public PageResult(List list, int n10) {
        this.page = list;
        this.leadingNulls = 0;
        this.trailingNulls = 0;
        this.positionOffset = n10;
    }

    public PageResult(List list, int n10, int n11, int n12) {
        this.page = list;
        this.leadingNulls = n10;
        this.trailingNulls = n11;
        this.positionOffset = n12;
    }

    public static PageResult getEmptyResult() {
        return EMPTY_RESULT;
    }

    public static PageResult getInvalidResult() {
        return INVALID_RESULT;
    }

    public boolean isInvalid() {
        boolean bl2;
        PageResult pageResult = INVALID_RESULT;
        if (this == pageResult) {
            bl2 = true;
        } else {
            bl2 = false;
            pageResult = null;
        }
        return bl2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Result ");
        int n10 = this.leadingNulls;
        stringBuilder.append(n10);
        String string2 = ", ";
        stringBuilder.append(string2);
        List list = this.page;
        stringBuilder.append(list);
        stringBuilder.append(string2);
        n10 = this.trailingNulls;
        stringBuilder.append(n10);
        stringBuilder.append(", offset ");
        n10 = this.positionOffset;
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }
}

