package com.mycompany.song;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class MainFrame extends JFrame{
    JPanel TopPanel;
    JPanel BottomPanel;
    private JLabel title;
    private JLabel artist;
    private JLabel release;
    private JLabel time;
    private JLabel type; 
    private JTextField TextTitle;
    private JTextField TextRelease;
    private JTextField TextTime;
    private JTextField TextSongCode;
    private JTextField TextArtist;
    private JRadioButton TypeRock;
    private JRadioButton TypeClassic;
    private JRadioButton TypeJazz;
    private JRadioButton TypeRap;
    private ButtonGroup TypeGroup;
    private JLabel Lrap;
    private JLabel Ljazz;
    private JLabel Lclassic;
    private JLabel Lrock;
    private JLabel SongCode;
    private JButton enter;
    private JButton exit;
    private JButton statistics;
    private JButton save;
    private JButton info;
    private JButton clear;
    private JTextArea ListOfSongsInputed;
    
    

    
    public MainFrame(){
        clear= new JButton("CLEAR");
        artist = new JLabel("Artist");
        TextArtist = new JTextField();
         
        TextSongCode = new JTextField();
        SongCode = new JLabel("Song Code ");
        ListOfSongsInputed = new JTextArea();
        BottomPanel = new JPanel();
        exit = new JButton("EXIT");
        statistics = new JButton("STATISTICS");
        save = new JButton("SAVE");
        info = new JButton("ABOUT");
        Lrock = new JLabel("Rock");
        Lrap = new JLabel("Rap");
        Ljazz = new JLabel("Jazz");
        Lclassic = new JLabel("\t  Classic");
        TextTitle = new JTextField();
        TextRelease = new JTextField();
        TextTime = new JTextField();
        TopPanel= new JPanel();
        title = new JLabel("Title");
        release = new JLabel("Release Date ");
        time = new JLabel("Time ");
        type = new JLabel("Type   ");
        TypeRock=new JRadioButton();
        TypeClassic=new JRadioButton();
        TypeRap=new JRadioButton();
        TypeJazz=new JRadioButton();
        TypeGroup = new ButtonGroup();
        TypeGroup.add(TypeRap);
        TypeGroup.add(TypeClassic);
        TypeGroup.add(TypeRock);
        TypeGroup.add(TypeJazz);
        
        
        
        enter = new JButton("ENTER");
        
      
      TextTitle.setColumns(15);
      TextRelease.setColumns(15);
      TextTime.setColumns(15);
      TextArtist.setColumns(15);
      TextSongCode.setColumns(7);
     TopPanel.setLayout(new FlowLayout());
     //TopPanel.setBackground(Color.lightGray);
     BottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
     BottomPanel.setBackground(Color.lightGray);
     this.setTitle("Song");
     this.setLayout(new BorderLayout());
     ListOfSongsInputed.setPreferredSize(new Dimension(1200,1000));
     
    
     TopPanel.add(title);
     TopPanel.add(TextTitle);
     TopPanel.add(artist);
     TopPanel.add(TextArtist);
     
     TopPanel.add(release);
     TopPanel.add(TextRelease);
     TopPanel.add(time);
     TopPanel.add(TextTime);
     TopPanel.add(type);
     TopPanel.add(Lclassic);
     TopPanel.add(TypeClassic);
     TopPanel.add(Ljazz);
     TopPanel.add(TypeJazz);
     TopPanel.add(Lrock);
     TopPanel.add(TypeRock);
     TopPanel.add(Lrap);
     TopPanel.add(TypeRap);
     TopPanel.add(enter);
     TopPanel.add(SongCode);
     TopPanel.add(TextSongCode);
    TopPanel.add(ListOfSongsInputed);
     ListOfSongsInputed.setEnabled(false);
    exit.setPreferredSize(new Dimension(100, 40));
    clear.setPreferredSize(new Dimension(100, 40));
    statistics.setPreferredSize(new Dimension(100, 40));
    save.setPreferredSize(new Dimension(100, 40));
    clear.setPreferredSize(new Dimension(100, 40));
    enter.setPreferredSize(new Dimension(100, 40));
    info.setPreferredSize(new Dimension(100, 40));
    TextSongCode.setEnabled(false);
     BottomPanel.add(clear);
     BottomPanel.add(info);
     BottomPanel.add(save);
     BottomPanel.add(statistics);
     BottomPanel.add(exit);
     
     this.add(BottomPanel,BorderLayout.SOUTH);
     
     this.add(TopPanel,BorderLayout.CENTER);
     //this.add(ListOfSongsInputed,BorderLayout.LINE_END);
    
     
      this.setSize(1300, 700);
       this.setLocationRelativeTo(null);
      this.setVisible(true);
      this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      
         clear.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){
                 TextRelease.setText("");
                 TextArtist.setText("");
                 TextTime.setText("");
                 TextTitle.setText("");
                 TextSongCode.setText("");
                 TypeGroup.clearSelection();
                 
             }
}
         );
         exit.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){
                 
                int i = JOptionPane.showConfirmDialog(MainFrame.this, "Do you want to exit the program?");
                if (i==JOptionPane.YES_OPTION)
                       System.exit(0);
                 
             }
}
         );
         this.addWindowListener(new WindowAdapter(){
             @Override
             public void windowClosing(WindowEvent e){
                 
                int i = JOptionPane.showConfirmDialog(MainFrame.this, "Do you want to exit the program?");
                if (i==JOptionPane.YES_OPTION)
                       System.exit(0);
                 
             }
}
         );
         
          enter.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){
                 String titl=TextTitle.getText();
                 String art = TextArtist.getText();
                 String code=titl + art.substring(0, 2);
                 TextSongCode.setText(code);
                 ListOfSongsInputed.append("Title Of Song: " + titl + "\t Artist Of Song: " + art +"\t Song Code: " + code );
                ListOfSongsInputed.append("\n");
                 
             }
}
         );
           info.addActionListener(new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent e) {
                new AboutWindow();
            }
        });
       
}
 
}
