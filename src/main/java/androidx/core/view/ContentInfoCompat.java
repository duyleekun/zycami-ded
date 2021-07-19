/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ClipData
 *  android.content.ClipData$Item
 *  android.content.ClipDescription
 *  android.net.Uri
 *  android.os.Bundle
 *  android.util.Pair
 */
package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import androidx.core.view.ContentInfoCompat$Builder;
import java.util.ArrayList;
import java.util.List;

public final class ContentInfoCompat {
    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;
    public final ClipData mClip;
    public final Bundle mExtras;
    public final int mFlags;
    public final Uri mLinkUri;
    public final int mSource;

    public ContentInfoCompat(ContentInfoCompat$Builder contentInfoCompat$Builder) {
        int n10;
        ClipData clipData;
        this.mClip = clipData = (ClipData)Preconditions.checkNotNull(contentInfoCompat$Builder.mClip);
        this.mSource = n10 = Preconditions.checkArgumentInRange(contentInfoCompat$Builder.mSource, 0, 3, "source");
        this.mFlags = n10 = Preconditions.checkFlagsArgument(contentInfoCompat$Builder.mFlags, 1);
        clipData = contentInfoCompat$Builder.mLinkUri;
        this.mLinkUri = clipData;
        contentInfoCompat$Builder = contentInfoCompat$Builder.mExtras;
        this.mExtras = contentInfoCompat$Builder;
    }

    private static ClipData buildClipData(ClipDescription clipDescription, List list) {
        int n10;
        ClipDescription clipDescription2 = new ClipDescription(clipDescription);
        clipDescription = (ClipData.Item)list.get(0);
        ClipData clipData = new ClipData(clipDescription2, (ClipData.Item)clipDescription);
        for (int i10 = 1; i10 < (n10 = list.size()); ++i10) {
            clipDescription2 = (ClipData.Item)list.get(i10);
            clipData.addItem((ClipData.Item)clipDescription2);
        }
        return clipData;
    }

    public static String flagsToString(int n10) {
        int n11 = n10 & 1;
        if (n11 != 0) {
            return "FLAG_CONVERT_TO_PLAIN_TEXT";
        }
        return String.valueOf(n10);
    }

    public static String sourceToString(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        return String.valueOf(n10);
                    }
                    return "SOURCE_DRAG_AND_DROP";
                }
                return "SOURCE_INPUT_METHOD";
            }
            return "SOURCE_CLIPBOARD";
        }
        return "SOURCE_APP";
    }

    public ClipData getClip() {
        return this.mClip;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public Uri getLinkUri() {
        return this.mLinkUri;
    }

    public int getSource() {
        return this.mSource;
    }

    public Pair partition(Predicate object) {
        ClipData clipData;
        int n10;
        Object object2 = this.mClip;
        int n11 = object2.getItemCount();
        ClipData clipData2 = null;
        int n12 = 1;
        ContentInfoCompat contentInfoCompat = null;
        if (n11 == n12) {
            object2 = this.mClip.getItemAt(0);
            boolean bl2 = object.test(object2);
            if (bl2) {
                object2 = this;
            } else {
                n11 = 0;
                object2 = null;
            }
            if (!bl2) {
                contentInfoCompat = this;
            }
            return Pair.create((Object)object2, (Object)contentInfoCompat);
        }
        object2 = new ArrayList();
        ArrayList<ClipData> arrayList = new ArrayList<ClipData>();
        for (int i10 = 0; i10 < (n10 = (clipData = this.mClip).getItemCount()); ++i10) {
            clipData = this.mClip.getItemAt(i10);
            boolean bl3 = object.test(clipData);
            if (bl3) {
                ((ArrayList)object2).add(clipData);
                continue;
            }
            arrayList.add(clipData);
        }
        boolean bl4 = ((ArrayList)object2).isEmpty();
        if (bl4) {
            return Pair.create(null, (Object)this);
        }
        bl4 = arrayList.isEmpty();
        if (bl4) {
            return Pair.create((Object)this, null);
        }
        object = new ContentInfoCompat$Builder(this);
        object2 = ContentInfoCompat.buildClipData(this.mClip.getDescription(), (List)object2);
        object = ((ContentInfoCompat$Builder)object).setClip((ClipData)object2).build();
        object2 = new ContentInfoCompat$Builder(this);
        clipData2 = ContentInfoCompat.buildClipData(this.mClip.getDescription(), arrayList);
        object2 = ((ContentInfoCompat$Builder)object2).setClip(clipData2).build();
        return Pair.create((Object)object, (Object)object2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ContentInfoCompat{clip=");
        Object object = this.mClip;
        stringBuilder.append(object);
        stringBuilder.append(", source=");
        object = ContentInfoCompat.sourceToString(this.mSource);
        stringBuilder.append((String)object);
        stringBuilder.append(", flags=");
        object = ContentInfoCompat.flagsToString(this.mFlags);
        stringBuilder.append((String)object);
        stringBuilder.append(", linkUri=");
        object = this.mLinkUri;
        stringBuilder.append(object);
        stringBuilder.append(", extras=");
        object = this.mExtras;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

