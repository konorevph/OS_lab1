package ProcessorSimulator;

import java.util.LinkedList;

public class OperatingSystem {

    private int MAX_EMPLOYED_OUTPUTS;
    private int countOfProcesses;
    private int countOfDoneProcesses;
    private LinkedList<Process> readyProcesses;
    private LinkedList<Process> waitProcesses;
    private Processor processor;
    private Output[] outPuts;

    private int pointOfTime;

    public OperatingSystem(int countOfOutputs, int maxEmployedOutputs){


        MAX_EMPLOYED_OUTPUTS = maxEmployedOutputs;

        outPuts = new Output[countOfOutputs];
        int[] timesForOutputs = { 2, 3, 5};
        for(int i = 0; i < countOfOutputs; i ++){
            outPuts[i] = new Output(this, timesForOutputs[i],  "I/O" + (i));
        }

        processor = new Processor(this);
        readyProcesses = new LinkedList<>();
        waitProcesses = new LinkedList<>();

        pointOfTime = 0;
        countOfProcesses = 0;
        countOfDoneProcesses = 0;
    }

    public void createProcess(String str){
        readyProcesses.add(new Process(this, str, "P" + countOfProcesses++));
    }
    public void ProcessesCalculation() {
        while (countOfDoneProcesses < countOfProcesses){
            System.out.print(pointOfTime++ + ": ");

            if(!readyProcesses.isEmpty() && processor.isEmpty())
                processor.putProcess(readyProcesses.removeFirst());

            if(!processor.isEmpty())
                processor.calculation();

            System.out.print(processor);

            if(!waitProcesses.isEmpty()){
                System.out.println(waitProcesses.getFirst());
                waitProcesses.forEach( process -> {
                    int index = process.getCurrentOperation().getValue();

                    if(outPuts[index].isEmpty()) {
                        outPuts[index].putProcess(process);
                    }
                });
            }

            for(int i = 0; i < outPuts.length; i++){
                if(!outPuts[i].isEmpty()){
                    outPuts[i].ShowProcess();
                }
            }

            System.out.println();
        }
    }

    public void removeProcessFromWaitList(Process process){
        waitProcesses.remove(process);
    }

    public void boostCountOfDoneProcesses(){
        countOfDoneProcesses++;
    }

    public void putProcessIntoReadyList(Process process){
        readyProcesses.add(process);
    }

    public void putProcessIntoWaitList(Process process){
        waitProcesses.add(process);
    }

}
