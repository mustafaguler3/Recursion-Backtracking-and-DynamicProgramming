package recursion;

public class TowersOfHanoi {

    public void solve(int disk, char source,char middle,char destinatio){

        if (disk == 0){
            System.out.println("Plate "+disk+" from "+ source + " to "+destinatio);
            return;
        }

        solve(disk -1,source,destinatio,middle);

        System.out.println("Plate "+disk+" from "+ source + " to "+destinatio);
    }
}
