/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.InputFilter
 *  android.text.Spanned
 */
package d.v.f.i;

import android.text.InputFilter;
import android.text.Spanned;
import d.v.f.i.f;
import java.util.regex.Pattern;

public final class a
implements InputFilter {
    public final /* synthetic */ Pattern a;

    public /* synthetic */ a(Pattern pattern) {
        this.a = pattern;
    }

    public final CharSequence filter(CharSequence charSequence, int n10, int n11, Spanned spanned, int n12, int n13) {
        return f.d(this.a, charSequence, n10, n11, spanned, n12, n13);
    }
}

