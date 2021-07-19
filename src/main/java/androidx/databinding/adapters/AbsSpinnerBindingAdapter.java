/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.AbsSpinner
 *  android.widget.ArrayAdapter
 *  android.widget.SpinnerAdapter
 */
package androidx.databinding.adapters;

import android.content.Context;
import android.widget.AbsSpinner;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import androidx.databinding.adapters.ObservableListAdapter;
import java.util.List;

public class AbsSpinnerBindingAdapter {
    public static void setEntries(AbsSpinner absSpinner, List list) {
        if (list != null) {
            Object object = absSpinner.getAdapter();
            boolean bl2 = object instanceof ObservableListAdapter;
            if (bl2) {
                object = (ObservableListAdapter)((Object)object);
                ((ObservableListAdapter)((Object)object)).setList(list);
            } else {
                Context context = absSpinner.getContext();
                int n10 = 17367048;
                int n11 = 0x1090009;
                object = new ObservableListAdapter(context, list, n10, n11, 0);
                absSpinner.setAdapter((SpinnerAdapter)object);
            }
        } else {
            list = null;
            absSpinner.setAdapter(null);
        }
    }

    /*
     * Unable to fully structure code
     */
    public static void setEntries(AbsSpinner var0, CharSequence[] var1_1) {
        block4: {
            block3: {
                if (var1_1 == null) break block3;
                var2_2 = var0.getAdapter();
                var3_3 = 0;
                var4_4 = null;
                var5_5 = 1;
                if (var2_2 == null || (var6_6 = var2_2.getCount()) != (var7_7 = var1_1.length)) ** GOTO lbl13
                for (var6_6 = 0; var6_6 < (var7_7 = var1_1.length); ++var6_6) {
                    var8_8 = var1_1[var6_6];
                    var9_9 = var2_2.getItem(var6_6);
                    var7_7 = (int)var8_8.equals(var9_9);
                    if (var7_7 != 0) {
                        continue;
                    }
lbl13:
                    // 3 sources

                    var3_3 = var5_5;
                    break;
                }
                if (var3_3 != 0) {
                    var4_4 = var0.getContext();
                    var5_5 = 17367048;
                    var2_2 = new ArrayAdapter(var4_4, var5_5, (Object[])var1_1);
                    var10_10 = 0x1090009;
                    var2_2.setDropDownViewResource(var10_10);
                    var0.setAdapter(var2_2);
                }
                break block4;
            }
            var10_11 = false;
            var1_1 = null;
            var0.setAdapter(null);
        }
    }
}

