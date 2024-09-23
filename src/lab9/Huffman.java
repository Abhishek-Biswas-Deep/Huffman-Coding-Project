/**
 * This class builds the Huffman tree given as a list of symbols and probability pairs and also uses method to do
 * the encoding and decoding.
 * This class is the demo class that prints the expected output.
 * Name- Abhishek Biswas Deep
 * ID- B00864230
 */

package lab9;

import java.util.*;
import java.io.*;

public class Huffman {
    public static void main(String[] args) throws IOException {

        //Using the scanner.
        Scanner keyboard = new Scanner(System.in);

        //Output
        System.out.println("Huffman Coding");
        System.out.print("Enter the name of the file with letters and probability: ");

        //Prompting the user to enter the file name.
        //Reading the file.
        String filename = keyboard.nextLine();
        File inFile = new File(filename);
        Scanner input = new Scanner(inFile);

        //Creating an arraylist 'S' of type BinaryTree which is of pair.
        ArrayList<BinaryTree<Pair>> S = new ArrayList<BinaryTree<Pair>>();

        //This loop does the looping.
        //It also creates character and double that both together make up the pair.
        //This also enqueues in ascending order into S.
        while (input.hasNext()) {
            char line = input.next().charAt(0);
            double values = input.nextDouble();
            //Calling the pair.
            Pair pair = new Pair(line, values);
            //Using a binary tree of type pair
            //Then roots are made for the binary tree.
            //Then adding that to S.
            BinaryTree<Pair> pairs = new BinaryTree<Pair>();
            pairs.makeRoot(pair);
            S.add(pairs);
        }

        //closing the file
        input.close();

        //Output
        //Prompting the user to type in the letters.
        System.out.print("Enter a line of text (uppercase letters only): ");
        String line = keyboard.nextLine();

        //Creating another array list 'T' of type BinaryTree which is of pair.
        ArrayList<BinaryTree<Pair>> T = new ArrayList<BinaryTree<Pair>>();

        //The loop does the looping, and it stops until S is empty.
        while (!(S.isEmpty())) {

            //This is creating and initializing two binary trees 'A' and 'B'.
            //This is made to pick the smallest weight trees.
            BinaryTree<Pair> A = new BinaryTree<Pair>();
            BinaryTree<Pair> B = new BinaryTree<Pair>();

            //This checks if T is empty or not.
            //If T is empty, then A and B are set to the front and next to the front entries of S and then dequeued.
            if (T.isEmpty()) {
                A = S.remove(0);
                B = S.remove(0);

            //And then if T is not empty, then this one gets into action.
            } else {

                //Finding the smallest from the front of S and front of T.
                //Checking if the front of S is smaller than the front of T.
                if (S.get(0).getData().getProb() < T.get(0).getData().getProb()) {

                    //Dequeue A
                    A = S.remove(0);

                //And then again if the front of S is not smaller than the front of T, then this one activates.
                } else {

                    //Dequeue A
                    A = T.remove(0);

                }

                //This one checks if the size of the tree is greater than 1 or not.
                if (S.size() >= 1 && T.size() >= 1) {

                    //Finding the smallest by checking if the front of S is less than the front of T.
                    if (S.get(0).getData().getProb() < T.get(0).getData().getProb()) {

                        //Dequeue B
                        B = S.remove(0);

                    //This one activates if the first condition fails.
                    } else {

                        //Dequeue B
                        B = T.remove(0);

                    }

                //If the size is not greater than 1, then removal is done to alter the size to 1.
                } else {

                    //If the size of S is 0, then dequeue B
                    if (S.size() == 0) {
                        B = T.remove(0);

                    //If the size of T is 0, then dequeue B.
                    } else if (T.size() == 0) {
                        B = S.remove(0);
                    }

                }

            }

            //Constructing a new tree 'P'.
            BinaryTree<Pair> P = new BinaryTree<Pair>();

            //Then root is created for P.
            //A and B is then attached to P as the subtrees.
            P.makeRoot(new Pair('0', A.getData().getProb() + B.getData().getProb()));
            P.attachRight(A);
            P.attachLeft(B);

            //P is enqueued to queue T.
            T.add(0, P);

        }

        //This is looping through.
        //If the number of elements in T is greater than 1, then the two nodes are dequeued and then combination is done.
        while (T.size() > 1) {

            //Dequeue T
            BinaryTree<Pair> C = T.remove(0);
            BinaryTree<Pair> D = T.remove(0);

            //Creating a binary tree of 'R'.
            //Then the tree is enqueued to make the size of T to 1.
            BinaryTree<Pair> R = new BinaryTree<Pair>();

            //Making roots in R.
            //Then attaching the subtrees.
            //Then adding to make the size to 1.
            R.makeRoot(new Pair('0', C.getData().getProb() + D.getData().getProb()));
            R.attachLeft(C);
            R.attachRight(D);
            T.add(0, R);

        }

        //Encoding
        //Output- Printing to the console.
        System.out.print("Here's the encoded line: ");

        //Calling the encoding method to perform the encoding.
        String[] encoding = findEncoding(T.get(0));

        //Creating an array list of type String.
        //Then looping through the size of the letters entered by the user.
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < line.length(); i++) {

            //This makes a character.
            char c = line.charAt(i);

            //This checks the letters from A to Z.
            if (c >= 'A' && c <= 'Z') {

                //This makes sure that the encoding deducts the other values to get the exact number.
                int character = c - 'A';

                //This is adding the encodings in the arraylist.
                arrayList.add(encoding[character]);

                //Printing the encoded line.
                System.out.print(encoding[character]);

            //This activates if the first condition does not work.
            } else {

                //Creating arraylist of characters to store the input line.
                //And then prints it.
                arrayList.add(Character.toString(c));
                System.out.print(c);

            }

        }

