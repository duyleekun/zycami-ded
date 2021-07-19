/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseBooleanArray
 *  android.widget.TableLayout
 */
package androidx.databinding.adapters;

import android.util.SparseBooleanArray;
import android.widget.TableLayout;
import java.util.regex.Pattern;

public class TableLayoutBindingAdapter {
    private static final int MAX_COLUMNS = 20;
    private static Pattern sColumnPattern = Pattern.compile("\\s*,\\s*");

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static SparseBooleanArray parseColumns(CharSequence stringArray) {
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        if (stringArray == null) {
            return sparseBooleanArray;
        }
        Pattern pattern = sColumnPattern;
        stringArray = pattern.split((CharSequence)stringArray);
        int n10 = stringArray.length;
        int n11 = 0;
        while (n11 < n10) {
            String string2 = stringArray[n11];
            try {
                int n12 = Integer.parseInt(string2);
                if (n12 >= 0) {
                    boolean bl2 = true;
                    sparseBooleanArray.put(n12, bl2);
                }
            }
            catch (NumberFormatException numberFormatException) {}
            ++n11;
        }
        return sparseBooleanArray;
    }

    public static void setCollapseColumns(TableLayout tableLayout, CharSequence charSequence) {
        int n10;
        charSequence = TableLayoutBindingAdapter.parseColumns(charSequence);
        for (int i10 = 0; i10 < (n10 = 20); ++i10) {
            int n11;
            n10 = (int)(charSequence.get(i10, false) ? 1 : 0);
            if (n10 == (n11 = tableLayout.isColumnCollapsed(i10))) continue;
            tableLayout.setColumnCollapsed(i10, n10 != 0);
        }
    }

    public static void setShrinkColumns(TableLayout tableLayout, CharSequence charSequence) {
        int n10;
        int n11;
        if (charSequence != null && (n11 = charSequence.length()) > 0 && (n11 = (int)charSequence.charAt(0)) == (n10 = 42)) {
            boolean bl2 = true;
            tableLayout.setShrinkAllColumns(bl2);
        } else {
            tableLayout.setShrinkAllColumns(false);
            charSequence = TableLayoutBindingAdapter.parseColumns(charSequence);
            n11 = charSequence.size();
            for (int i10 = 0; i10 < n11; ++i10) {
                n10 = charSequence.keyAt(i10);
                boolean bl3 = charSequence.valueAt(i10);
                if (!bl3) continue;
                tableLayout.setColumnShrinkable(n10, bl3);
            }
        }
    }

    public static void setStretchColumns(TableLayout tableLayout, CharSequence charSequence) {
        int n10;
        int n11;
        if (charSequence != null && (n11 = charSequence.length()) > 0 && (n11 = (int)charSequence.charAt(0)) == (n10 = 42)) {
            boolean bl2 = true;
            tableLayout.setStretchAllColumns(bl2);
        } else {
            tableLayout.setStretchAllColumns(false);
            charSequence = TableLayoutBindingAdapter.parseColumns(charSequence);
            n11 = charSequence.size();
            for (int i10 = 0; i10 < n11; ++i10) {
                n10 = charSequence.keyAt(i10);
                boolean bl3 = charSequence.valueAt(i10);
                if (!bl3) continue;
                tableLayout.setColumnStretchable(n10, bl3);
            }
        }
    }
}

