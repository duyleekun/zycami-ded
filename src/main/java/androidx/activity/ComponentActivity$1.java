/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package androidx.activity;

import android.text.TextUtils;
import androidx.activity.ComponentActivity;

public class ComponentActivity$1
implements Runnable {
    public final /* synthetic */ ComponentActivity this$0;

    public ComponentActivity$1(ComponentActivity componentActivity) {
        this.this$0 = componentActivity;
    }

    public void run() {
        IllegalStateException illegalStateException2;
        block3: {
            ComponentActivity componentActivity = this.this$0;
            try {
                ComponentActivity.access$001(componentActivity);
            }
            catch (IllegalStateException illegalStateException2) {
                String string2 = illegalStateException2.getMessage();
                String string3 = "Can not perform this action after onSaveInstanceState";
                boolean bl2 = TextUtils.equals((CharSequence)string2, (CharSequence)string3);
                if (!bl2) break block3;
            }
            return;
        }
        throw illegalStateException2;
    }
}

