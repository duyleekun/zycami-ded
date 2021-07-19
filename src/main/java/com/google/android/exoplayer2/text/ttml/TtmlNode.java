/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.text.Layout$Alignment
 *  android.text.Spannable
 *  android.text.SpannableStringBuilder
 *  android.util.Base64
 *  android.util.Pair
 */
package com.google.android.exoplayer2.text.ttml;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.text.Cue$Builder;
import com.google.android.exoplayer2.text.ttml.DeleteTextSpan;
import com.google.android.exoplayer2.text.ttml.TtmlRegion;
import com.google.android.exoplayer2.text.ttml.TtmlRenderUtil;
import com.google.android.exoplayer2.text.ttml.TtmlStyle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public final class TtmlNode {
    public static final String ANONYMOUS_REGION_ID = "";
    public static final String ATTR_ID = "id";
    public static final String ATTR_TTS_BACKGROUND_COLOR = "backgroundColor";
    public static final String ATTR_TTS_COLOR = "color";
    public static final String ATTR_TTS_DISPLAY_ALIGN = "displayAlign";
    public static final String ATTR_TTS_EXTENT = "extent";
    public static final String ATTR_TTS_FONT_FAMILY = "fontFamily";
    public static final String ATTR_TTS_FONT_SIZE = "fontSize";
    public static final String ATTR_TTS_FONT_STYLE = "fontStyle";
    public static final String ATTR_TTS_FONT_WEIGHT = "fontWeight";
    public static final String ATTR_TTS_ORIGIN = "origin";
    public static final String ATTR_TTS_RUBY = "ruby";
    public static final String ATTR_TTS_RUBY_POSITION = "rubyPosition";
    public static final String ATTR_TTS_TEXT_ALIGN = "textAlign";
    public static final String ATTR_TTS_TEXT_COMBINE = "textCombine";
    public static final String ATTR_TTS_TEXT_DECORATION = "textDecoration";
    public static final String ATTR_TTS_WRITING_MODE = "writingMode";
    public static final String BOLD = "bold";
    public static final String CENTER = "center";
    public static final String COMBINE_ALL = "all";
    public static final String COMBINE_NONE = "none";
    public static final String END = "end";
    public static final String ITALIC = "italic";
    public static final String LEFT = "left";
    public static final String LINETHROUGH = "linethrough";
    public static final String NO_LINETHROUGH = "nolinethrough";
    public static final String NO_UNDERLINE = "nounderline";
    public static final String RIGHT = "right";
    public static final String RUBY_AFTER = "after";
    public static final String RUBY_BASE = "base";
    public static final String RUBY_BASE_CONTAINER = "baseContainer";
    public static final String RUBY_BEFORE = "before";
    public static final String RUBY_CONTAINER = "container";
    public static final String RUBY_DELIMITER = "delimiter";
    public static final String RUBY_TEXT = "text";
    public static final String RUBY_TEXT_CONTAINER = "textContainer";
    public static final String START = "start";
    public static final String TAG_BODY = "body";
    public static final String TAG_BR = "br";
    public static final String TAG_DATA = "data";
    public static final String TAG_DIV = "div";
    public static final String TAG_HEAD = "head";
    public static final String TAG_IMAGE = "image";
    public static final String TAG_INFORMATION = "information";
    public static final String TAG_LAYOUT = "layout";
    public static final String TAG_METADATA = "metadata";
    public static final String TAG_P = "p";
    public static final String TAG_REGION = "region";
    public static final String TAG_SPAN = "span";
    public static final String TAG_STYLE = "style";
    public static final String TAG_STYLING = "styling";
    public static final String TAG_TT = "tt";
    public static final String UNDERLINE = "underline";
    public static final String VERTICAL = "tb";
    public static final String VERTICAL_LR = "tblr";
    public static final String VERTICAL_RL = "tbrl";
    private List children;
    public final long endTimeUs;
    public final String imageId;
    public final boolean isTextNode;
    private final HashMap nodeEndsByRegion;
    private final HashMap nodeStartsByRegion;
    public final TtmlNode parent;
    public final String regionId;
    public final long startTimeUs;
    public final TtmlStyle style;
    private final String[] styleIds;
    public final String tag;
    public final String text;

    private TtmlNode(String hashMap, String string2, long l10, long l11, TtmlStyle ttmlStyle, String[] stringArray, String string3, String string4, TtmlNode ttmlNode) {
        boolean bl2;
        this.tag = hashMap;
        this.text = string2;
        this.imageId = string4;
        this.style = ttmlStyle;
        this.styleIds = stringArray;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            hashMap = null;
        }
        this.isTextNode = bl2;
        this.startTimeUs = l10;
        this.endTimeUs = l11;
        hashMap = (String)Assertions.checkNotNull(string3);
        this.regionId = hashMap;
        this.parent = ttmlNode;
        this.nodeStartsByRegion = hashMap = new HashMap();
        this.nodeEndsByRegion = hashMap = new HashMap();
    }

    private void applyStyleToOutput(Map map, Cue$Builder cue$Builder, int n10, int n11) {
        TtmlStyle ttmlStyle = this.style;
        SpannableStringBuilder spannableStringBuilder = this.styleIds;
        ttmlStyle = TtmlRenderUtil.resolveStyle(ttmlStyle, (String[])spannableStringBuilder, map);
        spannableStringBuilder = (SpannableStringBuilder)cue$Builder.getText();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            cue$Builder.setText((CharSequence)spannableStringBuilder);
        }
        if (ttmlStyle != null) {
            TtmlNode ttmlNode = this.parent;
            TtmlRenderUtil.applyStylesToSpan((Spannable)spannableStringBuilder, n10, n11, ttmlStyle, ttmlNode, map);
            map = ttmlStyle.getTextAlign();
            cue$Builder.setTextAlignment((Layout.Alignment)map);
        }
    }

    public static TtmlNode buildNode(String string2, long l10, long l11, TtmlStyle ttmlStyle, String[] stringArray, String string3, String string4, TtmlNode ttmlNode) {
        TtmlNode ttmlNode2 = new TtmlNode(string2, null, l10, l11, ttmlStyle, stringArray, string3, string4, ttmlNode);
        return ttmlNode2;
    }

    public static TtmlNode buildTextNode(String string2) {
        String string3 = TtmlRenderUtil.applyTextElementSpacePolicy(string2);
        TtmlNode ttmlNode = new TtmlNode(null, string3, -9223372036854775807L, -9223372036854775807L, null, null, ANONYMOUS_REGION_ID, null, null);
        return ttmlNode;
    }

    private static void cleanUpText(SpannableStringBuilder spannableStringBuilder) {
        int n10;
        int n11;
        int n12;
        int n13;
        int n14 = spannableStringBuilder.length();
        Class<DeleteTextSpan> clazz = DeleteTextSpan.class;
        int n15 = 0;
        for (DeleteTextSpan deleteTextSpan : (DeleteTextSpan[])spannableStringBuilder.getSpans(0, n14, clazz)) {
            n13 = spannableStringBuilder.getSpanStart((Object)deleteTextSpan);
            n12 = spannableStringBuilder.getSpanEnd((Object)deleteTextSpan);
            String string2 = ANONYMOUS_REGION_ID;
            spannableStringBuilder.replace(n13, n12, (CharSequence)string2);
        }
        n14 = 0;
        DeleteTextSpan[] deleteTextSpanArray = null;
        while (true) {
            n11 = spannableStringBuilder.length();
            n10 = 32;
            if (n14 >= n11) break;
            n11 = spannableStringBuilder.charAt(n14);
            if (n11 == n10) {
                for (n12 = n11 = n14 + 1; n12 < (n13 = spannableStringBuilder.length()) && (n13 = (int)spannableStringBuilder.charAt(n12)) == n10; ++n12) {
                }
                if ((n12 -= n11) > 0) {
                    spannableStringBuilder.delete(n14, n12 += n14);
                }
            }
            ++n14;
        }
        n14 = spannableStringBuilder.length();
        n11 = 1;
        if (n14 > 0 && (n14 = (int)spannableStringBuilder.charAt(0)) == n10) {
            spannableStringBuilder.delete(0, n11);
        }
        n14 = 0;
        deleteTextSpanArray = null;
        while (true) {
            n12 = spannableStringBuilder.length() - n11;
            n13 = 10;
            if (n14 >= n12) break;
            n12 = spannableStringBuilder.charAt(n14);
            if (n12 == n13 && (n13 = (int)spannableStringBuilder.charAt(n12 = n14 + 1)) == n10) {
                n13 = n14 + 2;
                spannableStringBuilder.delete(n12, n13);
            }
            ++n14;
        }
        n14 = spannableStringBuilder.length();
        if (n14 > 0) {
            n14 = spannableStringBuilder.length() - n11;
            if ((n14 = (int)spannableStringBuilder.charAt(n14)) == n10) {
                n14 = spannableStringBuilder.length() - n11;
                n12 = spannableStringBuilder.length();
                spannableStringBuilder.delete(n14, n12);
            }
        }
        while (n15 < (n14 = spannableStringBuilder.length() - n11)) {
            n14 = spannableStringBuilder.charAt(n15);
            if (n14 == n10 && (n12 = (int)spannableStringBuilder.charAt(n14 = n15 + 1)) == n13) {
                spannableStringBuilder.delete(n15, n14);
            }
            ++n15;
        }
        n14 = spannableStringBuilder.length();
        if (n14 > 0) {
            n14 = spannableStringBuilder.length() - n11;
            if ((n14 = (int)spannableStringBuilder.charAt(n14)) == n13) {
                n14 = spannableStringBuilder.length() - n11;
                n11 = spannableStringBuilder.length();
                spannableStringBuilder.delete(n14, n11);
            }
        }
    }

    private void getEventTimes(TreeSet treeSet, boolean bl2) {
        Object object;
        long l10;
        String string2 = this.tag;
        boolean bl3 = TAG_P.equals(string2);
        Object object2 = this.tag;
        String string3 = TAG_DIV;
        boolean bl4 = string3.equals(object2);
        if (bl2 || bl3 || bl4 && (object2 = this.imageId) != null) {
            long l11;
            long l12 = this.startTimeUs;
            long l13 = -9223372036854775807L;
            long l14 = l12 - l13;
            Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object3 != false) {
                object2 = l12;
                treeSet.add(object2);
            }
            if ((l10 = (l11 = (l12 = this.endTimeUs) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
                object2 = l12;
                treeSet.add(object2);
            }
        }
        if ((object2 = this.children) == null) {
            return;
        }
        bl4 = false;
        object2 = null;
        string3 = null;
        for (int i10 = 0; i10 < (l10 = (long)(object = this.children).size()); ++i10) {
            object = (TtmlNode)this.children.get(i10);
            boolean bl5 = bl2 || bl3;
            super.getEventTimes(treeSet, bl5);
        }
    }

    private static SpannableStringBuilder getRegionOutputText(String string2, Map map) {
        boolean bl2 = map.containsKey(string2);
        if (!bl2) {
            Cue$Builder cue$Builder = new Cue$Builder();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            cue$Builder.setText((CharSequence)spannableStringBuilder);
            map.put(string2, cue$Builder);
        }
        return (SpannableStringBuilder)Assertions.checkNotNull(((Cue$Builder)map.get(string2)).getText());
    }

    /*
     * WARNING - void declaration
     */
    private void traverseForImage(long l10, String string2, List list) {
        int n10;
        void var7_10;
        boolean bl2;
        Object object = ANONYMOUS_REGION_ID;
        String string3 = this.regionId;
        boolean n11 = ((String)object).equals(string3);
        if (!n11) {
            string2 = this.regionId;
        }
        boolean bl3 = this.isActive(l10);
        if (bl3 && (bl2 = ((String)(object = TAG_DIV)).equals(string3 = this.tag)) && (string3 = this.imageId) != null) {
            String string4 = this.imageId;
            Pair pair = new Pair((Object)string2, (Object)string4);
            list.add(pair);
            return;
        }
        boolean bl4 = false;
        string3 = null;
        while (++var7_10 < (n10 = this.getChildCount())) {
            object = this.getChild((int)var7_10);
            super.traverseForImage(l10, string2, list);
        }
    }

    private void traverseForStyle(long l10, Map map, Map map2) {
        int n10;
        int n11 = this.isActive(l10);
        if (n11 == 0) {
            return;
        }
        Object object = this.nodeEndsByRegion.entrySet().iterator();
        while (true) {
            int n12 = object.hasNext();
            Integer n13 = null;
            if (n12 == 0) break;
            HashMap hashMap = this.nodeStartsByRegion;
            Map.Entry entry = object.next();
            Object object2 = (String)entry.getKey();
            boolean bl2 = hashMap.containsKey(object2);
            if (bl2) {
                n13 = (Integer)this.nodeStartsByRegion.get(object2);
                n10 = n13;
            }
            if (n10 == (n12 = ((Integer)((Object)(entry = (Integer)entry.getValue()))).intValue())) continue;
            object2 = (Cue$Builder)Assertions.checkNotNull((Cue$Builder)map2.get(object2));
            this.applyStyleToOutput(map, (Cue$Builder)object2, n10, n12);
        }
        for (n10 = 0; n10 < (n11 = this.getChildCount()); ++n10) {
            object = this.getChild(n10);
            super.traverseForStyle(l10, map, map2);
        }
    }

    private void traverseForText(long l10, boolean bl2, String string2, Map map) {
        this.nodeStartsByRegion.clear();
        this.nodeEndsByRegion.clear();
        Object object = this.tag;
        Object object2 = TAG_METADATA;
        boolean n10 = ((String)object2).equals(object);
        if (n10) {
            return;
        }
        object2 = ANONYMOUS_REGION_ID;
        object = this.regionId;
        boolean bl3 = ((String)object2).equals(object);
        if (!bl3) {
            string2 = this.regionId;
        }
        boolean bl4 = this.isTextNode;
        if (bl4 && bl2) {
            SpannableStringBuilder spannableStringBuilder = TtmlNode.getRegionOutputText(string2, map);
            CharSequence charSequence = (CharSequence)Assertions.checkNotNull(this.text);
            spannableStringBuilder.append(charSequence);
        } else {
            object2 = TAG_BR;
            object = this.tag;
            boolean bl5 = ((String)object2).equals(object);
            if (bl5 && bl2) {
                SpannableStringBuilder spannableStringBuilder = TtmlNode.getRegionOutputText(string2, map);
                char c10 = '\n';
                spannableStringBuilder.append(c10);
            } else {
                boolean bl6 = this.isActive(l10);
                if (bl6) {
                    int n11;
                    Object object3;
                    int n12;
                    String string3;
                    int n13;
                    object = map.entrySet().iterator();
                    while ((n13 = object.hasNext()) != 0) {
                        object2 = (Map.Entry)object.next();
                        HashMap hashMap = this.nodeStartsByRegion;
                        string3 = (String)object2.getKey();
                        n13 = ((CharSequence)Assertions.checkNotNull(((Cue$Builder)object2.getValue()).getText())).length();
                        object2 = n13;
                        hashMap.put(string3, object2);
                    }
                    object = this.tag;
                    object2 = TAG_P;
                    boolean bl7 = ((String)object2).equals(object);
                    for (int i10 = 0; i10 < (n12 = this.getChildCount()); ++i10) {
                        boolean bl8;
                        object = this.getChild(i10);
                        if (!bl2 && !bl7) {
                            bl8 = false;
                            string3 = null;
                        } else {
                            boolean bl9;
                            bl8 = bl9 = true;
                        }
                        super.traverseForText(l10, bl8, string2, map);
                    }
                    if (bl7) {
                        object3 = TtmlNode.getRegionOutputText(string2, map);
                        TtmlRenderUtil.endParagraph((SpannableStringBuilder)object3);
                    }
                    object3 = map.entrySet().iterator();
                    while ((n11 = object3.hasNext()) != 0) {
                        Object object4 = (Map.Entry)object3.next();
                        HashMap hashMap = this.nodeEndsByRegion;
                        string2 = (String)object4.getKey();
                        n11 = ((CharSequence)Assertions.checkNotNull(((Cue$Builder)object4.getValue()).getText())).length();
                        object4 = n11;
                        hashMap.put(string2, object4);
                    }
                }
            }
        }
    }

    public void addChild(TtmlNode ttmlNode) {
        ArrayList arrayList = this.children;
        if (arrayList == null) {
            this.children = arrayList = new ArrayList();
        }
        this.children.add(ttmlNode);
    }

    public TtmlNode getChild(int n10) {
        List list = this.children;
        if (list != null) {
            return (TtmlNode)list.get(n10);
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
        throw indexOutOfBoundsException;
    }

    public int getChildCount() {
        int n10;
        List list = this.children;
        if (list == null) {
            n10 = 0;
            list = null;
        } else {
            n10 = list.size();
        }
        return n10;
    }

    public List getCues(long l10, Map object, Map map, Map object2) {
        int n10;
        Object object3 = new ArrayList();
        TreeMap treeMap = this.regionId;
        this.traverseForImage(l10, (String)((Object)treeMap), (List)object3);
        treeMap = new TreeMap();
        String string2 = this.regionId;
        this.traverseForText(l10, false, string2, treeMap);
        this.traverseForStyle(l10, (Map)object, treeMap);
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator<Object> iterator2 = object3.iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            object = (Pair)iterator2.next();
            object3 = ((Pair)object).second;
            if ((object3 = (String)object2.get(object3)) == null) continue;
            object3 = Base64.decode((String)object3, (int)0);
            int n11 = ((Object)object3).length;
            object3 = BitmapFactory.decodeByteArray((byte[])object3, (int)0, (int)n11);
            object = ((Pair)object).first;
            object = (TtmlRegion)Assertions.checkNotNull((TtmlRegion)map.get(object));
            Cue$Builder cue$Builder = new Cue$Builder();
            object3 = cue$Builder.setBitmap((Bitmap)object3);
            float f10 = ((TtmlRegion)object).position;
            object3 = ((Cue$Builder)object3).setPosition(f10).setPositionAnchor(0);
            f10 = ((TtmlRegion)object).line;
            object3 = ((Cue$Builder)object3).setLine(f10, 0);
            int n12 = ((TtmlRegion)object).lineAnchor;
            object3 = ((Cue$Builder)object3).setLineAnchor(n12);
            float f11 = ((TtmlRegion)object).width;
            object3 = ((Cue$Builder)object3).setSize(f11);
            f11 = ((TtmlRegion)object).height;
            object3 = ((Cue$Builder)object3).setBitmapHeight(f11);
            n10 = ((TtmlRegion)object).verticalType;
            object = ((Cue$Builder)object3).setVerticalType(n10).build();
            arrayList.add(object);
        }
        iterator2 = treeMap.entrySet().iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            object = (Map.Entry)iterator2.next();
            object2 = object.getKey();
            object2 = (TtmlRegion)Assertions.checkNotNull((TtmlRegion)map.get(object2));
            object = (Cue$Builder)object.getValue();
            object3 = (SpannableStringBuilder)Assertions.checkNotNull(((Cue$Builder)object).getText());
            TtmlNode.cleanUpText((SpannableStringBuilder)object3);
            float f12 = ((TtmlRegion)object2).line;
            int n13 = ((TtmlRegion)object2).lineType;
            ((Cue$Builder)object).setLine(f12, n13);
            int n14 = ((TtmlRegion)object2).lineAnchor;
            ((Cue$Builder)object).setLineAnchor(n14);
            f12 = ((TtmlRegion)object2).position;
            ((Cue$Builder)object).setPosition(f12);
            f12 = ((TtmlRegion)object2).width;
            ((Cue$Builder)object).setSize(f12);
            f12 = ((TtmlRegion)object2).textSize;
            n13 = ((TtmlRegion)object2).textSizeType;
            ((Cue$Builder)object).setTextSize(f12, n13);
            int n15 = ((TtmlRegion)object2).verticalType;
            ((Cue$Builder)object).setVerticalType(n15);
            object = ((Cue$Builder)object).build();
            arrayList.add(object);
        }
        return arrayList;
    }

    public long[] getEventTimesUs() {
        boolean bl2;
        Object object = new TreeSet();
        int n10 = 0;
        this.getEventTimes((TreeSet)object, false);
        int n11 = ((TreeSet)object).size();
        long[] lArray = new long[n11];
        object = ((TreeSet)object).iterator();
        while (bl2 = object.hasNext()) {
            Long l10 = (Long)object.next();
            long l11 = l10;
            int n12 = n10 + 1;
            lArray[n10] = l11;
            n10 = n12;
        }
        return lArray;
    }

    public String[] getStyleIds() {
        return this.styleIds;
    }

    public boolean isActive(long l10) {
        long l11;
        int n10;
        long l12;
        long l13;
        long l14;
        long l15;
        long l16;
        long l17;
        long l18 = this.startTimeUs;
        long l19 = -9223372036854775807L;
        long l20 = l18 - l19;
        Object object = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
        n10 = object == false && (object = (l17 = (l16 = this.endTimeUs) - l19) == 0L ? 0 : (l17 < 0L ? -1 : 1)) == false || (object = l18 == l10 ? 0 : (l18 < l10 ? -1 : 1)) <= 0 && (object = (l15 = (l16 = this.endTimeUs) - l19) == 0L ? 0 : (l15 < 0L ? -1 : 1)) == false || (l14 = l18 == l19 ? 0 : (l18 < l19 ? -1 : 1)) == false && (l14 = (l13 = l10 - (l19 = this.endTimeUs)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) < 0 || (l12 = l18 == l10 ? 0 : (l18 < l10 ? -1 : 1)) <= 0 && (n10 = (l11 = l10 - (l18 = this.endTimeUs)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0 ? 1 : 0;
        return n10 != 0;
    }
}

