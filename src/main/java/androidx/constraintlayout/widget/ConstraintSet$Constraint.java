/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package androidx.constraintlayout.widget;

import android.os.Build;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintAttribute$AttributeType;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.constraintlayout.widget.ConstraintSet$Layout;
import androidx.constraintlayout.widget.ConstraintSet$Motion;
import androidx.constraintlayout.widget.ConstraintSet$PropertySet;
import androidx.constraintlayout.widget.ConstraintSet$Transform;
import androidx.constraintlayout.widget.Constraints$LayoutParams;
import java.util.HashMap;

public class ConstraintSet$Constraint {
    public final ConstraintSet$Layout layout;
    public HashMap mCustomConstraints;
    public int mViewId;
    public final ConstraintSet$Motion motion;
    public final ConstraintSet$PropertySet propertySet;
    public final ConstraintSet$Transform transform;

    public ConstraintSet$Constraint() {
        HashMap hashMap = new HashMap();
        this.propertySet = hashMap;
        hashMap = new HashMap();
        this.motion = hashMap;
        hashMap = new HashMap();
        this.layout = hashMap;
        hashMap = new HashMap();
        this.transform = hashMap;
        this.mCustomConstraints = hashMap = new HashMap();
    }

    public static /* synthetic */ void access$000(ConstraintSet$Constraint constraintSet$Constraint, int n10, ConstraintLayout$LayoutParams constraintLayout$LayoutParams) {
        constraintSet$Constraint.fillFrom(n10, constraintLayout$LayoutParams);
    }

    public static /* synthetic */ void access$300(ConstraintSet$Constraint constraintSet$Constraint, ConstraintHelper constraintHelper, int n10, Constraints$LayoutParams constraints$LayoutParams) {
        constraintSet$Constraint.fillFromConstraints(constraintHelper, n10, constraints$LayoutParams);
    }

    public static /* synthetic */ void access$400(ConstraintSet$Constraint constraintSet$Constraint, int n10, Constraints$LayoutParams constraints$LayoutParams) {
        constraintSet$Constraint.fillFromConstraints(n10, constraints$LayoutParams);
    }

    public static /* synthetic */ void access$500(ConstraintSet$Constraint constraintSet$Constraint, String string2, int n10) {
        constraintSet$Constraint.setIntValue(string2, n10);
    }

    public static /* synthetic */ void access$600(ConstraintSet$Constraint constraintSet$Constraint, String string2, int n10) {
        constraintSet$Constraint.setColorValue(string2, n10);
    }

    public static /* synthetic */ void access$700(ConstraintSet$Constraint constraintSet$Constraint, String string2, float f10) {
        constraintSet$Constraint.setFloatValue(string2, f10);
    }

    public static /* synthetic */ void access$800(ConstraintSet$Constraint constraintSet$Constraint, String string2, String string3) {
        constraintSet$Constraint.setStringValue(string2, string3);
    }

