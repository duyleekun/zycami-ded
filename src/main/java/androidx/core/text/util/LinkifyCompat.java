/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.text.Spannable
 *  android.text.SpannableString
 *  android.text.method.LinkMovementMethod
 *  android.text.method.MovementMethod
 *  android.text.style.URLSpan
 *  android.text.util.Linkify
 *  android.text.util.Linkify$MatchFilter
 *  android.text.util.Linkify$TransformFilter
 *  android.webkit.WebView
 *  android.widget.TextView
 */
package androidx.core.text.util;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.core.text.util.FindAddress;
import androidx.core.text.util.LinkifyCompat$1;
import androidx.core.text.util.LinkifyCompat$LinkSpec;
import androidx.core.util.PatternsCompat;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LinkifyCompat {
    private static final Comparator COMPARATOR;
    private static final String[] EMPTY_STRING;

    static {
        EMPTY_STRING = new String[0];
        LinkifyCompat$1 linkifyCompat$1 = new LinkifyCompat$1();
        COMPARATOR = linkifyCompat$1;
    }

    private LinkifyCompat() {
    }

    private static void addLinkMovementMethod(TextView textView) {
        MovementMethod movementMethod = textView.getMovementMethod();
        boolean bl2 = movementMethod instanceof LinkMovementMethod;
        if (!bl2 && (bl2 = textView.getLinksClickable())) {
            movementMethod = LinkMovementMethod.getInstance();
            textView.setMovementMethod(movementMethod);
        }
    }

    public static void addLinks(TextView textView, Pattern pattern, String string2) {
        boolean bl2 = LinkifyCompat.shouldAddLinksFallbackToFramework();
        if (bl2) {
            Linkify.addLinks((TextView)textView, (Pattern)pattern, (String)string2);
            return;
        }
        LinkifyCompat.addLinks(textView, pattern, string2, null, null, null);
    }

    public static void addLinks(TextView textView, Pattern pattern, String string2, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        boolean bl2 = LinkifyCompat.shouldAddLinksFallbackToFramework();
        if (bl2) {
            Linkify.addLinks((TextView)textView, (Pattern)pattern, (String)string2, (Linkify.MatchFilter)matchFilter, (Linkify.TransformFilter)transformFilter);
            return;
        }
        LinkifyCompat.addLinks(textView, pattern, string2, null, matchFilter, transformFilter);
    }

    public static void addLinks(TextView textView, Pattern pattern, String string2, String[] stringArray, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        boolean bl2 = LinkifyCompat.shouldAddLinksFallbackToFramework();
        if (bl2) {
            Linkify.addLinks((TextView)textView, (Pattern)pattern, (String)string2, (String[])stringArray, (Linkify.MatchFilter)matchFilter, (Linkify.TransformFilter)transformFilter);
            return;
        }
        SpannableString spannableString = SpannableString.valueOf((CharSequence)textView.getText());
        boolean bl3 = LinkifyCompat.addLinks((Spannable)spannableString, pattern, string2, stringArray, matchFilter, transformFilter);
        if (bl3) {
            textView.setText((CharSequence)spannableString);
            LinkifyCompat.addLinkMovementMethod(textView);
        }
    }

    public static boolean addLinks(Spannable spannable, int n10) {
        Linkify.MatchFilter matchFilter;
        String[] stringArray;
        Pattern pattern;
        Object object;
        int n11 = LinkifyCompat.shouldAddLinksFallbackToFramework();
        if (n11 != 0) {
            return Linkify.addLinks((Spannable)spannable, (int)n10);
        }
        n11 = 0;
        LinkifyCompat$LinkSpec linkifyCompat$LinkSpec = null;
        if (n10 == 0) {
            return false;
        }
        int n12 = spannable.length();
        Object object2 = URLSpan.class;
        Object object3 = (URLSpan[])spannable.getSpans(0, n12, object2);
        int n13 = ((URLSpan[])object3).length;
        int n14 = 1;
        n13 -= n14;
        while (n13 >= 0) {
            object = object3[n13];
            spannable.removeSpan(object);
            n13 += -1;
        }
        n12 = n10 & 4;
        if (n12 != 0) {
            n12 = 4;
            Linkify.addLinks((Spannable)spannable, (int)n12);
        }
        object3 = new ArrayList();
        n13 = n10 & 1;
        if (n13 != 0) {
            pattern = PatternsCompat.AUTOLINK_WEB_URL;
            object2 = "http://";
            stringArray = new String[]{object2, "https://", "rtsp://"};
            matchFilter = Linkify.sUrlMatchFilter;
            object = object3;
            LinkifyCompat.gatherLinks((ArrayList)object3, spannable, pattern, stringArray, matchFilter, null);
        }
        if ((n13 = n10 & 2) != 0) {
            pattern = PatternsCompat.AUTOLINK_EMAIL_ADDRESS;
            object2 = "mailto:";
            stringArray = new String[]{object2};
            matchFilter = null;
            object = object3;
            LinkifyCompat.gatherLinks((ArrayList)object3, spannable, pattern, stringArray, null, null);
        }
        if ((n10 &= 8) != 0) {
            LinkifyCompat.gatherMapLinks((ArrayList)object3, spannable);
        }
        LinkifyCompat.pruneOverlaps((ArrayList)object3, spannable);
        n10 = ((ArrayList)object3).size();
        if (n10 == 0) {
            return false;
        }
        Iterator iterator2 = ((ArrayList)object3).iterator();
        while ((n11 = iterator2.hasNext()) != 0) {
            linkifyCompat$LinkSpec = (LinkifyCompat$LinkSpec)iterator2.next();
            object3 = linkifyCompat$LinkSpec.frameworkAddedSpan;
            if (object3 != null) continue;
            object3 = linkifyCompat$LinkSpec.url;
            n13 = linkifyCompat$LinkSpec.start;
            n11 = linkifyCompat$LinkSpec.end;
            LinkifyCompat.applyLink((String)object3, n13, n11, spannable);
        }
        return n14 != 0;
    }

    public static boolean addLinks(Spannable spannable, Pattern pattern, String string2) {
        boolean bl2 = LinkifyCompat.shouldAddLinksFallbackToFramework();
        if (bl2) {
            return Linkify.addLinks((Spannable)spannable, (Pattern)pattern, (String)string2);
        }
        return LinkifyCompat.addLinks(spannable, pattern, string2, null, null, null);
    }

    public static boolean addLinks(Spannable spannable, Pattern pattern, String string2, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        boolean bl2 = LinkifyCompat.shouldAddLinksFallbackToFramework();
        if (bl2) {
            return Linkify.addLinks((Spannable)spannable, (Pattern)pattern, (String)string2, (Linkify.MatchFilter)matchFilter, (Linkify.TransformFilter)transformFilter);
        }
        return LinkifyCompat.addLinks(spannable, pattern, string2, null, matchFilter, transformFilter);
    }

    public static boolean addLinks(Spannable spannable, Pattern object, String string2, String[] stringArray, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        int n10;
        int n11;
        int n12;
        int n13 = LinkifyCompat.shouldAddLinksFallbackToFramework();
        if (n13 != 0) {
            return Linkify.addLinks((Spannable)spannable, (Pattern)object, (String)string2, (String[])stringArray, (Linkify.MatchFilter)matchFilter, (Linkify.TransformFilter)transformFilter);
        }
        String string3 = "";
        if (string2 == null) {
            string2 = string3;
        }
        int n14 = 1;
        if (stringArray == null || (n12 = stringArray.length) < n14) {
            stringArray = EMPTY_STRING;
        }
        n12 = stringArray.length + n14;
        String[] stringArray2 = new String[n12];
        Locale locale = Locale.ROOT;
        string2 = string2.toLowerCase(locale);
        locale = null;
        stringArray2[0] = string2;
        int n15 = 0;
        string2 = null;
        while (n15 < (n11 = stringArray.length)) {
            String string4 = stringArray[n15];
            ++n15;
            if (string4 == null) {
                string4 = string3;
            } else {
                Locale locale2 = Locale.ROOT;
                string4 = string4.toLowerCase(locale2);
            }
            stringArray2[n15] = string4;
        }
        object = ((Pattern)object).matcher((CharSequence)spannable);
        n15 = 0;
        string2 = null;
        while ((n10 = ((Matcher)object).find()) != 0) {
            n10 = ((Matcher)object).start();
            n13 = ((Matcher)object).end();
            n11 = matchFilter != null ? (int)(matchFilter.acceptMatch((CharSequence)spannable, n10, n13) ? 1 : 0) : n14;
            if (n11 == 0) continue;
            string2 = LinkifyCompat.makeUrl(((Matcher)object).group(0), stringArray2, (Matcher)object, transformFilter);
            LinkifyCompat.applyLink(string2, n10, n13, spannable);
            n15 = n14;
        }
        return n15 != 0;
    }

    public static boolean addLinks(TextView textView, int n10) {
        boolean bl2 = LinkifyCompat.shouldAddLinksFallbackToFramework();
        if (bl2) {
            return Linkify.addLinks((TextView)textView, (int)n10);
        }
        bl2 = false;
        if (n10 == 0) {
            return false;
        }
        CharSequence charSequence = textView.getText();
        boolean bl3 = charSequence instanceof Spannable;
        boolean bl4 = true;
        if (bl3) {
            if ((n10 = (int)(LinkifyCompat.addLinks((Spannable)(charSequence = (Spannable)charSequence), n10) ? 1 : 0)) != 0) {
                LinkifyCompat.addLinkMovementMethod(textView);
                return bl4;
            }
            return false;
        }
        n10 = (int)(LinkifyCompat.addLinks((Spannable)(charSequence = SpannableString.valueOf((CharSequence)charSequence)), n10) ? 1 : 0);
        if (n10 != 0) {
            LinkifyCompat.addLinkMovementMethod(textView);
            textView.setText(charSequence);
            return bl4;
        }
        return false;
    }

    private static void applyLink(String string2, int n10, int n11, Spannable spannable) {
        URLSpan uRLSpan = new URLSpan(string2);
        spannable.setSpan((Object)uRLSpan, n10, n11, 33);
    }

    private static String findAddress(String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return WebView.findAddress((String)string2);
        }
        return FindAddress.findAddress(string2);
    }

    private static void gatherLinks(ArrayList arrayList, Spannable spannable, Pattern object, String[] stringArray, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        int n10;
        object = ((Pattern)object).matcher((CharSequence)spannable);
        while ((n10 = ((Matcher)object).find()) != 0) {
            String string2;
            boolean bl2;
            n10 = ((Matcher)object).start();
            int n11 = ((Matcher)object).end();
            if (matchFilter != null && !(bl2 = matchFilter.acceptMatch((CharSequence)spannable, n10, n11))) continue;
            LinkifyCompat$LinkSpec linkifyCompat$LinkSpec = new LinkifyCompat$LinkSpec();
            linkifyCompat$LinkSpec.url = string2 = LinkifyCompat.makeUrl(((Matcher)object).group(0), stringArray, (Matcher)object, transformFilter);
            linkifyCompat$LinkSpec.start = n10;
            linkifyCompat$LinkSpec.end = n11;
            arrayList.add(linkifyCompat$LinkSpec);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void gatherMapLinks(ArrayList arrayList, Spannable object) {
        object = object.toString();
        int n10 = 0;
        try {
            String string2;
            while ((string2 = LinkifyCompat.findAddress((String)object)) != null) {
                int n11 = ((String)object).indexOf(string2);
                if (n11 < 0) {
                    return;
                }
                LinkifyCompat$LinkSpec linkifyCompat$LinkSpec = new LinkifyCompat$LinkSpec();
                int n12 = string2.length() + n11;
                linkifyCompat$LinkSpec.start = n11 += n10;
                linkifyCompat$LinkSpec.end = n10 += n12;
                object = ((String)object).substring(n12);
                CharSequence charSequence = "UTF-8";
                try {
                    string2 = URLEncoder.encode(string2, (String)charSequence);
                    charSequence = new StringBuilder();
                    String string3 = "geo:0,0?q=";
                    ((StringBuilder)charSequence).append(string3);
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    continue;
                }
                ((StringBuilder)charSequence).append(string2);
                linkifyCompat$LinkSpec.url = string2 = ((StringBuilder)charSequence).toString();
                arrayList.add(linkifyCompat$LinkSpec);
            }
            return;
        }
        catch (UnsupportedOperationException unsupportedOperationException) {}
    }

    private static String makeUrl(String string2, String[] object, Matcher matcher, Linkify.TransformFilter object2) {
        boolean bl2;
        int n10;
        block5: {
            if (object2 != null) {
                string2 = object2.transformUrl(matcher, string2);
            }
            matcher = null;
            n10 = 0;
            object2 = null;
            while (true) {
                int n11 = ((String[])object).length;
                bl2 = true;
                if (n10 >= n11) break;
                boolean bl3 = true;
                String string3 = object[n10];
                int n12 = object[n10].length();
                CharSequence charSequence = string2;
                n11 = (int)(string2.regionMatches(bl3, 0, string3, 0, n12) ? 1 : 0);
                if (n11 != 0) {
                    bl3 = false;
                    String string4 = null;
                    string3 = object[n10];
                    n12 = object[n10].length();
                    charSequence = string2;
                    n11 = (int)(string2.regionMatches(false, 0, string3, 0, n12) ? 1 : 0);
                    if (n11 == 0) {
                        charSequence = new StringBuilder();
                        string4 = object[n10];
                        ((StringBuilder)charSequence).append(string4);
                        object2 = object[n10];
                        n10 = ((String)object2).length();
                        string2 = string2.substring(n10);
                        ((StringBuilder)charSequence).append(string2);
                        string2 = ((StringBuilder)charSequence).toString();
                    }
                    break block5;
                }
                ++n10;
            }
            bl2 = false;
        }
        if (!bl2 && (n10 = ((String[])object).length) > 0) {
            object2 = new StringBuilder();
            object = object[0];
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(string2);
            string2 = ((StringBuilder)object2).toString();
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void pruneOverlaps(ArrayList arrayList, Spannable spannable) {
        int n10;
        LinkifyCompat$LinkSpec linkifyCompat$LinkSpec;
        int n11;
        int n12;
        int n13 = spannable.length();
        int n14 = 0;
        URLSpan[] uRLSpanArray = (URLSpan[])spannable.getSpans(0, n13, URLSpan.class);
        LinkifyCompat$LinkSpec linkifyCompat$LinkSpec2 = null;
        for (n12 = 0; n12 < (n11 = uRLSpanArray.length); ++n12) {
            URLSpan uRLSpan;
            linkifyCompat$LinkSpec = new LinkifyCompat$LinkSpec();
            linkifyCompat$LinkSpec.frameworkAddedSpan = uRLSpan = uRLSpanArray[n12];
            URLSpan uRLSpan2 = uRLSpanArray[n12];
            linkifyCompat$LinkSpec.start = n10 = spannable.getSpanStart((Object)uRLSpan2);
            URLSpan uRLSpan3 = uRLSpanArray[n12];
            linkifyCompat$LinkSpec.end = n10 = spannable.getSpanEnd((Object)uRLSpan3);
            arrayList.add(linkifyCompat$LinkSpec);
        }
        Comparator comparator = COMPARATOR;
        Collections.sort(arrayList, comparator);
        n13 = arrayList.size();
        while (n14 < (n12 = n13 + -1)) {
            int n15;
            int n16;
            int n17;
            linkifyCompat$LinkSpec2 = (LinkifyCompat$LinkSpec)arrayList.get(n14);
            n11 = n14 + 1;
            LinkifyCompat$LinkSpec linkifyCompat$LinkSpec3 = (LinkifyCompat$LinkSpec)arrayList.get(n11);
            int n18 = linkifyCompat$LinkSpec2.start;
            int n19 = linkifyCompat$LinkSpec3.start;
            if (n18 <= n19 && (n12 = linkifyCompat$LinkSpec2.end) > n19 && (n12 = (n10 = linkifyCompat$LinkSpec3.end) <= n12 || (n17 = n12 - n18) > (n16 = n10 - n19) ? n11 : ((n12 -= n18) < (n10 -= n19) ? n14 : n15)) != (n15 = -1)) {
                linkifyCompat$LinkSpec = ((LinkifyCompat$LinkSpec)arrayList.get((int)n12)).frameworkAddedSpan;
                if (linkifyCompat$LinkSpec != null) {
                    spannable.removeSpan((Object)linkifyCompat$LinkSpec);
                }
                arrayList.remove(n12);
                n13 += -1;
                continue;
            }
            n14 = n11;
        }
        return;
    }

    private static boolean shouldAddLinksFallbackToFramework() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }
}

