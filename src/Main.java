import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Files;
import static java.nio.file.StandardOpenOption.CREATE;


public class Main {
    
    private static ArrayList<String> usersList = new ArrayList<>();
    // final private static String divider = "===================================================";
    private static String currentFileName= "main.txt";
    private static String newFileName = "";
    private static ArrayList <String> LoadedList = new ArrayList<>();
    private static boolean loaded = false;
    private static boolean isSaved = false;
    
    
    
    public static void main(String[] args) throws IOException {
        String mainMenu = "| <A> - Add,  <D> - Delete,  <V> - View, <Q> - Quit, |\n| <O> - Open,  <S> - Save,  <C> - Clear |";
        String regExString = "[AaDdVvQqOoSsCc]";
        String userSelection;
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        
        // Files
        JFileChooser chooser = new JFileChooser();
        File workingDir = new File(System.getProperty("user.dir"));
        chooser.setCurrentDirectory(workingDir);
        
        do {
            System.out.println(mainMenu);
            userSelection = SafeInput.getRegExString(sc, "What would you like to do?\n", regExString);

            // If Statement
            if (userSelection.equalsIgnoreCase("q")){
                saveCurrentList(isSaved, sc, chooser);
                done = true;
                System.exit(0);
            }
            else if (userSelection.equalsIgnoreCase("a")){
                addToTheCurrentList(sc, "Enter the Value To Be Added:\n>> ");
                isSaved = false;
            }
            else if (userSelection.equalsIgnoreCase("d")){
                removeFromTheCurrentList(sc, "Enter the Value To Be Deleted:\n>> ");
                isSaved = false;
            }
            else if (userSelection.equalsIgnoreCase("v")){
                saveCurrentList(isSaved, sc, chooser);
                readFromLoadedFile(loaded);
            }
            else if (userSelection.equalsIgnoreCase("o")){
                openAndLoadFileToList(chooser);
                loaded = true;
            }
            else if (userSelection.equalsIgnoreCase("s")){
                if (usersList.isEmpty()){
                    System.out.println("No Item in the User's List");
                    System.out.println("\n<Cannot Be Saved>");
                    isSaved = false;
                }else {
                    saveCurrentList(isSaved, sc, chooser);
                    isSaved = true;
                }
            }
            else if (userSelection.equalsIgnoreCase("c")){
                clearList();
                isSaved = false;
            }


        }while(!done);

    }


    public static void saveCurrentList(boolean isSaved, Scanner pipe, JFileChooser chooser) throws IOException{
        boolean wantToSave = false;
        boolean wantToCreateANewFile = false;
        if (!isSaved){
            isSaved = false;
            wantToSave = SafeInput.getYNConfirm(pipe, "Would you like to save your changes?\n>> ");
            if (wantToSave){
                wantToCreateANewFile = SafeInput.getYNConfirm(pipe, "\n Would you like to create a new file?\n>> ");
                if(wantToCreateANewFile)
                    createFile(pipe, wantToCreateANewFile);
                else
                    createFile(pipe, wantToCreateANewFile);
            }
        }
    }
    
    public static void addToTheCurrentList(Scanner pipe, String prompt){
        String userInput = "";
        do{
            userInput = SafeInput.getNonZeroLenString(pipe, prompt);
        }while(userInput.isEmpty());
        usersList.add(userInput);
        LoadedList.add(userInput);
        
        System.out.println("<Added>\n");
    }

    public static void removeFromTheCurrentList(Scanner pipe, String promopt){
        String userInput = "";
        do{
            userInput = SafeInput.getNonZeroLenString(pipe, promopt);
        }while(userInput.isEmpty());
        usersList.remove(userInput);
        LoadedList.remove(userInput);
        System.out.println("<Removed>\n");
    }

    public static void openAndLoadFileToList (JFileChooser chooser){
        File selectedFile;
        String rec = "";
        
        try {
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                while (reader.ready()){
                    rec = reader.readLine();
                    LoadedList.add(rec);
                    usersList.add(rec);
                }


            }
        }catch(FileNotFoundException e){
            System.out.println("\n<File Not Found>");
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void readFromLoadedFile(boolean loaded) throws IOException{
        if (!loaded) {
            String rec = "";
            for (int i = 0; i < usersList.size(); i++){
                rec = usersList.get(i);
                System.out.println(rec);
            }
        }else {
            String rec = "";
            for (int i = 0; i < LoadedList.size(); i++){
                rec = LoadedList.get(i);
                System.out.println(rec);
            }
            loaded = false;
        }
        }


    public static void clearList(){
        usersList.clear();
        LoadedList.clear();
        System.out.println("<Cleared>\n");
    }


    public static void createFile(Scanner pipe, boolean newFile){
        try{
            if (newFile) {
                if (setNewFileName(pipe)) {
                    currentFileName = newFileName;
                    FileWriter myWriter = new FileWriter(currentFileName);
                    for (String word : usersList){
                        myWriter.write(word);
                        myWriter.write("\n");
                    }
    
                    myWriter.close();
                }
                System.out.println("<New File Created>\n");
            
            }else{
                FileWriter myWriter = new FileWriter(currentFileName);
                for (String word : usersList){
                    myWriter.write(word);
                    myWriter.write("\n");
                }
                myWriter.close();
    
            }
            System.out.println("<File Saved>\n");
        }catch (IOException e){
            System.out.println("<File Not Saved>\n");
            e.printStackTrace();
        }

    }

    public static boolean setNewFileName(Scanner pipe){
        String input;
        do {
            input = SafeInput.getNonZeroLenString(pipe, "What would you like to name your file?\n>> ");
        }while(input.isEmpty());
        newFileName = (input + ".txt");
        System.out.println("<File Saved>\n");
        return true;
    }


}
