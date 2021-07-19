/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.Adapter
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemSelectedListener
 */
package androidx.databinding.adapters;

import android.widget.Adapter;
import android.widget.AdapterView;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.adapters.AdapterViewBindingAdapter$OnItemSelected;
import androidx.databinding.adapters.AdapterViewBindingAdapter$OnItemSelectedComponentListener;
import androidx.databinding.adapters.AdapterViewBindingAdapter$OnNothingSelected;

public class AdapterViewBindingAdapter {
    public static void setOnItemSelectedListener(AdapterView adapterView, AdapterViewBindingAdapter$OnItemSelected adapterViewBindingAdapter$OnItemSelected, AdapterViewBindingAdapter$OnNothingSelected adapterViewBindingAdapter$OnNothingSelected, InverseBindingListener inverseBindingListener) {
        if (adapterViewBindingAdapter$OnItemSelected == null && adapterViewBindingAdapter$OnNothingSelected == null && inverseBindingListener == null) {
            adapterViewBindingAdapter$OnItemSelected = null;
            adapterView.setOnItemSelectedListener(null);
        } else {
            AdapterViewBindingAdapter$OnItemSelectedComponentListener adapterViewBindingAdapter$OnItemSelectedComponentListener = new AdapterViewBindingAdapter$OnItemSelectedComponentListener(adapterViewBindingAdapter$OnItemSelected, adapterViewBindingAdapter$OnNothingSelected, inverseBindingListener);
            adapterView.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)adapterViewBindingAdapter$OnItemSelectedComponentListener);
        }
    }

    public static void setSelectedItemPosition(AdapterView adapterView, int n10) {
        int n11 = adapterView.getSelectedItemPosition();
        if (n11 != n10) {
            adapterView.setSelection(n10);
        }
    }

    public static void setSelectedItemPosition(AdapterView adapterView, int n10, Adapter adapter) {
        Adapter adapter2 = adapterView.getAdapter();
        if (adapter != adapter2) {
            adapterView.setAdapter(adapter);
            adapterView.setSelection(n10);
        } else {
            int n11 = adapterView.getSelectedItemPosition();
            if (n11 != n10) {
                adapterView.setSelection(n10);
            }
        }
    }

    public static void setSelection(AdapterView adapterView, int n10) {
        AdapterViewBindingAdapter.setSelectedItemPosition(adapterView, n10);
    }

    public static void setSelection(AdapterView adapterView, int n10, Adapter adapter) {
        AdapterViewBindingAdapter.setSelectedItemPosition(adapterView, n10, adapter);
    }
}

