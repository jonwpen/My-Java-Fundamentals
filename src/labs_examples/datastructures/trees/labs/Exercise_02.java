package labs_examples.datastructures.trees.labs;

/*
    Trees: Exercise_02

    For this challenge, please research and implement a custom Trie data structure (https://en.wikipedia.org/wiki/Trie).

    Trie's are very interesting and useful data structures. Many interview questions, and real-world scenario's
    can be properly addressed using a Trie. We use Tries to store things like words and numbers in a highly
    efficient manner. See here: http://theoryofprogramming.com/wp-content/uploads/2015/06/trie12.jpg

    Understanding and implement a Trie is a fantastic step in thinking creatively as a developer to
    accomplish goals as efficiently as possible.

    Here is a fantastic set of relevant interview questions: https://www.techiedelight.com/trie-interview-questions/

 */

/*
Summary - The user will add words to the Trie, then every word is split into an array and each character is a new node.
When two words have the same prefix, those nodes will not be duplicated, but rather the Trie will fork at the point
where the words differ. Methods can be either recursive or iterative depending on the anticipated size of the data set.
It is commonly used for interview problems related to word validation.
A nice Trie visualizer: https://www.cs.usfca.edu/~galles/visualization/Trie.html
https://www.geeksforgeeks.org/trie-insert-and-search/
HackerRank: https://www.youtube.com/watch?v=zIjfhVPRZCg
*/

public class Exercise_02{
	public static void main(String[] args) {
		
		Trie trie = new Trie();
		trie.addWord("play");
		trie.addWord("playstation");
		trie.addWord("paper");
		trie.addWord("platypus");
		trie.addWord("player");
		trie.addWord("plate");
		trie.addWord("place");
		trie.addWord("apple");
		
		System.out.println(trie.startsWithPrefix("pla"));
		System.out.println(trie.searchWord("player"));
	}
}

class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    // Traverse through each character of the word
    // Create necessary nodes if they don't exist
    // Mark the last node as the end of the word
    public void addWord(String word) {
        TrieNode node = root; // Start at the root of the Trie
        for (char ch : word.toCharArray()) {
        	//Calculate the index. 'a' has an ascii value of 97. It is the base value to subtract from each char of a given word.
            int i = ch - 'a';
         // If the child node at index 'i' doesn't exist, create a new TrieNode
            if (node.children[i] == null) {
                node.children[i] = new TrieNode();
            }
            node = node.children[i]; // Move to the child node at index 'i'
        }
        node.isEndOfWord = true; // Mark the last node as the end of a word
    }
    // Traverse through each character of the word
    // Return true if the word exists in the Trie and is marked as the end of a word
    // Return false otherwise
    public boolean searchWord(String word) {
        TrieNode node = getNode(word);
        return node != null && node.isEndOfWord;
    }
    // Traverse through each character of the prefix
    // Return true if there is a matching path in the Trie
    // Return false otherwise
    public boolean startsWithPrefix(String prefix) {
        TrieNode node = getNode(prefix);
        return node != null;
    }
    // Retrieve the last node in the Trie based on the given word
    // Traverse through each character of the word
    // Return the node if the path exists in the Trie
    // Return null otherwise
    private TrieNode getNode(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
    	//use a size of 26 if you are working with lowercase English letters
    	//This allows you to find a character based on ascii value from 97 to 122
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}
