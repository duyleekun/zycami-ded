/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.google.android.exoplayer2.text.ssa;

import android.graphics.PointF;
import com.google.android.exoplayer2.text.ssa.SsaStyle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SsaStyle$Overrides {
    private static final Pattern ALIGNMENT_OVERRIDE_PATTERN;
    private static final Pattern BRACES_PATTERN;
    private static final Pattern MOVE_PATTERN;
    private static final String PADDED_DECIMAL_PATTERN = "\\s*\\d+(?:\\.\\d+)?\\s*";
    private static final Pattern POSITION_PATTERN;
    private static final String TAG = "SsaStyle.Overrides";
    public final int alignment;
    public final PointF position;

    static {
        BRACES_PATTERN = Pattern.compile("\\{([^}]*)\\}");
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        String string2 = PADDED_DECIMAL_PATTERN;
        objectArray[0] = string2;
        POSITION_PATTERN = Pattern.compile(Util.formatInvariant("\\\\pos\\((%1$s),(%1$s)\\)", objectArray));
        Object[] objectArray2 = new Object[n10];
        objectArray2[0] = string2;
        MOVE_PATTERN = Pattern.compile(Util.formatInvariant("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", objectArray2));
        ALIGNMENT_OVERRIDE_PATTERN = Pattern.compile("\\\\an(\\d+)");
    }

    private SsaStyle$Overrides(int n10, PointF pointF) {
        this.alignment = n10;
        this.position = pointF;
    }

    private static int parseAlignmentOverride(String object) {
        int n10;
        Pattern pattern = ALIGNMENT_OVERRIDE_PATTERN;
        int n11 = (int)(((Matcher)(object = pattern.matcher((CharSequence)object))).find() ? 1 : 0);
        if (n11 != 0) {
            n11 = 1;
            object = (String)Assertions.checkNotNull(((Matcher)object).group(n11));
            n10 = SsaStyle.access$000((String)object);
        } else {
            n10 = -1;
        }
        return n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static SsaStyle$Overrides parseFromDialogue(String object) {
        Pattern pattern = BRACES_PATTERN;
        object = pattern.matcher((CharSequence)object);
        int n10 = -1;
        PointF pointF = null;
        int n11 = n10;
        int n12;
        while ((n12 = ((Matcher)object).find()) != 0) {
            n12 = 1;
            String string2 = (String)Assertions.checkNotNull(((Matcher)object).group(n12));
            try {
                PointF pointF2 = SsaStyle$Overrides.parsePosition(string2);
                if (pointF2 != null) {
                    pointF = pointF2;
                }
            }
            catch (RuntimeException runtimeException) {}
            try {
                n12 = SsaStyle$Overrides.parseAlignmentOverride(string2);
                if (n12 == n10) continue;
                n11 = n12;
            }
            catch (RuntimeException runtimeException) {
            }
        }
        return new SsaStyle$Overrides(n11, pointF);
    }

    private static PointF parsePosition(String string2) {
        block6: {
            Object object;
            Object object2;
            block5: {
                int n10;
                int n11;
                boolean bl2;
                block4: {
                    object2 = POSITION_PATTERN.matcher(string2);
                    object = MOVE_PATTERN.matcher(string2);
                    boolean bl3 = ((Matcher)object2).find();
                    bl2 = ((Matcher)object).find();
                    n11 = 2;
                    n10 = 1;
                    if (!bl3) break block4;
                    if (bl2) {
                        int n12 = String.valueOf(string2).length() + 82;
                        StringBuilder stringBuilder = new StringBuilder(n12);
                        stringBuilder.append("Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='");
                        stringBuilder.append(string2);
                        stringBuilder.append("'");
                        string2 = stringBuilder.toString();
                        object = TAG;
                        Log.i((String)object, string2);
                    }
                    string2 = ((Matcher)object2).group(n10);
                    object2 = ((Matcher)object2).group(n11);
                    break block5;
                }
                if (!bl2) break block6;
                string2 = ((Matcher)object).group(n10);
                object2 = ((Matcher)object).group(n11);
            }
            float f10 = Float.parseFloat(((String)Assertions.checkNotNull(string2)).trim());
            float f11 = Float.parseFloat(((String)Assertions.checkNotNull(object2)).trim());
            object = new PointF(f10, f11);
            return object;
        }
        return null;
    }

    public static String stripStyleOverrides(String string2) {
        return BRACES_PATTERN.matcher(string2).replaceAll("");
    }
}

