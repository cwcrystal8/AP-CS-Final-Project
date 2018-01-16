# AP-CS-Final-Project

## Instructions
How to run:
1. Download the BeCrystaled directory.
2. In a bash shell, run
~~~~
$ javac StartPage.java
~~~~
3. Then run
~~~~
$ java StartPage
~~~~

How to play:
1. Press start to start a game.
2. Select a candy.
3. Select another candy in a cell directly next to the originally selected candy to swap (Note that the swap must create a valid combination of at least 3 of the same candies in a row). Combinations of 4 in a row, 5 in a row, or an L or T shape will result in Special Candies, which can be combined with any two consecutive Regular candies of the same type. When combined, each one will be activated to reveal a special power. 
 * Four in a row (vertical): Clears an entire column
 * Four in a row (horizontal): Clears an entire row
 * Five in a row (horizontal or vertical): Clears a row and a column
 * L or T shape: Clears the surrounding 3 by 3 square
4. Continue until the 50 moves have been exhausted.
5. If you run out of possible combinations, press restart, and your game will end.
6. Try to obtain a high score! :)

## Development Log
## 01/15
Completed:
 * Finished basics of Window.java for the GUI
 * Incorporated ability to support SpecialCandy combinations
~~~~~~~
~~~~~~~
In Progress:
 * Easier additional features (e.g. start menu, programmed delay, high score board, etc.)
~~~~~~~
~~~~~~~
Pending:
 * Harder additional features (e.g. animations)
~~~~~~~
~~~~~~~
Notes:
We were finally able to incorporate the SpecialCandy classes into the GUI to make it compatible, and we worked out how to successfully move down the board, update the score, and update the GUI to reflect the changes in the board. We encountered a major obstacle when we found that the updates in the GUI would revert back to the original board after a mouse hovered over the button, but then we implemented MouseListener to override that effect. By the next week, we should have a start menu completed, as well as a high score board. Ideally, the GUI would update after every combination to show each change in the board, but right now the calls to repaint() are getting grouped together so that the GUI only updates at the end of every move. Hopefully we'll be able to resolve this issue. 

## 01/13
Completed:
 * Reformatted GUI to include score, and restart button within a system of nested Layouts
 * Wrote several methods to detect and find existing combinations on the board
 * Researching ActionListener interface
~~~~~~~
~~~~~~~
In Progress:
 * Finishing Window.java for the GUI
~~~~~~~
~~~~~~~
Pending:
 * Potential additional features (e.g. animations)
~~~~~~~
~~~~~~~
Notes:
We had to research how to nest Layouts and set margins in order to balance the grid, the score, and the restart button in one GUI, and ended up learning a lot of new syntax, most of which we didn't use (like rigid areas, glue, etc.).

## 01/10
Completed:
 * Finished writing and testing all Candy subclasses
 * Finished researching importing images in GUI
 * Incorporated images into GUI
 * Added a restart button, and a label to show the score
~~~~~~~
~~~~~~~
In Progress:
 * Writing Window.java for the GUI
 * Researching ActionListener interface
~~~~~~~
~~~~~~~
Pending:
 * Potential additional features (e.g. animations)
~~~~~~~
~~~~~~~
Notes:
We got our GUI to work, and completed all 7 classes in the Candy hierarchy! Everything we've written so far has been tested, and we have a basic outline of our actionPerformed(ActionEvent e) method already prepared, to make finishing the GUI that much easier. We also learned about the wonders of "git pull --rebase" after our branches failed to merge successfully.


## 01/07
Completed:
  * Tested branch creation, commits, and merging
  * Tested if each username was shown after a commit
  * Created separate branch for the GUI, started basic outline
  * Finished project prototype
  * Researched GUI tables
  * Wrote Candy, RegularCandy, and SpecialCandy class
  * Tested Candy and RegularCandy
~~~~~~~
~~~~~~~
In Progress:
 * Writing Window.java for the GUI
 * Researching ActionListener interface
 * Testing SpecialCandy class
~~~~~~~
~~~~~~~
Pending:
 * Writing SpecialCandy subclasses
 * Potential additional features
~~~~~~~
~~~~~~~
Notes:
We are in the process of making a GUI interface, and will finish the Candy class within the next few days.

### 12/14
Completed:
  * Project Outline (.txt file)
  * GitHub repository creation and collaborator confirmation
  * Project Proposal
~~~~~~~
~~~~~~~
In Progress:
  * Writing class outlines (.java file)
  * Researching GUI capabilities
~~~~~~~
~~~~~~~
Pending:
  * Creating GUI (must finish within two days)
    * Must learn how to import pictures
  * Writing and testing Window Class
  * Writing and testing Candy Class (and all subclasses)
  * Potential additional features
~~~~~~~
~~~~~~~
Notes:
We have written our project proposal, created the repository on GitHub, and outlined what our project should look like (how it would behave, etc.). Within the next week, our goal is to research GUI, and write a class outline for all the classes (data fields, method signatures, etc.).
