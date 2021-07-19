/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.StateSet$Variant;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class StateSet$State {
    public int mConstraintID;
    public int mId;
    public boolean mIsLayout;
    public ArrayList mVariants;

    public StateSet$State(Context context, XmlPullParser xmlPullParser) {
        ArrayList arrayList;
        this.mVariants = arrayList = new ArrayList();
        this.mConstraintID = -1;
        arrayList = null;
        this.mIsLayout = false;
        xmlPullParser = Xml.asAttributeSet((XmlPullParser)xmlPullParser);
        int[] nArray = R$styleable.State;
        xmlPullParser = context.obtainStyledAttributes((AttributeSet)xmlPullParser, nArray);
        int n10 = xmlPullParser.getIndexCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            int n12 = xmlPullParser.getIndex(i10);
            if (n12 == (n11 = R$styleable.State_android_id)) {
                n11 = this.mId;
                this.mId = n12 = xmlPullParser.getResourceId(n12, n11);
                continue;
            }
            n11 = R$styleable.State_constraints;
            if (n12 != n11) continue;
            n11 = this.mConstraintID;
            this.mConstraintID = n12 = xmlPullParser.getResourceId(n12, n11);
            Object object = context.getResources();
            n11 = this.mConstraintID;
            object = object.getResourceTypeName(n11);
            Object object2 = context.getResources();
            int n13 = this.mConstraintID;
            object2.getResourceName(n13);
            object2 = "layout";
            n12 = (int)(((String)object2).equals(object) ? 1 : 0);
            if (n12 == 0) continue;
            n12 = 1;
            this.mIsLayout = n12;
        }
        xmlPullParser.recycle();
    }

    public void add(StateSet$Variant stateSet$Variant) {
        this.mVariants.add(stateSet$Variant);
    }

    public int findMatch(float f10, float f11) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.mVariants)).size()); ++i10) {
            object = (StateSet$Variant)this.mVariants.get(i10);
            n10 = (int)(((StateSet$Variant)object).match(f10, f11) ? 1 : 0);
            if (n10 == 0) continue;
            return i10;
        }
        return -1;
    }
}

