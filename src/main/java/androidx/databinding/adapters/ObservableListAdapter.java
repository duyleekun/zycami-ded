/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 *  android.widget.TextView
 */
package androidx.databinding.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableList$OnListChangedCallback;
import androidx.databinding.adapters.ObservableListAdapter$1;
import java.util.List;

public class ObservableListAdapter
extends BaseAdapter {
    private final Context mContext;
    private final int mDropDownResourceId;
    private final LayoutInflater mLayoutInflater;
    private List mList;
    private ObservableList$OnListChangedCallback mListChangedCallback;
    private final int mResourceId;
    private final int mTextViewResourceId;

    public ObservableListAdapter(Context context, List list, int n10, int n11, int n12) {
        this.mContext = context;
        this.mResourceId = n10;
        this.mDropDownResourceId = n11;
        this.mTextViewResourceId = n12;
        if (n10 == 0) {
            context = null;
        } else {
            String string2 = "layout_inflater";
            context = (LayoutInflater)context.getSystemService(string2);
        }
        this.mLayoutInflater = context;
        this.setList(list);
    }

    public int getCount() {
        return this.mList.size();
    }

    public View getDropDownView(int n10, View view, ViewGroup viewGroup) {
        int n11 = this.mDropDownResourceId;
        return this.getViewForResource(n11, n10, view, viewGroup);
    }

    public Object getItem(int n10) {
        return this.mList.get(n10);
    }

    public long getItemId(int n10) {
        return n10;
    }

    public View getView(int n10, View view, ViewGroup viewGroup) {
        int n11 = this.mResourceId;
        return this.getViewForResource(n11, n10, view, viewGroup);
    }

    public View getViewForResource(int n10, int n11, View view, ViewGroup object) {
        Context context;
        if (view == null) {
            if (n10 == 0) {
                context = this.mContext;
                view = new TextView(context);
            } else {
                view = this.mLayoutInflater.inflate(n10, (ViewGroup)object, false);
            }
        }
        context = (n10 = this.mTextViewResourceId) == 0 ? view : view.findViewById(n10);
        context = (TextView)context;
        object = this.mList;
        Object object2 = object.get(n11);
        boolean bl2 = object2 instanceof CharSequence;
        object2 = bl2 ? (CharSequence)object2 : String.valueOf(object2);
        context.setText(object2);
        return view;
    }

    public void setList(List object) {
        Object object2 = this.mList;
        if (object2 == object) {
            return;
        }
        boolean bl2 = object2 instanceof ObservableList;
        if (bl2) {
            object2 = (ObservableList)object2;
            ObservableList$OnListChangedCallback observableList$OnListChangedCallback = this.mListChangedCallback;
            object2.removeOnListChangedCallback(observableList$OnListChangedCallback);
        }
        this.mList = object;
        boolean bl3 = object instanceof ObservableList;
        if (bl3) {
            object = this.mListChangedCallback;
            if (object == null) {
                this.mListChangedCallback = object = new ObservableListAdapter$1(this);
            }
            object = (ObservableList)this.mList;
            object2 = this.mListChangedCallback;
            object.addOnListChangedCallback((ObservableList$OnListChangedCallback)object2);
        }
        this.notifyDataSetChanged();
    }
}

