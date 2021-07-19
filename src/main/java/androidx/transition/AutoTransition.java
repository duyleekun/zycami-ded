/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 */
package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;

public class AutoTransition
extends TransitionSet {
    public AutoTransition() {
        this.init();
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init();
    }

    private void init() {
        int n10 = 1;
        this.setOrdering(n10);
        Transition transition = new Fade(2);
        transition = this.addTransition(transition);
        Transition transition2 = new ChangeBounds();
        transition = ((TransitionSet)transition).addTransition(transition2);
        transition2 = new Fade(n10);
        ((TransitionSet)transition).addTransition(transition2);
    }
}

