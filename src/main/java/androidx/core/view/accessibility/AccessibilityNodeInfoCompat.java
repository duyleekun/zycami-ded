/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.SpannableString
 *  android.text.Spanned
 *  android.text.TextUtils
 *  android.text.style.ClickableSpan
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionInfo
 *  android.view.accessibility.AccessibilityNodeInfo$CollectionItemInfo
 *  android.view.accessibility.AccessibilityNodeInfo$RangeInfo
 *  android.view.accessibility.AccessibilityNodeInfo$TouchDelegateInfo
 */
package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.R$id;
import androidx.core.os.BuildCompat;
import androidx.core.view.accessibility.AccessibilityClickableSpanCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$RangeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$TouchDelegateInfoCompat;
import androidx.core.view.accessibility.AccessibilityWindowInfoCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_X = "ACTION_ARGUMENT_MOVE_WINDOW_X";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";
    public static final String ACTION_ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT = "android.view.accessibility.action.ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT";
    public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 0x100000;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 0x200000;
    private static final int BOOLEAN_PROPERTY_IS_HEADING = 2;
    private static final int BOOLEAN_PROPERTY_IS_SHOWING_HINT = 4;
    private static final int BOOLEAN_PROPERTY_IS_TEXT_ENTRY_KEY = 8;
    private static final String BOOLEAN_PROPERTY_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
    private static final int BOOLEAN_PROPERTY_SCREEN_READER_FOCUSABLE = 1;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    private static final String HINT_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private static final String PANE_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";
    private static final String ROLE_DESCRIPTION_KEY = "AccessibilityNodeInfo.roleDescription";
    private static final String SPANS_ACTION_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";
    private static final String SPANS_END_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY";
    private static final String SPANS_FLAGS_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY";
    private static final String SPANS_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY";
    private static final String SPANS_START_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";
    private static final String STATE_DESCRIPTION_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY";
    private static final String TOOLTIP_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";
    private static int sClickableSpanId;
    private final AccessibilityNodeInfo mInfo;
    public int mParentVirtualDescendantId;
    private int mVirtualDescendantId;

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        int n10;
        this.mParentVirtualDescendantId = n10 = -1;
        this.mVirtualDescendantId = n10;
        this.mInfo = accessibilityNodeInfo;
    }

    public AccessibilityNodeInfoCompat(Object object) {
        int n10;
        this.mParentVirtualDescendantId = n10 = -1;
        this.mVirtualDescendantId = n10;
        object = (AccessibilityNodeInfo)object;
        this.mInfo = object;
    }

    private void addSpanLocationToExtras(ClickableSpan object, Spanned object2, int n10) {
        List list = this.extrasIntList(SPANS_START_KEY);
        Integer n11 = object2.getSpanStart(object);
        list.add(n11);
        list = this.extrasIntList(SPANS_END_KEY);
        n11 = object2.getSpanEnd(object);
        list.add(n11);
        list = this.extrasIntList(SPANS_FLAGS_KEY);
        object = object2.getSpanFlags(object);
        list.add(object);
        object = this.extrasIntList(SPANS_ID_KEY);
        object2 = n10;
        object.add(object2);
    }

    private void clearExtrasSpans() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            this.mInfo.getExtras().remove(SPANS_START_KEY);
            this.mInfo.getExtras().remove(SPANS_END_KEY);
            this.mInfo.getExtras().remove(SPANS_FLAGS_KEY);
            Bundle bundle = this.mInfo.getExtras();
            String string2 = SPANS_ID_KEY;
            bundle.remove(string2);
        }
    }

    private List extrasIntList(String arrayList) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 < n11) {
            arrayList = new ArrayList();
            return arrayList;
        }
        ArrayList arrayList2 = this.mInfo.getExtras().getIntegerArrayList(arrayList);
        if (arrayList2 == null) {
            arrayList2 = new ArrayList();
            Bundle bundle = this.mInfo.getExtras();
            bundle.putIntegerArrayList(arrayList, arrayList2);
        }
        return arrayList2;
    }

    private static String getActionSymbolicName(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                switch (n10) {
                    default: {
                        switch (n10) {
                            default: {
                                switch (n10) {
                                    default: {
                                        return "ACTION_UNKNOWN";
                                    }
                                    case 16908362: {
                                        return "ACTION_PRESS_AND_HOLD";
                                    }
                                    case 16908361: {
                                        return "ACTION_PAGE_RIGHT";
                                    }
                                    case 16908360: {
                                        return "ACTION_PAGE_LEFT";
                                    }
                                    case 16908359: {
                                        return "ACTION_PAGE_DOWN";
                                    }
                                    case 16908358: {
                                        return "ACTION_PAGE_UP";
                                    }
                                    case 16908357: {
                                        return "ACTION_HIDE_TOOLTIP";
                                    }
                                    case 16908356: 
                                }
                                return "ACTION_SHOW_TOOLTIP";
                            }
                            case 16908349: {
                                return "ACTION_SET_PROGRESS";
                            }
                            case 16908348: {
                                return "ACTION_CONTEXT_CLICK";
                            }
                            case 16908347: {
                                return "ACTION_SCROLL_RIGHT";
                            }
                            case 16908346: {
                                return "ACTION_SCROLL_DOWN";
                            }
                            case 16908345: {
                                return "ACTION_SCROLL_LEFT";
                            }
                            case 16908344: {
                                return "ACTION_SCROLL_UP";
                            }
                            case 16908343: {
                                return "ACTION_SCROLL_TO_POSITION";
                            }
                            case 16908342: 
                        }
                        return "ACTION_SHOW_ON_SCREEN";
                    }
                    case 16908372: {
                        return "ACTION_IME_ENTER";
                    }
                    case 16908354: {
                        return "ACTION_MOVE_WINDOW";
                    }
                    case 0x200000: {
                        return "ACTION_SET_TEXT";
                    }
                    case 524288: {
                        return "ACTION_COLLAPSE";
                    }
                    case 262144: {
                        return "ACTION_EXPAND";
                    }
                    case 131072: {
                        return "ACTION_SET_SELECTION";
                    }
                    case 65536: {
                        return "ACTION_CUT";
                    }
                    case 32768: {
                        return "ACTION_PASTE";
                    }
                    case 16384: {
                        return "ACTION_COPY";
                    }
                    case 8192: {
                        return "ACTION_SCROLL_BACKWARD";
                    }
                    case 4096: {
                        return "ACTION_SCROLL_FORWARD";
                    }
                    case 2048: {
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    }
                    case 1024: {
                        return "ACTION_NEXT_HTML_ELEMENT";
                    }
                    case 512: {
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    }
                    case 256: {
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    }
                    case 128: {
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    }
                    case 64: {
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    }
                    case 32: {
                        return "ACTION_LONG_CLICK";
                    }
                    case 16: {
                        return "ACTION_CLICK";
                    }
                    case 8: {
                        return "ACTION_CLEAR_SELECTION";
                    }
                    case 4: 
                }
                return "ACTION_SELECT";
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    private boolean getBooleanProperty(int n10) {
        Bundle bundle = this.getExtras();
        boolean bl2 = false;
        if (bundle == null) {
            return false;
        }
        String string2 = BOOLEAN_PROPERTY_KEY;
        int n11 = bundle.getInt(string2, 0) & n10;
        if (n11 == n10) {
            bl2 = true;
        }
        return bl2;
    }

    public static ClickableSpan[] getClickableSpans(CharSequence charSequence) {
        boolean bl2 = charSequence instanceof Spanned;
        if (bl2) {
            CharSequence charSequence2 = charSequence;
            charSequence2 = (Spanned)charSequence;
            int n10 = charSequence.length();
            return (ClickableSpan[])charSequence2.getSpans(0, n10, ClickableSpan.class);
        }
        return null;
    }

    private SparseArray getOrCreateSpansFromViewTags(View view) {
        SparseArray sparseArray = this.getSpansFromViewTags(view);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            int n10 = R$id.tag_accessibility_clickable_spans;
            view.setTag(n10, (Object)sparseArray);
        }
        return sparseArray;
    }

    private SparseArray getSpansFromViewTags(View view) {
        int n10 = R$id.tag_accessibility_clickable_spans;
        return (SparseArray)view.getTag(n10);
    }

    private boolean hasSpans() {
        return this.extrasIntList(SPANS_START_KEY).isEmpty() ^ true;
    }

    private int idForClickableSpan(ClickableSpan clickableSpan, SparseArray sparseArray) {
        if (sparseArray != null) {
            int n10;
            for (int i10 = 0; i10 < (n10 = sparseArray.size()); ++i10) {
                ClickableSpan clickableSpan2 = (ClickableSpan)((WeakReference)sparseArray.valueAt(i10)).get();
                n10 = (int)(clickableSpan.equals(clickableSpan2) ? 1 : 0);
                if (n10 == 0) continue;
                return sparseArray.keyAt(i10);
            }
        }
        int n11 = sClickableSpanId;
        sClickableSpanId = n11 + 1;
        return n11;
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return AccessibilityNodeInfoCompat.wrap(AccessibilityNodeInfo.obtain());
    }

    public static AccessibilityNodeInfoCompat obtain(View view) {
        return AccessibilityNodeInfoCompat.wrap(AccessibilityNodeInfo.obtain((View)view));
    }

    public static AccessibilityNodeInfoCompat obtain(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        if (n11 >= n12) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(AccessibilityNodeInfo.obtain((View)view, (int)n10));
        }
        return null;
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return AccessibilityNodeInfoCompat.wrap(AccessibilityNodeInfo.obtain((AccessibilityNodeInfo)accessibilityNodeInfoCompat.mInfo));
    }

    private void removeCollectedSpans(View view) {
        if ((view = this.getSpansFromViewTags(view)) != null) {
            int n10;
            int n11;
            ArrayList arrayList = new ArrayList();
            int n12 = 0;
            Integer n13 = null;
            for (n11 = 0; n11 < (n10 = view.size()); ++n11) {
                Object object = ((WeakReference)view.valueAt(n11)).get();
                if (object != null) continue;
                object = n11;
                arrayList.add(object);
            }
            while (n12 < (n11 = arrayList.size())) {
                n13 = (Integer)arrayList.get(n12);
                n11 = n13;
                view.remove(n11);
                ++n12;
            }
        }
    }

    private void setBooleanProperty(int n10, boolean bl2) {
        Bundle bundle = this.getExtras();
        if (bundle != null) {
            String string2 = BOOLEAN_PROPERTY_KEY;
            int n11 = bundle.getInt(string2, 0);
            int n12 = ~n10;
            n11 &= n12;
            if (!bl2) {
                n10 = 0;
            }
            bundle.putInt(string2, n10 |= n11);
        }
    }

    public static AccessibilityNodeInfoCompat wrap(AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
        return accessibilityNodeInfoCompat;
    }

    public static AccessibilityNodeInfoCompat wrapNonNullInstance(Object object) {
        if (object != null) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(object);
            return accessibilityNodeInfoCompat;
        }
        return null;
    }

    public void addAction(int n10) {
        this.mInfo.addAction(n10);
    }

    public void addAction(AccessibilityNodeInfoCompat$AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfoCompat$AccessibilityActionCompat = (AccessibilityNodeInfo.AccessibilityAction)accessibilityNodeInfoCompat$AccessibilityActionCompat.mAction;
            accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction)accessibilityNodeInfoCompat$AccessibilityActionCompat);
        }
    }

    public void addChild(View view) {
        this.mInfo.addChild(view);
    }

    public void addChild(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        if (n11 >= n12) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.addChild(view, n10);
        }
    }

    public void addSpansToExtras(CharSequence charSequence, View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11 && n10 < (n11 = 26)) {
            this.clearExtrasSpans();
            this.removeCollectedSpans(view);
            ClickableSpan[] clickableSpanArray = AccessibilityNodeInfoCompat.getClickableSpans(charSequence);
            if (clickableSpanArray != null && (n11 = clickableSpanArray.length) > 0) {
                Bundle bundle = this.getExtras();
                int n12 = R$id.accessibility_action_clickable_span;
                ClickableSpan clickableSpan = SPANS_ACTION_ID_KEY;
                bundle.putInt((String)clickableSpan, n12);
                view = this.getOrCreateSpansFromViewTags(view);
                bundle = null;
                for (n11 = 0; clickableSpanArray != null && n11 < (n12 = clickableSpanArray.length); ++n11) {
                    ClickableSpan clickableSpan2 = clickableSpanArray[n11];
                    n12 = this.idForClickableSpan(clickableSpan2, (SparseArray)view);
                    Object object = clickableSpanArray[n11];
                    clickableSpan = new WeakReference(object);
                    view.put(n12, clickableSpan);
                    clickableSpan = clickableSpanArray[n11];
                    object = charSequence;
                    object = (Spanned)charSequence;
                    this.addSpanLocationToExtras(clickableSpan, (Spanned)object, n12);
                }
            }
        }
    }

    public boolean canOpenPopup() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return this.mInfo.canOpenPopup();
        }
        return false;
    }

    public boolean equals(Object object) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object == null) {
            return false;
        }
        int n10 = object instanceof AccessibilityNodeInfoCompat;
        if (n10 == 0) {
            return false;
        }
        object = (AccessibilityNodeInfoCompat)object;
        AccessibilityNodeInfo accessibilityNodeInfo2 = this.mInfo;
        if (accessibilityNodeInfo2 == null ? (accessibilityNodeInfo2 = ((AccessibilityNodeInfoCompat)object).mInfo) != null : (n10 = accessibilityNodeInfo2.equals((Object)(accessibilityNodeInfo = ((AccessibilityNodeInfoCompat)object).mInfo))) == 0) {
            return false;
        }
        n10 = this.mVirtualDescendantId;
        int n11 = ((AccessibilityNodeInfoCompat)object).mVirtualDescendantId;
        if (n10 != n11) {
            return false;
        }
        n10 = this.mParentVirtualDescendantId;
        int n12 = ((AccessibilityNodeInfoCompat)object).mParentVirtualDescendantId;
        if (n10 != n12) {
            return false;
        }
        return bl2;
    }

    public List findAccessibilityNodeInfosByText(String object) {
        ArrayList<AccessibilityNodeInfoCompat> arrayList = new ArrayList<AccessibilityNodeInfoCompat>();
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        object = accessibilityNodeInfo.findAccessibilityNodeInfosByText((String)object);
        int n10 = object.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.wrap((AccessibilityNodeInfo)object.get(i10));
            arrayList.add(accessibilityNodeInfoCompat);
        }
        return arrayList;
    }

    public List findAccessibilityNodeInfosByViewId(String iterator2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            iterator2 = this.mInfo.findAccessibilityNodeInfosByViewId((String)((Object)iterator2));
            ArrayList<AccessibilityNodeInfoCompat> arrayList = new ArrayList<AccessibilityNodeInfoCompat>();
            iterator2 = iterator2.iterator();
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.wrap((AccessibilityNodeInfo)iterator2.next());
                arrayList.add(accessibilityNodeInfoCompat);
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public AccessibilityNodeInfoCompat findFocus(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        if (n11 >= n12) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.findFocus(n10));
        }
        return null;
    }

    public AccessibilityNodeInfoCompat focusSearch(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        if (n11 >= n12) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.focusSearch(n10));
        }
        return null;
    }

    public List getActionList() {
        List list;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            list = this.mInfo.getActionList();
        } else {
            n10 = 0;
            list = null;
        }
        if (list != null) {
            ArrayList<AccessibilityNodeInfoCompat$AccessibilityActionCompat> arrayList = new ArrayList<AccessibilityNodeInfoCompat$AccessibilityActionCompat>();
            int n12 = list.size();
            for (int i10 = 0; i10 < n12; ++i10) {
                Object e10 = list.get(i10);
                AccessibilityNodeInfoCompat$AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat = new AccessibilityNodeInfoCompat$AccessibilityActionCompat(e10);
                arrayList.add(accessibilityNodeInfoCompat$AccessibilityActionCompat);
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public int getActions() {
        return this.mInfo.getActions();
    }

    public void getBoundsInParent(Rect rect) {
        this.mInfo.getBoundsInParent(rect);
    }

    public void getBoundsInScreen(Rect rect) {
        this.mInfo.getBoundsInScreen(rect);
    }

    public AccessibilityNodeInfoCompat getChild(int n10) {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getChild(n10));
    }

    public int getChildCount() {
        return this.mInfo.getChildCount();
    }

    public CharSequence getClassName() {
        return this.mInfo.getClassName();
    }

    public AccessibilityNodeInfoCompat$CollectionInfoCompat getCollectionInfo() {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11 && (collectionInfo = this.mInfo.getCollectionInfo()) != null) {
            AccessibilityNodeInfoCompat$CollectionInfoCompat accessibilityNodeInfoCompat$CollectionInfoCompat = new AccessibilityNodeInfoCompat$CollectionInfoCompat(collectionInfo);
            return accessibilityNodeInfoCompat$CollectionInfoCompat;
        }
        return null;
    }

    public AccessibilityNodeInfoCompat$CollectionItemInfoCompat getCollectionItemInfo() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11 && (collectionItemInfo = this.mInfo.getCollectionItemInfo()) != null) {
            AccessibilityNodeInfoCompat$CollectionItemInfoCompat accessibilityNodeInfoCompat$CollectionItemInfoCompat = new AccessibilityNodeInfoCompat$CollectionItemInfoCompat(collectionItemInfo);
            return accessibilityNodeInfoCompat$CollectionItemInfoCompat;
        }
        return null;
    }

    public CharSequence getContentDescription() {
        return this.mInfo.getContentDescription();
    }

    public int getDrawingOrder() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return this.mInfo.getDrawingOrder();
        }
        return 0;
    }

    public CharSequence getError() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return this.mInfo.getError();
        }
        return null;
    }

    public Bundle getExtras() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return this.mInfo.getExtras();
        }
        Bundle bundle = new Bundle();
        return bundle;
    }

    public CharSequence getHintText() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return this.mInfo.getHintText();
        }
        n11 = 19;
        if (n10 >= n11) {
            return this.mInfo.getExtras().getCharSequence(HINT_TEXT_KEY);
        }
        return null;
    }

    public Object getInfo() {
        return this.mInfo;
    }

    public int getInputType() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return this.mInfo.getInputType();
        }
        return 0;
    }

    public AccessibilityNodeInfoCompat getLabelFor() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getLabelFor());
        }
        return null;
    }

    public AccessibilityNodeInfoCompat getLabeledBy() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getLabeledBy());
        }
        return null;
    }

    public int getLiveRegion() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return this.mInfo.getLiveRegion();
        }
        return 0;
    }

    public int getMaxTextLength() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return this.mInfo.getMaxTextLength();
        }
        return -1;
    }

    public int getMovementGranularities() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return this.mInfo.getMovementGranularities();
        }
        return 0;
    }

    public CharSequence getPackageName() {
        return this.mInfo.getPackageName();
    }

    public CharSequence getPaneTitle() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return this.mInfo.getPaneTitle();
        }
        n11 = 19;
        if (n10 >= n11) {
            return this.mInfo.getExtras().getCharSequence(PANE_TITLE_KEY);
        }
        return null;
    }

    public AccessibilityNodeInfoCompat getParent() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getParent());
    }

    public AccessibilityNodeInfoCompat$RangeInfoCompat getRangeInfo() {
        AccessibilityNodeInfo.RangeInfo rangeInfo;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11 && (rangeInfo = this.mInfo.getRangeInfo()) != null) {
            AccessibilityNodeInfoCompat$RangeInfoCompat accessibilityNodeInfoCompat$RangeInfoCompat = new AccessibilityNodeInfoCompat$RangeInfoCompat(rangeInfo);
            return accessibilityNodeInfoCompat$RangeInfoCompat;
        }
        return null;
    }

    public CharSequence getRoleDescription() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return this.mInfo.getExtras().getCharSequence(ROLE_DESCRIPTION_KEY);
        }
        return null;
    }

    public CharSequence getStateDescription() {
        int n10 = BuildCompat.isAtLeastR();
        if (n10 != 0) {
            return this.mInfo.getStateDescription();
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return this.mInfo.getExtras().getCharSequence(STATE_DESCRIPTION_KEY);
        }
        return null;
    }

    public CharSequence getText() {
        boolean bl2 = this.hasSpans();
        if (bl2) {
            int n10;
            List list = this.extrasIntList(SPANS_START_KEY);
            List list2 = this.extrasIntList(SPANS_END_KEY);
            List list3 = this.extrasIntList(SPANS_FLAGS_KEY);
            List list4 = this.extrasIntList(SPANS_ID_KEY);
            Object object = this.mInfo.getText();
            Object object2 = this.mInfo.getText();
            int n11 = object2.length();
            object = TextUtils.substring((CharSequence)object, (int)0, (int)n11);
            SpannableString spannableString = new SpannableString(object);
            for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
                n11 = (Integer)list4.get(i10);
                int n12 = this.getExtras().getInt(SPANS_ACTION_ID_KEY);
                object = new AccessibilityClickableSpanCompat(n11, this, n12);
                object2 = (Integer)list.get(i10);
                n11 = (Integer)object2;
                Integer n13 = (Integer)list2.get(i10);
                n12 = n13;
                Integer n14 = (Integer)list3.get(i10);
                int n15 = n14;
                spannableString.setSpan(object, n11, n12, n15);
            }
            return spannableString;
        }
        return this.mInfo.getText();
    }

    public int getTextSelectionEnd() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            return this.mInfo.getTextSelectionEnd();
        }
        return -1;
    }

    public int getTextSelectionStart() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            return this.mInfo.getTextSelectionStart();
        }
        return -1;
    }

    public CharSequence getTooltipText() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return this.mInfo.getTooltipText();
        }
        n11 = 19;
        if (n10 >= n11) {
            return this.mInfo.getExtras().getCharSequence(TOOLTIP_TEXT_KEY);
        }
        return null;
    }

    public AccessibilityNodeInfoCompat$TouchDelegateInfoCompat getTouchDelegateInfo() {
        AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11 && (touchDelegateInfo = this.mInfo.getTouchDelegateInfo()) != null) {
            AccessibilityNodeInfoCompat$TouchDelegateInfoCompat accessibilityNodeInfoCompat$TouchDelegateInfoCompat = new AccessibilityNodeInfoCompat$TouchDelegateInfoCompat(touchDelegateInfo);
            return accessibilityNodeInfoCompat$TouchDelegateInfoCompat;
        }
        return null;
    }

    public AccessibilityNodeInfoCompat getTraversalAfter() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 22;
        if (n10 >= n11) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getTraversalAfter());
        }
        return null;
    }

    public AccessibilityNodeInfoCompat getTraversalBefore() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 22;
        if (n10 >= n11) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(this.mInfo.getTraversalBefore());
        }
        return null;
    }

    public String getViewIdResourceName() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            return this.mInfo.getViewIdResourceName();
        }
        return null;
    }

    public AccessibilityWindowInfoCompat getWindow() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return AccessibilityWindowInfoCompat.wrapNonNullInstance(this.mInfo.getWindow());
        }
        return null;
    }

    public int getWindowId() {
        return this.mInfo.getWindowId();
    }

    public int hashCode() {
        int n10;
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (accessibilityNodeInfo == null) {
            n10 = 0;
            accessibilityNodeInfo = null;
        } else {
            n10 = accessibilityNodeInfo.hashCode();
        }
        return n10;
    }

    public boolean isAccessibilityFocused() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return this.mInfo.isAccessibilityFocused();
        }
        return false;
    }

    public boolean isCheckable() {
        return this.mInfo.isCheckable();
    }

    public boolean isChecked() {
        return this.mInfo.isChecked();
    }

    public boolean isClickable() {
        return this.mInfo.isClickable();
    }

    public boolean isContentInvalid() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return this.mInfo.isContentInvalid();
        }
        return false;
    }

    public boolean isContextClickable() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return this.mInfo.isContextClickable();
        }
        return false;
    }

    public boolean isDismissable() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return this.mInfo.isDismissable();
        }
        return false;
    }

    public boolean isEditable() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            return this.mInfo.isEditable();
        }
        return false;
    }

    public boolean isEnabled() {
        return this.mInfo.isEnabled();
    }

    public boolean isFocusable() {
        return this.mInfo.isFocusable();
    }

    public boolean isFocused() {
        return this.mInfo.isFocused();
    }

    public boolean isHeading() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return this.mInfo.isHeading();
        }
        n10 = (int)(this.getBooleanProperty(2) ? 1 : 0);
        n11 = 1;
        if (n10) {
            return n11 != 0;
        }
        AccessibilityNodeInfoCompat$CollectionItemInfoCompat accessibilityNodeInfoCompat$CollectionItemInfoCompat = this.getCollectionItemInfo();
        if (accessibilityNodeInfoCompat$CollectionItemInfoCompat == null || !(n10 = accessibilityNodeInfoCompat$CollectionItemInfoCompat.isHeading())) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean isImportantForAccessibility() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return this.mInfo.isImportantForAccessibility();
        }
        return true;
    }

    public boolean isLongClickable() {
        return this.mInfo.isLongClickable();
    }

    public boolean isMultiLine() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return this.mInfo.isMultiLine();
        }
        return false;
    }

    public boolean isPassword() {
        return this.mInfo.isPassword();
    }

    public boolean isScreenReaderFocusable() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return this.mInfo.isScreenReaderFocusable();
        }
        return this.getBooleanProperty(1);
    }

    public boolean isScrollable() {
        return this.mInfo.isScrollable();
    }

    public boolean isSelected() {
        return this.mInfo.isSelected();
    }

    public boolean isShowingHintText() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return this.mInfo.isShowingHintText();
        }
        return this.getBooleanProperty(4);
    }

    public boolean isTextEntryKey() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            return this.mInfo.isTextEntryKey();
        }
        return this.getBooleanProperty(8);
    }

    public boolean isVisibleToUser() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return this.mInfo.isVisibleToUser();
        }
        return false;
    }

    public boolean performAction(int n10) {
        return this.mInfo.performAction(n10);
    }

    public boolean performAction(int n10, Bundle bundle) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        if (n11 >= n12) {
            return this.mInfo.performAction(n10, bundle);
        }
        return false;
    }

    public void recycle() {
        this.mInfo.recycle();
    }

    public boolean refresh() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            return this.mInfo.refresh();
        }
        return false;
    }

    public boolean removeAction(AccessibilityNodeInfoCompat$AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfoCompat$AccessibilityActionCompat = (AccessibilityNodeInfo.AccessibilityAction)accessibilityNodeInfoCompat$AccessibilityActionCompat.mAction;
            return accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction)accessibilityNodeInfoCompat$AccessibilityActionCompat);
        }
        return false;
    }

    public boolean removeChild(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return this.mInfo.removeChild(view);
        }
        return false;
    }

    public boolean removeChild(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            return this.mInfo.removeChild(view, n10);
        }
        return false;
    }

    public void setAccessibilityFocused(boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setAccessibilityFocused(bl2);
        }
    }

    public void setBoundsInParent(Rect rect) {
        this.mInfo.setBoundsInParent(rect);
    }

    public void setBoundsInScreen(Rect rect) {
        this.mInfo.setBoundsInScreen(rect);
    }

    public void setCanOpenPopup(boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setCanOpenPopup(bl2);
        }
    }

    public void setCheckable(boolean bl2) {
        this.mInfo.setCheckable(bl2);
    }

    public void setChecked(boolean bl2) {
        this.mInfo.setChecked(bl2);
    }

    public void setClassName(CharSequence charSequence) {
        this.mInfo.setClassName(charSequence);
    }

    public void setClickable(boolean bl2) {
        this.mInfo.setClickable(bl2);
    }

    public void setCollectionInfo(Object object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            object = object == null ? null : (AccessibilityNodeInfo.CollectionInfo)((AccessibilityNodeInfoCompat$CollectionInfoCompat)object).mInfo;
            accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo)object);
        }
    }

    public void setCollectionItemInfo(Object object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            object = object == null ? null : (AccessibilityNodeInfo.CollectionItemInfo)((AccessibilityNodeInfoCompat$CollectionItemInfoCompat)object).mInfo;
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo)object);
        }
    }

    public void setContentDescription(CharSequence charSequence) {
        this.mInfo.setContentDescription(charSequence);
    }

    public void setContentInvalid(boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setContentInvalid(bl2);
        }
    }

    public void setContextClickable(boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setContextClickable(bl2);
        }
    }

    public void setDismissable(boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setDismissable(bl2);
        }
    }

    public void setDrawingOrder(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 24;
        if (n11 >= n12) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setDrawingOrder(n10);
        }
    }

    public void setEditable(boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setEditable(bl2);
        }
    }

    public void setEnabled(boolean bl2) {
        this.mInfo.setEnabled(bl2);
    }

    public void setError(CharSequence charSequence) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setError(charSequence);
        }
    }

    public void setFocusable(boolean bl2) {
        this.mInfo.setFocusable(bl2);
    }

    public void setFocused(boolean bl2) {
        this.mInfo.setFocused(bl2);
    }

    public void setHeading(boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setHeading(bl2);
        } else {
            n10 = 2;
            this.setBooleanProperty(n10, bl2);
        }
    }

    public void setHintText(CharSequence charSequence) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setHintText(charSequence);
        } else {
            n11 = 19;
            if (n10 >= n11) {
                Bundle bundle = this.mInfo.getExtras();
                String string2 = HINT_TEXT_KEY;
                bundle.putCharSequence(string2, charSequence);
            }
        }
    }

    public void setImportantForAccessibility(boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setImportantForAccessibility(bl2);
        }
    }

    public void setInputType(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 19;
        if (n11 >= n12) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setInputType(n10);
        }
    }

    public void setLabelFor(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setLabelFor(view);
        }
    }

    public void setLabelFor(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 17;
        if (n11 >= n12) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setLabelFor(view, n10);
        }
    }

    public void setLabeledBy(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setLabeledBy(view);
        }
    }

    public void setLabeledBy(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 17;
        if (n11 >= n12) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setLabeledBy(view, n10);
        }
    }

    public void setLiveRegion(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 19;
        if (n11 >= n12) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setLiveRegion(n10);
        }
    }

    public void setLongClickable(boolean bl2) {
        this.mInfo.setLongClickable(bl2);
    }

    public void setMaxTextLength(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setMaxTextLength(n10);
        }
    }

    public void setMovementGranularities(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        if (n11 >= n12) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setMovementGranularities(n10);
        }
    }

    public void setMultiLine(boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setMultiLine(bl2);
        }
    }

    public void setPackageName(CharSequence charSequence) {
        this.mInfo.setPackageName(charSequence);
    }

    public void setPaneTitle(CharSequence charSequence) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setPaneTitle(charSequence);
        } else {
            n11 = 19;
            if (n10 >= n11) {
                Bundle bundle = this.mInfo.getExtras();
                String string2 = PANE_TITLE_KEY;
                bundle.putCharSequence(string2, charSequence);
            }
        }
    }

    public void setParent(View view) {
        this.mParentVirtualDescendantId = -1;
        this.mInfo.setParent(view);
    }

    public void setParent(View view, int n10) {
        this.mParentVirtualDescendantId = n10;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        if (n11 >= n12) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setParent(view, n10);
        }
    }

    public void setPassword(boolean bl2) {
        this.mInfo.setPassword(bl2);
    }

    public void setRangeInfo(AccessibilityNodeInfoCompat$RangeInfoCompat accessibilityNodeInfoCompat$RangeInfoCompat) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfoCompat$RangeInfoCompat = (AccessibilityNodeInfo.RangeInfo)accessibilityNodeInfoCompat$RangeInfoCompat.mInfo;
            accessibilityNodeInfo.setRangeInfo((AccessibilityNodeInfo.RangeInfo)accessibilityNodeInfoCompat$RangeInfoCompat);
        }
    }

    public void setRoleDescription(CharSequence charSequence) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            Bundle bundle = this.mInfo.getExtras();
            String string2 = ROLE_DESCRIPTION_KEY;
            bundle.putCharSequence(string2, charSequence);
        }
    }

    public void setScreenReaderFocusable(boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setScreenReaderFocusable(bl2);
        } else {
            n10 = 1;
            this.setBooleanProperty(n10, bl2);
        }
    }

    public void setScrollable(boolean bl2) {
        this.mInfo.setScrollable(bl2);
    }

    public void setSelected(boolean bl2) {
        this.mInfo.setSelected(bl2);
    }

    public void setShowingHintText(boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setShowingHintText(bl2);
        } else {
            n10 = 4;
            this.setBooleanProperty(n10, bl2);
        }
    }

    public void setSource(View view) {
        this.mVirtualDescendantId = -1;
        this.mInfo.setSource(view);
    }

    public void setSource(View view, int n10) {
        this.mVirtualDescendantId = n10;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        if (n11 >= n12) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setSource(view, n10);
        }
    }

    public void setStateDescription(CharSequence charSequence) {
        int n10 = BuildCompat.isAtLeastR();
        if (n10 != 0) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setStateDescription(charSequence);
        } else {
            n10 = Build.VERSION.SDK_INT;
            int n11 = 19;
            if (n10 >= n11) {
                Bundle bundle = this.mInfo.getExtras();
                String string2 = STATE_DESCRIPTION_KEY;
                bundle.putCharSequence(string2, charSequence);
            }
        }
    }

    public void setText(CharSequence charSequence) {
        this.mInfo.setText(charSequence);
    }

    public void setTextEntryKey(boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setTextEntryKey(bl2);
        } else {
            n10 = 8;
            this.setBooleanProperty(n10, bl2);
        }
    }

    public void setTextSelection(int n10, int n11) {
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 18;
        if (n12 >= n13) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setTextSelection(n10, n11);
        }
    }

    public void setTooltipText(CharSequence charSequence) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setTooltipText(charSequence);
        } else {
            n11 = 19;
            if (n10 >= n11) {
                Bundle bundle = this.mInfo.getExtras();
                String string2 = TOOLTIP_TEXT_KEY;
                bundle.putCharSequence(string2, charSequence);
            }
        }
    }

    public void setTouchDelegateInfo(AccessibilityNodeInfoCompat$TouchDelegateInfoCompat accessibilityNodeInfoCompat$TouchDelegateInfoCompat) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfoCompat$TouchDelegateInfoCompat = accessibilityNodeInfoCompat$TouchDelegateInfoCompat.mInfo;
            accessibilityNodeInfo.setTouchDelegateInfo((AccessibilityNodeInfo.TouchDelegateInfo)accessibilityNodeInfoCompat$TouchDelegateInfoCompat);
        }
    }

    public void setTraversalAfter(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 22;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setTraversalAfter(view);
        }
    }

    public void setTraversalAfter(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 22;
        if (n11 >= n12) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setTraversalAfter(view, n10);
        }
    }

    public void setTraversalBefore(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 22;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setTraversalBefore(view);
        }
    }

    public void setTraversalBefore(View view, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 22;
        if (n11 >= n12) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setTraversalBefore(view, n10);
        }
    }

    public void setViewIdResourceName(String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setViewIdResourceName(string2);
        }
    }

    public void setVisibleToUser(boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
            accessibilityNodeInfo.setVisibleToUser(bl2);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = super.toString();
        stringBuilder.append((String)object);
        object = new Rect();
        this.getBoundsInParent((Rect)object);
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("; boundsInParent: ");
        ((StringBuilder)charSequence).append(object);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        this.getBoundsInScreen((Rect)object);
        charSequence = new StringBuilder();
        String string2 = "; boundsInScreen: ";
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(object);
        object = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)object);
        stringBuilder.append("; packageName: ");
        object = this.getPackageName();
        stringBuilder.append((CharSequence)object);
        stringBuilder.append("; className: ");
        object = this.getClassName();
        stringBuilder.append((CharSequence)object);
        stringBuilder.append("; text: ");
        object = this.getText();
        stringBuilder.append((CharSequence)object);
        stringBuilder.append("; contentDescription: ");
        object = this.getContentDescription();
        stringBuilder.append((CharSequence)object);
        stringBuilder.append("; viewId: ");
        object = this.getViewIdResourceName();
        stringBuilder.append((String)object);
        stringBuilder.append("; checkable: ");
        int n10 = this.isCheckable();
        stringBuilder.append(n10 != 0);
        stringBuilder.append("; checked: ");
        n10 = this.isChecked();
        stringBuilder.append(n10 != 0);
        stringBuilder.append("; focusable: ");
        n10 = this.isFocusable();
        stringBuilder.append(n10 != 0);
        stringBuilder.append("; focused: ");
        n10 = this.isFocused();
        stringBuilder.append(n10 != 0);
        stringBuilder.append("; selected: ");
        n10 = this.isSelected();
        stringBuilder.append(n10 != 0);
        stringBuilder.append("; clickable: ");
        n10 = this.isClickable();
        stringBuilder.append(n10 != 0);
        stringBuilder.append("; longClickable: ");
        n10 = this.isLongClickable();
        stringBuilder.append(n10 != 0);
        stringBuilder.append("; enabled: ");
        n10 = this.isEnabled();
        stringBuilder.append(n10 != 0);
        stringBuilder.append("; password: ");
        n10 = this.isPassword();
        stringBuilder.append(n10 != 0);
        object = new StringBuilder();
        ((StringBuilder)object).append("; scrollable: ");
        boolean bl2 = this.isScrollable();
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        stringBuilder.append((String)object);
        object = "; [";
        stringBuilder.append((String)object);
        n10 = Build.VERSION.SDK_INT;
        charSequence = ", ";
        int n11 = 1;
        int n12 = 21;
        if (n10 >= n12) {
            int n13;
            object = this.getActionList();
            Object var9_9 = null;
            for (n12 = 0; n12 < (n13 = object.size()); ++n12) {
                CharSequence charSequence2;
                Object object2 = (AccessibilityNodeInfoCompat$AccessibilityActionCompat)object.get(n12);
                int n14 = ((AccessibilityNodeInfoCompat$AccessibilityActionCompat)object2).getId();
                String string3 = AccessibilityNodeInfoCompat.getActionSymbolicName(n14);
                boolean bl3 = string3.equals(charSequence2 = "ACTION_UNKNOWN");
                if (bl3 && (charSequence2 = ((AccessibilityNodeInfoCompat$AccessibilityActionCompat)object2).getLabel()) != null) {
                    object2 = ((AccessibilityNodeInfoCompat$AccessibilityActionCompat)object2).getLabel();
                    string3 = object2.toString();
                }
                stringBuilder.append(string3);
                n13 = object.size() - n11;
                if (n12 == n13) continue;
                stringBuilder.append((String)charSequence);
            }
        } else {
            n10 = this.getActions();
            while (n10 != 0) {
                n12 = Integer.numberOfTrailingZeros(n10);
                n12 = n11 << n12;
                int n15 = ~n12;
                String string4 = AccessibilityNodeInfoCompat.getActionSymbolicName(n12);
                stringBuilder.append(string4);
                if ((n10 &= n15) == 0) continue;
                stringBuilder.append((String)charSequence);
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public AccessibilityNodeInfo unwrap() {
        return this.mInfo;
    }
}

