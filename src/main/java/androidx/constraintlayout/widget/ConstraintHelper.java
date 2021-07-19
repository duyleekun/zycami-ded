/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.graphics.Canvas
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.ViewParent
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.constraintlayout.widget.ConstraintSet$Constraint;
import androidx.constraintlayout.widget.ConstraintSet$Layout;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;

public abstract class ConstraintHelper
extends View {
    public int mCount;
    public Helper mHelperWidget;
    public int[] mIds;
    private HashMap mMap;
    public String mReferenceIds;
    public String mReferenceTags;
    public boolean mUseViewMeasure;
    private View[] mViews;
    public Context myContext;

    public ConstraintHelper(Context context) {
        super(context);
        HashMap hashMap;
        int[] nArray = new int[32];
        this.mIds = nArray;
        this.mUseViewMeasure = false;
        this.mViews = null;
        this.mMap = hashMap = new HashMap();
        this.myContext = context;
        this.init(null);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Object object = new int[32];
        this.mIds = object;
        this.mUseViewMeasure = false;
        this.mViews = null;
        object = new HashMap;
        super();
        this.mMap = object;
        this.myContext = context;
        this.init(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        Object object = new int[32];
        this.mIds = object;
        this.mUseViewMeasure = false;
        this.mViews = null;
        object = new HashMap;
        super();
        this.mMap = object;
        this.myContext = context;
        this.init(attributeSet);
    }

    private void addID(String string2) {
        int n10;
        if (string2 != null && (n10 = string2.length()) != 0) {
            Object object = this.myContext;
            if (object == null) {
                return;
            }
            string2 = string2.trim();
            object = this.getParent();
            n10 = object instanceof ConstraintLayout;
            if (n10 != 0) {
                object = (ConstraintLayout)this.getParent();
            }
            if ((n10 = this.findId(string2)) != 0) {
                HashMap hashMap = this.mMap;
                Integer n11 = n10;
                hashMap.put(n11, string2);
                this.addRscID(n10);
            } else {
                object = new StringBuilder();
                String string3 = "Could not find id of \"";
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append("\"");
                string2 = ((StringBuilder)object).toString();
                object = "ConstraintHelper";
                Log.w((String)object, (String)string2);
            }
        }
    }

    private void addRscID(int n10) {
        int[] nArray;
        int n11 = this.getId();
        if (n10 == n11) {
            return;
        }
        n11 = this.mCount + 1;
        int[] nArray2 = this.mIds;
        int n12 = nArray2.length;
        if (n11 > n12) {
            n11 = nArray2.length * 2;
            this.mIds = nArray = Arrays.copyOf(nArray2, n11);
        }
        nArray = this.mIds;
        int n13 = this.mCount;
        nArray[n13] = n10;
        this.mCount = ++n13;
    }

    private void addTag(String string2) {
        int n10;
        if (string2 != null && (n10 = string2.length()) != 0) {
            Object object = this.myContext;
            if (object == null) {
                return;
            }
            string2 = string2.trim();
            n10 = 0;
            object = null;
            Object object2 = this.getParent();
            boolean bl2 = object2 instanceof ConstraintLayout;
            if (bl2) {
                object = (ConstraintLayout)this.getParent();
            }
            object2 = "ConstraintHelper";
            if (object == null) {
                Log.w((String)object2, (String)"Parent not a ConstraintLayout");
                return;
            }
            int n11 = object.getChildCount();
            for (int i10 = 0; i10 < n11; ++i10) {
                int n12;
                Object object3 = object.getChildAt(i10);
                Object object4 = object3.getLayoutParams();
                int n13 = object4 instanceof ConstraintLayout$LayoutParams;
                if (n13 == 0 || (n12 = string2.equals(object4 = ((ConstraintLayout$LayoutParams)object4).constraintTag)) == 0) continue;
                n12 = object3.getId();
                if (n12 == (n13 = -1)) {
                    object4 = new StringBuilder();
                    String string3 = "to use ConstraintTag view ";
                    ((StringBuilder)object4).append(string3);
                    object3 = object3.getClass().getSimpleName();
                    ((StringBuilder)object4).append((String)object3);
                    ((StringBuilder)object4).append(" must have an ID");
                    object3 = ((StringBuilder)object4).toString();
                    Log.w((String)object2, (String)object3);
                    continue;
                }
                int n14 = object3.getId();
                this.addRscID(n14);
            }
        }
    }

    private int[] convertReferenceString(View object, String stringArray) {
        int n10;
        stringArray = stringArray.split(",");
        object.getContext();
        int n11 = stringArray.length;
        object = new int[n11];
        int n12 = 0;
        for (int i10 = 0; i10 < (n10 = stringArray.length); ++i10) {
            String string2 = stringArray[i10].trim();
            n10 = this.findId(string2);
            if (n10 == 0) continue;
            int n13 = n12 + 1;
            object[n12] = (View)n10;
            n12 = n13;
        }
        int n14 = stringArray.length;
        if (n12 != n14) {
            object = Arrays.copyOf((int[])object, n12);
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int findId(ConstraintLayout constraintLayout, String string2) {
        if (string2 == null) return 0;
        if (constraintLayout == null) {
            return 0;
        }
        Resources resources = this.myContext.getResources();
        if (resources == null) {
            return 0;
        }
        int n10 = constraintLayout.getChildCount();
        int n11 = 0;
        while (n11 < n10) {
            int n12;
            View view = constraintLayout.getChildAt(n11);
            int n13 = view.getId();
            if (n13 != (n12 = -1)) {
                n13 = 0;
                String string3 = null;
                try {
                    n12 = view.getId();
                    string3 = resources.getResourceEntryName(n12);
                }
                catch (Resources.NotFoundException notFoundException) {}
                if ((n13 = (int)(string2.equals(string3) ? 1 : 0)) != 0) {
                    return view.getId();
                }
            }
            ++n11;
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int findId(String string2) {
        Object object;
        boolean bl2;
        Object object2 = this.getParent();
        boolean bl3 = object2 instanceof ConstraintLayout;
        String string3 = null;
        if (bl3) {
            object2 = (ConstraintLayout)this.getParent();
        } else {
            bl3 = false;
            object2 = null;
        }
        boolean bl4 = this.isInEditMode();
        int n10 = 0;
        if (bl4 && object2 != null && (bl2 = (object = ((ConstraintLayout)((Object)object2)).getDesignInformation(0, string2)) instanceof Integer)) {
            object = (Integer)object;
            n10 = (Integer)object;
        }
        if (n10 == 0 && object2 != null) {
            n10 = this.findId((ConstraintLayout)((Object)object2), string2);
        }
        if (n10 == 0) {
            object2 = R$id.class;
            try {
                object2 = ((Class)object2).getField(string2);
                n10 = ((Field)object2).getInt(null);
            }
            catch (Exception exception) {}
        }
        if (n10 != 0) return n10;
        object2 = this.myContext.getResources();
        string3 = this.myContext.getPackageName();
        object = "id";
        return object2.getIdentifier(string2, (String)object, string3);
    }

    public void addView(View view) {
        if (view == this) {
            return;
        }
        int n10 = view.getId();
        int n11 = -1;
        String string2 = "ConstraintHelper";
        if (n10 == n11) {
            Log.e((String)string2, (String)"Views added to a ConstraintHelper need to have an id");
            return;
        }
        ViewParent viewParent = view.getParent();
        if (viewParent == null) {
            Log.e((String)string2, (String)"Views added to a ConstraintHelper need to have a parent");
            return;
        }
        this.mReferenceIds = null;
        int n12 = view.getId();
        this.addRscID(n12);
        this.requestLayout();
    }

    public void applyLayoutFeatures() {
        boolean bl2;
        Object object = this.getParent();
        if (object != null && (bl2 = object instanceof ConstraintLayout)) {
            object = (ConstraintLayout)((Object)object);
            this.applyLayoutFeatures((ConstraintLayout)((Object)object));
        }
    }

    public void applyLayoutFeatures(ConstraintLayout constraintLayout) {
        int n10;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = this.getVisibility();
        int n13 = 21;
        float f10 = n11 >= n13 ? this.getElevation() : 0.0f;
        for (int i10 = 0; i10 < (n10 = this.mCount); ++i10) {
            n10 = this.mIds[i10];
            View view = constraintLayout.getViewById(n10);
            if (view == null) continue;
            view.setVisibility(n12);
            float f11 = f10 - 0.0f;
            float f12 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
            if (f12 <= 0 || n11 < n13) continue;
            float f13 = view.getTranslationZ() + f10;
            view.setTranslationZ(f13);
        }
    }

    public int[] getReferencedIds() {
        int[] nArray = this.mIds;
        int n10 = this.mCount;
        return Arrays.copyOf(nArray, n10);
    }

    public View[] getViews(ConstraintLayout constraintLayout) {
        int n10;
        int n11;
        View[] viewArray = this.mViews;
        if (viewArray == null || (n11 = viewArray.length) != (n10 = this.mCount)) {
            n11 = this.mCount;
            this.mViews = viewArray = new View[n11];
        }
        viewArray = null;
        for (n11 = 0; n11 < (n10 = this.mCount); ++n11) {
            View view;
            n10 = this.mIds[n11];
            View[] viewArray2 = this.mViews;
            viewArray2[n11] = view = constraintLayout.getViewById(n10);
        }
        return this.mViews;
    }

    public void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            Context context = this.getContext();
            int[] nArray = R$styleable.ConstraintLayout_Layout;
            attributeSet = context.obtainStyledAttributes(attributeSet, nArray);
            int n10 = attributeSet.getIndexCount();
            nArray = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                String string2;
                int n11;
                int n12 = attributeSet.getIndex(i10);
                if (n12 == (n11 = R$styleable.ConstraintLayout_Layout_constraint_referenced_ids)) {
                    this.mReferenceIds = string2 = attributeSet.getString(n12);
                    this.setIds(string2);
                    continue;
                }
                n11 = R$styleable.ConstraintLayout_Layout_constraint_referenced_tags;
                if (n12 != n11) continue;
                this.mReferenceTags = string2 = attributeSet.getString(n12);
                this.setReferenceTags(string2);
            }
            attributeSet.recycle();
        }
    }

    public void loadParameters(ConstraintSet$Constraint constraintSet$Constraint, HelperWidget helperWidget, ConstraintLayout$LayoutParams object, SparseArray sparseArray) {
        int n10;
        object = constraintSet$Constraint.layout;
        Object object2 = ((ConstraintSet$Layout)object).mReferenceIds;
        if (object2 != null) {
            this.setReferencedIds((int[])object2);
        } else {
            object = ((ConstraintSet$Layout)object).mReferenceIdString;
            if (object != null && (n10 = ((String)object).length()) > 0) {
                object = constraintSet$Constraint.layout;
                object2 = ((ConstraintSet$Layout)object).mReferenceIdString;
                ((ConstraintSet$Layout)object).mReferenceIds = object2 = this.convertReferenceString(this, (String)object2);
            }
        }
        helperWidget.removeAllIds();
        object = constraintSet$Constraint.layout.mReferenceIds;
        if (object != null) {
            int n11;
            object = null;
            for (n10 = 0; n10 < (n11 = ((int[])(object2 = constraintSet$Constraint.layout.mReferenceIds)).length); ++n10) {
                int n12 = object2[n10];
                if ((object2 = (Object)((ConstraintWidget)sparseArray.get(n12))) == null) continue;
                helperWidget.add((ConstraintWidget)object2);
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String string2 = this.mReferenceIds;
        if (string2 != null) {
            this.setIds(string2);
        }
        if ((string2 = this.mReferenceTags) != null) {
            this.setReferenceTags(string2);
        }
    }

    public void onDraw(Canvas canvas) {
    }

    public void onMeasure(int n10, int n11) {
        boolean bl2 = this.mUseViewMeasure;
        if (bl2) {
            super.onMeasure(n10, n11);
        } else {
            n10 = 0;
            this.setMeasuredDimension(0, 0);
        }
    }

    public void removeView(View object) {
        int n10;
        int n11;
        int n12 = object.getId();
        if (n12 == (n11 = -1)) {
            return;
        }
        this.mReferenceIds = null;
        n11 = 0;
        int[] nArray = null;
        for (int i10 = 0; i10 < (n10 = this.mCount); ++i10) {
            int[] nArray2 = this.mIds;
            n10 = nArray2[i10];
            if (n10 != n12) continue;
            while (i10 < (n10 = (n12 = this.mCount) + -1)) {
                View view;
                object = this.mIds;
                n10 = i10 + 1;
                object[i10] = view = object[n10];
                i10 = n10;
            }
            nArray = this.mIds;
            n10 = n12 + -1;
            nArray[n10] = 0;
            this.mCount = n12 += -1;
            break;
        }
        this.requestLayout();
    }

    public void resolveRtl(ConstraintWidget constraintWidget, boolean bl2) {
    }

    public void setIds(String string2) {
        this.mReferenceIds = string2;
        if (string2 == null) {
            return;
        }
        int n10 = 0;
        String string3 = null;
        this.mCount = 0;
        while (true) {
            int n11;
            int n12;
            if ((n12 = string2.indexOf(44, n10)) == (n11 = -1)) {
                string2 = string2.substring(n10);
                this.addID(string2);
                return;
            }
            string3 = string2.substring(n10, n12);
            this.addID(string3);
            n10 = n12 + 1;
        }
    }

    public void setReferenceTags(String string2) {
        this.mReferenceTags = string2;
        if (string2 == null) {
            return;
        }
        int n10 = 0;
        String string3 = null;
        this.mCount = 0;
        while (true) {
            int n11;
            int n12;
            if ((n12 = string2.indexOf(44, n10)) == (n11 = -1)) {
                string2 = string2.substring(n10);
                this.addTag(string2);
                return;
            }
            string3 = string2.substring(n10, n12);
            this.addTag(string3);
            n10 = n12 + 1;
        }
    }

    public void setReferencedIds(int[] nArray) {
        int n10;
        this.mReferenceIds = null;
        this.mCount = 0;
        for (int i10 = 0; i10 < (n10 = nArray.length); ++i10) {
            n10 = nArray[i10];
            this.addRscID(n10);
        }
    }

    public void setTag(int n10, Object object) {
        super.setTag(n10, object);
        if (object == null && (object = this.mReferenceIds) == null) {
            this.addRscID(n10);
        }
    }

    public void updatePostConstraints(ConstraintLayout constraintLayout) {
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
    }

    public void updatePreDraw(ConstraintLayout constraintLayout) {
    }

    public void updatePreLayout(ConstraintWidgetContainer constraintWidgetContainer, Helper helper, SparseArray sparseArray) {
        int n10;
        helper.removeAllIds();
        for (int i10 = 0; i10 < (n10 = this.mCount); ++i10) {
            n10 = this.mIds[i10];
            ConstraintWidget constraintWidget = (ConstraintWidget)sparseArray.get(n10);
            helper.add(constraintWidget);
        }
    }

    public void updatePreLayout(ConstraintLayout object) {
        int n10;
        Object object2;
        int n11 = this.isInEditMode();
        if (n11 != 0) {
            object2 = this.mReferenceIds;
            this.setIds((String)object2);
        }
        if ((object2 = this.mHelperWidget) == null) {
            return;
        }
        object2.removeAllIds();
        object2 = null;
        for (n11 = 0; n11 < (n10 = this.mCount); ++n11) {
            Object object3 = this.mIds;
            n10 = object3[n11];
            Object object4 = ((ConstraintLayout)((Object)object)).getViewById(n10);
            if (object4 == null) {
                HashMap hashMap = this.mMap;
                object3 = n10;
                int n12 = this.findId((ConstraintLayout)((Object)object), (String)(object3 = (Object)((String)hashMap.get(object3))));
                if (n12 != 0) {
                    this.mIds[n11] = n12;
                    object4 = this.mMap;
                    Integer n13 = n12;
                    ((HashMap)object4).put(n13, object3);
                    object4 = ((ConstraintLayout)((Object)object)).getViewById(n12);
                }
            }
            if (object4 == null) continue;
            object3 = this.mHelperWidget;
            object4 = ((ConstraintLayout)((Object)object)).getViewWidget((View)object4);
            object3.add((ConstraintWidget)object4);
        }
        object2 = this.mHelperWidget;
        object = ((ConstraintLayout)object).mLayoutWidget;
        object2.updateConstraints((ConstraintWidgetContainer)object);
    }

    public void validateParams() {
        Object object = this.mHelperWidget;
        if (object == null) {
            return;
        }
        object = this.getLayoutParams();
        boolean bl2 = object instanceof ConstraintLayout$LayoutParams;
        if (bl2) {
            ConstraintWidget constraintWidget;
            object = (ConstraintLayout$LayoutParams)((Object)object);
            ((ConstraintLayout$LayoutParams)object).widget = constraintWidget = (ConstraintWidget)((Object)this.mHelperWidget);
        }
    }
}

