package ProcessorSimulator;

public class Output {

    private String name;
    private Process process;
    private OperatingSystem operatingSystem;
    private int QUANTITY_OPERATIONS, currentQuantityOperations;

    private OperationInfo operation;
    public Output( OperatingSystem operatingSystem, int QUANTITY_OPERATIONS , String name){
        this.name = name;
        this.operatingSystem = operatingSystem;
        this.QUANTITY_OPERATIONS = QUANTITY_OPERATIONS;
    }

    public void putProcess(Process process){
        this.process = process;
        operation = process.pollCurrentOperation();
        currentQuantityOperations = 0;
        operatingSystem.removeProcessFromWaitList(process);
    }

    public void ShowProcess(){
        if (process == null) return;
        if (currentQuantityOperations < QUANTITY_OPERATIONS - 1) {
            currentQuantityOperations += 1;
        }
        else  {
            if (!process.isEmpty()){
                operatingSystem.putProcessIntoReadyList(process);
            }
            else {
                operatingSystem.boostCountOfDoneProcesses();
            }
            cleanOutput();
        }
    }

    public String toString(){
        if (process == null) return "";
        return " " + name + "[" + process.getName() + "]" + " ";
    }

    public void cleanOutput(){
        process = null;
    }

    public boolean isLastOperation(){
        return currentQuantityOperations == QUANTITY_OPERATIONS;
    }

    public boolean isEmpty(){
        return process == null;
    }
}
