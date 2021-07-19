/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package androidx.core.os;

import android.os.Build;
import androidx.core.os.LocaleListCompat;
import androidx.core.os.LocaleListInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

public final class LocaleListCompatWrapper
implements LocaleListInterface {
    private static final Locale EN_LATN;
    private static final Locale LOCALE_AR_XB;
    private static final Locale LOCALE_EN_XA;
    private static final Locale[] sEmptyList;
    private final Locale[] mList;
    private final String mStringRepresentation;

    static {
        Locale locale;
        sEmptyList = new Locale[0];
        LOCALE_EN_XA = locale = new Locale("en", "XA");
        LOCALE_AR_XB = locale = new Locale("ar", "XB");
        EN_LATN = LocaleListCompat.forLanguageTagCompat("en-Latn");
    }

    public LocaleListCompatWrapper(Locale ... object) {
        int n10 = ((Object)object).length;
        if (n10 == 0) {
            object = sEmptyList;
            this.mList = object;
            this.mStringRepresentation = object = "";
        } else {
            int n11;
            Object object2 = new ArrayList();
            HashSet<Object> hashSet = new HashSet<Object>();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i10 = 0; i10 < (n11 = ((Object)object).length); ++i10) {
                Object locale = object[i10];
                if (locale != null) {
                    char c10 = hashSet.contains(locale);
                    if (c10 != '\u0000') continue;
                    locale = (Locale)((Locale)locale).clone();
                    object2.add(locale);
                    LocaleListCompatWrapper.toLanguageTag(stringBuilder, (Locale)locale);
                    c10 = ((Object)object).length + -1;
                    if (i10 < c10) {
                        c10 = ',';
                        stringBuilder.append(c10);
                    }
                    hashSet.add(locale);
                    continue;
                }
                ((StringBuilder)object2).append("list[");
                ((StringBuilder)object2).append(i10);
                ((StringBuilder)object2).append("] is null");
                object2 = ((StringBuilder)object2).toString();
                object = new NullPointerException((String)object2);
                throw object;
            }
            int n12 = object2.size();
            object = new Locale[n12];
            object = (Locale[])object2.toArray((T[])object);
            this.mList = object;
            this.mStringRepresentation = object = stringBuilder.toString();
        }
    }

    private Locale computeFirstMatch(Collection object, boolean n10) {
        int n11 = this.computeFirstMatchIndex((Collection)object, n10 != 0);
        if (n11 == (n10 = -1)) {
            n11 = 0;
            object = null;
        } else {
            Locale[] localeArray = this.mList;
            object = localeArray[n11];
        }
        return object;
    }

    private int computeFirstMatchIndex(Collection object, boolean n10) {
        int n11;
        int n12;
        block10: {
            block9: {
                Locale[] localeArray = this.mList;
                n12 = localeArray.length;
                int n13 = 1;
                if (n12 == n13) {
                    return 0;
                }
                n11 = localeArray.length;
                if (n11 == 0) {
                    return -1;
                }
                n11 = -1 >>> 1;
                if (n10 == 0) break block9;
                Locale locale = EN_LATN;
                n10 = this.findFirstMatchIndex(locale);
                if (n10 == 0) {
                    return 0;
                }
                if (n10 < n11) break block10;
            }
            n10 = n11;
        }
        object = object.iterator();
        while ((n12 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Locale locale = LocaleListCompat.forLanguageTagCompat((String)object.next());
            n12 = this.findFirstMatchIndex(locale);
            if (n12 == 0) {
                return 0;
            }
            if (n12 >= n10) continue;
            n10 = n12;
        }
        if (n10 == n11) {
            return 0;
        }
        return n10;
    }

    private int findFirstMatchIndex(Locale locale) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((Locale[])(object = this.mList)).length); ++i10) {
            int n11 = LocaleListCompatWrapper.matchScore(locale, (Locale)(object = object[i10]));
            if (n11 <= 0) continue;
            return i10;
        }
        return -1 >>> 1;
    }

    private static String getLikelyScript(Locale object) {
        int n10 = Build.VERSION.SDK_INT;
        String string2 = "";
        int n11 = 21;
        if (n10 >= n11 && (n10 = (int)(((String)(object = ((Locale)object).getScript())).isEmpty() ? 1 : 0)) == 0) {
            return object;
        }
        return string2;
    }

    private static boolean isPseudoLocale(Locale locale) {
        boolean bl2;
        Locale locale2 = LOCALE_EN_XA;
        boolean bl3 = locale2.equals(locale);
        if (!bl3 && !(bl2 = (locale2 = LOCALE_AR_XB).equals(locale))) {
            bl2 = false;
            locale = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private static int matchScore(Locale object, Locale object2) {
        boolean bl2 = ((Locale)object).equals(object2);
        int n10 = 1;
        if (bl2) {
            return n10;
        }
        String string2 = ((Locale)object).getLanguage();
        String string3 = ((Locale)object2).getLanguage();
        bl2 = string2.equals(string3);
        string3 = null;
        if (!bl2) {
            return 0;
        }
        bl2 = LocaleListCompatWrapper.isPseudoLocale((Locale)object);
        if (!bl2 && !(bl2 = LocaleListCompatWrapper.isPseudoLocale((Locale)object2))) {
            string2 = LocaleListCompatWrapper.getLikelyScript((Locale)object);
            boolean bl3 = string2.isEmpty();
            if (bl3) {
                boolean bl4;
                bl2 = ((String)(object = ((Locale)object).getCountry())).isEmpty();
                if (!bl2 && !(bl4 = ((String)object).equals(object2 = ((Locale)object2).getCountry()))) {
                    n10 = 0;
                }
                return n10;
            }
            object = LocaleListCompatWrapper.getLikelyScript((Locale)object2);
            return (int)(string2.equals(object) ? 1 : 0);
        }
        return 0;
    }

    public static void toLanguageTag(StringBuilder stringBuilder, Locale object) {
        char c10;
        String string2 = ((Locale)object).getLanguage();
        stringBuilder.append(string2);
        string2 = ((Locale)object).getCountry();
        if (string2 != null && (c10 = string2.isEmpty()) == '\u0000') {
            c10 = '-';
            stringBuilder.append(c10);
            object = ((Locale)object).getCountry();
            stringBuilder.append((String)object);
        }
    }

    public boolean equals(Object localeArray) {
        Object object;
        int n10;
        boolean bl2 = true;
        if (localeArray == this) {
            return bl2;
        }
        int n11 = localeArray instanceof LocaleListCompatWrapper;
        if (n11 == 0) {
            return false;
        }
        Locale[] localeArray2 = this.mList;
        n11 = localeArray2.length;
        localeArray = ((LocaleListCompatWrapper)localeArray).mList;
        int n12 = localeArray.length;
        if (n11 != n12) {
            return false;
        }
        localeArray2 = null;
        for (n11 = 0; n11 < (n10 = ((Locale[])(object = this.mList)).length); ++n11) {
            Locale locale = localeArray[n11];
            n12 = (int)(((Locale)(object = object[n11])).equals(locale) ? 1 : 0);
            if (n12 != 0) continue;
            return false;
        }
        return bl2;
    }

    public Locale get(int n10) {
        Locale locale;
        Locale[] localeArray;
        int n11;
        if (n10 >= 0 && n10 < (n11 = (localeArray = this.mList).length)) {
            locale = localeArray[n10];
        } else {
            n10 = 0;
            locale = null;
        }
        return locale;
    }

    public Locale getFirstMatch(String[] object) {
        object = Arrays.asList(object);
        return this.computeFirstMatch((Collection)object, false);
    }

    public Object getLocaleList() {
        return null;
    }

    public int hashCode() {
        Object object;
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = ((Locale[])(object = this.mList)).length); ++i10) {
            n11 *= 31;
            object = object[i10];
            int n12 = ((Locale)object).hashCode();
            n11 += n12;
        }
        return n11;
    }

    public int indexOf(Locale locale) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((Locale[])(object = this.mList)).length); ++i10) {
            boolean bl2 = ((Locale)(object = object[i10])).equals(locale);
            if (!bl2) continue;
            return i10;
        }
        return -1;
    }

    public boolean isEmpty() {
        Locale[] localeArray = this.mList;
        boolean bl2 = localeArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            localeArray = null;
        }
        return bl2;
    }

    public int size() {
        return this.mList.length;
    }

    public String toLanguageTags() {
        return this.mStringRepresentation;
    }

    public String toString() {
        Object object;
        int n10;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i10 = 0; i10 < (n10 = ((Locale[])(object = this.mList)).length); ++i10) {
            object = object[i10];
            stringBuilder.append(object);
            object = this.mList;
            char c10 = ((Locale[])object).length + -1;
            if (i10 >= c10) continue;
            c10 = ',';
            stringBuilder.append(c10);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

