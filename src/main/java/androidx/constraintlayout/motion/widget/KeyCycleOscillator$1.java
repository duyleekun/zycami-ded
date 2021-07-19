/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator
 */
package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator$WavePoint;
import java.util.Comparator;

public class KeyCycleOscillator$1
implements Comparator {
    public final /* synthetic */ KeyCycleOscillator this$0;

    public KeyCycleOscillator$1(KeyCycleOscillator keyCycleOscillator) {
        this.this$0 = keyCycleOscillator;
    }

    public int compare(KeyCycleOscillator$WavePoint keyCycleOscillator$WavePoint, KeyCycleOscillator$WavePoint keyCycleOscillator$WavePoint2) {
        int n10 = keyCycleOscillator$WavePoint.mPosition;
        int n11 = keyCycleOscillator$WavePoint2.mPosition;
        return Integer.compare(n10, n11);
    }
}

