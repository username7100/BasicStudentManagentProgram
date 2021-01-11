import java.io.*;
import java.util.*;

public class App {
    private ArrayList<String> List = new ArrayList<>();

    public App() {
        if (readFile("D:/test.txt")) {
            outList();
            sortFirstName();
            outList();
        }
    }

    public boolean readFile(String s) {
        File f = new File(s);
        if (f.exists()) {
            try (Scanner read = new Scanner(f)) {
                while (read.hasNextLine()) {
                    Scanner readln = new Scanner(read.nextLine());
                    String name = readln.nextLine();
                    List.add(name);
                }
            } catch (Exception e) {
                System.out.println("\n\tFile is invalid!\n");
                return false;
            }
        } else {
            System.out.println("\n\tFile isn't exists!\n");
            return false;
        }
        return true;
    }

    public void outList() {
        System.out.println();
        for (String i : List) {
            System.out.println(i);
        }
    }

    public void sortFirstName() {
        for (int i = 0; i < List.size() - 1; i += 1)
            for (int j = i + 1; j < List.size(); j += 1) {
                int x1 = List.get(i).indexOf(" ");
                int x = List.get(i).indexOf(" ", x1 + 1);
                int y1 = List.get(j).indexOf(" ");
                int y = List.get(j).indexOf(" ", y1 + 1);
                String lName1 = List.get(i).substring(0, x1);
                lName1 = lName1.trim();
                String lName2 = List.get(j).substring(0, y1);
                lName2 = lName2.trim();
                String fName1 = List.get(i).substring(x + 1, List.get(i).length());
                fName1 = fName1.trim();
                String fName2 = List.get(j).substring(y + 1, List.get(j).length());
                fName2 = fName2.trim();
                if (fName1.equals(fName2)) {
                    if (lName1.compareTo(lName2) > 0) {
                        String temp = List.get(i);
                        List.set(i, List.get(j));
                        List.set(j, temp);
                    }
                } else {
                    if (fName1.compareTo(fName2) > 0) {
                        String temp = List.get(i);
                        List.set(i, List.get(j));
                        List.set(j, temp);
                    }
                }
            }
    }

    public static void main(String[] args) {
        new App();
    }
}
/*D:\text.txt
Nguyễn Văn An   
Nguyễn Thị Huệ 
Lê Chí Thành    
Trần Ngọc Tâm  
Nguyễn Hoàng An
Bùi Thị Thơ    
Nguyễn Ngọc An
Phạm Hồng Hạnh 
Thái Bình Dương 
Đinh Nhân Tệ    
Nguyễn Xuân An  
*/
