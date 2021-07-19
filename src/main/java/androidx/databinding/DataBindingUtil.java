/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.databinding;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBinderMapperImpl;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

public class DataBindingUtil {
    private static DataBindingComponent sDefaultComponent;
    private static DataBinderMapper sMapper;

    static {
        DataBinderMapperImpl dataBinderMapperImpl = new DataBinderMapperImpl();
        sMapper = dataBinderMapperImpl;
        sDefaultComponent = null;
    }

    private DataBindingUtil() {
    }

    public static ViewDataBinding bind(View view) {
        DataBindingComponent dataBindingComponent = sDefaultComponent;
        return DataBindingUtil.bind(view, dataBindingComponent);
    }

    public static ViewDataBinding bind(View object, DataBindingComponent object2) {
        Object object3 = DataBindingUtil.getBinding(object);
        if (object3 != null) {
            return object3;
        }
        object3 = object.getTag();
        int n10 = object3 instanceof String;
        if (n10 != 0) {
            Object object4 = object3;
            DataBinderMapper dataBinderMapper = sMapper;
            object4 = (String)object3;
            n10 = dataBinderMapper.getLayoutId((String)object4);
            if (n10 != 0) {
                return sMapper.getDataBinder((DataBindingComponent)object2, (View)object, n10);
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("View is not a binding layout. Tag: ");
            ((StringBuilder)object2).append(object3);
            object2 = ((StringBuilder)object2).toString();
            object = new IllegalArgumentException((String)object2);
            throw object;
        }
        object = new IllegalArgumentException("View is not a binding layout");
        throw object;
    }

    public static ViewDataBinding bind(DataBindingComponent dataBindingComponent, View view, int n10) {
        return sMapper.getDataBinder(dataBindingComponent, view, n10);
    }

    public static ViewDataBinding bind(DataBindingComponent dataBindingComponent, View[] viewArray, int n10) {
        return sMapper.getDataBinder(dataBindingComponent, viewArray, n10);
    }

    private static ViewDataBinding bindToAddedViews(DataBindingComponent dataBindingComponent, ViewGroup viewGroup, int n10, int n11) {
        int n12;
        int n13 = viewGroup.getChildCount();
        int n14 = n13 - n10;
        if (n14 == (n12 = 1)) {
            viewGroup = viewGroup.getChildAt(n13 -= n12);
            return DataBindingUtil.bind(dataBindingComponent, (View)viewGroup, n11);
        }
        View[] viewArray = new View[n14];
        for (n12 = 0; n12 < n14; ++n12) {
            View view;
            int n15 = n12 + n10;
            viewArray[n12] = view = viewGroup.getChildAt(n15);
        }
        return DataBindingUtil.bind(dataBindingComponent, viewArray, n11);
    }

    public static String convertBrIdToString(int n10) {
        return sMapper.convertBrIdToString(n10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static ViewDataBinding findBinding(View view) {
        while (true) {
            int n10;
            block7: {
                boolean bl2;
                block11: {
                    boolean bl3;
                    block10: {
                        block9: {
                            int n11;
                            int n12;
                            char c10;
                            char c11;
                            Object object;
                            block8: {
                                String string2;
                                if (view == null) {
                                    return null;
                                }
                                object = ViewDataBinding.getBinding(view);
                                if (object != null) {
                                    return object;
                                }
                                object = view.getTag();
                                c11 = object instanceof String;
                                if (c11 == '\u0000' || (c11 = ((String)(object = (String)object)).startsWith(string2 = "layout")) == '\u0000' || (c11 = ((String)object).endsWith(string2 = "_0")) == '\u0000') break block7;
                                c11 = ((String)object).charAt(6);
                                c10 = '/';
                                n12 = ((String)object).indexOf(c10, 7);
                                bl3 = true;
                                n11 = -1;
                                bl2 = false;
                                if (c11 != c10) break block8;
                                if (n12 != n11) break block9;
                                break block10;
                            }
                            char c12 = '-';
                            if (c11 != c12 || n12 == n11) break block11;
                            if ((n10 = ((String)object).indexOf(c10, ++n12)) == n11) break block10;
                        }
                        bl3 = false;
                    }
                    bl2 = bl3;
                }
                if (bl2) {
                    return null;
                }
            }
            if ((n10 = (view = view.getParent()) instanceof View) == 0) return null;
        }
    }

    public static ViewDataBinding getBinding(View view) {
        return ViewDataBinding.getBinding(view);
    }

    public static DataBindingComponent getDefaultComponent() {
        return sDefaultComponent;
    }

    public static ViewDataBinding inflate(LayoutInflater layoutInflater, int n10, ViewGroup viewGroup, boolean bl2) {
        DataBindingComponent dataBindingComponent = sDefaultComponent;
        return DataBindingUtil.inflate(layoutInflater, n10, viewGroup, bl2, dataBindingComponent);
    }

    public static ViewDataBinding inflate(LayoutInflater layoutInflater, int n10, ViewGroup viewGroup, boolean bl2, DataBindingComponent dataBindingComponent) {
        int n11 = 0;
        boolean bl3 = viewGroup != null && bl2;
        if (bl3) {
            n11 = viewGroup.getChildCount();
        }
        layoutInflater = layoutInflater.inflate(n10, viewGroup, bl2);
        if (bl3) {
            return DataBindingUtil.bindToAddedViews(dataBindingComponent, viewGroup, n11, n10);
        }
        return DataBindingUtil.bind(dataBindingComponent, (View)layoutInflater, n10);
    }

    public static ViewDataBinding setContentView(Activity activity, int n10) {
        DataBindingComponent dataBindingComponent = sDefaultComponent;
        return DataBindingUtil.setContentView(activity, n10, dataBindingComponent);
    }

    public static ViewDataBinding setContentView(Activity activity, int n10, DataBindingComponent dataBindingComponent) {
        activity.setContentView(n10);
        activity = (ViewGroup)activity.getWindow().getDecorView().findViewById(0x1020002);
        return DataBindingUtil.bindToAddedViews(dataBindingComponent, (ViewGroup)activity, 0, n10);
    }

    public static void setDefaultComponent(DataBindingComponent dataBindingComponent) {
        sDefaultComponent = dataBindingComponent;
    }
}

