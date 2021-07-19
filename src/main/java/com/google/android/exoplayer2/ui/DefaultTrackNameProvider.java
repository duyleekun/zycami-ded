/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.ui;

import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ui.R$string;
import com.google.android.exoplayer2.ui.TrackNameProvider;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.Locale;

public class DefaultTrackNameProvider
implements TrackNameProvider {
    private final Resources resources;

    public DefaultTrackNameProvider(Resources resources) {
        this.resources = resources = (Resources)Assertions.checkNotNull(resources);
    }

    private String buildAudioChannelString(Format format) {
        int n10 = format.channelCount;
        int n11 = -1;
        if (n10 != n11 && n10 >= (n11 = 1)) {
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 6;
                    if (n10 != n11 && n10 != (n11 = 7)) {
                        n11 = 8;
                        if (n10 != n11) {
                            format = this.resources;
                            n11 = R$string.exo_track_surround;
                            return format.getString(n11);
                        }
                        format = this.resources;
                        n11 = R$string.exo_track_surround_7_point_1;
                        return format.getString(n11);
                    }
                    format = this.resources;
                    n11 = R$string.exo_track_surround_5_point_1;
                    return format.getString(n11);
                }
                format = this.resources;
                n11 = R$string.exo_track_stereo;
                return format.getString(n11);
            }
            format = this.resources;
            n11 = R$string.exo_track_mono;
            return format.getString(n11);
        }
        return "";
    }

    private String buildBitrateString(Format object) {
        int n10 = ((Format)object).bitrate;
        int n11 = -1;
        if (n10 == n11) {
            object = "";
        } else {
            Resources resources = this.resources;
            int n12 = R$string.exo_track_bitrate;
            int n13 = 1;
            Object[] objectArray = new Object[n13];
            float f10 = n10;
            float f11 = 1000000.0f;
            objectArray[0] = object = Float.valueOf(f10 /= f11);
            object = resources.getString(n12, objectArray);
        }
        return object;
    }

    private String buildLabelString(Format object) {
        String string2 = ((Format)object).label;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        object = bl2 ? "" : ((Format)object).label;
        return object;
    }

    private String buildLanguageOrLabelString(Format format) {
        String string2;
        int n10 = 2;
        Object object = new String[n10];
        object[0] = string2 = this.buildLanguageString(format);
        string2 = this.buildRoleString(format);
        int n11 = 1;
        object[n11] = string2;
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = this.joinWithSeparator((String)object)));
        if (bl2) {
            object = this.buildLabelString(format);
        }
        return object;
    }

    private String buildLanguageString(Format object) {
        Object object2;
        object = ((Format)object).language;
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 == 0 && (n10 = ((String)(object2 = "und")).equals(object)) == 0) {
            n10 = Util.SDK_INT;
            int n11 = 21;
            object = n10 >= n11 ? Locale.forLanguageTag((String)object) : (object2 = new Locale((String)object));
            return ((Locale)object).getDisplayName();
        }
        return "";
    }

    private String buildResolutionString(Format object) {
        int n10 = ((Format)object).width;
        int n11 = ((Format)object).height;
        int n12 = -1;
        if (n10 != n12 && n11 != n12) {
            Resources resources = this.resources;
            int n13 = R$string.exo_track_resolution;
            int n14 = 2;
            Object[] objectArray = new Object[n14];
            Integer n15 = n10;
            objectArray[0] = n15;
            n10 = 1;
            objectArray[n10] = object = Integer.valueOf(n11);
            object = resources.getString(n13, objectArray);
        } else {
            object = "";
        }
        return object;
    }

    private String buildRoleString(Format stringArray) {
        int n10;
        int n11;
        String[] stringArray2;
        int n12;
        String string2;
        int n13 = stringArray.roleFlags;
        int n14 = 2;
        if ((n13 &= n14) != 0) {
            string2 = this.resources;
            n12 = R$string.exo_track_role_alternate;
            string2 = string2.getString(n12);
        } else {
            string2 = "";
        }
        n12 = stringArray.roleFlags & 4;
        int n15 = 1;
        if (n12 != 0) {
            stringArray2 = new String[n14];
            stringArray2[0] = string2;
            string2 = this.resources;
            n11 = R$string.exo_track_role_supplementary;
            stringArray2[n15] = string2 = string2.getString(n11);
            string2 = this.joinWithSeparator(stringArray2);
        }
        if ((n12 = stringArray.roleFlags & 8) != 0) {
            stringArray2 = new String[n14];
            stringArray2[0] = string2;
            string2 = this.resources;
            n11 = R$string.exo_track_role_commentary;
            stringArray2[n15] = string2 = string2.getString(n11);
            string2 = this.joinWithSeparator(stringArray2);
        }
        if ((n10 = stringArray.roleFlags & 0x440) != 0) {
            stringArray = new String[n14];
            stringArray[0] = string2;
            string2 = this.resources;
            n14 = R$string.exo_track_role_closed_captions;
            stringArray[n15] = string2 = string2.getString(n14);
            string2 = this.joinWithSeparator(stringArray);
        }
        return string2;
    }

    private static int inferPrimaryTrackType(Format format) {
        int n10;
        String string2 = format.sampleMimeType;
        int n11 = MimeTypes.getTrackType(string2);
        if (n11 != (n10 = -1)) {
            return n11;
        }
        string2 = MimeTypes.getVideoMediaMimeType(format.codecs);
        int n12 = 2;
        if (string2 != null) {
            return n12;
        }
        string2 = MimeTypes.getAudioMediaMimeType(format.codecs);
        int n13 = 1;
        if (string2 != null) {
            return n13;
        }
        n11 = format.width;
        if (n11 == n10 && (n11 = format.height) == n10) {
            int n14;
            n11 = format.channelCount;
            if (n11 == n10 && (n14 = format.sampleRate) == n10) {
                return n10;
            }
            return n13;
        }
        return n12;
    }

    private String joinWithSeparator(String ... stringArray) {
        int n10 = stringArray.length;
        String string2 = "";
        for (int i10 = 0; i10 < n10; ++i10) {
            String string3 = stringArray[i10];
            int n11 = string3.length();
            if (n11 <= 0) continue;
            n11 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
            if (n11 != 0) {
                string2 = string3;
                continue;
            }
            Resources resources = this.resources;
            int n12 = R$string.exo_item_list;
            int n13 = 2;
            Object[] objectArray = new Object[n13];
            objectArray[0] = string2;
            int n14 = 1;
            objectArray[n14] = string3;
            string2 = resources.getString(n12, objectArray);
        }
        return string2;
    }

    public String getTrackName(Format object) {
        int n10 = DefaultTrackNameProvider.inferPrimaryTrackType((Format)object);
        String string2 = null;
        int n11 = 3;
        int n12 = 1;
        int n13 = 2;
        if (n10 == n13) {
            String string3;
            String[] stringArray = new String[n11];
            stringArray[0] = string3 = this.buildRoleString((Format)object);
            stringArray[n12] = string2 = this.buildResolutionString((Format)object);
            stringArray[n13] = object = this.buildBitrateString((Format)object);
            object = this.joinWithSeparator(stringArray);
        } else if (n10 == n12) {
            String string4;
            String[] stringArray = new String[n11];
            stringArray[0] = string4 = this.buildLanguageOrLabelString((Format)object);
            stringArray[n12] = string2 = this.buildAudioChannelString((Format)object);
            stringArray[n13] = object = this.buildBitrateString((Format)object);
            object = this.joinWithSeparator(stringArray);
        } else {
            object = this.buildLanguageOrLabelString((Format)object);
        }
        n10 = ((String)object).length();
        if (n10 == 0) {
            object = this.resources;
            n10 = R$string.exo_track_unknown;
            object = object.getString(n10);
        }
        return object;
    }
}

