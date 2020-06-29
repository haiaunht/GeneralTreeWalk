/*
* Hai-Au Bui
* Assignment 6, CSD 335
* Professor Abbott
*/
package assignment6_hai.au_bui_csd335;

import java.io.File;

/**
 * @author HaiAu Bui
 * Assignment 6
 * CSD335, Professor Abbott
 */
public class Assignment6_HaiAu_Bui_CSD335 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //File test = new File("C:\\Users\\HaiAu\\OneDrive\\Desktop\\Data Structure and Algorithms\\FileTreeWalkFolder");
        String pathName = "C:\\Users\\HaiAu\\OneDrive\\Desktop\\Data Structure and Algorithms\\FileTreeWalkFolder" ;
        FileTreeWalk myTestFileTreeWalk = new FileTreeWalk( new File(pathName));
        myTestFileTreeWalk.listAllFiles();
        
       
        //TESTING toString() method
        System.out.println("\n\nTesting toString");
        System.out.println(myTestFileTreeWalk.toString());
        
        
        //Search for a file
        System.out.println("\nTest finding file");
        String result = myTestFileTreeWalk.findFiles("text2_1.txt");
        System.out.println(result);
    }
        
    
}
