import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryGUI {
    private Library library;
    private JFrame frame;
    private JTextArea outputArea;
    private JTextField inputField;

    public LibraryGUI() {
        library = new Library();
        frame = new JFrame("Library Management System");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Input field and buttons
        inputField = new JTextField(20);
        JButton loadButton = new JButton("Load Books from File");
        JButton displayButton = new JButton("Display Books");
        JButton removeByBarcodeButton = new JButton("Remove by Barcode");
        JButton removeByTitleButton = new JButton("Remove by Title");
        JButton checkOutButton = new JButton("Check Out Book");
        JButton checkInButton = new JButton("Check In Book");
        JButton exitButton = new JButton("Exit");

        outputArea = new JTextArea(20, 50);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add components to frame
        frame.add(new JLabel("Enter file path or input:"));
        frame.add(inputField);
        frame.add(loadButton);
        frame.add(displayButton);
        frame.add(removeByBarcodeButton);
        frame.add(removeByTitleButton);
        frame.add(checkOutButton);
        frame.add(checkInButton);
        frame.add(exitButton);
        frame.add(scrollPane);

        // Add button action listeners
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = inputField.getText();
                try {
                    library.addBooksFromFile(filePath);
                    outputArea.append("Books loaded successfully from file.\n");
                } catch (Exception ex) {
                    outputArea.append("Error: File not found.\n");
                }
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.append("Displaying all books:\n");
                outputArea.append(library.displayBooks() + "\n");
            }
        });

        removeByBarcodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String barcode = inputField.getText();
                if (library.removeBookByBarcode(barcode)) {
                    outputArea.append("Book with barcode " + barcode + " removed successfully.\n");
                } else {
                    outputArea.append("Error: Book with barcode " + barcode + " not found.\n");
                }
            }
        });

        removeByTitleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = inputField.getText();
                if (library.removeBookByTitle(title)) {
                    outputArea.append("Book with title '" + title + "' removed successfully.\n");
                } else {
                    outputArea.append("Error: Book with title '" + title + "' not found.\n");
                }
            }
        });

        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = inputField.getText();
                if (library.checkOutBook(title)) {
                    outputArea.append("Book with title '" + title + "' checked out successfully.\n");
                } else {
                    outputArea.append("Error: Book with title '" + title + "' is either not found or already checked out.\n");
                }
            }
        });

        checkInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = inputField.getText();
                if (library.checkInBook(title)) {
                    outputArea.append("Book with title '" + title + "' checked in successfully.\n");
                } else {
                    outputArea.append("Error: Book with title '" + title + "' is either not found or already checked in.\n");
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LibraryGUI();
    }
}
