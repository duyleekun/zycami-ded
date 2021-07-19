/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.Rating
 *  android.os.Build$VERSION
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.Log
 */
package android.support.v4.media;

import android.media.Rating;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.RatingCompat$1;
import android.util.Log;

public final class RatingCompat
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    private static final float RATING_NOT_RATED = -1.0f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private static final String TAG = "Rating";
    private Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;

    static {
        RatingCompat$1 ratingCompat$1 = new RatingCompat$1();
        CREATOR = ratingCompat$1;
    }

    public RatingCompat(int n10, float f10) {
        this.mRatingStyle = n10;
        this.mRatingValue = f10;
    }

    public static RatingCompat fromRating(Object object) {
        int n10;
        int n11;
        boolean bl2 = false;
        float f10 = 0.0f;
        RatingCompat ratingCompat = null;
        if (object != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 19)) {
            Object object2 = object;
            object2 = (Rating)object;
            n10 = object2.getRatingStyle();
            boolean bl3 = object2.isRated();
            if (bl3) {
                switch (n10) {
                    default: {
                        return null;
                    }
                    case 6: {
                        f10 = object2.getPercentRating();
                        ratingCompat = RatingCompat.newPercentageRating(f10);
                        break;
                    }
                    case 3: 
                    case 4: 
                    case 5: {
                        f10 = object2.getStarRating();
                        ratingCompat = RatingCompat.newStarRating(n10, f10);
                        break;
                    }
                    case 2: {
                        bl2 = object2.isThumbUp();
                        ratingCompat = RatingCompat.newThumbRating(bl2);
                        break;
                    }
                    case 1: {
                        bl2 = object2.hasHeart();
                        ratingCompat = RatingCompat.newHeartRating(bl2);
                        break;
                    }
                }
            } else {
                ratingCompat = RatingCompat.newUnratedRating(n10);
            }
            ratingCompat.mRatingObj = object;
        }
        return ratingCompat;
    }

    public static RatingCompat newHeartRating(boolean bl2) {
        float f10;
        if (bl2) {
            int n10 = 1065353216;
            f10 = 1.0f;
        } else {
            boolean bl3 = false;
            f10 = 0.0f;
        }
        RatingCompat ratingCompat = new RatingCompat(1, f10);
        return ratingCompat;
    }

    public static RatingCompat newPercentageRating(float f10) {
        float f11;
        float f12 = 0.0f;
        RatingCompat ratingCompat = null;
        float f13 = f10 - 0.0f;
        float f14 = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
        if (f14 >= 0 && (f14 = (f11 = f10 - (f12 = 100.0f)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) <= 0) {
            ratingCompat = new RatingCompat(6, f10);
            return ratingCompat;
        }
        Log.e((String)TAG, (String)"Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat newStarRating(int n10, float f10) {
        float f11;
        int n11 = 3;
        float f12 = 4.2E-45f;
        String string2 = TAG;
        if (n10 != n11) {
            n11 = 4;
            f12 = 5.6E-45f;
            if (n10 != n11) {
                n11 = 5;
                f12 = 7.0E-45f;
                if (n10 != n11) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid rating style (");
                    stringBuilder.append(n10);
                    stringBuilder.append(") for a star rating");
                    String string3 = stringBuilder.toString();
                    Log.e((String)string2, (String)string3);
                    return null;
                }
                n11 = 0x40A00000;
                f12 = 5.0f;
            } else {
                n11 = 0x40800000;
                f12 = 4.0f;
            }
        } else {
            n11 = 0x40400000;
            f12 = 3.0f;
        }
        float f13 = (f11 = f10 - 0.0f) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1);
        if (f13 >= 0 && (n11 = (int)(f10 == f12 ? 0 : (f10 > f12 ? 1 : -1))) <= 0) {
            RatingCompat ratingCompat = new RatingCompat(n10, f10);
            return ratingCompat;
        }
        Log.e((String)string2, (String)"Trying to set out of range star-based rating");
        return null;
    }

    public static RatingCompat newThumbRating(boolean bl2) {
        float f10;
        if (bl2) {
            int n10 = 1065353216;
            f10 = 1.0f;
        } else {
            boolean bl3 = false;
            f10 = 0.0f;
        }
        RatingCompat ratingCompat = new RatingCompat(2, f10);
        return ratingCompat;
    }

    public static RatingCompat newUnratedRating(int n10) {
        switch (n10) {
            default: {
                return null;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
        }
        RatingCompat ratingCompat = new RatingCompat(n10, -1.0f);
        return ratingCompat;
    }

    public int describeContents() {
        return this.mRatingStyle;
    }

    public float getPercentRating() {
        int n10 = this.mRatingStyle;
        int n11 = 6;
        if (n10 == n11 && (n10 = (int)(this.isRated() ? 1 : 0)) != 0) {
            return this.mRatingValue;
        }
        return -1.0f;
    }

    public Object getRating() {
        Object object = this.mRatingObj;
        if (object == null) {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 19;
            float f10 = 2.7E-44f;
            if (n10 >= n11) {
                n10 = this.isRated() ? 1 : 0;
                if (n10 != 0) {
                    n10 = this.mRatingStyle;
                    switch (n10) {
                        default: {
                            return null;
                        }
                        case 6: {
                            float f11 = this.getPercentRating();
                            this.mRatingObj = object = Rating.newPercentageRating((float)f11);
                            break;
                        }
                        case 3: 
                        case 4: 
                        case 5: {
                            f10 = this.getStarRating();
                            this.mRatingObj = object = Rating.newStarRating((int)n10, (float)f10);
                            break;
                        }
                        case 2: {
                            n10 = this.isThumbUp() ? 1 : 0;
                            this.mRatingObj = object = Rating.newThumbRating(n10 != 0);
                            break;
                        }
                        case 1: {
                            n10 = this.hasHeart() ? 1 : 0;
                            this.mRatingObj = object = Rating.newHeartRating(n10 != 0);
                            break;
                        }
                    }
                } else {
                    n10 = this.mRatingStyle;
                    this.mRatingObj = object = Rating.newUnratedRating((int)n10);
                }
            }
        }
        return this.mRatingObj;
    }

    public int getRatingStyle() {
        return this.mRatingStyle;
    }

    public float getStarRating() {
        int n10 = this.mRatingStyle;
        int n11 = 3;
        if ((n10 == n11 || n10 == (n11 = 4) || n10 == (n11 = 5)) && (n10 = (int)(this.isRated() ? 1 : 0)) != 0) {
            return this.mRatingValue;
        }
        return -1.0f;
    }

    public boolean hasHeart() {
        boolean bl2 = this.mRatingStyle;
        boolean bl3 = false;
        boolean bl4 = true;
        if (bl2 != bl4) {
            return false;
        }
        float f10 = this.mRatingValue;
        float f11 = 1.0f;
        float f12 = f10 - f11;
        float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (f13 == false) {
            bl3 = bl4;
        }
        return bl3;
    }

    public boolean isRated() {
        float f10 = this.mRatingValue;
        float f11 = f10 - 0.0f;
        float f12 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (f12 >= 0) {
            f12 = 1.0f;
            f10 = Float.MIN_VALUE;
        } else {
            f12 = 0.0f;
            f10 = 0.0f;
        }
        return (boolean)f12;
    }

    public boolean isThumbUp() {
        int n10 = this.mRatingStyle;
        boolean bl2 = false;
        int n11 = 2;
        float f10 = 2.8E-45f;
        if (n10 != n11) {
            return false;
        }
        float f11 = this.mRatingValue;
        n11 = 1065353216;
        f10 = 1.0f;
        float f12 = f11 - f10;
        n10 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (n10 == 0) {
            bl2 = true;
        }
        return bl2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rating:style=");
        int n10 = this.mRatingStyle;
        stringBuilder.append(n10);
        String string2 = " rating=";
        stringBuilder.append(string2);
        float f10 = this.mRatingValue;
        float f11 = f10 - 0.0f;
        float f12 = f11 == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1);
        string2 = f12 < 0 ? "unrated" : String.valueOf(f10);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.mRatingStyle;
        parcel.writeInt(n10);
        float f10 = this.mRatingValue;
        parcel.writeFloat(f10);
    }
}

