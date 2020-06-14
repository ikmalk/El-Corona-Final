/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corona.map;

import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author farha
 */
public class Map {

    Scanner s = new Scanner(System.in);
    private static final int home = 0;
    private static final int school = 1;
    private static final int office = 2;
    private static final int hospital = 3;
    private static final int restaurant = 4;
    private static final int bank = 5;
    private static final int supermarket = 6;
    private static final int shoppingMall = 7;
    private static final int airport = 8;
    private static final int park = 9;
    private static final int policeStation = 10;
    private static final int governmentOffice = 11;
    private static final int Gym = 12;
    private final int SIZE = 13;
    public placeManagement[][] map;
    public locationList[] locationlist;

    public Map() {
        map = new placeManagement[10][10];
        locationlist = new locationList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            locationlist[i] = new locationList();
        }

        locate();
    }

    public void locate() {
        int homeCount = 0;
        int officeCount = 0;
        int schoolCount = 0;
        int restaurantCount = 0;
        int supermarketCount = 0;
        int mallCount = 0;
        int terminalCount = 0;
        int gymCount = 0;
        int bankCount = 0;
        int gvtofficeCount = 0;

        //Home
        for (int i = 2; i < 4; i++) {
            for (int j = 1; j < 7; j++) {
                if (j != 2 && j != 3) {
                    homeCount++;
                    map[i][j] = new placeManagement("Home" + homeCount);
                    locationlist[0].addNode(i, j);  //record all the home location in location list
                }

            }
        }
        for (int i = 8; i < 10; i++) {
            for (int j = 2; j < 5; j++) {
                homeCount++;
                map[i][j] = new placeManagement("Home" + homeCount);
                locationlist[0].addNode(i, j);
            }
        }
        //Office
        for (int i = 2; i < 6; i++) {
            for (int j = 2; j < 10; j++) {
                if (i == 2 || i == 3) {
                    if (j == 2 || j == 3) {
                        officeCount++;
                        map[i][j] = new placeManagement("Office" + officeCount);
                        locationlist[2].addNode(i, j);  //record all the office in locationlist
                    }
                }
                if (i == 4) {
                    if (j == 5 || j == 6) {
                        officeCount++;
                        map[i][j] = new placeManagement("Office" + officeCount);
                        locationlist[2].addNode(i, j);
                    }
                }
                if (i == 5) {
                    if (j >= 5 && j <= 9) {
                        officeCount++;
                        map[i][j] = new placeManagement("Office" + officeCount);
                        locationlist[2].addNode(i, j);
                    }
                }
            }
        }
        //school
        map[2][0] = new placeManagement("School" + (++schoolCount));
        locationlist[1].addNode(2, 0);// add all the school to the location list
        map[3][0] = new placeManagement("School" + (++schoolCount));
        locationlist[1].addNode(3, 0);
        map[8][0] = new placeManagement("School" + (++schoolCount));
        locationlist[1].addNode(8, 0);
        map[9][0] = new placeManagement("School" + (++schoolCount));
        locationlist[1].addNode(9, 0);
        map[8][1] = new placeManagement("School" + (++schoolCount));
        locationlist[1].addNode(8, 1);
        map[9][1] = new placeManagement("School" + (++schoolCount));
        locationlist[1].addNode(9, 1);
        //Hospital
        for (int i = 2; i < 5; i++) {
            for (int j = 7; j < 10; j++) {
                if (i == 2 && j == 7) {
                    map[i][j] = new placeManagement("Hospital");
                    locationlist[3].addNode(2, 7);// only one hospital instance of management overall
                } else {
                    map[i][j] = map[2][7];
                    locationlist[3].addNode(i, j);
                }
            }
        }
        //mall
        for (int i = 6; i < 8; i++) {
            for (int j = 5; j < 10; j++) {
                if (i == 7) {
                    if (j > 5 && j < 9) {
                        map[i][j] = new placeManagement("Mall" + (++mallCount));
                        locationlist[7].addNode(i, j);
                        continue;
                    }
                }
                supermarketCount++;
                map[i][j] = new placeManagement("Supermarket" + supermarketCount);
                locationlist[6].addNode(i, j);
            }
        }
        for (int i = 8; i < 10; i++) {
            for (int j = 5; j < 10; j++) {
                if (i == 8) {
                    if (j > 5 && j < 9) {
                        map[i][j] = new placeManagement("Mall" + (++mallCount));
                        locationlist[7].addNode(i, j);
                        continue;
                    }
                }
                restaurantCount++;
                map[i][j] = new placeManagement("Restaurant" + restaurantCount);
                locationlist[4].addNode(i, j);
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 6; j < 10; j++) {
                map[i][j] = new placeManagement("Airport" + (++terminalCount));
                locationlist[8].addNode(i, j);
            }
        }
        map[0][0] = new placeManagement("Gym" + (++gymCount));
        locationlist[12].addNode(0, 0);
        map[1][0] = new placeManagement("Gym" + (++gymCount));
        locationlist[12].addNode(1, 0);
        map[4][0] = new placeManagement("Gym" + (++gymCount));
        locationlist[12].addNode(4, 0);
        map[4][1] = new placeManagement("Gym" + (++gymCount));
        locationlist[12].addNode(4, 1);

        for (int i = 0; i < 2; i++) {
            for (int j = 4; j < 6; j++) {
                map[i][j] = new placeManagement("Bank " + (++bankCount));
                locationlist[5].addNode(i, j);
            }
        }

        for (int i = 5; i < 8; i++) {
            for (int j = 0; j < 2; j++) {
                if (i == 5 && j == 0) {
                    map[i][j] = new placeManagement("Police Station");
                    locationlist[10].addNode(i, j);
                } else {
                    map[i][j] = map[5][0];
                    locationlist[10].addNode(i, j);
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 4; j++) {
                map[i][j] = new placeManagement("GovtOffice" + (++gvtofficeCount));
                locationlist[11].addNode(i, j);
            }
        }

        for (int i = 4; i < 8; i++) {
            for (int j = 2; j < 5; j++) {
                if (i == 4 && j == 2) {
                    map[i][j] = new placeManagement("Park");
                    locationlist[9].addNode(i, j);
                } else {
                    map[i][j] = map[4][2];
                    locationlist[9].addNode(i, j);
                }
            }
        }
    }
    
    public void show() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%-20s", map[i][j].toString());
            }
            System.out.println("");
            System.out.println("");
        }
    }
    
    public void showList() {
    	for(int i = 0;i<locationlist.length;i++) {
    		locationlist[i].showList();
    		System.out.println();
    	}
    }
    
    //write the map into a text file
    public void write() throws Exception{
    	FileWriter writer = new FileWriter("Map.txt");
    	for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                writer.write(String.format("%-20s", map[i][j].toString()));
            }
            writer.write("\n\n");
        }
    	writer.close();
    }
    

}