    private void fillFrom(int n10, ConstraintLayout$LayoutParams constraintLayout$LayoutParams) {
        String string2;
        float f10;
        int n11;
        this.mViewId = n10;
        ConstraintSet$Layout constraintSet$Layout = this.layout;
        constraintSet$Layout.leftToLeft = n11 = constraintLayout$LayoutParams.leftToLeft;
        constraintSet$Layout.leftToRight = n11 = constraintLayout$LayoutParams.leftToRight;
        constraintSet$Layout.rightToLeft = n11 = constraintLayout$LayoutParams.rightToLeft;
        constraintSet$Layout.rightToRight = n11 = constraintLayout$LayoutParams.rightToRight;
        constraintSet$Layout.topToTop = n11 = constraintLayout$LayoutParams.topToTop;
        constraintSet$Layout.topToBottom = n11 = constraintLayout$LayoutParams.topToBottom;
        constraintSet$Layout.bottomToTop = n11 = constraintLayout$LayoutParams.bottomToTop;
        constraintSet$Layout.bottomToBottom = n11 = constraintLayout$LayoutParams.bottomToBottom;
        constraintSet$Layout.baselineToBaseline = n11 = constraintLayout$LayoutParams.baselineToBaseline;
        constraintSet$Layout.startToEnd = n11 = constraintLayout$LayoutParams.startToEnd;
        constraintSet$Layout.startToStart = n11 = constraintLayout$LayoutParams.startToStart;
        constraintSet$Layout.endToStart = n11 = constraintLayout$LayoutParams.endToStart;
        constraintSet$Layout.endToEnd = n11 = constraintLayout$LayoutParams.endToEnd;
        constraintSet$Layout.horizontalBias = f10 = constraintLayout$LayoutParams.horizontalBias;
        constraintSet$Layout.verticalBias = f10 = constraintLayout$LayoutParams.verticalBias;
        constraintSet$Layout.dimensionRatio = string2 = constraintLayout$LayoutParams.dimensionRatio;
        constraintSet$Layout.circleConstraint = n11 = constraintLayout$LayoutParams.circleConstraint;
        constraintSet$Layout.circleRadius = n11 = constraintLayout$LayoutParams.circleRadius;
        constraintSet$Layout.circleAngle = f10 = constraintLayout$LayoutParams.circleAngle;
        constraintSet$Layout.editorAbsoluteX = n11 = constraintLayout$LayoutParams.editorAbsoluteX;
        constraintSet$Layout.editorAbsoluteY = n11 = constraintLayout$LayoutParams.editorAbsoluteY;
        constraintSet$Layout.orientation = n11 = constraintLayout$LayoutParams.orientation;
        constraintSet$Layout.guidePercent = f10 = constraintLayout$LayoutParams.guidePercent;
        constraintSet$Layout.guideBegin = n11 = constraintLayout$LayoutParams.guideBegin;
        constraintSet$Layout.guideEnd = n11 = constraintLayout$LayoutParams.guideEnd;
        constraintSet$Layout = this.layout;
        constraintSet$Layout.mWidth = n11 = constraintLayout$LayoutParams.width;
        constraintSet$Layout.mHeight = n11 = constraintLayout$LayoutParams.height;
        constraintSet$Layout.leftMargin = n11 = constraintLayout$LayoutParams.leftMargin;
        constraintSet$Layout.rightMargin = n11 = constraintLayout$LayoutParams.rightMargin;
        constraintSet$Layout.topMargin = n11 = constraintLayout$LayoutParams.topMargin;
        constraintSet$Layout.bottomMargin = n11 = constraintLayout$LayoutParams.bottomMargin;
        constraintSet$Layout.verticalWeight = f10 = constraintLayout$LayoutParams.verticalWeight;
        constraintSet$Layout.horizontalWeight = f10 = constraintLayout$LayoutParams.horizontalWeight;
        constraintSet$Layout.verticalChainStyle = n11 = constraintLayout$LayoutParams.verticalChainStyle;
        constraintSet$Layout.horizontalChainStyle = n11 = constraintLayout$LayoutParams.horizontalChainStyle;
        n11 = constraintLayout$LayoutParams.constrainedWidth ? 1 : 0;
        constraintSet$Layout.constrainedWidth = n11;
        n11 = constraintLayout$LayoutParams.constrainedHeight ? 1 : 0;
        constraintSet$Layout.constrainedHeight = n11;
        constraintSet$Layout.widthDefault = n11 = constraintLayout$LayoutParams.matchConstraintDefaultWidth;
        constraintSet$Layout.heightDefault = n11 = constraintLayout$LayoutParams.matchConstraintDefaultHeight;
        constraintSet$Layout.widthMax = n11 = constraintLayout$LayoutParams.matchConstraintMaxWidth;
        constraintSet$Layout.heightMax = n11 = constraintLayout$LayoutParams.matchConstraintMaxHeight;
        constraintSet$Layout.widthMin = n11 = constraintLayout$LayoutParams.matchConstraintMinWidth;
        constraintSet$Layout.heightMin = n11 = constraintLayout$LayoutParams.matchConstraintMinHeight;
        constraintSet$Layout.widthPercent = f10 = constraintLayout$LayoutParams.matchConstraintPercentWidth;
        constraintSet$Layout.heightPercent = f10 = constraintLayout$LayoutParams.matchConstraintPercentHeight;
        constraintSet$Layout.mConstraintTag = string2 = constraintLayout$LayoutParams.constraintTag;
        constraintSet$Layout.goneTopMargin = n11 = constraintLayout$LayoutParams.goneTopMargin;
        constraintSet$Layout.goneBottomMargin = n11 = constraintLayout$LayoutParams.goneBottomMargin;
        constraintSet$Layout.goneLeftMargin = n11 = constraintLayout$LayoutParams.goneLeftMargin;
        constraintSet$Layout.goneRightMargin = n11 = constraintLayout$LayoutParams.goneRightMargin;
        constraintSet$Layout = this.layout;
        constraintSet$Layout.goneStartMargin = n11 = constraintLayout$LayoutParams.goneStartMargin;
        constraintSet$Layout.goneEndMargin = n11 = constraintLayout$LayoutParams.goneEndMargin;
        n11 = Build.VERSION.SDK_INT;
        int n12 = 17;
        if (n11 >= n12) {
            int n13;
            constraintSet$Layout.endMargin = n11 = constraintLayout$LayoutParams.getMarginEnd();
            constraintSet$Layout = this.layout;
            constraintSet$Layout.startMargin = n13 = constraintLayout$LayoutParams.getMarginStart();
        }
    }

