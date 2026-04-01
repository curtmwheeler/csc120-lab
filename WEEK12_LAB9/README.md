# CSC 120 - Week 12 Lab 9 Plan: Election Program

Goal:
Write a Java program that reads votes (names), counts how many times each name appears, and determines the winner.

---

1. Overall Structure

Main responsibilities:

* Ask user for input method (file or keyboard)
* Read votes
* Store and count votes
* Print results
* Determine and print winner

---

2. Data Structures

Use two parallel arrays:

String[] names   → stores unique candidate names
int[] counts     → stores corresponding vote counts

Index relationship:
names[i] corresponds to counts[i]

Both arrays start with length 0.

---

3. Main Method Flow

4. Create Scanner for keyboard input

5. Ask: "Use a file? (y/n)"

6. If yes:

   * Ask for filename
   * Create Scanner using file
   * Set useFile = true

7. If no:

   * Use keyboard Scanner
   * Print voting instructions

8. Initialize:
   names = empty String array
   counts = empty int array

9. Loop while input exists:

   * Read line (name)
   * If empty string → break
   * Call find(names, name)
   * If found:
     increment counts[index]
   * Else:
     names = addName(names, name)
     counts = addNewCount(counts)

10. After loop:

    * Call findWinner(names, counts)

11. If using file:

    * Close Scanner

---

4. Input Loop Details

Condition:
while (in.hasNext())

Inside loop:

* String name = in.nextLine()
* If name equals "" → break
* int index = find(names, name)

If index >= 0:
counts[index]++
Else:
names = addName(names, name)
counts = addNewCount(counts)

---

5. Required Methods

A. find(String[] names, String name)

Purpose:

* Search for name in names array
* Ignore case

Returns:

* Index if found
* -1 if not found

Logic:

* Loop from 0 to names.length - 1
* Use equalsIgnoreCase
* Return index if match
* Return -1 if no match

---

B. addName(String[] names, String name)

Purpose:

* Add new name to array

Logic:

* Create new array size +1
* Copy existing elements
* Add name at last index
* Return new array

---

C. addNewCount(int[] counts)

Purpose:

* Add new count (1) for new candidate

Logic:

* Create new array size +1
* Copy existing values
* Set last element = 1
* Return new array

---

6. findWinner(String[] names, int[] counts)

Steps:

1. Print vote totals:
   For each index i:
   print names[i] + " received " + counts[i] + " votes."

2. Determine winner:
   int maxCount = 0
   int winnerIndex = 0

   Loop through counts:
   If counts[i] > maxCount:
   maxCount = counts[i]
   winnerIndex = i

3. Print result:
   "--------"
   "The winner is " + names[winnerIndex] + "!"

---

7. Edge Cases

* Empty input → no output or handle gracefully
* Case-insensitive names (Harry vs harry)
* Blank line terminates input
* Ties → any winner is acceptable

---

8. Implementation Order

9. Write find()

10. Write addName()

11. Write addNewCount()

12. Hardcode small test in main (no input yet)

13. Implement input loop

14. Add file input handling

15. Write findWinner()

16. Test with sample inputs

---

9. Notes

* Arrays must be resized manually (no ArrayList)
* Always reassign arrays after adding:
  names = addName(...)
  counts = addNewCount(...)
* Be careful with array copying and indices
* Use equalsIgnoreCase for comparisons

---

End of Plan
