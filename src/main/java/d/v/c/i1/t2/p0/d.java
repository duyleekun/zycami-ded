/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.InputFilter
 *  android.text.Spanned
 */
package d.v.c.i1.t2.p0;

import android.text.InputFilter;
import android.text.Spanned;
import com.zhiyun.cama.main.me.edit.EditProfileFragment;

public final class d
implements InputFilter {
    public static final /* synthetic */ d a;

    static {
        d d10;
        a = d10 = new d();
    }

    public final CharSequence filter(CharSequence charSequence, int n10, int n11, Spanned spanned, int n12, int n13) {
        return EditProfileFragment.A(charSequence, n10, n11, spanned, n12, n13);
    }
}

