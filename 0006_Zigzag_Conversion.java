class Solution {
    public String convert(String s, int numRows) {
         int length = s.length();
        
        //Edge condition
        if(numRows > length || numRows <= 1) {
            return s;   
        }
        
        char[] ZigzagChars = new char[length];
        int interval = 2 * numRows  - 2;
        int count = 0;
        for(int i = 0; i< numRows; i++) {
            int step = interval - 2 * i;
            for(int j = i; j <length; j+=interval) {
                ZigzagChars[count] = s.charAt(j);
                count++;
                if(step > 0 && step < interval && j + step < length) {
                    ZigzagChars[count] = s.charAt(j + step);
                    count++;
                }
            }
        }
        
        return new String(ZigzagChars);
    }
}