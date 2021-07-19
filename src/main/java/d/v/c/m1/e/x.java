/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.c.m1.e;

import android.text.TextUtils;
import androidx.core.util.Pair;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class x {
    private static final Pattern e = Pattern.compile("[0-9]*,?[0-9]*\\.?[0-9]+");
    private long a;
    private String b;
    private String c;
    private String d;

    public long a() {
        return this.a;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.d;
    }

    public x e(long l10) {
        this.a = l10;
        return this;
    }

    public x f(String string2) {
        this.c = string2;
        return this;
    }

    public x g(String string2) {
        this.b = string2;
        return this;
    }

    public x h(String string2) {
        this.d = string2;
        return this;
    }

    public Pair i(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return null;
        }
        Object object = e.matcher(string2);
        boolean bl3 = ((Matcher)object).find();
        if (bl3) {
            object = ((Matcher)object).group();
            string2 = string2.replace((CharSequence)object, "");
            return Pair.create(object, string2);
        }
        return null;
    }
}