    private void fillFromConstraints(int n10, Constraints$LayoutParams constraints$LayoutParams) {
        boolean bl2;
        float f10;
        this.fillFrom(n10, constraints$LayoutParams);
        Object object = this.propertySet;
        ((ConstraintSet$PropertySet)object).alpha = f10 = constraints$LayoutParams.alpha;
        object = this.transform;
        ((ConstraintSet$Transform)object).rotation = f10 = constraints$LayoutParams.rotation;
        ((ConstraintSet$Transform)object).rotationX = f10 = constraints$LayoutParams.rotationX;
        ((ConstraintSet$Transform)object).rotationY = f10 = constraints$LayoutParams.rotationY;
        ((ConstraintSet$Transform)object).scaleX = f10 = constraints$LayoutParams.scaleX;
        ((ConstraintSet$Transform)object).scaleY = f10 = constraints$LayoutParams.scaleY;
        ((ConstraintSet$Transform)object).transformPivotX = f10 = constraints$LayoutParams.transformPivotX;
        ((ConstraintSet$Transform)object).transformPivotY = f10 = constraints$LayoutParams.transformPivotY;
        ((ConstraintSet$Transform)object).translationX = f10 = constraints$LayoutParams.translationX;
        ((ConstraintSet$Transform)object).translationY = f10 = constraints$LayoutParams.translationY;
        ((ConstraintSet$Transform)object).translationZ = f10 = constraints$LayoutParams.translationZ;
        ((ConstraintSet$Transform)object).elevation = f10 = constraints$LayoutParams.elevation;
        ((ConstraintSet$Transform)object).applyElevation = bl2 = constraints$LayoutParams.applyElevation;
    }

    private void fillFromConstraints(ConstraintHelper constraintHelper, int n10, Constraints$LayoutParams object) {
        this.fillFromConstraints(n10, (Constraints$LayoutParams)((Object)object));
        n10 = constraintHelper instanceof Barrier;
        if (n10 != 0) {
            int n11;
            int n12;
            ConstraintSet$Layout constraintSet$Layout = this.layout;
            constraintSet$Layout.mHelperType = 1;
            constraintHelper = (Barrier)constraintHelper;
            constraintSet$Layout.mBarrierDirection = n12 = ((Barrier)constraintHelper).getType();
            constraintSet$Layout = this.layout;
            object = constraintHelper.getReferencedIds();
            constraintSet$Layout.mReferenceIds = (int[])object;
            constraintSet$Layout = this.layout;
            constraintSet$Layout.mBarrierMargin = n11 = ((Barrier)constraintHelper).getMargin();
        }
    }

