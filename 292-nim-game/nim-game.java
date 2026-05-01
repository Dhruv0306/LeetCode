class Solution {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}

/*
* n = 1 to 3 : Take n stone and you win
* n = 4 : You can take any 1, 2, 3 stones but still your friend still finishes
* n = 5 to 7 : W just make sure that even if our friend takes 3 stones we can take atleast 1 stone at the end to win
* n = 8 : Same as 4 we have no moves that will allow us to finish, our firend alwaus finishes

* Form this we can test that if n = 4k for any k then we loss and if not we win.
 */