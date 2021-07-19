/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.LocaleList
 */
package androidx.core.os;

import android.os.LocaleList;
import androidx.core.os.LocaleListInterface;
import java.util.Locale;

public final class LocaleListPlatformWrapper
implements LocaleListInterface {
    private final LocaleList mLocaleList;

    public LocaleListPlatformWrapper(LocaleList localeList) {
        this.mLocaleList = localeList;
    }

    public boolean equals(Object object) {
        LocaleList localeList = this.mLocaleList;
        object = ((LocaleListInterface)object).getLocaleList();
        return localeList.equals(object);
    }

    public Locale get(int n10) {
        return this.mLocaleList.get(n10);
    }

    public Locale getFirstMatch(String[] stringArray) {
        return this.mLocaleList.getFirstMatch(stringArray);
    }

    public Object getLocaleList() {
        return this.mLocaleList;
    }

    public int hashCode() {
        return this.mLocaleList.hashCode();
    }

    public int indexOf(Locale locale) {
        return this.mLocaleList.indexOf(locale);
    }

    public boolean isEmpty() {
        return this.mLocaleList.isEmpty();
    }

    public int size() {
        return this.mLocaleList.size();
    }

    public String toLanguageTags() {
        return this.mLocaleList.toLanguageTags();
    }

    public String toString() {
        return this.mLocaleList.toString();
    }
}

