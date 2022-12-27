import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Clock implements Runnable{
    private JPanel Clock;
    private JLabel time_Display;
    private JLabel day_Display;
    private JLabel date_Display;
    String hours,day,date_;

    public Clock() {
        Thread t=new Thread(this);
        t.start();
    }

    public void run(){
        while (true){
            Calendar c=Calendar.getInstance();
            SimpleDateFormat simpleTimeFormat=new SimpleDateFormat("hh:mm:ss a");
            SimpleDateFormat simpleDayFormat=new SimpleDateFormat("EEEE");
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
            Date date=c.getTime();
            hours=simpleTimeFormat.format(date);
            time_Display.setText(hours);
            day=simpleDayFormat.format(date);
            day_Display.setText(day);
            date_=simpleDateFormat.format(date);
            date_Display.setText(date_);
            }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Clock");
        frame.setContentPane(new Clock().Clock);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
