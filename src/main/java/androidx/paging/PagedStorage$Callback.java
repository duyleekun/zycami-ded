/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

public interface PagedStorage$Callback {
    public void onEmptyAppend();

    public void onEmptyPrepend();

    public void onInitialized(int var1);

    public void onPageAppended(int var1, int var2, int var3);

    public void onPageInserted(int var1, int var2);

    public void onPagePlaceholderInserted(int var1);

    public void onPagePrepended(int var1, int var2, int var3);

    public void onPagesRemoved(int var1, int var2);

    public void onPagesSwappedToPlaceholder(int var1, int var2);
}

