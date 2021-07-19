/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.hms.hatool.y;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public abstract class s0 {
    public static long a(String object, long l10) {
        long l11;
        Locale locale = Locale.getDefault();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat((String)object, locale);
        object = l10;
        object = simpleDateFormat.format(object);
        object = simpleDateFormat.parse((String)object);
        try {
            l11 = ((Date)object).getTime();
        }
        catch (ParseException parseException) {
            object = "hmsSdk/stringUtil";
            String string2 = "getMillisOfDate(): Time conversion Exception !";
            y.f((String)object, string2);
            l11 = 0L;
        }
        return l11;
    }

    public static Pair a(String string2) {
        Pair pair = "_default_config_tag";
        boolean bl2 = pair.equals(string2);
        if (!bl2) {
            pair = string2.split("-");
            int n10 = ((String[])pair).length;
            int n11 = 2;
            int n12 = 1;
            if (n10 > n11) {
                n10 = ((Pair)pair).length - n12;
                pair = pair[n10];
                n10 = pair.length();
                n11 = string2.length() - n10 - n12;
                string2 = string2.substring(0, n11);
            } else {
                string2 = pair[0];
                pair = pair[n12];
            }
            Pair pair2 = new Pair((Object)string2, (Object)pair);
            return pair2;
        }
        pair = new Pair((Object)string2, (Object)"");
        return pair;
    }

    public static String a(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        return "alltype";
                    }
                    return "diffprivacy";
                }
                return "preins";
            }
            return "maint";
        }
        return "oper";
    }

    public static String a(String string2, String string3) {
        CharSequence charSequence = "_default_config_tag";
        boolean bl2 = ((String)charSequence).equals(string2);
        if (!bl2) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append("-");
            ((StringBuilder)charSequence).append(string3);
            string2 = ((StringBuilder)charSequence).toString();
        }
        return string2;
    }

    public static String a(String charSequence, String string2, String string3) {
        CharSequence charSequence2 = "_default_config_tag";
        boolean bl2 = ((String)charSequence2).equals(charSequence);
        if (bl2) {
            charSequence = new StringBuilder();
            string2 = "_default_config_tag#";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(string3);
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append((String)charSequence);
            ((StringBuilder)charSequence2).append("-");
            ((StringBuilder)charSequence2).append(string2);
            ((StringBuilder)charSequence2).append("#");
            ((StringBuilder)charSequence2).append(string3);
            charSequence = ((StringBuilder)charSequence2).toString();
        }
        return charSequence;
    }

    public static Set a(Set object) {
        int n10;
        if (object != null && (n10 = object.size()) != 0) {
            boolean bl2;
            HashSet<CharSequence> hashSet = new HashSet<CharSequence>();
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                CharSequence charSequence = "_default_config_tag";
                String string2 = (String)object.next();
                boolean bl3 = ((String)charSequence).equals(string2);
                if (!bl3) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append(string2);
                    String string3 = "-";
                    ((StringBuilder)charSequence).append(string3);
                    ((StringBuilder)charSequence).append("oper");
                    charSequence = ((StringBuilder)charSequence).toString();
                    CharSequence charSequence2 = new StringBuilder();
                    charSequence2.append(string2);
                    charSequence2.append(string3);
                    charSequence2.append("maint");
                    charSequence2 = charSequence2.toString();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    stringBuilder.append(string3);
                    stringBuilder.append("diffprivacy");
                    string2 = stringBuilder.toString();
                    hashSet.add(charSequence);
                    hashSet.add(charSequence2);
                    hashSet.add(string2);
                    continue;
                }
                hashSet.add(charSequence);
            }
            return hashSet;
        }
        object = new HashSet();
        return object;
    }
}

