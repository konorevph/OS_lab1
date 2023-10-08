import ProcessorSimulator.OperatingSystem;
import ProcessorSimulator.Process;

public class Main {
    public static void main(String[] args) {
        OperatingSystem operatingSystem = new OperatingSystem(3, 2);
//        operatingSystem.createProcess("2 (3) 5 (1) 3");
//        operatingSystem.createProcess("2 (3) 6 (3) 2");
//        operatingSystem.createProcess("2 (2) 4 (2) 2");
//        operatingSystem.createProcess("3 (3) 3 (1) 2");

        operatingSystem.createProcess("5 (1) 4 (3) 5 (1) 1");
        operatingSystem.createProcess("5 (1) 4 (3) 4 (1) 1");
        operatingSystem.createProcess("5 (2) 4 (2) 6 (1) 3");
        operatingSystem.createProcess("5 (2) 4 (2) 5 (3) 3");
        operatingSystem.createProcess("5 (3) 4 (1) 4 (2) 3");
        operatingSystem.createProcess("5 (3) 4 (1) 3 (2) 2");

        operatingSystem.ProcessesCalculation();
    }
}