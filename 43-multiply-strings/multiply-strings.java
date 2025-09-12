import java.math.BigInteger;
class Solution {
    public String multiply(String num1, String num2) {
    BigInteger n = new BigInteger(num1);
    BigInteger m = new BigInteger(num2);
    BigInteger res = n.multiply(m);
    return res.toString();    
    }
}