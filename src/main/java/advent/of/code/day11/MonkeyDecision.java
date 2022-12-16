package advent.of.code.day11;

public class MonkeyDecision {
    private final int divisible;
    private final int throwToMonkeyTrue;
    private final int throwToMonkeyFalse;

    public MonkeyDecision(int divisible, int throwToMonkeyTrue, int throwToMonkeyFalse) {
        this.divisible = divisible;
        this.throwToMonkeyTrue = throwToMonkeyTrue;
        this.throwToMonkeyFalse = throwToMonkeyFalse;
    }

    public int calculateNextMonkey(int worryLevel){
        if (worryLevel % divisible == 0){
            System.out.println("Current worry level is divisible by " + divisible);
            System.out.println("Item with worry level " + worryLevel + " is thrown to monkey " + throwToMonkeyTrue);
            return throwToMonkeyTrue;
        }
        System.out.println("Current worry level is not divisible by " + divisible);
        System.out.println("Item with worry level " + worryLevel + " is thrown to monkey " + throwToMonkeyFalse);
        return throwToMonkeyFalse;
    }
}
