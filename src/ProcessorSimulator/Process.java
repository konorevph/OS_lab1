package ProcessorSimulator;


import java.util.LinkedList;

public class Process{

    private OperatingSystem operatingSystem;
    private LinkedList<OperationInfo> operationsInfo;
    private OperationInfo currentOperation;
    private String name;


    public Process(OperatingSystem operatingSystem, String str, String name_process){
        this.operatingSystem = operatingSystem;
        name = name_process;

        operationsInfo = new LinkedList<OperationInfo>();

        for(String item : str.split(" ")){
            OperationInfo operationInfo;
            if(item.contains("(")){
                int device = Integer.parseInt(item.substring(item.indexOf('(') + 1, item.lastIndexOf(')')));
                operationInfo = new OperationInfo(1, device);
            }
            else {
                int time = Integer.parseInt(item);
                operationInfo = new OperationInfo(-1, time);
            }

            this.operationsInfo.add(operationInfo);
        }



    }

    public String getName(){
        return name;
    }

    public OperationInfo pollCurrentOperation(){
        return operationsInfo.removeFirst();
    }

    public boolean isEmpty(){
        return operationsInfo.isEmpty();
    }

    public OperationInfo getCurrentOperation(){
        return operationsInfo.getFirst();
    }

    public String toString(){
        return name;
    }

}
