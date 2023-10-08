package ProcessorSimulator;

import java.util.LinkedList;

public class OperatingSystem {


    private int countOfProcesses;
    private int countOfDoneProcesses;
    private LinkedList<Process> readyProcesses;
    private LinkedList<Process> waitProcesses;
    private Processor[] processors;
    private Output[] outPuts;

    private int pointOfTime;

    public OperatingSystem(int countOfOutputs, int CountOfProcessors){



        outPuts = new Output[countOfOutputs];
        int[] timesForOutputs = { 2, 3, 5};
        for(int i = 0; i < countOfOutputs; i ++){
            outPuts[i] = new Output(this, timesForOutputs[i],  "I/O" + (i + 1));
        }

        processors = new Processor[CountOfProcessors];
        for(int i = 0; i < processors.length; i++){
            processors[i] = new Processor(this);
        }
        readyProcesses = new LinkedList<>();
        waitProcesses = new LinkedList<>();

        pointOfTime = 0;
        countOfProcesses = 0;
        countOfDoneProcesses = 0;
    }

    public void createProcess(String str){
        readyProcesses.add(new Process(this, str, "P" + (++countOfProcesses)));
    }
    public void ProcessesCalculation() {
        int count1 = 0, count2 = 0;
        while (countOfDoneProcesses < countOfProcesses){
            System.out.print(pointOfTime++ + ": ");

            for (Output outPut : outPuts) {
                if(outPut != null && outPut.getProcessName().contains("P6")){
                    count2 += 1;
                }
                outPut.ShowProcess();
            }

            for(Processor processor : processors){
                processor.calculation();

                if(!readyProcesses.isEmpty() && processor.isEmpty())
                    processor.putProcess(readyProcesses.removeFirst());

                System.out.print(processor);
            }


            for(int i = 0; i < waitProcesses.size();){
                int index = waitProcesses.get(i).getCurrentOperation().getValue() - 1;

                if(outPuts[index].isEmpty()) {
                    outPuts[index].putProcess(waitProcesses.get(i));
                }
                else {
                    System.out.print(" Приостановка ожидания для " + waitProcesses.get(i).toString() + " ");
                    i++;
                }
            }

            for (Output output : outPuts){
                System.out.print(output);
            }

            System.out.print(" W[");
            for (Process process : waitProcesses){
                if (process.getName().contains("P6")){
                    count2 += 1;
                }
                System.out.print(process + ",");
            }
            System.out.print("]");
            System.out.print(" R[");
            for (Process process : readyProcesses) {
                if (process.getName().contains("P6")){
                    count1 += 1;
                }
                System.out.print(process + ",");
            }
            System.out.print("]");
            System.out.println();
        }
        System.out.print(count1);
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
