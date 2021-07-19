/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemSelectedListener
 */
package androidx.databinding.adapters;

import android.view.View;
import android.widget.AdapterView;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.adapters.AdapterViewBindingAdapter$OnItemSelected;
import androidx.databinding.adapters.AdapterViewBindingAdapter$OnNothingSelected;

public class AdapterViewBindingAdapter$OnItemSelectedComponentListener
implements AdapterView.OnItemSelectedListener {
    private final InverseBindingListener mAttrChanged;
    private final AdapterViewBindingAdapter$OnNothingSelected mNothingSelected;
    private final AdapterViewBindingAdapter$OnItemSelected mSelected;

    public AdapterViewBindingAdapter$OnItemSelectedComponentListener(AdapterViewBindingAdapter$OnItemSelected adapterViewBindingAdapter$OnItemSelected, AdapterViewBindingAdapter$OnNothingSelected onNothingSelected, InverseBindingListener inverseBindingListener) {
        this.mSelected = adapterViewBindingAdapter$OnItemSelected;
        this.mNothingSelected = onNothingSelected;
        this.mAttrChanged = inverseBindingListener;
    }

    public void onItemSelected(AdapterView object, View view, int n10, long l10) {
        AdapterViewBindingAdapter$OnItemSelected adapterViewBindingAdapter$OnItemSelected = this.mSelected;
        if (adapterViewBindingAdapter$OnItemSelected != null) {
            adapterViewBindingAdapter$OnItemSelected.onItemSelected((AdapterView)object, view, n10, l10);
        }
        if ((object = this.mAttrChanged) != null) {
            object.onChange();
        }
    }

    public void onNothingSelected(AdapterView object) {
        AdapterViewBindingAdapter$OnNothingSelected adapterViewBindingAdapter$OnNothingSelected = this.mNothingSelected;
        if (adapterViewBindingAdapter$OnNothingSelected != null) {
            adapterViewBindingAdapter$OnNothingSelected.onNothingSelected((AdapterView)object);
        }
        if ((object = this.mAttrChanged) != null) {
            object.onChange();
        }
    }
}

