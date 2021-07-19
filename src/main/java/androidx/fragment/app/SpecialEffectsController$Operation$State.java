/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.SpecialEffectsController$3;

public final class SpecialEffectsController$Operation$State
extends Enum {
    private static final /* synthetic */ SpecialEffectsController$Operation$State[] $VALUES;
    public static final /* enum */ SpecialEffectsController$Operation$State GONE;
    public static final /* enum */ SpecialEffectsController$Operation$State INVISIBLE;
    public static final /* enum */ SpecialEffectsController$Operation$State REMOVED;
    public static final /* enum */ SpecialEffectsController$Operation$State VISIBLE;

    static {
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State;
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State2;
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State3;
        SpecialEffectsController$Operation$State specialEffectsController$Operation$State4;
        REMOVED = specialEffectsController$Operation$State4 = new SpecialEffectsController$Operation$State("REMOVED", 0);
        int n10 = 1;
        VISIBLE = specialEffectsController$Operation$State3 = new SpecialEffectsController$Operation$State("VISIBLE", n10);
        int n11 = 2;
        GONE = specialEffectsController$Operation$State2 = new SpecialEffectsController$Operation$State("GONE", n11);
        int n12 = 3;
        INVISIBLE = specialEffectsController$Operation$State = new SpecialEffectsController$Operation$State("INVISIBLE", n12);
        SpecialEffectsController$Operation$State[] specialEffectsController$Operation$StateArray = new SpecialEffectsController$Operation$State[4];
        specialEffectsController$Operation$StateArray[0] = specialEffectsController$Operation$State4;
        specialEffectsController$Operation$StateArray[n10] = specialEffectsController$Operation$State3;
        specialEffectsController$Operation$StateArray[n11] = specialEffectsController$Operation$State2;
        specialEffectsController$Operation$StateArray[n12] = specialEffectsController$Operation$State;
        $VALUES = specialEffectsController$Operation$StateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SpecialEffectsController$Operation$State() {
        void var2_-1;
        void var1_-1;
    }

    public static SpecialEffectsController$Operation$State from(int n10) {
        if (n10 != 0) {
            int n11 = 4;
            if (n10 != n11) {
                n11 = 8;
                if (n10 == n11) {
                    return GONE;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown visibility ");
                stringBuilder.append(n10);
                String string2 = stringBuilder.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
                throw illegalArgumentException;
            }
            return INVISIBLE;
        }
        return VISIBLE;
    }

    public static SpecialEffectsController$Operation$State from(View view) {
        float f10 = view.getAlpha();
        float f11 = f10 - 0.0f;
        Object object = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (object == false && (object = (Object)view.getVisibility()) == false) {
            return INVISIBLE;
        }
        return SpecialEffectsController$Operation$State.from(view.getVisibility());
    }

    public static SpecialEffectsController$Operation$State valueOf(String string2) {
        return Enum.valueOf(SpecialEffectsController$Operation$State.class, string2);
    }

    public static SpecialEffectsController$Operation$State[] values() {
        return (SpecialEffectsController$Operation$State[])$VALUES.clone();
    }

    public void applyState(View view) {
        Object object = SpecialEffectsController$3.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;
        int n10 = this.ordinal();
        int n11 = object[n10];
        n10 = 1;
        String string2 = "FragmentManager";
        int n12 = 2;
        if (n11 != n10) {
            String string3 = "SpecialEffectsController: Setting view ";
            if (n11 != n12) {
                int n13 = 3;
                if (n11 != n13) {
                    n13 = 4;
                    if (n11 == n13) {
                        n11 = (int)(FragmentManager.isLoggingEnabled(n12) ? 1 : 0);
                        if (n11 != 0) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append(string3);
                            ((StringBuilder)object).append(view);
                            string3 = " to INVISIBLE";
                            ((StringBuilder)object).append(string3);
                            object = ((StringBuilder)object).toString();
                            Log.v((String)string2, (String)object);
                        }
                        view.setVisibility(n13);
                    }
                } else {
                    n11 = (int)(FragmentManager.isLoggingEnabled(n12) ? 1 : 0);
                    if (n11 != 0) {
                        object = new StringBuilder;
                        object = new StringBuilder();
                        ((StringBuilder)object).append(string3);
                        ((StringBuilder)object).append(view);
                        string3 = " to GONE";
                        ((StringBuilder)object).append(string3);
                        object = ((StringBuilder)object).toString();
                        Log.v((String)string2, (String)object);
                    }
                    n11 = 8;
                    view.setVisibility(n11);
                }
            } else {
                n11 = (int)(FragmentManager.isLoggingEnabled(n12) ? 1 : 0);
                if (n11 != 0) {
                    object = new StringBuilder;
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string3);
                    ((StringBuilder)object).append(view);
                    string3 = " to VISIBLE";
                    ((StringBuilder)object).append(string3);
                    object = ((StringBuilder)object).toString();
                    Log.v((String)string2, (String)object);
                }
                n11 = 0;
                object = null;
                view.setVisibility(0);
            }
        } else {
            object = (ViewGroup)view.getParent();
            if (object != null) {
                n10 = (int)(FragmentManager.isLoggingEnabled(n12) ? 1 : 0);
                if (n10 != 0) {
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append("SpecialEffectsController: Removing view ");
                    charSequence.append(view);
                    String string4 = " from container ";
                    charSequence.append(string4);
                    charSequence.append(object);
                    charSequence = charSequence.toString();
                    Log.v((String)string2, (String)charSequence);
                }
                object.removeView(view);
            }
        }
    }
}

