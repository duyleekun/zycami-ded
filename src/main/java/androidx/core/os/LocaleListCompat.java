/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.LocaleList
 */
package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.core.os.LocaleListCompatWrapper;
import androidx.core.os.LocaleListInterface;
import androidx.core.os.LocaleListPlatformWrapper;
import java.util.Locale;

public final class LocaleListCompat {
    private static final LocaleListCompat sEmptyLocaleList = LocaleListCompat.create(new Locale[0]);
    private LocaleListInterface mImpl;

    private LocaleListCompat(LocaleListInterface localeListInterface) {
        this.mImpl = localeListInterface;
    }

    public static LocaleListCompat create(Locale ... localeArray) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            LocaleList localeList = new LocaleList(localeArray);
            return LocaleListCompat.wrap(localeList);
        }
        LocaleListCompatWrapper localeListCompatWrapper = new LocaleListCompatWrapper(localeArray);
        LocaleListCompat localeListCompat = new LocaleListCompat(localeListCompatWrapper);
        return localeListCompat;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Locale forLanguageTagCompat(String object) {
        String string2 = "-";
        int n10 = ((String)object).contains(string2);
        int n11 = -1;
        int n12 = 2;
        int n13 = 1;
        if (n10 != 0) {
            String[] stringArray = ((String)object).split(string2, n11);
            n10 = stringArray.length;
            if (n10 > n12) {
                String string3 = stringArray[0];
                String string4 = stringArray[n13];
                String string5 = stringArray[n12];
                return new Locale(string3, string4, string5);
            }
            n10 = stringArray.length;
            if (n10 > n13) {
                String string6 = stringArray[0];
                String string7 = stringArray[n13];
                return new Locale(string6, string7);
            }
            n10 = stringArray.length;
            if (n10 == n13) {
                String string8 = stringArray[0];
                return new Locale(string8);
            }
        } else {
            String string9 = "_";
            n10 = ((String)object).contains(string9);
            if (n10 == 0) return new Locale((String)object);
            String[] stringArray = ((String)object).split(string9, n11);
            n10 = stringArray.length;
            if (n10 > n12) {
                String string10 = stringArray[0];
                String string11 = stringArray[n13];
                String string12 = stringArray[n12];
                return new Locale(string10, string11, string12);
            }
            n10 = stringArray.length;
            if (n10 > n13) {
                String string13 = stringArray[0];
                String string14 = stringArray[n13];
                return new Locale(string13, string14);
            }
            n10 = stringArray.length;
            if (n10 == n13) {
                String string15 = stringArray[0];
                return new Locale(string15);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can not parse language tag: [");
        stringBuilder.append((String)object);
        stringBuilder.append("]");
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static LocaleListCompat forLanguageTags(String stringArray) {
        int n10;
        if (stringArray != null && (n10 = stringArray.isEmpty()) == 0) {
            stringArray = stringArray.split(",", -1);
            n10 = stringArray.length;
            Locale[] localeArray = new Locale[n10];
            for (int i10 = 0; i10 < n10; ++i10) {
                int n11 = Build.VERSION.SDK_INT;
                int n12 = 21;
                Locale locale = n11 >= n12 ? Locale.forLanguageTag(stringArray[i10]) : LocaleListCompat.forLanguageTagCompat(stringArray[i10]);
                localeArray[i10] = locale;
            }
            return LocaleListCompat.create(localeArray);
        }
        return LocaleListCompat.getEmptyLocaleList();
    }

    public static LocaleListCompat getAdjustedDefault() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return LocaleListCompat.wrap(LocaleList.getAdjustedDefault());
        }
        Locale locale = Locale.getDefault();
        Locale[] localeArray = new Locale[]{locale};
        return LocaleListCompat.create(localeArray);
    }

    public static LocaleListCompat getDefault() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return LocaleListCompat.wrap(LocaleList.getDefault());
        }
        Locale locale = Locale.getDefault();
        Locale[] localeArray = new Locale[]{locale};
        return LocaleListCompat.create(localeArray);
    }

    public static LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    public static LocaleListCompat wrap(LocaleList localeList) {
        LocaleListPlatformWrapper localeListPlatformWrapper = new LocaleListPlatformWrapper(localeList);
        LocaleListCompat localeListCompat = new LocaleListCompat(localeListPlatformWrapper);
        return localeListCompat;
    }

    public static LocaleListCompat wrap(Object object) {
        return LocaleListCompat.wrap((LocaleList)object);
    }

    public boolean equals(Object object) {
        LocaleListInterface localeListInterface;
        boolean bl2;
        boolean bl3 = object instanceof LocaleListCompat;
        if (bl3 && (bl2 = (localeListInterface = this.mImpl).equals(object = ((LocaleListCompat)object).mImpl))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Locale get(int n10) {
        return this.mImpl.get(n10);
    }

    public Locale getFirstMatch(String[] stringArray) {
        return this.mImpl.getFirstMatch(stringArray);
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public int indexOf(Locale locale) {
        return this.mImpl.indexOf(locale);
    }

    public boolean isEmpty() {
        return this.mImpl.isEmpty();
    }

    public int size() {
        return this.mImpl.size();
    }

    public String toLanguageTags() {
        return this.mImpl.toLanguageTags();
    }

    public String toString() {
        return this.mImpl.toString();
    }

    public Object unwrap() {
        return this.mImpl.getLocaleList();
    }
}