        //Printing empty line.
        System.out.println();

        //Decoding
        //Output- Printing the expected output.
        System.out.print("Here's the decoded line: ");

        //This loop runs and loops through the size of the arraylist.
        for (int i = 0; i < arrayList.size(); i++) {

            //This is made to get the data.
            BinaryTree<Pair> cur = T.get(0);

            //This checks if the numbers are either 0 or 1.
            if (arrayList.get(i).charAt(0) == '0' || arrayList.get(i).charAt(0) == '1') {

                //This is another loop that loops at getting the arraylist at the previous for loop.
                for (int j = 0; j < arrayList.get(i).length(); j++) {

                    //This is getting the arraylist at i and j using character, so in other words, this gets the letters.
                    char c = arrayList.get(i).charAt(j);

                    //This checks if the character corresponds to 0 or not.
                    if (c == '0') {

                        //Then left element is taken.
                        cur = cur.getLeft();

                    //If the first one fails then this one is used.
                    } else {

                        //Then the right element is taken.
                        cur = cur.getRight();

                    }

                }

                //Printing the lines back to the console.
                System.out.print(cur.getData().getValue());

            //This one checks if the first one fails then the whole characters are printed.
            } else {

                //Printing the whole letters to the console.
                System.out.print(arrayList.get(i));

            }

        }

    }

    //Encoding
    private static String[] findEncoding(BinaryTree<Pair> bt) {
        String[] result = new String[26];
        findEncoding(bt, result, "");
        return result;
    }

    private static void findEncoding(BinaryTree<Pair> bt, String[] a, String prefix) {
        //test is node/tree is a leaf
        if (bt.getLeft() == null && bt.getRight() == null) {
            a[bt.getData().getValue() - 65] = prefix;
        }
        //recursive calls
        else {
            findEncoding(bt.getLeft(), a, prefix + "0");
            findEncoding(bt.getRight(), a, prefix + "1");
        }
    }

}
