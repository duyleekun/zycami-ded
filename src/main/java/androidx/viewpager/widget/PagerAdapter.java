/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObservable
 *  android.database.DataSetObserver
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class PagerAdapter {
    public static final int POSITION_NONE = 254;
    public static final int POSITION_UNCHANGED = 255;
    private final DataSetObservable mObservable;
    private DataSetObserver mViewPagerObserver;

    public PagerAdapter() {
        DataSetObservable dataSetObservable;
        this.mObservable = dataSetObservable = new DataSetObservable();
    }

    public void destroyItem(View object, int n10, Object object2) {
        object = new UnsupportedOperationException("Required method destroyItem was not overridden");
        throw object;
    }

    public void destroyItem(ViewGroup viewGroup, int n10, Object object) {
        this.destroyItem((View)viewGroup, n10, object);
    }

    public void finishUpdate(View view) {
    }

    public void finishUpdate(ViewGroup viewGroup) {
        this.finishUpdate((View)viewGroup);
    }

    public abstract int getCount();

    public int getItemPosition(Object object) {
        return -1;
    }

    public CharSequence getPageTitle(int n10) {
        return null;
    }

    public float getPageWidth(int n10) {
        return 1.0f;
    }

    public Object instantiateItem(View object, int n10) {
        object = new UnsupportedOperationException("Required method instantiateItem was not overridden");
        throw object;
    }

    public Object instantiateItem(ViewGroup viewGroup, int n10) {
        return this.instantiateItem((View)viewGroup, n10);
    }

    public abstract boolean isViewFromObject(View var1, Object var2);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void notifyDataSetChanged() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.mViewPagerObserver;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.mObservable.notifyChanged();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mObservable.registerObserver((Object)dataSetObserver);
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(View view, int n10, Object object) {
    }

    public void setPrimaryItem(ViewGroup viewGroup, int n10, Object object) {
        this.setPrimaryItem((View)viewGroup, n10, object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setViewPagerObserver(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.mViewPagerObserver = dataSetObserver;
            return;
        }
    }

    public void startUpdate(View view) {
    }

    public void startUpdate(ViewGroup viewGroup) {
        this.startUpdate((View)viewGroup);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mObservable.unregisterObserver((Object)dataSetObserver);
    }
}

