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
        if(type == 0){
            System.out.println("Процессор: " + value);
        }
        else {
            System.out.println("Вывод на I/O" + value);
        }
    }

}
