/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.SpannableString
 *  android.text.TextUtils
 *  android.text.style.ForegroundColorSpan
 *  android.view.View$OnClickListener
 */
package d.v.e.l;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import d.v.e.l.t1$a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t1 {
    public static SpannableString a(SpannableString spannableString, String string2, String string3, int n10, boolean bl2, View.OnClickListener onClickListener) {
        int n11;
        int n12;
        if (spannableString == null) {
            spannableString = new SpannableString((CharSequence)string2);
        }
        if ((n12 = string2.indexOf(string3)) == (n11 = -1)) {
            return spannableString;
        }
        int n13 = bl2 ? string3.length() + (n12 += -1) + 2 : string3.length() + n12;
        t1$a t1$a = new t1$a(onClickListener, n10);
        spannableString.setSpan((Object)t1$a, n12, n13, 17);
        return spannableString;
    }

    public static SpannableString b(int n10, String object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            SpannableString spannableString = new SpannableString((CharSequence)object);
            int n11 = 82;
            object = Pattern.compile(string2, n11);
            try {
                object = ((Pattern)object).matcher((CharSequence)spannableString);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            while (true) {
                int n12 = ((Matcher)object).find();
                if (n12 == 0) break;
                n12 = ((Matcher)object).start();
                int n13 = ((Matcher)object).end();
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(n10);
                int n14 = 33;
                spannableString.setSpan((Object)foregroundColorSpan, n12, n13, n14);
                continue;
                break;
            }
            return spannableString;
        }
        SpannableString spannableString = new SpannableString((CharSequence)object);
        return spannableString;
    }
}

