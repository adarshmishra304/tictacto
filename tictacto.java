import java.util.*;
 public class tictacto
 {
    public static void main() 
    {

       tictacto ob=new tictacto();
        Scanner Sc=new Scanner(System.in);
        int i=0,j=0,a=0,n=0;
        char[][] arr=new char[3][3];
        char c='1';
        String s=" ";
        for(i=2;i>=0;i--)
        {
            for(j=0;j<3;j++)
            arr[i][j]=c++;
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
         for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
            System.out.print(arr[i][j]);
         System.out.println();
        }
        for(a=9;a>0;a--)
        {
            n=Sc.nextInt();
            if(n<1||n>9)
            {
                System.out.println("wrong input");
                a++;
                continue;
            }
            if(s.indexOf((char)(48+n))!=-1&&s.length()!=1)
            {
                System.out.println("input another value");
                a++;
                continue;
            }
            s=s+" "+n;
            if(n<4)
            ob.printing(arr,2,n-1,a%2==0?'O':'X');
            else if(n<7)
            ob.printing(arr,1,n-4,a%2==0?'O':'X');
            else
            ob.printing(arr,0,n-7,a%2==0?'O':'X');
            
            if(a>4)
            {
                if((arr[0][0]==arr[0][1]&&arr[0][1]==arr[0][2])||(arr[1][0]==arr[1][1]&&arr[1][1]==arr[1][2])||
                (arr[2][0]==arr[2][1]&&arr[2][1]==arr[2][2])||(arr[0][0]==arr[1][0]&&arr[1][0]==arr[2][0])||
                (arr[0][1]==arr[1][1]&&arr[1][1]==arr[2][1])||(arr[0][2]==arr[1][2]&&arr[1][2]==arr[2][2])||
                (arr[0][0]==arr[1][1]&&arr[1][1]==arr[2][2])||(arr[2][0]==arr[1][1]&&arr[1][1]==arr[0][2]))
                {  
                    System.out.println("match over");
                    if(a%2==1)
                    System.out.println("X won");
                    else
                    System.out.println("O won");
                    System.exit(0);
                }
            }
            
           
        }
        System.out.println("drew \n shake hand");
    
    }
        void printing( char[][] arr,int r,int c,char z)
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        int i,j;
        arr[r][c]=z;
        for(i=0;i<3;i++)
        {
            for(j=0;j<3;j++)
             System.out.print( arr[i][j]+"   ");
             System.out.println();
        }
    }
}
