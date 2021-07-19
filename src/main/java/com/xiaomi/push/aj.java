/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences$Editor
 */
package com.xiaomi.push;

import android.content.SharedPreferences;
import com.xiaomi.push.ai;
import com.xiaomi.push.ai$a;
import com.xiaomi.push.ai$b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class aj
extends ai$b {
    public final /* synthetic */ ai a;
    public final /* synthetic */ String a;

    public aj(ai ai2, ai$a ai$a, String string2) {
        this.a = ai2;
        this.a = string2;
        super(ai$a);
    }

    public void a() {
        super.a();
    }

    public void b() {
        SharedPreferences.Editor editor = ai.a(this.a).edit();
        String string2 = this.a;
        long l10 = System.currentTimeMillis();
        editor.putLong(string2, l10).commit();
    }
}

