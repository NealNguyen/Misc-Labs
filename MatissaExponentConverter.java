import java.util.*;

public class MatissaExponentConverter
{
    /*
     *  Convert the parameter val to its m-bit matissa and e-bit exponent
     *  with one space seperating the matissa and the exponent
     *  
     *  return "np" if the conversion is not possible
     * 
     * preconditions:  -???? >  val  > ????
     * 
     *         see the student tester for sample input/output
     */
    public static String toMatissaExponent(double val, int m, int e)
    {
        double mantissa = 0;
        int exponent = 0;
        while(Math.pow(2, exponent) <= Math.abs(val))
        {
            exponent++;
        }
        if(val != 0 && exponent == 0)
        {
            while(Math.pow(2, exponent - 1) > Math.abs(val))
            {
                exponent--;
            }
        }
        if(exponent >= Math.pow(2, e - 1) || exponent < -Math.pow(2, e - 1))
        {
            return "np";
        }
        String expStr = "";
        int bit = -(int)Math.pow(2, e - 1);
        int temp = exponent;
        if(temp < 0)
        {
            temp -= bit;
            expStr += "1";
        }
        else
        {
            expStr += "0";
        }
        bit /= -2;
        while(bit > 0)
        {
            if(bit <= temp)
            {
                temp -= bit;
                expStr += "1";
            }
            else
            {
                expStr += "0";
            }
            bit /= 2;
        }
        
        mantissa = val;
        while(Math.abs(mantissa) >= 1)
        {
            mantissa /= 2;
        }
        if(mantissa != 0)
        {
            while(Math.abs(mantissa) < 0.5)
            {
                mantissa *= 2;
            }
        }
        double bit2 = -1;
        String manStr = "";
        if(mantissa < 0)
        {
            manStr += "1";
            mantissa += 1;
        }
        else
        {
            manStr += "0";
        }
        bit2 /= -2;
        while(mantissa > 0 && bit2 > 0)
        {
            if(mantissa >= bit2)
            {
                mantissa -= bit2;
                manStr += "1";
            }
            else
            {
                manStr += "0";
            }
            bit2 /= 2;
        }
        if(manStr.length() > m)
        {
            return "np";
        }
        while(manStr.length() < m)
        {
            manStr += "0";
        }
        
        return manStr + " " + expStr;
    }

    /*
     *    converts the mantissa-exponent string to its equivalent real number
     *    
     *    precondition: str contains one space seperating the matissa from the exponent 
     *
     * 
     *         see the student tester for sample input/output
     */
    public static double toDouble(String str)
    {
        double num = 0;
        if(str.charAt(0) == '1')
        {
            num = -1;
        }
        int index = 1;
        while(index < str.indexOf(' '))
        {
            if(str.charAt(index) == '1')
            {
                num += Math.pow(2, -index);
            }
            index++;
        }
        
        int exponent = 0;
        String expStr = str.split(" ")[1];
        index = expStr.length() - 1;
        int bit = 1;
        while(index > 0)
        {
            if(expStr.charAt(index) == '1')
            {
                exponent += bit;
            }
            bit *= 2;
            index--;
        }
        if(expStr.charAt(0) == '1')
        {
            exponent -= bit;
        }
        
        return num * Math.pow(2, exponent);
    }
}