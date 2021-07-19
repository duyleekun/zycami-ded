/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.TextView
 *  androidx.constraintlayout.motion.widget.MotionController
 */
package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.solver.widgets.WidgetContainer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints$LayoutParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MotionLayout$Model {
    public ConstraintSet mEnd;
    public int mEndId;
    public ConstraintWidgetContainer mLayoutEnd;
    public ConstraintWidgetContainer mLayoutStart;
    public ConstraintSet mStart;
    public int mStartId;
    public final /* synthetic */ MotionLayout this$0;

    public MotionLayout$Model(MotionLayout object) {
        this.this$0 = object;
        this.mLayoutStart = object = new ConstraintWidgetContainer();
        this.mLayoutEnd = object = new ConstraintWidgetContainer();
        this.mStart = null;
        this.mEnd = null;
    }

    private void debugLayout(String charSequence, ConstraintWidgetContainer constraintWidgetContainer) {
        Object object = (View)constraintWidgetContainer.getCompanionWidget();
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)charSequence);
        charSequence = " ";
        ((StringBuilder)object2).append((String)charSequence);
        object = Debug.getName(object);
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("  ========= ");
        ((StringBuilder)object2).append(constraintWidgetContainer);
        object2 = ((StringBuilder)object2).toString();
        String string2 = "MotionLayout";
        Log.v((String)string2, (String)object2);
        object2 = constraintWidgetContainer.getChildren();
        int n10 = ((ArrayList)object2).size();
        for (int i10 = 0; i10 < n10; ++i10) {
            CharSequence charSequence2 = new StringBuilder();
            charSequence2.append((String)object);
            charSequence2.append("[");
            charSequence2.append(i10);
            charSequence2.append("] ");
            charSequence2 = charSequence2.toString();
            ConstraintWidget constraintWidget = (ConstraintWidget)constraintWidgetContainer.getChildren().get(i10);
            Object object3 = new StringBuilder();
            ((StringBuilder)object3).append("");
            Object object4 = constraintWidget.mTop.mTarget;
            String string3 = "_";
            object4 = object4 != null ? "T" : string3;
            ((StringBuilder)object3).append((String)object4);
            object3 = ((StringBuilder)object3).toString();
            object4 = new StringBuilder();
            ((StringBuilder)object4).append((String)object3);
            object3 = constraintWidget.mBottom.mTarget;
            object3 = object3 != null ? "B" : string3;
            ((StringBuilder)object4).append((String)object3);
            object3 = ((StringBuilder)object4).toString();
            object4 = new StringBuilder();
            ((StringBuilder)object4).append((String)object3);
            object3 = constraintWidget.mLeft.mTarget;
            object3 = object3 != null ? "L" : string3;
            ((StringBuilder)object4).append((String)object3);
            object3 = ((StringBuilder)object4).toString();
            object4 = new StringBuilder();
            ((StringBuilder)object4).append((String)object3);
            object3 = constraintWidget.mRight.mTarget;
            if (object3 != null) {
                string3 = "R";
            }
            ((StringBuilder)object4).append(string3);
            object3 = ((StringBuilder)object4).toString();
            object4 = (View)constraintWidget.getCompanionWidget();
            string3 = Debug.getName((View)object4);
            boolean bl2 = object4 instanceof TextView;
            if (bl2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                stringBuilder.append("(");
                object4 = ((TextView)object4).getText();
                stringBuilder.append(object4);
                object4 = ")";
                stringBuilder.append((String)object4);
                string3 = stringBuilder.toString();
            }
            object4 = new StringBuilder();
            ((StringBuilder)object4).append((String)charSequence2);
            ((StringBuilder)object4).append("  ");
            ((StringBuilder)object4).append(string3);
            ((StringBuilder)object4).append((String)charSequence);
            ((StringBuilder)object4).append(constraintWidget);
            ((StringBuilder)object4).append((String)charSequence);
            ((StringBuilder)object4).append((String)object3);
            charSequence2 = ((StringBuilder)object4).toString();
            Log.v((String)string2, (String)charSequence2);
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(" done. ");
        charSequence = ((StringBuilder)charSequence).toString();
        Log.v((String)string2, (String)charSequence);
    }

    private void debugLayoutParam(String string2, ConstraintLayout$LayoutParams object) {
        CharSequence charSequence = new StringBuilder();
        CharSequence charSequence2 = " ";
        ((StringBuilder)charSequence).append((String)charSequence2);
        int n10 = object.startToStart;
        int n11 = -1;
        charSequence2 = n10 != n11 ? "SS" : "__";
        ((StringBuilder)charSequence).append((String)charSequence2);
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append((String)charSequence);
        int n12 = object.startToEnd;
        String string3 = "|__";
        charSequence = n12 != n11 ? "|SE" : string3;
        ((StringBuilder)charSequence2).append((String)charSequence);
        charSequence = ((StringBuilder)charSequence2).toString();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append((String)charSequence);
        n12 = object.endToStart;
        charSequence = n12 != n11 ? "|ES" : string3;
        ((StringBuilder)charSequence2).append((String)charSequence);
        charSequence = ((StringBuilder)charSequence2).toString();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append((String)charSequence);
        n12 = object.endToEnd;
        charSequence = n12 != n11 ? "|EE" : string3;
        ((StringBuilder)charSequence2).append((String)charSequence);
        charSequence = ((StringBuilder)charSequence2).toString();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append((String)charSequence);
        n12 = object.leftToLeft;
        charSequence = n12 != n11 ? "|LL" : string3;
        ((StringBuilder)charSequence2).append((String)charSequence);
        charSequence = ((StringBuilder)charSequence2).toString();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append((String)charSequence);
        n12 = object.leftToRight;
        charSequence = n12 != n11 ? "|LR" : string3;
        ((StringBuilder)charSequence2).append((String)charSequence);
        charSequence = ((StringBuilder)charSequence2).toString();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append((String)charSequence);
        n12 = object.rightToLeft;
        charSequence = n12 != n11 ? "|RL" : string3;
        ((StringBuilder)charSequence2).append((String)charSequence);
        charSequence = ((StringBuilder)charSequence2).toString();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append((String)charSequence);
        n12 = object.rightToRight;
        charSequence = n12 != n11 ? "|RR" : string3;
        ((StringBuilder)charSequence2).append((String)charSequence);
        charSequence = ((StringBuilder)charSequence2).toString();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append((String)charSequence);
        n12 = object.topToTop;
        charSequence = n12 != n11 ? "|TT" : string3;
        ((StringBuilder)charSequence2).append((String)charSequence);
        charSequence = ((StringBuilder)charSequence2).toString();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append((String)charSequence);
        n12 = object.topToBottom;
        charSequence = n12 != n11 ? "|TB" : string3;
        ((StringBuilder)charSequence2).append((String)charSequence);
        charSequence = ((StringBuilder)charSequence2).toString();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append((String)charSequence);
        n12 = object.bottomToTop;
        charSequence = n12 != n11 ? "|BT" : string3;
        ((StringBuilder)charSequence2).append((String)charSequence);
        charSequence = ((StringBuilder)charSequence2).toString();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append((String)charSequence);
        int n13 = object.bottomToBottom;
        if (n13 != n11) {
            string3 = "|BB";
        }
        ((StringBuilder)charSequence2).append(string3);
        object = ((StringBuilder)charSequence2).toString();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append((String)object);
        string2 = ((StringBuilder)charSequence).toString();
        Log.v((String)"MotionLayout", (String)string2);
    }

    private void debugWidget(String string2, ConstraintWidget constraintWidget) {
        ConstraintAnchor$Type constraintAnchor$Type;
        Object object;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append(" ");
        Object object3 = constraintWidget.mTop.mTarget;
        String string3 = "B";
        String string4 = "T";
        Object object4 = "__";
        if (object3 != null) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append(string4);
            object = constraintWidget.mTop.mTarget.mType;
            constraintAnchor$Type = ConstraintAnchor$Type.TOP;
            object = object == constraintAnchor$Type ? string4 : string3;
            ((StringBuilder)object3).append((String)object);
            object3 = ((StringBuilder)object3).toString();
        } else {
            object3 = object4;
        }
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        object3 = new StringBuilder();
        ((StringBuilder)object3).append((String)object2);
        object2 = constraintWidget.mBottom.mTarget;
        if (object2 != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string3);
            object = constraintWidget.mBottom.mTarget.mType;
            constraintAnchor$Type = ConstraintAnchor$Type.TOP;
            if (object == constraintAnchor$Type) {
                string3 = string4;
            }
            ((StringBuilder)object2).append(string3);
            object2 = ((StringBuilder)object2).toString();
        } else {
            object2 = object4;
        }
        ((StringBuilder)object3).append((String)object2);
        object2 = ((StringBuilder)object3).toString();
        object3 = new StringBuilder();
        ((StringBuilder)object3).append((String)object2);
        object2 = constraintWidget.mLeft.mTarget;
        string3 = "R";
        string4 = "L";
        if (object2 != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string4);
            object = constraintWidget.mLeft.mTarget.mType;
            constraintAnchor$Type = ConstraintAnchor$Type.LEFT;
            object = object == constraintAnchor$Type ? string4 : string3;
            ((StringBuilder)object2).append((String)object);
            object2 = ((StringBuilder)object2).toString();
        } else {
            object2 = object4;
        }
        ((StringBuilder)object3).append((String)object2);
        object2 = ((StringBuilder)object3).toString();
        object3 = new StringBuilder();
        ((StringBuilder)object3).append((String)object2);
        object2 = constraintWidget.mRight.mTarget;
        if (object2 != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string3);
            object4 = constraintWidget.mRight.mTarget.mType;
            object = ConstraintAnchor$Type.LEFT;
            if (object4 == object) {
                string3 = string4;
            }
            ((StringBuilder)object2).append(string3);
            object4 = ((StringBuilder)object2).toString();
        }
        ((StringBuilder)object3).append((String)object4);
        object2 = ((StringBuilder)object3).toString();
        object3 = new StringBuilder();
        ((StringBuilder)object3).append(string2);
        ((StringBuilder)object3).append((String)object2);
        ((StringBuilder)object3).append(" ---  ");
        ((StringBuilder)object3).append(constraintWidget);
        string2 = ((StringBuilder)object3).toString();
        Log.v((String)"MotionLayout", (String)string2);
    }

    private void setupConstraintWidget(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet object) {
        Object object2;
        Object object3;
        int n10;
        SparseArray sparseArray = new SparseArray();
        int n11 = -2;
        Constraints$LayoutParams constraints$LayoutParams = new Constraints$LayoutParams(n11, n11);
        sparseArray.clear();
        sparseArray.put(0, (Object)constraintWidgetContainer);
        n11 = this.this$0.getId();
        sparseArray.put(n11, (Object)constraintWidgetContainer);
        Object object4 = constraintWidgetContainer.getChildren().iterator();
        while ((n10 = object4.hasNext()) != 0) {
            object3 = (ConstraintWidget)object4.next();
            object2 = (View)((ConstraintWidget)object3).getCompanionWidget();
            int n12 = object2.getId();
            sparseArray.put(n12, object3);
        }
        object4 = constraintWidgetContainer.getChildren();
        Iterator iterator2 = ((ArrayList)object4).iterator();
        while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            Object object5 = object4 = iterator2.next();
            object5 = (ConstraintWidget)object4;
            Object object6 = object4 = ((ConstraintWidget)object5).getCompanionWidget();
            object6 = (View)object4;
            n11 = object6.getId();
            ((ConstraintSet)object).applyToLayoutParams(n11, constraints$LayoutParams);
            n11 = object6.getId();
            n11 = ((ConstraintSet)object).getWidth(n11);
            ((ConstraintWidget)object5).setWidth(n11);
            n11 = object6.getId();
            n11 = ((ConstraintSet)object).getHeight(n11);
            ((ConstraintWidget)object5).setHeight(n11);
            n11 = object6 instanceof ConstraintHelper;
            if (n11 != 0) {
                object4 = object6;
                object4 = (ConstraintHelper)((Object)object6);
                ((ConstraintSet)object).applyToHelper((ConstraintHelper)((Object)object4), (ConstraintWidget)object5, constraints$LayoutParams, sparseArray);
                n11 = object6 instanceof Barrier;
                if (n11 != 0) {
                    object4 = object6;
                    object4 = (Barrier)((Object)object6);
                    ((ConstraintHelper)((Object)object4)).validateParams();
                }
            }
            if ((n11 = Build.VERSION.SDK_INT) >= (n10 = 17)) {
                object4 = this.this$0;
                n11 = object4.getLayoutDirection();
                constraints$LayoutParams.resolveLayoutDirection(n11);
            } else {
                constraints$LayoutParams.resolveLayoutDirection(0);
            }
            object4 = this.this$0;
            object3 = null;
            object2 = object6;
            MotionLayout.access$800((MotionLayout)object4, false, (View)object6, (ConstraintWidget)object5, constraints$LayoutParams, sparseArray);
            n11 = ((View)object6).getId();
            n11 = ((ConstraintSet)object).getVisibilityMode(n11);
            n10 = 1;
            if (n11 == n10) {
                n11 = ((View)object6).getVisibility();
                ((ConstraintWidget)object5).setVisibility(n11);
                continue;
            }
            n11 = ((View)object6).getId();
            n11 = ((ConstraintSet)object).getVisibility(n11);
            ((ConstraintWidget)object5).setVisibility(n11);
        }
        object = constraintWidgetContainer.getChildren().iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object4 = (ConstraintWidget)object.next();
            n10 = object4 instanceof VirtualLayout;
            if (n10 == 0) continue;
            object3 = (ConstraintHelper)((Object)((ConstraintWidget)object4).getCompanionWidget());
            object4 = (Helper)object4;
            ((ConstraintHelper)((Object)object3)).updatePreLayout(constraintWidgetContainer, (Helper)object4, sparseArray);
            object4 = (VirtualLayout)object4;
            ((VirtualLayout)object4).captureWidgets();
        }
    }

    public void build() {
        Object object;
        Object object2;
        Object object3;
        MotionLayout motionLayout = this.this$0;
        int n10 = motionLayout.getChildCount();
        this.this$0.mFrameArrayList.clear();
        int n11 = 0;
        Object object4 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            object3 = this.this$0.getChildAt(i10);
            object2 = new MotionController((View)object3);
            object = this.this$0.mFrameArrayList;
            ((HashMap)object).put(object3, object2);
        }
        while (n11 < n10) {
            object4 = this.this$0.getChildAt(n11);
            object3 = (MotionController)this.this$0.mFrameArrayList.get(object4);
            if (object3 != null) {
                object2 = this.mStart;
                object = ")";
                String string2 = " (";
                String string3 = "no widget for  ";
                String string4 = "MotionLayout";
                if (object2 != null) {
                    Object object5;
                    object2 = this.mLayoutStart;
                    if ((object2 = this.getWidget((ConstraintWidgetContainer)object2, (View)object4)) != null) {
                        object5 = this.mStart;
                        object3.setStartState((ConstraintWidget)object2, (ConstraintSet)object5);
                    } else {
                        object2 = this.this$0;
                        int n12 = ((MotionLayout)object2).mDebugPath;
                        if (n12 != 0) {
                            object2 = new StringBuilder();
                            object5 = Debug.getLocation();
                            ((StringBuilder)object2).append((String)object5);
                            ((StringBuilder)object2).append(string3);
                            object5 = Debug.getName((View)object4);
                            ((StringBuilder)object2).append((String)object5);
                            ((StringBuilder)object2).append(string2);
                            object5 = object4.getClass().getName();
                            ((StringBuilder)object2).append((String)object5);
                            ((StringBuilder)object2).append((String)object);
                            object2 = ((StringBuilder)object2).toString();
                            Log.e((String)string4, (String)object2);
                        }
                    }
                }
                if ((object2 = this.mEnd) != null) {
                    object2 = this.mLayoutEnd;
                    if ((object2 = this.getWidget((ConstraintWidgetContainer)object2, (View)object4)) != null) {
                        object4 = this.mEnd;
                        object3.setEndState((ConstraintWidget)object2, (ConstraintSet)object4);
                    } else {
                        object3 = this.this$0;
                        int n13 = ((MotionLayout)object3).mDebugPath;
                        if (n13 != 0) {
                            object3 = new StringBuilder();
                            object2 = Debug.getLocation();
                            ((StringBuilder)object3).append((String)object2);
                            ((StringBuilder)object3).append(string3);
                            object2 = Debug.getName((View)object4);
                            ((StringBuilder)object3).append((String)object2);
                            ((StringBuilder)object3).append(string2);
                            object4 = object4.getClass().getName();
                            ((StringBuilder)object3).append((String)object4);
                            ((StringBuilder)object3).append((String)object);
                            object4 = ((StringBuilder)object3).toString();
                            Log.e((String)string4, (String)object4);
                        }
                    }
                }
            }
            ++n11;
        }
    }

    public void copy(ConstraintWidgetContainer iterator2, ConstraintWidgetContainer constraintWidget) {
        boolean bl2;
        boolean bl3;
        Object object = ((WidgetContainer)((Object)iterator2)).getChildren();
        HashMap<Object, ConstraintWidget> hashMap = new HashMap<Object, ConstraintWidget>();
        hashMap.put(iterator2, constraintWidget);
        Object object2 = ((WidgetContainer)constraintWidget).getChildren();
        ((ArrayList)object2).clear();
        constraintWidget.copy((ConstraintWidget)((Object)iterator2), hashMap);
        iterator2 = ((ArrayList)object).iterator();
        while (bl3 = iterator2.hasNext()) {
            object2 = (ConstraintWidget)iterator2.next();
            boolean bl4 = object2 instanceof androidx.constraintlayout.solver.widgets.Barrier;
            ConstraintWidget constraintWidget2 = bl4 ? new androidx.constraintlayout.solver.widgets.Barrier() : ((bl4 = object2 instanceof Guideline) ? new Guideline() : ((bl4 = object2 instanceof Flow) ? new Flow() : ((bl4 = object2 instanceof Helper) ? new HelperWidget() : new ConstraintWidget())));
            ((WidgetContainer)constraintWidget).add(constraintWidget2);
            hashMap.put(object2, constraintWidget2);
        }
        iterator2 = ((ArrayList)object).iterator();
        while (bl2 = iterator2.hasNext()) {
            constraintWidget = (ConstraintWidget)iterator2.next();
            object = (ConstraintWidget)hashMap.get(constraintWidget);
            ((ConstraintWidget)object).copy(constraintWidget, hashMap);
        }
    }

    public ConstraintWidget getWidget(ConstraintWidgetContainer object, View view) {
        Object object2 = ((ConstraintWidget)object).getCompanionWidget();
        if (object2 == view) {
            return object;
        }
        object = ((WidgetContainer)object).getChildren();
        int n10 = ((ArrayList)object).size();
        for (int i10 = 0; i10 < n10; ++i10) {
            ConstraintWidget constraintWidget = (ConstraintWidget)((ArrayList)object).get(i10);
            Object object3 = constraintWidget.getCompanionWidget();
            if (object3 != view) continue;
            return constraintWidget;
        }
        return null;
    }

    public void initFrom(ConstraintWidgetContainer object, ConstraintSet object2, ConstraintSet constraintSet) {
        this.mStart = object2;
        this.mEnd = constraintSet;
        object = new ConstraintWidgetContainer();
        this.mLayoutStart = object;
        object = new ConstraintWidgetContainer();
        this.mLayoutEnd = object;
        object = this.mLayoutStart;
        Object object3 = MotionLayout.access$200(this.this$0).getMeasurer();
        ((ConstraintWidgetContainer)object).setMeasurer((BasicMeasure$Measurer)object3);
        object = this.mLayoutEnd;
        object3 = MotionLayout.access$300(this.this$0).getMeasurer();
        ((ConstraintWidgetContainer)object).setMeasurer((BasicMeasure$Measurer)object3);
        this.mLayoutStart.removeAllChildren();
        this.mLayoutEnd.removeAllChildren();
        object = MotionLayout.access$400(this.this$0);
        object3 = this.mLayoutStart;
        this.copy((ConstraintWidgetContainer)object, (ConstraintWidgetContainer)object3);
        object = MotionLayout.access$500(this.this$0);
        object3 = this.mLayoutEnd;
        this.copy((ConstraintWidgetContainer)object, (ConstraintWidgetContainer)object3);
        object = this.this$0;
        float f10 = ((MotionLayout)object).mTransitionLastPosition;
        double d10 = f10;
        double d11 = 0.5;
        double d12 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
        if (d12 > 0) {
            if (object2 != null) {
                object = this.mLayoutStart;
                this.setupConstraintWidget((ConstraintWidgetContainer)object, (ConstraintSet)object2);
            }
            object = this.mLayoutEnd;
            this.setupConstraintWidget((ConstraintWidgetContainer)object, constraintSet);
        } else {
            object = this.mLayoutEnd;
            this.setupConstraintWidget((ConstraintWidgetContainer)object, constraintSet);
            if (object2 != null) {
                object = this.mLayoutStart;
                this.setupConstraintWidget((ConstraintWidgetContainer)object, (ConstraintSet)object2);
            }
        }
        object = this.mLayoutStart;
        int n10 = MotionLayout.access$600(this.this$0);
        ((ConstraintWidgetContainer)object).setRtl(n10 != 0);
        this.mLayoutStart.updateHierarchy();
        object = this.mLayoutEnd;
        object2 = this.this$0;
        n10 = MotionLayout.access$700((MotionLayout)object2);
        ((ConstraintWidgetContainer)object).setRtl(n10 != 0);
        this.mLayoutEnd.updateHierarchy();
        object = this.this$0.getLayoutParams();
        if (object != null) {
            n10 = ((ViewGroup.LayoutParams)object).width;
            int n11 = -2;
            if (n10 == n11) {
                object2 = this.mLayoutStart;
                object3 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                ((ConstraintWidget)object2).setHorizontalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)((Object)object3));
                object2 = this.mLayoutEnd;
                ((ConstraintWidget)object2).setHorizontalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)((Object)object3));
            }
            if ((d12 = (double)((ViewGroup.LayoutParams)object).height) == n11) {
                object = this.mLayoutStart;
                object2 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                ((ConstraintWidget)object).setVerticalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)((Object)object2));
                object = this.mLayoutEnd;
                ((ConstraintWidget)object).setVerticalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)((Object)object2));
            }
        }
    }

    public boolean isNotConfiguredWith(int n10, int n11) {
        int n12 = this.mStartId;
        n10 = n10 == n12 && n11 == (n10 = this.mEndId) ? 0 : 1;
        return n10 != 0;
    }

    /*
     * Unable to fully structure code
     */
    public void measure(int var1_1, int var2_2) {
        var3_3 = View.MeasureSpec.getMode((int)var1_1);
        var4_4 = View.MeasureSpec.getMode((int)var2_2);
        var5_5 = this.this$0;
        var5_5.mWidthMeasureMode = var3_3;
        var5_5.mHeightMeasureMode = var4_4;
        var6_6 = var5_5.getOptimizationLevel();
        var8_8 = var7_7.mCurrentState;
        var7_7 = this.this$0;
        var9_9 = var7_7.getStartState();
        if (var8_8 == var9_9) {
            var7_7 = this.this$0;
            var10_10 = this.mLayoutEnd;
            MotionLayout.access$1200((MotionLayout)var7_7, var10_10, var6_6, var1_1, var2_2);
            var7_7 = this.mStart;
            if (var7_7 != null) {
                var7_7 = this.this$0;
                var10_10 = this.mLayoutStart;
                MotionLayout.access$1300((MotionLayout)var7_7, var10_10, var6_6, var1_1, var2_2);
            }
        } else {
            var7_7 = this.mStart;
            if (var7_7 != null) {
                var7_7 = this.this$0;
                var10_10 = this.mLayoutStart;
                MotionLayout.access$1400((MotionLayout)var7_7, var10_10, var6_6, var1_1, var2_2);
            }
            var7_7 = this.this$0;
            var10_10 = this.mLayoutEnd;
            MotionLayout.access$1500((MotionLayout)var7_7, var10_10, var6_6, var1_1, var2_2);
        }
        var7_7 = this.this$0.getParent();
        var9_9 = var7_7 instanceof MotionLayout;
        var8_8 = 0;
        var10_10 = null;
        var11_11 = 1;
        var12_12 = 1.4E-45f;
        if (var9_9 == 0) ** GOTO lbl-1000
        var9_9 = 0x40000000;
        var13_13 = 2.0f;
        if (var3_3 == var9_9 && var4_4 == var9_9) {
            var9_9 = 0;
            var7_7 = null;
            var13_13 = 0.0f;
        } else lbl-1000:
        // 2 sources

        {
            var9_9 = var11_11;
            var13_13 = var12_12;
        }
        if (var9_9 != 0) {
            var7_7 = this.this$0;
            var7_7.mWidthMeasureMode = var3_3;
            var7_7.mHeightMeasureMode = var4_4;
            var3_3 = var7_7.mCurrentState;
            var4_4 = var7_7.getStartState();
            if (var3_3 == var4_4) {
                var14_14 = this.this$0;
                var15_15 = this.mLayoutEnd;
                MotionLayout.access$1600((MotionLayout)var14_14, var15_15, var6_6, var1_1, var2_2);
                var14_14 = this.mStart;
                if (var14_14 != null) {
                    var14_14 = this.this$0;
                    var15_15 = this.mLayoutStart;
                    MotionLayout.access$1700((MotionLayout)var14_14, var15_15, var6_6, var1_1, var2_2);
                }
            } else {
                var14_14 = this.mStart;
                if (var14_14 != null) {
                    var14_14 = this.this$0;
                    var15_15 = this.mLayoutStart;
                    MotionLayout.access$1800((MotionLayout)var14_14, var15_15, var6_6, var1_1, var2_2);
                }
                var14_14 = this.this$0;
                var15_15 = this.mLayoutEnd;
                MotionLayout.access$1900((MotionLayout)var14_14, var15_15, var6_6, var1_1, var2_2);
            }
            var14_14 = this.this$0;
            var14_14.mStartWrapWidth = var4_4 = this.mLayoutStart.getWidth();
            var14_14 = this.this$0;
            var14_14.mStartWrapHeight = var4_4 = this.mLayoutStart.getHeight();
            var14_14 = this.this$0;
            var14_14.mEndWrapWidth = var4_4 = this.mLayoutEnd.getWidth();
            var14_14 = this.this$0;
            var15_15 = this.mLayoutEnd;
            var14_14.mEndWrapHeight = var4_4 = var15_15.getHeight();
            var14_14 = this.this$0;
            var4_4 = var14_14.mStartWrapWidth;
            var6_6 = var14_14.mEndWrapWidth;
            if (var4_4 == var6_6 && (var4_4 = var14_14.mStartWrapHeight) == (var6_6 = var14_14.mEndWrapHeight)) {
                var4_4 = 0;
                var15_15 = null;
                var16_16 = 0.0f;
            } else {
                var4_4 = var11_11;
                var16_16 = var12_12;
            }
            var14_14.mMeasureDuringTransition = var4_4;
        }
        var14_14 = this.this$0;
        var4_4 = var14_14.mStartWrapWidth;
        var6_6 = var14_14.mStartWrapHeight;
        var9_9 = var14_14.mWidthMeasureMode;
        var17_17 = -1 << -1;
        var18_18 = -0.0f;
        if (var9_9 == var17_17 || var9_9 == 0) {
            var13_13 = var4_4;
            var19_19 = var14_14.mPostInterpolationPosition;
            var20_20 = var14_14.mEndWrapWidth - var4_4;
            var16_16 = var20_20;
            var4_4 = (int)(var13_13 += (var19_19 *= var16_16));
        }
        if ((var9_9 = var14_14.mHeightMeasureMode) == var17_17 || var9_9 == 0) {
            var13_13 = var6_6;
            var18_18 = var14_14.mPostInterpolationPosition;
            var21_21 = var14_14.mEndWrapHeight - var6_6;
            var6_6 = var3_3 = (int)(var13_13 += (var18_18 *= var21_21));
        }
        if ((var3_3 = (int)(var14_14 = this.mLayoutStart).isWidthMeasuredTooSmall()) == 0 && (var3_3 = (int)(var14_14 = this.mLayoutEnd).isWidthMeasuredTooSmall()) == 0) {
            var9_9 = 0;
            var7_7 = null;
            var13_13 = 0.0f;
        } else {
            var9_9 = var11_11;
            var13_13 = var12_12;
        }
        var14_14 = this.mLayoutStart;
        var3_3 = (int)var14_14.isHeightMeasuredTooSmall();
        if (var3_3 != 0 || (var3_3 = (int)(var14_14 = this.mLayoutEnd).isHeightMeasuredTooSmall()) != 0) {
            var8_8 = var11_11;
        }
        MotionLayout.access$2000(this.this$0, var1_1, var2_2, var4_4, var6_6, (boolean)var9_9, (boolean)var8_8);
    }

    public void reEvaluateState() {
        int n10 = MotionLayout.access$900(this.this$0);
        int n11 = MotionLayout.access$1000(this.this$0);
        this.measure(n10, n11);
        MotionLayout.access$1100(this.this$0);
    }

    public void setMeasuredId(int n10, int n11) {
        this.mStartId = n10;
        this.mEndId = n11;
    }
}

