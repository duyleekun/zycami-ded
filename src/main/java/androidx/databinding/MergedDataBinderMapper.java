/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 */
package androidx.databinding;

import android.util.Log;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MergedDataBinderMapper
extends DataBinderMapper {
    private static final String TAG = "MergedDataBinderMapper";
    private Set mExistingMappers;
    private List mFeatureBindingMappers;
    private List mMappers;

    public MergedDataBinderMapper() {
        Cloneable cloneable;
        this.mExistingMappers = cloneable = new Cloneable();
        this.mMappers = cloneable;
        super();
        this.mFeatureBindingMappers = cloneable;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean loadFeatures() {
        boolean bl3;
        String string2 = "unable to add feature mapper for ";
        String string3 = TAG;
        Iterator iterator2 = this.mFeatureBindingMappers.iterator();
        boolean bl2 = false;
        while (bl3 = iterator2.hasNext()) {
            String string4 = (String)iterator2.next();
            Object object = Class.forName(string4);
            Object object2 = DataBinderMapper.class;
            boolean bl4 = ((Class)object2).isAssignableFrom((Class<?>)object);
            if (!bl4) continue;
            object = ((Class)object).newInstance();
            object = (DataBinderMapper)object;
            this.addMapper((DataBinderMapper)object);
            object = this.mFeatureBindingMappers;
            try {
                object.remove(string4);
                bl2 = true;
            }
            catch (InstantiationException instantiationException) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(string4);
                string4 = ((StringBuilder)object2).toString();
                Log.e((String)string3, (String)string4, (Throwable)instantiationException);
            }
            catch (IllegalAccessException illegalAccessException) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(string4);
                string4 = ((StringBuilder)object2).toString();
                Log.e((String)string3, (String)string4, (Throwable)illegalAccessException);
            }
            catch (ClassNotFoundException classNotFoundException) {
            }
        }
        return bl2;
    }

    public void addMapper(DataBinderMapper object) {
        Set set = this.mExistingMappers;
        Class<?> clazz = object.getClass();
        boolean bl2 = set.add(clazz);
        if (bl2) {
            clazz = this.mMappers;
            clazz.add(object);
            object = ((DataBinderMapper)object).collectDependencies().iterator();
            while (bl2 = object.hasNext()) {
                clazz = (DataBinderMapper)object.next();
                this.addMapper((DataBinderMapper)((Object)clazz));
            }
        }
    }

    public void addMapper(String string2) {
        List list = this.mFeatureBindingMappers;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(".DataBinderMapperImpl");
        string2 = stringBuilder.toString();
        list.add(string2);
    }

    public String convertBrIdToString(int n10) {
        boolean bl2;
        Iterator iterator2 = this.mMappers.iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = ((DataBinderMapper)iterator2.next()).convertBrIdToString(n10);
            if (string2 == null) continue;
            return string2;
        }
        boolean bl3 = this.loadFeatures();
        if (bl3) {
            return this.convertBrIdToString(n10);
        }
        return null;
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int n10) {
        boolean bl2;
        Iterator iterator2 = this.mMappers.iterator();
        while (bl2 = iterator2.hasNext()) {
            ViewDataBinding viewDataBinding = ((DataBinderMapper)iterator2.next()).getDataBinder(dataBindingComponent, view, n10);
            if (viewDataBinding == null) continue;
            return viewDataBinding;
        }
        boolean bl3 = this.loadFeatures();
        if (bl3) {
            return this.getDataBinder(dataBindingComponent, view, n10);
        }
        return null;
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArray, int n10) {
        boolean bl2;
        Iterator iterator2 = this.mMappers.iterator();
        while (bl2 = iterator2.hasNext()) {
            ViewDataBinding viewDataBinding = ((DataBinderMapper)iterator2.next()).getDataBinder(dataBindingComponent, viewArray, n10);
            if (viewDataBinding == null) continue;
            return viewDataBinding;
        }
        boolean bl3 = this.loadFeatures();
        if (bl3) {
            return this.getDataBinder(dataBindingComponent, viewArray, n10);
        }
        return null;
    }

    public int getLayoutId(String string2) {
        int n10;
        Iterator iterator2 = this.mMappers.iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            DataBinderMapper dataBinderMapper = (DataBinderMapper)iterator2.next();
            n10 = dataBinderMapper.getLayoutId(string2);
            if (n10 == 0) continue;
            return n10;
        }
        boolean bl2 = this.loadFeatures();
        if (bl2) {
            return this.getLayoutId(string2);
        }
        return 0;
    }
}

