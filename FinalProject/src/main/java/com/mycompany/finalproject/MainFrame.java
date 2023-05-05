package com.mycompany.finalproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
    //dilwsi metavlitwn
    private JLabel songNameLbl;
    private JLabel releaseDateLbl;
    private JLabel timeLbl;
    private JLabel artistLbl;
    private JLabel genreLbl;

    private JTextField songNameTf;
    private JTextField releaseDateTf;
    private JTextField timeTf;
    private JTextField artistTf;

    private JComboBox genreCb;
    private String genres[] = {"Pop", "Trap", "Metal", "Jazz"};

    private JButton insertBtn;
    private JButton saveBtn;
    private JButton statBtn;
    private JButton infoBtn;
    private JButton exitBtn;
    private JButton clearBtn;

    private JMenuBar mBar;
    private JMenu fileMenu;
    private JMenu infoMenu;

    private JMenuItem saveItm;
    private JMenuItem statItm;
    private JMenuItem infoItm;
    private JMenuItem exitItm;

    private JTextArea area;

    private ArrayList<Song> songList = new ArrayList();

    int idAssist;

    public MainFrame() {
        //initialization metavlitwn
        idAssist = 0;
        songNameLbl = new JLabel("Song Title\t");
        releaseDateLbl = new JLabel("Release Date\t");
        timeLbl = new JLabel("Run Time\t");
        artistLbl = new JLabel("Artist Name\t");
        genreLbl = new JLabel("Genre\t");
        songNameTf = new JTextField(10);
        releaseDateTf = new JTextField(10);
        timeTf = new JTextField(10);
        artistTf = new JTextField(10);

        genreCb = new JComboBox(genres);

        insertBtn = new JButton("Insert");
        saveBtn = new JButton("Save to file");
        statBtn = new JButton("Statistics");
        infoBtn = new JButton("Information");
        exitBtn = new JButton("Exit");
        clearBtn = new JButton("Clear");

        mBar = new JMenuBar();
        fileMenu = new JMenu("File");
        infoMenu = new JMenu("Info");

        saveItm = new JMenuItem("Save to file");
        exitItm = new JMenuItem("Exit");
        infoItm = new JMenuItem("Information");
        statItm = new JMenuItem("Statistics");
        
        //dimiourgia tou area
        area = new JTextArea();
        area.setForeground(Color.black);
        area.setEnabled(false);
        Font font = new Font("Consolas", Font.BOLD, 14);
        area.setFont(font);
        
        //dimiourgia twn panels
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //prosthetoume ta components sta panel
        topPanel.add(songNameLbl);
        topPanel.add(songNameTf);
        topPanel.add(releaseDateLbl);
        topPanel.add(releaseDateTf);
        topPanel.add(timeLbl);
        topPanel.add(timeTf);
        topPanel.add(artistLbl);
        topPanel.add(artistTf);
        topPanel.add(genreLbl);
        topPanel.add(genreCb);
        topPanel.add(insertBtn);
        topPanel.add(clearBtn);

        bottomPanel.add(saveBtn);
        bottomPanel.add(statBtn);
        bottomPanel.add(infoBtn);
        bottomPanel.add(exitBtn);
        
        //prosthetoume sto menu ta items
        fileMenu.add(saveItm);
        fileMenu.add(statItm);
        fileMenu.addSeparator();
        fileMenu.add(exitItm);
        infoMenu.add(infoItm);
        
        //kanoume setup to menu
        mBar.add(fileMenu);
        mBar.add(infoMenu);
        
        //prosthetoume sto frame to menu kai ta panels
        this.setJMenuBar(mBar);
        
        
        this.add(topPanel, BorderLayout.PAGE_START);
        this.add(bottomPanel, BorderLayout.PAGE_END);
        this.add(area, BorderLayout.CENTER);
        
        //energopoioume to frame
        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("SONGS");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        loadFromFile();
        this.setVisible(true);

        //prosthiki action kai window listener
        
        //window listener gia to koumpi X
        this.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                try {
                    exitApp();
                } catch (IOException ex) {

                }
            }
        });
        
        //action listener gia to koumpi exit sto panel
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    exitApp();
                } catch (IOException ex) {
                }
            }
        });
        
        //action listener gia to koumpi clear
        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        
        //action listener gia to koumpi insert
        insertBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertText();
            }
        });
        
        //action listener gia to koumpi information
        infoBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // dimiourgoume neo frame apo tin class InfoFrame
                    new InfoFrame();
                } catch (IOException ex) {
                    System.err.println("Error");
                }
            }
        });
        
        //action listener gia to koumpi save to file
        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    saveToFile();
                } catch (IOException ex) {
                    System.err.println("Error");
                }
            }
        });
        
        //action listener gia to koumpi statistics
        statBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statFrame();
            }
        });

        //action listener gia to koumpi save sto menu
        saveItm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    saveToFile();
                } catch (IOException ex) {
                    System.err.println("Error");
                }
            }
        });
        
        //action listener gia to koumpi information sto menu
        infoItm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new InfoFrame();
                } catch (IOException ex) {
                    System.err.println("Error");
                }
            }
        });
        
        //action listener gia to koumpi exit sto menu
        exitItm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    exitApp();
                } catch (IOException ex) {
                }
            }
        });
        
        //action listener gia to koumpi statistics sto menu
        statItm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statFrame();
            }
        });

    }
    int fileLineCounter = 0;

    private void exitApp() throws IOException {
        Scanner sc = new Scanner(new FileInputStream("test.txt"));
        //metrame tis grammes diladi ta tragoudia sto file
        while (sc.hasNextLine()) {
            sc.nextLine();
            fileLineCounter++;
        }
        sc.close();
        // sigkrinoume ta tragoudia sto file me tis eggrafes sto arraylist
        // ta tragoudia sto file tha einai panta isa i mikrotera apo tis eggrafes sto arraylist
        if (fileLineCounter != songList.size()) {
            //den exei ginei apothikeusi olwn twn tragoudiwn
            int i = JOptionPane.showConfirmDialog(MainFrame.this, "Do you want to save the new songs?");
            if (i == JOptionPane.YES_OPTION) {
                saveToFile();
                System.exit(0);
                // patise no diladi den thelei na apothikeusei 
            } else if(i == JOptionPane.NO_OPTION){
                System.exit(0);
            }
            // exei patisei idi save
        } else {
            System.exit(0);
        }
    }

    private void clearFields() {
        // katharizei ola ta pedia
        songNameTf.setText("");
        releaseDateTf.setText("");
        timeTf.setText("");
        artistTf.setText("");
    }

    private void insertText() {
        
        //pernoume oti exei sta text field kai ta apothikeoume se strings
        String songName = songNameTf.getText().toLowerCase().trim();
        String artistName = artistTf.getText().toLowerCase().trim();
        String date = releaseDateTf.getText().toLowerCase().trim();
        String time = timeTf.getText().toLowerCase().trim();

        boolean shouldAppend1 = true, shouldAppend2;
        // elegxoume an ola ta pedia einai simplirwmena
        if ((songName != null && !songName.isEmpty())
                && (artistName != null && !artistName.isEmpty())
                && (date != null && !date.isEmpty())
                && (time != null && !time.isEmpty())) {
            //exei simplirwsei ola ta pedia
            //loop gia olo to arraylist
            for (Song song : songList) {
                //elegxos gia diplotipa
                if (song.getArtistName().contains(artistName)
                        && song.getSongName().contains(songName)
                        && song.getReleaseDate().contains(date)) {
                    //exei diplwtita
                    shouldAppend1 = false;
                    JOptionPane.showMessageDialog(
                            MainFrame.this,
                            "Duplicate Song",
                            "Duplicate Error",
                            JOptionPane.WARNING_MESSAGE);
                    clearFields();

                }
            }
            if (shouldAppend1) {
                try {
                    //elegxos ama exei swsto release date
                    if (date.length() == 4) {
                        //exei swsto release date
                        shouldAppend1 = true;
                    } else {
                        // den exei swsto release date
                        JOptionPane.showMessageDialog(
                                MainFrame.this,
                                "Please put correct date(4 digits)",
                                "Release Date error",
                                JOptionPane.WARNING_MESSAGE);
                        releaseDateTf.setText("");
                        date = "";
                        shouldAppend1 = false;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(
                            MainFrame.this,
                            "Please put correct date(4 digits)",
                            "Release Date error",
                            JOptionPane.WARNING_MESSAGE);
                    releaseDateTf.setText("");
                    date = "";
                    shouldAppend1 = false;
                }
                 //elegxos gia swsto time 
                try {
                    Double.parseDouble(time);
                    shouldAppend2 = true;
                    
                } catch (NumberFormatException ex) {
                    // lathos morfi time
                    JOptionPane.showMessageDialog(
                            MainFrame.this,
                            "Only Integer or Float Value Allowed with dot",
                            "Run time error",
                            JOptionPane.WARNING_MESSAGE);
                    timeTf.setText("");
                    time = "";
                    shouldAppend2 = false;
                }
                // ama to date kai to time einai swsta kai exei simplirwsei ola ta pedia
                if (shouldAppend1 && shouldAppend2) {
                    //vgazoume kodiko tragoudiou
                    String codeId = songName.substring(0, 2)
                            + artistName.substring(0, Math.min(4, artistName.length()));
                    for (Song song : songList) {
                        //oso iparxei idi afto to id
                        while (song.getSongId().contains(codeId)) {
                            codeId = codeId.concat(String.valueOf(idAssist));
                            idAssist++;
                        }
                    }
                    //kanw append sto text area apo to array list
                    Song song = new Song(codeId, songName, artistName, date, time, genreCb.getSelectedItem().toString());
                    songList.add(song);
                    area.append(song.toString());
                    area.append("\n");
                    clearFields();
                }
            }
            //den exei simplirwsei ola ta fields
        } else {
            JOptionPane.showMessageDialog(
                    MainFrame.this,
                    "Please Fill Every Field",
                    "Empty Field warning",
                    JOptionPane.WARNING_MESSAGE);

        }
    }

    private void saveToFile() throws IOException {
        // ama einai adeio to array list bgazei warning
        if (songList.isEmpty()) {
            JOptionPane.showMessageDialog(
                    MainFrame.this,
                    "Nothing to save",
                    "Save warning",
                    JOptionPane.WARNING_MESSAGE);
            
        }
        //iparxei kati sto array list
        else {
            FileWriter fw = new FileWriter("test.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Song song : songList) {
                //metatrepoume kathe song se string kai to apothikevoume sto file
                bw.write(song.toString());
                bw.newLine();
            }
            bw.close();
        }
    }

    private void statFrame() {
        //koumpi gia exit
        JButton exitstBtn = new JButton("Exit Statistics");
        //dimiourgei neo frame 
        JFrame frame = new JFrame();
        // //dimiourgei neo text area
        JTextArea statArea = new JTextArea();
        //dilwsi kai initialization twn metavlitwn
        String mostGenre = " ";
        String minTime = " ";
        String maxTime = " ";
        float min = 999;
        float max = 0;
        int rapC = 0;
        int jazzC = 0;
        int trapC = 0;
        int metalC = 0;
        int maxGenre = 0;
        //loop se olo to array list
        for (Song song : songList) {
            // elegxos gia most genre
            if (song.getGenre().matches("Pop")) {
                rapC++;
                if (rapC > maxGenre) {
                    maxGenre = rapC;
                    mostGenre = "Type: Pop Has The Most Songs With " + maxGenre + " Songs";
                }
            } else if (song.getGenre().matches("Trap")) {
                trapC++;
                if (trapC > maxGenre) {
                    maxGenre = trapC;
                    mostGenre = "Type: Trap Has The Most Songs With " + maxGenre + " Songs";
                }
            } else if (song.getGenre().matches("Jazz")) {
                jazzC++;
                if (jazzC > maxGenre) {
                    maxGenre = jazzC;
                    mostGenre = "Type: Jazz Has The Most Songs With " + maxGenre + " Songs";
                }

            } else if (song.getGenre().matches("Metal")) {
                metalC++;
                if (metalC > maxGenre) {
                    maxGenre = metalC;
                    mostGenre = "Type: Metal Has The Most Songs With " + maxGenre + " Songs";
                }
            }
            //den iparxei tragoudi 
            if (maxGenre == 0) {
                mostGenre = "No song Added";
            }
            // elegxos gia mikroteri diarkeia tragoudiou
            if (Float.parseFloat(song.getDuration()) <= min) {
                minTime = song.getSongName().concat(" with duration ").concat(song.getDuration());
                min = Float.parseFloat(song.getDuration());
            }
            // elegxos gia megaliteri diarkeia tragoudiou
            if (Float.parseFloat(song.getDuration()) >= max) {
                maxTime = song.getSongName().concat(" with duration ").concat(song.getDuration());
                max = Float.parseFloat(song.getDuration());
            }
        }
        //apothikevoume se string ola ta apotelesmata
        String info = "Statistics:\n"
                + "Number of songs saved: " + songList.size() + "\n"
                + mostGenre + "\n"
                + "Shortest Song: " + minTime + "min\n"
                + "Longest Song: " + maxTime + "min\n";
        //dimiourgia text area
        statArea = new JTextArea();
        statArea.setLineWrap(true);
        statArea.setForeground(Color.BLACK);
        Font font = new Font("Consolas", Font.BOLD, 16);
        statArea.setFont(font);
        //kanoume append to string me ta statistika
        statArea.append(info);
        //den mporei na grapsei o xristis kati sto area
        statArea.setEnabled(false);
        //prosthetoume to koumpi exit sto frame
        frame.add(exitstBtn, BorderLayout.PAGE_END);
        // ama patisei exit krivoume to frame
        exitstBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        //energopoioume to StatFrame
        frame.add(statArea);
        frame.setAlwaysOnTop(true);
        frame.setSize(600, 300);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.add(statArea, BorderLayout.CENTER);
        frame.setTitle("Statistics");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void loadFromFile() {
        try {
            // diavazoume apo file
            BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
            //adeiazei to array list
            songList.clear();
            // dilwnoume metavlites
            String line = "";
            String[] fields;
            Song song;
            //oso to buffer den einai adeio 
            while (reader.ready()) {
                //diavazei mia grammi
                line = reader.readLine();
                //kathe tab einai endiksi epomenis idiotitas
                fields = line.split("\t");
                if (fields.length == 6) {
                    //apothikeuoume sto arraylist to tragoudi
                    song = new Song(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]);
                    songList.add(song);
                }
            }
            //ama den einai adeio to array list kanoume append sto text area oti exei mesa
            if (!songList.isEmpty()) {
                area.setText("");
                for (Song songs : songList) {
                    area.append(songs.toString());
                    area.append("\n");
                }
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(saveBtn,
                    "Can't access " + "test.txt",
                    "File not found error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(saveBtn,
                    "Can't write to " + "test.txt",
                    "File I/O error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}

