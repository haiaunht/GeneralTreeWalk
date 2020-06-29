
package assignment6_hai.au_bui_csd335;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*
* Hai-Au Bui
* Assignment 6, CSD 335
* Professor Abbott
*/



public class FileTreeWalk {
    
    private File pathName;     //the starting point for the traversal of the file system    
    List<File> fileFound = new ArrayList<>();   //when traverse the file sys, if found the file, add in this list
    StringBuilder traversalString = new StringBuilder();    //build up the string while traverse the pathName files
  

    // constructor pass a specific pathname to traverse from
    public FileTreeWalk( File pathname ){
        this.pathName = pathname;
        if( !pathName.isFile() && !pathName.isDirectory())
            throw new IllegalArgumentException("Illegal path input. Input was a file not a directory.");
        traversalString.append( pathName.getName() +"\n" );
    }

    /*
    * This method outputs a string representation of the tree structure of the file system 
    * starting at the pathname specified in the constructor
    */
    public void listAllFiles(){          
        //call the helper method listAllFiles and pass the pathName and 0 indentation as its argument       
        System.out.println(  listAllFiles( pathName,"")  );
    }

    
    /*
    * @param folder: is the starting point that we want to traverse down
    * @param indentationlevel: is the indentation (i use one tab) which reflect the position
    *                          of the files within the files system hierarchy
    * @result: retrun the String with nice indentation formatted
    */
    private String listAllFiles(File folder, String indentationLevel) {
       
        File[] fileNames = folder.listFiles();
        
        //each time the recurse method call, add one more tab
        indentationLevel += "\t";
        
        //here is where first file of each loop, if it is a directory recurseively call listAllFiles method
        //else add to the String output
        for ( File file : fileNames ) {                 
            if ( file.isDirectory() ) {
                traversalString.append( indentationLevel + file.getName() + "\n");
                listAllFiles( file,indentationLevel  );                    
            }                
            else if( file.isFile() ){
                traversalString.append( indentationLevel + file.getName() + "\n");                    
            } 
        }
        
        return traversalString.toString();
    }
    
  
      
    /*
    * @param folder: is the starting point that we want to traverse down
    * @param fileName: a name of a file which we need to search if it is exist in files system
    * I used this for 2 purpose, one for toString() and one for findFiles()
    */
    private void traverseAllFile( File folder , String fileName ){
        File[] fileNames = folder.listFiles();
        
        for( File file : fileNames ){
            // if the file is directory keep go to the children recursively
            if( file.isDirectory() ){
                traverseAllFile( file, fileName );
            }
            
            // if the file is a file, check if is the file we are searching for
            // if yes, add to the list fileFound
            if( file.isFile()){
                if( file.getName().equals(fileName)){
                    fileFound.add(file);
                }
            }   
        }        
    }

    /*
    * @parm fileName: a String of file's name that need to search if it exists
    * @result: return a String of file's name if found, otherwise output the message that file not found
    */
    public String findFiles( String fileName ){
        StringBuilder result = new StringBuilder();

        //calling the traverseAllFile
        traverseAllFile(pathName, fileName);

        // if the list fileFound is empty which is no file was found
        if ( fileFound.isEmpty() ) {
            result.append("\"" + fileName + "\" is not found!");
        } else {
            //if the List fileFound has files in there, add it to StringBuilder object result;
            result.append("File \"" + fileName + "\" is found at:\n");
            for (File e : fileFound) {
                result.append(e + "\n");
            }
        }
        return result.toString();
    }

    // return the string of all folders and files it has traversed
    @Override
    public String toString(){
        return traversalString.toString();
    }   
    
    
}
  
    
