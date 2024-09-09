package Java;

public class TasksLauncher {

    public void start() {
        task8QueensLaunch();
    }

    private void task8QueensLaunch(){
        Task8Queens task = new Task8Queens();
        task.prepareTable();
        task.searchSolution();
//        task.showTable();
    }

}
