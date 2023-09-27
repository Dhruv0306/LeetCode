class Solution {
    public int romanToInt(String s) {
        int res=0;
        for(int i=s.length()-1;i>=0;i--){ //VI
            char ch=s.charAt(i);
            switch(ch){
                case 'M':res=res+1000;
                break;
                case 'D':res=res+500;
                break;
                case 'C':if(res>=500){
                    res=res-100;
                }else{
                    res=res+100;
                };
                break;
                case 'L':res=res+50;
                break;
                case 'X':if(res>=50){
                    res=res-10;
                }else{
                    res=res+10;
                };
                break;
                case 'V':res=res+5;
                break;
                case 'I': if(res>=5){
                    res=res-1;
                }else{
                    res=res+1;
                };
                break;
                default :System.out.println("invalid");
                break;
            }
        }
        return res;
    }
}