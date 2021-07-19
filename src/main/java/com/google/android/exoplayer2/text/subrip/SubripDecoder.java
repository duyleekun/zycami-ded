/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Html
 *  android.text.Spanned
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.text.subrip;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Cue$Builder;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.subrip.SubripSubtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SubripDecoder
extends SimpleSubtitleDecoder {
    private static final String ALIGN_BOTTOM_LEFT = "{\\an1}";
    private static final String ALIGN_BOTTOM_MID = "{\\an2}";
    private static final String ALIGN_BOTTOM_RIGHT = "{\\an3}";
    private static final String ALIGN_MID_LEFT = "{\\an4}";
    private static final String ALIGN_MID_MID = "{\\an5}";
    private static final String ALIGN_MID_RIGHT = "{\\an6}";
    private static final String ALIGN_TOP_LEFT = "{\\an7}";
    private static final String ALIGN_TOP_MID = "{\\an8}";
    private static final String ALIGN_TOP_RIGHT = "{\\an9}";
    private static final float END_FRACTION = 0.92f;
    private static final float MID_FRACTION = 0.5f;
    private static final float START_FRACTION = 0.08f;
    private static final String SUBRIP_ALIGNMENT_TAG = "\\{\\\\an[1-9]\\}";
    private static final Pattern SUBRIP_TAG_PATTERN;
    private static final String SUBRIP_TIMECODE = "(?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?";
    private static final Pattern SUBRIP_TIMING_LINE;
    private static final String TAG = "SubripDecoder";
    private final ArrayList tags;
    private final StringBuilder textBuilder;

    static {
        SUBRIP_TIMING_LINE = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
        SUBRIP_TAG_PATTERN = Pattern.compile("\\{\\\\.*?\\}");
    }

    public SubripDecoder() {
        super(TAG);
        Serializable serializable;
        this.textBuilder = serializable = new StringBuilder();
        super();
        this.tags = serializable;
    }

    private Cue buildCue(Spanned spanned, String string2) {
        float f10;
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        Cue$Builder cue$Builder;
        Object object;
        block32: {
            float f11;
            float f12;
            float f13;
            int n15;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            String string8;
            String string9;
            String string10;
            String string11;
            block31: {
                object = string2;
                cue$Builder = new Cue$Builder();
                cue$Builder = cue$Builder.setText((CharSequence)spanned);
                if (string2 == null) {
                    return cue$Builder.build();
                }
                n14 = string2.hashCode();
                string11 = ALIGN_TOP_RIGHT;
                string10 = ALIGN_TOP_MID;
                string9 = ALIGN_TOP_LEFT;
                string8 = ALIGN_MID_RIGHT;
                string7 = ALIGN_MID_MID;
                string6 = ALIGN_MID_LEFT;
                string5 = ALIGN_BOTTOM_RIGHT;
                string4 = ALIGN_BOTTOM_MID;
                string3 = ALIGN_BOTTOM_LEFT;
                n15 = 4;
                n13 = 3;
                f13 = 4.2E-45f;
                n12 = 2;
                f12 = 2.8E-45f;
                n11 = 1;
                f11 = Float.MIN_VALUE;
                switch (n14) {
                    default: {
                        break;
                    }
                    case -685620462: {
                        n14 = (int)(string2.equals(string11) ? 1 : 0);
                        if (n14 == 0) break;
                        n14 = 5;
                        break block31;
                    }
                    case -685620493: {
                        n14 = (int)(string2.equals(string10) ? 1 : 0);
                        if (n14 == 0) break;
                        n14 = 8;
                        break block31;
                    }
                    case -685620524: {
                        n14 = (int)(string2.equals(string9) ? 1 : 0);
                        if (n14 == 0) break;
                        n14 = n12;
                        break block31;
                    }
                    case -685620555: {
                        n14 = (int)(string2.equals(string8) ? 1 : 0);
                        if (n14 == 0) break;
                        n14 = n15;
                        break block31;
                    }
                    case -685620586: {
                        n14 = (int)(string2.equals(string7) ? 1 : 0);
                        if (n14 == 0) break;
                        n14 = 7;
                        break block31;
                    }
                    case -685620617: {
                        n14 = (int)(string2.equals(string6) ? 1 : 0);
                        if (n14 == 0) break;
                        n14 = n11;
                        break block31;
                    }
                    case -685620648: {
                        n14 = (int)(string2.equals(string5) ? 1 : 0);
                        if (n14 == 0) break;
                        n14 = n13;
                        break block31;
                    }
                    case -685620679: {
                        n14 = (int)(string2.equals(string4) ? 1 : 0);
                        if (n14 == 0) break;
                        n14 = 6;
                        break block31;
                    }
                    case -685620710: {
                        n14 = (int)(string2.equals(string3) ? 1 : 0);
                        if (n14 == 0) break;
                        n14 = 0;
                        break block31;
                    }
                }
                n14 = -1;
            }
            if (n14 != 0 && n14 != n11 && n14 != n12) {
                if (n14 != n13 && n14 != n15 && n14 != (n15 = 5)) {
                    cue$Builder.setPositionAnchor(n11);
                } else {
                    cue$Builder.setPositionAnchor(n12);
                }
            } else {
                n14 = 0;
                cue$Builder.setPositionAnchor(0);
            }
            n14 = string2.hashCode();
            switch (n14) {
                default: {
                    break;
                }
                case -685620462: {
                    n10 = (int)(((String)object).equals(string11) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = 5;
                    f10 = 7.0E-45f;
                    break block32;
                }
                case -685620493: {
                    n10 = (int)(((String)object).equals(string10) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = 4;
                    f10 = 5.6E-45f;
                    break block32;
                }
                case -685620524: {
                    n10 = (int)(((String)object).equals(string9) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = n13;
                    f10 = f13;
                    break block32;
                }
                case -685620555: {
                    n10 = (int)(((String)object).equals(string8) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = 8;
                    f10 = 1.1E-44f;
                    break block32;
                }
                case -685620586: {
                    n10 = (int)(((String)object).equals(string7) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = 7;
                    f10 = 9.8E-45f;
                    break block32;
                }
                case -685620617: {
                    n10 = (int)(((String)object).equals(string6) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = 6;
                    f10 = 8.4E-45f;
                    break block32;
                }
                case -685620648: {
                    n10 = (int)(((String)object).equals(string5) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = n12;
                    f10 = f12;
                    break block32;
                }
                case -685620679: {
                    n10 = (int)(((String)object).equals(string4) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = n11;
                    f10 = f11;
                    break block32;
                }
                case -685620710: {
                    n10 = (int)(((String)object).equals(string3) ? 1 : 0);
                    if (n10 == 0) break;
                    n10 = 0;
                    f10 = 0.0f;
                    object = null;
                    break block32;
                }
            }
            n10 = -1;
            f10 = 0.0f / 0.0f;
        }
        if (n10 != 0 && n10 != n11 && n10 != n12) {
            if (n10 != n13 && n10 != (n14 = 4) && n10 != (n14 = 5)) {
                cue$Builder.setLineAnchor(n11);
            } else {
                n10 = 0;
                f10 = 0.0f;
                object = null;
                cue$Builder.setLineAnchor(0);
            }
        } else {
            cue$Builder.setLineAnchor(n12);
        }
        f10 = SubripDecoder.getFractionalPositionForAnchorType(cue$Builder.getPositionAnchor());
        object = cue$Builder.setPosition(f10);
        float f14 = SubripDecoder.getFractionalPositionForAnchorType(cue$Builder.getLineAnchor());
        return ((Cue$Builder)object).setLine(f14, 0).build();
    }

    public static float getFractionalPositionForAnchorType(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 == n11) {
                    return 0.92f;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                throw illegalArgumentException;
            }
            return 0.5f;
        }
        return 0.08f;
    }

    private static long parseTimecode(Matcher object, int n10) {
        int n11 = n10 + 1;
        String string2 = ((Matcher)object).group(n11);
        long l10 = 60;
        long l11 = 1000L;
        long l12 = string2 != null ? Long.parseLong(string2) * l10 * l10 * l11 : 0L;
        n11 = n10 + 2;
        long l13 = Long.parseLong((String)Assertions.checkNotNull(((Matcher)object).group(n11))) * l10 * l11;
        l12 += l13;
        n11 = n10 + 3;
        string2 = (String)Assertions.checkNotNull(((Matcher)object).group(n11));
        long l14 = Long.parseLong(string2) * l11;
        l12 += l14;
        if ((object = ((Matcher)object).group(n10 += 4)) != null) {
            long l15 = Long.parseLong((String)object);
            l12 += l15;
        }
        return l12 * l11;
    }

    private String processLine(String object, ArrayList arrayList) {
        int n10;
        object = ((String)object).trim();
        StringBuilder stringBuilder = new StringBuilder((String)object);
        object = SUBRIP_TAG_PATTERN.matcher((CharSequence)object);
        int n11 = 0;
        while ((n10 = ((Matcher)object).find()) != 0) {
            String string2 = ((Matcher)object).group();
            arrayList.add(string2);
            int n12 = ((Matcher)object).start() - n11;
            n10 = string2.length();
            int n13 = n12 + n10;
            String string3 = "";
            stringBuilder.replace(n12, n13, string3);
            n11 += n10;
        }
        return stringBuilder.toString();
    }

    public Subtitle decode(byte[] object, int n10, boolean bl2) {
        Object object2;
        Object object3 = TAG;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        LongArray longArray = new LongArray();
        ParsableByteArray parsableByteArray = new ParsableByteArray((byte[])object, n10);
        while (true) {
            object = parsableByteArray.readLine();
            n10 = 0;
            object2 = null;
            if (object == null) break;
            int n11 = ((String)object).length();
            if (n11 == 0) continue;
            try {
                Integer.parseInt((String)object);
            }
            catch (NumberFormatException numberFormatException) {
                object2 = "Skipping invalid index: ";
                object = String.valueOf(object);
                n11 = ((String)object).length();
                object = n11 != 0 ? ((String)object2).concat((String)object) : new String((String)object2);
                Log.w((String)object3, (String)object);
                continue;
            }
            object = parsableByteArray.readLine();
            if (object == null) {
                object = "Unexpected end";
                Log.w((String)object3, (String)object);
                break;
            }
            Object object4 = SUBRIP_TIMING_LINE.matcher((CharSequence)object);
            int n12 = ((Matcher)object4).matches();
            if (n12 != 0) {
                Object object5;
                long l10 = SubripDecoder.parseTimecode((Matcher)object4, 1);
                longArray.add(l10);
                int n13 = 6;
                long l11 = SubripDecoder.parseTimecode((Matcher)object4, n13);
                longArray.add(l11);
                this.textBuilder.setLength(0);
                this.tags.clear();
                object = parsableByteArray.readLine();
                while ((n11 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0)) == 0) {
                    object4 = this.textBuilder;
                    n11 = ((StringBuilder)object4).length();
                    if (n11 > 0) {
                        object4 = this.textBuilder;
                        object5 = "<br>";
                        ((StringBuilder)object4).append((String)object5);
                    }
                    object4 = this.textBuilder;
                    object5 = this.tags;
                    object = this.processLine((String)object, (ArrayList)object5);
                    ((StringBuilder)object4).append((String)object);
                    object = parsableByteArray.readLine();
                }
                object = Html.fromHtml((String)this.textBuilder.toString());
                n11 = 0;
                object4 = null;
                while (n10 < (n12 = ((ArrayList)(object5 = this.tags)).size())) {
                    String string2;
                    object5 = (String)this.tags.get(n10);
                    boolean bl3 = ((String)object5).matches(string2 = SUBRIP_ALIGNMENT_TAG);
                    if (bl3) {
                        object4 = object5;
                        break;
                    }
                    ++n10;
                }
                object = this.buildCue((Spanned)object, (String)object4);
                arrayList.add(object);
                object = Cue.EMPTY;
                arrayList.add(object);
                continue;
            }
            object2 = "Skipping invalid timing: ";
            n11 = ((String)(object = String.valueOf(object))).length();
            object = n11 != 0 ? ((String)object2).concat((String)object) : new String((String)object2);
            Log.w((String)object3, (String)object);
            continue;
            break;
        }
        object = new Cue[]{};
        object = (Cue[])arrayList.toArray((T[])object);
        object2 = longArray.toArray();
        object3 = new SubripSubtitle((Cue[])object, (long[])object2);
        return object3;
    }
}

