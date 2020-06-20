package impl;

public class BackSpaceString {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length()-1;
        int j = T.length()-1;
        while(i>=0 || j>=0) {
            int icount=0;
            int jcount=0;
            while(i>=0 && S.charAt(i) == '#') {
                while(i>=0 && S.charAt(i) == '#') {
                    icount++;
                    i--;
                }
                while(icount>0) {
                    i--;
                    icount--;
                    if(i>=0 && S.charAt(i) == '#') {
                        icount++;
                        i--;
                    }
                }
            }
            while(j>=0 && T.charAt(j) == '#') {
                while(j>=0 && T.charAt(j) == '#') {
                    jcount++;
                    j--;
                }
                while(jcount>0) {
                    j--;
                    jcount--;
                    if(j>=0 && T.charAt(j) == '#') {
                        jcount++;
                        j--;
                    }
                }
            }
            if(i>=0 && j>=0 && S.charAt(i) != T.charAt(j)) return false;
            if((i>=0 && j<0 && S.charAt(i) != '#') || (j>=0 && i<0 && T.charAt(j) != '#')) return false;
            i--;j--;
        }
        return true;
    }
}