class Solution {
    public boolean isValid(String s) {
        char []ch = new char[s.length()];

        if(s.length()%2!=0){
            return false;
        }

        int index = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='{' || c=='(' || c=='['){
                ch[index] = c;
                index++;
            }
            else if(index==0){
                return false;
            }
            else if(ch[index-1]=='{' && c=='}'){
                index--;
            }
            else if(ch[index-1]=='(' && c==')'){
                index--;
            }
            else if(ch[index-1]=='[' && c==']'){
                index--;
            }
            else{
                return false;
            }

            if(index<0){
                return false;
            }
        }
        if(index == 0){
            return true;
        }
        else{
            return false;
        }
    }
}