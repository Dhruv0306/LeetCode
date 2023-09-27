class Solution {
    public int reverse(int x) {
        if(x<-2147483648 || x>2147483647)return 0;

        boolean isNagetive = x<0 ;
        long n = (isNagetive)?(-1*x):x, m = 0;

        while(n>0){
            m = 10*m + n%10;
            n = n/10;
        }
        m = (isNagetive)?(-1*m):m;
        
        if(m<-2147483648 || m>2147483647)return 0;
        return (int)m;
    }
}