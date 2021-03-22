public class Test implements Observer{
    private MeasuringStation m;
    private float latestValue;
    private boolean stop;

    public Test(){
        m = new MeasuringStation();
        latestValue = 0;
        m.registerObserver(this);
    }

    public void run(){
        m.runSensors();
    }

    public void displayValues() {
        System.out.println(latestValue);
    }

    @Override
    public void update() {
        latestValue = m.getTempValues().get(m.getTempValues().size()-1);
        displayValues();
    }


}