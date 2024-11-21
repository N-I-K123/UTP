package zad1;

public class StringTask implements Runnable{

    private String str;
    private int num;
    private String result;
    private Thread thread;
    private volatile boolean running;
    private volatile boolean end;
    private volatile TaskState state;
    public StringTask(String str, int num) {
        this.str = str;
        this.num = num;
        this.result = "";
        this.state = TaskState.CREATED;
        this.end = false;
    }
    public String getResult(){
        return result;
    }
    public TaskState getState(){
        return state;
    }
    public void start(){
        if (thread == null || !thread.isAlive()) {
            running = true;
            state = TaskState.RUNNING;
            thread = new Thread(this);
            thread.start();
        }
    }
    public void abort(){
        running = false;
        if (thread!=null){
            state = TaskState.ABORTED;
            thread.interrupt();
            end = true;
        }
    }
    @Override
    public void run() {
        for (int i = 0; i < num && running; i++) {
            this.result += str;
        }
        end = true;
        if (running){
            state = TaskState.READY;
        }else {
            state = TaskState.ABORTED;
        }
    }
    public boolean isDone(){
        return end;
    }
}
