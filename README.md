# CCC Java Solutions
## IntelliJ Workflow
I'll share with you the best way (I have though of so far) for 
working through the CCC problems in IntelliJ.

CCC Java submission requirements:
- Uploaded `.java` files **must** be named `Main.java`.
- The contents of the file must **not** contain references to any `package`.

Based on the requirements, working within IntelliJ in a helpful and organized 
manner can be a a bit cumbersome.

### IntelliJ Steps
1. Create a new Java project.
2. Name it appropriately (`CCC-2017`)
3. Once loaded, right-click on the top-level project folder 
in the project `(Alt+1)` panel.
4. Click `New -> Module`.
5. Create a new Java module by pressing `next` and then naming the module. 
Give it an appropriate name like `Junior 1` or `J1 Problem Name`.
You will see that module appear in the project panel `(Alt + 1)`.
6. Expand the module's file tree in the project panel to reveal the 
new module's `src` directory.
7. Right click the `src` direcroty and click `New -> Java Class`.
8. Using the pop-up dialogue box, give it the name `Main`.
9. The new file will open. Type out our favourite mantra of `public static void main(String[] args) {...`
10. Get coding!

### Running in IntelliJ
When working in a file, you can run it several ways. Either right-click 
the **code window** or the **code window tab** and select `Run 'Main.main()'.
You can also look for a triangular "play" symbol in the margins near the code line numbers.

### Submiting to CCC Online Grader
From the contest page, under the `Submit Solution` section,
- select the problem from the dropdown list.
- select the language you are using
- click `choose file`
- navigate to the appropriate Main.java file and submit
Submitting successfully will bring you to a page that you will have to constantly
refresh to get an update on the tests that were run on your code.