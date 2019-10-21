package battleship;

import java.util.ArrayList;

public class DotCom {
    private String name;
    ArrayList<String> locationCells;
    int numOfHits;

    public void setName(String name){
        this.name=name;
    }

    public void setLocationCells(ArrayList<String> locs) {
        this.locationCells = locs;
    }
    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if (index>=0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "kill";
            } else {
                result = "hit";
            }
        }
        return result;
    }
}
