package Front__end;

import Back__end.GroupDatabase;
import Back__end.User;
import Back__end.UserRepository;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public abstract class SearchParentGUI<T> extends javax.swing.JFrame {
    protected ArrayList<T> results; // Can hold either User or Group objects
    protected JPanel resultsPanel;
    protected JScrollPane scrollPane;
    protected User currentUser;

    public SearchParentGUI(User currentUser,String title, ArrayList<T> results) {
        this.results = results;
        this.currentUser=currentUser;
        initComponents(title);
    }

    private void initComponents(String title) {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(title);

        JLabel titleLabel = new JLabel(title + " Results: ", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));

        resultsPanel = new JPanel();
        resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.Y_AXIS));
        populateResults();

        scrollPane = new JScrollPane(resultsPanel);
        scrollPane.setPreferredSize(new Dimension(600, 400));

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(titleLabel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setSize(800, 600);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                UserRepository.saveData();
                GroupDatabase.saveGroupsToJson();
                UserRepository.loadUsersFromJson();
                GroupDatabase.loadGroupsFromJson();
                dispose();
            }
        });
        setVisible(true);
    }

    protected abstract JPanel createPanel(T result); // for User/Group specific logic

    protected abstract void populateResults(); // Populate User or Group-specific results

    protected void refreshUI() {
        resultsPanel.removeAll();
        populateResults();
        resultsPanel.revalidate();
        resultsPanel.repaint();
    }
}
