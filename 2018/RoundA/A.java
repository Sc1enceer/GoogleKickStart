import java.io.PrintStream;
import java.util.*;

public class A{

  public String solve(Scanner sc){
    String str = sc.next();
    char[] chars = str.toCharArray();
    long v = long.MAX_VALUE;
    char[] temp = cal(chars, true);
    if(temp != null) v= Math.min(v,Math.abs(Long.parseLong(new String(temp)) - long.parseLong(s)));
    temp = cal(chars, false);
    if(temp != null) v= Math.min(v,Math.abs(Long.parseLong(new String(temp)) - long.parseLong(s)));
    return String.valueOf(v);
  }

  private char[] cal(char[] chars, boolean smaller){
    char[] ans = new char[chars.length];
    int small = 0;
    for(int i =0; i< chars.length; i++){
      if(small>0) ans[i] = '0';
      else if(small <0) ans[i] = '8';
      else{
        if((chars[i] - '0')%2 == 0) ans[i] = chars[i];
        else{
          if (smaller) {
            ans[i] = (char)(chars[i]-1);
            small -=1;

          } else {
            if (chars[i] == '9') {
              return null;
            }
            ans[i] = (char) (chars[i] +1);
            small=1;
          }
        }
      }
    }
    return ans;
  }



  public static void main(String[] args) throws Exception{
    System.setOut(new PrintStream("output.txt"));
    Scanner sc = new Scanner(System.in);
    int times = Integer.parseInt(sc.nextLine());
    long start = System.currentTimeMillis();
    for(int i = 1; i<= times; i++){
      try{
        System.out.println(String.format("Case #%d : %s", t, new Main().solve(sc)));
      } catch(Throwable e){
        System.out.println("ERROR in case #" + t);
        e.printStackTrace();
      }
    }
    long end = System.currentTimeMillis();
    System.err.println(String.format("Time used: %.3fs", (end-start)/1000.0));
  }
}
