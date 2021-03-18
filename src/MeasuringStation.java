import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MeasuringStation {
    private Sensor temp;
    private ArrayList<Observer> observers;

    public MeasuringStation(){
        temp = new Sensor(this);
        observers = new ArrayList<Observer>();

    }

    public void runSensors() {
                TimerTask task = new TimerTask() {
                    Sensor t = temp;
                    @Override
                    public void run() {
                        t.measure();
                    }
                };

                Timer timer = new Timer();
                timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public void registerObserver(Observer o){
        observers.add(o);
    }

    public void newValues() {
        for(Observer o : observers){
            o.update();
        }
    }

    public Sensor getTemp(){
        return temp;
    }

}