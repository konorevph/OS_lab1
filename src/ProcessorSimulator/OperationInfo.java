package ProcessorSimulator;

class OperationInfo {

    private int type;
    private int value;

    public OperationInfo(int type, int value){
        this.type = type;
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value) { this.value = value; }

    public boolean isOut(){
        return type == 1;
    }

    public boolean isProcessor(){
        return type == 0;
    }

    public void print(){
        if(type == -1){
            System.out.print("Занимаем процесс на " + value + " ");
        }
        else {
            System.out.print("Вывод на I/O" + value);
        }
    }

}
