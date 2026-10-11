import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;

/*
 * JotBox3.java - Stage 3: SWING + FILES + STRINGTOKENIZER
 *
 * QUICK NOTES - 2 patterns
 * Acronym: Ask, then Take  (hasMoreTokens() ASKS, nextToken() TAKES)
 *   StringTokenizer st = new StringTokenizer(text);     // spaces by default, (text, ",") for a comma
 *   st.countTokens()                                    // COUNT the pieces
 *   while (st.hasMoreTokens()) { st.nextToken(); }      // LOOP through the pieces
 *
 * Swing = F T M I L B S      Files = C O L C
 */
public class JotBox3 {

    private static JFrame box;
    private static JTextArea area;

    public static void main(String[] args) {

        // F - Frame
        box = new JFrame("JotBox");
        box.setSize(420, 320);
        box.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        box.setLayout(new BorderLayout());

        // T - Text area
        area = new JTextArea();
        area.setBackground(Color.WHITE);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        box.add(new JScrollPane(area), BorderLayout.CENTER);

        // M - Menus
        JMenu g = new JMenu("File");
        JMenu k = new JMenu("Tools");

        // I - Items
        JMenuItem u = new JMenuItem("New");
        JMenuItem v = new JMenuItem("Open");
        JMenuItem w = new JMenuItem("Save");
        JMenuItem y = new JMenuItem("Word Count");
        JMenuItem z = new JMenuItem("List Words");
        g.add(u);
        g.add(v);
        g.add(w);
        k.add(y);
        k.add(z);

        // L - Listeners
        u.addActionListener(ev -> area.setText(""));
        v.addActionListener(ev -> openFile());
        w.addActionListener(ev -> saveFile());

        y.addActionListener(ev -> { // COUNT
            StringTokenizer st = new StringTokenizer(area.getText());
            JOptionPane.showMessageDialog(box, "Words: " + st.countTokens());
        });

        z.addActionListener(ev -> {
    StringTokenizer st = new StringTokenizer(area.getText());
    String list = "";
    while (st.hasMoreTokens()) list += st.nextToken() + "\n"; // Ask, then Take
    JOptionPane.showMessageDialog(box, list);
});
          
          
        });

        // B - Bar
        JMenuBar strip = new JMenuBar();
        strip.add(g);
        strip.add(k);
        box.setJMenuBar(strip);

        // S - Show
        box.setLocationRelativeTo(null);
        box.setVisible(true);
    }

    private static void openFile() { // C O L C
        JFileChooser pick = new JFileChooser();
        if (pick.showOpenDialog(box) != JFileChooser.APPROVE_OPTION) return;
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(pick.getSelectedFile()));
            String line;
            while ((line = in.readLine()) != null) text.append(line).append("\n");
            in.close();
            area.setText(text.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(box, "Could not read file");
        }
    }

    private static void saveFile() { // C O L C
        JFileChooser pick = new JFileChooser();
        if (pick.showSaveDialog(box) != JFileChooser.APPROVE_OPTION) return;
        try {
            PrintWriter out = new PrintWriter(new FileWriter(pick.getSelectedFile()));
            out.print(area.getText());
            out.close();
            JOptionPane.showMessageDialog(box, "File saved");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(box, "Could not save file");
        }
    }
}