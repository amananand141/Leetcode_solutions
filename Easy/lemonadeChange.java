class Solution {
    public boolean lemonadeChange(int[] bills) {
        // keep the counter of 5 & 10 $ bills
        int five = 0;
        int ten = 0;

        for(int i=0; i<bills.length; i++){
            if(bills[i] == 5){
                five++;
                // NO change to return 
            }else if(bills[i] == 10){
                if(five == 0){
                    // if no 5$ bills to give
                    return false;
                }
                ten++;
                five--;
            }else{
                if(ten == 0){
                    // if no 10$ available we try to pay with 3*5$ bills 
                    if(five < 3){// if not return false
                        return false;
                    }
                    five -= 3;
                }else{
                    ten--;
                    // we have the 10 but not a 5$ bill
                    if(five == 0)return false;
                    five--;
                }
            }
        }
        return true;
    }
}
