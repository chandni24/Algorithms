import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

{
  {'A','B','C','E'},
  {'S','F','C','S'},
  {'A','D','E','E'}
}
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 *
 *@author Chandni
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		//System.out.println("b "+board.length+"\t"+board[0].length);
		if(word.length() == 0)
			return true;
		boolean[][] a = new boolean[board.length][board[0].length];
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(charExists(board, word, i, j, a))
					return true;
			}
		}
		return false;
	}

	public boolean charExists(char[][] board, String word, int i, int j, boolean[][] a) {
		//System.out.println("2\t"+word+"\t"+i+"\t"+j);System.out.println("se "+a[1][2]+" es");
		if(word.length() == 0)
			return true;
		
		if(i<0 || j<0 || i>=board.length || j>=board[0].length)
			return false;
		
		if(board[i][j] == word.charAt(0)) {
			char temp = board[i][j];
			board[i][j] = '#';
			if(charExists(board, word.substring(1), i-1, j, a) //up
			|| charExists(board, word.substring(1), i+1, j, a) //bottom
			|| charExists(board, word.substring(1), i, j-1, a) //left
			|| charExists(board, word.substring(1), i, j+1, a)) //right
				return true;
			board[i][j] = temp;
		}
		return false;
	}
	
    public List<String> findWords(char[][] board, String[] words) {
    	List<String> list = new LinkedList<String>();
    	char[][] board_copy = new char[board.length][board[0].length];
    	for (int j = 0; j < board.length; j++) {
    		for (int k = 0; k < board[0].length; k++) {
    			board_copy[j][k] = board[j][k];
    		}
        }
    	for(int i=0; i<words.length; i++){
    		if(exist(board, words[i]))
    			list.add(words[i]);
    		for (int j = 0; j < board.length; j++) {
        		for (int k = 0; k < board[0].length; k++) {
        		board[j][k] = board_copy[j][k];
        		}
            }
    	}
    	System.out.println(list.size());
    	for(int i=0; i<list.size(); i++){
    		System.out.println(list.get(i));
    	}
    	return list;
    }
    
	public static void main(String[] args) {

//		char[][] board = {
//				{'A','B','C','E'},
//				{'S','F','C','S'},
//				{'A','D','E','E'}
//		};
		char[][] board = {{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}		                 
		};
		//String word = "";
		String word = "eat";
		//String word = "SEE";
		//String word = "ABCB";
		String[] words = {"eat","oath","pea","rain"};
		new WordSearch().findWords(board, words);
		//System.out.println(new WordSearch().exist(board, word));
	}
}
