<div id="video_wrapper">
  <video autoplay loop>
      <source src="https://drive.google.com/uc?export=view&id=1vEEQAHEQNWlZYUpMbfz9t8MYNVgxwoes" type="video/mp4">
  </video>
</div>

# Reviews of Week
This page contains learnings and key code snippets.  You should highlight things that were challenges or consumed time.

### Week 1
1. Describe Linked Lists
2. Describe Java Generic T
3. Queue Add and Delete
4. Merge 2 Queues
5. Build Stack and reverse Queue Order


### Week 0
#### [Review Ticket](https://github.com/nighthawkcoders/pages_java/issues/1)

* Menu built with Data Structure.  The great find was Runnable (courtesy of Chenxin), this greatly reduced implementation.  Here is the data structure with Lambda Runnable initialization.

```java
  // Row initialize
  MenuRow[] rows = new MenuRow[]{
          new MenuRow("Exit", () -> main(null)),
          new MenuRow("Swap", () -> IntByReference.main(null)),  // lambda style, () -> to point to Class.Method
          new MenuRow("Matrix", () -> Matrix.main(null)),
          new MenuRow("Number", () -> Number.main(null))
  };
```  

```java
// Runnable used in Class
class MenuRow {
    String title;       // menu item title
    Runnable action;    // menu item action, using Runnable

    /**
     *  Constructor for MenuRow,
     *
     * @param  title,  is the description of the menu item
     * @param  action, is the run-able action for the menu item
     */
    public MenuRow(String title, Runnable action) {
        this.title = title;
        this.action = action;
    }
```
* Menu using Try / Catch for success and errors.  Also, when all goes well it activates run from Runnable.

```java
// Menu construction
  Menu menu = new Menu(rows);

  // Run menu forever, exit condition contained in loop
  while (true) {
      System.out.println("Hacks Menu:");
      // print rows
      menu.print();

      // Scan for input
      try {
          Scanner sc = new Scanner(System.in);
          int selection = sc.nextInt();

          // menu action
          try {
              MenuRow row = menu.get(selection);
              // stop menu condition
              if (row.getTitle().equals("Exit"))
                  return;
              // run option
              row.run();
          } catch (Exception e) {
              System.out.printf("Invalid selection %d\n", selection);
          }
      } catch (Exception e) {
          System.out.println("Not a number");
      }
  }
```

* Swap Number in Objects.  No real challenges, Swap Low to High looks like this...

```java
public void swapToLowHighOrder(IntByReference i) {
        if (this.value > i.value) {
            int tmp = this.value;
            this.value = i.value;
            i.value = tmp;
        }
    }
```

* Print Matrix.  No real challenges, IntelliJ directed me to StringBuilder

```java
// nest for loops to format output of a matrix
    public String toString() {
        // construct output of matrix using for loops
        // outer loop for row
        StringBuilder output = new StringBuilder();
        for (int[] row : matrix) {
            // inner loop for column
            for (int cell : row) {
                output.append((cell==-1) ? " " : String.format("%x",cell)).append(" ");
            }
            output.append("\n"); // new line
        }
        return output.toString();
    }
```

* Deployed and built on replit.  Java package being incorrect caused Java not to find externally referenced classes.  The package name needs to match directory.  If this is correct the javac (compile) should work correctly.

```java
package src;
```

* Running on replit without Main.java at root.   To enable compatibility between replit and IntelliJ, it was necessary to try to build and run with a simple .replit run command.  First attempt was to create a base script (run.sh) assisted by Michael Zhang, later Raadwan shared using semi-colon delimited commands in .replit run environment variable.
 
```bash
language = "java"
run = "javac src/Menu.java; java src/Menu; rm src/*.class"
```
