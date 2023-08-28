# UserJavaFX
Project on the topic "Creating a graphical
application with a user interface in JavaFX"
Instructions for completing the task:
• All classes must comply with Code Conventions for the Java Programming Language and SOLID principles
Task:
1. Create a ComboBox control on the form
2. Download data from the resource https://jsonplaceholder.typicode.com/users in ComboBox, by creating a download repository from the server. Main class: User
3. If you have errors import'a Jackson classes after adding dependencies to the file pom.xml and its updates, then you need to press alt+enter on import and select the “add requires” option. InteliJIdea development environment add a dependency to your file module-info.java . A similar situation may occur with the declaration of an ObjectMapper object. Copy the import of this object from another project to your file and use the instructions above 
4. By clicking on the “Select” button, add the selected User object to the ListView, which is located below
5. After adding the selected object to the list, delete it from the ComboBox
6. Implement buttons that will allow you to delete the selected object from the ListView, as well as view information about the selected object by issuing it as an informational message
