<img src="https://github.com/user-attachments/assets/2ad86f70-12b4-4500-997d-9f8c1874a9b5" alt="Dal logo" width="80"/>
<h1>Associated with Dalhousie University</h1>

### CSCI2110

### Huffman Coding Project
This project implements Huffman coding, a data compression algorithm, in Java. It includes a binary tree implementation, a Huffman encoding and decoding system, and supporting classes.

#### Project Structure
The project consists of the following Java files:

1. BinaryTree.java: Implements a generic binary tree data structure.
2. Huffman.java: Contains the main logic for Huffman coding, including encoding and decoding.
3. Pair.java: A utility class to store character-probability pairs.

Additionally, there's a text file:

- LettersProbability.txt: Contains the probabilities of English letters used for Huffman coding.

#### Features
- Binary Tree Implementation
- Huffman Tree Construction
- Encoding of uppercase letters
- Decoding of Huffman-encoded text
- File input for letter probabilities

#### How to Use
1. Compile all Java files in the lab9 package.
2. Run the Huffman class.
3. When prompted, enter the name of the file containing letter probabilities.
4. Enter a line of text (uppercase letters only) to be encoded.
5. The program will display the encoded line and then the decoded line.

#### Implementation Details
- BinaryTree.java: A generic binary tree implementation with methods for tree manipulation and traversal.
- Huffman.java: The main class that builds the Huffman tree, encodes input text, and decodes Huffman-encoded text.
- Pair.java: A class that keeps track of letters and their relative probabilities, used in building the Huffman tree.

#### Sample input and output
```
Huffman Coding
Enter the name of the file with letters and probability: src/lab9/LettersProbability.txt
Enter a line of text (uppercase letters only): THIS IS COOL
Here's the encoded line: 00000000001000000100000000010000000010 0000000010000000010 00001000000000011000000000110000010
Here's the decoded line: THIS IS COOL
Process finished with exit code 0

Huffman Coding
Enter the name of the file with letters and probability: src/lab9/LettersProbability.txt
Enter a line of text (uppercase letters only): THIS CLASS IS AWESOME
Here's the encoded line: 00000000001000000100000000010000000010 000010000001000000000010000000010000000010 0000000010000000010 000000000100010000000000000000000100000000001100001100000000000
Here's the decoded line: THIS CLASS IS AWESOME
Process finished with exit code 0

Huffman Coding
Enter the name of the file with letters and probability: src/lab9/LettersProbability.txt
Enter a line of text (uppercase letters only): WITH GREAT POWER COMES GREAT RESPONSIBILITY
Here's the encoded line: 001000000000100000000000100000010 0011000000011000000000000000000001000000000001 01000000000011001000000000000000000011 0000100000000001100001100000000000000000010 0011000000011000000000000000000001000000000001 0000000110000000000000000001001000000000011000000001100000001000000000100110000000010000001000000000100000000000100011
Here's the decoded line: WITH GREAT POWER COMES GREAT RESPONSIBILITY
Process finished with exit code 0

Huffman Coding
Enter the name of the file with letters and probability: src/lab9/LettersProbability.txt
Enter a line of text (uppercase letters only): THIS IS MY ASSIGNMENT
Here's the encoded line: 00000000001000000100000000010000000010 0000000010000000010 00001100011 0000000001000000001000000001000000000100011000000001100001100000000000000000001100000000001
Here's the decoded line: THIS IS MY ASSIGNMENT
Process finished with exit code 0
```
