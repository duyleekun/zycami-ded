/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.text.TextUtils
 */
package d.v.c.a2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import d.v.e.l.o1;

public class a
extends ViewModel {
    private static final String a = "page_id";
    private static final String b = "type";
    private static final String c = "type_id";
    private static final String d = "1";
    private static final String e = "share_post";

    private Uri b(Intent intent) {
        String string2;
        String string3;
        boolean bl2;
        if (intent != null && (bl2 = TextUtils.equals((CharSequence)(string3 = intent.getAction()), (CharSequence)(string2 = "android.intent.action.VIEW")))) {
            return intent.getData();
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public long c(Activity object) {
        Intent intent = object.getIntent();
        Uri uri = this.b(intent);
        long l10 = -1;
        if (uri == null) {
            return l10;
        }
        String string2 = c;
        String string3 = uri.getQueryParameter(string2);
        try {
            return Long.parseLong(string3);
        }
        catch (NumberFormatException numberFormatException) {
            return l10;
        }
    }

    public boolean d(Activity object) {
        boolean bl2;
        int n10;
        String string2;
        String string3;
        boolean bl3;
        Object object2 = object.getIntent();
        if ((object2 = this.b((Intent)object2)) != null && (bl3 = TextUtils.equals((CharSequence)(string3 = object2.getScheme()), (CharSequence)(string2 = o1.L((Context)object, n10 = 2131951832)))) && (bl2 = TextUtils.equals((CharSequence)(string3 = object2.getHost()), (CharSequence)(object = o1.L((Context)object, n10 = 2131951829)))) && (bl2 = TextUtils.equals((CharSequence)(object = object2.getQueryParameter(a)), (CharSequence)(string3 = d))) && (bl2 = TextUtils.equals((CharSequence)(object = object2.getQueryParameter(b)), (CharSequence)(object2 = e)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

