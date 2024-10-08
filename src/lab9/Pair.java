/**
 * This class keeps track of letters and their relative probabilities to build Huffman tree.
 * Name- Abhishek Biswas Deep
 * ID- B00864230
 */

package lab9;

public class Pair implements Comparable<Pair>{
    //declare all required fields
    private char value;
    private double prob;

    //constructor
    public Pair(char value, double prob) {
        this.value = value;
        this.prob = prob;
    }

    //getters
    public char getValue() {
        return value;
    }

    public double getProb() {
        return prob;
    }

    //setters
    public void setValue(char value) {
        this.value = value;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    //toString
    @Override
    public String toString() {
        return "Pair{" +
                "value=" + value +
                ", prob=" + prob +
                '}';
    }

    /**
     * The compareTo method overrides the compareTo method of the Comparable interface.
     */
    @Override
    public int compareTo(Pair p) {
        return Double.compare(this.getProb(), p.getProb());
    }

}
