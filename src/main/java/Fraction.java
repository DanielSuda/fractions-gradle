public class Fraction implements IFraction {

    private final Integer numerator;
    private final Integer denominator;

    public Fraction(Integer numerator, Integer denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

        if (denominator == 0) throw new ArithmeticException("Cannot Divide by 0");
    }

    private Fraction reduceFraction(int numerator, int denominator) {
        int d;
        d = greatestCommonDivisor(numerator, denominator);

        numerator = numerator / d;
        denominator = denominator / d;
        return new Fraction(numerator, denominator);
    }

    private int greatestCommonDivisor(int a, int b) {
        if (b == 0)
            return a;
        return greatestCommonDivisor(b, a % b);
    }

    @Override
    public @NotNull
    Integer getNumerator() {
        return numerator;
    }

    @Override
    public @NotNull
    Integer getDenominator() {
        return denominator;
    }

    @Override
    public @NotNull
    IFraction plus(@NotNull IFraction other) {
        return reduceFraction((numerator * other.getDenominator()) + (denominator * other.getNumerator()), denominator * other.getDenominator());
    }

    @Override
    public @NotNull
    IFraction minus(@NotNull IFraction other) {
        return reduceFraction((numerator * other.getDenominator()) - (denominator * other.getNumerator()), denominator * other.getDenominator());
    }

    @Override
    public @NotNull
    IFraction times(@NotNull IFraction other) {
        return reduceFraction(this.numerator * other.getNumerator(), this.denominator * other.getDenominator());
    }

    @Override
    public @NotNull
    IFraction dividedBy(@NotNull IFraction other) {
        return reduceFraction(this.numerator * other.getDenominator(), this.denominator * other.getNumerator());
    }
    @Override
    public String toString() {
        return "Fraction " + numerator + "|" + denominator;
    }
}
