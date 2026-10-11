import javax.swing.*;   // Swing classes: JFrame, JMenu, JTextArea, JOptionPane...
import java.awt.*;      // BorderLayout and Color

/*
 * JotBox1.java - Stage 1: Java Swing
 *   box   = JFrame (the window)
 *   strip = JMenuBar (the bar across the top)
 *   g, h, k = JMenu ("File", "Edit", "Tools")
 *   u, v, w = JMenuItem ("New", "Open", "Save") -- File menu
 */
public class JotBox1 {

    public static void main(String[] args) {

        // ---- Frame ----
        JFrame box = new JFrame("JotBox");                         // create the window with a title
        box.setSize(420, 320);                                     // width, height in pixels
        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        // clicking X ends the program
        box.setLayout(new BorderLayout());                         // lets us place things NORTH, CENTER, etc.

        // ---- Text area (the notepad) ----
        JTextArea area = new JTextArea();                          // the place where the user types
        area.setBackground(Color.WHITE);                           // white page
        area.setLineWrap(true);                                    // long lines wrap to the next line
        area.setWrapStyleWord(true);                               // wrap between words, not in the middle of one
        JScrollPane sc = new JScrollPane(area);                    // adds scrollbars when text is too long
        box.add(sc, BorderLayout.CENTER);                          // the text area fills the middle of the window

        // ---- Menus ----
        JMenu g = new JMenu("File");
        JMenu h = new JMenu("Edit");
        JMenu k = new JMenu("Tools");

        // ---- File items ----
        JMenuItem u = new JMenuItem("New");
        JMenuItem v = new JMenuItem("Open");
        JMenuItem w = new JMenuItem("Save");

        // What each item does when clicked (ev -> ... is a lambda: "when clicked, do this")
        u.addActionListener(ev -> area.setText(""));                                // New: empty the text area
        v.addActionListener(ev -> JOptionPane.showMessageDialog(box, "Open file")); // Open: just a message for now
        w.addActionListener(ev -> JOptionPane.showMessageDialog(box, "File saved"));// Save: just a message for now

        // ---- Put the items inside the File menu ----
        g.add(u);
        g.add(v);
        g.add(w);

        // ---- Put the menus on the menu bar ----
        JMenuBar strip = new JMenuBar();
        strip.add(g);
        strip.add(h);
        strip.add(k);
        box.setJMenuBar(strip);                                    // attach the menu bar to the window

        // ---- Show the window ----
        box.setLocationRelativeTo(null);                           // centre it on the screen
        box.setVisible(true);                                      // windows are hidden until you do this
    }
}












