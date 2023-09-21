package Tree;

public class Bai1 {
    public int factorialOfN(int n){
        if(n==0) return 1;
        return n*factorialOfN(n-1);
    }
}
