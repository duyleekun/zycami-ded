/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 */
package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import androidx.navigation.NavArgument;
import androidx.navigation.NavDeepLink$MimeType;
import androidx.navigation.NavDeepLink$ParamQuery;
import androidx.navigation.NavDeepLinkRequest;
import androidx.navigation.NavType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class NavDeepLink {
    private static final Pattern SCHEME_PATTERN = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    private final String mAction;
    private final ArrayList mArguments;
    private boolean mExactDeepLink;
    private boolean mIsParameterizedQuery;
    private final String mMimeType;
    private Pattern mMimeTypePattern;
    private final Map mParamArgMap;
    private Pattern mPattern;
    private final String mUri;

    public NavDeepLink(String string2) {
        this(string2, null, null);
    }

    public NavDeepLink(String string2, String string3, String string4) {
        boolean bl2;
        NavDeepLink navDeepLink = this;
        Object object = string2;
        CharSequence charSequence = string4;
        Object object2 = new ArrayList();
        this.mArguments = object2;
        this.mParamArgMap = object2;
        int n10 = 0;
        this.mPattern = null;
        int n11 = 0;
        String string5 = null;
        this.mExactDeepLink = false;
        this.mIsParameterizedQuery = false;
        this.mMimeTypePattern = null;
        this.mUri = string2;
        object2 = string3;
        this.mAction = string3;
        this.mMimeType = string4;
        if (string2 != null) {
            int n12;
            object2 = Uri.parse((String)string2);
            CharSequence charSequence2 = object2.getQuery();
            int n13 = 1;
            if (charSequence2 != null) {
                n12 = n13;
            } else {
                n12 = 0;
                charSequence2 = null;
            }
            navDeepLink.mIsParameterizedQuery = n12;
            super("^");
            Object object3 = SCHEME_PATTERN.matcher((CharSequence)object);
            boolean bl3 = ((Matcher)object3).find();
            if (!bl3) {
                object3 = "http[s]?://";
                ((StringBuilder)charSequence2).append((String)object3);
            }
            object3 = Pattern.compile("\\{(.+?)\\}");
            int n14 = navDeepLink.mIsParameterizedQuery;
            String string6 = "\\E.*\\Q";
            String string7 = ".*";
            if (n14 != 0) {
                Object object4 = Pattern.compile("(\\?)").matcher((CharSequence)object);
                boolean bl4 = ((Matcher)object4).find();
                if (bl4) {
                    n14 = ((Matcher)object4).start();
                    object = ((String)object).substring(0, n14);
                    navDeepLink.buildPathRegex((String)object, (StringBuilder)charSequence2, (Pattern)object3);
                }
                navDeepLink.mExactDeepLink = false;
                object = object2.getQueryParameterNames().iterator();
                while ((n14 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                    boolean bl5;
                    object4 = (String)object.next();
                    StringBuilder stringBuilder = new StringBuilder();
                    String string8 = object2.getQueryParameter((String)object4);
                    Matcher matcher = ((Pattern)object3).matcher(string8);
                    NavDeepLink$ParamQuery navDeepLink$ParamQuery = new NavDeepLink$ParamQuery();
                    int n15 = 0;
                    while (bl5 = matcher.find()) {
                        string5 = matcher.group(n13);
                        navDeepLink$ParamQuery.addArgumentName(string5);
                        n11 = matcher.start();
                        string5 = Pattern.quote(string8.substring(n15, n11));
                        stringBuilder.append(string5);
                        stringBuilder.append("(.+?)?");
                        n15 = matcher.end();
                        n11 = 0;
                        string5 = null;
                    }
                    n11 = string8.length();
                    if (n15 < n11) {
                        string5 = Pattern.quote(string8.substring(n15));
                        stringBuilder.append(string5);
                    }
                    string5 = stringBuilder.toString().replace(string7, string6);
                    navDeepLink$ParamQuery.setParamRegex(string5);
                    navDeepLink.mParamArgMap.put(object4, navDeepLink$ParamQuery);
                    n11 = 0;
                    string5 = null;
                }
            } else {
                navDeepLink.mExactDeepLink = bl2 = navDeepLink.buildPathRegex((String)object, (StringBuilder)charSequence2, (Pattern)object3);
            }
            object = ((StringBuilder)charSequence2).toString().replace(string7, string6);
            n10 = 2;
            navDeepLink.mPattern = object = Pattern.compile((String)object, n10);
        }
        if (charSequence != null) {
            object = Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(charSequence);
            bl2 = ((Matcher)object).matches();
            if (bl2) {
                object = new NavDeepLink$MimeType((String)charSequence);
                super();
                ((StringBuilder)charSequence).append("^(");
                object2 = ((NavDeepLink$MimeType)object).mType;
                ((StringBuilder)charSequence).append((String)object2);
                ((StringBuilder)charSequence).append("|[*]+)/(");
                object = ((NavDeepLink$MimeType)object).mSubType;
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append("|[*]+)$");
                object = ((StringBuilder)charSequence).toString();
                charSequence = "*|[*]";
                object2 = "[\\s\\S]";
                navDeepLink.mMimeTypePattern = object = Pattern.compile(((String)object).replace(charSequence, (CharSequence)object2));
            } else {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("The given mimeType ");
                ((StringBuilder)object2).append((String)charSequence);
                ((StringBuilder)object2).append(" does not match to required \"type/subtype\" format");
                charSequence = ((StringBuilder)object2).toString();
                object = new IllegalArgumentException((String)charSequence);
                throw object;
            }
        }
    }

    private boolean buildPathRegex(String string2, StringBuilder stringBuilder, Pattern object) {
        boolean bl2;
        object = ((Pattern)object).matcher(string2);
        String string3 = ".*";
        int n10 = string2.contains(string3);
        int n11 = 1;
        n10 ^= n11;
        int n12 = 0;
        while (bl2 = ((Matcher)object).find()) {
            string3 = ((Matcher)object).group(n11);
            ArrayList arrayList = this.mArguments;
            arrayList.add(string3);
            n10 = ((Matcher)object).start();
            string3 = Pattern.quote(string2.substring(n12, n10));
            stringBuilder.append(string3);
            stringBuilder.append("(.+?)");
            n12 = ((Matcher)object).end();
            n10 = 0;
            string3 = null;
        }
        int n13 = string2.length();
        if (n12 < n13) {
            string2 = Pattern.quote(string2.substring(n12));
            stringBuilder.append(string2);
        }
        stringBuilder.append("($|(\\?(.)*))");
        return n10 != 0;
    }

    private boolean matchAction(String string2) {
        boolean bl2;
        String string3;
        boolean bl3;
        boolean bl4 = true;
        boolean bl5 = string2 == null ? bl4 : false;
        if (bl5 == (bl3 = (string3 = this.mAction) != null ? bl4 : false)) {
            return false;
        }
        if (string2 != null && !(bl2 = string3.equals(string2))) {
            bl4 = false;
        }
        return bl4;
    }

    private boolean matchMimeType(String object) {
        boolean bl2;
        boolean bl3;
        Pattern pattern;
        boolean bl4;
        boolean bl5 = true;
        if (object == null) {
            bl4 = bl5;
        } else {
            bl4 = false;
            pattern = null;
        }
        String string2 = this.mMimeType;
        if (string2 != null) {
            bl3 = bl5;
        } else {
            bl3 = false;
            string2 = null;
        }
        if (bl4 == bl3) {
            return false;
        }
        if (object != null && !(bl2 = ((Matcher)(object = (pattern = this.mMimeTypePattern).matcher((CharSequence)object))).matches())) {
            bl5 = false;
        }
        return bl5;
    }

    private boolean matchUri(Uri object) {
        Pattern pattern;
        boolean bl2;
        boolean bl3 = true;
        boolean bl4 = object == null ? bl3 : false;
        if (bl4 == (bl2 = (pattern = this.mPattern) != null ? bl3 : false)) {
            return false;
        }
        if (object != null) {
            object = object.toString();
            boolean bl5 = ((Matcher)(object = pattern.matcher((CharSequence)object))).matches();
            if (!bl5) {
                bl3 = false;
            }
        }
        return bl3;
    }

    private boolean parseArgument(Bundle bundle, String string2, String string3, NavArgument object) {
        if (object != null) {
            object = ((NavArgument)object).getType();
            try {
                ((NavType)object).parseAndPut(bundle, string2, string3);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                return true;
            }
        } else {
            bundle.putString(string2, string3);
        }
        return false;
    }

    public String getAction() {
        return this.mAction;
    }

    public Bundle getMatchingArguments(Uri uri, Map map) {
        Object object;
        String string2;
        Object object2;
        Iterator iterator2 = this.mPattern;
        String string3 = uri.toString();
        boolean bl2 = ((Matcher)((Object)(iterator2 = ((Pattern)((Object)iterator2)).matcher(string3)))).matches();
        if (!bl2) {
            return null;
        }
        string3 = new Bundle();
        Object object3 = this.mArguments;
        int n11 = ((ArrayList)object3).size();
        int n12 = 0;
        NavDeepLink$ParamQuery navDeepLink$ParamQuery = null;
        while (n12 < n11) {
            object2 = (String)this.mArguments.get(n12);
            boolean n10 = this.parseArgument((Bundle)string3, (String)object2, string2 = Uri.decode((String)((Matcher)((Object)iterator2)).group(++n12)), (NavArgument)(object = (NavArgument)map.get(object2)));
            if (!n10) continue;
            return null;
        }
        boolean bl3 = this.mIsParameterizedQuery;
        if (bl3) {
            iterator2 = this.mParamArgMap.keySet().iterator();
            while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                int n10;
                int n13;
                object3 = (String)iterator2.next();
                navDeepLink$ParamQuery = (NavDeepLink$ParamQuery)this.mParamArgMap.get(object3);
                if ((object3 = uri.getQueryParameter((String)object3)) != null) {
                    object2 = Pattern.compile(navDeepLink$ParamQuery.getParamRegex());
                    object3 = ((Pattern)object2).matcher((CharSequence)object3);
                    n13 = ((Matcher)object3).matches();
                    if (n13 == 0) {
                        return null;
                    }
                } else {
                    n11 = 0;
                    object3 = null;
                }
                object2 = null;
                for (n13 = 0; n13 < (n10 = navDeepLink$ParamQuery.size()); ++n13) {
                    String string4;
                    String string5;
                    boolean bl4;
                    if (object3 != null) {
                        n10 = n13 + 1;
                        string2 = Uri.decode((String)((Matcher)object3).group(n10));
                    } else {
                        n10 = 0;
                        string2 = null;
                    }
                    object = navDeepLink$ParamQuery.getArgumentName(n13);
                    NavArgument navArgument = (NavArgument)map.get(object);
                    if (string2 == null || (bl4 = (string5 = string2.replaceAll("[{}]", string4 = "")).equals(object)) || (n10 = (int)(this.parseArgument((Bundle)string3, (String)object, string2, navArgument) ? 1 : 0)) == 0) continue;
                    return null;
                }
            }
        }
        return string3;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public int getMimeTypeMatchRating(String string2) {
        boolean bl2;
        Object object = this.mMimeType;
        if (object != null && (bl2 = ((Matcher)(object = this.mMimeTypePattern.matcher(string2))).matches())) {
            Object object2 = this.mMimeType;
            object = new NavDeepLink$MimeType((String)object2);
            object2 = new NavDeepLink$MimeType(string2);
            return ((NavDeepLink$MimeType)object).compareTo((NavDeepLink$MimeType)object2);
        }
        return -1;
    }

    public String getUriPattern() {
        return this.mUri;
    }

    public boolean isExactDeepLink() {
        return this.mExactDeepLink;
    }

    public boolean matches(Uri uri) {
        NavDeepLinkRequest navDeepLinkRequest = new NavDeepLinkRequest(uri, null, null);
        return this.matches(navDeepLinkRequest);
    }

    public boolean matches(NavDeepLinkRequest object) {
        Object object2 = ((NavDeepLinkRequest)object).getUri();
        boolean bl2 = this.matchUri((Uri)object2);
        if (!bl2) {
            return false;
        }
        object2 = ((NavDeepLinkRequest)object).getAction();
        bl2 = this.matchAction((String)object2);
        if (!bl2) {
            return false;
        }
        object = ((NavDeepLinkRequest)object).getMimeType();
        return this.matchMimeType((String)object);
    }
}

