import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            String line = sc.nextLine();
            // 입력의 끝인 '#'이 들어오면 반복문을 종료합니다.
            if(line.equals("#")){
                break;
            }
            
            line = line.toLowerCase();
            
            int count = 0;
            // 문자열의 길이만큼 반복하며 글자를 하나씩 확이합니다.
            for(int i = 0; i < line.length(); i++){
                char ch = line.charAt(i);
                
                // 현재 문자가 모음인지 확인합니다.
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    count++;
                } 
            }
            
            System.out.println(count);
        }
       
        sc.close();
    }
}