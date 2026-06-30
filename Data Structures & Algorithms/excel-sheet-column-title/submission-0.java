class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber>0) {
            int col = columnNumber%26;
            sb.append(col==0? 'Z':(char)('A'-1+col));
            columnNumber=(columnNumber-1)/26;
        }
        return sb.reverse().toString();
    }
}