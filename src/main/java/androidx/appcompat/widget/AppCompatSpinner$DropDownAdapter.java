/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources$Theme
 *  android.database.DataSetObserver
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ListAdapter
 *  android.widget.SpinnerAdapter
 *  android.widget.ThemedSpinnerAdapter
 */
package androidx.appcompat.widget;

import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import androidx.appcompat.widget.ThemedSpinnerAdapter;

public class AppCompatSpinner$DropDownAdapter
implements ListAdapter,
SpinnerAdapter {
    private SpinnerAdapter mAdapter;
    private ListAdapter mListAdapter;

    public AppCompatSpinner$DropDownAdapter(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
        SpinnerAdapter spinnerAdapter2;
        this.mAdapter = spinnerAdapter;
        int n10 = spinnerAdapter instanceof ListAdapter;
        if (n10 != 0) {
            spinnerAdapter2 = spinnerAdapter;
            spinnerAdapter2 = (ListAdapter)spinnerAdapter;
            this.mListAdapter = spinnerAdapter2;
        }
        if (theme != null) {
            n10 = Build.VERSION.SDK_INT;
            int n11 = 23;
            if (n10 >= n11 && (n10 = spinnerAdapter instanceof android.widget.ThemedSpinnerAdapter) != 0) {
                spinnerAdapter2 = (spinnerAdapter = (android.widget.ThemedSpinnerAdapter)spinnerAdapter).getDropDownViewTheme();
                if (spinnerAdapter2 != theme) {
                    spinnerAdapter.setDropDownViewTheme(theme);
                }
            } else {
                n10 = spinnerAdapter instanceof ThemedSpinnerAdapter;
                if (n10 != 0 && (spinnerAdapter2 = (spinnerAdapter = (ThemedSpinnerAdapter)spinnerAdapter).getDropDownViewTheme()) == null) {
                    spinnerAdapter.setDropDownViewTheme(theme);
                }
            }
        }
    }

    public boolean areAllItemsEnabled() {
        ListAdapter listAdapter = this.mListAdapter;
        if (listAdapter != null) {
            return listAdapter.areAllItemsEnabled();
        }
        return true;
    }

    public int getCount() {
        int n10;
        SpinnerAdapter spinnerAdapter = this.mAdapter;
        if (spinnerAdapter == null) {
            n10 = 0;
            spinnerAdapter = null;
        } else {
            n10 = spinnerAdapter.getCount();
        }
        return n10;
    }

    public View getDropDownView(int n10, View view, ViewGroup viewGroup) {
        View view2;
        SpinnerAdapter spinnerAdapter = this.mAdapter;
        if (spinnerAdapter == null) {
            n10 = 0;
            view2 = null;
        } else {
            view2 = spinnerAdapter.getDropDownView(n10, view, viewGroup);
        }
        return view2;
    }

    public Object getItem(int n10) {
        Object object;
        SpinnerAdapter spinnerAdapter = this.mAdapter;
        if (spinnerAdapter == null) {
            n10 = 0;
            object = null;
        } else {
            object = spinnerAdapter.getItem(n10);
        }
        return object;
    }

    public long getItemId(int n10) {
        SpinnerAdapter spinnerAdapter = this.mAdapter;
        long l10 = spinnerAdapter == null ? (long)-1 : spinnerAdapter.getItemId(n10);
        return l10;
    }

    public int getItemViewType(int n10) {
        return 0;
    }

    public View getView(int n10, View view, ViewGroup viewGroup) {
        return this.getDropDownView(n10, view, viewGroup);
    }

    public int getViewTypeCount() {
        return 1;
    }

    public boolean hasStableIds() {
        boolean bl2;
        SpinnerAdapter spinnerAdapter = this.mAdapter;
        if (spinnerAdapter != null && (bl2 = spinnerAdapter.hasStableIds())) {
            bl2 = true;
        } else {
            bl2 = false;
            spinnerAdapter = null;
        }
        return bl2;
    }

    public boolean isEmpty() {
        int n10 = this.getCount();
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isEnabled(int n10) {
        ListAdapter listAdapter = this.mListAdapter;
        if (listAdapter != null) {
            return listAdapter.isEnabled(n10);
        }
        return true;
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        SpinnerAdapter spinnerAdapter = this.mAdapter;
        if (spinnerAdapter != null) {
            spinnerAdapter.registerDataSetObserver(dataSetObserver);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        SpinnerAdapter spinnerAdapter = this.mAdapter;
        if (spinnerAdapter != null) {
            spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
        }
    }
}

