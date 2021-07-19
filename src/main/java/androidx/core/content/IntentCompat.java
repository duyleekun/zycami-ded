/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Build$VERSION
 */
package androidx.core.content;

import android.content.Intent;
import android.os.Build;

public final class IntentCompat {
    public static final String ACTION_CREATE_REMINDER = "android.intent.action.CREATE_REMINDER";
    public static final String CATEGORY_LEANBACK_LAUNCHER = "android.intent.category.LEANBACK_LAUNCHER";
    public static final String EXTRA_HTML_TEXT = "android.intent.extra.HTML_TEXT";
    public static final String EXTRA_START_PLAYBACK = "android.intent.extra.START_PLAYBACK";
    public static final String EXTRA_TIME = "android.intent.extra.TIME";

    private IntentCompat() {
    }

    public static Intent makeMainSelectorActivity(String string2, String string3) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 15;
        if (n10 >= n11) {
            return Intent.makeMainSelectorActivity((String)string2, (String)string3);
        }
        Intent intent = new Intent(string2);
        intent.addCategory(string3);
        return intent;
    }
}

