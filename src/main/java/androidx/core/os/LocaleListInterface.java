/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.os;

import java.util.Locale;

public interface LocaleListInterface {
    public Locale get(int var1);

    public Locale getFirstMatch(String[] var1);

    public Object getLocaleList();

    public int indexOf(Locale var1);

    public boolean isEmpty();

    public int size();

    public String toLanguageTags();
}
