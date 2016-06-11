/*
 * code authored by Maria & Gary Litvan
 */

public class Twos_Complement
{
    private String type;

    /*
     * Convert the 2s complement representation to its integer equivalent
     * 
     * precondition  s is the 2s complement number that is to be convert to an int
     *               The number of bits = s.length()
     * 
     *                 see the student tester for sample input/output
     */
    public static int convertToDecimal(String s)
    {
        int multiplier = 1;
        int sum = 0;
        for(int x = s.length() - 1; x >= 0; x--)
        {
            if(x == 0)
            {
                multiplier *= -1;
            }
            sum += multiplier*Integer.parseInt(s.substring(x, x+1));
            multiplier *= 2;
        }
        return sum;
    }

    /*
     * Convert the int parameter val to its 2s complement representatino
     * 
     * precondition:  -2^(bits-1) <+ val <+ (2^[bits-1]) - 1
     *                i.e., the valu fits in the range
     *                
     * postcondition   The return value has length() == bits
     * 
     *                 see the student tester for sample input/output
     */
    public static String convertDecimalTo2sComplement(int val, int bits)
    {
        String s = "";
        int multiplier = -(int)Math.pow(2, bits - 1);
        for(int x = 0; x < bits; x++)
        {
            if((val >= multiplier && multiplier > 0) || val < 0)
            {
                s += "1";
                val -= multiplier;
            }
            else
            {
                s += "0";
            }
            if(x == 0)
            {
                multiplier *= -1;
            }
            multiplier /= 2;
        }
        return s;
    }

    /*
     *    inverts the String parameter s to it negative value
     *    precondition:  s is a valid 2s complement number with s.length() bits
     *    
     *    postcondition  return a string with length() == s.length()
     *                   the decimals value of s == - decimal value of return String
     *                   
     *                   e.g.,  If s = 0111, the String 1001 is returned
     *                          If s = 001, the String 111 is returned
     */
    public static String invert(String s)
    {
        //return convertDecimalTo2sComplement(-convertToDecimal(s), s.length());
        int[] arr = new int[s.length()];
        for(int x = 0; x < s.length(); x++)
        {
            if(s.charAt(x) == '0')
            {
                arr[x] = 1;
            }
            else
            {
                arr[x] = 0;;
            }
        }
        String st = "";
        for(int x = arr.length - 1; x >= 0; x--)
        {
            if(arr[x] == 0)
            {
                arr[x] = 1;
                break;
            }
            else
            {
                arr[x] = 0;
            }
        }
        for(int x = 0; x < arr.length; x++)
        {
            st += "" + arr[x];
        }
        return st;
    }
}