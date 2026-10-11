import javax.swing.*;
import java.awt.*;
import java.io.*;

/*
 * JotBox2.java - Stage 2: SWING + READING AND WRITING FILES
 *
 * QUICK NOTES - 4 steps
 * Acronym: Choose, Open, Loop, Close = C O L C
 *   Reading: JFileChooser -> BufferedReader(FileReader) -> while ((line = in.readLine()) != null) -> in.close()
 *   Writing: JFileChooser -> PrintWriter(FileWriter)    -> out.print(...)                          -> out.close()
 *   Both inside try { } catch (IOException e) { }
 *   Reading = Reader, Writing = Writer. null means the file has ended.
 *
 * Swing set-up is the same F T M I L B S as JotBox1.
 */
public class JotBox2 {

    private static JFrame box;     // static so openFile() and saveFile() can use them
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

        // M - Menus   I - Items
        JMenu g = new JMenu("File");
        JMenuItem u = new JMenuItem("New");
        JMenuItem v = new JMenuItem("Open");
        JMenuItem w = new JMenuItem("Save");
        g.add(u);
        g.add(v);
        g.add(w);

        // L - Listeners (Open and Save call the methods below)
        u.addActionListener(ev -> area.setText(""));
        v.addActionListener(ev -> openFile());
        w.addActionListener(ev -> saveFile());

        // B - Bar
        JMenuBar strip = new JMenuBar();
        strip.add(g);
        box.setJMenuBar(strip);

        // S - Show
        box.setLocationRelativeTo(null);
        box.setVisible(true);
    }

    // READING: C O L C
    private static void openFile() {
        JFileChooser pick = new JFileChooser();                                // C - Choose
        if (pick.showOpenDialog(box) != JFileChooser.APPROVE_OPTION) return;   // Cancel pressed

        StringBuilder text = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(pick.getSelectedFile())); // O - Open
            String line;
            while ((line = in.readLine()) != null) text.append(line).append("\n");          // L - Loop
            in.close();                                                                     // C - Close
            area.setText(text.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(box, "Could not read file");
        }
    }

    // WRITING: C O L C (no loop needed, print the whole text at once)
    private static void saveFile() {
        JFileChooser pick = new JFileChooser();                                // C - Choose
        if (pick.showSaveDialog(box) != JFileChooser.APPROVE_OPTION) return;

        try {
            PrintWriter out = new PrintWriter(new FileWriter(pick.getSelectedFile()));      // O - Open
            out.print(area.getText());                                                      // write
            out.close();                                                                    // C - Close
            JOptionPane.showMessageDialog(box, "File saved");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(box, "Could not save file");
        }
    }
}