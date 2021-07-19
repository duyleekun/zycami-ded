/*
 * Decompiled with CFR 0.151.
 */
package androidx.sqlite.db;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SupportSQLiteQueryBuilder {
    private static final Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private Object[] mBindArgs;
    private String[] mColumns = null;
    private boolean mDistinct = false;
    private String mGroupBy = null;
    private String mHaving = null;
    private String mLimit = null;
    private String mOrderBy = null;
    private String mSelection;
    private final String mTable;

    private SupportSQLiteQueryBuilder(String string2) {
        this.mTable = string2;
    }

    private static void appendClause(StringBuilder stringBuilder, String string2, String string3) {
        boolean bl2 = SupportSQLiteQueryBuilder.isEmpty(string3);
        if (!bl2) {
            stringBuilder.append(string2);
            stringBuilder.append(string3);
        }
    }

    private static void appendColumns(StringBuilder stringBuilder, String[] stringArray) {
        int n10 = stringArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = stringArray[i10];
            if (i10 > 0) {
                String string3 = ", ";
                stringBuilder.append(string3);
            }
            stringBuilder.append(string2);
        }
        stringBuilder.append(' ');
    }

    public static SupportSQLiteQueryBuilder builder(String string2) {
        SupportSQLiteQueryBuilder supportSQLiteQueryBuilder = new SupportSQLiteQueryBuilder(string2);
        return supportSQLiteQueryBuilder;
    }

    private static boolean isEmpty(String string2) {
        boolean bl2;
        if (string2 != null && (bl2 = string2.length())) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public SupportSQLiteQueryBuilder columns(String[] stringArray) {
        this.mColumns = stringArray;
        return this;
    }

    public SupportSQLiteQuery create() {
        int n10;
        Object object = this.mGroupBy;
        boolean bl2 = SupportSQLiteQueryBuilder.isEmpty((String)object);
        if (bl2 && !(bl2 = SupportSQLiteQueryBuilder.isEmpty((String)(object = this.mHaving)))) {
            object = new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
            throw object;
        }
        object = new StringBuilder(120);
        Object object2 = "SELECT ";
        ((StringBuilder)object).append((String)object2);
        boolean bl3 = this.mDistinct;
        if (bl3) {
            object2 = "DISTINCT ";
            ((StringBuilder)object).append((String)object2);
        }
        if ((object2 = this.mColumns) != null && (n10 = ((String[])object2).length) != 0) {
            SupportSQLiteQueryBuilder.appendColumns((StringBuilder)object, object2);
        } else {
            object2 = " * ";
            ((StringBuilder)object).append((String)object2);
        }
        ((StringBuilder)object).append(" FROM ");
        object2 = this.mTable;
        ((StringBuilder)object).append((String)object2);
        object2 = this.mSelection;
        SupportSQLiteQueryBuilder.appendClause((StringBuilder)object, " WHERE ", (String)object2);
        object2 = this.mGroupBy;
        SupportSQLiteQueryBuilder.appendClause((StringBuilder)object, " GROUP BY ", (String)object2);
        object2 = this.mHaving;
        SupportSQLiteQueryBuilder.appendClause((StringBuilder)object, " HAVING ", (String)object2);
        object2 = this.mOrderBy;
        SupportSQLiteQueryBuilder.appendClause((StringBuilder)object, " ORDER BY ", (String)object2);
        object2 = this.mLimit;
        SupportSQLiteQueryBuilder.appendClause((StringBuilder)object, " LIMIT ", (String)object2);
        object = ((StringBuilder)object).toString();
        Object[] objectArray = this.mBindArgs;
        object2 = new SimpleSQLiteQuery((String)object, objectArray);
        return object2;
    }

    public SupportSQLiteQueryBuilder distinct() {
        this.mDistinct = true;
        return this;
    }

    public SupportSQLiteQueryBuilder groupBy(String string2) {
        this.mGroupBy = string2;
        return this;
    }

    public SupportSQLiteQueryBuilder having(String string2) {
        this.mHaving = string2;
        return this;
    }

    public SupportSQLiteQueryBuilder limit(String string2) {
        Object object;
        boolean bl2 = SupportSQLiteQueryBuilder.isEmpty(string2);
        if (!bl2 && !(bl2 = ((Matcher)(object = sLimitPattern.matcher(string2))).matches())) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid LIMIT clauses:");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            object = new IllegalArgumentException(string2);
            throw object;
        }
        this.mLimit = string2;
        return this;
    }

    public SupportSQLiteQueryBuilder orderBy(String string2) {
        this.mOrderBy = string2;
        return this;
    }

    public SupportSQLiteQueryBuilder selection(String string2, Object[] objectArray) {
        this.mSelection = string2;
        this.mBindArgs = objectArray;
        return this;
    }
}

