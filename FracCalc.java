import java.util.*; 

public class FracCalc {

    public static void main(String[] args) 
    {
        Scanner inputScanner = new Scanner(System.in);
        
            String inputLine = inputScanner.nextLine();
            System.out.println(produceAnswer(inputLine));
        
        
    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
        String x = "";
        String y = "";
        String answer = "";

        boolean multiply = false;
        boolean divide = false;
        boolean add = false;
        boolean subtract = false;
        boolean xWholeFound = false;
        boolean yWholeFound = false;
        boolean opFound = false;

        int count = 0;
        int lastPlace = 0;

        int xWhole = 0;
        int xImp;
        int xNum = 0;
        int xDeno = 1;

        int yWhole = 0;
        int yImp;
        int yNum = 0;
        int yDeno = 1;

        while(input.charAt(count) != ' '){
            count = count + 1;
            if(input.charAt(count) == ' '){
                if(input.charAt(count+1) == '/'){
                    divide = true;
                    opFound = true;

                }
                else if(input.charAt(count+1) == '*'){
                    multiply = true;
                    opFound = true;

                }
                else if(input.charAt(count+1) == '+'){
                    add = true;
                    opFound = true;

                }
                else if(input.charAt(count+1) == '-' ){
                    subtract = true;
                    opFound = true;

                }
                x = input.substring(0, count);
                y = input.substring(count + 3);

            }

        }
        
        for(int a = 0; a < x.length(); a++){
            if(x.indexOf('/') != -1){
                if(x.charAt(a) == '_'){
                    xWhole = Integer.parseInt(x.substring(0,a));
                    lastPlace = a+1;
                }
                else if(x.charAt(a) == '/'){
                    xNum = Integer.parseInt(x.substring(lastPlace,a));
                    xDeno = Integer.parseInt(x.substring(a+1));

                }
            }
            else{
                xWhole = Integer.parseInt(x);
            }
        }
        lastPlace = 0;
        if(xWhole >= 0){
            xImp = (xDeno*xWhole)+xNum;
        }
        else{
            xImp = (xDeno*xWhole)-xNum;
        }
        for(int b = 0; b < y.length(); b++){
            if(y.indexOf('/') != -1){
                if(y.charAt(b) == '_'){
                    yWhole = Integer.parseInt(y.substring(0,b));
                    lastPlace = b+1;
                }
                else if(y.charAt(b) == '/'){
                    yNum = Integer.parseInt(y.substring(lastPlace,b));
                    yDeno = Integer.parseInt(y.substring(b+1));

                }
            }
            else{
                yWhole = Integer.parseInt(y);
            }
        }
        if(yWhole >= 0){
            yImp = (yDeno*yWhole)+yNum;
        }
        else{
            yImp = (yDeno*yWhole)-yNum;
        }
        

        if(add == true){
            answer = fracAdd(xImp, xDeno, yImp, yDeno);
        }
        else if(subtract == true){
            answer = fracAdd(xImp, xDeno, -yImp, yDeno);
        }
        else if(divide == true){
            answer = fracMult(xImp, xDeno, yDeno, yImp);
        }
        else if(multiply == true){
            
            answer = fracMult(xImp, xDeno, yImp, yDeno);
        }

        return answer;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static double fracToNumber(String num, String deno){
        int numerator = Integer.parseInt(num);
        int denominator = Integer.parseInt(deno);

        return (((double)(numerator))/denominator);
    }

    public static int LCM(int x, int y){
        int lcm;
        if(x > y){
            lcm = x;
        }
        else{
            lcm = y;
        }
        if(x != 0 && y != 0){
            while((lcm % x != 0 || lcm % y != 0)){
                lcm += 1;
            }
            return lcm;
        }
        else{
            return -1;
        }
    }

    public static int GCF(int x, int y){
        int gcf = 1;
        int max = 0;
        boolean doMath = false;
        if(y==x){
            gcf = 1;
            
        }
        else if(y> x){
            max = x;
            gcf = 2;
            doMath = true;
        }
        else if(y< x){
            max = y;
            gcf = 2;
            doMath = true;
        }
        if(doMath){
        while((x % gcf != 0 || y % gcf != 0) && gcf <= max){
            gcf += 1;
        }
    }
        if(gcf <= max && max%gcf == 0){
            return gcf;
    }
    else{
        return 1;
    }
    
    }
    
    public static int commonFac(int x, int y){
        int count;
        int val = 1;
        int i;
        
        
        if(x > y){
            count = x;
            i = y;
        }
        else{
            count = y;
            i = x;
        }
        
        for(i = i; i<count; i++){
            if((count%i) == 0){
                val = i;
                break;
            }
            i+=1;
        }
        return val;
    }

    public static String fracAdd(int xNum, int xDeno, int yNum, int yDeno){
        int LCD = LCM(xDeno,yDeno);
        
        String val = "";
        int Total = xNum*(LCD/xDeno) + yNum*(LCD/yDeno);
        int fac = GCF(Total, LCD);
        int numerator = (xNum*(LCD/xDeno) + yNum*(LCD/yDeno))/fac;
        int denominator = LCD/fac;
        int newNum = (numerator%denominator)/GCF(numerator%denominator, denominator);
        int newDeno = denominator/GCF(numerator%denominator, denominator);
        if(Math.abs(numerator) > denominator && Math.abs(numerator) % denominator != 0){
            
            val = numerator/denominator + "_" + (Math.abs(newNum)) + "/" + Math.abs(newDeno);
        
        
        }
        else if (Math.abs(numerator)%denominator == 0){
            val = numerator / denominator + "";
        }
        else if(Math.abs(numerator) == 0){
            val = "0";
        }
        else{
            
        
            val = numerator + "/" + (denominator);
        
        }
        return val;
        
    }
    public static String fracMult(int xNum,int xDeno, int yNum, int yDeno){
        
        
        String val = "";
        
        int fac = GCF(Math.abs(xNum*yNum), Math.abs(xDeno*yDeno));
        int numerator = xNum * yNum / fac;
        int denominator = xDeno*yDeno/fac;
        int newNum = (numerator%denominator)/GCF(Math.abs(numerator%denominator), Math.abs(denominator));
        int newDeno = denominator/GCF(Math.abs(numerator%denominator), Math.abs(denominator));
        if(numerator != 0){
        if(Math.abs(numerator) > denominator && Math.abs(numerator)%denominator != 0){
            
            val = numerator/denominator + "_" + Math.abs(newNum) + "/" + Math.abs(newDeno);
        
        
        }
        else if (Math.abs(numerator)%denominator == 0){
            val = numerator / denominator + "";
        }
        
        else{
            
        
            val = numerator + "/" + (denominator);
        
        }
    }
    else if(Math.abs(numerator) == 0){
            val = "0";
        }
        return val;
        
    }
    
    

}

