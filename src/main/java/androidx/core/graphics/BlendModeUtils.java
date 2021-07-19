/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.BlendMode
 *  android.graphics.PorterDuff$Mode
 */
package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import androidx.core.graphics.BlendModeCompat;
import androidx.core.graphics.BlendModeUtils$1;

public class BlendModeUtils {
    private BlendModeUtils() {
    }

    public static BlendMode obtainBlendModeFromCompat(BlendModeCompat blendModeCompat) {
        int[] nArray = BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat;
        int n10 = blendModeCompat.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                return null;
            }
            case 29: {
                return BlendMode.LUMINOSITY;
            }
            case 28: {
                return BlendMode.COLOR;
            }
            case 27: {
                return BlendMode.SATURATION;
            }
            case 26: {
                return BlendMode.HUE;
            }
            case 25: {
                return BlendMode.MULTIPLY;
            }
            case 24: {
                return BlendMode.EXCLUSION;
            }
            case 23: {
                return BlendMode.DIFFERENCE;
            }
            case 22: {
                return BlendMode.SOFT_LIGHT;
            }
            case 21: {
                return BlendMode.HARD_LIGHT;
            }
            case 20: {
                return BlendMode.COLOR_BURN;
            }
            case 19: {
                return BlendMode.COLOR_DODGE;
            }
            case 18: {
                return BlendMode.LIGHTEN;
            }
            case 17: {
                return BlendMode.DARKEN;
            }
            case 16: {
                return BlendMode.OVERLAY;
            }
            case 15: {
                return BlendMode.SCREEN;
            }
            case 14: {
                return BlendMode.MODULATE;
            }
            case 13: {
                return BlendMode.PLUS;
            }
            case 12: {
                return BlendMode.XOR;
            }
            case 11: {
                return BlendMode.DST_ATOP;
            }
            case 10: {
                return BlendMode.SRC_ATOP;
            }
            case 9: {
                return BlendMode.DST_OUT;
            }
            case 8: {
                return BlendMode.SRC_OUT;
            }
            case 7: {
                return BlendMode.DST_IN;
            }
            case 6: {
                return BlendMode.SRC_IN;
            }
            case 5: {
                return BlendMode.DST_OVER;
            }
            case 4: {
                return BlendMode.SRC_OVER;
            }
            case 3: {
                return BlendMode.DST;
            }
            case 2: {
                return BlendMode.SRC;
            }
            case 1: 
        }
        return BlendMode.CLEAR;
    }

    public static PorterDuff.Mode obtainPorterDuffFromCompat(BlendModeCompat blendModeCompat) {
        if (blendModeCompat != null) {
            int[] nArray = BlendModeUtils$1.$SwitchMap$androidx$core$graphics$BlendModeCompat;
            int n10 = blendModeCompat.ordinal();
            n10 = nArray[n10];
            switch (n10) {
                default: {
                    return null;
                }
                case 18: {
                    return PorterDuff.Mode.LIGHTEN;
                }
                case 17: {
                    return PorterDuff.Mode.DARKEN;
                }
                case 16: {
                    return PorterDuff.Mode.OVERLAY;
                }
                case 15: {
                    return PorterDuff.Mode.SCREEN;
                }
                case 14: {
                    return PorterDuff.Mode.MULTIPLY;
                }
                case 13: {
                    return PorterDuff.Mode.ADD;
                }
                case 12: {
                    return PorterDuff.Mode.XOR;
                }
                case 11: {
                    return PorterDuff.Mode.DST_ATOP;
                }
                case 10: {
                    return PorterDuff.Mode.SRC_ATOP;
                }
                case 9: {
                    return PorterDuff.Mode.DST_OUT;
                }
                case 8: {
                    return PorterDuff.Mode.SRC_OUT;
                }
                case 7: {
                    return PorterDuff.Mode.DST_IN;
                }
                case 6: {
                    return PorterDuff.Mode.SRC_IN;
                }
                case 5: {
                    return PorterDuff.Mode.DST_OVER;
                }
                case 4: {
                    return PorterDuff.Mode.SRC_OVER;
                }
                case 3: {
                    return PorterDuff.Mode.DST;
                }
                case 2: {
                    return PorterDuff.Mode.SRC;
                }
                case 1: 
            }
            return PorterDuff.Mode.CLEAR;
        }
        return null;
    }
}

