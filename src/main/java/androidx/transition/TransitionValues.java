/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.Map;

public class TransitionValues {
    public final ArrayList mTargetedTransitions;
    public final Map values;
    public View view;

    public TransitionValues() {
        Cloneable cloneable;
        this.values = cloneable = new Cloneable();
        this.mTargetedTransitions = cloneable;
    }

    public TransitionValues(View view) {
        Cloneable cloneable;
        this.values = cloneable = new Cloneable();
        this.mTargetedTransitions = cloneable;
        this.view = view;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof TransitionValues;
        if (bl2) {
            boolean bl3;
            Object object2 = this.view;
            object = (TransitionValues)object;
            View view = ((TransitionValues)object).view;
            if (object2 == view && (bl3 = (object2 = this.values).equals(object = ((TransitionValues)object).values))) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.view.hashCode() * 31;
        int n11 = this.values.hashCode();
        return n10 + n11;
    }

    public String toString() {
        boolean bl2;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("TransitionValues@");
        int n10 = this.hashCode();
        CharSequence charSequence2 = Integer.toHexString(n10);
        charSequence.append((String)charSequence2);
        charSequence.append(":\n");
        charSequence = charSequence.toString();
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append((String)charSequence);
        ((StringBuilder)charSequence2).append("    view = ");
        charSequence = this.view;
        ((StringBuilder)charSequence2).append((Object)charSequence);
        charSequence = "\n";
        ((StringBuilder)charSequence2).append((String)charSequence);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        Object object = new StringBuilder();
        ((StringBuilder)object).append((String)charSequence2);
        ((StringBuilder)object).append("    values:");
        charSequence2 = ((StringBuilder)object).toString();
        object = this.values.keySet().iterator();
        while (bl2 = object.hasNext()) {
            String string2 = (String)object.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)charSequence2);
            stringBuilder.append("    ");
            stringBuilder.append(string2);
            stringBuilder.append(": ");
            charSequence2 = this.values.get(string2);
            stringBuilder.append((Object)charSequence2);
            stringBuilder.append((String)charSequence);
            charSequence2 = stringBuilder.toString();
        }
        return charSequence2;
    }
}