    private ConstraintAttribute get(String object, ConstraintAttribute$AttributeType object2) {
        Object object3 = this.mCustomConstraints;
        boolean bl2 = ((HashMap)object3).containsKey(object);
        if (bl2) {
            object3 = ((ConstraintAttribute)(object = (ConstraintAttribute)this.mCustomConstraints.get(object))).getType();
            if (object3 != object2) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("ConstraintAttribute is already a ");
                object = ((ConstraintAttribute)object).getType().name();
                ((StringBuilder)object3).append((String)object);
                object = ((StringBuilder)object3).toString();
                object2 = new IllegalArgumentException((String)object);
                throw object2;
            }
        } else {
            object3 = new ConstraintAttribute((String)object, (ConstraintAttribute$AttributeType)((Object)object2));
            object2 = this.mCustomConstraints;
            ((HashMap)object2).put(object, object3);
            object = object3;
        }
        return object;
    }

    private void setColorValue(String string2, int n10) {
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.COLOR_TYPE;
        this.get(string2, constraintAttribute$AttributeType).setColorValue(n10);
    }

    private void setFloatValue(String string2, float f10) {
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.FLOAT_TYPE;
        this.get(string2, constraintAttribute$AttributeType).setFloatValue(f10);
    }

    private void setIntValue(String string2, int n10) {
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.INT_TYPE;
        this.get(string2, constraintAttribute$AttributeType).setIntValue(n10);
    }

    private void setStringValue(String string2, String string3) {
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.STRING_TYPE;
        this.get(string2, constraintAttribute$AttributeType).setStringValue(string3);
    }

    public void applyTo(ConstraintLayout$LayoutParams constraintLayout$LayoutParams) {
        String string2;
        int n10;
        float f10;
        int n11;
        Object object = this.layout;
        constraintLayout$LayoutParams.leftToLeft = n11 = ((ConstraintSet$Layout)object).leftToLeft;
        constraintLayout$LayoutParams.leftToRight = n11 = ((ConstraintSet$Layout)object).leftToRight;
        constraintLayout$LayoutParams.rightToLeft = n11 = ((ConstraintSet$Layout)object).rightToLeft;
        constraintLayout$LayoutParams.rightToRight = n11 = ((ConstraintSet$Layout)object).rightToRight;
        constraintLayout$LayoutParams.topToTop = n11 = ((ConstraintSet$Layout)object).topToTop;
        constraintLayout$LayoutParams.topToBottom = n11 = ((ConstraintSet$Layout)object).topToBottom;
        constraintLayout$LayoutParams.bottomToTop = n11 = ((ConstraintSet$Layout)object).bottomToTop;
        constraintLayout$LayoutParams.bottomToBottom = n11 = ((ConstraintSet$Layout)object).bottomToBottom;
        constraintLayout$LayoutParams.baselineToBaseline = n11 = ((ConstraintSet$Layout)object).baselineToBaseline;
        constraintLayout$LayoutParams.startToEnd = n11 = ((ConstraintSet$Layout)object).startToEnd;
        constraintLayout$LayoutParams.startToStart = n11 = ((ConstraintSet$Layout)object).startToStart;
        constraintLayout$LayoutParams.endToStart = n11 = ((ConstraintSet$Layout)object).endToStart;
        constraintLayout$LayoutParams.endToEnd = n11 = ((ConstraintSet$Layout)object).endToEnd;
        constraintLayout$LayoutParams.leftMargin = n11 = ((ConstraintSet$Layout)object).leftMargin;
        constraintLayout$LayoutParams.rightMargin = n11 = ((ConstraintSet$Layout)object).rightMargin;
        constraintLayout$LayoutParams.topMargin = n11 = ((ConstraintSet$Layout)object).topMargin;
        constraintLayout$LayoutParams.bottomMargin = n11 = ((ConstraintSet$Layout)object).bottomMargin;
        constraintLayout$LayoutParams.goneStartMargin = n11 = ((ConstraintSet$Layout)object).goneStartMargin;
        constraintLayout$LayoutParams.goneEndMargin = n11 = ((ConstraintSet$Layout)object).goneEndMargin;
        constraintLayout$LayoutParams.goneTopMargin = n11 = ((ConstraintSet$Layout)object).goneTopMargin;
        constraintLayout$LayoutParams.goneBottomMargin = n11 = ((ConstraintSet$Layout)object).goneBottomMargin;
        constraintLayout$LayoutParams.horizontalBias = f10 = ((ConstraintSet$Layout)object).horizontalBias;
        constraintLayout$LayoutParams.verticalBias = f10 = ((ConstraintSet$Layout)object).verticalBias;
        constraintLayout$LayoutParams.circleConstraint = n11 = ((ConstraintSet$Layout)object).circleConstraint;
        constraintLayout$LayoutParams.circleRadius = n10 = ((ConstraintSet$Layout)object).circleRadius;
        object = this.layout;
        constraintLayout$LayoutParams.circleAngle = f10 = ((ConstraintSet$Layout)object).circleAngle;
        constraintLayout$LayoutParams.dimensionRatio = string2 = ((ConstraintSet$Layout)object).dimensionRatio;
        constraintLayout$LayoutParams.editorAbsoluteX = n11 = ((ConstraintSet$Layout)object).editorAbsoluteX;
        constraintLayout$LayoutParams.editorAbsoluteY = n11 = ((ConstraintSet$Layout)object).editorAbsoluteY;
        constraintLayout$LayoutParams.verticalWeight = f10 = ((ConstraintSet$Layout)object).verticalWeight;
        constraintLayout$LayoutParams.horizontalWeight = f10 = ((ConstraintSet$Layout)object).horizontalWeight;
        constraintLayout$LayoutParams.verticalChainStyle = n11 = ((ConstraintSet$Layout)object).verticalChainStyle;
        constraintLayout$LayoutParams.horizontalChainStyle = n11 = ((ConstraintSet$Layout)object).horizontalChainStyle;
        n11 = ((ConstraintSet$Layout)object).constrainedWidth ? 1 : 0;
        constraintLayout$LayoutParams.constrainedWidth = n11;
        n11 = ((ConstraintSet$Layout)object).constrainedHeight ? 1 : 0;
        constraintLayout$LayoutParams.constrainedHeight = n11;
        constraintLayout$LayoutParams.matchConstraintDefaultWidth = n11 = ((ConstraintSet$Layout)object).widthDefault;
        constraintLayout$LayoutParams.matchConstraintDefaultHeight = n11 = ((ConstraintSet$Layout)object).heightDefault;
        constraintLayout$LayoutParams.matchConstraintMaxWidth = n11 = ((ConstraintSet$Layout)object).widthMax;
        constraintLayout$LayoutParams.matchConstraintMaxHeight = n11 = ((ConstraintSet$Layout)object).heightMax;
        constraintLayout$LayoutParams.matchConstraintMinWidth = n11 = ((ConstraintSet$Layout)object).widthMin;
        constraintLayout$LayoutParams.matchConstraintMinHeight = n11 = ((ConstraintSet$Layout)object).heightMin;
        constraintLayout$LayoutParams.matchConstraintPercentWidth = f10 = ((ConstraintSet$Layout)object).widthPercent;
        constraintLayout$LayoutParams.matchConstraintPercentHeight = f10 = ((ConstraintSet$Layout)object).heightPercent;
        constraintLayout$LayoutParams.orientation = n11 = ((ConstraintSet$Layout)object).orientation;
        constraintLayout$LayoutParams.guidePercent = f10 = ((ConstraintSet$Layout)object).guidePercent;
        constraintLayout$LayoutParams.guideBegin = n11 = ((ConstraintSet$Layout)object).guideBegin;
        constraintLayout$LayoutParams.guideEnd = n11 = ((ConstraintSet$Layout)object).guideEnd;
        constraintLayout$LayoutParams.width = n11 = ((ConstraintSet$Layout)object).mWidth;
        constraintLayout$LayoutParams.height = n11 = ((ConstraintSet$Layout)object).mHeight;
        object = ((ConstraintSet$Layout)object).mConstraintTag;
        if (object != null) {
            constraintLayout$LayoutParams.constraintTag = object;
        }
        n10 = Build.VERSION.SDK_INT;
        n11 = 17;
        f10 = 2.4E-44f;
        if (n10 >= n11) {
            n10 = this.layout.startMargin;
            constraintLayout$LayoutParams.setMarginStart(n10);
            object = this.layout;
            n10 = ((ConstraintSet$Layout)object).endMargin;
            constraintLayout$LayoutParams.setMarginEnd(n10);
        }
        constraintLayout$LayoutParams.validate();
    }

    public ConstraintSet$Constraint clone() {
        int n10;
        ConstraintSet$Constraint constraintSet$Constraint = new ConstraintSet$Constraint();
        Object object = constraintSet$Constraint.layout;
        Object object2 = this.layout;
        ((ConstraintSet$Layout)object).copyFrom((ConstraintSet$Layout)object2);
        object = constraintSet$Constraint.motion;
        object2 = this.motion;
        ((ConstraintSet$Motion)object).copyFrom((ConstraintSet$Motion)object2);
        object = constraintSet$Constraint.propertySet;
        object2 = this.propertySet;
        ((ConstraintSet$PropertySet)object).copyFrom((ConstraintSet$PropertySet)object2);
        object = constraintSet$Constraint.transform;
        object2 = this.transform;
        ((ConstraintSet$Transform)object).copyFrom((ConstraintSet$Transform)object2);
        constraintSet$Constraint.mViewId = n10 = this.mViewId;
        return constraintSet$Constraint;
    }
}

