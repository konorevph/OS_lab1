package ProcessorSimulator;

public class Processor {
    private Process process;
    private OperatingSystem operatingSystem;
    private OperationInfo operation;

    public String toString(){
        if(process == null) return "Процессор пуст ";
        return process.getName() + '(' + operation.getValue() + ')' +" ";
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

    public OperationInfo getOperation(){
        return operation;
    }

    public Process getProcess(){
        return process;
    }
    public void calculation() {
        if(operation == null || process == null) return;
        if (operation.getValue() > 1) {
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
