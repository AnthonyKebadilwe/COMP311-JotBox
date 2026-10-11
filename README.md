COMP 311 - JotBox Practice (40 marks)
All questions build on the JFrame notepad (frame, menu bar, File/Edit/Tools menus, New/Open/Save, white text area).
Use your own letters for the variables and keep the style of your labs (short comments, one idea per line).

=====================================================================
Q1 [10] JAVA SWING  (JotBox1.java)
=====================================================================
Build the window: a JFrame called "JotBox" with a BorderLayout, a JMenuBar holding File, Edit and Tools menus,
New / Open / Save items in the File menu, and a white JTextArea inside a JScrollPane in the centre.
New must clear the text area.

QUICK NOTES - 7 steps
Acronym: Frogs Taste Many Interesting Little Bugs Sometimes  =  F T M I L B S

  F  Frame      new JFrame("Title"), setSize, setDefaultCloseOperation(EXIT_ON_CLOSE), setLayout(new BorderLayout())
  T  Text area  new JTextArea(), put it in a JScrollPane, add to BorderLayout.CENTER
  M  Menus      new JMenu("File")
  I  Items      new JMenuItem("New"), then g.add(u) to put the item in the menu
  L  Listeners  u.addActionListener(ev -> ...)   "when clicked, do this"
  B  Bar        new JMenuBar(), strip.add(g), box.setJMenuBar(strip)
  S  Show       setLocationRelativeTo(null), setVisible(true)   <- forget this and no window appears

=====================================================================
Q2 [10] READING AND WRITING TO FILES  (JotBox2.java)
=====================================================================
Make Open read a chosen file into the text area using a BufferedReader, and Save write the text area to a file
using a PrintWriter. Show a friendly message if an IOException happens.

QUICK NOTES - 4 steps
Acronym: Choose, Open, Loop, Close  =  C O L C

  Reading:  JFileChooser -> new BufferedReader(new FileReader(file)) -> while ((line = in.readLine()) != null) -> in.close()
  Writing:  JFileChooser -> new PrintWriter(new FileWriter(file))    -> out.print(...)                          -> out.close()
  Both:     wrap in try { ... } catch (IOException e) { ... }

  Remember: Reading = Reader, Writing = Writer.  null means the file has ended.
  Cancel check: if (pick.showOpenDialog(box) != JFileChooser.APPROVE_OPTION) return;

=====================================================================
Q3 [10] STRINGTOKENIZER  (JotBox3.java)
=====================================================================
Add a Tools menu with Word Count (use countTokens()) and List Words (loop with hasMoreTokens()/nextToken()).

QUICK NOTES - 2 patterns
Acronym: Ask, then Take  =  hasMoreTokens() ASKS, nextToken() TAKES

  StringTokenizer st = new StringTokenizer(text);        // spaces by default; use (text, ",") for a comma
  st.countTokens()                                       // COUNT: how many pieces
  while (st.hasMoreTokens()) { st.nextToken(); }         // LOOP: ask, then take

  Import: java.util.StringTokenizer

=====================================================================
Q4 [10] ARRAYLIST  (JotBox4.java)
=====================================================================
Add: (a) Open reads the lines into an ArrayList<String> first, (b) Edit > Sort Lines sorts that ArrayList,
(c) Tools > Find Word uses a StringTokenizer and an ArrayList<Integer> to report every line containing a word,
(d) Tools > Recent Files keeps the last 5 file names in an ArrayList.

QUICK NOTES - 4 verbs
Acronym: Make, Add, Get, Loop  =  M A G L

  M  Make   ArrayList<String> list = new ArrayList<String>();
  A  Add    list.add("x");   list.add(0, "x") puts it at the front
  G  Get    list.get(0);  list.size();  list.remove(0);
  L  Loop   for (String s : list) { }

  Sort: Collections.sort(list)      Import: java.util.*
  An ArrayList grows by itself; an array has a fixed size.

=====================================================================
HOW TO PRACTISE
=====================================================================
1. Close the files and type JotBox1 from memory using F T M I L B S.
2. Add Open and Save using C O L C.
3. Add Word Count using Ask, then Take.
4. Add Recent Files using M A G L.
If you get stuck on a line, check that file and retype it. Do the whole thing two or three times.