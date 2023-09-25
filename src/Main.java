import ProcessorSimulator.OperatingSystem;
import ProcessorSimulator.Process;

public class Main {
    public static void main(String[] args) {
        OperatingSystem operatingSystem = new OperatingSystem(3, 2);
        operatingSystem.createProcess("2 (2) 5 (0) 3");
        operatingSystem.createProcess("2 (2) 6 (2) 2");
        operatingSystem.createProcess("2 (1) 4 (1) 1");
        operatingSystem.createProcess("3 (2) 3 (0) 2");
        operatingSystem.ProcessesCalculation();
    }
}