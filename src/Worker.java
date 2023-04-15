public class Worker {
    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String s);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String s);
    }


    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 32) {
                errorCallback.onError("Task " + i + " is not done");
            } else {
                callback.onDone("Task " + i + " is done");
            }
        }
    }


}







