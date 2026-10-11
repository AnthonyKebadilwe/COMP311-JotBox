# COMP 311 – Programming in Java: Checklist

BIUST – Department of Computing and Informatics

Tick each box (`- [x]`) as you finish it.

## 1. JotBox Notepad (Swing + ArrayList + Files + Tokenizer)

- [ ] `JotBox1.java` – Swing window: JFrame, JMenuBar, File / Edit / Tools menus, New / Open / Save, white JTextArea in a JScrollPane
- [ ] `JotBox2.java` – Open reads a file (`BufferedReader`), Save writes a file (`PrintWriter`), friendly message on `IOException`
- [ ] `JotBox3.java` – Tools menu: Word Count (`countTokens()`) and List Words (`hasMoreTokens()` / `nextToken()`)
- [ ] `JotBox4.java` – Final app: ArrayList of lines, Sort Lines, Find Word, Recent Files (last 5)
- [ ] Variable names changed from the original demo, app renamed to JotBox
- [ ] Compiles with no errors in VS Code
- [ ] Every menu item tested by clicking it

## 2. Topic Revision

### Java Swing
- [ ] JFrame: size, close operation, layout
- [ ] JMenuBar, JMenu, JMenuItem
- [ ] `addActionListener` with a lambda
- [ ] JTextArea, JScrollPane, JFileChooser, JOptionPane

### ArrayList
- [ ] `add`, `get`, `remove`, `size`
- [ ] Looping with a standard `for` loop and an enhanced `for` loop
- [ ] Sorting with `Collections.sort`

### Reading and Writing Files
- [ ] `File`, `Scanner`, `BufferedReader`, `FileReader`
- [ ] `PrintWriter`, `FileWriter`
- [ ] `try` / `catch` for `FileNotFoundException` and `IOException`
- [ ] Always close the file

### StringTokenizer
- [ ] Default delimiters (spaces)
- [ ] Custom delimiter (e.g. `","`)
- [ ] `countTokens()`, `hasMoreTokens()`, `nextToken()`
- [ ] Converting tokens with `Integer.parseInt` / `Double.parseDouble`

## 3. Labs

- [ ] Lab 4 Part 2 – Arrays
- [ ] Lab 5 – Classes and Objects (`Book`, `Student`, `Library`)
- [ ] Lab 6 – Java Methods
- [ ] Lab 7 – File IO
- [ ] Lab 8 – StringTokenizer, Math and Methods

## 4. Practice Pack (test-paper style)

- [ ] `Question1.java` – Palindromes with StringTokenizer
- [ ] `Question2.java` – `process(String path)` sums numbers from a file
- [ ] `Question3.java` – switch on the day
- [ ] `FootballTeam.java` – class, constructors, access levels, main
- [ ] `Question5.java` + `Employee.java` – ArrayList of employees
- [ ] `Question6.java` + `Meeting.java` – ArrayList of meetings, enhanced for loop
- [ ] `Question7.java` – searching an array
- [ ] `Question8.java` – read students from a file, write honours list
- [ ] `Question9.java` – save and load books
- [ ] `Question10.java` – Swing calculator

## 5. Test Revision

- [ ] Method overloading vs overriding
- [ ] `double` vs `float`
- [ ] Access specifiers: public, protected, default, private
- [ ] `break` vs `continue`
- [ ] Constructors and `this`
- [ ] Pass by value
- [ ] Arrays: disadvantages, fixed size, `Arrays.copyOf()`

## 6. Before Pushing to GitHub

- [ ] Each `.java` file is named exactly like its public class
- [ ] Sample data files included (`hello.txt`, `students.txt`)
- [ ] Short comments explain each section of the code
- [ ] No `.class` files committed
- [ ] README and this checklist added to the repository root
- [ ] Commit message written (e.g. `Add JotBox notepad stages 1-4`)
- [ ] Pushed and checked on github.com

## Upload Steps

```
git init
git add .
git commit -m "Add COMP 311 Java work"
git branch -M main
git remote add origin https://github.com/<your-username>/<repo-name>.git
git push -u origin main
```
