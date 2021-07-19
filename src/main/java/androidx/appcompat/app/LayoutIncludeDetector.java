/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.AttributeSet
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.appcompat.app;

import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class LayoutIncludeDetector {
    private final Deque mXmlParserStack;

    public LayoutIncludeDetector() {
        ArrayDeque arrayDeque;
        this.mXmlParserStack = arrayDeque = new ArrayDeque();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean isParserOutdated(XmlPullParser xmlPullParser) {
        int n10 = 1;
        if (xmlPullParser == null) return n10 != 0;
        try {
            int n11 = xmlPullParser.getEventType();
            int n12 = 3;
            if (n11 == n12) return n10 != 0;
        }
        catch (XmlPullParserException xmlPullParserException) {
            return n10 != 0;
        }
        int n13 = xmlPullParser.getEventType();
        if (n13 != n10) return 0 != 0;
        return n10 != 0;
    }

    private static XmlPullParser popOutdatedAttrHolders(Deque deque) {
        boolean bl2;
        while (!(bl2 = deque.isEmpty())) {
            XmlPullParser xmlPullParser = (XmlPullParser)((WeakReference)deque.peek()).get();
            boolean bl3 = LayoutIncludeDetector.isParserOutdated(xmlPullParser);
            if (bl3) {
                deque.pop();
                continue;
            }
            return xmlPullParser;
        }
        return null;
    }

    private static boolean shouldInheritContext(XmlPullParser object, XmlPullParser object2) {
        block5: {
            if (object2 != null && object != object2) {
                try {
                    int n10 = object2.getEventType();
                    int n11 = 2;
                    if (n10 != n11) break block5;
                    object = "include";
                }
                catch (XmlPullParserException xmlPullParserException) {}
                object2 = object2.getName();
                return ((String)object).equals(object2);
            }
        }
        return false;
    }

    public boolean detect(AttributeSet attributeSet) {
        boolean bl2;
        boolean bl3 = attributeSet instanceof XmlPullParser;
        if (bl3 && (bl3 = (attributeSet = (XmlPullParser)attributeSet).getDepth()) == (bl2 = true)) {
            XmlPullParser xmlPullParser = LayoutIncludeDetector.popOutdatedAttrHolders(this.mXmlParserStack);
            Deque deque = this.mXmlParserStack;
            WeakReference<AttributeSet> weakReference = new WeakReference<AttributeSet>(attributeSet);
            deque.push(weakReference);
            boolean bl4 = LayoutIncludeDetector.shouldInheritContext((XmlPullParser)attributeSet, xmlPullParser);
            if (bl4) {
                return bl2;
            }
        }
        return false;
    }
}

