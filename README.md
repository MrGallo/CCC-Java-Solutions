# CCC Java Solutions

## General Knowledge Requirements
To be successful in this competition, you need to acquire some programming skills that may extend further than the standard curriculum. The CCC Problems are quite the challenge. You will need to practice often. Although smaller in scope, the problems on [Codingbat.com](http://codingbat.com/java) can be a great preperation for the type of problems you will encounter.
Required learning:
- Every question will have you take String input and parse it to an integer.
  - You will get strings like "1 3 5 3 5" and will need to turn it into an integer array.
  - Learn:
    - `Integer.parseInt()`
    - `String.split()`
- Working with more advanced Objects:
  - Maps (Codingbat [Map-1](http://codingbat.com/java/Map-1), [Map-2](http://codingbat.com/java/Map-2)), Lists, ArrayLists
- Learn to use streams. [Codingbat Functional-1](http://codingbat.com/java/Functional-1), [COdingbat Functional-2](http://codingbat.com/java/Functional-2)
  - lambdas, `Array.stream()`, `.map()`, `.filter()`, `.collect()` (Advanced)

## IntelliJ Workflow
I'll share with you the best way (I have though of so far) for 
working through the CCC problems in IntelliJ.

CCC Java submission requirements:
- Uploaded `.java` files **must** be named `Main.java`.
- The contents of the file must **not** contain references to any `package`.
- There must be **no** output in the program aside from the solution itself.
  - This means you cannot 'prompt' for user input.

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

**Blank Output Window**

Because you cannot 'prompt' for input with a message like `Please enter an integer: `,
when you run your program, it won't be obvious that it is waithing for you to test it.
Just click in the output window and enter your test cases.


### Submiting to CCC Online Grader
From the contest page, under the `Submit Solution` section,
- select the problem from the dropdown list.
- select the language you are using
- click `choose file`
- navigate to the appropriate Main.java file and submit
Submitting successfully will bring you to a page that you will have to constantly
refresh to get an update on the tests that were run on your code.
