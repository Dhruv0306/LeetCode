class Solution {
    public String toHex(int num) {
        // num = (num < 0) ? (~num + 1) : num;
        String binary = Integer.toBinaryString(num);
        // System.out.println(num);
        StringBuilder sb = new StringBuilder();
        for(int i = binary.length() - 1; i >= 0; i -= 4){
            if(i >= 3) sb.insert(0, hex(binary.substring(i - 3, i + 1)));
            else if(i == 2) sb.insert(0, hex("0" + binary.substring(i - 2, i + 1)));
            else if(i == 1) sb.insert(0, hex("00" + binary.substring(i - 1, i + 1)));
            else if(i == 0) sb.insert(0, hex("000" + binary.substring(i, i + 1)));
        }

        return sb.toString();
    }

    public static String hex(String bin){
        if(bin.equals("0000")) return "0"; if(bin.equals("0001")) return "1";
        if(bin.equals("0010")) return "2"; if(bin.equals("0011")) return "3";
        if(bin.equals("0100")) return "4"; if(bin.equals("0101")) return "5";
        if(bin.equals("0110")) return "6"; if(bin.equals("0111")) return "7";
        if(bin.equals("1000")) return "8"; if(bin.equals("1001")) return "9";
        if(bin.equals("1010")) return "a"; if(bin.equals("1011")) return "b";
        if(bin.equals("1100")) return "c"; if(bin.equals("1101")) return "d";
        if(bin.equals("1110")) return "e"; if(bin.equals("1111")) return "f";
        return "-1";
    }
}