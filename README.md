# File List Maker
This Java program, created by `VoidDeveloper_`, implements a file management system that allows users to manipulate lists and files interactively.

## Class Main
> ArrayList: usersList - to get hold of the current list <br> LoadedList - to load from a saved file

`Loaded boolean` to check if the current file is loaded or not

## main();

Users can input the corresponding letters to perform the desired operation. Input is case-insensitive and validated against the regular expression `[AaDdVvQqOoSsCc]`.

### Features

- **Add**: Add an item to the current list.
- **Delete**: Remove an item from the current list.
- **View**: View items from a loaded file.
- **Open**: Open and load a file into the list.
- **Save**: Save the current list to a file.
- **Clear**: Clear the current list.
- **Quit**: Exit the program.

### File Handling

The program utilizes the `JFileChooser` class to manage file operations. By default, the program sets the working directory to the current user directory.

### Dependencies

This program relies on standard Java libraries and does not require any external dependencies.

## saveCurrentList();

### Save Current List Functionality

The `saveCurrentList` method allows users to save the current list to a file. It checks if any changes have been made since the last save. If changes are detected, the user is prompted to confirm whether they want to save their changes. If confirmed, the user is further prompted to choose whether to create a new file or overwrite an existing one.

### Function Signature

```java
public static void saveCurrentList(boolean isSaved, Scanner pipe, JFileChooser chooser) throws IOException
```

### Parameters

`isSaved`: A boolean indicating whether the current list has been saved previously.

`pipe`: A Scanner object for input.

`chooser`: A JFileChooser object for file selection.

### Details

If the list has unsaved changes (`!isSaved`), the user is prompted to confirm 
whether they want to save the changes.
If the user chooses to save (`wantToSave` is true), they are further prompted to decide whether to create a new file (`wantToCreateANewFile`).
If the user opts to create a new file, the `createFile` method is called with the pipe and `wantToCreateANewFile` parameters.
If the user decides not to save changes, the `openAndLoadFileToList` method is called to load a file into the list.

## addToTheCurrentList();


#### `addToTheCurrentList`

This method allows users to add an item to the current list. It prompts the user for input and ensures that the input is not empty before adding it to the list.

```java
public static void addToTheCurrentList(Scanner pipe, String prompt)
```
### Parameters

`pipe`: A Scanner object for input.

`prompt`: A String containing the prompt message for the user.

`removeFromTheCurrentList`
This method enables users to remove an item from the current list. Similar to `addToTheCurrentList`, it prompts the user for input and ensures that the input is not empty before removing it from the list.

## removeFromTheCurrentList();

```java
public static void removeFromTheCurrentList(Scanner pipe, String prompt)
```
### Parameters

`pipe`: A Scanner object for input.

`prompt`: A String containing the prompt message for the user.

`openAndLoadFileToList`
This method allows users to open and load a file into the current list. It utilizes a `JFileChooser` object to let the user select a file. The contents of the selected file are then read and added to the list.

## openAndLoadFileToList();

```java
public static void openAndLoadFileToList(JFileChooser chooser)
```

### Parameters
`chooser`: A `JFileChooser` object for file selection.

## readFromLoadedFile();

#### `readFromLoadedFile`

This method reads and prints the contents of either the current list or the loaded list, depending on the boolean parameter `loaded`.

```java
public static void readFromLoadedFile(boolean loaded) throws IOException
```
## Parameters
`loaded`: A boolean indicating whether a file has been loaded into the list.

## clearList();
`clearList`
This method clears both the current list and the loaded list.

```java
public static void clearList()
```

## createFile();
This method creates a new file or overwrites an existing one with the contents of the current list.
```java
public static void createFile(Scanner pipe, boolean newFile)
```
### Parameters
`pipe`: A Scanner object for input.

`newFile`: A boolean indicating whether to create a new file.

## setNewFileName();

#### `setNewFileName`
This method prompts the user to enter a name for the new file.
```java
public static boolean setNewFileName(Scanner pipe)
```
## Parameters
`pipe`: A Scanner object for input.

## Folder Structure

The workspace contains two folders by default, where:
- `txt`: a txt file when users creates from the programs
- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies). 

### Dependencies
- `java.util.ArrayList`
- `java.util.Scanner`
- `java.io.*`
- `javax.swing.*`
- `java.nio.file.Path`
- `java.nio.file.Files`
- `java.nio.file.StandardOpenOption.CREATE`


# Creator
> ***VoidDeveloper_***

### Contact
> badhikari1211+githubcontacts@gmail.com