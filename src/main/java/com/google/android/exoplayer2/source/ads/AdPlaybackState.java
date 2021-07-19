/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import com.google.android.exoplayer2.source.ads.AdPlaybackState$AdGroup;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class AdPlaybackState {
    public static final int AD_STATE_AVAILABLE = 1;
    public static final int AD_STATE_ERROR = 4;
    public static final int AD_STATE_PLAYED = 3;
    public static final int AD_STATE_SKIPPED = 2;
    public static final int AD_STATE_UNAVAILABLE;
    public static final AdPlaybackState NONE;
    public final int adGroupCount;
    public final long[] adGroupTimesUs;
    public final AdPlaybackState$AdGroup[] adGroups;
    public final long adResumePositionUs;
    public final Object adsId;
    public final long contentDurationUs;

    static {
        AdPlaybackState adPlaybackState;
        long[] lArray = new long[]{};
        NONE = adPlaybackState = new AdPlaybackState((Object)null, lArray, null, 0L, -9223372036854775807L);
    }

    public AdPlaybackState(Object object, long ... lArray) {
        this(object, lArray, (AdPlaybackState$AdGroup[])null, 0L, -9223372036854775807L);
    }

    private AdPlaybackState(Object object, long[] object2, AdPlaybackState$AdGroup[] adPlaybackState$AdGroupArray, long l10, long l11) {
        int n10;
        this.adsId = object;
        this.adGroupTimesUs = object2;
        this.adResumePositionUs = l10;
        this.contentDurationUs = l11;
        this.adGroupCount = n10 = ((long[])object2).length;
        if (adPlaybackState$AdGroupArray == null) {
            int n11;
            adPlaybackState$AdGroupArray = new AdPlaybackState$AdGroup[n10];
            object = null;
            for (n10 = 0; n10 < (n11 = this.adGroupCount); ++n10) {
                object2 = new AdPlaybackState$AdGroup;
                adPlaybackState$AdGroupArray[n10] = object2;
            }
        }
        this.adGroups = adPlaybackState$AdGroupArray;
    }

    private boolean isPositionBeforeAdGroup(long l10, long l11, int n10) {
        long l12 = Long.MIN_VALUE;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        boolean bl2 = false;
        if (l13 == false) {
            return false;
        }
        long[] lArray = this.adGroupTimesUs;
        long l14 = lArray[n10];
        n10 = (int)(l14 == l12 ? 0 : (l14 < l12 ? -1 : 1));
        boolean bl3 = true;
        if (n10 == 0) {
            long l15;
            long l16 = -9223372036854775807L;
            long l17 = l11 - l16;
            n10 = (int)(l17 == 0L ? 0 : (l17 < 0L ? -1 : 1));
            if (n10 == 0 || (l15 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1)) < 0) {
                bl2 = bl3;
            }
            return bl2;
        }
        Object object = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
        if (object < 0) {
            bl2 = bl3;
        }
        return bl2;
    }

    public boolean equals(Object objectArray) {
        Object object;
        Object object2;
        boolean bl2 = true;
        if (this == objectArray) {
            return bl2;
        }
        if (objectArray != null && (object2 = AdPlaybackState.class) == (object = objectArray.getClass())) {
            boolean bl3;
            long l10;
            long l11;
            long l12;
            long l13;
            int n10;
            objectArray = (AdPlaybackState)objectArray;
            object2 = this.adsId;
            object = objectArray.adsId;
            int n11 = Util.areEqual(object2, object);
            if (n11 == 0 || (n11 = this.adGroupCount) != (n10 = objectArray.adGroupCount) || (n11 = (int)((l13 = (l12 = this.adResumePositionUs) - (l11 = objectArray.adResumePositionUs)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) != 0 || (n11 = (int)((l10 = (l12 = this.contentDurationUs) - (l11 = objectArray.contentDurationUs)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0 || (n11 = (int)(Arrays.equals((long[])(object2 = (Object)this.adGroupTimesUs), (long[])(object = (Object)objectArray.adGroupTimesUs)) ? 1 : 0)) == 0 || !(bl3 = Arrays.equals(object2 = this.adGroups, objectArray = objectArray.adGroups))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getAdGroupIndexAfterPositionUs(long l10, long l11) {
        int n10;
        long l12;
        long l13;
        long l14 = Long.MIN_VALUE;
        long l15 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
        int n11 = -1;
        if (l15 != false && ((l15 = (l13 = l11 - (l12 = -9223372036854775807L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) == false || (n10 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1)) < 0)) {
            long l16;
            long l17;
            long l18;
            Object object;
            for (n10 = 0; n10 < (l15 = (long)((long[])(object = this.adGroupTimesUs)).length) && (l15 = (l18 = (l12 = object[n10]) - l14) == 0L ? 0 : (l18 < 0L ? -1 : 1)) != false && ((l17 = (l16 = l10 - (l12 = object[n10])) == 0L ? 0 : (l16 < 0L ? -1 : 1)) >= 0 || (l17 = (long)((AdPlaybackState$AdGroup)(object = (Object)this.adGroups[n10])).hasUnplayedAds()) == false); ++n10) {
            }
            long[] lArray = this.adGroupTimesUs;
            int n12 = lArray.length;
            if (n10 < n12) {
                n11 = n10;
            }
        }
        return n11;
    }

    public int getAdGroupIndexForPositionUs(long l10, long l11) {
        AdPlaybackState$AdGroup adPlaybackState$AdGroup;
        boolean bl2;
        boolean bl3;
        int n10;
        long[] lArray = this.adGroupTimesUs;
        for (n10 = lArray.length + -1; n10 >= 0 && (bl3 = this.isPositionBeforeAdGroup(l10, l11, n10)); n10 += -1) {
        }
        if (n10 < 0 || !(bl2 = (adPlaybackState$AdGroup = this.adGroups[n10]).hasUnplayedAds())) {
            n10 = -1;
        }
        return n10;
    }

    public int hashCode() {
        int n10;
        int n11 = this.adGroupCount * 31;
        Object object = this.adsId;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        n11 = (n11 + n10) * 31;
        n10 = (int)this.adResumePositionUs;
        n11 = (n11 + n10) * 31;
        n10 = (int)this.contentDurationUs;
        n11 = (n11 + n10) * 31;
        n10 = Arrays.hashCode(this.adGroupTimesUs);
        n11 = (n11 + n10) * 31;
        n10 = Arrays.hashCode(this.adGroups);
        return n11 + n10;
    }

    public boolean isAdInErrorState(int object, int n10) {
        AdPlaybackState$AdGroup[] adPlaybackState$AdGroupArray = this.adGroups;
        int n11 = adPlaybackState$AdGroupArray.length;
        boolean bl2 = false;
        if (object >= n11) {
            return false;
        }
        Object object2 = adPlaybackState$AdGroupArray[object];
        int n12 = ((AdPlaybackState$AdGroup)object2).count;
        n11 = -1;
        if (n12 != n11 && n10 < n12 && (object = (Object)(object2 = (Object)((AdPlaybackState$AdGroup)object2).states)[n10]) == (n10 = 4)) {
            bl2 = true;
        }
        return bl2;
    }

    public String toString() {
        String string2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AdPlaybackState(adsId=");
        Object object = this.adsId;
        stringBuilder.append(object);
        stringBuilder.append(", adResumePositionUs=");
        long l10 = this.adResumePositionUs;
        stringBuilder.append(l10);
        stringBuilder.append(", adGroups=[");
        object = null;
        int n10 = 0;
        while (true) {
            int n11;
            String string3;
            AdPlaybackState$AdGroup[] adPlaybackState$AdGroupArray = this.adGroups;
            int n12 = adPlaybackState$AdGroupArray.length;
            string2 = "])";
            if (n10 >= n12) break;
            stringBuilder.append("adGroup(timeUs=");
            long l11 = this.adGroupTimesUs[n10];
            stringBuilder.append(l11);
            stringBuilder.append(", ads=[");
            n12 = 0;
            adPlaybackState$AdGroupArray = null;
            while (true) {
                int[] nArray = this.adGroups[n10].states;
                int n13 = nArray.length;
                string3 = ", ";
                n11 = 1;
                if (n12 >= n13) break;
                stringBuilder.append("ad(state=");
                nArray = this.adGroups[n10].states;
                n13 = nArray[n12];
                if (n13 != 0) {
                    if (n13 != n11) {
                        int n14 = 2;
                        if (n13 != n14) {
                            n14 = 3;
                            if (n13 != n14) {
                                n14 = 4;
                                if (n13 != n14) {
                                    n13 = 63;
                                    stringBuilder.append((char)n13);
                                } else {
                                    n13 = 33;
                                    stringBuilder.append((char)n13);
                                }
                            } else {
                                n13 = 80;
                                stringBuilder.append((char)n13);
                            }
                        } else {
                            n13 = 83;
                            stringBuilder.append((char)n13);
                        }
                    } else {
                        n13 = 82;
                        stringBuilder.append((char)n13);
                    }
                } else {
                    n13 = 95;
                    stringBuilder.append((char)n13);
                }
                stringBuilder.append(", durationUs=");
                long l12 = this.adGroups[n10].durationsUs[n12];
                stringBuilder.append(l12);
                stringBuilder.append(')');
                nArray = this.adGroups[n10].states;
                n13 = nArray.length - n11;
                if (n12 < n13) {
                    stringBuilder.append(string3);
                }
                ++n12;
            }
            stringBuilder.append(string2);
            adPlaybackState$AdGroupArray = this.adGroups;
            n12 = adPlaybackState$AdGroupArray.length - n11;
            if (n10 < n12) {
                stringBuilder.append(string3);
            }
            ++n10;
        }
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public AdPlaybackState withAdCount(int n10, int n11) {
        AdPlaybackState adPlaybackState;
        Object[] objectArray;
        boolean bl2;
        if (n11 > 0) {
            bl2 = true;
        } else {
            bl2 = false;
            objectArray = null;
        }
        Assertions.checkArgument(bl2);
        objectArray = this.adGroups;
        Object object = objectArray[n10];
        int n12 = ((AdPlaybackState$AdGroup)object).count;
        if (n12 == n11) {
            return this;
        }
        n12 = objectArray.length;
        Object[] objectArray2 = objectArray = Util.nullSafeArrayCopy(objectArray, n12);
        objectArray2 = (AdPlaybackState$AdGroup[])objectArray;
        AdPlaybackState$AdGroup adPlaybackState$AdGroup = this.adGroups[n10].withAdCount(n11);
        objectArray2[n10] = adPlaybackState$AdGroup;
        Object object2 = this.adsId;
        long[] lArray = this.adGroupTimesUs;
        long l10 = this.adResumePositionUs;
        long l11 = this.contentDurationUs;
        object = adPlaybackState;
        adPlaybackState = new AdPlaybackState(object2, lArray, (AdPlaybackState$AdGroup[])objectArray2, l10, l11);
        return adPlaybackState;
    }

    public AdPlaybackState withAdDurationsUs(long[][] object) {
        Object object2;
        Object object3;
        Object[] objectArray = this.adGroups;
        int n10 = objectArray.length;
        Object[] objectArray2 = objectArray = Util.nullSafeArrayCopy(objectArray, n10);
        objectArray2 = (AdPlaybackState$AdGroup[])objectArray;
        objectArray = null;
        for (int i10 = 0; i10 < (n10 = this.adGroupCount); ++i10) {
            object3 = objectArray2[i10];
            object2 = object[i10];
            objectArray2[i10] = object3 = ((AdPlaybackState$AdGroup)object3).withAdDurationsUs((long[])object2);
        }
        object = new AdPlaybackState;
        object2 = this.adsId;
        long[] lArray = this.adGroupTimesUs;
        long l10 = this.adResumePositionUs;
        long l11 = this.contentDurationUs;
        object3 = object;
        object(object2, lArray, (AdPlaybackState$AdGroup[])objectArray2, l10, l11);
        return object;
    }

    public AdPlaybackState withAdLoadError(int n10, int n11) {
        Object[] objectArray = this.adGroups;
        int n12 = objectArray.length;
        Object[] objectArray2 = objectArray = Util.nullSafeArrayCopy(objectArray, n12);
        objectArray2 = (AdPlaybackState$AdGroup[])objectArray;
        AdPlaybackState$AdGroup adPlaybackState$AdGroup = ((AdPlaybackState$AdGroup)objectArray2[n10]).withAdState(4, n11);
        objectArray2[n10] = adPlaybackState$AdGroup;
        Object object = this.adsId;
        long[] lArray = this.adGroupTimesUs;
        long l10 = this.adResumePositionUs;
        long l11 = this.contentDurationUs;
        AdPlaybackState adPlaybackState = new AdPlaybackState(object, lArray, (AdPlaybackState$AdGroup[])objectArray2, l10, l11);
        return adPlaybackState;
    }

    public AdPlaybackState withAdResumePositionUs(long l10) {
        long l11 = this.adResumePositionUs;
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return this;
        }
        Object object2 = this.adsId;
        long[] lArray = this.adGroupTimesUs;
        AdPlaybackState$AdGroup[] adPlaybackState$AdGroupArray = this.adGroups;
        long l13 = this.contentDurationUs;
        AdPlaybackState adPlaybackState = new AdPlaybackState(object2, lArray, adPlaybackState$AdGroupArray, l10, l13);
        return adPlaybackState;
    }

    public AdPlaybackState withAdUri(int n10, int n11, Uri uri) {
        Object[] objectArray = this.adGroups;
        int n12 = objectArray.length;
        Object[] objectArray2 = objectArray = Util.nullSafeArrayCopy(objectArray, n12);
        objectArray2 = (AdPlaybackState$AdGroup[])objectArray;
        AdPlaybackState$AdGroup adPlaybackState$AdGroup = ((AdPlaybackState$AdGroup)objectArray2[n10]).withAdUri(uri, n11);
        objectArray2[n10] = adPlaybackState$AdGroup;
        Object object = this.adsId;
        long[] lArray = this.adGroupTimesUs;
        long l10 = this.adResumePositionUs;
        long l11 = this.contentDurationUs;
        AdPlaybackState adPlaybackState = new AdPlaybackState(object, lArray, (AdPlaybackState$AdGroup[])objectArray2, l10, l11);
        return adPlaybackState;
    }

    public AdPlaybackState withContentDurationUs(long l10) {
        long l11 = this.contentDurationUs;
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return this;
        }
        Object object2 = this.adsId;
        long[] lArray = this.adGroupTimesUs;
        AdPlaybackState$AdGroup[] adPlaybackState$AdGroupArray = this.adGroups;
        long l13 = this.adResumePositionUs;
        AdPlaybackState adPlaybackState = new AdPlaybackState(object2, lArray, adPlaybackState$AdGroupArray, l13, l10);
        return adPlaybackState;
    }

    public AdPlaybackState withPlayedAd(int n10, int n11) {
        Object[] objectArray = this.adGroups;
        int n12 = objectArray.length;
        Object[] objectArray2 = objectArray = Util.nullSafeArrayCopy(objectArray, n12);
        objectArray2 = (AdPlaybackState$AdGroup[])objectArray;
        AdPlaybackState$AdGroup adPlaybackState$AdGroup = ((AdPlaybackState$AdGroup)objectArray2[n10]).withAdState(3, n11);
        objectArray2[n10] = adPlaybackState$AdGroup;
        Object object = this.adsId;
        long[] lArray = this.adGroupTimesUs;
        long l10 = this.adResumePositionUs;
        long l11 = this.contentDurationUs;
        AdPlaybackState adPlaybackState = new AdPlaybackState(object, lArray, (AdPlaybackState$AdGroup[])objectArray2, l10, l11);
        return adPlaybackState;
    }

    public AdPlaybackState withSkippedAd(int n10, int n11) {
        Object[] objectArray = this.adGroups;
        int n12 = objectArray.length;
        Object[] objectArray2 = objectArray = Util.nullSafeArrayCopy(objectArray, n12);
        objectArray2 = (AdPlaybackState$AdGroup[])objectArray;
        AdPlaybackState$AdGroup adPlaybackState$AdGroup = ((AdPlaybackState$AdGroup)objectArray2[n10]).withAdState(2, n11);
        objectArray2[n10] = adPlaybackState$AdGroup;
        Object object = this.adsId;
        long[] lArray = this.adGroupTimesUs;
        long l10 = this.adResumePositionUs;
        long l11 = this.contentDurationUs;
        AdPlaybackState adPlaybackState = new AdPlaybackState(object, lArray, (AdPlaybackState$AdGroup[])objectArray2, l10, l11);
        return adPlaybackState;
    }

    public AdPlaybackState withSkippedAdGroup(int n10) {
        Object object = this.adGroups;
        int n11 = ((AdPlaybackState$AdGroup[])object).length;
        Object[] objectArray = object = Util.nullSafeArrayCopy(object, n11);
        objectArray = (AdPlaybackState$AdGroup[])object;
        objectArray[n10] = object = ((AdPlaybackState$AdGroup)objectArray[n10]).withAllAdsSkipped();
        Object object2 = this.adsId;
        long[] lArray = this.adGroupTimesUs;
        long l10 = this.adResumePositionUs;
        long l11 = this.contentDurationUs;
        AdPlaybackState adPlaybackState = new AdPlaybackState(object2, lArray, (AdPlaybackState$AdGroup[])objectArray, l10, l11);
        return adPlaybackState;
    }
}

