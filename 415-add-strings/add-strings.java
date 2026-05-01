class Solution {
    public String addStrings(String num1, String num2) {
        int n = num1.length() - 1, m = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(n >= 0 && m >= 0){
            int sum = (num1.charAt(n) - '0') + (num2.charAt(m) - '0') + carry;
            if(sum > 9) {
                sum = sum % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            sb.insert(0, sum);
            n--; m--;
        }

        if(n >= 0){
            while(n >= 0){
                int sum = (num1.charAt(n) - '0') + carry;
                if(sum > 9) {
                    sum = sum % 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                sb.insert(0, sum);
                n--;
            }
        }

        if(m >= 0){
            while(m >= 0){
                int sum = (num2.charAt(m) - '0') + carry;
                if(sum > 9) {
                    sum = sum % 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                sb.insert(0, sum);
                m--;
            }
        }

        if(carry == 1){
            sb.insert(0, "1");
        }

        return sb.toString();
    }
}