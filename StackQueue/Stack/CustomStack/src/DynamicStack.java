public class DynamicStack extends CustomStack {
    public DynamicStack() {
        super();//call CustomStack()
    }

    public DynamicStack(int size) {
        super(size);//call CustomStack(int size)
    }

    public boolean push(int item) {
        if (this.isFull()) {
            int[] arr = new int[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                arr[i] = data[i];
            }

            data = arr;
        }
        return super.push(item);
    }
}
