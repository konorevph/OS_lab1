package ProcessorSimulator;

public class Processor {
    private Process process;
    private OperatingSystem operatingSystem;
    private OperationInfo operation;

    public String toString(){
        if(process == null) return "Процессор пуст";
        return process.getName();
    }

    public Processor(OperatingSystem operatingSystem){
        this.operatingSystem = operatingSystem;
    }

    public void putProcess(Process process){
        this.process = process;
        operation = process.pollCurrentOperation();
    }

    public boolean isEmpty(){
        return process == null;
    }

    public void calculation() {
        if (operation.getValue() > 0) {
            operation.setValue(operation.getValue() - 1);
        }
        else {
            if (!process.isEmpty()){
                operatingSystem.putProcessIntoWaitList(process);
            }
            else {
                operatingSystem.boostCountOfDoneProcesses();
            }
            cleanProcessor();
        }
    }

    public void cleanProcessor(){
        process = null;
    }
}
