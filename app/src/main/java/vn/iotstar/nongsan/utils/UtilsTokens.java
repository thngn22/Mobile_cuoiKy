package vn.iotstar.nongsan.utils;

import vn.iotstar.nongsan.models.Tokens;

public class UtilsTokens {
    public static Tokens tokens = new Tokens();

    public UtilsTokens( Tokens tokens) {
        this.tokens = tokens;
    }

    public static Tokens getTokens() {
        return tokens;
    }

    public static void setTokens(Tokens tokens) {
        UtilsTokens.tokens = tokens;
    }
}
