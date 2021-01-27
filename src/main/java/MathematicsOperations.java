public class MathematicsOperations {

    public Long factorial(int number){
        long factorial = 1;

        for (int i = 2; i <= number; i++){
            factorial *= i;
        }

        return factorial;
    }
}
